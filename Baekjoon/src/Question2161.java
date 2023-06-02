import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Question2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            queue.add(i + 1);
        }
        for (int i = 0; i < num; i++) {
            sb.append(queue.poll()).append(" ");

            if (!queue.isEmpty()) {
                int temp = queue.poll();

                queue.add(temp);
            }
        }
        System.out.println(sb);
    }
}
