package dev.haynesy.ui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Haynesy
 * Date: 10/08/2014
 * Time: 10:33 AM
 */
public class Bitmap {
    private int width;
    private int height;
    public int[] pixels;
    public BufferedImage image;

    public Bitmap(int width, int height) {
        this.width = width;
        this.height = height;

        image = getEmptyImage(width, height);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    }

    public Bitmap(String filename) {

        try {
            BufferedImage tempImage = ImageIO.read(new File("./resources/" + filename));

            this.width = tempImage.getWidth();
            this.height = tempImage.getHeight();
            pixels = new int[width * height];

            image = getEmptyImage(width, height);
            tempImage.getRGB(0, 0, width, height, pixels, 0, width);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap.class.getResource(filename);
    }

    public BufferedImage getEmptyImage(int width, int height) {
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public void render(Bitmap bitmap, int offsetX, int offsetY) {
        int startX = offsetX;
        int startY = offsetY;

        int endX = bitmap.width + offsetX;
        int endY = bitmap.height + offsetY;

        if(startX < 0) startX = 0;
        if(startY < 0) startY = 0;
        if(endX > width) endX = width;
        if(endY > height) endY = height;

        for(int y = startY; y < endY; y++) {

            for (int x = startX; x < endX; x++) {

                int target = (y - offsetY) * bitmap.width + (x - offsetX);

                if(target >= bitmap.pixels.length)
                    continue;

                int color = bitmap.pixels[target];
                pixels[y * width + x] = color;
            }

            System.out.print("\n");
        }

        System.out.print("\n\n");
    }

    public void fill(int color) {
        Arrays.fill(pixels, color);
    }

    @Override
    public String toString(){

        String result = "";
        for(int y = 0; y < height; y++){

            for(int x = 0; x < width; x++){
                result += pixels[x * width + y]+ ", ";
            }
            result += "\n";
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bitmap bitmap = (Bitmap) o;

        if (!Arrays.equals(pixels, bitmap.pixels)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pixels);
    }
}
