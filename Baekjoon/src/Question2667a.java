import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Question2667a {
    static int[][] arr;
    static boolean[][] check;
    static int[] X = {-1,0,1,0};
    static int[] Y = {0,1,0,-1};
    static int testCase;
    static int result = 0;
    static ArrayList<Integer> resultArr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine());

        arr = new int[testCase][testCase];
        check = new boolean[testCase][testCase];

        for (int i = 0 ; i < testCase;i++) {
            String str = br.readLine();
            for (int j = 0 ; j < testCase;j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0 ; i < testCase;i++) {
            for (int j = 0 ; j < testCase;j++) {
                if (!check[i][j] && arr[i][j] == 1) {
                    bfs(i,j);

                    //돌아오면 1을 체크한 변수를 list에 저장
                    resultArr.add(result);
                    result = 0; //다음 메소드호출을 위한 초기화
                }
            }
        }
        Collections.sort(resultArr);
        System.out.println(resultArr.size());
        for (Integer s : resultArr) {
            System.out.println(s);
        }
    }
    public static void bfs (int a,int b) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(a,b));
        check[a][b] = true;
        result += 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0 ; i < 4;i++) {
                int one = point.x + X[i];
                int two = point.y + Y[i];

                if (one >= 0 && two >= 0 && one < testCase && two < testCase) {
                    if (arr[one][two] >= 1 && !check[one][two]) {
                        check[one][two] = true;
                        result += 1;
                        queue.add(new Point(one,two));
                    }
                }
            }
        }
    }
}
