import java.util.*;

public class Question14235 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        //우선순위 큐를 선언하여 들어오는 값들을 자동정렬
        StringBuilder sb = new StringBuilder();
        int testCase = sc.nextInt();

        while (testCase --> 0) {
            int num = sc.nextInt();

            if (num == 0) {
                if (queue.isEmpty()) { //큐가 비어있는경우 즉 줄 선물이 존재x
                    sb.append(-1).append("\n");
                }
                else { //큐를 poll하면서 sb에 값 저장
                   sb.append(queue.poll()).append("\n");
                }
            } else { //거점에서 충전하는경우
                for (int i = 0 ; i < num;i++) {
                    queue.add(sc.nextInt());
                }
            }
        }
        System.out.println(sb); //정답출력
    }
}
