package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap {
   /* private Integer width = 4;
    private Integer height = 4;
    private ArrayList<Animal> animals = new ArrayList<>();*/
    public RectangularMap(){

    }
    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }


    public Integer getWidth(){
        return this.width;
    }

    public Integer getHeight(){
        return this.height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(this.isOccupied(position)){
            return false;
        }
        if(position.x < 0 || position.y < 0) {
            return false;
        }
        if (position.x > this.width || position.y > this.height) {
            return false;
        }
        return true;
    }



}
