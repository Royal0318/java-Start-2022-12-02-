import java.util.Scanner;

public class Question4963 {
    static int W; //넓이
    static int H; //높이
    static int[] dx = {0,0,1,-1,-1,1,-1,1}; //자신을 기준으로 동서남북 대각선까지 8방향 x,y좌표
    static int[] dy = {1,-1,0,0,-1,1,1,-1};
    static int[][] arr; //각 지도에 체크
    static boolean[][] check; //방문여부 체크
    static int result; //정답
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            result = 0; //반복될때마다 섬의개수 초기화
            W = sc.nextInt(); //너비
            H = sc.nextInt(); //높이

            if (W == 0 && H == 0) {
                break; //시스템 종료조건
            } else {
                arr = new int[H][W];
                check = new boolean[H][W];

                for (int i = 0; i < H;i++) {
                    for (int j = 0; j < W;j++) {
                        arr[i][j] = sc.nextInt();
                    }
                }
                for (int i = 0; i < H;i++) {
                    for (int j = 0; j < W;j++) {
                       if (arr[i][j] == 1 && !check[i][j]) {
                           //0이면바다라 접근X && false는 방문하지 않은곳
                           result += 1;
                           dfs(i,j);
                       }
                    }
                }
                System.out.println(result);
            }
        }
    }
    public static void dfs (int X,int Y) {
        check[X][Y] = true; //방문 여부 check

        for (int i = 0; i < 8;i++) { //자신을 중심으로 사방체크
            int a = X + dx[i]; //다른 좌표들이 1이 넘는경우를 위해 더해줌
            int b = Y + dy[i];

            if (a >= 0 && b >= 0 && a < H && b < W) { //a와 b의값이 0보다크고 범위를 벗어나면 안되기때문에 H,W보다 작아야함
                if (arr[a][b] == 1 && !check[a][b]) { //사방 좌표가 1이라면 연결된것 그곳이 방문한곳이 아니라면
                    dfs(a,b); //재귀를 돌린다
                }
            }
        }
    }
}
