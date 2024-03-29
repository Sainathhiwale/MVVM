package com.dorvis.mvvm.di.component;

import android.app.Application;

import com.dorvis.mvvm.base.BaseApplication;
import com.dorvis.mvvm.di.main.ActivityBuildersModule;
import com.dorvis.mvvm.di.main.AppModule;
import com.dorvis.mvvm.di.module.ContextModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ContextModule.class, AppModule.class, AndroidSupportInjectionModule.class,
        ActivityBuildersModule.class
})public interface  ApplicationComponent extends AndroidInjector<DaggerApplication> {


    void inject(BaseApplication baseApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }

}
