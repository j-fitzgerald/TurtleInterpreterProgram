package TestTheTests.ClassTests;

import Interpreter.Commands.*;
import Visitors.MementoVisitor;
import Visitors.Turtle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

public class TestMementoVisitorTest {

    Turtle turtle;
    MementoVisitor mementoVisitor;
    Move move5;
    Turn turn90;
    PenUp penUp;
    PenDown penDown;

    @BeforeEach
    void setUp(){
        turtle = new Turtle();
        mementoVisitor = new MementoVisitor(turtle);
        move5 = new Move(new Value(5),turtle);
        turn90 = new Turn(new Value(90),turtle);
        penUp = new PenUp(turtle);
        penDown = new PenDown(turtle);
        move5.visit(mementoVisitor);
        turn90.visit(mementoVisitor);
        penDown.visit(mementoVisitor);
        penUp.visit(mementoVisitor);
    }

    @Test
    void testMoveMemento(){
        mementoVisitor.restoreMemento(0);
        assertEquals(turtle.location(), new Point2D.Double());
        mementoVisitor.restoreMemento(1);
        assertNotEquals(turtle.location(), new Point2D.Double(5, 0));
    }

    @Test
    void testTurnMemento() {
        assertNotEquals(turtle.direction(), 90);
        mementoVisitor.restoreMemento(2);
        assertNotEquals(turtle.direction(), 90);
    }

    @Test
    void testPenMemento(){
        assertTrue(turtle.isPenUp());
        mementoVisitor.restoreMemento(3);
        assertFalse(turtle.isPenUp());
        mementoVisitor.restoreMemento(4);
        assertFalse(turtle.isPenUp());
    }


}
