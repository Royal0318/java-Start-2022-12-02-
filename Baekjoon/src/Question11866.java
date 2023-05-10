import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N;i++) {
            queue.add(i);
        }
        while (true) {
            if (queue.isEmpty()) {
                break;
            } else {
                for (int i = 1; i < K;i++) {
                    queue.add(queue.poll());
                }
                if (queue.size() == 1) {
                    sb.append(queue.poll());
                } else {
                    sb.append(queue.poll()).append(", ");
                }
            }
        }
        System.out.println("<"+sb+">");
    }
}
