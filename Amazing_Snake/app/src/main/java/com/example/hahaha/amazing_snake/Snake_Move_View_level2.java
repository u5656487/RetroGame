package com.example.hahaha.amazing_snake;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HAHAHA on 1/04/2018.
 */

public class Snake_Move_View_level2 extends  View  implements Runnable, View.OnTouchListener {
    Handler timer;
    Random random;
    Snake_Body snake;
    final int COL_NUM=15;
    final int ROW_NUM=15;
    float screen_width;
    float screen_height;
    float half_gap;
    float width;
    float mouse_x;
    float mouse_y;
    Shape shape;
    ArrayList<Fruits> fruits;

    // when the snake_move_view was initialised, initialize a new snake_body and fruits.
    public Snake_Move_View_level2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);
        screen_width=Resources.getSystem().getDisplayMetrics().widthPixels;
        screen_height=Resources.getSystem().getDisplayMetrics().heightPixels;
        float gap=screen_height-screen_width;
        half_gap =gap/2;
        width=screen_width/COL_NUM;
        timer = new Handler();
        snake=new Snake_Body(new Point( (float) (2.5*width),half_gap+width/2),width);
        timer.postDelayed(this, snake.getDelay());
        snake.set_MoveDistance(width);
        snake.set_COLNUM(COL_NUM);
        snake.set_halgap(half_gap);
        fruits=new ArrayList<Fruits>();
        Fruits fruit=new Fruits(new Point( (float)(2.5*width),(float) (half_gap+1.5*width)),FruitType.Apple );
        fruits.add(fruit);
        fruit =new Fruits(new Point( (float)(4.5*width),(float) (half_gap+2.5*width)),FruitType.Banana );
        fruits.add(fruit);

    }
    // draw the Grid, snake and fruits on the canvas
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawGrid(canvas);
        for (Point point:snake.snake_container){
            shape=new ColorBody(new Circle(point), Color.GREEN);
            shape.draw(canvas,width/2);
        }
        for (Fruits f:fruits){
            if(f.t==FruitType.Apple){
                shape=new ColorBody(new Circle(f.g),Color.BLUE);
                shape.draw(canvas,width/2);}
            else if(f.t==FruitType.Banana){
                shape=new ColorBody(new Circle(f.g),Color.YELLOW);
                shape.draw(canvas,width/2);}
        }

        for (Point point:snake.molt.get()){
            shape=new ColorBody(new Circle(point), Color.BLACK);
            shape.draw(canvas,width/2);
        }

        this.invalidate();

    }
    //draw Grid
    public void drawGrid(Canvas canvas){
        Paint p=new Paint();
        p.setColor(Color.BLACK);
        p.setStrokeWidth(10);
        p.setTextSize(100);
        canvas.drawText("Score :"+(snake.snake_container.size() -3),screen_width/5,half_gap/2,p);
        for(int i=0;i<=COL_NUM;i++){
            canvas.drawLine(0,half_gap+width*i,screen_width,half_gap+width*i,p);
            canvas.drawLine(0+width*i,half_gap,0+width*i,half_gap+screen_width,p);
        }
    }
    // When the motionevent was detected, decide whether to change snake's moving direction. And based on the motionevent, change the direction
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN) {
            mouse_x = event.getX();
            mouse_y = event.getY();
        }
        float snakeX=this.snake.snake_container.get(0).x;
        float snakeY=this.snake.snake_container.get(0).y;
        if (Math.abs(mouse_x - snakeX) >= Math.abs(mouse_y - snakeY)){
            if (mouse_x > snakeX) {
                snake.dir = Direction.Right;
            } else {
                snake.dir = Direction.Left;
            }
        } else {
            if (mouse_y > snakeY) {
                snake.dir = Direction.Down;
            } else {
                snake.dir = Direction.Top;
            }
        }
        this.invalidate();
        return true;
    }
    // move the snake, check whether there is crash,  whether the snake can eat fruits, whether to molt.
    @Override
    public void run() {
        snake.snake_move();
        check_crash();
        fruits=snake.eat(fruits);
        snake.snake_molt();
        this.invalidate();
        timer.postDelayed(this,snake.getDelay());
    }


    //check whether the snake was hit the wall, molted fur or hit itself. If hitted, initialize a new snake.

    private void check_crash(){
        for(int i=1;i<snake.snake_container.size();i++){
            if(Snake_Body.pointequal(snake.snake_container.get(0),snake.snake_container.get(i))){
                Toast.makeText(getContext(), "GAME OVER!", Toast.LENGTH_LONG).show();
                snake=new Snake_Body(new Point( (float) (2.5*width),half_gap+width/2),width);
                snake.set_MoveDistance(width);
                snake.set_COLNUM(COL_NUM);
                snake.set_halgap(half_gap);
            }
        }
        if((this.snake.snake_container.get(0).x>=screen_width || (this.snake.snake_container.get(0).y>=screen_height-half_gap)||(this.snake.snake_container.get(0).x<=0))||(this.snake.snake_container.get(0).y<=half_gap)){
            Toast.makeText(getContext(), "GAME OVER!", Toast.LENGTH_LONG).show();
            snake=new Snake_Body(new Point( (float) (2.5*width),half_gap+width/2),width);
            snake.set_MoveDistance(width);
            snake.set_COLNUM(COL_NUM);
            snake.set_halgap(half_gap);
        }

        for(Point p: snake.molt.get() ){
            if(Snake_Body.pointequal(snake.snake_container.get(0),p)){
                Toast.makeText(getContext(), "GAME OVER!", Toast.LENGTH_LONG).show();
                Toast.makeText(getContext(), "GAME OVER!", Toast.LENGTH_LONG).show();
                snake=new Snake_Body(new Point( (float) (2.5*width),half_gap+width/2),width);
                snake.set_MoveDistance(width);
                snake.set_COLNUM(COL_NUM);
                snake.set_halgap(half_gap);

            }
        }

    }

}
