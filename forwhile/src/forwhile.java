/*
본인이 생각하는 숫자 ?가지를 더하는 프로그램을 개발해보자.

	몇 가지 수를 입력받을 지 알아보자.
	아래 예시의 경우에는, 4개를 입력받은 경우의 수이다.

	몇 개의 숫자를 입력받으시겠습니까? : 4

	처음에 입력받을 숫자 : 1
	두 번째 숫자 : 2
		1[본인이 생각한 숫자] + 2[본인이 생각한 숫자] = 3
		두 번째 숫자 : 5
		3[결과값] + 5[본인이 생각한 숫자] = 8[결과값]
		두 번째 숫자 : 6
		8[결과값] + 6[본인이 생각한 숫자] = 14[결과값]
 */
import java.util.Scanner;
public class forwhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int whilestart = 2;
        System.out.println("총 반복횟수를 정해주세요");
        int Repetition = sc.nextInt();

        System.out.println("1번째 숫자 입력");
        int First = sc.nextInt();

        while (whilestart <= Repetition) {
            System.out.println(""+whilestart+"번째 숫자 입력");
            int Second = sc.nextInt();
            System.out.println(""+First+" + "+Second+" = "+(First + Second)+"");
            First += Second;
            //두 번째 숫자를 첫 번째에 같이 더해야 다음에 2번째에 오는 숫자를 또입력할때 누적된수에 2번째 숫자를
            //더할 수 있기 때문이다
            whilestart++;
        }
        System.out.println("목표 횟수에 도달하였으므로 프로그램을 종료합니다");
    }
}