package com.clemmahe.firebasemvpdagger.firebase;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * FirebaseManager
 * Created by clem on 05/12/2016.
 */

@Singleton
public class FirebaseManager {

    private Context mContext;


    @Inject
    FirebaseManager(Context context) {
        mContext = context;
    }

    /**
     * authenticationUser
     * @return boolean
     */
    public boolean authenticationUser(){
        Toast.makeText(mContext,"authenticationUser called",Toast.LENGTH_SHORT).show();
        return true;
    }


}
