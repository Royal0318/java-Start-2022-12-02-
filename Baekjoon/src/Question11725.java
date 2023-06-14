import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Question11725 {
    static List<Integer>[] arr; //자식노드들
    static boolean[] check; //방문여부
    static int[] p; //부모노드 담는 배열값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        arr = new ArrayList[testCase + 1];
        check = new boolean[testCase + 1];
        p = new int[testCase + 1];

        for (int i = 1; i <= testCase;i++) {
            arr[i] = new ArrayList<>();//list에 1 ~ 7까지 담음
        }
        for (int i = 0; i < testCase - 1;i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            arr[one].add(two);
            //ex) 1 6이면 arr[1]은이미 위에서 선언 그값에 6이다 arr[1] == 6
            arr[two].add(one);
            //서로연결
        }
        dfs(1);
        for (int i = 2; i <= testCase;i++) {
            System.out.println(p[i]); //노드 2부터 부모노드를 출력한다
        }
    }
    public static void dfs (int a) {
        check[a] = true;

        for (int s : arr[a]) { //foreach문을 통해 배열a에속한 부모노드 찾기
            if (!check[s]) { //만약에 방문하지 않았다면
                p[s] = a;
                dfs(s);
            }
        }
    }
}
/*
시뮬레이션 예제
7                                트리를 그린다면
1 6                                   1
6 3                              4         6
3 5                          2      7        3
4 1                                             5
2 4
4 7

이런식으로 트리가 그려진다 즉 부모노드는 자식노드의 위에존재한다 예를들면 2의 부모노드는 4이다
가장 최상위 부모노드는 1이된다
1.dfs(1)을 통해 dfs의 함수를 거쳐 재귀를 통해 부모노드를 찾기 시작한다
2.int a = 1이기 때문에 boolean check[]를통해 1번노드는 지나갔다고 true선언을해줌
3.for each문을 통해 arr[a] 값 즉 arr[1]은 처음에 6번과 연결되었으므로 int s = 6이됨
4.check[6]은 아직 들린적이없으므로 false이다 그러므로 if문이 성립되며
5.부모노드를 저장하는 p배열 p[6] = 1 즉 6번자식노드의 부모노드는 1번이라고 배열에담으며
6.마지막으로 재귀함수를 하기위해 dfs(6) 즉 다음 자식노드를 탐색하는것을 반복한다
 */
