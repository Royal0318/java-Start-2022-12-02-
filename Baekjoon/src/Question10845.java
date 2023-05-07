import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Question10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>(); //기본 Q선언

        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        int rear = 0;
        for (int i = 0; i < testCase;i++) {

            String str = br.readLine();

            if (str.charAt(0) == 'p') {
                if (str.charAt(1) == 'u') {
                    String[] st = str.split(" "); //스핏을 쓰는것이 더 편하다
                    if (!queue.isEmpty()) {
                        queue.add(Integer.parseInt(st[1]));
                    } else {
                        queue.add(Integer.parseInt(st[1]));
                    }
                    rear = Integer.parseInt(st[1]);
                } else { //pop
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.poll()).append("\n");
                    }
                }
            } else if (str.charAt(0) == 'f') {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                }
            } else if (str.charAt(0) == 's') {
                sb.append(queue.size()).append("\n");
            } else if (str.charAt(0) == 'e') {
                if (queue.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else { //back
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(rear).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}