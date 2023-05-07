import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1;i <= N;i++) {
            queue.add(i);
        }
        //1부터 N까지 큐에 넣음
        while (true) {
            if (queue.size() == 0) {
                break;
            } else {
                for (int i = 0; i < (K - 1);i++) {
                    queue.add(queue.poll());
                }
                if (queue.size() == 1) {
                    sb.append(queue.poll());
                } else {
                    sb.append(queue.poll()).append(", ");
                }
            }
        }
        //삭제를 계속 반복하면서 index가 0이되었을때 탈출 3이라면 2까지 추가하면서 pop을하고
        //3에 도달했을시 그 부분만 pop한다
        System.out.println("<"+sb+">");
    }
}
