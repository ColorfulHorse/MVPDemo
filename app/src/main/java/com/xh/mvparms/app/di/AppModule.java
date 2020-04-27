package com.xh.mvparms.app.di;

import android.app.Application;
import android.content.Context;

import com.jess.xinghuo.di.scope.AppScope;
import com.jess.xinghuo.mvp.BasePresenter;
import com.jess.xinghuo.mvp.IPresenter;
import com.xh.mvparms.BuildConfig;
import com.xh.mvparms.app.box.MyObjectBox;

import javax.annotation.Nullable;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

@Module
public class AppModule {

    @AppScope
    @Provides
    public static BoxStore providerBoxStore(Application context){
        BoxStore mBoxStore = MyObjectBox.builder().androidContext(context).build();
        if (BuildConfig.DEBUG){
            new AndroidObjectBrowser(mBoxStore).start(context);
        }
        return mBoxStore;
    }

    /**
     * 此方法是为了给不需要Presenter的组件提供一个空Presenter
     * @return
     */
    @Provides
    @Nullable
    public static IPresenter providerPresenter(){
        return null;
    }
}
