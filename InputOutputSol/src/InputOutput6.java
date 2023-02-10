import java.util.Scanner;

public class InputOutput6 {
    public static void main(String[] args) {
        /*
        이 풀이법은 함수형을 이용한 풀이법이며 기존풀이법보다 더 시각적으로도 이득이고 코드길이로도 이득이다
        지금은 음식의 개수가 3개밖에 없지만 음식이 기하급수적으로 늘어나게된다면 기존 방식으로는 가독성도 떨어지며 코드길이가 지금보다 몇배 더 길어질것이다
        함수형을 이용할경우 해당 if값만 늘려주면되기 때문에 시각적으로도 코드길이로도 이득인 방법인것이다
         */
        System.out.println("총 가격은 "+MainMenu()+"원 입니다");
    }
    public static int MainMenu () {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.감자 2.옥수수 3.수박");
            int Choice = sc.nextInt();

            if (Choice == 1) {
                return FoodPrice("감자", 1000, 2000, 3000);
            } else if (Choice == 2) {
                return FoodPrice("옥수수", 4000, 5000, 6000);
            } else if (Choice == 3) {
                return FoodPrice("수박", 10000, 20000, 30000);
            } else {
                System.out.println("잘못된 입력!");
            }
            return 0;
        }
    }
    public static int FoodPrice (String FoodName,int FoodPrice,int FoodPrice2,int FoodPrice3) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("" + FoodName + "을 선택하셨습니다 1." + FoodPrice + "원어치 2." + FoodPrice2 + "원어치 3." + FoodPrice3 + "원어치");
            int PriceChoice = sc.nextInt();

            if (PriceChoice == 1) {
                return FoodNumber("" + FoodName + "", FoodPrice);
            } else if (PriceChoice == 2) {
                return FoodNumber("" + FoodName + "", FoodPrice2);
            } else if (PriceChoice == 3) {
                return FoodNumber("" + FoodName + "", FoodPrice3);
            } else {
                System.out.println("잘못된 입력!");
            }
            return 0;
        }
    }
    public static int FoodNumber (String FoodName,int Price) {
        Scanner sc = new Scanner(System.in);
        System.out.println(""+FoodName+"의 개수를 적어주세요");
        int FoodNum = sc.nextInt();
        return (FoodNum * Price);
    }
}
