package com.clemmahe.firebasemvpdagger.authent;

import com.clemmahe.firebasemvpdagger.firebase.FirebaseManager;
import com.clemmahe.firebasemvpdagger.firebase.IFirebaseAuthenticationListener;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

/**
 * StoredDataPresenter
 * Created by clem on 04/12/2016.
 */

public final class AuthentPresenter implements AuthentContract.Presenter, IFirebaseAuthenticationListener{


    private AuthentContract.View mView;
    private FirebaseManager mManager;

    private IFirebaseAuthenticationListener listener;

    @Inject
    AuthentPresenter(FirebaseManager manager, AuthentContract.View view) {
        this.mManager = manager;
        this.mManager.setAuthListener(this);
        this.mView = view;
    }

    /**
     * Method injection is used here to safely reference {@code this} after the object is created.
     * For more information, see Java Concurrency in Practice.
     */
    @Inject
    void setupListeners() {
        mView.setPresenter(this);
    }

    @Override
    public void startSignIn() {
        mView.viewSignIn(mManager.getApiClient());
    }

    @Override
    public void signInOk(final GoogleSignInAccount account) {
        //Call firebase auth
        mManager.firebaseAuthWithGoogle(account);
    }

    @Override
    public void siginInFailed() {
        mView.viewSignedInFailed();
    }


    @Override
    public void start() {
        mManager.startAuth();
    }

    @Override
    public void stop() {
        mManager.stopAuth();
    }


    @Override
    public void onConnected(FirebaseUser mFirebaseUser) {
        mView.showConnectedStatus(true);
    }

    @Override
    public void failConnected() {
        mView.showConnectedStatus(false);
    }
}