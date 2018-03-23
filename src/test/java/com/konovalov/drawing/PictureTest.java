package com.konovalov.drawing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ekonovalov on 23.03.2018.
 */
public class PictureTest {

    @Test
    public void apply() throws Exception {
        Canvas c = new Canvas(20, 4);

        new Line(1,2, 6,2).apply(c);
        new Line(6,3, 6,4).apply(c);

        new Rect(14, 1, 18, 3).apply(c);

        new Fill(10,3, 'o').apply(c);

        assertEquals(c.toString(),
                "----------------------\n" +
                        "|oooooooooooooxxxxxoo|\n" +
                        "|xxxxxxooooooox   xoo|\n" +
                        "|     xoooooooxxxxxoo|\n" +
                        "|     xoooooooooooooo|\n" +
                        "----------------------");
    }

}
