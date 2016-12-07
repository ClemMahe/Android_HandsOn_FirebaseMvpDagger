package com.clemmahe.firebasemvpdagger.authent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.clemmahe.firebasemvpdagger.MvpApp;
import com.clemmahe.firebasemvpdagger.R;
import com.clemmahe.firebasemvpdagger.utils.ActivityUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AuthentActivity extends AppCompatActivity{
    
    @Inject
    AuthentPresenter mAuthentPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_authent);
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
                .firebaseComponent(((MvpApp) getApplication()).getFirebaseComponent())
                .build()
                .inject(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}