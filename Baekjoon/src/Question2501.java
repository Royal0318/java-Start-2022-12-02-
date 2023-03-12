import java.util.Scanner;
public class Question2501 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a = 1;
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if ((n / i) >= 1 && (n % i) == 0) {
                arr[a] = i;
                //예를들어 i가 300이라고 되면 arr[i] = i라고했을시 arr[300] = 300이므로 반례로 작용됨 그러므로 순서대로 담아지도록 별도의 변수가 필요하다
                a++;
            }
        }
        if (n > k) {
            System.out.println("" + arr[k] + "");
        } else {
            System.out.println(""+0+"");
        }
    }
}
