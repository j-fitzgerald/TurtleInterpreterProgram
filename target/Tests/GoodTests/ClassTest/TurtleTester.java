package GoodTests.ClassTest;

import Visitors.Turtle;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurtleTester {
    Turtle turtle;

    @org.junit.jupiter.api.BeforeEach
    void setUp(){
        turtle = new Turtle();
    }

    @Test
    void movement(){
        assertEquals(turtle.location(), new Point2D.Double(0,0));
        turtle.move(5);
        assertEquals(turtle.location(), new Point2D.Double(5,0));
        assertEquals(turtle.direction(), 0);
        turtle.turn(90);
        assertEquals(turtle.direction(), 90);
        assertEquals(turtle.location(), new Point2D.Double(5,0));
        turtle.move(5);
        assertEquals(turtle.location(), new Point2D.Double(5,5));
        turtle.turn(360);
        assertEquals(turtle.direction(), 90);
    }

    @Test
    void pen(){
        assertTrue(turtle.isPenUp());
        turtle.penDown();
        assertFalse(turtle.isPenUp());
        turtle.penUp();
        assertTrue(turtle.isPenUp());
    }
}
