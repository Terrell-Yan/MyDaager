package com.example.seanm.myapplication.di.module;



import com.example.seanm.myapplication.entity.Info;

import dagger.Module;
import dagger.Provides;

/**
 * Created by WZG on 2016/11/2.
 */
@Module
public class InfoModule {
    private String name;

    public InfoModule(String name) {
        this.name = name;
    }

    @Provides
    Info provideInfo(){
        return new Info(name);
    }
}
