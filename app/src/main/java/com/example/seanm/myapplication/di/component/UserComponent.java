package com.example.seanm.myapplication.di.component;



import com.example.seanm.myapplication.MainActivity;
import com.example.seanm.myapplication.di.module.UserModule;

import dagger.Component;

/**
 * Created by WZG on 2016/11/2.
 */
@Component(modules = UserModule.class)
public interface UserComponent {

    void inject(MainActivity mainActivity);
}
