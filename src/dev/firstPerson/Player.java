package dev.firstPerson;

import dev.haynesy.ui.Bitmap;

/**
 * Created by NewLease on 13/08/2014.
 */
public class Player {

    public float x, y, direction;
    public Bitmap weapon;
    public int paces;

    public Player(float x, float y, float direction){

        this.x = x;
        this.y = y;
        this.direction = direction;
        weapon = new Bitmap("weapon.png");
        paces = 0;
    }

    public void walk(int distance, Map map){

    }

    public void update() {

    }
}
