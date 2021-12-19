package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    public ArrayList<Animal> animals = new ArrayList<>();
    Map<Vector2d, Object> objects = new HashMap<>();
    public Integer width =0 ;
    public Integer height = 0;
    public MapBoundary mapBoundary;


    public AbstractWorldMap() {
        this.mapBoundary = new MapBoundary();
    }

    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            this.objects.put(animal.getPosition(), animal);
            animal.addObserver(this);
            mapBoundary.placeAnimal(animal);
            return true;
        }
        else{
            throw new IllegalArgumentException("Cannot place object at position: "+ animal.getPosition() + "There's already an animal");
        }
        /*if (this.isOccupied(animal.getPosition())){
            return false;
        }
        else {
            this.animals.add(animal);
            this.objects.put(animal.getPosition(), animal);
            return true;
        }*/
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
        /*for (Animal ani: this.animals) {
            if (ani.isAt(position)) {
                return true;
            }
        }
        return false;*/
        if(this.objects.get(position)!= null){
            if(this.objects.get(position) instanceof Grass)
                return false;
            else
                return this.objects.get(position) instanceof Animal;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        /*for (Animal ani: this.animals) {
            if (ani.isAt(position)) {
                return ani;
            }
        }
        return null;*/
       return this.objects.get(position);
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(mapBoundary.getLeftCorner(), mapBoundary.getRightCorner());
    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = (Animal)objects.get(oldPosition);
        this.objects.remove(oldPosition);
        this.objects.put(newPosition, animal);
    }
}
