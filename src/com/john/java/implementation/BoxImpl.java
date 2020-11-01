package com.john.java.implementation;


import com.john.java.model.Box;

public class BoxImpl implements BoxImplI{
    private final Box box;

    public BoxImpl(Box box) {
        this.box = box;
    }

    @Override
    public double getSurfaceArea() {
        return (2*(box.getLength()*box.getWidth()))
                + (2*(box.getWidth()*box.getHeight()))
                +(2*(box.getLength()*box.getHeight()));
    }

    @Override
    public double getVolume() {
        return box.getHeight()*box.getLength()*box.getWidth();
    }
}
