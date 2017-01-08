package com.clemmahe.firebasemvpdagger.authent;

import com.clemmahe.firebasemvpdagger.BasePresenter;
import com.clemmahe.firebasemvpdagger.BaseView;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * FriendsContract
 * Created by clem on 04/12/2016.
 */

public interface AuthentContract {

    /**
     * Authent View
     */
    interface View extends BaseView<Presenter> {

        void showConnectedStatus(boolean isConnected);

        void viewSignIn(final GoogleApiClient apiClient);

        void viewSignedInFailed();
    }

    /**
     * Authent Presenter
     */
    interface Presenter extends BasePresenter {

        void startSignIn();

        void signInOk(GoogleSignInAccount account);

        void siginInFailed();
    }
}