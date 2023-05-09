import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Question11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        //최대값부터 출력되는 큐 선언
        for (int i = 0; i < testCase;i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0 && queue.isEmpty()) {
                sb.append(0).append("\n");
            } else if (num == 0) {
                sb.append(queue.poll()).append("\n");
            } else {
               queue.add(num);
            }
        }
        System.out.println(sb);
    }
}
