package com.xh.mvparms.app.main.weekly;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.xh.mvparms.R;
import com.xh.mvparms.app.base.BaseLazyFragment;
import com.xh.mvparms.app.model.bean.Forecast;
import com.xh.mvparms.app.model.bean.ForecastList;
import com.xh.mvparms.app.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WeeklyFragment extends BaseLazyFragment<WeeklyPresenterImp> implements WeeklyContract.View{

    private static final String TAG = WeeklyFragment.class.getSimpleName();
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    private ForecastList forecastList;
    private List<Forecast> data = new ArrayList<>();
    private ForecastListAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;


    public static WeeklyFragment newInstance() {

        Bundle args = new Bundle();

        WeeklyFragment fragment = new WeeklyFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public Long getCityId() {
        return ApiService.DEFAULT_ID;
    }

    @Override
    public void showLoading(boolean show) {
        if (show){
            if (refresh.isRefreshing())
                return;
        }
        refresh.setRefreshing(show);
    }

    @Override
    public void onData(ForecastList data) {
        forecastList = data;
        this.data.clear();
        this.data.addAll(data.getDailyForecast());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailed(Throwable throwable) {
        Log.e(TAG, "err", throwable);
    }

    @Override
    public void goDetail(Forecast forecast) {
        /*Intent intent = new Intent(getActivity(), ForecastActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ForecastActivity.EXTRA_FORECAST_ID, Parcels.wrap(forecast));
        bundle.putString(ForecastActivity.EXTRA_CITY_NAME, forecastList.getCity());
        intent.putExtras(bundle);
        startActivity(intent);*/
    }


    @Override
    public int bindLayout() {
        return R.layout.fragment_forecast_list;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mAdapter = new ForecastListAdapter(data);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(((position, view) -> mPresenter.goDetail(data.get(position))));
        refresh.setOnRefreshListener(() -> {
            mPresenter.getData();
        });
    }


    @Override
    protected void lazyLoad(@Nullable Bundle savedInstanceState) {
        mPresenter.getData();
    }

}
