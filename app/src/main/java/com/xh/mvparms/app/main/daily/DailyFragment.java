package com.xh.mvparms.app.main.daily;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xh.mvparms.R;
import com.xh.mvparms.app.base.BaseLazyFragment;

public class DailyFragment extends BaseLazyFragment<DailyPresenterImp> implements DailyContract.View{


    public static DailyFragment newInstance() {

        Bundle args = new Bundle();

        DailyFragment fragment = new DailyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_daily;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void lazyLoad(@Nullable Bundle savedInstanceState) {

    }
}
