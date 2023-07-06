import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question14716 {
    static int[][] arr;
    static boolean[][] check;
    static int M;
    static int N;
    static int[] X = {-1,-1,0,1,1,1,0,-1}; //12시방향부터
    static int[] Y = {0,1,1,1,0,-1,-1,-1};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M + 1][N + 1];
        check = new boolean[M + 1][N + 1];

        for (int i = 0; i < M;i++) {
            String str = br.readLine();
            String[] cut = str.split(" ");
            for (int j = 0; j < cut.length;j++) {
                arr[i][j] = Integer.parseInt(cut[j]);
            }
        }
        for (int i = 0; i < M;i++) {
            for (int j = 0; j < N;j++) {
                if (arr[i][j] == 1 && !check[i][j]) {
                    dfs(i,j);
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
    public static void dfs (int a,int b) {
        check[a][b] = true;

        for (int i = 0; i < 8;i++) {
            int one = X[i] + a;
            int two = Y[i] + b;

            if (one < M && two < N && one >= 0 && two >= 0 && !check[one][two]) {
                if (arr[one][two] == 1) {
                    dfs(one, two);
                }
            }
        }
    }
}
