package dev.firstPerson;

import dev.haynesy.ui.Bitmap;

/**
 * Created by NewLease on 13/08/2014.
 */
public class Player {

    public final Bitmap image;
    private final MiniMap miniMap;
    public float x, y;
    public float direction, angle, speed, movementSpeed, turnSpeed;

    public Player(float x, float y, int width, int height, MiniMap miniMap){

        this.x = x;
        this.y = y;

        direction = 0;
        angle = 0;
        speed = 0;
        movementSpeed = 0.1f;
        turnSpeed = (float) (4 * Math.PI / 180);

        image = createPlayer(width, height);

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

        Bitmap result = new Bitmap(width, height);

        // TODO add player icon

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

        // TODO: Render player screen projection
        // miniMap.context.fillRect(leftTop, rightTop, leftBottom, rightBottom);

    }
}
