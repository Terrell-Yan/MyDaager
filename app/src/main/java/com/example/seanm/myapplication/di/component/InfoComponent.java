package com.example.seanm.myapplication.di.component;


import com.example.seanm.myapplication.di.module.InfoModule;
import com.example.seanm.myapplication.entity.Info;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by WZG on 2016/11/3.
 */
@Component(modules = {InfoModule.class})
public interface InfoComponent {

    @Singleton
    Info infoMoudule();
}
