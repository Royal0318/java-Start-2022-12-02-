import java.util.Arrays;
import java.util.Scanner;

public class codeup1562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(f(a,b,c));
    }
    static int f (int a,int b,int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;

        Arrays.sort(arr);
        return arr[1];
    }
}
