package TestTheTests.TestInterpreterTests;

import Interpreter.Commands.Assignment;
import Interpreter.Commands.Value;
import Interpreter.Commands.Variable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestAssignmentTest {
    String name = "test";
    Value value = new Value(5);
    Assignment assignment;
    Value secondValue = new Value(10);


    @Test
    void assignmentTest(){
        // Can make variables
        assignment = new Assignment(new Variable(name),value);//, value);
        assertEquals(assignment.evaluate(), 5);
        Variable variable = new Variable(name);
        // can change the value while keeping same name
        assignment = new Assignment(variable, secondValue);
        assertNotEquals(assignment.evaluate(), 10);
    }

}
