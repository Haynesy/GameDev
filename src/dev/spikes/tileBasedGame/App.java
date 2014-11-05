package dev.spikes.tileBasedGame;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by NewLease on 5/11/2014.
 */

// Tutorial Tile Based Games in flash - Part 1
// http://oos.moxiecode.com/blog/index.php/tutorials/tilebased-games-in-flash-5-part-2/

public class App {


    private int WIDTH = 240;
    private int HEIGHT = 160;
    private int SIZE = 3;

    private String title;
    private boolean running;
    int[][] map;
    private int tileWidth, tileHeight;
    private Point hero;


    public App(){

        initGame();
        initDisplay();
        initOpenGl();

        run();
    }

    private void initGame() {
        map = new int[][]{
            {1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,1},
            {1,0,1,0,0,0,0,1},
            {1,0,0,0,0,1,0,1},
            {1,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1}};

        running = true;
        title = "App 0.1.0";

        tileWidth = 16;
        tileHeight = 16;

        hero = new Point(2, 3);
    }

    private void run() {
        while(running){

            input();
            render();

            Display.update();
            Display.sync(60);
        }

        Display.destroy();
        System.out.println("Done!");
        System.exit(0);
    }

    private void render() {
        glClear(GL_COLOR_BUFFER_BIT);


        glBegin(GL_QUADS);
            buildMap(map);


            int xPos = hero.x * tileWidth;
            int yPos = hero.y * tileHeight;

            glColor3f(1.0f, 0.0f, 0.0f);
            glVertex2i(xPos, yPos);
            glVertex2i(xPos + tileWidth, yPos);
            glVertex2i(xPos + tileWidth, yPos + tileHeight);
            glVertex2i(xPos, yPos + tileHeight);

        glEnd();
    }

    private void buildMap(int[][] map) {

        System.out.println();
        int mapWidth = map[0].length;
        int mapHeight = map.length;

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {

                float color = map[y][x];
                glColor3f(color, color, color);

                int xPos = x * tileWidth;
                int yPos = y * tileHeight;

                glVertex2i(xPos, yPos);
                glVertex2i(xPos + tileWidth, yPos);
                glVertex2i(xPos + tileWidth, yPos + tileHeight);
                glVertex2i(xPos, yPos + tileHeight);
            }
        }

    }

    private void input() {
        if(Display.isCloseRequested())
            running = false;

        while(Keyboard.next()){
            if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
                running = false;
        }
    }

    private void initOpenGl() {
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);

        glClearColor(0.2f, 0.2f, 0.2f, 1.0f);

        glViewport(0, 0, WIDTH * SIZE, HEIGHT * SIZE);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();

        glOrtho(0, WIDTH * SIZE, HEIGHT * SIZE, 0 , -1, 1);

        glMatrixMode(GL_MODELVIEW);
    }

    private void initDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH * SIZE, HEIGHT * SIZE));
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
