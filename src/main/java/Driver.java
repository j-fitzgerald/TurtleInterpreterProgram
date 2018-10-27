import TurtleProgram.TurtleProgram;
import Visitors.*;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        String path = "C:\\Users\\Clyste\\Desktop\\AdvancedOOP\\Repo\\jf_assignment3" +
                "\\src\\main\\resources\\turtle.txt";
        String repeatPath = "C:\\Users\\Clyste\\Desktop\\AdvancedOOP\\Repo\\jf_assignment3" +
                "\\src\\main\\resources\\repeatFile.txt";
        String nestedRepeat = "C:\\Users\\Clyste\\Desktop\\AdvancedOOP\\Repo\\" +
                "jf_assignment3\\src\\main\\resources\\nestedRepeat.txt";
        MementoVisitor mementoVisitor = new MementoVisitor();
        DistanceVisitor distanceVisitor = new DistanceVisitor();
        ArrayList<TurtleVisitorInterface> visitorList = new ArrayList();
        visitorList.add(mementoVisitor);
        visitorList.add(distanceVisitor);

        TurtleProgram turtleProgram = new TurtleProgram(path, new Turtle(), visitorList);
        turtleProgram.run();
        System.out.println();
        turtleProgram = new TurtleProgram(repeatPath, new Turtle(), visitorList);
        turtleProgram.run();
        System.out.println();
        turtleProgram = new TurtleProgram(nestedRepeat, new Turtle(), visitorList);
        turtleProgram.run();



    }
}
