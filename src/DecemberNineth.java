/*
오늘은 while문을 건너 for문을 익혔다
많은 사람들이 while문과 for문의 차이가 무엇이냐고 궁금해 하는데 결론적으론 반복문인건 같지만
차이점은 가독성에서 나타난다 for문은 괄호 안에만 봐도 어디서부터 어디까지 진행되는지 알 수 있다
for문의특징은 for(초기식,조건식,증감식) 으로 되어있으며 반복횟수가 정해져있을때 for문
무한반복 할 시 while문을 사용하면 좋다
서로 반복문이라 초기,조건,증감식위치만 다를뿐이라서 1단부터 9단까지 기초적인 구구단을 만들어 보았다
내부에 있는 for문이 a = 1을 받고 b가 9되면 false가되어 다시 밖으로 나가 a의 2를 받고 다시 9까지 도는 매커니즘
그렇게 1단부터 9단까지 돌 수 있는것이다
 */
import java.util.Scanner;
public class DecemberNineth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 1;
        int b = 1;
        for (a = 1;a <= 9;a ++){
            for (b = 1;b <= 9; b++) {
                System.out.println(""+a+" * "+b+" = "+(a * b)+"");
            }
        }
    }
}
