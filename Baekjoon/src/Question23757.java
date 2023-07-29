import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Question23757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        //큰수부터 정렬
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N;i++) {
            p.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M;i++) {

            int kids = Integer.parseInt(st.nextToken());

            int pTemp = p.poll();

            if (kids > pTemp) { //선물중 가장큰것이 아이가원하는것보다 큰경우
                System.out.println(0);
                return;
            }
            p.add(pTemp - kids);
        }
        System.out.println(1);
    }
}
