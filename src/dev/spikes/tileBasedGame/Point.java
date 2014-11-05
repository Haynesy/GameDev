package dev.spikes.tileBasedGame;

/**
 * Created by NewLease on 5/11/2014.
 */
public class Point {
    public float y;
    public float x;
    private float speed;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = 1f;

    }

    public void move(int x, int y, int[][] map) {

        // add speed by checking for intersection
        int xPos = (int) (this.x + (x * speed));
        int yPos = (int) (this.y + (y * speed));

        if(map[yPos][xPos] == 1)
            return;

        this.x += (x * speed);
        this.y += (y * speed);
    }
}
