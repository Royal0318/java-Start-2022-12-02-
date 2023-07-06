import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1303 {
    static int N;
    static int M;
    static char[][] arr;
    static int[] X = {-1, 0, 1, 0};
    static int[] Y = {0, 1, 0, -1};
    static boolean[][] check;
    static boolean powerCount;
    static int whitePower;
    static int whitePeopleCount = 0;
    static int bluePower;
    static int bluePeopleCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //자신 W 적군 B
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < 2; i++) { //3중포문은 화이트한번 블루한번 구해야하기때문
            check = new boolean[M][N]; //한번 체크하고 돌아오면 boolean초기화
            if (i == 1) { //boolean이 true면 blue가 체크될차례
                powerCount = true;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (!powerCount) { //white 전투력측정
                        if (arr[j][k] == 'W' && !check[j][k]) { //white이면서 방문하지않은경우
                            dfs(j, k);

                            whitePower += Math.pow(whitePeopleCount, 2); //뭉친인원만큼 전투력 제곱
                            whitePeopleCount = 0;
                        }
                    }
                    else { //blue전투력 측정
                        if (arr[j][k] == 'B' && !check[j][k]) { //white이면서 방문하지않은경우
                            dfs(j, k);

                            bluePower += Math.pow(bluePeopleCount, 2);
                            bluePeopleCount = 0;
                        }
                    }
                }
            }
        }
        System.out.println("" + whitePower + " " + bluePower + "");
    }

    public static void dfs(int a, int b) {
        check[a][b] = true;

        if (!powerCount && arr[a][b] == 'W') {
            whitePeopleCount += 1;
        }
        if (powerCount && arr[a][b] == 'B') {
            bluePeopleCount += 1;
        }
        for (int i = 0; i < 4; i++) {
            int one = X[i] + a;
            int two = Y[i] + b;

            if (one < M && two < N && one >= 0 && two >= 0 && !check[one][two]) {
                if (!powerCount && arr[one][two] == 'W') { //white전투력측정
                    dfs(one, two);
                }
                if (powerCount && arr[one][two] == 'B') {
                    dfs(one, two);
                }
            }
        }
    }
}
