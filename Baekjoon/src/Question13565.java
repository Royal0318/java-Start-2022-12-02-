import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question13565 {
    static int[][] arr;
    static boolean[][] check;
    static int[] X = {-1,0,1,0};
    static int[] Y = {0,1,0,-1};
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) { //맨위부터 시작
            check = new boolean[M + 1][N + 1]; //한바퀴돌고올때마다 초기화
            if (arr[0][i] != 1) { //1이 아닌것 즉 흰색만통과
                dfs(0, i);
            }
        }
        System.out.println("NO");
        //맨위에서 전류를보내주고 맨밑에 닿으면 yes아니면 false 1은 검은색 0만지나가야함
    }
    public static void dfs(int a,int b) {
        check[a][b] = true;

        if (a == (M - 1)) { //a가 M - 1까지왔다는의미는 맨밑라인까지 도달했다는뜻이며 곧 전류가통한다는의미
            System.out.println("YES");
            System.exit(0); //바로 시스템종료
        }

        for (int i = 0; i < 4;i++) { //4방체크
            int one = X[i] + a;
            int two = Y[i] + b;

            if (one >= 0 && two >= 0 && one < M && two < N) { //범위를벗어나지않음
                if (arr[one][two] != 1 && !check[one][two]) { //검은색이 아니면서 방문하지않은경우
                    dfs(one, two);
                }
            }//종료조건 : M - 1에 닿았을때
        }
    }
}
