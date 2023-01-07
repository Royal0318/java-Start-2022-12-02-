/*
처음에 몇개의 숫자를 입력받을지 적고
그 숫자만큼 더하여 최종출력을해주세요
예) 총 5개의 숫자를 입력받는다고 가정
1번째 입력 : 1
2번째 입력 : 2
출력 : 3
3번째 입력 5
출력 : 3 + 5 = 8
4번째 입력 : 10
출력 : 8 + 10 = 18
최종값 : 18
 */
import java.util.Scanner;

public class JanuarySeventh {
    public static void main(String[] args) { //최종출력
        System.out.println("최종값 : " + Number() + "");
    }
    public static int Number() {
        Scanner sc = new Scanner(System.in);
        int a = 2;
        System.out.println("몇개의 숫자를 입력 받으시겠습니까?");
        int InPut = sc.nextInt();
        System.out.println("1번째 숫자");
        int First = sc.nextInt();
        System.out.println("1번째 숫자 : " + First + "");

        return NuberInPut(First,InPut,a);
    }
    public static int NuberInPut(int Fitst,int InPut,int a) {
        Scanner sc = new Scanner(System.in);
        while (a < InPut) {
            System.out.println("" + a + "번째 숫자");
            int Number = sc.nextInt();
            System.out.println("" + Fitst + " + " + Number + " = " + (Fitst + Number) + "");
            Fitst += Number;
            a++;
        }
        return Fitst;
    }
}
