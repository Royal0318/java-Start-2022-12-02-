import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][K];

        for (int i = 0; i < N; i++) { //각각배열에 값 입력
            String str = br.readLine();
            for (int j = 0; j < K; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int min = Math.min(N, K);//N과 K중 작은값을 고른다

        //ex = 3 5
        while (min > 0) { //최종 1X1행까지 가능하도록함
            for (int i = 0; i <= N - min; i++) { //0으로 고정
                for (int j = 0; j <= K - min; j++) { //0,1,2 이렇게돔
                    int point = arr[i][j]; //기준꼭지점

                    //   기준 꼭지점 ==  오른쪽 위 꼭지점                    왼쪽 아래꼭지점                             오른쪽 아래꼭지점
                    if (point == arr[i][(j + min) - 1] && point == arr[(i + min) - 1][j] && point == arr[(i + min) - 1][(j + min) - 1]) {
                        System.out.println(""+min * min+""); //정사각형이니까 가X세 같음
                        return; //정답을 찾은경우이므로 바로 프로그램종료시킴
                    }
                }
            }
            min -= 1; //만약에 처음 3X3에서 찾지못하면 2X2에서 찾도록 min -1을함
        }
    }
}
