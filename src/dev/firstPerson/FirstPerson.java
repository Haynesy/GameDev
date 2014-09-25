package dev.firstPerson;

import dev.haynesy.App;

/**
 * Created by NewLease on 13/08/2014.
 */
public class FirstPerson extends App {

    private final Game game;

    public FirstPerson(){
        super();
        width = 600;
        height = 400;
        scale = 1;
        finalWidth = width * scale;
        finalHeight = height * scale;

        game = new Game();
    }

    public static void main(String[] args){

        FirstPerson.start(new FirstPerson());
    }



    @Override
    public void updateScreen(){
        //camera.render(screen, player, map);
        game.update(screen);
    }

    @Override
    public void handleInput(){

        game.updateInput(input);
    }

    @Override
    public void tick(){
//        map.update();
//        player.update();
//        camera.render(screen, player, map);

    }
}
