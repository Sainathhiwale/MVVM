package com.dorvis.mvvm.di.module;

import com.dorvis.mvvm.ui.home.HomeViewModel;
import com.dorvis.mvvm.ui.login.LoginViewModel;
import com.dorvis.mvvm.ui.users.allusers.AllUserViewModel;
import com.dorvis.mvvm.utils.ViewModelFactory;
import com.dorvis.mvvm.utils.ViewModelKey;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Singleton
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
   abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    abstract ViewModel bindHomeViewModel(HomeViewModel homeViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
