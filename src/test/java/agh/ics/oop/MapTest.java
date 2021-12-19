package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void CheckOptionParser(){
        String[] args = {"r","f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        Assertions.assertEquals( directions[0],MoveDirection.RIGHT );
        Assertions.assertEquals( directions[1],MoveDirection.FORWARD );
        Assertions.assertEquals( directions[2],MoveDirection.FORWARD );

        String[] args1 = {"r","f", "f", "w"};

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MoveDirection[] directions1 = new OptionsParser().parse(args1);
        });

        String expectedMessage = "w is not legal move specification";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }




    @Test
    void CheckMove(){
        String[] args = {"r","f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        List<Animal> animals = ((SimulationEngine)engine).getAnimals();
        Assertions.assertEquals(animals.get(1).toString(),  "(3,5) N");
        Assertions.assertEquals(animals.get(0).toString(), "(3,2) E" );


        String[] arg = {"r","f", "f", "l", "l", "b", "b" , "b", "b", "b" , "b", "b", "b" , "b", "b", "b" , "b", "b", "b" , "b", "b", "b" , "b", "b", "b" , "b", "b", "b" , "b", "f"};
        MoveDirection[] directions1 = new OptionsParser().parse(arg);
        IWorldMap map1 = new RectangularMap(20, 10);
        Vector2d[] positions1 = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine1 = new SimulationEngine(directions1, map1, positions1);
        engine1.run();

        List<Animal> animals1 = ((SimulationEngine)engine1).getAnimals();
        Assertions.assertEquals(animals1.get(1).toString(),  "(14,5) W");
        Assertions.assertEquals(animals1.get(0).toString(), "(3,0) N" );



    }


}