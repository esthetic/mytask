package com.thecabine.sample;

import android.app.Application;
import android.content.Context;

/**
 * Created by admin on 10/21/15.
 */
public class App extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static Context getAppContext() {
        return sContext;
    }
}
