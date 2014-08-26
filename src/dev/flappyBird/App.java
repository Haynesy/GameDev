package dev.flappyBird;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by NewLease on 26/08/2014.
 */
public class App implements Runnable {

    private int width = 1280;
    private int height = 720;
    private String title = "App 0.1.0";
    private Boolean running = false;
    private Thread thread;

    public App(){
        running = true;
        thread = new Thread(this, "App 0.1.0");
        thread.start();
    }

    public static void main(String[] args){

        App app = new App();

        System.out.println("Done!");
    }

    @Override
    public void run() {
        try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.setTitle(title);

            ContextAttribs context;
            if(System.getProperty("os.name").contains("Mac"))
                context = new ContextAttribs(3, 2);
            else
                context = new ContextAttribs(3, 3);

            Display.create(new PixelFormat(), context.withProfileCore(true));
        } catch (LWJGLException e) {

            e.printStackTrace();
        }

        init();

        while(running){
            
            render();
            Display.update();

            if(Display.isCloseRequested())
                running  = false;
        }

        Display.destroy();


    }

    private void render() {
        glClear(GL_COLOR_BUFFER_BIT);
    }

    private void init() {
        String version = glGetString(GL_VERSION);
        System.out.println("OpenGL "+ version);

        glClearColor(0.1f, 0.1f, 0.1f, 0.1f); // Clear to white
    }
}
