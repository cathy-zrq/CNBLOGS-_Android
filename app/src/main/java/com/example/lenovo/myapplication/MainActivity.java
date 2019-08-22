package com.example.lenovo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lenovo.myapplication.entity.HotNews;
import com.example.lenovo.myapplication.entity.LatestNews;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Global.GLOBAL_CONTEXT=getApplicationContext();

        initControl();


    }


    public void initControl(){
        toolbar=(Toolbar) this.findViewById(R.id.tlTitleBar);
        this.setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("");
//        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setHomeAsUpIndicator(R.drawable.cnblogs);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.hotNews:
                mIntent=new Intent(MainActivity.this, HotNewsActivity.class);
                startActivity(mIntent);
                break;
            case R.id.latestNews:
                mIntent=new Intent(MainActivity.this, LatestNewsActivity.class);
                startActivity(mIntent);
                break;
            case R.id.recommendNews:
                mIntent=new Intent(MainActivity.this, RecommendNewsActivity.class);
                startActivity(mIntent);
                break;
            case R.id.setting:
                mIntent=new Intent(MainActivity.this, SettingActivity.class);
                startActivity(mIntent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
