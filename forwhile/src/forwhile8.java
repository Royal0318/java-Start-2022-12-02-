/*
[1.기본 문제출제 : 누가 보더라도 이해하기 쉽게 코드를 작성하시오.]
	[2.기본 문제출제 : 누가 보더라도 프로그램을 사용할 수 있게 제대로 정의해주시오]
	[3.기본 문제출제 : 아래 문제의 경우 음식이 세 가지로 분류되어 있는데, 본인이 두 가지를 더 추가해서 만든다.]
	[4.기본 문제출제 : 참고로 이 문제는 풀 수 있는 방식이 워낙 많고, 도움이 될 수 있는 문제기 때문에, 본인이 풀었을 경우, 다른 방식으로 또 풀어보겠다. 이후 피드백을 드림.]
	2번 기본 문제출제에 대한 예시
	떡볶이 금액 : 10000 같은 식으로, 숫자만 입력받는 형태가 아닌,
           누가 보더라도 이해하고 프로그램을 사용할 수 있게제작한다

	철수와 영희가 있다.
	둘이 가진 금액은 애초에 10000원으로,
	처음에 용돈을 추가적으로 입력받는다.

	추가적으로 입력받으면, 현재 금액이 얼마인지 바로 나타내준 후,

	바로 떡볶이 금액, 우동 금액, 과자 금액을 입력받는다.
	그리고
	바로 떡볶이를 몇 개를 주문하겠냐는 메시지가 나타난다.
	이곳에서 20개를 입력하게 되면 10000원밖에 없기 때문에
            10000원이 부족해진다.

	=문단2=
	돈이 부족하지 않을 경우에는 떡볶이는 얼마였고,
            현재 얼마가 남았다는 문장과 함께
	바로 떡볶이 > 우동 > 과자로 넘어가면 되지만,
	만약 위처럼 돈이 부족한 경우에는 현재 얼마가 부족한지
    나타내고,
	추가적으로 용돈을 입력받을 수 있게 만든다.
	추가적으로 용돈을 받은 경우에는 얼마를 입력받아서 얼마가 되었다. 라는 형식으로 나타내면 되고,
	그곳에서 돈이 부족하지 않은 경우에는 떡볶이는 얼마였고, 현재 얼마가 남았다는 문장과 함께
	다음 떡볶이 > 우동 > 과자로 넘어가게 된다.
 */
import java.util.Scanner;
public class forwhile8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Moneyborrowcount = 0;
        //추가적으로 돈을 빌렸는지 확인할 수 있는 카운트값
        System.out.println("추가 용돈을 입력해주세요");
        int Plusmoney = sc.nextInt() + 10000;

        System.out.println("현재 가지고 있는 돈은 총 " + Plusmoney + "원 입니다");
        System.out.println("떡볶이,우동,과자,빵,음료수 가격을 각각 적어주세요");
        int Food = sc.nextInt(); //떡볶이
        int Food2 = sc.nextInt();//우동
        int Food3 = sc.nextInt();//과자
        int Food4 = sc.nextInt();//빵
        int Food5 = sc.nextInt();//음료수

        System.out.println("떡볶이는 구매 개수 입력");
        int Foodnumber = sc.nextInt();
        Plusmoney -= (Food * Foodnumber);


        if (Plusmoney < 0) {
            while (true) {
                //돈이 부족한경우 돈을빌릴수있으며 지불해야 하는 값보다 적게 빌릴경우 while문을 통해 다시 빌리도록 한다
                System.out.println("돈이" + (Plusmoney * -1) + "원 부족합니다 얼마를 빌리시겠습니까?");
                int Foodborrow = sc.nextInt();
                Plusmoney += Foodborrow;

                if (Plusmoney < 0) {
                    System.out.println("안내 : 돈이 부족합니다! 다시 시도해주세요");
                    Plusmoney -= Foodborrow; //다시 시도하는경우 빌린돈을 다시 반환
                } else {
                    Moneyborrowcount += 1; //빌린 후 카운트값 1추가 및 break로 탈출
                    break;
                }
            }
        }
        System.out.println("떡볶이 가격은 " + (Food * Foodnumber) + "원이고 남은돈은 " + Plusmoney + "원 입니다");
        System.out.println("우동 구매 개수 입력");
        int Food2number = sc.nextInt();
        Plusmoney -= (Food2 * Food2number);

        if (Plusmoney < 0 && Moneyborrowcount == 1) {
            System.out.println("이미 돈을 받았기 때문에 쫒겨났습니다");
            return;
        }
        if (Plusmoney < 0) {
            while (true) {
                System.out.println("돈이" + (Plusmoney * -1) + "원 부족합니다 얼마를 빌리시겠습니까?");
                int Foodborrow = sc.nextInt();
                Plusmoney += Foodborrow;

                if (Plusmoney < 0) {
                    System.out.println("안내 : 돈이 부족합니다! 다시 시도해주세요");
                    Plusmoney -= Foodborrow;
                } else {
                    Moneyborrowcount += 1;
                    break;
                }
            }
        }
        System.out.println("우동 가격은 " + (Food2 * Food2number) + "원이고 남은돈은 " + Plusmoney + "원 입니다");
        System.out.println("과자 구매 개수 입력");
        int Food3number = sc.nextInt();
        Plusmoney -= (Food3 * Food3number);

        if (Plusmoney < 0 && Moneyborrowcount == 1) {
            System.out.println("이미 돈을 받았기 때문에 쫒겨났습니다");
            return;
        }
        if (Plusmoney < 0) {
            while (true) {
                System.out.println("돈이" + (Plusmoney * -1) + "원 부족합니다 얼마를 빌리시겠습니까?");
                int Foodborrow = sc.nextInt();
                Plusmoney += Foodborrow;

                if (Plusmoney < 0) {
                    System.out.println("안내 : 돈이 부족합니다! 다시 시도해주세요");
                    Plusmoney -= Foodborrow;
                } else {
                    Moneyborrowcount += 1;
                    break;
                }
            }
        }
        System.out.println("과자 가격은 " + (Food3 * Food3number) + "원이고 남은돈은 " + Plusmoney + "원 입니다");
        System.out.println("빵 구매 개수 입력");
        int Food4number = sc.nextInt();
        Plusmoney -= (Food4 * Food4number);

        if (Plusmoney < 0 && Moneyborrowcount == 1) {
            System.out.println("이미 돈을 받았기 때문에 쫒겨났습니다");
            return;
        }
        if (Plusmoney < 0) {
            while (true) {
                System.out.println("돈이" + (Plusmoney * -1) + "원 부족합니다 얼마를 빌리시겠습니까?");
                int Foodborrow = sc.nextInt();
                Plusmoney += Foodborrow;

                if (Plusmoney < 0) {
                    System.out.println("안내 : 돈이 부족합니다! 다시 시도해주세요");
                    Plusmoney -= Foodborrow;
                } else {
                    Moneyborrowcount += 1;
                    break;
                }
            }
        }
        System.out.println("빵 가격은 " + (Food4 * Food4number) + "원이고 남은돈은 " + Plusmoney + "원 입니다");
        System.out.println("음료수 구매 개수 입력");
        int Food5number = sc.nextInt();
        Plusmoney -= (Food5 * Food5number);

        if (Plusmoney < 0 && Moneyborrowcount == 1) {
            System.out.println("이미 돈을 받았기 때문에 쫒겨났습니다");
            return;
        }
        if (Plusmoney < 0) {
            while (true) {
                System.out.println("돈이" + (Plusmoney * -1) + "원 부족합니다 얼마를 빌리시겠습니까?");
                int Foodborrow = sc.nextInt();
                Plusmoney += Foodborrow;

                if (Plusmoney < 0) {
                    System.out.println("안내 : 돈이 부족합니다! 다시 시도해주세요");
                    Plusmoney -= Foodborrow;
                } else {
                    break;
                }
            }
        }
        System.out.println("음료수 가격은 " + (Food5 * Food5number) + "원이고 남은돈은 " + Plusmoney + "원 입니다");
    }
}
