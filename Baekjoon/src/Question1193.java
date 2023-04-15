import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1193 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

       for (int i = 1;i <= 10000000;i++) {
           if (i >= x) { //i가 x보다 커질때 답 도출시작 그전까지는 무시
               if ((i % 2) == 0) { //계산한값 나머지가 없으면 짝수
                   System.out.println(""+x+"/"+(i - x + 1)+"");
               } else { //홀수
                   System.out.println(""+(i - x + 1)+"/"+x+"");
               }
               break;
           }
           x -= i; //x값은 x-i
       }
    }
}
/*
핵심 : for문의 i와 처음에 입력한x값이랑 비교하는데
for문이 도는 i값이 x보다 커지는시점에 i와 x가 정답을 도출할수있는 열쇠가된다
만약에 x가 i보다 커지는시점에서 계속돌게된다면 x에값이 음수가 되어 계산이불가능해진다
시뮬레이션을 돌려보겠다 x = 5라고 가정한다
i = 1   2   3   4
x = 5   4   2   -1
즉이렇게되기 때문에 i가 4까지 갈수없으며 그전까지만 가능하다
이것을 나타낸것이 if(i >= x)이다 i가 3 x가 2라면 if문을 통해 i가 홀수인지 짝수인지 판단한다
홀수짝수에따라 계산이 달라지며 바로 break가되어 종료된다
 */