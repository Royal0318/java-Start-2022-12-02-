import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Question27497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<String> deque = new LinkedList<>(); //알파벳을 담는 덱
        Deque<Integer> number = new LinkedList<>(); //순서를 담는 덱

        for (int i = 1 ; i <= testCase;i++) {
            String str = br.readLine();

            String[] cut = str.split(" ");

            if (Objects.equals(cut[0], "1")) { //1번케이스인경우
                deque.addLast(cut[1]);
                number.addLast(i);
            }
            else if (Objects.equals(cut[0],"2")) { //3번케이스인경우
                deque.addFirst(cut[1]);
                number.addFirst(i);
            }
            else { //그외에 최근에등록된 번호를 pop하는경우
                if (!deque.isEmpty()) { //비어있지않으면 순서를비교하며 최신것을 poll한다
                    int peekFirst = Integer.parseInt(String.valueOf(number.peekFirst()));
                    int peekLast = Integer.parseInt(String.valueOf(number.peekLast()));
                    if (peekLast > peekFirst) {
                        number.pollLast();
                        deque.pollLast();
                    }
                    else {
                        number.pollFirst();
                        deque.pollFirst();
                    }
                }
            }
        }
        if (deque.isEmpty()) { //만약 빈 문자열이 최종적으로나오면 0출력
            System.out.println(0);
            return;
        }
        for (String s : deque) sb.append(s); //그렇지않으면 붙여서 한번에출력
        System.out.println(sb);
    }
}
