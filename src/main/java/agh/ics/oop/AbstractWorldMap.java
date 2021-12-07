package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap {
    public ArrayList<Animal> animals = new ArrayList<>();
    public Integer width =0 ;
    public Integer height = 0;


    public boolean place(Animal animal) {
        if (this.isOccupied(animal.getPosition())){
            return false;
        }
        else {
            this.animals.add(animal);
            return true;
        }
    }

  /*  public boolean canMoveTo(Vector2d position) {
        if(this.isOccupied(position)){
            return false;
        }
        if(position.x < 0 || position.y < 0) {
            return false;
        }

    }*/

    public boolean isOccupied(Vector2d position) {
        for (Animal ani: this.animals) {
            if (ani.isAt(position)) {
                return true;
            }
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal ani: this.animals) {
            if (ani.isAt(position)) {
                return ani;
            }
        }
        return null;
    }

    public String toString(){
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0,0), new Vector2d(this.width,this.height));
    }

}
