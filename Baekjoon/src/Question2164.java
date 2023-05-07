import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Question2164 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 1; i <= num;i++) {
      queue.add(i);
    }
    //1부터 num까지 숫자를 추가 단 거꾸로 큐에 담는다
    while (queue.size() >= 1) {
      if (queue.size() == 1) {
        break;
      }
      queue.poll();
      queue.add(queue.poll());
    }
    //size가 1이되면 break 그전까지 pop하면서 pop할때 값을 다시 가장위로 추가한다
    System.out.println(queue.poll()); //마지막으로 남은 값을 pop하면서 종료한다
  }
}




