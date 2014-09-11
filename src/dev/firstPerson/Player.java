package dev.firstPerson;

import dev.haynesy.ui.Bitmap;

import java.util.Random;

/**
 * Created by NewLease on 13/08/2014.
 */
public class Player {

    public final Bitmap image;
    private final MiniMap miniMap;
    public float x, y;
    public float direction, angle, speed, movementSpeed, turnSpeed;

    public Player(float x, float y, MiniMap miniMap){

        this.x = x;
        this.y = y;

        direction = 0;
        angle = 0;
        speed = 0;
        movementSpeed = 0.1f;
        turnSpeed = (float) (4 * Math.PI / 180);

        image = createPlayer(miniMap.cellWidth, miniMap.cellHeight);

        this.miniMap = miniMap;
    }

    public void move(){
        float moveStep = speed * movementSpeed;
        angle += direction * turnSpeed;
        float xPos = (float) (x + Math.cos(angle) * moveStep);
        float yPos = (float) (x + Math.sin(angle) * moveStep);
        if(!containsBlock(xPos, yPos)) {
            x = xPos;
            y = yPos;
        }

    }

    private boolean containsBlock(float xPos, float yPos) {
        int yMapPos = (int) Math.floor(y);
        int xMapPos = (int) Math.floor(x);

        return (miniMap.map[yMapPos][xMapPos] != -1);
    }

    private Bitmap createPlayer(int width, int height) {

        Random random = new Random();
        Bitmap result = new Bitmap(width, height);

        for(int i = 0; i < result.pixels.length; i++)
            result.pixels[i] = random.nextInt();

        return result;
    }

    public void draw(){

        // Minimap
        int xPos = (int) x * miniMap.cellWidth;
        int yPos = (int) y * miniMap.cellHeight;
        miniMap.render(image, xPos, yPos);

        int projectedX = (int) (x + Math.cos(angle));
        int projectedY = (int) (y + Math.sin(angle));

        int leftTop = miniMap.cellWidth * projectedX - miniMap.cellWidth / 4;
        int rightTop = miniMap.cellHeight * projectedY - miniMap.cellHeight / 4;
        int leftBottom = miniMap.cellWidth / 2;
        int rightBottom = miniMap.cellHeight / 2;

//        Print.line("Left Top: "+ leftTop);
//        Print.line("Right Top: "+ rightTop);
//        Print.line("Left Bottom: "+ leftBottom);
//        Print.line("Right Bottom: "+ rightBottom);

        // TODO redner point
    }
}
