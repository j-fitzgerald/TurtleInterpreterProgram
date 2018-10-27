package GoodTests.InterpreterTests;

import Interpreter.Commands.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignmentTest {
    String name = "test";
    Value value = new Value(5);
    Assignment assignment;
    Value secondValue = new Value(10);


    @Test
    void assignmentTest(){
        // Can make variables
        assignment = new Assignment(new Variable(name), value);//, value);
        assertEquals(assignment.evaluate(), 5);
        Variable variable = new Variable(name);
        // can change the value while keeping same name
        assignment = new Assignment(variable, secondValue);
        assertEquals(assignment.evaluate(), 10);
    }

}
