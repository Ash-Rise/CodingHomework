import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String s0 = "";
    Scanner in = new Scanner(System.in);
    int ton [] = new int[200];
    int h[] = new int[100];
    char s[] = new char[10010];
    int height = 0;

    while(in.hasNextLine()) {
      s0 = in.nextLine();
      s = s0.toCharArray();
      for(var ch: s) {
        ton[ch]++;
      }
    }

    for(int i = 'a'; i <= 'z'; i++) {
      h[ton[i]]++;
      height = Math.max(height, ton[i]);
    }
    //System.out.print(height);
    // for(int i = 1; i <= height; i++) System.out.println(h[i]);

    int width = 0;
    //System.out.println(width);

    for(int i = height; i >= 1; i--) {
      width += h[i];
      for(int j = 1; j <= width; j++)
        System.out.print("#");
      System.out.print("\n");
    }

  }
}
