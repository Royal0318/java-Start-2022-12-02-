import java.util.Scanner;

public class InputOutput11 {
    String Food;
    String Food2;
    String Food3;

    InputOutput11(String Food,String Food2,String Food3) {
        this.Food = Food;
        this.Food2 = Food2;
        this.Food3 = Food3;
    }
    void Foodselectmenu () {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1." + Food + " 2." + Food2 + " 3." + Food3 + "");
            int Foodchoice = sc.nextInt();

            if (Foodchoice == 1) {
                FoodbuyMet(Food,1000,2000,3000);
            } else if (Foodchoice == 2) {
                FoodbuyMet(Food2,4000,5000,6000);
            } else if (Foodchoice == 3) {
                FoodbuyMet(Food3,10000,20000,30000);
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
    void FoodbuyMet (String MyselectFood,int Price,int Price2,int Price3) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println(""+MyselectFood+"를 선택하셨습니다 1."+Price+"원어치 2."+Price2+"원어치 3."+Price3+"원어치");
            int Foodpricechoice = sc.nextInt();

            if (Foodpricechoice == 1) {
                FoodNumberMet(MyselectFood,Price);
            } else if (Foodpricechoice == 2) {
                FoodNumberMet(MyselectFood,Price2);
            } else if (Foodpricechoice == 3) {
                FoodNumberMet(MyselectFood,Price3);
            } else {
                System.out.println("잘못된 입력");
            }
        }
    }
    void FoodNumberMet (String Food,int Price) {
        Scanner sc = new Scanner(System.in);
        System.out.println(""+Food+"의 구매 개수를 입력해주세요");
        int Foodbuynum = sc.nextInt();

        System.out.println("총 가격은 : "+(Price * Foodbuynum)+"원 입니다");
        System.exit(1);
    }
}
