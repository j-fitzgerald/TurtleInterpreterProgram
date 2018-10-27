package Interpreter.Commands;

import Visitors.Turtle;
import Visitors.TurtleVisitorInterface;

import java.util.ArrayList;

public class Repeat implements ListExpression {
    private TerminalExpression timesExpression;
    public int times;
    public ArrayList<Expression> repeatedExpressionList;

    public Repeat(TerminalExpression timeExpression){
        this.timesExpression = timeExpression;
        repeatedExpressionList = new ArrayList<Expression>();
    }

    public int evaluate() {
        times = timesExpression.evaluate();
        for (int i = 0; i < timesExpression.evaluate(); i++){
            for(Expression e: repeatedExpressionList){
                e.evaluate();
            }
        }
        return 0;
    }

    public void visit(TurtleVisitorInterface visitor) {
        for (int i = 0; i < timesExpression.evaluate(); i++){
            for(Expression e: repeatedExpressionList){
                e.visit(visitor);
            }
        }

    }

    public void addExpression(Expression e){
        repeatedExpressionList.add(e);
    }

    public void addExpressionList(ArrayList<Expression> expressionList){
        repeatedExpressionList = expressionList;
    }
}
