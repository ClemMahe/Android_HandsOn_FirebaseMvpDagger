package com.clemmahe.firebasemvpdagger.authent;

import javax.inject.Inject;

/**
 * AuthentPresenter
 * Created by clem on 04/12/2016.
 */

public final class AuthentPresenter implements AuthentContract.Presenter {

    /*
    private AuthentContract.View mView;
    private FirebaseManager mManager;
    @Inject
    AuthentPresenter(FirebaseManager manager,
                        AuthentContract.View view) {
        mManager = manager;
        mView = view;
    }
    */

    private AuthentContract.View mView;
    @Inject
    AuthentPresenter(AuthentContract.View view) {
        mView = view;
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
    public void login() {

    }

    @Override
    public void start() {

    }
}