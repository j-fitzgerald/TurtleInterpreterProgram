package Interpreter.Commands;

import Visitors.Turtle;
import Visitors.TurtleVisitorInterface;

public class Assignment implements NonTerminalExpression {
    Variable variableExpression;
    Expression valueExpression;

    public Assignment(Variable variableExpression, Expression valueExpression){
        this.variableExpression = variableExpression;
        this.valueExpression = valueExpression;

    }

    public int evaluate() {
        variableExpression.setValue(valueExpression);
        return variableExpression.value;
    }

    public void visit(TurtleVisitorInterface visitor) {
        visitor.visitAssignment(this);
    }
}
