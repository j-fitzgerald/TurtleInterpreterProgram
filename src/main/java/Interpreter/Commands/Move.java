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
    }

    public int evaluate() {
        this.value = valueExpression.evaluate();
        turtle.move(value);
        turtle.name++;
        System.out.println(turtle);
        return value;
    }

    public void visit(TurtleVisitorInterface visitor) {
        value = valueExpression.evaluate();
        visitor.visitMove(this);
    }

}
