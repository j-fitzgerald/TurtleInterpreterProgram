package Interpreter.Commands;

import Visitors.TurtleVisitorInterface;

public class Assignment implements NonTerminalExpression {
    Variable variableExpression;
    Expression valueExpression;

    public Assignment(Variable variableExpression){
        this.variableExpression = variableExpression;
    }

    public Assignment(Variable variableExpression, Expression valueExpression){
        this.variableExpression = variableExpression;
        this.valueExpression = valueExpression;
        variableExpression.setValue(valueExpression);
    }

    public int evaluate() {
        if(valueExpression != null)
            variableExpression.setValue(valueExpression);
        variableExpression.evaluate();
        return variableExpression.value;
    }

    public void visit(TurtleVisitorInterface visitor) {
        //evaluate();
    }
}
