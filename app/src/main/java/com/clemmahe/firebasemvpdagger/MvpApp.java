package com.clemmahe.firebasemvpdagger;

import android.app.Application;
import android.util.Log;

import com.clemmahe.firebasemvpdagger.firebase.DaggerFirebaseComponent;
import com.clemmahe.firebasemvpdagger.firebase.FirebaseComponent;
import com.clemmahe.firebasemvpdagger.firebase.FirebaseModule;


/**
 * MvpApp
 * Created by clem on 05/12/2016.
 */

public class MvpApp extends Application {

    protected FirebaseComponent mFirebaseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //Firebase component
        mFirebaseComponent = DaggerFirebaseComponent.builder()
                .applicationModule(new ApplicationModule((getApplicationContext())))
                .firebaseModule(new FirebaseModule())
                .build();

        Log.d("TAG","Instance mFirebase: "+mFirebaseComponent);
    }

    /**
     * Get Firebase component
     * @return FirebaseComponent
     */
    public FirebaseComponent getFirebaseComponent() {
        return mFirebaseComponent;
    }

}