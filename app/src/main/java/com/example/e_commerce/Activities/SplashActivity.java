package com.example.e_commerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.e_commerce.R;

public class SplashActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        handler.postDelayed((Runnable) () -> {
           intent = new Intent(SplashActivity.this, IntroActivity.class);
            startActivity(intent);

        }, 3000);


    }


}