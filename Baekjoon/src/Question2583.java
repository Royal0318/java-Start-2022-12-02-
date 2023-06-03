import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question2583 {
    static int M; //세로
    static int N; //가로
    static int testCase; //테스트케이스
    static int caseNumber; //총 분리된 영역
    static int[][] arr; //영억 저장
    static int count; //분리된 영역 개수 저장
    static int[] X = {1, 0, -1, 0}; //X와 Y의 상하좌우 좌표
    static int[] Y = {0, 1, 0, -1};
    static ArrayList<Integer> arrayList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        arrayList = new ArrayList<>();
        M = sc.nextInt(); //세로
        N = sc.nextInt(); //가로
        testCase = sc.nextInt();

        arr = new int[M][N];

        for (int i = 0; i < testCase; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            //0,0좌표가 아래를 향하였기때문에 모양을 뒤집어서 원래대로 향하도록한다
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    arr[j][k] = 1;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) { //빈 영역인경우
                    count = 1; //넓이 개수 1개추가
                    caseNumber += 1; //넓이 시작카운트 1개추가
                    dfs(i, j);
                    arrayList.add(count); //재귀를 한번돌고 여기를온다는뜻은 더이상 갈곳이 없어서
                    //새로운곳을 다시받기위하여 왔다는뜻이다
                }
            }
        }
        System.out.println(caseNumber);
        Collections.sort(arrayList); //오름차순 정렬이기때문에 Arrays.sort보다 빠른정렬을씀
        for (int s : arrayList) {
            sb.append(s-1).append(" ");
        }
        System.out.println(sb);
    }

    public static void dfs(int a, int b) {
        arr[a][b] = 1; //재귀를돌면서 방문한곳은 1처리 중복방문 X
        count += 1; //한번돌때마다 넓이개수를 1개씩 올린다

        for (int i = 0; i < 4; i++) {
            int aX = a + X[i];
            int bY = b + Y[i];

            if (aX >= 0 && bY >= 0 && aX < M && bY < N) { //영역을 벗어나면안됨
                if (arr[aX][bY] == 0) { //빈영역인경우 다음 이어진 빈 영역을찾기위해 재귀 돔
                    dfs(aX, bY);
                }
            }
        }
    }
}
