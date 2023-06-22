import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question3184 {
    static int[] x = {-1, 0, 1, 0};
    static int[] y = {0, 1, 0, -1};
    static char[][] arr;
    static boolean[][] check;
    static int sheep = 0; //양의수
    static int wolf = 0;//늑대수
    static int sheepTemp; //임시 양의수
    static int wolfTemp; //임시 늑대수
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R + 1][C + 1];
        check = new boolean[R + 1][C + 1];

        for (int i = 0; i < R; i++) { //각각기호 입력
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) { //늑대 양 을 카운트함
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 'v') { //늑대
                    wolf += 1;
                } else if (arr[i][j] == 'o') { //양
                    sheep += 1;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != '#' && !check[i][j]) { //울타리만 아니면 재귀함수 실행
                    dfs(i, j);

                    if (sheepTemp > wolfTemp) { //재귀에서 돌아와서 양이 더크면 총늑대의 수 - 그 부근에 존재하는 늑대수를뺀다 즉 쫒아냄
                        wolf -= wolfTemp;
                    } else { //아닌경우 양의 수를 줄임
                        sheep -= sheepTemp;
                    }
                    sheepTemp = 0;
                    wolfTemp = 0; //다음을 셈을 위해 초기화
                }
            }
        }
        System.out.println("" + sheep + " " + wolf + ""); //정답출력
    }

    public static void dfs(int a, int b) {
        check[a][b] = true; //방문하였으므로 true전환

        if (arr[a][b] == 'v') { //재귀를돌면서 좌표에 늑대나 양이존재하면 인스턴스번수에 저장
            wolfTemp += 1;
        } else if (arr[a][b] == 'o') {
            sheepTemp += 1;
        }
        for (int i = 0; i < 4; i++) { //사방을 방문함
            int one = x[i] + a;
            int two = y[i] + b;

            if (one >= 0 && two >= 0 && one < R && two < C && !check[one][two]) { //배열 index를 벗어나지 않는 범위 && 방문하지않은경우
                if (arr[one][two] != '#') { //그리고 울타리가 아니고 양이나 늑대 그리고 지형이라면 재귀돔
                    dfs(one, two);
                }
            }
        }
    }
}
