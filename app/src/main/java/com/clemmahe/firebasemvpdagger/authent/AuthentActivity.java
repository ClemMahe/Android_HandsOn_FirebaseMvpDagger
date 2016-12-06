package com.clemmahe.firebasemvpdagger.authent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import com.clemmahe.firebasemvpdagger.MvpApp;
import com.clemmahe.firebasemvpdagger.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AuthentActivity extends AppCompatActivity implements AuthentContract.View{

    public static final String EXTRA_TASK_ID = "TASK_ID";

    @Inject
    AuthentPresenter mAuthentPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.content_list_peripherals)
    RelativeLayout contentListPeripherals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_authent);
        ButterKnife.bind(this);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DaggerAuthentComponent.builder()
                .authentPresenterModule(new AuthentPresenterModule(this))
                .firebaseComponent(((MvpApp) getApplication()).getFirebaseComponent())
                .build()
                .inject(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void showConnectedStatus(boolean isConnected) {

    }

    @Override
    public void setPresenter(AuthentContract.Presenter presenter) {

    }
}