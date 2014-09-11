package dev.firstPerson;

import dev.haynesy.ui.Bitmap;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Haynesy
 * Date: 17/08/2014
 * Time: 2:31 PM
 */
public class MiniMap extends Bitmap {

    private final int width;
    private final int[] colors;
    private final int height;
    private final int cellsAcross;
    private final int cellsDown;
    public final int cellWidth;
    public final int cellHeight;
    public final int[][] map;
    private ArrayList<Player> players;

    public MiniMap(int[][] map, int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;

        this.map = map;

        players = new ArrayList<Player>();

        cellsAcross = map[0].length;
        cellsDown = map.length;
        cellWidth = width / cellsAcross;
        cellHeight = height / cellsDown;
        colors = new int[]{0xffffff00, 0xffff00ff, 0xff00ffff, 0x000000ff};
    }

    public void draw() {

        Bitmap block = new Bitmap(cellWidth, cellHeight);

        for (int y = 0; y < cellsDown; y++) {

            for (int x = 0; x < cellsAcross; x++) {

                block.fill(0x00000000);
                int cell = map[y][x];

                if (cell != -1)
                    block.fill(colors[cell]);

                render(block, cellWidth * x, cellHeight * y);
            }
        }

        for(Player player : players){
            render(player.image,
                    (int) player.x * cellWidth,
                    (int) player.y * cellHeight);
        }
    }

    public void registerPlayer(Player player) {
        players.add(player);
    }
}
