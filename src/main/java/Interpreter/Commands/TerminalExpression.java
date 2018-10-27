package Interpreter.Commands;

// Expressions which have no children
public interface TerminalExpression extends Expression {
    int evaluate();
}
