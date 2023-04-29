import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[100][100];

        int result = 0;
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());


            for (int j = w; j < (w + 10); j++) { //가로
                for (int k = h; k < (h + 10); k++) { //세로
                    if (arr[j][k] == 0) {
                        arr[j][k] = 1;
                        result += 1;
                    }
                }
            }
        }
        System.out.println(result);
        /*
        색종이의 크기가 10cm이기 때문에 w + 10을 적용 arr = 0이라는것은 검은색종이가 닿지
        않았다는 뜻이며 그럴때 1을부여한다
         */
    }
}
