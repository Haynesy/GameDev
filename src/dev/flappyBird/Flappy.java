package dev.flappyBird;

import dev.flappyBird.util.ShaderUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

/**
 * Created by NewLease on 26/08/2014.
 */
public class Flappy implements Runnable {

    private int width = 1280;
    private int height = 720;
    private String title = "Flappy 0.1.0";
    private Boolean running = false;
    private Thread thread;

    public Flappy(){
        running = true;
        thread = new Thread(this, "App 0.1.0");
        thread.start();
    }

    public static void main(String[] args){

        Flappy app = new Flappy();

        System.out.println("Done!");
    }

    @Override
    public void run() {
        try {
            Display.setDisplayModeAndFullscreen(new DisplayMode(width, height));

            ContextAttribs context;
            if(System.getProperty("os.name").contains("Mac"))
                context = new ContextAttribs(3, 2);
            else
                context = new ContextAttribs(3, 3);

            Display.create(new PixelFormat(), context.withProfileCore(true));

        } catch (LWJGLException e) {

            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }

        init();

        int vertexArrayObject = glGenVertexArrays();
        glBindVertexArray(vertexArrayObject);
        int shader = ShaderUtils.load("resources/shaders/shader.vert", "resources/shaders/shader.frag");
        glUseProgram(shader);

        while(running){
            
            render();

            if(Display.isCloseRequested())
                running  = false;
        }

        Display.destroy();


    }

    private void render() {

        glClear(GL_COLOR_BUFFER_BIT);
        //glLoadIdentity();

        glDrawArrays(GL_TRIANGLES, 0 , 3);

        // Update LWJGL
        Display.update();
        Display.sync(60);
    }

    private void init() {
        Display.setVSyncEnabled(true);
        Display.setTitle(title);

        String version = glGetString(GL_VERSION);
        System.out.println("OpenGL "+ version);

        glClearColor(0.1f, 0.1f, 0.1f, 0.1f); // Clear to white
    }
}
