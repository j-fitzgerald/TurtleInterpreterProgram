package Interpreter.Commands;

import Visitors.TurtleVisitorInterface;

public class Turn implements NonTerminalExpression {
    private TerminalExpression valueExpression;
    public int value;

    public Turn(TerminalExpression valueExpression){
        this.valueExpression = valueExpression;
    }

    public int evaluate() {
        this.value = valueExpression.evaluate();
        return value;
    }

    public void visit(TurtleVisitorInterface visitor) {
        evaluate();
        visitor.visitTurn(this);
    }
}
