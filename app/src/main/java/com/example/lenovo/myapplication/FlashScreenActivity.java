package com.example.lenovo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FlashScreenActivity extends AppCompatActivity {

    LinearLayout mLinearLayout;
    TextView tvCountDown;
    TextView tvSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);


//        ActionBar actionBar=getSupportActionBar();
//        actionBar.hide();

        mLinearLayout=findViewById(R.id.llCountDown);
        tvCountDown =findViewById(R.id.tvCountDown);
        tvSkip=findViewById(R.id.tvSkip);


        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FlashScreenActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        startTime();
    }


     public void startTime(){
         CountDownTimer timer = new CountDownTimer(5000,1000) {
             @Override
             public void onTick(long l) {
                 tvCountDown.setText(l/1000+1+"");
             }

             @Override
             public void onFinish() {
                 Intent intent=new Intent(FlashScreenActivity.this,MainActivity.class);
                 startActivity(intent);
             }
         }.start();
     }
}
