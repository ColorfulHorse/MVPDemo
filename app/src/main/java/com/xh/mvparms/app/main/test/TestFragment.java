package com.xh.mvparms.app.main.test;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jess.xinghuo.base.BaseFragment;
import com.xh.mvparms.R;


public class TestFragment extends BaseFragment<TestPresenterImp> implements TestContract.View{
    @Override
    public int bindLayout() {
        return R.layout.fragment_daily;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
}
