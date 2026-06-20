package cn.edu.ncu.lzc.shape1;

public final class Hexagon extends Shape {
    private double side;

    public double getSide() { return side; }
    public void setSide(double side) { this.side = side; }

    @Override
    public double getArea() { return 3 * Math.sqrt(3) / 2 * side * side; }

    @Override
    public double getPerimeter() { return 6 * side; }
}
