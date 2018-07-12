package com.example.hahaha.amazing_snake;

import java.util.ArrayList;

/**
 * Created by HAHAHA on 17/05/2018.
 */

public class Molt {
    ArrayList<Point> molt;
    //molt is a arraylist of point.
    public Molt(){
        molt=new ArrayList<>();
    }
    public void addAll(ArrayList<Point> points){
        molt.addAll(points);
    }
    public ArrayList<Point> get(){
        return molt;
    }
}
