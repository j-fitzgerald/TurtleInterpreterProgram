package Interpreter.Commands;

// Expressions which hold at least one child Expression - see ListExpression for more
// than one child
public interface NonTerminalExpression extends Expression {
    int evaluate();
}
