import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question2468 {
    static int[][] arr;
    static boolean[][] check;
    static int result;
    static int max;
    static int[] X = {-1, 0, 1, 0};
    static int[] Y = {0, 1, 0, -1};
    static int testCase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine());

        arr = new int[testCase + 1][testCase + 1]; //배열선언
        max = 1;

        for (int i = 0; i < testCase; i++) { //2차원배열 입력
            String str = br.readLine();
            String[] cut = str.split(" "); //split을 이용하여 공백을 기준으로 자름
            for (int j = 0; j < cut.length; j++) {
                arr[i][j] = Integer.parseInt(cut[j]);
            }
        }

        for (int n = 1; n <= 101; n++) { //해수면높이
            check = new boolean[testCase + 1][testCase + 1]; //한번돌때마다 boolean값 초기화시킴

            for (int i = 0; i < testCase; i++) {
                for (int j = 0; j < testCase; j++) {
                    if (arr[i][j] <= n) { //해수면 높이가 더 높은경우 true이다 true는 잠겼거나 방문한지역이기 때문에 체크안함
                        check[i][j] = true;
                    }
                }
            }
            for (int i = 0; i < testCase; i++) {
                for (int j = 0; j < testCase; j++) {
                    if (!check[i][j]) { //재귀를 돌아와서 새로운지역을 탐색하는경우 즉 잠기지않은지역 찾을시
                        dfs(i, j);
                        result += 1; //다른지역이동시 +1
                    }
                }
            }
            if (result > max) { //만약에 max값보다 지역값이 더크면
                max = result; //max값에 담음
            }
            result = 0; //다음 재귀를 위해서 초기화시킴
        }
        System.out.println(max);
    }

    public static void dfs(int x, int y) {
        check[x][y] = true; //방문했으면 체크

        for (int i = 0; i < 4; i++) { //상하좌우탐색 4곳
            int a = X[i] + x;
            int b = Y[i] + y;

            if (a >= 0 && b >= 0 && a < testCase && b < testCase) { //서로 범위를 벗어나지 않는범위
                if (!check[a][b]) {
                    dfs(a, b);
                }
            }
        }
    }
}
