package GoodTests.InterpreterTests;

import Interpreter.Commands.*;
import Interpreter.ProgramBuilder;
import Parsing.FileParser;
import Visitors.Turtle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramBuilderTest {
    ProgramBuilder parser;
    FileParser fileParser = new FileParser("C:\\Users\\Clyste\\Desktop\\AdvancedOOP\\Repo\\jf_assignment3" +
            "\\src\\main\\resources\\turtle.txt");
    ArrayList<Expression> expressions;
    Turtle turtle;
    Program program;

    @BeforeEach
    void setUp(){
        parser = new ProgramBuilder(fileParser.getLines().iterator(), turtle =
                new Turtle());
        expressions = parser.getExpressionList();
        program =  parser.getRootProgram();
    }

    @Test
    void parsedExpressions(){
        assertEquals(expressions.get(0).getClass(), Assignment.class);
        assertEquals(expressions.get(1).getClass(), Move.class);
        assertEquals(expressions.get(2).getClass(), Turn.class);
        assertEquals(expressions.get(3).getClass(), PenDown.class);
        assertEquals(expressions.get(4).getClass(), Move.class);
        assertEquals(expressions.get(5).getClass(), Assignment.class);
        assertEquals(expressions.get(6).getClass(), Turn.class);
        assertEquals(expressions.get(7).getClass(), PenUp.class);
        assertEquals(expressions.get(8).getClass(), Move.class);
        assertEquals(expressions.get(9).getClass(), Turn.class);
    }
}
