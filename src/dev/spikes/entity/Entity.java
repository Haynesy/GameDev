package dev.spikes.entity;

import java.awt.*;

/**
 * Created by NewLease on 3/11/2014.
 */
public abstract class Entity implements IEntity {

    protected double x;
    protected double y;
    protected double width;
    protected double height;
    private Rectangle hitBox = new Rectangle();

    public Entity(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

//    @Override
//    public void draw() {
//
//    }
//
//    @Override
//    public void update(int delta) {
//
//    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public boolean intersects(IEntity other) {

        hitBox.setBounds((int) x, (int) y, (int) width, (int) height);

        return hitBox.intersects(other.getX(),
                                 other.getY(),
                                 other.getWidth(),
                                 other.getHeight());
    }
}
