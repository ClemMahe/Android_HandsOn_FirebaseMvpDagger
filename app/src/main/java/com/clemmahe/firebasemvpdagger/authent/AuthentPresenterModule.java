package com.clemmahe.firebasemvpdagger.authent;

import dagger.Module;
import dagger.Provides;

/**
 * AuthentPresenterModule
 * Created by clem on 04/12/2016.
 */
@Module
public class AuthentPresenterModule {

    private final AuthentContract.View mView;


    public AuthentPresenterModule(AuthentContract.View view) {
        mView = view;
    }

    @Provides
    AuthentContract.View provideAuthentContractView() {
        return mView;
    }

}