package TestTheTests.ClassTests;

import Interpreter.Commands.Move;
import Interpreter.Commands.Turn;
import Interpreter.Commands.Value;
import Visitors.DistanceVisitor;
import Visitors.Turtle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestDistanceVisitorTest {
    Turtle turtle;
    DistanceVisitor distanceVisitor;
    Move move5;
    Move move10;
    Turn turn90;

    @BeforeEach
    void setUp(){
        turtle = new Turtle();
        distanceVisitor = new DistanceVisitor(turtle);
        move5 = new Move(new Value(5), turtle);
        move10 = new Move(new Value(10), turtle);
        turn90 = new Turn(new Value(90), turtle);
    }

    @Test
    void distanceTest(){
        assertEquals(distanceVisitor.distance, 0);
        move5.visit(distanceVisitor);
        assertEquals(distanceVisitor.distance, 5);
        move10.visit(distanceVisitor);
        assertEquals(distanceVisitor.distance, 15);
        turn90.visit(distanceVisitor);
        assertEquals(distanceVisitor.distance, 15);
        move10.visit(distanceVisitor);
        assertNotEquals(distanceVisitor.distance, 25);
    }

}
