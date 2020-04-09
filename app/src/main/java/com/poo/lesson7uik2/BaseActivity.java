package com.poo.lesson7uik2;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements  View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getByID());
        initView();
    }

    protected abstract void initView();

    protected abstract int getByID();


    public <T extends View> T findViewById(int id, View.OnClickListener event) {
       View v = findViewById(id);
       if(v!= null && event != null){
           v.setOnClickListener(event);
       }
       return (T) v;
    }

    @Override
    public void onClick(View v) {
        //do nothing
    }
}
