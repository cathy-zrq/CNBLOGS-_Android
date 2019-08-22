package com.example.lenovo.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.myapplication.entity.HotNews;
import com.example.lenovo.myapplication.entity.LatestNews;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by lenovo on 2019/8/22.
 */

public class LatestNewsAdapter extends RecyclerView.Adapter<LatestNewsAdapter.LatestNewsViewHolder> {

    List<LatestNews> mLatestNewsList;

    public LatestNewsAdapter(List<LatestNews> latestNewsList) {
        mLatestNewsList = latestNewsList;
    }

    @NonNull
    @Override
    public LatestNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(Global.GLOBAL_CONTEXT).inflate(R.layout.activity_latest_news_item,null);
        LatestNewsViewHolder holder=new LatestNewsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LatestNewsAdapter.LatestNewsViewHolder holder, int position) {
        LatestNews latestNews=mLatestNewsList.get(position);
        holder.tvLatestNewsId.setText(latestNews.getId());
        holder.tvLatestNewsTitle.setText(latestNews.getNewTitle());
        holder.tvSourceName.setText(latestNews.getSourceName());
        holder.tvSummary.setText(latestNews.getSummary());
        String date= new SimpleDateFormat("yyyy-MM-dd").format(latestNews.getPublishedTime());
        holder.tvPublishedTime.setText(date.toString());
        holder.tvNumberOfComments.setText("Comments  "+latestNews.getNumberOfComments().toString());
        holder.tvNumberOfView.setText("View  "+latestNews.getNumberOfView().toString());
        holder.tvNumberOfDiggs.setText("Diggs  "+latestNews.getNumberOfDiggs().toString());
    }

    @Override
    public int getItemCount() {
        return mLatestNewsList.size();
    }

    public class LatestNewsViewHolder extends RecyclerView.ViewHolder{
        TextView tvLatestNewsId;
        TextView tvLatestNewsTitle;
        TextView tvPublishedTime;
        TextView tvSourceName;
        TextView tvSummary;
        TextView tvNumberOfView;
        TextView tvNumberOfComments;
        TextView tvNumberOfDiggs;

        public LatestNewsViewHolder(View v) {
            super(v);
            tvLatestNewsId=v.findViewById(R.id.tvLatestNewsId);
            tvLatestNewsTitle=v.findViewById(R.id.tvLatestNewsTitle);
            tvPublishedTime=v.findViewById(R.id.tvPublishedTime);
            tvSourceName=v.findViewById(R.id.tvSourceName);
            tvSummary=v.findViewById(R.id.tvSummary);
            tvNumberOfView=v.findViewById(R.id.tviews);
            tvNumberOfComments=v.findViewById(R.id.tvComments);
            tvNumberOfDiggs=v.findViewById(R.id.tvDiggs);

        }
    }
}
