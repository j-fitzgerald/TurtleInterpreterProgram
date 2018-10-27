package Interpreter.Commands;

import Visitors.TurtleVisitorInterface;

public class Move implements NonTerminalExpression{
    public TerminalExpression valueExpression;
    //private Expression valueExpression;
    public int value;

    public Move(TerminalExpression valueExpression){
        this.valueExpression = valueExpression;
    }

    public int evaluate() {
        this.value = valueExpression.evaluate();
        return value;
    }

    public void visit(TurtleVisitorInterface visitor) {
        evaluate();
        visitor.visitMove(this);
    }

}
