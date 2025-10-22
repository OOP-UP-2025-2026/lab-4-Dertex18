package ua.opnu;

public class Point {
    private int x;
    private int y;

    public Point() {
        this(0, 0); // Встановлює x=0, y=0
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double distanceFromOrigin() {
        return Math.sqrt(x*x + y*y);
    }
}