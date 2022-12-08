/*if와 else if문을 활용하여 내가 원하는 요일을 도출 할 수 있는 코드를 만들었다
이 문제는 기존 if와 elseif를 활용하는 것 뿐만 아니라 나눗셈을 이용하기 때문에 푸는데 약간의 시간이 소요됐다
여기서 중요한 개념은 나눗셈을 하여서 나머지를 구하는 방법인데 나머지는 remainder 변수값을 해주었으며
나눗셈의 개념으로는 ex)100을 5로 나누어서 나머지와 몫을 도출 할 때
100 % 5 룰 하게된다면 % 는 나머지를 구하기 때문에 나머지 값은 0가 도출되며
100 / 5 를 하게된다면 / 값은 몫을 구하기 때문에 몫의 값은 20이 도출되는 개념이다

문)2022년 12월을 기준으로 요일을 알 고 싶을 때 날짜를 입력받아서 요일값이 출력되도록 코드를 작성하여라
단 1 ~ 31일 범위를 벗어날 시 "1 ~ 31 사이의 값을 입력하세요"라는 문장이 출력되도록 하여야 한다.
*/

import java.util.Scanner;
public class Decembersecond2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("2022년 12월 1일 ~ 31일중 요일을 알고싶은 날짜를 입력해주세요");
        int day = sc.nextInt();
        int remainder = (day % 7);

        if (day <  1 || day > 31) {
            System.out.println("1 ~ 31 사이의 값을 입력하세요");
        }
        if (remainder == day % 7) {
            if (remainder == 5) {
                System.out.println("오늘은 월요일입니다.");
            } else if (remainder == 6) {
                System.out.println("오늘은 화요일입니다.");
            } else if (remainder == 0) {
                System.out.println("오늘은 수요일입니다.");
            } else if (remainder == 1) {
                System.out.println("오늘은 목요일입니다.");
            } else if (remainder == 2) {
                System.out.println("오늘은 금요일입니다.");
            } else if (remainder == 3) {
                System.out.println("오늘은 토요일입니다.");
            } else {
                System.out.println("오늘은 일요일입니다.");
            }
        }
    }
}
