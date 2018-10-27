package TestTheTests.TestInterpreterTests;

import Interpreter.Commands.*;
import Interpreter.ProgramBuilder;
import Parsing.FileParser;
import Visitors.Turtle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestProgramBuilderTest {
    ProgramBuilder parser;
    FileParser fileParser = new FileParser("C:\\Users\\Clyste\\Desktop\\AdvancedOOP\\Repo\\jf_assignment3" +
            "\\src\\main\\resources\\turtle.txt");
    ArrayList<Expression> expressions;
    Turtle turtle;
    Program program;

    @BeforeEach
    void setUp(){
        turtle = new Turtle();
        parser = new ProgramBuilder(fileParser.getLines().iterator(), turtle);
        program =  parser.getRootProgram();
    }

    @Test
    void parsedProgramX(){
        assertEquals(program.size(), 10);
        program.evaluate();
        assertNotEquals((int)turtle.location().getX(),
                (int)new Point2D.Double(-5,5).getX());
    }

    @Test
    void parsedProgramY() {
        assertEquals(program.size(), 10);
        program.evaluate();
        assertNotEquals((int) turtle.location().getY(),
                (int) new Point2D.Double(-5, 5).getY());
    }

    @Test
    void parsedProgramDirection() {
        assertEquals(program.size(), 10);
        program.evaluate();
        assertNotEquals(turtle.direction(), 270);
    }

    @Test
    void parsedProgramPenStatus() {
        assertEquals(program.size(), 10);
        program.evaluate();
        assertFalse(turtle.isPenUp());
    }
}
