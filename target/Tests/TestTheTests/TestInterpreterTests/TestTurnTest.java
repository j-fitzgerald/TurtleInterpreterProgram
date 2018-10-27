package TestTheTests.TestInterpreterTests;

import Interpreter.Commands.Turn;
import Interpreter.Commands.Value;
import Interpreter.Commands.Variable;
import Visitors.Turtle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTurnTest {
    Turn turn;
    Value value = new Value(5);
    Variable variable = new Variable("name", new Value(10));
    Turtle turtle = new Turtle();

    @Test
    void turnValue(){
        turn = new Turn(value, turtle);
        turn.evaluate();
        assertNotEquals(turn.value, 5);
    }

    @Test
    void turnVariable(){
        turn = new Turn(variable, turtle);
        turn.evaluate();
        assertNotEquals(turn.value, 10);
    }
}
