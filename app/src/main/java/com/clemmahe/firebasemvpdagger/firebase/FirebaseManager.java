package com.clemmahe.firebasemvpdagger.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.clemmahe.firebasemvpdagger.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * FirebaseManager
 * Created by clem on 05/12/2016.
 */

@Singleton
public class FirebaseManager implements GoogleApiClient.OnConnectionFailedListener,
        OnCompleteListener<AuthResult>{

    public static final int REQUEST_CODE_SIGN_IN = 101;

    private Context mCtx;

    //Google api client & sign in options
    private GoogleApiClient mGoogleApiClient;
    private GoogleSignInOptions gso;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private FirebaseUser mFirebaseUser;
    private boolean startAsLoggedIn;

    private IFirebaseAuthenticationListener listener;

    @Inject
    FirebaseManager(Context ctx) {
        this.mCtx = ctx;
        initApiClientSignInOptions();
    }

    /**
     * Set Listener
     * @param listener IFirebaseAuthenticationListener
     */
    public void setListener(IFirebaseAuthenticationListener listener){
        this.listener = listener;
    }

    /**
     * Init api client sign in options
     */
    private void initApiClientSignInOptions() {
        //Firebase
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                mFirebaseUser = firebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    // User is signed in
                    listener.onConnected(mFirebaseUser);
                }
            }
        };
        // Configure Google Sign In
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(mCtx.getString(R.string.webserver_id_oauth))
                .requestEmail()
                .requestProfile()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(mCtx)
                .addOnConnectionFailedListener(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }


    /**
     * firebaseAuthWithGoogle
     * Calls when Intent result of Request sign in result with success
     * @param acct GoogleSignInAccount
     */
    public void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d("TAG", "firebaseAuthWithGoogle:" + acct.getId());
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential).addOnCompleteListener(this);
    }



    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        //Connection failed
        listener.failConnected();
    }


    /**
     * Get API Client
     * @return GoogleApiClient
     */
    public GoogleApiClient getApiClient(){
        return mGoogleApiClient;
    }

    /**
     * Start manager
     */
    public void startManager() {
        mAuth.addAuthStateListener(mAuthListener);
    }

    /**
     * Stop manager
     */
    public void stopManager() {
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(!task.isSuccessful()){
            //Connect not successful
            if(listener!=null) listener.failConnected();
        }
    }


}
