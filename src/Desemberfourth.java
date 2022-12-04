문) 처음에 어떤 숫자를 입력받을지 알 수 없지만 10과 20이라고 가정을 한다 
그렇게된다면 test를 실행시 10 + 20 = 이 깜빡이게 되며 위 예시상 30이지만 결과값은 다를 수 있다
따라서 그 결과가 오답일 경우 오답이라는 문장과 함께 정답이 몇인지 알려주며 만약에 정답일 경우
"정답입니다"라는 문장과 함께 두 숫자중 큰 숫자를 고르는 문제로 넘어가게된다 반대로
오답을 선택했을 경우 정답을 알려주며 프로그램이 종료된다
위 문제를 충족시킬 수 있는 문제를 if와 else if를사용하여 코드를 작성하시오.



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
