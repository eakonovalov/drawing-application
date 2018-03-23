package com.konovalov.drawing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ekonovalov on 23.03.2018.
 */
public class CanvasTest {

    @Test
    public void testCanvas() throws Exception {
        Canvas c = new Canvas(1, 1);

        assertEquals(1, c.getWidth());
        assertEquals(1, c.getHeight());
    }

    @Test
    public void testToString() throws Exception {
        Canvas c = new Canvas(20, 4);

        assertEquals(c.toString(),
                "----------------------\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "----------------------");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWidth() throws Exception {
        new Canvas(-1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroWidth() throws Exception {
        new Canvas(0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeHeight() throws Exception {
        new Canvas(1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroHeight() throws Exception {
        new Canvas(1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooBigWidth() throws Exception {
        new Canvas(Canvas.MAX_WIDTH + 1, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTooBigHeight() throws Exception {
        new Canvas(1, Canvas.MAX_HEIGHT + 1);
    }

}
