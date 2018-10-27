package Interpreter.Commands;

import Visitors.TurtleVisitorInterface;

public class PenDown implements TerminalExpression {

    public PenDown(){

    }

    public int evaluate() {
        return 0;
    }

    public void visit(TurtleVisitorInterface visitor) {
        visitor.visitPenDown();
    }
}
