package com.konovalov.drawing;

/**
 * Created by ekonovalov on 23.03.2018.
 */
public interface Command {

    Canvas apply(Canvas c) throws IllegalArgumentException;

}
