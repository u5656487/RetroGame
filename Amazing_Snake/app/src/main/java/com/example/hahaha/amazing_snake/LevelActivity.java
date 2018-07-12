package com.example.hahaha.amazing_snake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * created by Wei XING
 */

/**
 * This class shows the page of three levels (easy,medium,hard)
 * each button will branch to the MainActivity
 */

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
    }

    public void playGameEasy(View view) {
        Log.d("main","button clicked");

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void playGameMedium(View view) {
        Log.d("main","button clicked");

        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);

    }
}
