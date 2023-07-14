import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.LinkedList;

public class Question1966 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                queue.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
            }
            int count = 0;
            while (!queue.isEmpty()) {
                int[] front = queue.poll();
                boolean isMax = true;

                for(int i = 0; i < queue.size(); i++) {
                    if(front[1] < queue.get(i)[1]) {
                        queue.offer(front);
                        for(int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                if(isMax == false) {
                    continue;
                }
                count += 1;
                if(front[0] == M) {
                    break;
                }

            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}