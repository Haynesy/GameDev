package dev.spikes;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by NewLease on 31/10/2014.
 */
public class App implements Runnable {
    private static boolean running;


    private String title = "App 0.1.0";
    public int WIDTH = 640;
    public int HEIGHT = 480;
    private boolean showConsole;
    private Box box;
    private Random random;

    private long lastFrame;
    private long getTime(){
        return Sys.getTime() * 1000 / Sys.getTimerResolution();
    }

    // Used to maintain constant time without depending on frame rate
    private int getDelta(){

        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = currentTime;

        return delta;
    }


    public App(){

        initDisplay();
        initOpenGl();

        box = new Box(10, 10, 100, 100);
        box.setDX(0.2);
        box.setDY(0.2);

        showConsole = false;
        running = true;
        random = new Random();

        lastFrame = getTime(); // Initial delta

        run();
    }

    private void initDisplay() {
        DisplayMode displayMode = new DisplayMode(WIDTH, HEIGHT);

        try {
            Display.setDisplayMode(displayMode);
            Display.setTitle(title);
            Display.create();
        } catch (LWJGLException exception){
            exception.printStackTrace();
        }

        if(Display.isFullscreen())
            Display.setVSyncEnabled(true);
    }

    private void initOpenGl() {
        glMatrixMode(GL_PROJECTION); // Switch to projection

        glLoadIdentity(); // Reset
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1); // Set up projection

        glMatrixMode(GL_MODELVIEW); // Switch back to model view
        glEnable(GL_TEXTURE_2D);
    }

    public static void main(String[] args){

        new App();
    }

    public void run() {
        while(running){

            int delta = getDelta();
            input(delta);

            tick(delta);

            glClear(GL_COLOR_BUFFER_BIT); // | GL_DEPTH_BUFFER_BIT
            render();

            // LWJGL Update
            Display.update();
            Display.sync(60);
        }
        System.out.println("Done!");
        Display.destroy();
        System.exit(0);
    }

    private void tick(int delta) {

        // Update all entities
        box.update(delta);
    }

    private void render() {

        glBegin(GL_POINTS);
        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < WIDTH; y++){
                glColor3f(random.nextFloat(), random.nextFloat(), random.nextFloat());
                glVertex2i(x, y);
            }
        }
        glEnd();

        box.draw();

        if(showConsole){
            // Show information
        }
    }

    private void input(int delta) {
        if(Display.isCloseRequested())
            running = false;

        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
            running = false;

        if(Keyboard.isKeyDown(Keyboard.KEY_I))
            showConsole = true;

        //box.setPosition(Mouse.getX(), HEIGHT - Mouse.getY());


    }
}
