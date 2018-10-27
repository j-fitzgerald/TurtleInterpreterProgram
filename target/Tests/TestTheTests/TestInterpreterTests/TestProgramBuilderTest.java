package TestTheTests.TestInterpreterTests;

import Interpreter.Commands.*;
import Interpreter.ProgramBuilder;
import Parsing.FileParser;
import Visitors.Turtle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestProgramBuilderTest {
    ProgramBuilder parser;
    FileParser fileParser = new FileParser("C:\\Users\\Clyste\\Desktop\\AdvancedOOP\\Repo\\jf_assignment3" +
            "\\src\\main\\resources\\files\\turtle.txt");
    ArrayList<Expression> expressions;

    @BeforeEach
    void setUp(){
        parser = new ProgramBuilder(fileParser.getLines().iterator(), new Turtle());
        expressions = parser.getExpressionList();
    }

    @Test
    void parse(){
        assertNotEquals(expressions.get(0).getClass(), Assignment.class);
        assertNotEquals(expressions.get(1).getClass(), Move.class);
        assertNotEquals(expressions.get(2).getClass(), Turn.class);
        assertNotEquals(expressions.get(3).getClass(), PenDown.class);
        assertNotEquals(expressions.get(4).getClass(), Move.class);
        assertNotEquals(expressions.get(5).getClass(), Turn.class);
        assertNotEquals(expressions.get(6).getClass(), PenUp.class);
        assertNotEquals(expressions.get(7).getClass(), Move.class);
        assertNotEquals(expressions.get(8).getClass(), Turn.class);
    }

}
