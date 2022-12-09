/*
오늘은 어제 했던 문제보다 한 층 더 심화된 while문을 풀어 보겠습니다.

문)본인이 생각하는 숫자 ?가지를 더하는 프로그램을 개발해보자!
몇 가지 수를 입력 받을 지 알아봅시다.
아래 예시를 보며 이해해보자
ex)몇개의 숫자를 입력 받으시겠습니까? : 4
처음에 입력받을 숫자 : 1
두번째에 입력받을 숫자 : 2
결과 : 1 + 2 = 3
세번째 숫자 : 5
결과 : 3 + 5 = 8
네번째 숫자 : 2
결과 : 8 + 2 = 10
위 처럼 이어질 수 있도록 while문을 이용하여 코드를 작성하시오.
 */
import java.util.Scanner;
public class Decembereighth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇개의 숫자를 입력 받으시겠습니까?");
        int input = sc.nextInt();
        int a = 2;

        System.out.println("1번째 숫자");
        int firstnumber = sc.nextInt();

        while (a <= input){
            System.out.println(""+a+"번째 숫자");
            int number = sc.nextInt();
            System.out.println(""+firstnumber+" + "+number+" = "+(firstnumber + number)+"");
            a = a + 1;
            firstnumber += number;
        }
        System.out.println(""+input +"번째 숫자까지 도달 하였으므로 프로그램을 종료합니다.");
    }
}
