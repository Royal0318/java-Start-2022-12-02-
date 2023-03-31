import java.util.Scanner;

public class codeup1610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int start = sc.nextInt();
        int n = sc.nextInt();
        f(s, start, n);
    }
    static void f (String s,int start,int n) {
       for (int i = start ; i < (start + n);i++) {
           System.out.printf(String.valueOf(s.charAt(i)));
       }
    }
}
