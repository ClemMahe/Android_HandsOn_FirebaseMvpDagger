package com.clemmahe.firebasemvpdagger.friends;

import dagger.Module;
import dagger.Provides;

/**
 * FriendsPresenterModule
 * Created by clem on 04/12/2016.
 */
@Module
public class FriendsPresenterModule {

    private final FriendsContract.View mView;


    public FriendsPresenterModule(FriendsContract.View view) {
        mView = view;
    }

    @Provides
    FriendsContract.View provideAuthentContractView() {
        return mView;
    }

}