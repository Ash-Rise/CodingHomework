package cn.edu.ncu.lzc.shape1;

public final class Triangle extends Shape {
    private double side;

    public double getSide() { return side; }
    public void setSide(double side) { this.side = side; }

    @Override 
    public double getArea() { return Math.sqrt(3) / 4 * side * side; }

    @Override 
    public double getPerimeter() { return 3 * side; }
}
