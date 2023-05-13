import java.util.Scanner;
import java.util.Stack;

public class Question11724 {
    static int N; //노드의개수
    static int L; //엣지
    static int[][] arr;
    static int count = 0;
    static int result = 0;//기본 1개
    static boolean[] check;

    public static void main(String[] args)  {
       Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();

        arr = new int[N + 1][N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i < L; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = arr[b][a] = 1; //각각 엣지가 이어진것을 체크함
        }
        dfs(1);
    }

    static void dfs(int temp) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 1;i <= N;i++) {
            if (!check[i]) { //아직방문하지 않은경우
                result += 1; //가장처음은 1개부터 시작한다
                stack.push(i); //처음이니까 1부터 push넣음

                while (!stack.empty()) { //만약에 스택이 비어있지 않은경우
                    count = stack.pop(); //pop하여 peek의 값을 count변수에 넣는다

                    check[count] = true; //그 배열을 true로바꿈 트루인것은 한번 방문했다는것을 체크하기위함

                    for(int j = 1 ; j <= N;j++) {
                        if(!check[j] && arr[count][j] != 0) { //만약 방문하지않았고(false) && 서로 연결되어있는경우 (1로 할당했기 때문)
                            check[j] = true; //j도 true
                            stack.push(j); //그 값을 push한다
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
