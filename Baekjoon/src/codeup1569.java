import java.util.Scanner;

public class codeup1569 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(f(n, sc));
    }
    static int f (int n, Scanner sc) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        int find = sc.nextInt();

        for (int i = 0; i < arr.length;i++) {
           if (arr[i] == find) {
               return (i+1);
           }
        }
        return -1;
    }
}
