import java.util.Scanner;

public class HuiwenNum {

    public static void main(String[] args) {
        //System.out.println("input 1-99999 number: ");
        String s, a = "";
        Scanner in = new Scanner(System.in);
        //ss = in.nextLine();
        s = in.nextLine();
        in.close();
        for(int i = s.length() - 1; i >= 0; i--) {
            a += s.charAt(i);
        }
        System.out.println(s + " is " + s.length() + " bit");
        if(a.equals(s)) {
            System.out.println(s + " is huiwen number");
        } else {
            System.out.println(s + " is not huiwen number");
        }
    }
    
}
