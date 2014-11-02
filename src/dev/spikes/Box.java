package dev.spikes;

import dev.spikes.entity.MoveableEntity;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.FileInputStream;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by NewLease on 3/11/2014.
 */
public class Box extends MoveableEntity{

    private Texture texture;

    public Box(int x, int y, int width, int height) {
        super(x, y, width, height);

        try {
            texture = TextureLoader.getTexture("png", new FileInputStream("resources/images/pixelart.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public void draw() {
        glColor3f(1.0f, 1.0f, 1.0f);
        texture.bind();

        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex2i((int) x, (int)y);
        glTexCoord2f(0, 1);
        glVertex2i((int)x, (int)(y + height));
        glTexCoord2f(1, 1);
        glVertex2i((int)(x + width), (int) (y + height));
        glTexCoord2f(1, 0);
        glVertex2i((int)(x + width), (int)y);
        glEnd();
    }
}
