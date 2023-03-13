import java.util.Scanner;

public class Question17614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 3; i <= n;i+=1) {
            String str = ""+i+"";
            for (int j = 0; j < str.length();j++) {
                if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                    count += 1;
                }
            }
        }
        System.out.println(""+count+"");
    }
}
