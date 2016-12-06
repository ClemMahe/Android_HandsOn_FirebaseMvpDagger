package com.clemmahe.firebasemvpdagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * ApplicationModule
 * Created by clem on 05/12/2016.
 */

@Module
public final class ApplicationModule {

    private final Context mContext;

    ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}