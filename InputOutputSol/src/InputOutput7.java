/*

	아래 문제는 바꿔가는 형식의 문제입니다.
	아래 풀어주시면, 이 문제를 바꾼형식의 문제를 풀어볼겁니다.

	처음에 어떤 숫자를 입력받을지 알 수 없지만, 10과 20이라고 가정한다.
	그렇게 하면 아래처럼 나타난다.
	10 + 20 =
	에서 깜빡이게 되고(입력을 받으라는 의미)
	, 위 예시상으로 정답은 30이지만 30을 적지 않을 수도 있다.
	따라서, 오답일 경우 오답이라는 문장과 정답이 몇인지 알려주는 프로그램을 개발하고,
	정답일 경우, 정답입니다 라는 문장과 함께 다음 문제가 나타난다.
	반대로 오답의 경우에는 프로그램이 종료된다.

	1. 10
	2. 20
	둘 중에 어떤 숫자가 더 크냐는 질문을 하게 되고,
	위 예시상으로 정답은 2번이지만 1번일 수도 있다.
	정답일 경우 바로 정답이라는 문장과 함께 프로그램을 종료하고,
	오답일 경우 오답이라는 문구와 함께 몇 번이 정답인지 나타난다.


 */
import java.util.Scanner;
public class InputOutput7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int AnswerSum = 0;
        System.out.println("1번째수와 2번째수를 입력");
        int Firstnum = sc.nextInt();
        int Secondnum = sc.nextInt();
        AnswerSum = (Firstnum + Secondnum);
        System.out.println(""+Firstnum+" + "+Secondnum+" = ?");
        int Answer = sc.nextInt();

        if (Answer == AnswerSum) {
            System.out.println("정답입니다! 1."+Firstnum+"  2."+Secondnum+" 어느쪽이 더 큽니까?");
            int MostBignum = sc.nextInt();

            if (MostBignum == 1 && Firstnum < Secondnum) {
                System.out.println("틀렸습니다! 정답은 "+Secondnum+"입니다");
            } else if (MostBignum == 1 && Firstnum > Secondnum) {
                System.out.println("정답입니다!");
            } else if (MostBignum == 2 && Firstnum < Secondnum) {
                System.out.println("정답입니다!");
            } else if (MostBignum == 2 && Firstnum > Secondnum) {
                System.out.println("틀렸습니다! 정답은 "+Firstnum+"입니다");
            } else {
                System.out.println("잘못된 입력입니다");
            }
        } else {
            System.out.println("오답입니다! 정답은 : "+AnswerSum+"입니다");
        }
    }
}
