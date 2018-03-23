package com.konovalov.drawing;

/**
 * Created by ekonovalov on 23.03.2018.
 */
public class Fill implements Command {

    private int x, y;
    private char c;

    public Fill(int x, int y, char c) {
        this.x = x - 1;
        this.y = y - 1;
        this.c = c;
    }

    public Canvas apply(Canvas c) throws IllegalArgumentException {
        if(x < 0 || y < 0) throw new IllegalArgumentException("Illegal coordinates");
        if(x >= c.getWidth() || y >= c.getHeight()) throw new IllegalArgumentException("Out of canvas");

        apply(c.getPicture(), c.getCharAt(x, y), this.c, x, y);

        return c;
    }

    private void apply(char[][] picture, char colorToReplace, char colorToPaint, int x, int y) {
        int currentColor = getValueAt(picture, x, y);
        if (currentColor == colorToReplace) {
            picture[x][y] = colorToPaint;
            apply(picture, colorToReplace, colorToPaint, x + 1, y);
            apply(picture, colorToReplace, colorToPaint, x - 1, y);
            apply(picture, colorToReplace, colorToPaint, x, y + 1);
            apply(picture, colorToReplace, colorToPaint, x, y - 1);
        }
    }

    private int getValueAt(char[][] picture, int x, int y) {
        if (x < 0 || y < 0 || x >= picture.length || y >= picture[x].length) {
            return -1;
        } else {
            return picture[x][y];
        }
    }

}
