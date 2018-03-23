package com.konovalov.drawing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ekonovalov on 23.03.2018.
 */
public class RectTest {

    @Test
    public void testApply() throws Exception {
        Canvas c = new Canvas(20, 4);

        new Rect(14, 1, 18, 3).apply(c);

        assertEquals(c.toString(),
                "----------------------\n" +
                        "|             xxxxx  |\n" +
                        "|             x   x  |\n" +
                        "|             xxxxx  |\n" +
                        "|                    |\n" +
                        "----------------------");
    }

    @Test
    public void testInvert() throws Exception {
        Canvas c = new Canvas(20, 4);

        new Rect(18, 3, 14, 1).apply(c);

        assertEquals(c.toString(),
                "----------------------\n" +
                        "|             xxxxx  |\n" +
                        "|             x   x  |\n" +
                        "|             xxxxx  |\n" +
                        "|                    |\n" +
                        "----------------------");
    }

    @Test
    public void testDot() throws Exception {
        Canvas c = new Canvas(20, 4);
        new Rect(2,2, 2,2).apply(c);

        assertEquals(c.toString(),
                "----------------------\n" +
                        "|                    |\n" +
                        "| x                  |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "----------------------");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeX1() throws Exception {
        Canvas c = new Canvas(20, 4);
        new Rect(-1, 1,1,1).apply(c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroX1() throws Exception {
        Canvas c = new Canvas(20, 4);
        new Rect(0, 1,1, 1).apply(c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeY1() throws Exception {
        Canvas c = new Canvas(20, 4);
        new Rect(1, -1,1,1).apply(c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroY1() throws Exception {
        Canvas c = new Canvas(20, 4);
        new Rect(1, 0,1, 1).apply(c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeX2() throws Exception {
        Canvas c = new Canvas(20, 4);
        new Rect(1, 1,-1,1).apply(c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroX2() throws Exception {
        Canvas c = new Canvas(20, 4);
        new Rect(1, 1,0, 1).apply(c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeY2() throws Exception {
        Canvas c = new Canvas(20, 4);
        new Rect(1, 1,1,-1).apply(c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroY2() throws Exception {
        Canvas c = new Canvas(20, 4);
        new Rect(1, 1,1, -1).apply(c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testX2OutOfCanvas() throws Exception {
        Canvas c = new Canvas(20, 4);
        new Rect(1, 1,21, 1).apply(c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testY2OutOfCanvas() throws Exception {
        Canvas c = new Canvas(20, 4);
        new Rect(1, 1,1, 5).apply(c);
    }

}