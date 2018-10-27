# TurtleInterpreterProgram
Turtle program using the Interpreter, Visitor, and Memento Patterns

Objective

    read Turtle instructions from a file
    use the Interpreter Pattern to parse the given instructions
    use the Visitor Pattern to properly execute the instructions provided by the Interpreter to request the appropriate execution
    use the Memento Pattern to save the state of the Turtle after every execution
        allow user to observe the turtles state at any particular point of execution

Challenges and solutions:

    1)initial tree construction - most examples of Interpreter (booleans, calculators) form trees naturally
    solution: the program is a root, with all instructions as separate children. Repeat instructions branch to more children instructions
    
    2)Evaluate controls turtle, Memento to save:
    description: if the turtle evaluates to completion, then MementoVisitor traverses the tree - it will store Mementos of the turtle only at the end point.
    solution: each visitor has its own Turtle instance. Evaluate sends the main Turtle through the program.  MementoVisitor then sends a fresh turtle through and creates Mementos at each step.
    
    3) TurtleControllerVisitor
    description: I thought it was an interesting idea to have a Visitor just to control the turtle - can alter the Visitor to adjust turtle behavior, everything is handled in visit() instead of evaluate, etc. Might be more adaptable.
    Discussed with professor - doesn't necessarily add anything that we cannot do by creating sub-classes of turtle to alter behavior.  Warned that any time you have a Class called 'Controller' you are just asking for trouble
    Solution: remove the TurtleControllerVisitor.
