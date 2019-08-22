package com.example.lenovo.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.myapplication.entity.HotNews;
import com.example.lenovo.myapplication.entity.RecommendNews;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by lenovo on 2019/8/22.
 */

public class RecommendNewsAdapter extends RecyclerView.Adapter<RecommendNewsAdapter.RecommendNewsViewHolder> {

    List<RecommendNews> mRecommendNewsList;

    public RecommendNewsAdapter(List<RecommendNews> recommendNewsList) {
        mRecommendNewsList = recommendNewsList;
    }

    @NonNull
    @Override
    public RecommendNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(Global.GLOBAL_CONTEXT).inflate(R.layout.activity_recommend_news_item,null);
        RecommendNewsViewHolder holder=new RecommendNewsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendNewsAdapter.RecommendNewsViewHolder holder, int position) {
        RecommendNews recommendNews=mRecommendNewsList.get(position);
        holder.tvRecommendNewsId.setText(recommendNews.getId());
        holder.tvRecommendNewsTitle.setText(recommendNews.getNewTitle());
        holder.tvSourceName.setText(recommendNews.getSourceName());
        holder.tvSummary.setText(recommendNews.getSummary());
        String date= new SimpleDateFormat("yyyy-MM-dd").format(recommendNews.getPublishedTime());
        holder.tvPublishedTime.setText(date.toString());
        holder.tvNumberOfComments.setText("Comments  "+recommendNews.getNumberOfComments().toString());
        holder.tvNumberOfView.setText("View  "+recommendNews.getNumberOfView().toString());
        holder.tvNumberOfDiggs.setText("Diggs  "+recommendNews.getNumberOfDiggs().toString());
    }

    @Override
    public int getItemCount() {
        return mRecommendNewsList.size();
    }

    public class RecommendNewsViewHolder extends RecyclerView.ViewHolder{
        TextView tvRecommendNewsId;
        TextView tvRecommendNewsTitle;
        TextView tvPublishedTime;
        TextView tvSourceName;
        TextView tvSummary;
        TextView tvNumberOfView;
        TextView tvNumberOfComments;
        TextView tvNumberOfDiggs;

        public RecommendNewsViewHolder(View v) {
            super(v);
            tvRecommendNewsId=v.findViewById(R.id.tvRecommendNewsId);
            tvRecommendNewsTitle=v.findViewById(R.id.tvRecommendNewsTitle);
            tvPublishedTime=v.findViewById(R.id.tvPublishedTime);
            tvSourceName=v.findViewById(R.id.tvSourceName);
            tvSummary=v.findViewById(R.id.tvSummary);
            tvNumberOfView=v.findViewById(R.id.tviews);
            tvNumberOfComments=v.findViewById(R.id.tvComments);
            tvNumberOfDiggs=v.findViewById(R.id.tvDiggs);

        }
    }
}
