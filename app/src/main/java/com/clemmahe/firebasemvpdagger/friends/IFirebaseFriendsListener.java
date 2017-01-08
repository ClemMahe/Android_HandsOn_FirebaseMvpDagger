package com.clemmahe.firebasemvpdagger.friends;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by clem on 07/01/2017.
 */

public interface IFirebaseFriendsListener {

    public void onInvitationSuccess(FirebaseUser mFirebaseUser);

    public void invitationCancelled();

}
