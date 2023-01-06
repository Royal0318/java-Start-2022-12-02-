package function;
import java.util.Scanner;
public class JanuarySixth {

    public static void main(String[] args) {
        System.out.println("남은 돈은 : "+PlusMoney()+"원 입니다");
    }
    public static int PlusMoney() {
        Scanner sc = new Scanner(System.in);
        int FoodCount = 0;
        System.out.println("추가 용돈을 적으세요");
        int TotalMoney = sc.nextInt() + 10000;
        System.out.println("총액 은 " + TotalMoney + "원 입니다");
        return Order(TotalMoney,FoodCount);
    }
        public static int Order(int TotalMoney,int FoodCount) {
            Scanner sc = new Scanner(System.in);

            if (FoodCount == 0) {
                System.out.println("떡볶이 가격을 적어주세요");
                int Food = sc.nextInt();
                System.out.println("떡볶이 개수");
                int FoodNumber = sc.nextInt();
                return ShortCash(FoodNumber, TotalMoney, Food,0);
            } else if (FoodCount == 1) {
                System.out.println("우동 가격을 적어주세요");
                int Food2 = sc.nextInt();
                System.out.println("우동 개수");
                int FoodNumber = sc.nextInt();
                return ShortCash(FoodNumber, TotalMoney, Food2,1);
            } else if (FoodCount == 2) {
                System.out.println("과자 가격을 적어주세요");
                int Food3 = sc.nextInt();
                System.out.println("과자 개수");
                int FoodNumber = sc.nextInt();
                return ShortCash(FoodNumber, TotalMoney, Food3,2);
            } else if (FoodCount == 3) {
                System.out.println("빵 가격을 적어주세요");
                int Food4 = sc.nextInt();
                System.out.println("빵 개수");
                int FoodNumber = sc.nextInt();
                return ShortCash(FoodNumber, TotalMoney, Food4,3);
            } else if (FoodCount == 4) {
                System.out.println("과일 가격을 적어주세요");
                int Food5 = sc.nextInt();
                System.out.println("과일 개수");
                int FoodNumber = sc.nextInt();
                return ShortCash(FoodNumber, TotalMoney, Food5,4);
            }
            return 0;
        }

    public static int ShortCash(int FoodNumber,int TotalMoney,int FoodSelect,int FoodCount) {
        Scanner sc = new Scanner(System.in);
        int FoodTotal = (FoodNumber * FoodSelect);

        if (FoodTotal < TotalMoney) { //돈이 남는경우
            System.out.println("남은 금액은 : "+(TotalMoney - FoodTotal)+"원 입니다");
            TotalMoney -= FoodTotal; //산 가격만큼 차감
            return Order(TotalMoney,(FoodCount + 1));

        } else if (FoodTotal > TotalMoney) {
            System.out.println(""+(FoodTotal - TotalMoney)+"원 부족합니다 추가 금액을 입력하세요");
            int Money = sc.nextInt();

            if ((Money - (FoodTotal - TotalMoney) > 0)) { //추가 금액을 받아서 부족하지 않은경우
                return (FoodCount + 1); //그 다음순서로 넘어감
            }
        }
        return 0;
    }
}
