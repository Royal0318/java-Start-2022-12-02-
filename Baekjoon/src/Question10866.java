import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Question10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < testCase;i++) {
            String str = br.readLine();
            
            if (str.charAt(0) == 'p' && str.charAt(5) == 'b') {
                String[] cut = str.split(" ");
                int temp = Integer.parseInt(cut[1]);
                deque.addLast(temp);
            } else if (str.charAt(0) == 'p' && str.charAt(5) == 'f') {
                String[] cut = str.split(" ");
                int temp = Integer.parseInt(cut[1]);
                deque.addFirst(temp);
            } else if (str.charAt(0) == 'p' && str.charAt(4) == 'f') {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.pollFirst()).append("\n");
                }
            } else if (str.charAt(0) == 'p' && str.charAt(4) == 'b') {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.pollLast()).append("\n");
                }
            } else if (str.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (str.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (str.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.peekFirst()).append("\n");
                }
            } else {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
