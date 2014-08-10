package dev.haynesy.ui;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created with IntelliJ IDEA.
 * User: Haynesy
 * Date: 10/08/2014
 * Time: 10:33 AM
 */
public class Bitmap {
    private final int width;
    private final int height;
    public int[] pixels;
    public BufferedImage image;

    public Bitmap(int width, int height) {
        this.width = width;
        this.height = height;

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    }
}
