package com.example.hahaha.amazing_snake.adapter;
/**
 * activity_Guide ViewPager Adapter
 */
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * created by Wei XING
 */

/**
 * Fragment Adapter: https://developer.android.com/reference/android/support/v4/view/PagerAdapter
 * usage note:  https://blog.csdn.net/zhaokaiqiang1992/article/details/22575757
 *
 *
 *  the adapter of ViewPager in the GuideActivity
 *
 */

public class VpAdapter extends PagerAdapter {

    private ArrayList<ImageView> imageViews;

    public VpAdapter(ArrayList<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    /**
     * get the current number of objects which need to show
     */
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageViews.size();
    }

    /**
     * @param arg0 This is the first parameter to isViewFromObject method
     * @param arg1  This is the second parameter to isViewFromObject method
     * @return boolean This returns check whether the page is formed .
     */
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0 == arg1;
    }

    /**
     * @param container This is the first parameter to destroyItem method
     * @param position  This is the second parameter to destroyItem method
     * @param object  This is the third parameter to destroyItem method
     * This method is to remove the current image from ViewGroup
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews.get(position));
    }

    /**
     * @param container This is the first parameter to instantiateItem method
     * @param position  This is the second parameter to instantiateItem method
     * @return Object This method is to show the current image.
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViews.get(position));
        return imageViews.get(position);
    }

}
