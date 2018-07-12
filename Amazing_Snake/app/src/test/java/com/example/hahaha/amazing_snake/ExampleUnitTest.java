package com.example.hahaha.amazing_snake;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {
    private  Snake_Body snake_body=new Snake_Body(new Point(0,0),400);;
    @Test
    public void snake_initTest() throws Exception {
        assertEquals(snake_body.snake_container.size(), 3);
        assertEquals(snake_body.dir, Direction.Right);
    }
}