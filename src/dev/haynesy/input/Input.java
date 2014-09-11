package dev.haynesy.input;

import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Haynesy
 * Date: 11/09/2014
 * Time: 3:39 PM
 */
public class Input {

    public boolean closed;
    public boolean leftClicked, rightClicked, middleClicked;
    private boolean leftMouseButton, rightMouseButton, middleMouseButton;
    private boolean onScreen;

    public void update(int xMousePos, int yMousePos,
       boolean leftMouseButton, boolean rightMouseButton, boolean middleMouseButton,
       boolean[] keys, boolean onScreen) {

        leftClicked = !this.leftMouseButton && leftMouseButton;
        rightClicked = !this.rightMouseButton && rightMouseButton;
        middleClicked = !this.middleMouseButton && middleMouseButton;

        this.leftMouseButton = leftMouseButton;
        this.rightMouseButton = rightMouseButton;
        this.middleMouseButton = middleMouseButton;

        this.onScreen = onScreen;

        if(keys[KeyEvent.VK_ESCAPE])
            closed = true;
    }

    @Override
    public String toString(){
        return "Closed: "+ closed +"\n";
    }
}
