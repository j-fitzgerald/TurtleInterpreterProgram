package Interpreter.Commands;

import Visitors.Turtle;
import Visitors.TurtleVisitorInterface;

public class Move implements NonTerminalExpression {
    public TerminalExpression valueExpression;
    public int value;
    private Turtle turtle;

    public Move(TerminalExpression valueExpression, Turtle turtle){
        this.valueExpression = valueExpression;
        this.turtle = turtle;
        this.value = valueExpression.evaluate();
    }

    public int evaluate() {
        this.value = valueExpression.evaluate();
        turtle.move(value);
        turtle.name++;
        return value;
    }

    public void visit(TurtleVisitorInterface visitor) {
        visitor.visitMove(this);
    }

}
