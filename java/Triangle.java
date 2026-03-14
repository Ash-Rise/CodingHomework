import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
    if(b > a) {
        int tmp = a;
        a = b;
        b = tmp;
    } 
    if(c > a) {
        int tmp = a;
        a = c;
        c = tmp;
    }
    double s = Math.sqrt((a + b + c) * (a + b - c) * (a - b + c) * (-a + b + c)) / 4.0;
    if(c + b > a) {
        IO.println("周长: " + (a+b+c));
        IO.println("面积: " + s);
    }

    in.close();
    }
}
