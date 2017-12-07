package com.example.seanm.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.seanm.myapplication.di.component.DaggerUserComponent;
import com.example.seanm.myapplication.di.component.UserComponent;
import com.example.seanm.myapplication.di.module.UserModule;
import com.example.seanm.myapplication.entity.User;

import javax.inject.Inject;

import dagger.android.DaggerActivity;

public class MainActivity extends AppCompatActivity {
@Inject
    User user;
UserComponent component;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        component= DaggerUserComponent.builder().userModule(new UserModule()).build();
        component.inject(this);
        TextView textView=(TextView)findViewById(R.id.tv);
        textView.setText("name:"+user.getName()+"\nsex:"+user.getSex()+"\nads:"+user.getAds());
    }
}
