package com.clemmahe.firebasemvpdagger.authent;

import com.clemmahe.firebasemvpdagger.firebase.FirebaseComponent;
import com.clemmahe.firebasemvpdagger.utils.ActivityScoped;

import dagger.Component;

/**
 * AuthentComponent
 * Created by clem on 04/12/2016.
 */
@ActivityScoped
@Component(dependencies = FirebaseComponent.class, modules = AuthentPresenterModule.class)
public interface AuthentComponent {

    void inject(AuthentActivity taskDetailActivity);
}