package dev.firstPerson;

import dev.haynesy.ui.Bitmap;

/**
 * Created by NewLease on 13/08/2014.
 */
public class Player {

    public int x, y, direction;
    public Bitmap weapon;
    public int paces;

    public Player(int x, int y, int direction){

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
