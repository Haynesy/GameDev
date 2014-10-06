package dev.haynesy.input;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Haynesy
 * Date: 11/09/2014
 * Time: 3:39 PM
 */
public class Input {

    private List<Key> keys = new ArrayList<Key>();
    public boolean closed;
    public boolean leftClicked, rightClicked, middleClicked;
    private boolean leftMouseButton, rightMouseButton, middleMouseButton;
    int x, y;
    private boolean onScreen;


    public static class Key {
    		public int[] bindings = new int[0];
    		public boolean wasDown;
    		public boolean down;
    		public boolean typed;
            public boolean toggled;

        public Key(Input input) {
    			input.keys.add(this);
    		}

    		public Key bind(int key) {
    			int[] newBindings = new int[bindings.length + 1];
    			System.arraycopy(bindings, 0, newBindings, 0, bindings.length);
    			newBindings[bindings.length] = key;
    			bindings = newBindings;
    			return this;
    		}

    		public void tick(boolean[] keysDown) {
    			wasDown = down;
    			down = false;
    			for (int i = 0; i < bindings.length; i++) {
    				if (keysDown[bindings[i]]) down = true;
    			}
    			typed = !wasDown && down;

                if(typed)
                    toggled = !toggled;
    		}
    	}


    public Key up = new Key(this).bind(KeyEvent.VK_UP).bind(KeyEvent.VK_W);
    public Key down = new Key(this).bind(KeyEvent.VK_DOWN).bind(KeyEvent.VK_S);
    public Key left = new Key(this).bind(KeyEvent.VK_LEFT).bind(KeyEvent.VK_A);
    public Key right = new Key(this).bind(KeyEvent.VK_RIGHT).bind(KeyEvent.VK_D);
    public Key tilde = new Key(this).bind(KeyEvent.VK_I);


    public void update(int xMousePos, int yMousePos,
       boolean leftMouseButton, boolean rightMouseButton, boolean middleMouseButton,
       boolean[] keysDown, boolean onScreen) {

        leftClicked = !this.leftMouseButton && leftMouseButton;
        rightClicked = !this.rightMouseButton && rightMouseButton;
        middleClicked = !this.middleMouseButton && middleMouseButton;

        this.leftMouseButton = leftMouseButton;
        this.rightMouseButton = rightMouseButton;
        this.middleMouseButton = middleMouseButton;

        this.onScreen = onScreen;
        this.x = xMousePos;
        this.y = yMousePos;

        if(keysDown[KeyEvent.VK_ESCAPE])
            closed = true;

        for (Key key : keys) {
            key.tick(keysDown);
        }
    }

    @Override
    public String toString(){
        return "Closed: "+ closed +"\n";
    }
}
