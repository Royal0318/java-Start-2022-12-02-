import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Question1021 {
    static LinkedList<Integer> deque;
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;

        deque = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 1 ; i <= N;i++) {
            deque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < M;i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0 ; i < M;i++) {

            if (check(arr.get(i))) { //왼쪽에 존재하는경우
                while (!Objects.equals(arr.get(i), deque.get(0))) { //i번째 값이 나올때까지 이동시킴
                    deque.addLast(deque.pollFirst());
                    result += 1;
                }
            }
            else { //오른쪽에 존재하는경우 왼쪽으로 이동
                while (!Objects.equals(arr.get(i), deque.get(0))) {
                    deque.addFirst(deque.pollLast());
                    result += 1;
                }
            }
            deque.poll();
        }
        System.out.println(result);
    }
    public static boolean check (int num) {
        for (int i = 0 ; i <= deque.size()/2; i++) {
            if (deque.get(i) == num) {
                return true; //true면 왼쪽에 존재하는것
            }
        }
        return false; //false는오른쪽에 존재
    }
}
