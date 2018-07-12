package com.example.hahaha.amazing_snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import static android.graphics.Color.BLACK;

public class ColorBody extends BodyDecorator {
    int color;
    //concrete decorator class, which consturcted by a shape and Color.(Color is a int)
    public ColorBody(Shape s, int c) {
        super(s);
        this.color=c;
    }
    // connnect 2 method, shape'method, and its own method
    @Override
    public void draw(Canvas c, float r) {
        Paint paint=new Paint();
        paint.setColor(this.color);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(4.5f);
        paint.setTextSize(100);
        this.shape.p=paint;
        this.shape.draw(c,r);

    }



}

