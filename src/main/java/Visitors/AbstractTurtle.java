package Visitors;

import java.awt.geom.Point2D;

public abstract class AbstractTurtle {
    abstract void move(int distance);
    abstract void turn(int degrees);
    abstract void penUp();
    abstract void penDown();
    abstract boolean isPenUp();
    abstract int direction();
    abstract Point2D location();
}
