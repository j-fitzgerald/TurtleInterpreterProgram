package GoodTests.InterpreterTests;

import Interpreter.Commands.*;
import Visitors.Turtle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnTest {
    Turtle turtle = new Turtle();
    Turn turn;
    Value value = new Value(5);
    Variable variable = new Variable("name", new Value(10));

    @Test
    void turnValue(){
        turn = new Turn(value, turtle);
        turn.evaluate();
        assertEquals(turn.value, 5);
    }

    @Test
    void turnVariable(){
        turn = new Turn(variable, turtle);
        turn.evaluate();
        assertEquals(turn.value, 10);
    }
}
