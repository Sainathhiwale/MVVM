package com.dorvis.mvvm.di.main;

import com.dorvis.mvvm.MainActivity;
import com.dorvis.mvvm.ui.login.LoginActivity;
import com.dorvis.mvvm.ui.login.LoginViewModel;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    abstract MainActivity contributeMainActivity();

  @ContributesAndroidInjector(modules = LoginViewModel.class)
  abstract LoginActivity bindLoginActivity();

}
