import java.util.Scanner;

public class codeup1571 {
    static int check = 0;
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n;i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(f(arr,n,target));
    }
    static int f (int[] arr,int n,int target) {
        int start = 0;
        int middle = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= target) {
                check += 1;
            }
        }
        if (check == arr.length) {
            return arr.length+1;
        } else {
            end = (n - 1);
            while (end > start) {
                middle = ((start + end) / 2);

                if (arr[middle] > target) {
                    end = middle;
                } else {
                    start = (middle + 1);
                }
            }
            return (end + 1);
        }
    }
}
