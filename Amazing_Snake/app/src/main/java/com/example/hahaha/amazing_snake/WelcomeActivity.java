package com.example.hahaha.amazing_snake;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * created by Wei XING
 */

/**
 * This is a welcome page (fulfill the introduction page for the first time to start)
 */

public class WelcomeActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //start a delay thread
        new Thread(this).start();

    }

    public void playGame(View view) {
        Log.d("main","button clicked");

        run();

    }

    @Override
    public void run() {
        try{
            /**
             * delay 0.5s
             */
            Thread.sleep(500);

            // if exits, open it, otherwise, create new Preferences
            SharedPreferences preferences= getSharedPreferences("count", 0);
            // fetch the data
            int count = preferences.getInt("count", 0);

            /**
             * if the user is not the first time to use, branch to the level page;
             * otherwise branch to the guide page
             */

            if (count == 0) {
                Intent intent1 = new Intent();
                intent1.setClass(WelcomeActivity.this, GuideActivity.class);
                startActivity(intent1);
            } else {
                Intent intent2 = new Intent();
                intent2.setClass(WelcomeActivity.this, GuideActivity.class); // should be LevelActivity here
                startActivity(intent2);
            }
            finish();

            //instantiate the object of Editor
            SharedPreferences.Editor editor = preferences.edit();
            //store data
            editor.putInt("count", 1);
            //commit change
            editor.commit();
        } catch (InterruptedException e) {

        }
    }
}
