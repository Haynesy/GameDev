package dev.haynesy.input;

import java.awt.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: Haynesy
 * Date: 10/08/2014
 * Time: 10:35 AM
 */
public class InputHandler implements MouseListener, MouseMotionListener, KeyListener {
    private final Canvas canvas;
    public boolean[] keys;
    private Input input;
    private int xMousePos, yMousePos;
    private boolean onScreen;
    private boolean mouseButton0, mouseButton1, mouseButton2;

    public InputHandler(Canvas canvas){
        keys = new boolean[65536];
        input = new Input();
        this.canvas = canvas;

        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
        canvas.addKeyListener(this);
    }
    @Override
    public synchronized void mouseClicked(MouseEvent e) {

    }

    @Override
    public synchronized void mousePressed(MouseEvent e) {
        xMousePos = e.getX();
        yMousePos = e.getY();
        onScreen = xMousePos >= 0 && yMousePos >= 0 && xMousePos < canvas.getWidth() && yMousePos < canvas.getHeight();
        if (e.getButton() == MouseEvent.BUTTON1) mouseButton0 = true;
        if (e.getButton() == MouseEvent.BUTTON3) mouseButton1 = true;
        if (e.getButton() == MouseEvent.BUTTON2) mouseButton2 = true;
    }

    @Override
    public synchronized void mouseReleased(MouseEvent e) {
        xMousePos = e.getX();
        yMousePos = e.getY();
        onScreen = xMousePos >= 0 && yMousePos >= 0 && xMousePos < canvas.getWidth() && yMousePos < canvas.getHeight();
        if (e.getButton() == MouseEvent.BUTTON1) mouseButton0 = false;
        if (e.getButton() == MouseEvent.BUTTON3) mouseButton1 = false;
        if (e.getButton() == MouseEvent.BUTTON2) mouseButton2 = false;
    }

    @Override
    public synchronized void mouseEntered(MouseEvent e) {
        xMousePos = e.getX();
        yMousePos = e.getY();
        onScreen = true;
    }

    @Override
    public synchronized void mouseExited(MouseEvent e) {
        xMousePos = e.getX();
        yMousePos = e.getY();
        onScreen = false;
    }

    @Override
    public synchronized void mouseDragged(MouseEvent e) {
        xMousePos = e.getX();
        yMousePos = e.getY();
        onScreen = true;
    }

    @Override
    public synchronized void mouseMoved(MouseEvent e) {
        xMousePos = e.getX();
        yMousePos = e.getY();
        onScreen = true;
    }

    @Override
    public synchronized void keyTyped(KeyEvent e) {

    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {

        if (e.getKeyCode() > 0 && e.getKeyCode() < keys.length)
            keys[e.getKeyCode()] = true;
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        if (e.getKeyCode() > 0 && e.getKeyCode() < keys.length)
            keys[e.getKeyCode()] = false;
    }

    public synchronized Input updateInput(int scale){
        input.update(xMousePos / scale, yMousePos / scale, mouseButton0, mouseButton1, mouseButton2, keys, onScreen);
        return input;
    }
}
