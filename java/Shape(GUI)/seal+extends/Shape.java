package cn.edu.ncu.lzc.shape1;

public sealed class Shape permits Circle, Rectangle, Hexagon, Triangle {
    private double x;
    private double y;

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public double getArea() { return 0; }
    public double getPerimeter() { return 0; }
}
