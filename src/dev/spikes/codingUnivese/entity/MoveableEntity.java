package dev.spikes.codingUnivese.entity;

/**
 * Created by NewLease on 3/11/2014.
 */
public abstract class MoveableEntity extends Entity implements IMoveableEntity {
    private double dx, dy;

    public MoveableEntity(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.dx = 0;
        this.dy = 0;
    }

    @Override
    public double getDX() {
        return dx;
    }

    @Override
    public double getDY() {
        return dy;
    }

    @Override
    public void setDX(double x) {
        this.dx = x;
    }

    @Override
    public void setDY(double y) {
        this.dy = y;
    }

    @Override
    public void update(int delta) {
        this.x += delta * dx;
        this.y += delta * dy;
    }
}
