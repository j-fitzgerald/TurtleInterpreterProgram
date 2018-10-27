package Interpreter.Commands;

import Visitors.Turtle;
import Visitors.TurtleVisitorInterface;

public class Turn implements NonTerminalExpression {
    private TerminalExpression valueExpression;
    public int value;
    private Turtle turtle;

    public Turn(TerminalExpression valueExpression, Turtle turtle){
        this.valueExpression = valueExpression;
        this.turtle = turtle;
        this.value = valueExpression.evaluate();
    }

    public int evaluate() {
        this.value = valueExpression.evaluate();
        turtle.turn(value);
        turtle.name++;
        return value;
    }

    public void visit(TurtleVisitorInterface visitor) {
        visitor.visitTurn(this);
    }
}
