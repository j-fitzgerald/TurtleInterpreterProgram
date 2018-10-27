package Interpreter.Commands;

import Visitors.Turtle;
import Visitors.TurtleVisitorInterface;

public class PenUp implements TerminalExpression {
    private Turtle turtle;

    public PenUp(Turtle turtle){
        this.turtle = turtle;
    }

    public int evaluate() {
        turtle.penUp();
        return 0;
    }

    public void visit(TurtleVisitorInterface visitor) {
        visitor.visitPenUp();
    }
}
