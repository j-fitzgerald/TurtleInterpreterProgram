package Interpreter.Commands;

import Visitors.Visitable;

// Any Expression in the tree - all must be Visitable so we can use visitors
public interface Expression extends Visitable {
    int evaluate();
}
