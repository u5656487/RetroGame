package com.example.hahaha.amazing_snake;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Random;

public class Fruits extends Shape {
    Point g;
    FruitType t;
    //fruit is a point.
    public Fruits(Point g,FruitType t){
        this.g=g;
        this.t=t;
    }

    public static Fruits updateFruit (FruitType type,int COL_NUM, float distance,float half_gap){
        Random random = new Random();
        float x = random.nextInt(COL_NUM)*distance + distance/2;
        float y = random.nextInt(COL_NUM)*distance +distance/2 + half_gap;
        return new Fruits(new Point(x,y),type);
    }
    // draw the fruit.
    @Override
    void draw(Canvas c, float r) {
        c.drawCircle(g.x, g.y,r,p);
    }
}
