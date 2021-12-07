package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {

    @Test
    void CheckCanMoveTo(){

        //sprawdzenie czy nie można wyjśc poza mape i czy można poruszać się na mapie
        IWorldMap map = new RectangularMap(5, 5);
        Assertions.assertFalse(map.canMoveTo(new Vector2d(6,5)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(-6,5)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(-1,-5)));

        Assertions.assertTrue(map.canMoveTo(new Vector2d(2,5)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(0,0)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(3,2)));

        Animal animal = new Animal(new Vector2d(3,5), MapDirection.EAST);
        map.place(animal);
        Assertions.assertFalse(map.canMoveTo(new Vector2d(3,5)));
    }

    @Test
    void CheckPlace() {
        IWorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(3,5), MapDirection.EAST);
        map.place(animal);
        Animal animal1 = new Animal(new Vector2d(2,1), MapDirection.EAST);
        map.place(animal1);
        Animal animal2 = new Animal(new Vector2d(2,1), MapDirection.NORTH);
        map.place(animal2);
        System.out.println(map);

    }
    @Test
    void CheckObjectAt() {
        IWorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(3,5), MapDirection.EAST);
        map.place(animal);
        Animal animal1 = new Animal(new Vector2d(2,1), MapDirection.EAST);
        map.place(animal1);
        Animal animal2 = new Animal(new Vector2d(1,1), MapDirection.NORTH);
        map.place(animal2);

        Assertions.assertEquals(map.objectAt(new Vector2d(3,5)),animal);

        Assertions.assertEquals(map.objectAt(new Vector2d(2,1)),animal1);

        Assertions.assertEquals(map.objectAt(new Vector2d(1,1)),animal2);

    }
    @Test
    void CheckisOccupied() {
        IWorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(3,5), MapDirection.EAST);
        map.place(animal);
        Animal animal1 = new Animal(new Vector2d(2,1), MapDirection.EAST);
        map.place(animal1);
        Animal animal2 = new Animal(new Vector2d(1,1), MapDirection.NORTH);
        map.place(animal2);

        Assertions.assertTrue(map.isOccupied(new Vector2d(3,5)));

        Assertions.assertTrue(map.isOccupied(new Vector2d(2,1)));

        Assertions.assertTrue(map.isOccupied(new Vector2d(1,1)));

        Assertions.assertFalse(map.isOccupied(new Vector2d(0,1)));

    }




}
