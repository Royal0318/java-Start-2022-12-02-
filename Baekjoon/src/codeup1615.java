import java.util.Scanner;

public class codeup1615 {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        boolean[] arr = new boolean[5001];
        f(start, end,arr);
    }
    static void f(int start, int end,boolean[] arr) {
        for (int k = start; k <= end; k++) {
            for (int i = 1; i < k; i++) {
                int lengthSum = 0;
                String str = "" + i + "";
                for (int j = 0; j < str.length(); j++) {
                    lengthSum += str.charAt(j) - '0';
                }
                if ((i + lengthSum) == k) {
                    arr[k] = true;
                    break;
                }
            }
        }
        for (int i = start;i <= end;i++) {
            if (!arr[i]) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
