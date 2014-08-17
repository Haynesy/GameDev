package dev.firstPerson;

import dev.haynesy.ui.Bitmap;

/**
 * Created by NewLease on 13/08/2014.
 */
public class Player {

    public float x, y;

    public Player(float x, float y, int width, int height){

        this.x = x;
        this.y = y;
        Bitmap player = new Bitmap(width, height);
        //player.circle(0, 0, (int) (width / 2), 0xff0000ff);
    }

    public void draw(MiniMap miniMap){

        /*
        x pos on minimap
        y pos on minimap
        draw a circle for the player

         */
    }
}
