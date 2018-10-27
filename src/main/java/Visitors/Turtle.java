package Visitors;

import java.awt.geom.Point2D;

public class Turtle extends AbstractTurtle{
    private Point2D location;
    private int degrees = 0;
    private boolean penStatus = false;
    public static final int MAX_DEGREES = 360;
    public int name = 0;

    public Turtle(){
        location = new Point2D.Double();
    }

    public void move(int distance) {
        location.setLocation(location.getX()+deltaX(distance),
                location.getY()+deltaY(distance));
    }

    public void turn(int degrees) {
        this.degrees += degrees;
        if (this.degrees >= MAX_DEGREES)
            this.degrees -= MAX_DEGREES;
        else if (this.degrees <0)
            this.degrees += MAX_DEGREES;
    }

    public void penUp() {
        penStatus = false;
    }

    public void penDown() {
        penStatus = true;
    }

    public boolean isPenUp() {
        return !penStatus;
    }

    public int direction() {
        return degrees;
    }

    public Point2D location() {
        return location;
    }

    private double inRadians(){
        return degrees * Math.PI / 180;
    }

    private double deltaX(int distance){
        return Math.cos(inRadians())*distance;
    }

    private double deltaY(int distance){
        return Math.sin(inRadians())*distance;
    }

    public Memento createMemento(){
        Memento state = new Memento(this);
        return state;
    }

    public void restoreState(Memento savedState){
        Memento state = savedState;
        name = state.name;
        location = state.location;
        degrees = state.degrees;
        penStatus = state.penStatus;
    }

    protected class Memento{
        // Shoudl have been Private
        public Point2D location;
        public int degrees;
        public boolean penStatus;
        public int name;

        public Memento(Turtle turtle){
            location = (Point2D)turtle.location.clone();
            degrees = turtle.degrees;
            penStatus = turtle.penStatus;
            name = turtle.name;
        }
    }

    public String toString(){
        return String.format("TURTLE %d\n\tLocation: [%.2f,%.2f]\n\trotation: %d\n\tPen" +
                " Status: %b", name, location.getX(), location.getY(), degrees,
                isPenUp());
    }
}
