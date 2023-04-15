import java.util.Scanner;

public class Question11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int one = sc.nextInt();
        int two = sc.nextInt();
        int sum = 1;
        int sum2 = 1;


        for (int i = 0; i < two;i++) {
            sum *= (one - i);
        }
        for (int i = 0;i < two;i++) {
            sum2 *= (two - i);
        }
        System.out.println((sum/sum2));
    }
}
