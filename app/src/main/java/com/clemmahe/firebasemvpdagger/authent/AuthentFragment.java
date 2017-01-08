package com.clemmahe.firebasemvpdagger.authent;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.clemmahe.firebasemvpdagger.BaseFragment;
import com.clemmahe.firebasemvpdagger.R;
import com.clemmahe.firebasemvpdagger.firebase.FirebaseManager;
import com.clemmahe.firebasemvpdagger.friends.FriendsActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by clem on 07/12/2016.
 */

public class AuthentFragment extends BaseFragment implements AuthentContract.View {


    @BindView(R.id.authent_googlesigninbutton)
    SignInButton authentGooglesigninbutton;
    @BindView(R.id.authent_friends)
    Button authentFriends;
    @BindView(R.id.authent_storedata)
    Button authentStoredata;

    private AuthentContract.Presenter mPresenter;

    private Snackbar statusSnackBar;
    private Handler uiThread;

    public static AuthentFragment newInstance() {
        return new AuthentFragment();
    }

    public AuthentFragment() {
        uiThread = new Handler(Looper.getMainLooper());
    }

    @Override
    public void setPresenter(@NonNull AuthentContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }


    @Override
    public void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.stop();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.authent_fragment, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void showConnectedStatus(boolean isConnected) {
        if (isConnected) {
            uiThread.post(new Runnable() {
                @Override
                public void run() {
                    statusSnackBar = Snackbar.make(getView(),
                            R.string.authen_state_connected,
                            Snackbar.LENGTH_INDEFINITE);
                    statusSnackBar.show();
                    authentFriends.setEnabled(true);
                    authentStoredata.setEnabled(true);
                }
            });
        }

    }

    @Override
    public void viewSignIn(final GoogleApiClient apiClient) {
        //called when on click is triggered
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(apiClient);
        startActivityForResult(signInIntent, FirebaseManager.REQUEST_CODE_SIGN_IN);
    }

    @Override
    public void viewSignedInFailed() {
        mPresenter.siginInFailed();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FirebaseManager.REQUEST_CODE_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                mPresenter.signInOk(account);
            } else {
                // Google Sign In failed, update UI appropriately
                mPresenter.siginInFailed();
            }
        }
    }

    @OnClick({R.id.authent_googlesigninbutton, R.id.authent_friends, R.id.authent_storedata})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.authent_googlesigninbutton:
                mPresenter.startSignIn();
                break;
            case R.id.authent_friends:
                Intent friendsIt = new Intent(getContext(),
                        FriendsActivity.class);
                startActivity(friendsIt);
                break;
            case R.id.authent_storedata:
                break;
        }
    }
}
