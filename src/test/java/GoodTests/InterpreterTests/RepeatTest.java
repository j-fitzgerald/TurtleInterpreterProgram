package GoodTests.InterpreterTests;

import Interpreter.Commands.*;
import Visitors.Turtle;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatTest {
    Value value = new Value(3);
    Repeat repeat = new Repeat(value);
    Turtle turtle = new Turtle();
    Move move = new Move(value, turtle);

    @Test
    void repeatTest(){
        repeat.addExpression(move);
        repeat.evaluate();
        assertEquals(turtle.location().getX(),(double)9); // 3 repeats of move 3
    }
}
