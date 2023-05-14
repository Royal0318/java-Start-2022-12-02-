import java.util.Scanner;

public class Question2606 {
    static int[][] arr;
    static boolean[] check; //감염 여부 check
    static int result = 0; //감염된 컴퓨터 대수 체크
    static int computer; //전역변수로 선언
    static int number;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        computer = sc.nextInt(); //컴퓨터 대수
        number = sc.nextInt(); //간선수

        arr = new int[computer + 1][computer + 1];
        check = new boolean[computer + 1];

        for (int i = 0; i < number; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();

            arr[c1][c2] = arr[c2][c1] = 1; //서로 연결
        }
        dfs(1);
        System.out.println(result);
    }

    static void dfs(int temp) {
        check[temp] = true;

        for (int i = 1; i <= computer;i++) {
            if (!check[i] && arr[temp][i] == 1) {
                dfs(i); //temp와 이어져있다면 다음 재귀돌때 temp = i
                result += 1;
            }
        }
    }
}
