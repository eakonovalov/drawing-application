package com.konovalov.drawing;

/**
 * Created by ekonovalov on 23.03.2018.
 */
public class Rect implements Command {

    private int x1, y1, x2, y2;

    public Rect(int x1, int y1, int x2, int y2) {
        this.x1 = (x1 < x2 ? x1 : x2) - 1;
        this.y1 = (y1 < y2 ? y1 : y2) - 1;
        this.x2 = (x1 < x2 ? x2 : x1) - 1;
        this.y2 = (y1 < y2 ? y2 : y1) - 1;
    }

    public Canvas apply(Canvas c) {
        if(x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0) throw new IllegalArgumentException("Illegal coordinates");
        if(x2 >= c.getWidth() || y2 >= c.getHeight()) throw new IllegalArgumentException("Out of canvas");

        for(int i = x1; i <= x2; i++) {
            c.getPicture()[i][y1] = 'x';
            c.getPicture()[i][y2] = 'x';
        }
        for(int j = y1 + 1; j < y2; j++) {
            c.getPicture()[x1][j] = 'x';
            c.getPicture()[x2][j] = 'x';
        }

        return c;
    }

}
