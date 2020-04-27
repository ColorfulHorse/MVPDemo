package com.xh.mvparms.app.main.monthly;

import android.os.Bundle;
import android.support.annotation.Nullable;


import com.jess.xinghuo.integration.AppManager;
import com.jess.xinghuo.integration.RepositoryManager;
import com.jess.xinghuo.mvp.BasePresenter;
import com.xh.mvparms.R;
import com.xh.mvparms.app.base.BaseLazyFragment;

import javax.inject.Inject;

public class MonthlyFragment extends BaseLazyFragment implements MonthlyContract.View{

    public static MonthlyFragment newInstance() {

        Bundle args = new Bundle();

        MonthlyFragment fragment = new MonthlyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_monthly;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void lazyLoad(@Nullable Bundle savedInstanceState) {

    }

}
