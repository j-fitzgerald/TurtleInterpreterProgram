package Interpreter.Commands;

import Visitors.TurtleVisitor;
import Visitors.Visitable;

public interface Expression extends Visitable {
    //void visit(TurtleVisitor visitor);
    int evaluate();
}
