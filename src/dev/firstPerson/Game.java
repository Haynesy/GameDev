package dev.firstPerson;

import dev.haynesy.input.Input;
import dev.haynesy.ui.Bitmap;

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


    public void updateInput(Input input) {

        if(input.up.down) player.y -= 1;
        if(input.down.down) player.y += 1;
        if(input.left.down) player.x -= 1;
        if(input.right.down) player.x += 1;

        player.move();
    }
}
