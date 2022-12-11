/*
오늘 while문을 풀다가 재미있는 문제를 발견하여 가지고 와서 풀어보았다
문)준원이는 저번 주에 살면서 처음으로 코스트코를 가 봤다. 정말 멋졌다. 그런데, 몇 개 담지도 않았는데 수상하게 높은 금액이 나오는 것이다!
준원이는 영수증을 보면서 정확하게 계산된 것이 맞는지 확인해보려 한다.
영수증에 적힌,
구매한 각 물건의 가격과 개수
구매한 물건들의 총 금액을 보고, 구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하는지 검사해보자.
첫째 줄에는 영수증에 적힌 총 금액 X가 주어진다
둘째 줄에는 영수증에 적힌 구매한 물건의 종류의 수 N이 주어진다.
이후 N개의 줄에는 각 물건의 가격a와 개수b가 공백을 사이에 두고 주어진다
출력 : 구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하면 Yes를 출력 일치하지 않는경우 No를 출력

이 문제의 풀이를 보면 N개의 줄에는 이라는 문장을 보아 반복되면서 가격을 받을 수 있는것을 알 수 있다
그리고 각각의 물건가격을 합산하여 비교해야 하기때문에 if문 그리고 가격을 담는 변수도 필요하다
그래서 int sum을 이용하여 갯수 * 가격이 1번 반복될 때 마다 가격을 누적시켰으며
false가되면 빠져나오는 특성을 가지고있는 while문의 특징을 이용하여 stuff까지 도달 시 if를 거쳐
가격이 일치하면 yes 아니면 no를 출력하도록 코드를 작성해보았다
 */

import java.util.Scanner;
public class Decemberteenth {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int stuff = sc.nextInt();
        int sum = 0;
        int a = 1;
        while (a <= stuff) {
            int Price = sc.nextInt();
            int number = sc.nextInt();
            sum += (Price * number);
            a++;
        }
        if (total == sum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
