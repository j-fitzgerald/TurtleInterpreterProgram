package Interpreter.Commands;

import Visitors.TurtleVisitorInterface;

import java.util.ArrayList;

public class Repeat implements NonTerminalExpression {
    private TerminalExpression timesExpression;
    public int times;
    public ArrayList<Expression> repeatedExpressionList;
    private ArrayList<Expression> backupList;

    public Repeat(TerminalExpression timeExpression){
        this.timesExpression = timeExpression;
        repeatedExpressionList = new ArrayList<Expression>();
    }

    public int evaluate() {
        times = timesExpression.evaluate();
        backupList = new ArrayList();
        for (Expression e: repeatedExpressionList){
            backupList.add(e);
        }
        repeatedExpressionList.clear();
        while (times > 0){
            for (Expression e: backupList) {
                repeatedExpressionList.add(e);
            }
            times --;
        }
        return repeatedExpressionList.size();
    }

    public void visit(TurtleVisitorInterface visitor) {
        evaluate();
        visitor.visitRepeat(this);
    }

    public void add(Expression e){
        repeatedExpressionList.add(e);
    }

    public void addExpressionList(ArrayList<Expression> expressionList){
        repeatedExpressionList = expressionList;
    }
}
