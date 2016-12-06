package com.clemmahe.firebasemvpdagger.authent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import com.clemmahe.firebasemvpdagger.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AuthentActivity extends AppCompatActivity {

    public static final String EXTRA_TASK_ID = "TASK_ID";

   // @Inject
    //AuthentPresenter mAuthentPresenter;
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

        // Create the presenter

        /*
        DaggerAuthentComponent.builder()
                .authentPresenterModule(new AuthentPresenterModule(contentListPeripherals))
                .tasksRepositoryComponent(((ToDoApplication) getApplication())
                        .getTasksRepositoryComponent())
                .build()
                .inject(this);
                */
        /*
        DaggerAuthentComponent.builder()
                .authentPresenterModule(new AuthentPresenterModule(taskDetailFragment, taskId))
                .tasksRepositoryComponent(((ToDoApplication) getApplication())
                .getTasksRepositoryComponent())
                .build()
                .inject(this);
                */
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}