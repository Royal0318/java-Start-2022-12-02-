/*
문)정수값을 입력받아 1부터 입력받은값까지 1씩 증가된 값을 누적하여 합을 구하는 코드를 작성하시오
예)정수입력 : 3
누적합 : 6
정수입력 : 5
누적합 : 15

여기서 주의해야 할 점이있다 sum에서 모두 누적시킨후에 for문 안에서 출력을 진행하기 된다면 각각의 더한 값이
모두 출력되어 입력이 3개면 3개의 값이 모두출력되게 된다
그러므로 for문이 Number 값에 도달하여 false가 되어 빠져나갈때 출력을 해줘야 원활하게 정답이 나온다
 */
import java.util.Scanner;
    public class Decembereleventh2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int Number = sc.nextInt();
            int Sum = 0;

            for (int i = 0; i <= Number; i++) {
                Sum += i;
            }
            System.out.println(""+Sum+"");
        }
    }


