package com.example.frescos.fresco;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class FrescoActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
