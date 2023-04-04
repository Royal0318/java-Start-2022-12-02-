import java.util.Scanner;

public class Question2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase;i++) {

            int n = sc.nextInt();
            String str = sc.next();

            for (int j = 0; j < str.length();j++) {
                //String입력한 index만큼 반복
                for (int k = 0; k < n;k++) {
                    //n만큼 반복되어 출력함
                    System.out.print(""+str.charAt(j)+"");
                }
            }
            System.out.println();
        }
    }
}
