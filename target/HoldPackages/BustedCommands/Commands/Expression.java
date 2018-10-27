package Interpreter.Commands;

import Visitors.Visitable;

public interface Expression extends Visitable {
    int evaluate();
}
