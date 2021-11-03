package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Vector2dTest {

    @Test
    void testEquals(){
        Assertions.assertTrue(new Vector2d(1,2).equals( new Vector2d(1,2)));
        Assertions.assertFalse(new Vector2d(1,2).equals( new Vector2d(2,2)));
        Assertions.assertFalse(new Vector2d(1,2).equals( new int[]{1,2}));
    }

    @Test
    void testToString(){
        Assertions.assertEquals( new Vector2d(3,4).toString(), "(3,4)");
        Assertions.assertEquals( new Vector2d(353,423).toString(), "(353,423)");

    }
    @Test
    void testPrecedes(){
        Assertions.assertTrue(new Vector2d(2,3).precedes(new Vector2d(3,4)));
        Assertions.assertTrue(new Vector2d(2,3).precedes(new Vector2d(2,5)));
        Assertions.assertFalse(new Vector2d(2,3).precedes(new Vector2d(1,2)));
    }
    @Test
    void testFollows(){
        Assertions.assertTrue(new Vector2d(4,4).follows(new Vector2d(3,4)));
        Assertions.assertTrue(new Vector2d(6,7).follows(new Vector2d(2,5)));
        Assertions.assertFalse(new Vector2d(2,3).follows(new Vector2d(8,2)));
    }
    @Test
    void testUpperRight(){
        Assertions.assertEquals(new Vector2d(4,4).upperRight(new Vector2d(3,4)),new Vector2d(4,4));
        Assertions.assertEquals(new Vector2d(6,7).upperRight(new Vector2d(2,5)),new Vector2d(6,7));
        Assertions.assertEquals(new Vector2d(2,3).upperRight(new Vector2d(8,2)),new Vector2d(8,3));
    }
    @Test
    void testLowerLeft(){
        Assertions.assertEquals(new Vector2d(4,4).lowerLeft(new Vector2d(3,4)),new Vector2d(3,4));
        Assertions.assertEquals(new Vector2d(6,7).lowerLeft(new Vector2d(2,5)),new Vector2d(2,5));
        Assertions.assertEquals(new Vector2d(2,3).lowerLeft(new Vector2d(8,2)),new Vector2d(2,2));
    }
    @Test
    void testAdd(){
        Assertions.assertEquals(new Vector2d(4,4).add(new Vector2d(3,4)),new Vector2d(7,8));
        Assertions.assertEquals(new Vector2d(6,7).add(new Vector2d(2,5)),new Vector2d(8,12));
        Assertions.assertEquals(new Vector2d(2,3).add(new Vector2d(8,2)),new Vector2d(10,5));
    }
    @Test
    void testSubstract() {
        Assertions.assertEquals(new Vector2d(4, 4).subtract(new Vector2d(3, 4)), new Vector2d(1, 0));
        Assertions.assertEquals(new Vector2d(6, 7).subtract(new Vector2d(2, 5)), new Vector2d(4, 2));
        Assertions.assertEquals(new Vector2d(2, 3).subtract(new Vector2d(8, 2)), new Vector2d(-6, 1));
    }
    @Test
    void testOpposite(){
        Assertions.assertEquals(new Vector2d(4,4).opposite(),new Vector2d(-4,-4));
        Assertions.assertEquals(new Vector2d(-6,7).opposite(),new Vector2d(6,-7));
        Assertions.assertEquals(new Vector2d(-2,-3).opposite(),new Vector2d(2,3));
    }


}
