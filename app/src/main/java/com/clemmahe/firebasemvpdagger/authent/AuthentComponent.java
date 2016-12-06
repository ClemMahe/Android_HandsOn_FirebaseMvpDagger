package com.clemmahe.firebasemvpdagger.authent;

import dagger.Component;

/**
 * AuthentComponent
 * Created by clem on 04/12/2016.
 */
//@Component(dependencies = FirebaseComponent.class, modules = AuthentPresenterModule.class)


@Component(modules = AuthentPresenterModule.class)



//@Component(dependencies = FirebaseComponent.class, modules = AuthentPresenterModule.class)
public interface AuthentComponent {

    void inject(AuthentActivity taskDetailActivity);
}