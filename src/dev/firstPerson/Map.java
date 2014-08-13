package dev.firstPerson;

import dev.haynesy.ui.Bitmap;

/**
 * Created by NewLease on 13/08/2014.
 */
public class Map {

    public int width, height;
    public int[] wallGrid;
    public Bitmap skybox;
    public Bitmap light;

    public Map(int width, int height){

        this.width = width;
        this.height = height;

        wallGrid = new int[width * height];
    }

    public void update() {

    }
}
