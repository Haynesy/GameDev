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
    private int mapMultiplier;


    public App(){

        initGame();
        initDisplay();
        initOpenGl();

        run();
    }

    private void initGame() {

        tileWidth = 16;
        tileHeight = 16;
        mapMultiplier = 4;

        int mapY = HEIGHT * SIZE / tileHeight * mapMultiplier;
        int mapX = WIDTH * SIZE / tileWidth * mapMultiplier;

        map = new int[mapY][mapX];

        for(int y = 0; y < mapY; y++){
            for(int x = 0; x < mapX; x++){

                if(x == 0 || y == 0 || x == mapX - 1 || y == mapY - 1){
                    map[y][x] = 1;
                    continue;
                }

                map[y][x] = 0;

            }
        }


//                {
//            {1,1,1,1,1,1,1,1},
//            {1,0,0,0,0,0,0,1},
//            {1,0,1,0,0,0,0,1},
//            {1,0,0,0,0,1,0,1},
//            {1,0,0,0,0,0,0,1},
//            {1,1,1,1,1,1,1,1}};

        running = true;
        title = "App 0.1.0";



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
            renderHero();

        glEnd();
    }

    private void renderHero() {
        float xPos = (float) Math.floor(hero.x * tileWidth);
        float yPos = (float) Math.floor(hero.y * tileHeight);

        int shrink = (int) Math.floor(tileWidth / 4.0f);

        glColor3f(1.0f, 0.0f, 0.0f);
        glVertex2f(xPos + shrink, yPos + shrink);
        glVertex2f(xPos + tileWidth - shrink, yPos + shrink);
        glVertex2f(xPos + tileWidth - shrink, yPos + tileHeight - shrink);
        glVertex2f(xPos + shrink, yPos + tileHeight - shrink);
    }

    private void buildMap(int[][] map) {

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

            if(Keyboard.isKeyDown(Keyboard.KEY_W))
                hero.move(0, -1, map);
            if(Keyboard.isKeyDown(Keyboard.KEY_S))
                hero.move(0, 1, map);
            if(Keyboard.isKeyDown(Keyboard.KEY_A))
                hero.move(-1, 0, map);
            if(Keyboard.isKeyDown(Keyboard.KEY_D))
                hero.move(1, 0, map);

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
