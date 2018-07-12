package com.example.hahaha.amazing_snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circle extends Shape {
    Point point;
    public  Circle(Point point){
        this.point=point;

    }
    @Override
    public void draw(Canvas c,float r) {
        c.drawCircle(point.x, point.y,r,p);
    }
}
