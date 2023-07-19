import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Question {
    int number;
    int index;

    public Question (int number,int index) {
        this.number = number;
        this.index = index;
    }
}
public class Question2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Question> deque = new ArrayDeque<>();
        int testCase = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= testCase;i++) {
            int temp = Integer.parseInt(st.nextToken());
            deque.add(new Question(temp,i)); //key : temp value : i
        }
        while (!deque.isEmpty()) { //덱이 모두빌때까지 반복
            sb.append("" + deque.getFirst().index + " "); //한번 반복될때마다 덱의 가장앞에 index를 저장한다

            int num = deque.pollFirst().number; //그리고 가장앞에 저장되었던 값을 num에 할당

            if (deque.size() == 1) { //마지막에 1개남았을때 따로 예외처리를 하지않으면 nullpointer가 발생하므로 따로 처리
                sb.append(deque.poll().index);
            }
            else {
                if (num > 0) { //pop한것이 양수일때 횟수 - 1
                    for (int i = 0; i < (num - 1); i++) {
                        deque.addLast(deque.pollFirst());
                    }
                } else { //음수일때는 그대로
                    for (int i = 0; i < Math.abs(num); i++) { //음수가나오면 for문을못돌리므로 절대값시킴
                        deque.addFirst(deque.pollLast());
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
