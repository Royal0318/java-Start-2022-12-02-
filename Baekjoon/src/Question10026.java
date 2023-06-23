import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10026 {
    static int testCase;
    static int[] X = {-1,0,1,0};
    static int[] Y = {0,1,0,-1};
    static boolean[][] check;
    static int end;
    static char[][] arr;
    static int result; //일반사람
    static int result2; //적록색약인사람
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine());

        arr = new char[testCase + 1][testCase + 1];
        StringTokenizer st;

        for (int i = 0; i < testCase;i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < testCase;j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        for (int k = 0; k < 2;k++) { //일반은 k = 0 적록색약은 k = 1
            check = new boolean[testCase + 1][testCase + 1]; //매번 초기화
            if (k == 1) { //k = 1인것은 일반사람의 카운트가 모두끝났기때문에 적록색약의 차례다
                end = 1; //이 변수를사용하여 일반사람 if문이 동작하지 않도록함
                change(); //change함수를 호출하여 G를 R로 변환
            }
            for (int i = 0; i < testCase; i++) {
                for (int j = 0; j < testCase; j++) {
                    if (!check[i][j] && end == 0) { //일반
                        dfs(i, j, arr[i][j]);
                        result += 1;
                    }
                    if (!check[i][j] && end == 1) { //적록
                        dfs(i, j, arr[i][j]);
                        result2 += 1;
                    }
                }
            }
        }
        System.out.println(""+result+" "+result2+""); //정답
    }
    public static void dfs (int a,int b,char save) { //일반사람
        check[a][b] = true;//방문여부체크

        for (int i = 0; i < 4;i++) {
            int one = X[i] + a;
            int two = Y[i] + b;

            if (one >= 0 && two >= 0 && one < testCase && two < testCase) { //인덱스에 벗어나지않는범위
                if (arr[one][two] == save && !check[one][two] && end == 0) { //일반사람꺼
                    dfs(one,two,save);
                }
                if (arr[one][two] == save && !check[one][two] && end == 1) { //적록
                    dfs(one,two,save);
                }
            }
        }
    }
    public static void change () {
        for (int i = 0; i < testCase;i++) {
            for (int j = 0; j < testCase;j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }
    }
}
