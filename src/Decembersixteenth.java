/*
문) 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
입력은 여러 개의 테스트 케이스로 이루어져 있다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
예 ) 입력 : 1,1 출력 : 2
    입력 : 2,2 출력 : 4

이문제의 특징은 보면알겠지만 무한반복이끝나는 조건을 따로 주지 않았다
그러므로 강제로 다른방법으로 종료를 시키는방법을 알아야한다 이런문제를 EOF문제라고한다
Scanner in = new Scanner(System.in); 과 while에 true대신 in.hasNext() 을 쓰면된다
그리고 hasnext라는 메소드를 이용해서 특정 예외값이 입력 되었을때 예외를 던져 프로그램을 종료시킨다
 */
import java.util.Scanner;
public class Decembersixteenth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(""+(a + b)+"");
        }
    }
}