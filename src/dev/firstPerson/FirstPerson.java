package dev.firstPerson;

import dev.haynesy.App;

/**
 * Created by NewLease on 13/08/2014.
 */
public class FirstPerson extends App {

    private Player player;
    private Map map;

    public FirstPerson(){
        map = new Map(10, 10);
        player = new Player();
    }

    public static void main(String[] args){

        FirstPerson.start(new FirstPerson());
    }

    /*
        var x  = column / resolution - 0.5;
        var angle = Math.atan2(x, focalLength);
        var ray = map.case(player, player.direction + angle. range);
     */
    public void ray(Point point){

    }

    @Override
    public void updateScreen(){


    }
}
