package Interpreter.Commands;

// NonTerminal Expressions which have a list of Expressions to run - Program/Repeat
public interface ListExpression extends NonTerminalExpression{
    void addExpression(Expression expression);

}
