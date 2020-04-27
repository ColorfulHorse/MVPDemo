/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jess.xinghuo.di.component;

import android.app.Application;
import android.content.Context;
import android.content.RestrictionsManager;

import com.google.gson.Gson;
import com.jess.xinghuo.base.delegate.BaseAppDelegate;
import com.jess.xinghuo.di.module.BaseModule;
import com.jess.xinghuo.di.module.ClientModule;
import com.jess.xinghuo.di.module.GlobalConfigModule;
import com.jess.xinghuo.http.imageloader.ImageLoader;
import com.jess.xinghuo.integration.AppManager;
import com.jess.xinghuo.integration.IRepositoryManager;
import com.jess.xinghuo.integration.RepositoryManager;
import com.jess.xinghuo.integration.cache.Cache;
import com.jess.xinghuo.utils.ArmsUtils;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * =====================全局单列===========================
 * 可通过 {@link ArmsUtils#obtainAppComponentFromContext(Context)} 拿到此接口的实现类
 * 拥有此接口的实现类即可调用对应的方法拿到 Dagger 提供的对应实例
 * ================================================
 */
@Singleton
@Component(modules = {
        BaseModule.class,
        ClientModule.class,
        GlobalConfigModule.class
})
public interface BaseComponent {

    Application application();

    //用于管理所有 activity
    AppManager appManager();

    //用于管理网络请求层,以及数据缓存层
    RepositoryManager repositoryManager();

    //RxJava 错误处理管理类
    RxErrorHandler rxErrorHandler();

    //图片管理器,用于加载图片的管理类,默认使用 Glide ,使用策略模式,可在运行时替换框架
    ImageLoader imageLoader();

    OkHttpClient okHttpClient();

    Retrofit retrofit();

    //gson
    Gson gson();

    //缓存文件根目录(RxCache 和 Glide 的缓存都已经作为子文件夹放在这个根目录下),应该将所有缓存都放到这个根目录下,便于管理和清理,可在 GlobalConfigModule 里配置
    File cacheFile();

    //用来存取一些整个App公用的数据,切勿大量存放大容量数据
    Cache<String, Object> extras();

    //用于创建框架所需缓存对象的工厂
    Cache.Factory cacheFactory();

    @Named("ActivityLifecycle")
    Application.ActivityLifecycleCallbacks activityLifecycle();

    @Named("ActivityLifecycleForRxLifecycle")
    Application.ActivityLifecycleCallbacks activityLifecycleForRxLifecycle();

    void inject(BaseAppDelegate delegate);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        Builder globalConfigModule(GlobalConfigModule globalConfigModule);
        BaseComponent build();
    }
}
