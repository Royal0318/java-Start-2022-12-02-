import java.util.Scanner;

public class forwhile19 {
    public static void main(String[] args) {
        int Foodbuymoney = 0;
        int Foodbuycheck = 0;
        int Calculatorsum = 0;
        int Calmenuoutcheck = 0;
        forwhile20 FoodMet = new forwhile20(Foodbuymoney,Foodbuycheck,Calculatorsum,Calmenuoutcheck);
        forwhile20 FoodMet2 = new forwhile20();
        //예비 생성자
        Selectmenu(Foodbuymoney,Calmenuoutcheck,FoodMet);

    }
     static void Selectmenu(int Foodbuymoney, int Calmenuoutcheck, forwhile20 FoodMet) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("[1.구구단 2.음식점 3.계산기 4.종료]");
            int Menuchoice = sc.nextInt();

            if (Menuchoice == 1) {
                FoodMet.Gugudan();
            } else if (Menuchoice == 2) {
                FoodMet.Restaurant();
            } else if (Menuchoice == 3) {
                if (Calmenuoutcheck == 1) {
                    FoodMet.AgainCalculator();
                } else {
                    FoodMet.Calculator();
                }
            } else if (Menuchoice == 4) {
                System.out.println("시스템을 종료합니다 \n총 누적금액 : "+Foodbuymoney+"원");
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
}
