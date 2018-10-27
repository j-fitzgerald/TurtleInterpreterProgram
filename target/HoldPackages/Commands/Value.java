package Interpreter.Commands;

import Visitors.TurtleVisitorInterface;

public class Value implements TerminalExpression {
    public int value;
    public Value(int value){
        this.value = value;
    }

    public int evaluate() {
        return value;
    }

    public void visit(TurtleVisitorInterface visitor) {

    }
}
