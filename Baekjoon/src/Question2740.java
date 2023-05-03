import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //3
        int M = Integer.parseInt(st.nextToken()); // 2

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) { //첫번째 행렬입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] += Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] arr2 = new int[K][L];

        for (int i = 0; i < K; i++) { //두번째 행렬입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < L; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //행렬의결과를출력
        for (int i = 0; i < N;i++) {
            for (int j = 0; j < L;j++) {
                int sum = 0; //한칸 채우면 변수값 초기화
                for (int k = 0; k < M;k++) {
                    sum += (arr[i][k] * arr2[k][j]);
                }
                System.out.printf(""+sum+" "); //공백이필요하기때문에 한번출력후 공백
            }
            System.out.println(); //줄띄우기
        }
    }
}
