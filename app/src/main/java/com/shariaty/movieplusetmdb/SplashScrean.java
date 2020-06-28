package com.shariaty.movieplusetmdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


public class SplashScrean extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screan);

        Thread splashTime=new Thread(){

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
                finally {
                    startActivity(new Intent(SplashScrean.this,MainActivity.class));
                }
            }
        };
        splashTime.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}