import java.io.*;

public class Question16561 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int inti = 3;
        int intj = 3;
        int intk = 3;
        int check = 0;

        //시간제약이 없을경우 3중포문으로 풀수 있는방법이있다 다만 시간이 오래걸리며 효율적이지 않다
        for (int i = 1;i < 1000;i++) {
            for (int j = 1;j < 1000;j++) {
                for (int k = 1;k < 1000;k++) {
                    if (((inti * i) + (intj * j) + (intk * k) == n)) {
                        check += 1;
                    }
                }
            }
        }
        System.out.println(""+check+"");
    }
}
