package com.clemmahe.firebasemvpdagger.authent;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.clemmahe.firebasemvpdagger.BaseActivity;
import com.clemmahe.firebasemvpdagger.R;
import com.clemmahe.firebasemvpdagger.firebase.FirebaseComponent;
import com.clemmahe.firebasemvpdagger.utils.ActivityUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AuthentActivity extends BaseActivity{
    
    @Inject
    AuthentPresenter mAuthentPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    FirebaseComponent mCompo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.authent_activity);
        ButterKnife.bind(this);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AuthentFragment authentFragment = (AuthentFragment) getSupportFragmentManager()
                .findFragmentById(R.id.authentContentFrame);
        if (authentFragment == null) {
            authentFragment = AuthentFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    authentFragment, R.id.authentContentFrame);
        }

        DaggerAuthentComponent.builder()
                .authentPresenterModule(new AuthentPresenterModule(authentFragment))
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