import java.util.Scanner;

public class Main {

  static int dx[] = {0, 1, 0, -1, 0, 1, 0, -1};
  static int dy[] = {1, 0, -1, 0, 1, 0, -1, 0};
  static int a[][] = new int[20][20];
  static int n;
  static int u = 0;

  public static void dfs(int x, int y, int dir) {
    a[x][y] = ++u;
    //if(u % n == 0) System.out.print("\n");

    for(int i = dir; i <= dir+3; i++) {
      int tx = x + dx[i], ty = y + dy[i];
    
      if(tx < 1 || tx > n || ty < 1 || ty > n) continue;

      if(a[tx][ty] == 0) {
        dfs(tx, ty, i%4);
        break;
      }
    }
  }



  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    dfs(1, 1, 0);

    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= n; j++)
        System.out.printf("%5d", a[i][j]);
      System.out.print("\n");
    }
  }
}
