package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {

   @Test
     void CheckNext(){
        Assertions.assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        Assertions.assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST);
        Assertions.assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);
        Assertions.assertEquals(MapDirection.NORTH.next(), MapDirection.EAST);
    }

    @Test
    void CheckPrevious(){
        Assertions.assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);
        Assertions.assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST);
        Assertions.assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH);
        Assertions.assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);
    }





}



