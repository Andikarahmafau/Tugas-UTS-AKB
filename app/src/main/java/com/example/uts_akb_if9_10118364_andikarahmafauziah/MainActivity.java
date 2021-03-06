package com.example.uts_akb_if9_10118364_andikarahmafauziah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


    public class Splash_Screen extends AppCompatActivity {
        private static int SPLASH_SCREEN = 5000;
//06062021-10118364-Andika Rahma Fauziah-IF09

        //variables
        Animation topAnim, bottomAnim;
        ImageView image;
        TextView logo, slogan;

        SharedPreferences onBoardingScreen;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow() .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_main);

            //Animation
            topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
            bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

            //Hooks
            image = findViewById(R.id.ImageView);
            logo = findViewById(R.id.textView);
            slogan = findViewById(R.id.textView2);

            image.setAnimation(topAnim);
            logo.setAnimation(bottomAnim);
            slogan.setAnimation(bottomAnim);

            new Handler() .postDelayed(new Runnable() {
                @Override
                public void run() {

                    onBoardingScreen = getSharedPreferences("onBoardingScreen" ,MODE_PRIVATE);
                    boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

                    if(isFirstTime){

                        SharedPreferences.Editor editor = onBoardingScreen.edit();
                        editor.putBoolean("firstTime", false);
                        editor.commit();
                        Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }
            },SPLASH_SCREEN);
}