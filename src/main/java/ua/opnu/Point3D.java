package ua.opnu;

public class Point3D extends Point {


    private int z;


    public Point3D() {

        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y); // Виклик конструктора Point(x, y)
        this.z = z;
    }


    public int getZ() {
        return this.z;
    }


    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y); // Встановлюємо x та y через батьківський метод
        this.z = z;
    }


    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    @Override
    public String toString() {

        return "(" + getX() + ", " + getY() + ", " + this.z + ")";
    }


    @Override
    public double distanceFromOrigin() {
        // Формула: sqrt(x^2 + y^2 + z^2)
        int x = getX();
        int y = getY();
        return Math.sqrt(x*x + y*y + this.z*this.z);
    }


    public double distance(Point3D p) {
        // Формула: sqrt((x1-x2)^2 + (y1-y2)^2 + (z1-z2)^2)
        int dx = this.getX() - p.getX();
        int dy = this.getY() - p.getY();
        int dz = this.z - p.getZ(); // Або p.z, якщо z не private

        return Math.sqrt(dx*dx + dy*dy + dz*dz);
    }
}