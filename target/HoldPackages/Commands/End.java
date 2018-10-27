package Interpreter.Commands;

import Visitors.TurtleVisitorInterface;

public class End implements TerminalExpression {

    public End(){

    }

    public void visit(TurtleVisitorInterface visitor){
        visitor.visitEnd();
    }

    public int evaluate() {
        return 0;
    }
}
