package Interpreter.Commands;

import Visitors.TurtleVisitorInterface;

public class PenUp implements TerminalExpression {
    public PenUp(){}

    public int evaluate() {
        return 0;
    }

    public void visit(TurtleVisitorInterface visitor) {
        visitor.visitPenUp();
    }
}
