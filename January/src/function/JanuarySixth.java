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
