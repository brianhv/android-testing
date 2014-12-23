package com.example.android.testing.espresso.BasicSample;

import android.app.Application;

import javax.inject.Inject;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

/**
 * Created by bhv1 on 12/23/14.
 */
public class MyApplication extends Application {
    private ObjectGraph graph;
    @Inject InjectedClass injectedClass;

    @Override
    public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(getModules());
        graph.inject(this);
    }

    private Object[] getModules() {
        return new Object[]{
                new DaggerModule(),
        };
    }

    public void inject(Object object) {
        graph.inject(object);
    }

    @Module(injects = MyApplication.class)
    public class DaggerModule {
        @Provides
        public InjectedClass provideInjectedClass() {
            return new InjectedClass();
        }
    }

    public class InjectedClass {
    }
}
