package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AnimalTest {

    @Test
    void AnimalCheck(){
        Assertions.assertEquals( new Animal(new Vector2d(1,2), MapDirection.SOUTH).toString() , "(1,2) Południe"  );
    }

    @Test
    void AnimalCheckPosition(){
        Assertions.assertTrue( new Animal(new Vector2d(2,2),MapDirection.SOUTH).isAt(new Vector2d(2,2)));
        Assertions.assertFalse( new Animal(new Vector2d(1,2), MapDirection.SOUTH).isAt(new Vector2d(1,1)) );
    }

    @Test
    void CheckMOve(){
        Animal animal = new Animal(new Vector2d(2,2),MapDirection.NORTH);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(animal.toString(), "(4,2) Wschód" );
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(animal.toString(), "(4,3) Południe" );
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(animal.toString(), "(4,4) Południe" );
        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(animal.toString(), "(4,4) Zachód" );
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(animal.toString(), "(4,1) Południe" );
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(animal.toString(), "(0,1) Wschód" );
    }

   /* @Test
    void CheckOption(){
        Animal animal = new Animal(new Vector2d(2,2),MapDirection.NORTH);
        String[] op = {"r","w", "right","forward", "f", "f","l"};
        MoveDirection[] parsedop = new OptionsParser().parse(op);


        Assertions.assertEquals(parsedop.toString(), "[RIGHT, RIGHT, FORWARD, FORWARD, FORWARD, LEFT]" );

        for (MoveDirection s : parsedop){
            animal.move(s);
        }

        Assertions.assertEquals(animal.toString(), "(2,0) Wschód" );


    }*/


}
