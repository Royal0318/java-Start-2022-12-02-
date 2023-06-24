import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1743 {
    static int N;
    static int M;
    static int K;
    static int[][] arr;
    static boolean[][] check;
    static int result = 1;
    static int temp;
    static int[] X = {-1,0,1,0};
    static int[] Y = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        check = new boolean[N + 1][M + 1];

        for (int i = 0; i < K;i++) {
            String str = br.readLine();
            String[] cut = str.split(" ");
            int a = Integer.parseInt(cut[0]) - 1;
            int b = Integer.parseInt(cut[1]) - 1;
            arr[a][b] = 1;
        }
        for (int i = 0; i < N;i++) {
            for (int j = 0; j < M;j++) {
                if (arr[i][j] == 1 && !check[i][j]) {
                    temp = 0;
                    dfs(i,j);
                    if (temp > result) {
                        result = temp;
                    }
                }
            }
        }
        System.out.println(result);
    }
    public static void dfs (int a,int b) {
        check[a][b] = true;
        temp += 1;

        for (int i = 0; i < 4;i++) {
            int one = X[i] + a;
            int two = Y[i] + b;

            if (one >= 0 && two >= 0 && one < N && two < M) {
                if (arr[one][two] == 1 && !check[one][two]) {
                    dfs(one, two);
                }
            }
        }
    }
}