import java.util.Scanner;

public class Question3040a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int length = 8;
        int sum = 0;
        for (int i = 0; i < arr.length;i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        f(arr, sum,length);
    }
    static void f (int[] arr,int sum,int length) {
        for (int i = length; i >= 1;i--) {
            for (int j = (i-1); j >= 0;j--) {
                if ((sum - (arr[i] + arr[j])) == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    output(arr);
                    return;
                }
            }
        }
        f(arr,sum,(length-1));
    }
    static void output (int[] arr) {
        for (int i = 0; i < 9;i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
