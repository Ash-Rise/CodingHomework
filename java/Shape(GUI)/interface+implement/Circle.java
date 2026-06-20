package cn.edu.ncu.lzc.shape2;

public final class Circle implements Shapable {
    private double x, y;
    private double r;

    public double getR() { return r; }
    public void setR(double r) { this.r = r; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    @Override
    public double getX() { return x; }

    @Override
    public double getY() { return y; }

    @Override
    public double getArea() { return Math.PI * r * r; }

    @Override
    public double getPerimeter() { return 2 * Math.PI * r; }
}
