package com.dorvis.mvvm.di.module;

import com.dorvis.mvvm.ui.home.HomeFragment;
import com.dorvis.mvvm.ui.home.HomeViewModel;
import com.dorvis.mvvm.ui.login.LoginActivity;
import com.dorvis.mvvm.ui.users.allusers.GetAllUserFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector()
    abstract LoginActivity bindLoginActivity();


}
