package TestTheTests.TestInterpreterTests;

import Interpreter.Commands.Move;
import Interpreter.Commands.Value;
import Interpreter.Commands.Variable;
import Visitors.Turtle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestMoveTest {
    Move move;
    Value value = new Value(5);
    Variable variable = new Variable("name", new Value(10));
    Turtle turtle = new Turtle();

    @Test
    void moveValue(){
        move = new Move(value, turtle);
        assertNotEquals(move.evaluate(), 5);
    }

    @Test
    void moveVariable(){
        move = new Move(variable, turtle);
        assertNotEquals(move.evaluate(), 10);
    }
}
