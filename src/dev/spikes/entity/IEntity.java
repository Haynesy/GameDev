package dev.spikes.entity;

/**
 * Created by NewLease on 3/11/2014.
 */
public interface IEntity {

    public void draw();
    public void update(int delta);
    public void setLocation(double x, double y);
    public void setX(double x);
    public void setY(double y);
    public void setWidth(double width);
    public void setHeight(double height);
    public double getX();
    public double getY();
    public double getWidth();
    public double getHeight();
    public boolean intersects(IEntity other);

}
