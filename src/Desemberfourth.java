/*
저번에 이어서 if와 else if의 좀 더 심화된 문제를 풀어보았다
이 문제는 if문과 그리고 새로운 개념인 연산자를 이용하였기 때문에 이론을 익히고 푸는데 시간이 조금 소요되었다
연산자의 종류로는
a < b a가 b보다 작다
a > b a가 b보다 크다
a == b a와 b가 같다
a != b a와 b가 같지 않다
a >= b a가 b보다 크거나 같다
a <= b a가 b보다 작거나 같다
이렇게 정리해 볼 수가 있으며
a || b : a와 b 둘중에 하나만 참이어도 참이다 하지만 둘 다 참이어도 실행한다. a && b : a와 b가 동시에 참이어야 한다.
라는 조건을 여러개 넣을 때 사용할 수 있는 연산자도 있다

문) 처음에 입력받을 수 2가지를 적어주세요
입력 받은 수 2개의 합울 비교하여 틀린경우 시스템을 종료하고 맞은경우 입력 받은 두 수의 크기를 비교한다
맞을경우 "정답입니다!"라는 문장을 출력하고 시스템을 종료하며
틀렸을경우 오답이라고 나오고 정답을 알려주고 시스템을 종료시킨다
만약 같은 수인 경우 "둘이 같은값이라서 비교할수 없습니다"라는 문장이 출력되며 종료되어야한다
위 코드를 작성하시오
 */
import java.util.Scanner;
public class Desemberfourth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("입력받을 2개의 수를 입력해주세요");
        int num = sc.nextInt();
        int num2 = sc.nextInt();
        int total = num + num2;


        System.out.println(""+num+"+"+num2+"= ?");
        int total2 = sc.nextInt();

        if (total2 == total) {
            System.out.println("1."+num+"  2."+num2+"어느쪽이 더 큽니까?");
            int answer3 = sc.nextInt();

            if (answer3 == 1 && num > num2) {
                System.out.println("정답입니다!");
            } else if (answer3 == 1 && num < num2) {
                System.out.println("오답입니다! 정답은 2번입니다");
            } else if (answer3 == 2 && num < num2) {
                System.out.println("정답입니다!");
            } else if (answer3 == 2 && num > num2) {
                System.out.println("오답입니다! 정답은 1번입니다");
            } else if (num == num2) {
                System.out.println("둘이 같은값이라서 비교할수 없습니다");
            }
        }
        if (total2 != total) {
            System.out.println("틀렸습니다 다시해주세요");
        }
    }
}
