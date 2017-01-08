package com.clemmahe.firebasemvpdagger.friends;

import com.clemmahe.firebasemvpdagger.firebase.FirebaseComponent;
import com.clemmahe.firebasemvpdagger.utils.FragmentScoped;

import dagger.Component;

/**
 * FriendsComponent
 * Created by clem on 04/12/2016.
 */
@FragmentScoped
@Component(dependencies = FirebaseComponent.class, modules = FriendsPresenterModule.class)
public interface FriendsComponent {

    void inject(FriendsActivity friendsActivity);
}