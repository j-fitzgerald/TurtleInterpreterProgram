package Interpreter;

import Interpreter.Commands.*;
import Visitors.Turtle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

// Interpret Strings into Expressions - Program represents our root
public class ProgramBuilder {
    public static final String MOVE = "move";
    public static final String TURN = "turn";
    public static final String PEN_DOWN = "penDown";
    public static final String PEN_UP = "penUp";
    public static final String ASSIGN = "=";
    public static final String REPEAT = "repeat";
    public static final String END = "end";
    public static final String SPLIT_TOKEN = " ";
    public static final String VARIABLE_TOKEN = "#";
    Iterator<String> iterator;
    String token;
    String splitToken[];
    //ArrayList<Expression> expressionList;
    Turtle turtle;
    Program rootProgram;
    // Switch between rootProgram and any RepeatExpressions
    ListExpression currentExpression;
    // Store ListExpressions in Stack, push on Repeat, pop on End
    Stack<ListExpression> listExpressionStack;

    public ProgramBuilder(Iterator iterator, Turtle turtle){
        this.iterator = iterator;
        this.turtle = turtle;
        //expressionList = new ArrayList<Expression>();
        rootProgram = new Program();
        currentExpression = rootProgram;
        listExpressionStack = new Stack();
        while (iterator.hasNext()) {
            parse();
        }
    }

    // valid expressions return true, else false
    // detects End for Repeat
    public boolean parse() {
        token = iterator.next();
        splitToken = token.split(SPLIT_TOKEN);
        if (token == null) return false;
        else if (token.contains(ASSIGN))
            buildAssignment();
        else if (token.contains(MOVE))
            buildMove();
        else if (token.contains(TURN))
            buildTurn();
        else if (token.contains(PEN_DOWN))
            buildPenDown();
        else if (token.contains(PEN_UP))
            buildPenUp();
        else if (token.contains(REPEAT))
            buildRepeat();
        else if (token.equals(END)){
            if (currentExpression.equals(rootProgram))
                System.out.println("Unexpected End");
            return false;
        }
        else return false;
        return true;
    }

    public void buildAssignment(){
        Assignment assignment;
        assignment = new Assignment(new Variable(splitToken[0]),
                new Value(Integer.parseInt(splitToken[2])));
        //expressionList.add(assignment);
        currentExpression.addExpression(assignment);
    }

    public void buildMove(){
        Move move;
        if (splitToken[1].contains(VARIABLE_TOKEN))
            move = new Move(new Variable(splitToken[1]), turtle);
        else
            move = new Move(new Value(Integer.parseInt(splitToken[1])), turtle);
        currentExpression.addExpression(move);
    }

    public void buildTurn(){
        Turn turn;
        if (splitToken[1].contains(VARIABLE_TOKEN))
            turn = new Turn(new Variable(splitToken[1]), turtle);
        else
            turn = new Turn(new Value(Integer.parseInt(splitToken[1])), turtle);
        currentExpression.addExpression(turn);
    }

    public void buildPenDown(){
        PenDown penDown = new PenDown(turtle);
        currentExpression.addExpression(penDown);
    }

    public void buildPenUp(){
        PenUp penUp = new PenUp(turtle);
        currentExpression.addExpression(penUp);
    }

    public void buildRepeat(){
        listExpressionStack.push(currentExpression);
        Repeat repeat;
        if (splitToken[1].contains(VARIABLE_TOKEN))
            repeat = new Repeat(new Variable(splitToken[1]));
        else
            repeat = new Repeat(new Value(Integer.parseInt(splitToken[1])));
        currentExpression = repeat;
        while (parse() == true){
            // keep parsing until we get an End
        }

        currentExpression = listExpressionStack.pop();
        currentExpression.addExpression(repeat);
    }

    public Program getRootProgram(){
        return rootProgram;
    }
}