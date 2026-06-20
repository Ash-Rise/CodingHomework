package cn.edu.ncu.lzc.shape2;

public sealed interface Shapable permits Circle, Rectangle, Hexagon, Triangle {
    double getArea();
    double getPerimeter();
    double getX();
    double getY();
}
