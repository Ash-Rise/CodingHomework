package cn.edu.ncu.lzc.shape2;

public final class Hexagon implements Shapable {
    private double x, y, side;

    public double getSide() { return side; }
    public void setSide(double side) { this.side = side; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    @Override
    public double getX() { return x; }

    @Override
    public double getY() { return y; }

    @Override
    public double getArea() { return 3 * Math.sqrt(3) / 2 * side * side; }

    @Override
    public double getPerimeter() { return 6 * side; }
}
