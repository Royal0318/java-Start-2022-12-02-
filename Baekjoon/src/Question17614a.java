import java.util.Scanner;

public class Question17614a {
    public static void main(String[] args) {
        int count = 0;

        System.out.println(f(count));
    }
    static int f (int count) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 3; i <= n;i++) {
            String str = ""+i+"";
            for (int j = 0; j < str.length();j++) {
                if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                    count += 1;
                }
            }
        }
        return count;
    }
}
