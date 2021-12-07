package agh.ics.oop;

public class Grass {
    private final Vector2d grass_position;


    public Grass(Vector2d grass_position){
        this.grass_position = grass_position;
    }

    public Vector2d getGrass_position(){
        return this.grass_position;
    }

    public String toString(){
        return "*";
    }

}
