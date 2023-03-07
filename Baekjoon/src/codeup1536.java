import java.util.Arrays;
import java.util.Scanner;

public class codeup1536 {
    public static void main(String[] args) {
        System.out.println(""+f()+"");
    }
    static int f () {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int small = 0;
        int[] arr = new int[n];

        for (int i = 0; i < arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        small = arr[0];
        return small;
    }
}
