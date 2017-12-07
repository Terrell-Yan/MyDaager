package com.example.seanm.myapplication.di.module;



import com.example.seanm.myapplication.entity.User;

import dagger.Module;
import dagger.Provides;

/**
 * Created by WZG on 2016/11/2.
 */
@Module
public class UserModule {

    @Provides
    User provideUser(){
        return new User("xxxx","SEX","XXX@Gmail.com");
    }
}
