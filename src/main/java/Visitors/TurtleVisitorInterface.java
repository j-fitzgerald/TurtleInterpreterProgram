package Visitors;

import Interpreter.Commands.*;

public interface TurtleVisitorInterface {
    void visitMove(Move move);
    void visitTurn(Turn turn);
    void visitPenUp();
    void visitPenDown();
    void visitRepeat(Repeat repeat);
    void visitEnd();
    void visitAssignment(Assignment assignment);

}
