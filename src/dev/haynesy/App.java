package dev.haynesy;

import dev.haynesy.input.InputHandler;
import dev.haynesy.ui.Bitmap;
import dev.haynesy.util.Print;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * Created by NewLease on 8/08/2014.
 */
public class App extends Canvas implements Runnable {

    public static int WIDTH = 200;
    public static int HEIGHT = 100;
    public static int SCALE = 4;
    public static int FINAL_WIDTH = WIDTH * SCALE;
    public static int FINAL_HEIGHT = HEIGHT * SCALE;

    private static Thread thread;
    private final InputHandler inputHandler;
    protected final Bitmap screen;
    private boolean running;
    protected Random random;

    public App(){
        inputHandler = new InputHandler();
        screen = new Bitmap(WIDTH, HEIGHT);
        random = new Random();

        addMouseListener(inputHandler);
        addMouseMotionListener(inputHandler);
        addKeyListener(inputHandler);
        running = true;
    }

    @Override
    public void run() {
        init();

        int frames = 0;
        double nsPerFrame = 1000000000.0/ 60.0;
        long currentFrameTime = System.currentTimeMillis();
        long lastFrameTime = System.nanoTime();
        double unprocessed = 0;

        while(running){

            long now = System.nanoTime();
            unprocessed += (now - lastFrameTime) / nsPerFrame;
            lastFrameTime = now;

            while(unprocessed >= 1) {
                unprocessed -= 1;
            }

            updateInput();
            tick();
            renderFrame();

            frames++;

            if(System.currentTimeMillis() - currentFrameTime >= 1000){

                Print.line("fps: "+ frames);
                frames = 0;
                currentFrameTime += 1000;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        close();
    }

    private void close() {
        try {
            System.exit(0);
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        requestFocus();

        if(getBufferStrategy() == null)
            createBufferStrategy(3);

    }

    private void renderFrame() {

        BufferStrategy stratedgy = getBufferStrategy();
        Graphics graphics = stratedgy.getDrawGraphics();

        updateScreen();

        graphics.drawImage(screen.image, 0, 0, FINAL_WIDTH, FINAL_HEIGHT, null);

        graphics.dispose();
        stratedgy.show();

    }

    protected void updateScreen() {
        for(int i = 0; i < screen.pixels.length; i++)
            screen.pixels[i] = random.nextInt();
    }

    private void updateInput(){
        if(inputHandler.closed) {
            running = false;
        }
    }

    protected void tick() {

    }

    public static void main(String[] args){
        Print.line("Starting...");

        App.start(new App());

        Print.line("Done!");
    }

    protected static void start(App app) {

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(app);
        frame.setVisible(true);

        frame.pack();
        thread = new Thread(app, "App");
        thread.start();

    }
}
