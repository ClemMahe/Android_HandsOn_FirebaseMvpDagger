package com.clemmahe.firebasemvpdagger.storeddatas;

import com.clemmahe.firebasemvpdagger.firebase.FirebaseManager;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Inject;

/**
 * StoredDataPresenter
 * Created by clem on 04/12/2016.
 */

public final class StoredDataPresenter implements StoredDataContract.Presenter {

    public static final String VALUE_EMAIL = "email";
    public static final String VALUE_TIME = "position_time";
    public static final String VALUE_LATITUDE = "position_latitude";
    public static final String VALUE_LONGITUDE = "position_longitude";


    private StoredDataContract.View mView;
    private FirebaseManager mManager;

    @Inject
    StoredDataPresenter(FirebaseManager manager, StoredDataContract.View view) {
        this.mManager = manager;
        this.mView = view;
    }

    /**
     * Method injection is used here to safely reference {@code this} after the object is created.
     * For more information, see Java Concurrency in Practice.
     */
    @Inject
    void setupListeners() {
        mView.setPresenter(this);
    }



    @Override
    public void start() {
        //mManager...
    }

    @Override
    public void stop() {
        //mManager...
    }


    @Override
    public void addPosition(long time, long latitude, long longitude) {
        // Write a message to the database
        FirebaseUser user = mManager.getCurrentUser();
        if(user!=null) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference dataReference = database.getReference("users/"+user.getUid());
            dataReference.child(VALUE_EMAIL).setValue(user.getEmail());
            dataReference.child(VALUE_TIME).setValue(time);
            dataReference.child(VALUE_LATITUDE).setValue(latitude);
            dataReference.child(VALUE_LONGITUDE).setValue(longitude);
            //Callback
            mView.positionAdded(latitude, longitude);
        }else{
            mView.positionNotAdded();
        }

    }
}