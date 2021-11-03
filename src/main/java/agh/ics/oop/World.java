package agh.ics.oop;

import java.util.ArrayList;

public class World {

    public static void main(String[] args) {
        System.out.println("System wystartowal");
        String[] tablica = {"f","f","r", "l"}; //testowa tablica komend
        ArrayList<Direction> comands = convert(args);
        run(comands);
        System.out.println("system zakonczyl dzialanie");
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
                    System.out.println("nie ma tego");
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
