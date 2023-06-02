import java.io.IOException;
import java.util.Scanner;

public class Question1012 {
    static int[][] arr; //배추가 심어져있는 땅
    static boolean[][] check; //밭 방문 여부 확인
    static int rows;
    static int col;
    static int t;
    static int[] X = {1,0,-1,0}; //사방 좌표
    static int[] Y = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int i = 0 ; i < testCase;i++) {
            int result = 0; //정답
            rows = sc.nextInt(); //가로
            col = sc.nextInt(); //세로
            t = sc.nextInt();

            arr = new int[rows + 1][col + 1]; //각각 크기에 따른 배열값 선언
            check = new boolean[rows + 1][col + 1];

            for (int j = 0; j < t;j++) {
                arr[sc.nextInt()][sc.nextInt()] = 1;
            }
            for (int j = 0; j < rows;j++) {
                for (int k = 0; k < col;k++) {
                    if (arr[j][k] == 1 && !check[j][k]) { //만약 1이면서 방문하지 않은경우
                        result += 1; //정답을 1개올리고
                        dfs(j,k); //나머지 재귀함수 실행
                    }
                }
            }
            System.out.println(result); //정답 출력
        }
    }
    public static void dfs (int q,int w) {
        //방문하였으므로 체크
        check[q][w] = true;
        //그다음 4방을 체크

        for (int i = 0; i < 4;i++) {
            int sumOne = q + X[i];
            int sumTwo = w + Y[i];

            //각각이 범위안에 존재해야함
            if (sumOne >= 0 && sumTwo >= 0 && sumOne < rows && sumTwo < col) {
                if (arr[sumOne][sumTwo] == 1 && !check[sumOne][sumTwo]) {
                    //사방을 체크했을때 그값이 방문하지않은 false이면서 1인경우
                    dfs(sumOne, sumTwo); //그 다음으로 재귀를돌린다
                }
            }
        }
    }
}
