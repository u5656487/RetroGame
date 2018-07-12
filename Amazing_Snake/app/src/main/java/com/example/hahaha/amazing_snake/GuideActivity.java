package com.example.hahaha.amazing_snake;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hahaha.amazing_snake.adapter.VpAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * created by Wei XING
 */

/**
 * slide screen: https://www.sitepoint.com/using-viewpager-to-create-a-sliding-screen-ui-in-android/
 *               https://github.com/tutorialwing/android-splash-screen-tutorial
 * apply ViewPager to adapt image : https://developer.android.com/training/animation/screen-slide
 *
 */

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager vPager;
    private VpAdapter vpAdapter;
    private static  int[] imgs = {R.drawable.details1,R.drawable.details2, R.drawable.details3};
    private ArrayList<ImageView> imageViews;
    private ImageView[] dotViews;//dot point

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        vPager = (ViewPager)findViewById(R.id.guide_ViewPager);
        initImages();
        initDots();
        vpAdapter = new VpAdapter(imageViews);
        vPager.setAdapter(vpAdapter);
        vPager.addOnPageChangeListener(this);
    }

    private void initDots() {
        LinearLayout layout = (LinearLayout)findViewById(R.id.dot_Layout);
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(20, 20);
        mParams.setMargins(10, 0, 10,0);//set the interval of dot
        dotViews = new ImageView[imgs.length];

        // measure the number of the dot, start from 0, 0 represents the first one
        for(int i = 0; i < imageViews.size(); i++)
        {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(mParams);
            imageView.setImageResource(R.drawable.dotselector);
            if(i== 0)
            {
                imageView.setSelected(true);//default to choose the first dot
            }
            else {
                imageView.setSelected(false);
            }
            dotViews[i] = imageView; // use to slide page
            layout.addView(imageView);
        }
    }

    /**
     * put the images (need to show in the introduction page) into the list (ArrayList);
     * in order to passing the images to the adapter to show the images
     */

    private void initImages() {
        // set all images to fill in the window
        ViewPager.LayoutParams mParams = new ViewPager.LayoutParams();
        imageViews = new ArrayList<ImageView>();

        for(int i=0; i<imgs.length; i++)
        {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mParams); // set layout
            iv.setImageResource(imgs[i]); // add image resources
            iv.setScaleType(ImageView.ScaleType.FIT_XY); // adapt image
            imageViews.add(iv);
            if (i == imgs.length -1 ){
                //add event for the last image
                iv.setOnTouchListener(new View.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event){
                        // branch to the LevelActivity
                        Intent toMainActivity = new Intent(GuideActivity.this, LevelActivity.class);
                        startActivity(toMainActivity);
                        return true;

                    }
                });
            }

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * arg0：the index of the current slide
     */
    @Override
    public void onPageSelected(int position) {
        for(int i = 0; i < dotViews.length; i++)
        {
            if(position == i)
            {
                dotViews[i].setSelected(true);
            }
            else {
                dotViews[i].setSelected(false);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            exitBy2Click();      //double click to exit the function
        }
        return false;
    }

    /**
     * double click to exit the function
     */
    private static Boolean isExit = false;
    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // prepare to exit
            Toast.makeText(this, "click again to exit the program", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // cancel exit
                }
            }, 2000); // cancel the task

        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            System.exit(0);
        }
    }
}
