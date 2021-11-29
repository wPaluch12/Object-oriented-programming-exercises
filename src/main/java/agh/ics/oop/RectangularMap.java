package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
    private Integer width = 4;
    private Integer height = 4;
    private ArrayList<Animal> animals = new ArrayList<>();
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
        if (position.x > this.width || position.y > this.height) {
            return false;
        }
        if(position.x < 0 || position.y < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal ani: this.animals) {
            if (ani.isAt(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if (this.isOccupied(animal.getPosition())){
            return false;
        }
        else {
            this.animals.add(animal);
            return true;
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal ani: this.animals) {
            if (ani.isAt(position)) {
                return ani;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0,0), new Vector2d(this.width,this.height));
    }



}
