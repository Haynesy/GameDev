package dev.spikes.pong;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by NewLease on 3/11/2014.
 */
public class App {

    private final String title = "Pong 0.1.0";
    private final Random random;
    public int WIDTH = 640;
    public int HEIGHT = 480;
    private boolean running;

    public App(){

        initDisplay();
        initOpenGl();

        running = true;
        random = new Random();

        run();
    }

    private void run() {

        while(running){

            updateInput();
            updateEntities();
            render();


            Display.update();
            Display.sync(60);
        }

        Display.destroy();

        System.out.println("Finished!");
        System.exit(0); // Mac
    }

    private void render() {
        glBegin(GL_POINTS);

        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < HEIGHT; y++){
                glColor3f(random.nextFloat(), random.nextFloat(), random.nextFloat());
                glVertex2i(x, y);
            }
        }

        glEnd();
    }

    private void updateEntities() {

    }

    private void updateInput() {
        if(Display.isCloseRequested())
            running = false;

        while(Keyboard.next()){
            if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
                running = false;
        }
    }

    private void initOpenGl() {

        glEnable(GL_TEXTURE_2D);

        glViewport(0, 0, WIDTH, HEIGHT);
        glMatrixMode(GL_PROJECTION);

        glLoadIdentity();
        glOrtho(0, WIDTH, HEIGHT, 0, -1, 1);

        glMatrixMode(GL_MODELVIEW);
    }

    private void initDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.setTitle(title);
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new App();
    }
}
