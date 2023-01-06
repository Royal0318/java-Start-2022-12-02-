/*
본 문제는 function을 이용하여 푸는 문제입니다
문) 갑과 을이 있다
둘이 가진 금액은 애초에 10000원으로,
	처음에 용돈을 추가적으로 입력받는다.
	추가적으로 입력받으면, 현재 금액이 얼마인지 바로 나타내준 후,
	바로 떡볶이 금액, 우동 금액, 과자 금액을 입력받는다.
	그리고
	바로 떡볶이를 몇 개를 주문하겠냐는 메시지가 나타난다.
	이곳에서 20개를 입력하게 되면 10000원밖에 없기 때문에 10000원이 부족해진다.

	=문단2=
	돈이 부족하지 않을 경우에는 떡볶이는 얼마였고, 현재 얼마가 남았다는 문장과 함께
	바로 떡볶이 > 우동 > 과자로 넘어가면 되지만,
	만약 위처럼 돈이 부족한 경우에는 현재 얼마가 부족한지 나타내고,
	추가적으로 용돈을 입력받을 수 있게 만든다.
	추가적으로 용돈을 받은 경우에는 얼마를 입력받아서 얼마가 되었다. 라는 형식으로 나타내면 되고,
	그곳에서 돈이 부족하지 않은 경우에는 떡볶이는 얼마였고, 현재 얼마가 남았다는 문장과 함께
	다음 떡볶이 > 우동 > 과자로 넘어가게 된다.

	위 문단2에서 이미 추가적으로 용돈을 받았기 때문에 더는 용돈을 추가적으로 받을 수 없다.
	이후 우동이나 과자에서 돈이 부족한 경우 주인장에게 쫓겨나게 만드시오(강제종료)
	단, 이 문제의 경우에는 떡볶이에서 돈이 부족하지 않은 경우의 수도 존재한다.
	만약 떡볶이에서 돈이 부족하지 않았다면, 우동에서 부족했을 경우, 그리고 과자에서도 부족하다면 과자에서 쫓겨났을 것이고,
	만약 돈이 아예 부족하지 않을 만큼 많이 받은 경우에는 셋 다 사먹어도 무난하게 마지막 금액이 나타났을 수 있다.
	즉, 상황에 따라 변화하는 알고리즘을 작성하시오.
 */
package function;
import java.util.Scanner;
public class JanuarySixth {
    public static void main(String[] args) {
        System.out.println("남은 돈은 : "+PlusMoney()+"원 입니다");
    }
    public static int PlusMoney() {
        Scanner sc = new Scanner(System.in);
        int Count = 0;
        int CheckCount = 0;
        System.out.println("추가 용돈을 적으세요");
        int TotalMoney = sc.nextInt() + 10000;
        System.out.println("총액은 " + TotalMoney + "원 입니다");
        return Order(TotalMoney,Count,CheckCount);
    }
    public static int Order(int TotalMoney,int Count,int CheckCount) {
            Scanner sc = new Scanner(System.in);

            if (Count == 0) {
                System.out.println("떡볶이 가격과 개수를 적어주세요");
                int Food = sc.nextInt();
                int FoodNumber = sc.nextInt();
                return ShortCash(FoodNumber, TotalMoney, Food,0,CheckCount);
            }
            if (Count == 1) {
                System.out.println("우동 가격과 개수를 적어주세요");
                int Food2 = sc.nextInt();
                int FoodNumber = sc.nextInt();
                return ShortCash(FoodNumber, TotalMoney, Food2,1,CheckCount);
            }
            if (Count == 2) {
                System.out.println("과자 가격과 개수를 적어주세요");
                int Food3 = sc.nextInt();
                int FoodNumber = sc.nextInt();
                return ShortCash(FoodNumber, TotalMoney, Food3,2,CheckCount);
            }
            if (Count == 3) {
                System.out.println("빵 가격과 개수를 적어주세요");
                int Food4 = sc.nextInt();
                int FoodNumber = sc.nextInt();
                return ShortCash(FoodNumber, TotalMoney, Food4,3,CheckCount);
            }
            if (Count == 4) {
                System.out.println("과일 가격과 개수를 적어주세요");
                int Food5 = sc.nextInt();
                int FoodNumber = sc.nextInt();
                return ShortCash(FoodNumber, TotalMoney, Food5,4,CheckCount);
            }
            if (Count == 5) { //출력이 나오기위해 리턴시킴
                return TotalMoney;
            }
            return 0;
        }
        public static int ShortCash(int FoodNumber,int TotalMoney,int FoodSelect,int Count,int CheckCount) {
        Scanner sc = new Scanner(System.in);
        int FoodTotal = (FoodNumber * FoodSelect);
        if (FoodTotal > TotalMoney && CheckCount == 1) { //쫒겨나는경우
                System.out.println("추가적으로 용돈을 받았기 때문에 쫒겨났습니다");
                System.exit(1); //강제종료
        } else if (FoodTotal < TotalMoney) {
            System.out.println("남은 금액은 : "+(TotalMoney - FoodTotal)+"원 입니다");
            TotalMoney -= FoodTotal; //산 가격만큼 차감
            return Order(TotalMoney,(Count + 1),CheckCount);
        } else if (FoodTotal > TotalMoney && CheckCount == 0) { //부족해서 용돈을 받는경우
            System.out.println(""+(FoodTotal - TotalMoney)+"원 부족합니다 추가 금액을 입력하세요");
            int Money = sc.nextInt();
            TotalMoney += Money;
            TotalMoney -= FoodTotal;
            System.out.println(""+Money+"원을 받아 남은 금액은 "+TotalMoney+"원 입니다");

            if (TotalMoney > 0) { //추가 금액을 받아서 부족하지 않은경우
                CheckCount += 1;
                return Order(TotalMoney,(Count + 1),CheckCount);
            }
        }
        return 0;
    }
}
