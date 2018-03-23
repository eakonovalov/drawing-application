package com.konovalov.drawing;

import asg.cliche.Command;
import asg.cliche.ShellFactory;

import java.io.IOException;

/**
 * Created by ekonovalov on 22.03.2018.
 */
public class Application {

    private Canvas c;

    @Command(name = "C")
    public String canvas(int width, int height) {
        c = new Canvas(width, height);
        return c.toString();
    }

    @Command(name = "L")
    public String line(int x1, int y1, int x2, int y2) {
        try {
            return new Line(x1, y1, x2, y2).apply(c).toString();
        } catch (IllegalArgumentException e) {
            return c + "\n" + e.getMessage();
        }
    }

    @Command(name = "R")
    public String rect(int x1, int y1, int x2, int y2) {
        try {
            return new Rect(x1, y1, x2, y2).apply(c).toString();
        } catch (IllegalArgumentException e) {
            return c + "\n" + e.getMessage();
        }
    }

    @Command(name = "B")
    public String fill(int x1, int y1, String c) {
        try {
            return new Fill(x1, y1, c.charAt(0)).apply(this.c).toString();
        } catch (IllegalArgumentException e) {
            return c + "\n" + e.getMessage();
        }
    }

    @Command(name = "Q")
    public void quit() {
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        ShellFactory.createConsoleShell("hello", "", new Application()).commandLoop();
    }

}
