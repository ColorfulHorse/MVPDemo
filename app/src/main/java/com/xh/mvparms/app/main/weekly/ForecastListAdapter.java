package com.xh.mvparms.app.main.weekly;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xh.mvparms.R;
import com.xh.mvparms.app.model.bean.Forecast;

import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author greensun
 *
 * @date 2018/8/21
 *
 * @desc TODO
 */
public class ForecastListAdapter extends RecyclerView.Adapter<ForecastListAdapter.BaseViewHolder> {

    private List<Forecast> data;
    private OnItemClickListener onItemClickListener;

    public ForecastListAdapter(List<Forecast> data) {
        this.data = data;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bindData(position, data.get(position));
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    class BaseViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.high)
        TextView high;
        @BindView(R.id.low)
        TextView low;
        BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindData(int position, Forecast forecast) {
            if (onItemClickListener != null){
                itemView.setOnClickListener(view -> onItemClickListener.onClick(position, itemView));
            }
            description.setText(forecast.getDesc());
            high.setText(String.format(Locale.getDefault(), "%.1f°", forecast.getHigh()));
            low.setText(String.format(Locale.getDefault(), "%.1f°", forecast.getLow()));
            Glide.with(itemView).load(forecast.getIconUrl()).into(icon);
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
            date.setText(dateFormat.format(forecast.getDate()));
        }

    }

    public interface OnItemClickListener{
        void onClick(int position, View view);
    }
}
