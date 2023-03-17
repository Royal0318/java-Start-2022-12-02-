import java.util.Scanner;

public class Question9094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int i = 0; i < test;i++) {
            int count = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            //2개의 값을 입력한다 조건으로 a < b < n이니까 조심
            for (int j = 1; j < n;j++) {
                for (int k = (j + 1); k < n;k++) {
                    if (((k * k) + (j * j) + m)%(k * j) == 0) {
                        count += 1;
                    }
                }
            }
            /*
            j는 n까지 돌지만 n이 10이라고 가정할때 j는 9까지 돈다 하지만 k는 돌지않기때문에 그것은 무효가 되며
            최종적으로 j는 8까지 카운트가된다  안쪽for문이 b이다 안쪽은 a보다 작으면안되니까 j + 1이다
             */
            System.out.println(""+count+"");
        }
    }
}
