/*
while문을 이용하여 좀 더 심화된 문제를 풀어보았다 이 문제에서 새로 등장하는 개념 "누적"개념이
추가되었다
조건식을 입력받은 정수의 값만큼 증가하며 a값이 number값보다 하나작을때 false가 되어 종료된다
a가 0인상태에서 한 바퀴를 돌면 0의값이 sum에 누적되어 처음에는 100이 출력될 것이며
a가 1인상태에서 두번째 바퀴를 돌면 1의 값이 sum에 누적되기 때문에 101이 출력 될 것이다
이렇게 false(a값이 num보다 하나 작아질 때 까지)가 실행되면 프로그램이 종료 되는 것 이다
추가된 값을 누적 하고싶다면 += 누적값을 빼고싶다면 -=로 적으면 된다

문)정수값을 입력받아 1부터 입력 받은 값까지 1씩 증가된 값을 출력하는 코드를 작성한다
단,1부터 시작하는 값이 아닌 100부터 시작하는 형태로 출력되어야 한다
예)정수입력 2 출력값 100 101
 */
import java.util.Scanner;
public class Decemberseventh {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int sum = 100;
        System.out.println("정수를 입력해주세요");
        int number = sc.nextInt();
        while (a < number) {
            System.out.println(""+(100 + a)+"");
            a = a + 1;
            sum += a;
        }
    }
}
