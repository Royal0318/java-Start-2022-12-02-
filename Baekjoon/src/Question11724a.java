import java.util.Scanner;
public class Question11724a {
    static int[][] arr;
    static boolean[] check;
    static int result = 0; //정답

    static int node;
    static int edge;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        node = sc.nextInt(); //노드
        edge = sc.nextInt(); //엣지
        arr = new int[node + 1][node + 1]; //2차원 배열로 생성
        check = new boolean[node + 1];

        for (int i = 1; i <= edge; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1; //서로 연결된 엣지 생성
        }

        for (int i = 1; i <= node ; i++) {
           if (!check[i]) {
               dfs(i);
               result += 1;
           }
        }
        System.out.println(result);
    }

    static void dfs(int temp) {
        check[temp] = true;

        for (int i = 1; i <= node; i++) {
            if (!check[i] && arr[temp][i] == 1) {
                dfs(i);
            }
        }
    }
}
