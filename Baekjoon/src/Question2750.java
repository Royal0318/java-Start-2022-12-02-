import java.util.Arrays;
import java.util.Scanner;

public class Question2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[] arr = new int[testCase];
        for (int i = 0 ; i < testCase;i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0 ; i < testCase;i++) {
            System.out.println(arr[i]);
        }
    }
}
