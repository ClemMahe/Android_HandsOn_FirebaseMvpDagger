package com.clemmahe.firebasemvpdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.clemmahe.firebasemvpdagger.firebase.DaggerFirebaseComponent;
import com.clemmahe.firebasemvpdagger.firebase.FirebaseComponent;
import com.clemmahe.firebasemvpdagger.firebase.FirebaseModule;

/**
 * BaseActivity
 * Created by clem on 05/12/2016.
 */
public abstract class BaseActivity extends AppCompatActivity{

    protected FirebaseComponent mFirebaseComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Firebase component
        mFirebaseComponent = DaggerFirebaseComponent.builder()
                .applicationModule(new ApplicationModule((getApplicationContext())))
                .firebaseModule(new FirebaseModule())
                .build();
    }


    /**
     * Get Firebase component
     * @return FirebaseComponent
     */
    public FirebaseComponent getFirebaseComponent() {
        return mFirebaseComponent;
    }

}
