import java.util.Scanner;
public class Question11170 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int zeroCount = 0;

        for (int i = 0; i < testcase; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            for (int j = n; j <= m; j++) {
                String str = "" + j + "";
                for (int k = 0; k < str.length();k++) {
                    if (str.charAt(k) == '0') {
                        zeroCount += 1;
                    }
                }
            }
            System.out.println("" + zeroCount + "");
            zeroCount = 0;
        }
        /*
        3중포문을 사용하여 풀었다 0을 뽑아내는문제기이 때문에 chatAt를 사용하였으며 그값이 있을때마다 zerocount변수에
        1씩 저장하였고 for문이 모두 둘면 다시 초기화하여 출력하도록함
         */
    }
}
