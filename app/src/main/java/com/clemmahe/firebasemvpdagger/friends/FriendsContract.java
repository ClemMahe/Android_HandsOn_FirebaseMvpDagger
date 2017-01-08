package com.clemmahe.firebasemvpdagger.friends;

import com.clemmahe.firebasemvpdagger.BasePresenter;
import com.clemmahe.firebasemvpdagger.BaseView;

/**
 * FriendsContract
 * Created by clem on 04/12/2016.
 */

public interface FriendsContract {

    /**
     * Authent View
     */
    interface View extends BaseView<Presenter> {

        void inviteCompleted();

        void inviteCancelled();
    }

    /**
     * Authent Presenter
     */
    interface Presenter extends BasePresenter {

        void startInvite();

    }
}