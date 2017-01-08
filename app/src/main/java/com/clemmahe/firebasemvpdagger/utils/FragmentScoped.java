package com.clemmahe.firebasemvpdagger.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Component which use singletons components must be scoped as FriendsComponent using FirebaseComponent
 * Created by clem on 06/12/2016.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScoped {
}
