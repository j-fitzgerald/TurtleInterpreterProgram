package Visitors;

import Interpreter.Commands.*;

// Track distance a turtle has travelled
public class DistanceVisitor implements TurtleVisitorInterface {

    public int distance = 0;

    public DistanceVisitor(){}

    public DistanceVisitor(Turtle turtle){
    }

    public void visitMove(Move move) {
        distance += move.value;
    }

    public void visitTurn(Turn turn) { }

    public void visitPenUp(){}

    public void visitPenDown() {    }

    public void visitRepeat(Repeat repeat){}

    public String toString(){
        return "Distance travelled: " + distance;
    }

    public void visitEnd(){}

    public void visitAssignment(Assignment assignment) {
        assignment.evaluate();
    }
}
