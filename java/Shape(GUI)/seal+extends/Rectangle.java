package cn.edu.ncu.lzc.shape1;

public final class Rectangle extends Shape {
    private double w;
    private double h;

    public double getW() { return w; }
    public void setW(double w) { this.w = w; }
    public double getH() { return h; }
    public void setH(double h) { this.h = h; }

    @Override
    public double getArea() { return w * h; }

    @Override
    public double getPerimeter() { return 2 * (w + h); }
}
