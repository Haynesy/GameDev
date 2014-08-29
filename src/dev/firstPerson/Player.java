package dev.firstPerson;

import dev.haynesy.ui.Bitmap;

/**
 * Created by NewLease on 13/08/2014.
 */
public class Player {

    public final Bitmap image;
    public float x, y;

    public Player(float x, float y, int width, int height){

        this.x = x;
        this.y = y;
        image = createPlayer(width, height);
    }

    private Bitmap createPlayer(int width, int height) {

        Bitmap result = new Bitmap(width, height);

        // TODO add player icon

        return result;
    }

    public void draw(MiniMap miniMap){

        int xPos = (int) x * miniMap.cellWidth;
        int yPos = (int) y * miniMap.cellHeight;

        miniMap.render(image, xPos, yPos);
    }
}
