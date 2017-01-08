package com.clemmahe.firebasemvpdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.clemmahe.firebasemvpdagger.firebase.FirebaseComponent;

/**
 * BaseActivity
 * Created by clem on 05/12/2016.
 */
public abstract class BaseActivity extends AppCompatActivity{



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    /**
     * Get Firebase component
     * @return FirebaseComponent
     */
    public FirebaseComponent getFirebaseComponent() {
        return ((MvpApp)getApplication()).getFirebaseComponent();
    }

}
