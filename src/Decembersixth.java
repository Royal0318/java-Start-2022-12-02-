/*
오늘부터는 while문을 새로 시작합니다 while문이란 반복문이며 while과 for문이 반복문의 대표적인 예입니다
while문의 특징은
1.조건식이 true일때 실행
2.문장의 수행이 끝나면 조건식을 다시 확인후에 실행 flase가 될 때까지 실행한다
3.flase가 성립되면 그때 종료를합니다
무한적으로 반복하고싶을때 자주 사용함
위 내용을 숙지하고 여러가지 기초 예재를 풀어 본 후
가장 많이 풀어보는 구구단 1~9단까지를 한번의 실행으로 나오도록 코드를 만들어 보았다.

각 단수를 따로 만들었을 때는 while문 1가지로 가능하지만 1~9단을 모두 만들기 위해서 중첩 while문을 사용하였다
매커니즘을 보면 내부에 있는 while(b<=9)가 먼저 false가 될 때 까지 반복적으로 수행하며
flase후에 탈출하여 바깥으로 돌며 a = a + 1 즉 1단이 끝나고 다시 2단이시작되고 총 조건을 준 9단까지 실행 되었을때
프로그램이 종료된다
while문이 하나였을때는 쉬웠지만 중첩으로 사용하니 매커니즘을 알고있어야 풀 수 있었다
b = 1이 있는자리는 false가 되었을때 거쳐가는 경로이고 나중에 2중 3중 while문을 쓸 때 꼭 필요한 개념이니 기억해두자!
*/

import java.util.Scanner;
public class Decembersixth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 1;
        int b = 1;
        while (a <= 9) {
            System.out.println("구구단"+a+"단"); //1단을 받은 후에
            while (b <= 9) {  //b<=9가 성립될 때 까지 실행 b값이 9에 도달하면 탈출하여 밖의 while문을 실행
                System.out.println(""+a+" * "+b+" = "+(a * b)+"");
                b = b + 1;
            }
            a = a + 1;
            b = 1;
        }
    }
}
