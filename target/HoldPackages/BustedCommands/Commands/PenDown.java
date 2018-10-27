package Interpreter.Commands;

import Visitors.Turtle;
import Visitors.TurtleVisitorInterface;

public class PenDown implements TerminalExpression {
    private Turtle turtle;

    public PenDown(Turtle turtle){
        this.turtle = turtle;
    }

    public int evaluate() {
        turtle.penDown();
        return 0;
    }

    public void visit(TurtleVisitorInterface visitor) {
        visitor.visitPenDown();
    }
}
