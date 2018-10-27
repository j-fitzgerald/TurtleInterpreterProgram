package GoodTests;

import TurtleProgram.TurtleProgram;
import Visitors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurtleProgramTest {
    TurtleProgram turtleProgram;
    Turtle turtle;
    Turtle mementoTurtle;
    MementoVisitor mementoVisitor;
    DistanceVisitor distanceVisitor;
    ArrayList<TurtleVisitorInterface> visitorList;
    String path = "C:\\Users\\Clyste\\Desktop\\AdvancedOOP\\Repo\\jf_assignment3" +
            "\\src\\main\\resources\\turtle.txt";

    @BeforeEach
    void setUp(){
        turtle =  new Turtle();
        mementoTurtle = new Turtle();
        mementoVisitor = new MementoVisitor(mementoTurtle);
        distanceVisitor = new DistanceVisitor(turtle);
        visitorList = new ArrayList<>();
    }

    @Test
    void noVisitors(){
        turtleProgram = new TurtleProgram(path, turtle, visitorList);
        turtleProgram.run();
        assertEquals(turtle.location().getX(), new Point2D.Double(-5,10).getX());
        assertEquals(turtle.direction(), 270);
        assertTrue(turtle.isPenUp());
    }

    @Test
    void withMementoVisitor(){
        visitorList.add(mementoVisitor);
        turtleProgram = new TurtleProgram(path, turtle, visitorList);
        turtleProgram.run();
        mementoVisitor.restoreMemento(8);
        assertEquals(mementoTurtle.location().getX(), new Point2D.Double(-5,10).getX());
        assertEquals(mementoTurtle.direction(), 270);
        assertTrue(mementoTurtle.isPenUp());
        mementoVisitor.restoreMemento(0);
        assertEquals(mementoTurtle.location(), new Point2D.Double(0,0));
        assertEquals(mementoTurtle.direction(), 0);
        assertTrue(mementoTurtle.isPenUp());
    }


    @Test
    void withDistanceVisitor(){
        visitorList.add(distanceVisitor);
        turtleProgram = new TurtleProgram(path, turtle, visitorList);
        turtleProgram.run();
        assertEquals(turtle.location().getX(), new Point2D.Double(-5,10).getX());
        assertEquals(turtle.direction(), 270);
        assertTrue(turtle.isPenUp());
        assertEquals(distanceVisitor.distance, 20);
    }
}
