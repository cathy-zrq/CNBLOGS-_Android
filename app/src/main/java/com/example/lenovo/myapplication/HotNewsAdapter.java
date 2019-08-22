package com.example.lenovo.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.myapplication.entity.HotNews;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by lenovo on 2019/8/22.
 */

public class HotNewsAdapter extends RecyclerView.Adapter<HotNewsAdapter.HotNewsViewHolder> {

    List<HotNews> mHotNewsList;

    public HotNewsAdapter(List<HotNews> hotNewsList) {
        mHotNewsList = hotNewsList;
    }

    @NonNull
    @Override
    public HotNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(Global.GLOBAL_CONTEXT).inflate(R.layout.activity_hot_news_item,null);
        HotNewsViewHolder holder=new HotNewsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotNewsAdapter.HotNewsViewHolder holder, int position) {
        HotNews hotNews=mHotNewsList.get(position);
        holder.tvHotNewsId.setText(hotNews.getId());
        holder.tvHotNewsTitle.setText(hotNews.getNewTitle());
        holder.tvSourceName.setText(hotNews.getSourceName());
        holder.tvSummary.setText(hotNews.getSummary());
        String date= new SimpleDateFormat("yyyy-MM-dd").format(hotNews.getPublishedTime());
        holder.tvPublishedTime.setText(date.toString());
        holder.tvNumberOfComments.setText("Comments  "+hotNews.getNumberOfComments().toString());
        holder.tvNumberOfView.setText("View  "+hotNews.getNumberOfView().toString());
        holder.tvNumberOfDiggs.setText("Diggs  "+hotNews.getNumberOfDiggs().toString());
    }

    @Override
    public int getItemCount() {
        return mHotNewsList.size();
    }

    public class HotNewsViewHolder extends RecyclerView.ViewHolder{
        TextView tvHotNewsId;
        TextView tvHotNewsTitle;
        TextView tvPublishedTime;
        TextView tvSourceName;
        TextView tvSummary;
        TextView tvNumberOfView;
        TextView tvNumberOfComments;
        TextView tvNumberOfDiggs;

        public HotNewsViewHolder(View v) {
            super(v);
            tvHotNewsId=v.findViewById(R.id.tvHotNewsId);
            tvHotNewsTitle=v.findViewById(R.id.tvHotNewsTitle);
            tvPublishedTime=v.findViewById(R.id.tvPublishedTime);
            tvSourceName=v.findViewById(R.id.tvSourceName);
            tvSummary=v.findViewById(R.id.tvSummary);
            tvNumberOfView=v.findViewById(R.id.tviews);
            tvNumberOfComments=v.findViewById(R.id.tvComments);
            tvNumberOfDiggs=v.findViewById(R.id.tvDiggs);

        }
    }
}
