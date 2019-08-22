package com.example.lenovo.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.lenovo.myapplication.entity.LatestNews;
import com.example.lenovo.myapplication.entity.RecommendNews;
import com.example.lenovo.myapplication.util.HttpUtil;
import com.example.lenovo.myapplication.util.Utility;

import java.util.List;

public class RecommendNewsActivity extends AppCompatActivity {
    List<RecommendNews> mRecommendNewsList;
    RecommendNewsAdapter mRecommendNewsAdapter;
    RecyclerView mRecyclerView;
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_news);
        mRecyclerView=findViewById(R.id.recyclerView);

        mToolbar=this.findViewById(R.id.tlTitleBar);
        this.setSupportActionBar(mToolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("");
        loadDate();
    }



    public void loadDate(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final String s = HttpUtil.GetResult("http://wcf.open.cnblogs.com/news/recommend/paged/1/5");
                    mRecommendNewsList = Utility.handleRecommendNewsResponse(s);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showLatestNews(mRecommendNewsList);
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void showLatestNews(List<RecommendNews> list){
        mRecommendNewsAdapter=new RecommendNewsAdapter(list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(Global.GLOBAL_CONTEXT));
        mRecyclerView.setAdapter(mRecommendNewsAdapter);
    }
}
