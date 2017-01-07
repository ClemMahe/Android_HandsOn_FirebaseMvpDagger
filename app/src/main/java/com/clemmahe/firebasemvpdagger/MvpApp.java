package com.clemmahe.firebasemvpdagger;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;


/**
 * MvpApp
 * Created by clem on 05/12/2016.
 */

public class MvpApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
    }

}