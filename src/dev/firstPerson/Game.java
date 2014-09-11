package dev.firstPerson;

import dev.haynesy.input.InputHandler;
import dev.haynesy.ui.Bitmap;
import dev.haynesy.util.Print;

import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Haynesy
 * Date: 17/08/2014
 * Time: 2:09 PM
 */
public class Game {

    private final int[][] map;

    private final MiniMap miniMap;
    private final Player player;

    public Game(){
        map = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
                {1, 1, -1, -1, -1, -1, -1, 0, -1, 2, 3, 1, -1, -1, -1, 1},
                {1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
                {1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
                {1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
                {1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
                {1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
                {1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
                {1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
                {1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
                {1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1, 1},
                {1, -1, 1, -1, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, 1},
                {1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
                {1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };

        miniMap = new MiniMap(map, 300, 300);
        player = new Player(10, 6, miniMap);
        miniMap.registerPlayer(player);
    }

    public void update(Bitmap screen){

        miniMap.draw();
        player.draw();

        screen.render(miniMap, 0, 0);
    }


    public void updateInput(InputHandler inputHandler) {
        Boolean hasMoved = false;
        if(inputHandler.keys[KeyEvent.VK_W]){
            player.y -= 1;
            hasMoved = true;
            inputHandler.keys[KeyEvent.VK_W] = false;
        }
        if(inputHandler.keys[KeyEvent.VK_S]){
            player.y += 1;
            hasMoved = true;
            inputHandler.keys[KeyEvent.VK_S] = false;
        }
        if(inputHandler.keys[KeyEvent.VK_A]){
            player.x -= 1;
            hasMoved = true;
            inputHandler.keys[KeyEvent.VK_A] = false;
        }
        if(inputHandler.keys[KeyEvent.VK_D]){
            player.x += 1;
            hasMoved = true;
            inputHandler.keys[KeyEvent.VK_D] = false;
        }
        if(hasMoved){
            player.move();
        }

        Print.line("Player ("+ player.x +", "+ player.y +")");
    }
}
