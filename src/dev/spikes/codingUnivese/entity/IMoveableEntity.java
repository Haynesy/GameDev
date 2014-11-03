package dev.spikes.codingUnivese.entity;

/**
 * Created by NewLease on 3/11/2014.
 */
public interface IMoveableEntity extends IEntity {
    public double getDX();
    public double getDY();
    public void setDX(double x);
    public void setDY(double y);

}
