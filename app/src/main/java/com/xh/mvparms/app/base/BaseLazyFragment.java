package com.xh.mvparms.app.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.xinghuo.base.BaseFragment;
import com.jess.xinghuo.di.component.BaseComponent;
import com.jess.xinghuo.mvp.IPresenter;

public abstract class BaseLazyFragment<P extends IPresenter> extends BaseFragment<P>{
    // 是否已经初始化
    private boolean mInited = false;
    // 是否已被创建
    private boolean mCreated = false;
    private Bundle mSavedInstanceState;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSavedInstanceState = savedInstanceState;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCreated = true;
        if (getUserVisibleHint() && !mInited) {
            lazyLoad(mSavedInstanceState);
            mInited = true;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !mInited && mCreated) {
            lazyLoad(mSavedInstanceState);
            mInited = true;
        }
    }


    /**
     * 懒加载
     */
    protected abstract void lazyLoad(@Nullable Bundle savedInstanceState);
}
