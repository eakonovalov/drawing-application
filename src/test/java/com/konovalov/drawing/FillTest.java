package com.konovalov.drawing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ekonovalov on 23.03.2018.
 */
public class FillTest {

    @Test
    public void apply() throws Exception {
        Canvas c = new Canvas(20, 4);

        new Fill(10,3, 'o').apply(c);

        assertEquals(c.toString(),
                "----------------------\n" +
                        "|oooooooooooooooooooo|\n" +
                        "|oooooooooooooooooooo|\n" +
                        "|oooooooooooooooooooo|\n" +
                        "|oooooooooooooooooooo|\n" +
                        "----------------------");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeX() throws Exception {
        new Fill(-1, 1, ' ').apply(new Canvas(20, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroX() throws Exception {
        new Fill(0, 1, ' ').apply(new Canvas(20, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeY() throws Exception {
        new Fill(1, -1, ' ').apply(new Canvas(20, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroY() throws Exception {
        new Fill(1, 0, ' ').apply(new Canvas(20, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testXOutOfCanvas() throws Exception {
        new Fill(21, 1, ' ').apply(new Canvas(20, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testYOutOfCanvas() throws Exception {
        new Fill(1, 5, ' ').apply(new Canvas(20, 4));
    }

}