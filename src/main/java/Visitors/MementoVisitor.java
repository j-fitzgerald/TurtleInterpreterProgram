package Visitors;

import Interpreter.Commands.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;

// Create a Memento for every node visited
public class MementoVisitor implements TurtleVisitorInterface {
    private Turtle turtle;
    private ArrayList<Turtle.Memento> mementoList = new ArrayList();

    public MementoVisitor(){
        this.turtle = new Turtle();
        mementoList.add(turtle.createMemento());
        mementoList.get(0).location = new Point2D.Double(100,100);
    }

    public MementoVisitor(Turtle turtle){
        this.turtle = turtle;
        mementoList.add(turtle.createMemento());
    }

    public void visitMove(Move moveExpression) {
        turtle.move(moveExpression.value);
        mementoList.add(turtle.createMemento());
    }

    public void visitTurn(Turn turnExpression) {
        turtle.turn(turnExpression.value);
        mementoList.add(turtle.createMemento());
    }

    public void visitPenUp() {
        turtle.penUp();
        mementoList.add(turtle.createMemento());
    }

    public void visitPenDown() {
        turtle.penDown();
        mementoList.add(turtle.createMemento());
    }

    public void visitRepeat(Repeat repeat){}

    public void visitEnd(){}

    public void visitAssignment(Assignment assignment) {
        assignment.evaluate();
    }

    public void restoreMemento(int index){
        turtle.restoreState(mementoList.get(index));
    }

    public void test(){
        mementoList.get(0).location = new Point2D.Double(100,100);
    }
}
