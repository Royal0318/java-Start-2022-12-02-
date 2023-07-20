import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1926 {
    static int[] X = {-1,0,1,0};
    static int[] Y = {0,1,0,-1};
    static int[][] arr;
    static boolean[][] check;
    static int n;
    static int m;
    static int pictureCount; //그림 수
    static int resultBigArea = 0;
    static int area; //가장 큰넓이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n;i++) {
            String str = br.readLine();
            String[] cut = str.split(" ");
            for (int j = 0; j < cut.length;j++) {
                arr[i][j] = Integer.parseInt(cut[j]);
            }
        }
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < m;j++) {
                if (arr[i][j] == 1 && !check[i][j]) { //1이면서 방문하지않은곳
                    dfs(i,j);

                    if (resultBigArea < area) { //한바퀴 돌아왔을때 기존넓이보다 더 큰경우
                        resultBigArea = area; //바꾼다
                    }
                    pictureCount += 1; //한번 넓이를 찾을때마다 카운트
                    area = 0; //넓이 초기화
                }
            }
        }
        System.out.println(""+pictureCount+"\n"+resultBigArea+""); //정답출력
    }
    public static void dfs (int a,int b) {
        check[a][b] = true;
        area += 1;
        for (int i = 0; i < 4;i++) {
            int one = X[i] + a;
            int two = Y[i] + b;

            if (one >= 0 && two >= 0 && one < n && two < m) { //범위를 벗어나지 않는 조건
                if (arr[one][two] == 1 && !check[one][two]) {
                    dfs(one,two);
                }
            }
        }
    }
}
