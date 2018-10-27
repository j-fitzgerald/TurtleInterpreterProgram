package GoodTests.InterpreterTests;

import Interpreter.
        Commands.*;
import Visitors.Turtle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveTest {
    Move move;
    Value value = new Value(5);
    Variable variable = new Variable("name", new Value(10));
    Turtle turtle;

    @Test
    void moveValue(){
        turtle = new Turtle();
        move = new Move(value, turtle);
        assertEquals(move.evaluate(), 5);
    }

    @Test
    void moveVariable(){
        turtle = new Turtle();
        move = new Move(variable, turtle);
        assertEquals(move.evaluate(), 10);
    }
}
