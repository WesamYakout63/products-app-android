package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class SplashScreen extends AppCompatActivity {

    public static int Splash_time = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splash();

    }

    private void splash()
    {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this , MainActivity.class);
            startActivity(intent);
            finish();
        }, Splash_time);
    }

}
