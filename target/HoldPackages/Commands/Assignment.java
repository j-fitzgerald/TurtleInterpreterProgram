package Interpreter.Commands;

import Visitors.TurtleVisitorInterface;

public class Assignment implements NonTerminalExpression {
    Variable variableExpression;
    Expression valueExpression;

    public Assignment(Variable variableExpression){
        this.variableExpression = variableExpression;
    }

    public Assignment(Variable variableExpression, Value valueExpression){
        this.variableExpression = variableExpression;
        this.valueExpression = valueExpression;
        variableExpression.setValue(valueExpression);
    }

    public int evaluate() {
        variableExpression.evaluate();
        return variableExpression.value;
    }

    public void visit(TurtleVisitorInterface visitor) {
        evaluate();
    }
}
