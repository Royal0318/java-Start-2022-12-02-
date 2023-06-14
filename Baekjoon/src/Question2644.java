import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Question2644 {
    static List<Integer>[] arr; //자식노드
    static boolean[] check;
    static int result = -1;

    static int testCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        testCase = Integer.parseInt(br.readLine());

        arr = new ArrayList[testCase + 1];
        check = new boolean[testCase + 1];

        st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int son = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= testCase; i++) {
            arr[i] = new ArrayList<>();
        }

        int caseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseNum; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b); //서로연결
            arr[b].add(a);
        }
        dfs(p, son, 0); //부모,자식,0을 보낸다
        System.out.println(result);
    }
    public static void dfs (int s,int e,int temp) {
        if (s == e) { //만약에 부모와 자식이 같은경우에 지나왔던 경로를 카운트한 temp를 result에 할당 만약 아니면 -1을 출력
            result = temp;
            return;
        }
        check[s] = true;

        for (int i = 0; i < arr[s].size();i++) { //size는 arr[s]가연결되어있는 간선개수
            int num = arr[s].get(i); //arr[s].get은 arr[s]랑 연결되어있는 노드(가장가까운것)
            if (!check[num]) {
                dfs(num, e, temp + 1);
            }
        }
    }
}
/*
시뮬레이션
9                              트리
7 3                            1
7                           2      3
1 2                           7
1 3                             8
2 7                               9
2 8
2 9
4 5
4 6
부모와 자식간의 관계는 7과 3이다
그러므로 p = 7 son = 3이며
각각의 간선을 연결후 재귀를돌린다
1.처음에 p = 7, son = 3이며 둘이같지 않기때문에 if문을 지나간다
2.check[s] 즉 check[7]부터 시작하므로 true로 바꿔 들린것을 체크
3.for문을 돌리는데 0부터 시작하며 arr[7].size까지 즉 arr[7]이랑 연결되어있는 간선개수만큼 돌린다
4.num변수에 arr[7]이랑 연결되어있는것중 i값이 0부터 시작하므로
즉 0부터 9까지 도는데 작은값 + 7이랑연결되어있는 자식노드를 변수에 저장
5.만약num에 할당된 값이 false 즉 들리지않았으면 재귀를돌린다
재귀를돌릴때 촌수를 찾아나서는것이므로 temp + 1을해준다 주의 : temp += 1을하면 값이다르게나옴
6.반복
 */
