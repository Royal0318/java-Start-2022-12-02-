import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1987 {
    static int R;
    static int C;
    static boolean[] check;
    static int[][] arr;
    static int result; //정답
    static int[] X = {-1, 0, 1, 0};
    static int[] Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R + 1][C + 1];
        check = new boolean[26];//알파벳 총 26개

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - 'A';//알파벳을숫자로 저장
            }
        }
        //입력부 종료
        int temp = 1; //시작지점을 생각하여 1부터시작
        dfs(0, 0, temp); //한바퀴돌고 돌아오면 다른방향으로 찾으러감
        System.out.println(result);
    }

    public static void dfs(int a, int b, int temp) {
        result = Math.max(result, temp);

        check[arr[a][b]] = true; //해당 알파벳 저장

        for (int i = 0; i < 4; i++) { //사방탐색
            int one = X[i] + a;
            int two = Y[i] + b;

            if (one >= 0 && two >= 0 && one < R && two < C && !check[arr[one][two]]) { //범위를 벗어나지않는값
                check[arr[one][two]] = true;
                dfs(one, two, (temp + 1)); //다시탐색을 위해돌림 여기에 도달한건 새로운 알파벳을 발견했으므로 +1추가
                check[arr[one][two]] = false; //돌아가면서 true -- > false 로변경
            }
        }
    }
}
