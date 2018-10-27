package TestTheTests;

import TurtleProgram.TurtleProgram;
import Visitors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTurtleProgramTest {
    TurtleProgram turtleProgram;
    Turtle turtle;
    MementoVisitor mementoVisitor;
    DistanceVisitor distanceVisitor;
    ArrayList<TurtleVisitorInterface> visitorList;
    String path = "C:\\Users\\Clyste\\Desktop\\AdvancedOOP\\Repo\\jf_assignment3" +
            "\\src\\main\\resources\\turtle.txt";

    @BeforeEach
    void setUp(){
        turtle =  new Turtle();
        mementoVisitor = new MementoVisitor(turtle);
        distanceVisitor = new DistanceVisitor(turtle);
        visitorList = new ArrayList<>();
    }

    // verify distance and direction after traversing
    @Test
    void noVisitors(){
        turtleProgram = new TurtleProgram(path, turtle, visitorList);
        turtleProgram.run();
        assertNotEquals(turtle.location().getX(), new Point2D.Double(-5,10).getX());
        assertNotEquals(turtle.direction(), 270);
        assertTrue(turtle.isPenUp());
    }

    // Check the direction after restoring to original state
    @Test
    void withMementoVisitor(){
        visitorList.add(mementoVisitor);
        turtleProgram = new TurtleProgram(path, turtle, visitorList);
        turtleProgram.run();
        assertEquals(turtle.location().getX(), new Point2D.Double(-5,10).getX());
        assertEquals(turtle.direction(), 270);
        assertTrue(turtle.isPenUp());
        mementoVisitor.restoreMemento(0);
        assertNotEquals(turtle.direction(), 0);
    }

    // Invert the distance check to verify distance visitor
    @Test
    void withDistanceVisitor(){
        visitorList.add(distanceVisitor);
        turtleProgram = new TurtleProgram(path, turtle, visitorList);
        turtleProgram.run();
        assertEquals(turtle.location().getX(), new Point2D.Double(-5,10).getX());
        assertEquals(turtle.direction(), 270);
        assertTrue(turtle.isPenUp());
        assertNotEquals(distanceVisitor.distance, 20);
    }
}
