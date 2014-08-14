package dev.firstPerson;

import dev.haynesy.App;
import dev.haynesy.ui.Bitmap;

/**
 * Created by NewLease on 13/08/2014.
 */
public class FirstPerson extends App {

    private Player player;
    private Map map;
    private Camera camera;
    private Bitmap test;

    public FirstPerson(){

        width = 1440;
        height = 900;
        scale = 1;

        finalWidth = width * scale;
        finalHeight = height * scale;

        map = new Map(10, 10);
        player = new Player(1, 1, 1);
        camera = new Camera();

        test = new Bitmap("pixelart.png");
    }

    public static void main(String[] args){

        FirstPerson.start(new FirstPerson());
    }

    /*
        var x  = column / resolution - 0.5;
        var angle = Math.atan2(x, focalLength);
        var ray = map.case(player, player.direction + angle. range);
     */
    public void ray(Point origin){
//        Point stepX = step(sin, cos, origin.x, origin.y);
//        Point stepY = step(cos, sin, origin.x, origin.y, true);
//        Point nextStep = stepX.length2 < stepY.length2
//                ? inspect(stepX, 1, 0, origin.distance, stepX.y)
//                : inspect(stepX, 0, 1, origin.distance, stepY.x);
//
//        if(nextStep.distance > range) return [origin];
//        return [origin].concat(ray(nextStep));
    }

    @Override
    public void updateScreen(){
        camera.render(screen, player, map);

        screen.render(test, 10, 10);
    }

    @Override
    public void tick(){
        map.update();
        player.update();
        camera.render(screen, player, map);
    }
}
