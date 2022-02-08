package com.ankitsharma.digitalworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_splash_screen);
       getSupportActionBar ().hide ();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Thread td = new Thread (){

            @Override
            public void run() {
                try {
                    sleep (5000);
                }
                catch (Exception ex){
                    ex.printStackTrace ();
                }
                finally {
                    Intent intent = new Intent (SplashScreenActivity.this,LoginActivity.class);
                    startActivity (intent);
                    finish ();
                }
            }
        };td.start ();

    }
}