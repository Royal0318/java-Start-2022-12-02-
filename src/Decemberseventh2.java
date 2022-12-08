/*
문) while문을 이용하여 몇번째 까지 이어지는지 입력받고 그 후에 정수값을 입력받아 받을때마다 누적되도록 하며
순서에 도달하면 프로그램이 종료되도록 코드를 작성하여라
예)
몇 번째 까지?
순서 : 3
1번째
정수입력 : 2
누적합 : 2
2번째
정수입력 : 3
누적합 : 5
3번째
정수입력 : 5
누적합 : 10
 */
import java.util.Scanner;
public class Decemberseventh2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int a = 1;
        System.out.println("몇 번째 까지?");
        int order = sc.nextInt();
        while (a <= order) {
            System.out.println("정수값을 입력하세요");
            int number = sc.nextInt();
            System.out.println(""+a+"번째 누적합은 "+(sum + number)+"입니다");
            a = a + 1;
            sum += number;
        }
    }
}
