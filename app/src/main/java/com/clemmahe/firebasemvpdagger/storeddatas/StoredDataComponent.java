package com.clemmahe.firebasemvpdagger.storeddatas;

import com.clemmahe.firebasemvpdagger.firebase.FirebaseComponent;
import com.clemmahe.firebasemvpdagger.utils.FragmentScoped;

import dagger.Component;

/**
 * StoredDataComponent
 * Created by clem on 04/12/2016.
 */
@FragmentScoped
@Component(dependencies = FirebaseComponent.class, modules = StoredDataPresenterModule.class)
public interface StoredDataComponent {

    void inject(StoredDataActivity friendsActivity);
}