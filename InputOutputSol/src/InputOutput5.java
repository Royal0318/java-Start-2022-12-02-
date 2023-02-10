/*
다음 세 가지 중 고르시오.
	1. 감자. 2.옥수수 3. 수박
	1번을 누를 시
	1번 감자를 선택하셨습니다. 라는 문구가 나오도록.
	2번을 누를 시
	2번 옥수수를 선택하셨습니다.
	3번을 누를 시,
	3번 수박을 선택하셨습니다.
	>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	그 뒤 1번 감자에서 1천원어치, 2천원어치 3천원어치.
	2번을 누를 시 옥수수에서 4천원어치, 5천원어치 6천원어치,
	3번을 누를 시 수박에서 10000천원어치, 20000천원어치, 30000천원어치.
	라는 문구가 각각 나오도록 설정하고,
	그 안에서 또 1번을 누를 시
	“감자 1천원어치를 선택하셨습니다.” 라는 문구가 나오도록 하고,
	몇 개를 주문하겠냐고 질문한 뒤 그 개수에 따라 금액이 변동하도록 하시오.
 */
import java.util.Scanner;
public class InputOutput5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        해당문제는  Main클라스안에서 if문만으로 풀은문제이다 보시다시피 객체지향을 이용하는것보다 코드길이도 길고
        중복되는 부분도 굉장히많기때문에 비효율적인 풀이라고 할수있겠다
        그래서 중복이 많은경우 객체지향을 이용하는것이 훨씬 코드길이도 줄이며 시간을 단축시킬 수 있다
         */

        while (true) {
            System.out.println("1.감자 2.옥수수 3.수박");
            int Choice = sc.nextInt();

            if (Choice == 1) {
                System.out.println("감자를 선택하셨습니다 1.1000원어치 2.2000원어치 3.3000원어치");
                int Potatochoice = sc.nextInt();

                if (Potatochoice == 1) {
                    System.out.println("개수를 적어주세요");
                    int PotatoNumber = sc.nextInt();
                    System.out.println("감자의 총 금액은 "+(PotatoNumber * 1000)+"원 입니다");
                    break;
                } else if (Potatochoice == 2) {
                    System.out.println("개수를 적어주세요");
                    int PotatoNumber = sc.nextInt();
                    System.out.println("감자의 총 금액은 "+(PotatoNumber * 2000)+"원 입니다");
                    break;
                } else if (Potatochoice == 3) {
                    System.out.println("개수를 적어주세요");
                    int PotatoNumber = sc.nextInt();
                    System.out.println("감자의 총 금액은 "+(PotatoNumber * 3000)+"원 입니다");
                    break;
                } else {
                    System.out.println("잘못된 입력!");
                }
            } else if (Choice == 2) {
                System.out.println("옥수수를 선택하셨습니다 1.4000원어치 2.5000원어치 3.6000원어치");
                int Cornchoice = sc.nextInt();

                if (Cornchoice == 1) {
                    System.out.println("개수를 적어주세요");
                    int CornNumber = sc.nextInt();
                    System.out.println("옥수수의 총 금액은 "+(CornNumber * 4000)+"원 입니다");
                    break;
                } else if (Cornchoice == 2) {
                    System.out.println("개수를 적어주세요");
                    int CornNumber = sc.nextInt();
                    System.out.println("옥수수의 총 금액은 "+(CornNumber * 5000)+"원 입니다");
                    break;
                } else if (Cornchoice == 3) {
                    System.out.println("개수를 적어주세요");
                    int CornNumber = sc.nextInt();
                    System.out.println("옥수수의 총 금액은 "+(CornNumber * 6000)+"원 입니다");
                    break;
                } else {
                    System.out.println("잘못된 입력!");
                }
            } else if (Choice == 3) {
                System.out.println("수박을 선택하셨습니다 1.10000원어치 2.20000원어치 3.30000원어치");
                int WaterMelonchoice = sc.nextInt();

                if (WaterMelonchoice == 1) {
                    System.out.println("개수를 적어주세요");
                    int WaterMelonNumber = sc.nextInt();
                    System.out.println("감자의 총 금액은 "+(WaterMelonNumber * 10000)+"원 입니다");
                    break;
                } else if (WaterMelonchoice == 2) {
                    System.out.println("개수를 적어주세요");
                    int WaterMelonNumber = sc.nextInt();
                    System.out.println("감자의 총 금액은 "+(WaterMelonNumber * 20000)+"원 입니다");
                    break;
                } else if (WaterMelonchoice == 3) {
                    System.out.println("개수를 적어주세요");
                    int WaterMelonNumber = sc.nextInt();
                    System.out.println("감자의 총 금액은 "+(WaterMelonNumber * 30000)+"원 입니다");
                    break;
                } else {
                    System.out.println("잘못된 입력!");
                }
            } else {
                System.out.println("잘못된 입력!");
            }
        }
    }
}
