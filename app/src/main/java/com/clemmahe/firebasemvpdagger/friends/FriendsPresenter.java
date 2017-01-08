package com.clemmahe.firebasemvpdagger.friends;

import com.clemmahe.firebasemvpdagger.firebase.FirebaseManager;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

/**
 * FriendsPresenter
 * Created by clem on 04/12/2016.
 */

public final class FriendsPresenter implements FriendsContract.Presenter, IFirebaseFriendsListener{


    private FriendsContract.View mView;
    private FirebaseManager mManager;

    @Inject
    FriendsPresenter(FirebaseManager manager, FriendsContract.View view) {
        this.mManager = manager;
        this.mManager.setFriendsListener(this);
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
    public void start() {
        //mManager...
    }

    @Override
    public void stop() {
        //mManager...
    }


    @Override
    public void startInvite() {
    }

    @Override
    public void onInvitationSuccess(FirebaseUser mFirebaseUser) {

    }

    @Override
    public void invitationCancelled() {

    }
}