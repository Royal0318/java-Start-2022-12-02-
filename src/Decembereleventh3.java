/*
이번에는 좀 더 어려운 문제에 도전해보았다
문)
정수값을 입력받을 때 지정된 범위의 입력값이 아닌 경우
"?번 기회가 남았습니다"라는 문장을 출력하고
최대 3번 다시 입력 받을 수 있도록 하는 코드를 작성하시오
3번이내로 지정된 범위값을 입력한 경우 "Yes"라는 문장을 출력시킨 후 프로그램을 종료시키고
다시 입력 받은 후에도 틀린경우  출력 값으로 "No"라고 출력하고 프로그램을 종료시키도록 코드를 작성하시오
(지정된 범위는 1 ~ 100 사이의 값이다.)
이문제에서 for문으로도 무한루프를 돌릴 수 있다 범위를 설정하지않고 세미클론만 찍어주면은 무한루프가 작동한다
 */


import java.util.Scanner;
public class Decembereleventh3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Chance = 3;
        for (;;) {
            System.out.println("정수값 입력");
            int Number = sc.nextInt();

            if (Chance == 0) {
                System.out.println("No");
                break;
            }
            if (Number <= 0 || Number > 100) {
                Chance -= 1;
                System.out.println(""+Chance+"번 기회가 남았습니다");
            } else {
                System.out.println("Yes");
                break;
            }
        }
    }
}
