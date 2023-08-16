package com.example.jmp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.jmp1.ui.Dashboard.DashboardActivity;
import com.example.jmp1.ui.Login.LoginActivity;
import com.example.jmp1.ui.SplashScreen.SplashScreenActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        }, 5000);
    }
}