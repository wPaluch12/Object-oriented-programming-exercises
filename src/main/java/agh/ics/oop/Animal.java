package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation =  MapDirection.NORTH;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();


    private Animal(){

    }
    public Animal( Vector2d position, MapDirection orientation){
        this.position = position;
        this.orientation = orientation;
    }
    public Animal(IWorldMap map){
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    public String toString(){
        String s= position.toString()+" "+ orientation;
        return s;
    }

    public boolean isAt(Vector2d position){
        if (this.position.equals(position))
            return true;
        return false;
    }
    public Vector2d getPosition(){
        return this.position;
    }

    public void move(MoveDirection direction){
        if(direction==MoveDirection.LEFT){
            this.orientation = this.orientation.previous();
        }
        if (direction== MoveDirection.RIGHT) {
            this.orientation = this.orientation.next();
        }

        if (direction==MoveDirection.FORWARD) {
            if (this.orientation == MapDirection.NORTH){
                Vector2d test_orienation = this.position.add(MapDirection.NORTH.toUnitVector());
                if (this.map.canMoveTo(test_orienation)) {
                    this.positionChanged(this.position,test_orienation);
                    this.position = test_orienation;
                }
            }
            if (this.orientation == MapDirection.SOUTH) {
                Vector2d test_orienation = this.position.add(MapDirection.SOUTH.toUnitVector());
                if (this.map.canMoveTo(test_orienation)) {
                    this.positionChanged(this.position,test_orienation);
                    this.position = test_orienation;
                }
            }
            if (this.orientation == MapDirection.WEST) {
                Vector2d test_orienation = this.position.add(MapDirection.WEST.toUnitVector());
                if (this.map.canMoveTo(test_orienation)) {
                    this.positionChanged(this.position,test_orienation);
                    this.position = test_orienation;
                }
            }
            if (this.orientation == MapDirection.EAST) {
                Vector2d test_orienation = this.position.add(MapDirection.EAST.toUnitVector());
                if (this.map.canMoveTo(test_orienation)) {
                    this.positionChanged(this.position,test_orienation);
                    this.position = test_orienation;
                }
            }
            }


        if (direction==MoveDirection.BACKWARD){
            if (this.orientation == MapDirection.NORTH) {
                Vector2d test_orienation = this.position.subtract(MapDirection.NORTH.toUnitVector());
                if (this.map.canMoveTo(test_orienation)) {
                    this.positionChanged(this.position,test_orienation);
                    this.position = test_orienation;
                }
            }

            if (this.orientation == MapDirection.SOUTH) {
                Vector2d test_orienation = this.position.subtract(MapDirection.SOUTH.toUnitVector());
                if (this.map.canMoveTo(test_orienation)) {
                    this.positionChanged(this.position,test_orienation);
                    this.position = test_orienation;
                }
            }
            if (this.orientation == MapDirection.WEST) {
                Vector2d test_orienation = this.position.subtract(MapDirection.WEST.toUnitVector());
                if (this.map.canMoveTo(test_orienation)) {
                    this.positionChanged(this.position,test_orienation);
                    this.position = test_orienation;
                }
            }
            if (this.orientation == MapDirection.EAST){
                Vector2d test_orienation = this.position.subtract(MapDirection.EAST.toUnitVector());
                    if (this.map.canMoveTo(test_orienation)) {
                        this.positionChanged(this.position,test_orienation);
                        this.position = test_orienation;
                    }
            }
        }

       /* if(this.position.x > 4 || this.position.y > 4){
            this.position=this.position.lowerLeft(new Vector2d(4,4));
        }
        if(this.position.x<0 || this.position.y<0){
            this.position=this.position.upperRight(new Vector2d(0,0));
        }*/



    }



    public void addObserver(IPositionChangeObserver observer){
      this.observers.add(observer);
  }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }



}
