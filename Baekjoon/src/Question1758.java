import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question1758 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long money = 0;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] tip = new int[N];
        for (int i = 1 ; i <= N;i++) {
            arr[i - 1] = i;
        } //도착한 등수
        for (int i = 0 ; i < N;i++) { //팁 입력
            tip[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tip);

        for (int i = 0 ; i < N;i++) {
            if (tip[N - 1 - i] - (arr[i] - 1) < 0) {
                continue;
            }
            money += (tip[N - 1 - i] - (arr[i] - 1));
        }
        System.out.println(money);
        /*
        돈을 long으로하는이유 : 각각사람의 수도 10만까지 팁도 10만까지 가능하다
        그렇다면 10만명이 존재하고 10만원씩 팁을 준다고 가정할때
        1번손님은 10만원 2번손님은 999,999원 3번은 999,998....
        즉 거의 100억에 가까운 값이 나오게되므로 이미 int형 범위를넘어버린다
        그러므로 long으로 해야한다
         */
    }
}
