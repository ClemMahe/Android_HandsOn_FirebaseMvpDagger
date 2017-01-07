package com.clemmahe.firebasemvpdagger.firebase;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by clem on 07/01/2017.
 */

public interface IFirebaseAuthenticationListener {

    public void onConnected(FirebaseUser mFirebaseUser);

    public void failConnected();

}
