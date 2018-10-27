package TestTheTests.TestInterpreterTests;

import Interpreter.Commands.Expression;
import Interpreter.Commands.Move;
import Interpreter.Commands.Repeat;
import Interpreter.Commands.Value;
import Visitors.Turtle;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestRepeatTest {
    Turtle turtle = new Turtle();
    Value value = new Value(3);
    Repeat repeat = new Repeat(value);
    Move move = new Move(value, turtle);
    ArrayList<Expression> expressionList;
    Point2D testPoint = new Point2D.Double();

    @Test
    void repeatTest(){
        repeat.addExpression(move);
        repeat.evaluate();
        expressionList = repeat.repeatedExpressionList;
        assertEquals(expressionList.size(), value.evaluate());
        assertEquals(turtle.location(), new Point2D.Double());
        assertEquals(turtle.direction(), 0);
        for(Expression e: expressionList){
            e.evaluate();
            testPoint = new Point2D.Double(testPoint.getX() + (double)value.evaluate(),0);
            assertNotEquals(turtle.location().getX(), testPoint.getX());
            assertNotEquals(turtle.location().getY(), testPoint.getY());
        }

    }
}
