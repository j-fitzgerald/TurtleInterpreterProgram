package TurtleProgram;

import Interpreter.Commands.Expression;
import Interpreter.Commands.Program;
import Interpreter.Commands.VariableHash;
import Interpreter.ProgramBuilder;
import Parsing.FileParser;
import Visitors.Turtle;
import Visitors.*;

import java.util.ArrayList;

public class TurtleProgram {

    private ArrayList<Expression> expressionList;
    private ArrayList<TurtleVisitorInterface> visitorList;
    private Turtle turtle;
    DistanceVisitor distanceVisitor;
    private Program program;

    public TurtleProgram(String source, Turtle turtle,
                         ArrayList<TurtleVisitorInterface> visitorList) {
        this.turtle = turtle;
        VariableHash.map.clear();
        FileParser fileParser = new FileParser(source);
        ProgramBuilder parser =
                new ProgramBuilder(fileParser.getLines().iterator(),turtle);
        program = parser.getRootProgram();

        //expressionList = parser.getExpressionList();
        this.visitorList = visitorList;
        for (TurtleVisitorInterface visitors: visitorList){
            if (visitors.getClass().equals(DistanceVisitor.class))
                distanceVisitor = (DistanceVisitor)visitors;
        }
    }

    public void run() {
        /*
        for (Expression e : expressionList) {
            if (e == null) {
                System.out.println("ERROR - null expression detected");
                continue;
            }
            e.evaluate();
        }
        */
        program.evaluate();

        for (TurtleVisitorInterface v : visitorList) {
            program.visit(v);
        /*    for (Expression e : expressionList) {
                e.visit(v);
            }
        */
        }

        if (distanceVisitor != null)
            System.out.println(distanceVisitor);


    }
}
