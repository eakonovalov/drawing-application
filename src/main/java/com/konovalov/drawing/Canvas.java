package com.konovalov.drawing;

/**
 * Created by ekonovalov on 23.03.2018.
 */
public class Canvas {

    public static final int MAX_WIDTH = 500;
    public static final int MAX_HEIGHT = 500;

    private char[][] arr;

    public Canvas(int width, int height) throws IllegalArgumentException {
        if(width <= 0 || height <= 0) throw new IllegalArgumentException("Illegal canvas size");
        if(width > MAX_WIDTH || height > MAX_HEIGHT) throw new IllegalArgumentException("Too big canvas. Max width = " + MAX_WIDTH + ", max height = " + MAX_HEIGHT);

        arr = new char[width][height];
        for(int i = 0; i < getWidth(); i++) {
            for(int j = 0; j < getHeight(); j++) {
                arr[i][j] = ' ';
            }
        }
    }

    public int getWidth() {
        return arr.length;
    }

    public int getHeight() {
        return arr[0].length;
    }

    public char[][] getPicture() {
        return arr;
    }

    public char getCharAt(int x, int y) {
        return arr[x][y];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < getWidth() + 2; i++) {
            sb.append("-");
        }
        sb.append("\n");
        for(int j = 0; j < getHeight(); j++) {
            sb.append("|");
            for(int i = 0; i < getWidth(); i++) {
                sb.append(arr[i][j]);
            }
            sb.append("|\n");
        }
        for(int i = 0; i < getWidth() + 2; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

}
