package com.example.hahaha.amazing_snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public abstract class BodyDecorator extends Shape{
    Shape shape;
    public BodyDecorator(Shape s){
        this.shape = s;
    }
    // connect concrete class and concrete decorator class.
    @Override
    public void draw(Canvas c, float r) {
        this.shape.draw(c,r);
    }
}
