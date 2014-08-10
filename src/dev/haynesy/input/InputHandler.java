package dev.haynesy.input;

import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: Haynesy
 * Date: 10/08/2014
 * Time: 10:35 AM
 */
public class InputHandler implements MouseListener, MouseMotionListener, KeyListener {
    public boolean[] keys;
    public boolean closed;

    public InputHandler(){
        keys = new boolean[256];

        for(int i = 0; i < keys.length; i++)
            keys[i] = false;

        closed = false;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyChar()] = true;

        if(e.getKeyChar() == KeyEvent.VK_ESCAPE)
            closed = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyChar()] = false;
    }
}
