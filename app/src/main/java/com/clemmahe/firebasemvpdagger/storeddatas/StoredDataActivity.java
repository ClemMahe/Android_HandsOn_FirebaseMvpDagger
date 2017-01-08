package com.clemmahe.firebasemvpdagger.storeddatas;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.clemmahe.firebasemvpdagger.BaseActivity;
import com.clemmahe.firebasemvpdagger.R;
import com.clemmahe.firebasemvpdagger.firebase.FirebaseComponent;
import com.clemmahe.firebasemvpdagger.utils.ActivityUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoredDataActivity extends BaseActivity{
    
    @Inject
    StoredDataPresenter mAuthentPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    FirebaseComponent mCompo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.storedatas_activity);
        ButterKnife.bind(this);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        StoredDataFragment storedDataFragment = (StoredDataFragment) getSupportFragmentManager()
                .findFragmentById(R.id.storedDataContentFrame);
        if (storedDataFragment == null) {
            storedDataFragment = StoredDataFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    storedDataFragment, R.id.storedDataContentFrame);
        }

        DaggerStoredDataComponent.builder()
                .storedDataPresenterModule(new StoredDataPresenterModule(storedDataFragment))
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