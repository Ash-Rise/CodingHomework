package cn.edu.ncu.lzc.shape1;

public final class Circle extends Shape {
    private double r;

    public double getR() { return r; }
    public void setR(double r) { this.r = r; }

    @Override
    public double getArea() { return Math.PI * r * r; }

    @Override
    public double getPerimeter() { return 2 * Math.PI * r; }
}
