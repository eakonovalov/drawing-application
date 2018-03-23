package com.konovalov.drawing;

/**
 * Created by ekonovalov on 23.03.2018.
 */
public class Line implements Command {

    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) throws IllegalArgumentException {
        this.x1 = (x1 < x2 ? x1 : x2) - 1;
        this.y1 = (y1 < y2 ? y1 : y2) - 1;
        this.x2 = (x1 < x2 ? x2 : x1) - 1;
        this.y2 = (y1 < y2 ? y2 : y1) - 1;
    }

    public Canvas apply(Canvas c) throws IllegalArgumentException {
        if(x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0) throw new IllegalArgumentException("Illegal coordinates");
        if(x1 != x2 && y1 != y2) throw new IllegalArgumentException("Not a horizontal or vertical line");
        if(x2 >= c.getWidth() || y2 >= c.getHeight()) throw new IllegalArgumentException("Out of canvas");

        for(int i = (x1 != x2 ? x1 : y1); i <= (x1 != x2 ? x2 : y2); i++) {
            c.getPicture()[x1 != x2 ? i : x1][x1 != x2 ? y1 : i] = 'x';
        }

        return c;
    }

}
