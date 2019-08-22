package com.example.lenovo.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.lenovo.myapplication.entity.HotNews;
import com.example.lenovo.myapplication.util.HttpUtil;
import com.example.lenovo.myapplication.util.Utility;

import java.util.List;

public class HotNewsActivity extends AppCompatActivity {

    List<HotNews> mHotNewsList;
    HotNewsAdapter mHotNewsAdapter;
    RecyclerView mRecyclerView;
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_news);
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
                    final String s = HttpUtil.GetResult("http://wcf.open.cnblogs.com/news/hot/10");
                    mHotNewsList = Utility.handleHotNewsResponse(s);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showHotNews(mHotNewsList);
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void showHotNews(List<HotNews> list){
        mHotNewsAdapter=new HotNewsAdapter(list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(Global.GLOBAL_CONTEXT));
        mRecyclerView.setAdapter(mHotNewsAdapter);
    }
}
