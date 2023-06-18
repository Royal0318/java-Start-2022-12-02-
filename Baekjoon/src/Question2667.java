import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Question2667 {
    static int[] X = {-1,0,1,0};
    static int[] Y = {0,1,0,-1};
    static int[][] arr;
    static boolean[][] check;
    static int testCase;
    static ArrayList<Integer> result = new ArrayList<>();
    static int temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine()); //총테스트케이스

        arr = new int[testCase + 1][testCase + 1];
        check = new boolean[testCase + 1][testCase + 1];

        for (int i = 0; i < testCase;i++) {
            String str = br.readLine();
            for (int j = 0; j < testCase;j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        } //여기까지 각 String을 int로 변환하여 배열에 저장

        for (int i = 0; i < testCase;i++) {
            for (int j = 0; j < testCase;j++) {
                if (arr[i][j] == 1 && !check[i][j]) {
                    //만약에 다음값이 1이면서 방문하지않은경우 dfs메소드에 i,j를 넘겨줌
                    temp = 1;
                    dfs(i, j);
                    result.add(temp); //지금까지 누적된 temp값을 Arraylist에 추가하며 dfs메소드로 넘어갈때 temp값이 다시 0으로됨
                }
            }
        }
        Collections.sort(result); //컬렉션솔트로 오름차순정렬
        System.out.println(result.size()); //총 단지수 출력
        for (Integer s : result) { //나머지 연결되어있는 집 개수 출력
            System.out.println(s);
        }
    }
    public static void dfs (int x,int y) {
        check[x][y] = true; //방문하였으므로 체크

        for (int i = 0; i < 4;i++) { //상하좌우4곳체크
            int one = X[i] + x;
            int two = Y[i] + y;

            for (int j = 0; j < testCase;j++) {
                if (one >= 0 && two >= 0) { //index를 벗어나지 않는 범위에서
                    if (arr[one][two] == 1 && !check[one][two]) { //방문하지않았으면서 1인경우
                        temp += 1;
                        dfs(one, two);
                    }
                }
            }
        }
    }
}
