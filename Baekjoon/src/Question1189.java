import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1189 {
    static char[][] arr;
    static boolean[][] check;
    static int result;
    static int[] X = {-1,0,1,0};
    static int[] Y = {0,1,0,-1};
    static int R;
    static int C;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); //총 가야하는 거리수

        arr = new char[R][C];
        check = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        //사람의 출발지점 오른쪽 맨밑
        check[R - 1][0] = true;
        dfs((R-1), 0,1); //시작지점은 본문에 따른 2,0부터 시작하므로
        System.out.println(result);
    }
    public static void dfs (int a,int b,int roadCount) {
        //roadcount는 재귀가끝나고돌아갈때 자동적 초기화
        if (a == 0 && b == (C - 1)) { //끝좌표에 도달했을때
            if (roadCount == K) { //거쳐왔던 도로의개수와 K개가 일치할경우
                result += 1; //경우의수를 1개추가
                return; //되돌아감
            }
        }
        for (int i = 0; i < 4;i++) {
            int one = X[i] + a;
            int two = Y[i] + b;

            if (one < 0 || two < 0 || one >= R || two >= C) { //기존조건들의 반대들은 모두 continue
                continue;
            }
            if (arr[one][two] == 'T' || check[one][two]) {
                continue;
            }
            check[a][b] = true;
            dfs(one, two,roadCount+1);
            check[a][b] = false; //리턴할때 되돌아갈때 모두 false함
        }
    }
}
