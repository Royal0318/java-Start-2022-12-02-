import java.util.Scanner;

public class codeup1535 {
    public static void main(String[] args){
        System.out.println(""+f()+"");
    }
    static int f () {
        int icount = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = arr[0];
        for (int i = 0; i < arr.length;i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i]) {
                max = arr[i];
                icount = i;
            }
        }
        return (icount+1);
    }
}
