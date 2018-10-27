/*
package Interpreter.Commands;

import Visitors.TurtleVisitorInterface;

public class Variable implements TerminalExpression {
    String name;
    Value valueExpression;
    int value;

    public Variable(String name){
        this.name= name;
    }

    public Variable(String name, Value valueExpression){
        this.name = name;
        this.valueExpression = valueExpression;
        //this.value = valueExpression.evaluate();
        setValue(valueExpression.evaluate());
    }

    public int evaluate(){
        if(valueExpression != null)
            setValue(valueExpression);
        else
            setValue(value);
        System.out.println("get " + name + " val: " + VariableHash.map.get(name));
        return VariableHash.map.get(name);
    }

    public void setValue(int value){
        System.out.println("set " + name + " val: " + value);
        this.value = value;
        VariableHash.map.put(name, value);
    }

    public void setValue(Value valueExpression){
        this.value = valueExpression.evaluate();
        VariableHash.map.put(name, value);
    }

    public void visit(TurtleVisitorInterface visitor) {
        //evaluate();
    }
}
*/

package Interpreter.Commands;

import Visitors.TurtleVisitorInterface;

public class Variable implements TerminalExpression{
    String name;
    Expression valueExpression;
    int value;

    public Variable(String name){
        this.name= name;

    }

    public Variable(String name, Expression valueExpression){
        this.name = name;
        this.valueExpression = valueExpression;
        //setValue(valueExpression.evaluate());
    }

    public int evaluate(){
        return VariableHash.map.get(name);
    }

    public void setValue(int value){
        this.value = value;
        VariableHash.map.put(name, value);
    }

    public void setValue(Expression valueExpression){
        this.value = valueExpression.evaluate();
        VariableHash.map.put(name, value);
    }

    public void visit(TurtleVisitorInterface visitor) {
        evaluate();
    }
}
