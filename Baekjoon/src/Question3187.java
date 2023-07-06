import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question3187 {
    static char[][] arr;
    static boolean[][] check;
    static int k = 0;
    static int kTemp = 0; //울타리안에 존재하는 양과 늑대의 숫자 카운트
    static int vTemp = 0;
    static int v = 0;
    static int W;
    static int D;
    static int[] X = {-1, 0, 1, 0};
    static int[] Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //빈공간 . //울타리 # //양 k //늑대 v
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new char[W + 1][D + 1];
        check = new boolean[W + 1][D + 1];

        for (int i = 0; i < W; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);

                if (arr[i][j] == 'k') { //양수 카운트
                    k += 1;
                } else if (arr[i][j] == 'v') { //늑대수 카운트
                    v += 1;
                }
            }
        }
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < D; j++) {
                if (arr[i][j] != '#' && !check[i][j]) {//울타리가 아니면서 방문하지않은경우
                    dfs(i, j);

                    if (kTemp > 0 && vTemp > 0) {
                        if (kTemp <= vTemp) { //늑대가 더많거나 둘의 마리수가 같을경우 늑대가 이김
                            k -= kTemp;
                        }
                        if (kTemp > vTemp) {
                            v -= vTemp;
                        }
                    }
                    kTemp = 0;
                    vTemp = 0;
                }
            }
        }
        System.out.println(""+k+" "+v+"");
    }

    public static void dfs(int a, int b) {
        check[a][b] = true;

        if (arr[a][b] == 'v') {
            vTemp += 1;
        } else if (arr[a][b] == 'k') {
            kTemp += 1;
        }
        for (int i = 0; i < 4; i++) {
            int one = X[i] + a;
            int two = Y[i] + b;

            if (one < W && two < D && one >= 0 && two >= 0 && !check[one][two]) {
                if (arr[one][two] != '#') {
                    dfs(one,two);
                }
            }
        }
    }
}
