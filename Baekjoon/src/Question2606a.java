import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question2606a {
    static int[][] arr;
    static boolean[] check;
    static int result = 0;
    static int count;
    static int computer;
    static int number;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        computer = sc.nextInt();
        number = sc.nextInt();

        arr = new int[computer + 1][computer + 1];
        check = new boolean[computer + 1];

        for (int i = 0; i < number; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();

            arr[c1][c2] = arr[c2][c1] = 1; //서로 연결
        }
        dfs(1);
    }

    static void dfs(int temp) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(temp);//1번 값 넣음
        check[temp] = true; //1번 true

        while (!queue.isEmpty()) { //큐가 비어있지 않은경우
            count = queue.poll(); //pop하면서 그값을 count에 넣음

            for (int i = 1; i <= computer;i++) {
                if (!check[i] && arr[count][i] == 1) { //인접한 선이존재하는경우
                    check[i] = true; //i를 true
                    result += 1;
                    queue.offer(i); //i를추가한다
                }
                //먼저들어간놈이 먼저나오므로 pop해주면서 돌릴수있다
            }
        }
        System.out.println(result);
    }
}
