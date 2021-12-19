package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.ArrayList;

public class World {

    public static void main(String[] args) {
        //f b r l f f r r f f f f f f f f
        Application.launch(App.class, args);
//        try{
//            MoveDirection[] directions = new OptionsParser().parse(args);
//            //IWorldMap map = new RectangularMap(10,5);
//            IWorldMap map = new GrassField(10);
//            Vector2d[] positions = {new Vector2d(2,2) , new Vector2d(3,4) };
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//        }
//        catch(IllegalArgumentException ex) {
//            System.out.println(ex.getMessage());
//            System.exit(0);
//        }
    }

    public static void run( ArrayList<Direction> com){

        for(Direction comand : com){
            switch(comand){
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tylu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skreca w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skreca w lewo");
                    break;
                default:
                    break;
            }

        }

    }

    public static  ArrayList<Direction> convert(String[] table){
        ArrayList<Direction> converted = new  ArrayList<Direction>();
        for (String t: table) {
            int i=0;
            switch (t){
                case "f":
                    converted.add(Direction.FORWARD);
                    break;
                case "b":
                    converted.add(Direction.BACKWARD);
                    break;
                case "r":
                    converted.add(Direction.RIGHT);
                    break;
                case "l":
                    converted.add(Direction.LEFT);
                    break;
            }
        }
        return converted;


    }

}
