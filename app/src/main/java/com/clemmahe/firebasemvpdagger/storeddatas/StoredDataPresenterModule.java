package com.clemmahe.firebasemvpdagger.storeddatas;

import dagger.Module;
import dagger.Provides;

/**
 * StoredDataPresenterModule
 * Created by clem on 04/12/2016.
 */
@Module
public class StoredDataPresenterModule {

    private final StoredDataContract.View mView;


    public StoredDataPresenterModule(StoredDataContract.View view) {
        mView = view;
    }

    @Provides
    StoredDataContract.View provideAuthentContractView() {
        return mView;
    }

}