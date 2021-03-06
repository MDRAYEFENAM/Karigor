package com.mdrayefenam.karigorbangla.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mdrayefenam.karigorbangla.R;
import com.mdrayefenam.karigorbangla.SessionClass.SessionClass;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    SessionClass sessionClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.splash_screen);

        sessionClass = SessionClass.getInstance(this);

        if (sessionClass.isLoggedIn()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(SplashScreen.this, MainServiceSelectPage.class);
                    startActivity(intent);
                    finish();


                }
            }, 2000);
        } else {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(SplashScreen.this, MainServiceSelectPage.class);
                    startActivity(intent);
                    finish();


                }
            }, 2000);
        }
    }
}
