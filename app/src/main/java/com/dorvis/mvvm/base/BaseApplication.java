package com.dorvis.mvvm.base;

import com.dorvis.mvvm.R;
import com.dorvis.mvvm.data.prefs.DataManager;
import com.dorvis.mvvm.data.prefs.SharedPrefsHelper;
import com.dorvis.mvvm.di.component.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    private DataManager dataManager;
    public static final String  CHANNEL_ID ="DailyExpense";

    @Override
    public void onCreate() {
        super.onCreate();


        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(getApplicationContext());
        dataManager = new DataManager(sharedPrefsHelper);

    }



    public DataManager getDataManager() {
        return dataManager;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().application(this).build();
//        return null;
    }
    /*@Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        ApplicationComponent component = DaggerApplicationComponent.builder().application(this).build();
        component.inject(this);

        return component;
    }*/
}
