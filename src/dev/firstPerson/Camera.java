package dev.firstPerson;

import dev.haynesy.ui.Bitmap;

/**
 * Created with IntelliJ IDEA.
 * User: Haynesy
 * Date: 13/08/2014
 * Time: 8:03 PM
 */
public class Camera {
    public void render(Bitmap screen, Player player, Map map) {
        drawSky(player.direction, map.skybox, map.light);
        drawColumns(player, map);
        drawWeapon(player.weapon, player.paces);

    }

    private void drawWeapon(Bitmap weapon, int paces) {


    }

    private void drawColumns(Player player, Map map) {


    }

    private void drawSky(int direction, Bitmap skybox, Bitmap light) {

    }
}
