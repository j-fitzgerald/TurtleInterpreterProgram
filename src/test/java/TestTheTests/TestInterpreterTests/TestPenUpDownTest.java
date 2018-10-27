package TestTheTests.TestInterpreterTests;

import Interpreter.Commands.PenDown;
import Interpreter.Commands.PenUp;
import Visitors.Turtle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPenUpDownTest {
    Turtle turtle = new Turtle();
    PenUp penUp = new PenUp(turtle);
    PenDown penDown = new PenDown(turtle);

    @Test
    void penTest(){
        assertTrue(turtle.isPenUp());
        penDown.evaluate();
        assertFalse(turtle.isPenUp());
        penUp.evaluate();
        assertFalse(turtle.isPenUp());
    }
}
