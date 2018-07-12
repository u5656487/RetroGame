package com.example.hahaha.amazing_snake;

import java.util.ArrayList;

public class Snake_Body {
    ArrayList<Point> snake_container;
    Direction dir;
    float x;
    float y;
    int snake_move_delay=1000;
    float snake_move_distance;
    int COLNUM;
    float halfgap;
    int molting=0;
    Molt molt;
    int delay_time=0;
    Fruits new_fruit;
    // when snake body was created, init the snake with length 3, moving direction to right, and molt.
    public Snake_Body(Point init_Point,float distance) {
        set_MoveDistance(distance);
        Point head = new Point(init_Point.x, init_Point.y);
        Point body1 = new Point(init_Point.x - distance, init_Point.y);
        Point body2 = new Point(init_Point.x - 2*distance,init_Point.y);
        snake_container = new ArrayList<Point>();
        this.snake_container.add(head);
        this.snake_container.add(body1);
        this.snake_container.add(body2);
        dir = Direction.Right;
        molt=new Molt();
    }
    // the function used to change Snake_body's field value, or get the field value
    public void set_X(float x){
        this.x=x;
    }
    public void set_halgap(float x){
        halfgap=x;
    }
    public void set_COLNUM(int x){
        COLNUM=x;
    }
    public void set_MoveDistance(float d){
        snake_move_distance=d;
    }
    public void changeDelay(int time) {
        snake_move_delay = time;
    }
    public int getDelay(){
        return snake_move_delay;
    }

    // eat fruits or not, if the snake can eat the fruit, init a fuit with same type, and somewhere snake can eat. (cannot have the same location of current snake location)
    public ArrayList<Fruits> eat(ArrayList<Fruits>p) {
        for (Fruits fruit : p) {
            if (pointequal(snake_container.get(0),fruit.g)) {
                snake_container.add(fruit.g);
                p.remove(fruit);
                if(fruit.t==FruitType.Banana){
                    changeDelay(200);
                    delay_time=10;
                }
                new_fruit=Fruits.updateFruit(fruit.t,COLNUM,snake_move_distance,halfgap);
                while (snake_container.contains(new_fruit.g) || molt.get().contains(new_fruit) ||p.contains(new_fruit)){
                  new_fruit=Fruits.updateFruit(fruit.t,COLNUM,snake_move_distance,halfgap);
                }
                p.add(new_fruit);
                break;
            }
        }
        return p;
    }


    // Based on direction, decide how the snake will move
    public void snake_move() {
        if(delay_time>0){delay_time--;}
        if(delay_time==0){changeDelay(1000);}
        Point new_head = new Point(0,0);
        if (dir == Direction.Top) {
            new_head.x = this.snake_container.get(0).x;
            new_head.y = this.snake_container.get(0).y - snake_move_distance;
        }
        if (dir == Direction.Down) {
            new_head.x = this.snake_container.get(0).x;
            new_head.y = this.snake_container.get(0).y + snake_move_distance;
        }
        if (dir == Direction.Left) {
            new_head.x = this.snake_container.get(0).x - snake_move_distance;
            new_head.y = this.snake_container.get(0).y;
        }
        if (dir == Direction.Right) {
            new_head.x = this.snake_container.get(0).x + snake_move_distance;
            new_head.y = this.snake_container.get(0).y;
        }
        this.snake_container.add(0, new_head);
        this.snake_container.remove(snake_container.size() - 1);

    }
    // when the snake length can be divided by 4, snake will molt
    public void snake_molt(){
        if(this.snake_container.size()%4==0){
            if(molting==0){molt.addAll(this.snake_container);}molting=1;}
        else{molting=0;}

    }
    // help function, used to check whether the 2 point has same location
    public static Boolean pointequal(Point p1,Point p2){
        if(p1.x==p2.x & p1.y==p2.y){
            return true;
        }
        return false;
    }


}
