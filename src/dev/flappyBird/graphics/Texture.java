package dev.flappyBird.graphics;

import dev.flappyBird.util.BufferUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by NewLease on 26/08/2014.
 */
public class Texture {

    private int width, height;
    private int textureId;

    public Texture(String path){
        textureId = load(path);
    }

    public int load(String path){

        BufferedImage image;

        try {
            image = ImageIO.read(new FileInputStream(path));

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

        width = image.getWidth();
        height = image.getHeight();

        int[] pixels = new int[width * height];
        image.getRGB(0, 0, width, height, pixels, 0, width);

        int[] data = new int[width * height];
        for(int i = 0; i < pixels.length; i++){
            int a = (pixels[i] & 0xff000000) >> 24;
            int r = (pixels[i] & 0x00ff0000) >> 16;
            int b = (pixels[i] & 0x0000ff00) >> 8;
            int g = (pixels[i] & 0x000000ff) >> 0;

            data[i] = (a << 24) | (b << 16) | (g << 8) | (r << 0);
        }

        int texId = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, texId);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height,
                                    0, GL_RGBA,
                    GL_UNSIGNED_BYTE, BufferUtils.createIntBuffer(data));

        glBindTexture(GL_TEXTURE_2D, 0);

        return texId;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getTextureId(){
        return textureId;
    }
}
