package dev.firstPerson;

/**
 * Created by NewLease on 13/08/2014.
 */
public class Map {

    public int width, height;
    public int[] wallGrid;

    public Map(int width, int height){

        this.width = width;
        this.height = height;

        wallGrid = new int[width * height];
    }
}
