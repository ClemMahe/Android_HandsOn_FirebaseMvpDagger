package com.clemmahe.firebasemvpdagger.friends;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.clemmahe.firebasemvpdagger.BaseActivity;
import com.clemmahe.firebasemvpdagger.R;
import com.clemmahe.firebasemvpdagger.utils.ActivityUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendsActivity extends BaseActivity{
    
    @Inject
    FriendsPresenter mAuthentPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.invitefriends_activity);
        ButterKnife.bind(this);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FriendsFragment friendsFragment = (FriendsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.friendsContentFrame);
        if (friendsFragment == null) {
            friendsFragment = FriendsFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    friendsFragment, R.id.friendsContentFrame);
        }

        DaggerFriendsComponent.builder()
                .friendsPresenterModule(new FriendsPresenterModule(friendsFragment))
                .firebaseComponent(((BaseActivity)this).getFirebaseComponent())
                .build()
                .inject(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }





}