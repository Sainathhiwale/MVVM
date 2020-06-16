package com.dorvis.mvvm.ui.login;

import androidx.lifecycle.ViewModel;

import com.dorvis.mvvm.di.utils_di.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class LoginViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    public abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);
}
