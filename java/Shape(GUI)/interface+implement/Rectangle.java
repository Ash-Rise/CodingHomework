package cn.edu.ncu.lzc.shape2;

public final class Rectangle implements Shapable {
    private double x, y, w, h;

    public double getW() { return w; }
    public void setW(double w) { this.w = w; }
    public double getH() { return h; }
    public void setH(double h) { this.h = h; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    @Override
    public double getX() { return x; }

    @Override
    public double getY() { return y; }

    @Override
    public double getArea() { return w * h; }

    @Override
    public double getPerimeter() { return 2 * (w + h); }
}
