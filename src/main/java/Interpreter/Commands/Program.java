package Interpreter.Commands;

import Visitors.TurtleVisitorInterface;

import java.util.ArrayList;

public class Program implements ListExpression {
    private ArrayList<Expression> expressionList;

    public Program(){
        expressionList = new ArrayList<>();
    }

    public int evaluate() {
        for(Expression e: expressionList) {
            e.evaluate();
        }
        return 0;
    }

    public void visit(TurtleVisitorInterface visitor) {
        for(Expression e: expressionList){
            e.visit(visitor);
        }
    }

    public void addExpression(Expression e){
        expressionList.add(e);
    }

    public void addExpressionList(ArrayList<Expression> expressionList){
        this.expressionList = expressionList;
    }

    public int size(){
        return expressionList.size();
    }
}
