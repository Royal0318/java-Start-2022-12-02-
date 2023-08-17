import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question2075 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0 ; i < N;i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < N;j++) {
                int num = Integer.parseInt(st.nextToken());

                if (queue.size() == N) { //일단5개넣고 비교한다 N번째만 비교하면되니까
                    if (queue.peek() < num) { //만약에 peek값이 num보다 작은경우 5번째값만 바꾸면됨
                        queue.poll();
                        queue.add(num);
                    }
                }
                else { //size가 N이아니면 될때까지 넣음
                    queue.add(num);
                }
            }
        }
        System.out.println(queue.peek());
    }
}
