import java.util.Scanner;

public class InputOutputsol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("A는 토마토,감자,물을 B는 과자,빵,껌을 구매합니다");
        System.out.println("토마토,감자,물,과자,빵,껌의 가격을 각각 적어주세요");
        int FoodPrice = sc.nextInt();
        int FoodPrice2 = sc.nextInt();
        int FoodPrice3 = sc.nextInt();
        int FoodPrice4 = sc.nextInt();
        int FoodPrice5 = sc.nextInt();
        int FoodPrice6 = sc.nextInt();
        FoodNumber(FoodPrice, FoodPrice2, FoodPrice3, FoodPrice4, FoodPrice5, FoodPrice6);
    }

    public static void FoodNumber(int FoodPrice, int FoodPrice2, int FoodPrice3, int FoodPrice4, int FoodPrice5, int FoodPrice6) {
        Scanner sc = new Scanner(System.in);
        System.out.println("토마토,감자,물,과자,빵,껌의 구매 개수을 각각 적어주세요");
        int FoodNumber = sc.nextInt();
        int FoodNumber2 = sc.nextInt();
        int FoodNumber3 = sc.nextInt();
        int FoodNumber4 = sc.nextInt();
        int FoodNumber5 = sc.nextInt();
        int FoodNumber6 = sc.nextInt();
        FoodCal(FoodPrice, FoodPrice2, FoodPrice3, FoodPrice4, FoodPrice5, FoodPrice6, FoodNumber, FoodNumber2, FoodNumber3, FoodNumber4, FoodNumber5, FoodNumber6);
    }

    public static void FoodCal(int FoodPrice, int FoodPrice2, int FoodPrice3, int FoodPrice4, int FoodPrice5, int FoodPrice6, int FoodNumber, int FoodNumber2, int FoodNumber3, int FoodNumber4, int FoodNumber5, int FoodNumber6) {
        int APriceSum = 0;
        int BPriceSum = 0;
        System.out.println("전체 가격은 : " + ((FoodPrice * FoodNumber) + (FoodPrice2 * FoodNumber2) + (FoodPrice3 * FoodNumber3) + (FoodPrice4 * FoodNumber4) + (FoodPrice5 * FoodNumber5) + (FoodPrice6 * FoodNumber6)) + "원");
        System.out.println("A의 총 가격은 : " + ((FoodPrice * FoodNumber) + (FoodPrice2 * FoodNumber2) + (FoodPrice3 * FoodNumber3)) + "원");
        APriceSum += ((FoodPrice * FoodNumber) + (FoodPrice2 * FoodNumber2) + (FoodPrice3 * FoodNumber3));
        System.out.println("B의 총 가격은 : " + ((FoodPrice4 * FoodNumber4) + (FoodPrice5 * FoodNumber5) + (FoodPrice6 * FoodNumber6)) + "원");
        BPriceSum += ((FoodPrice4 * FoodNumber4) + (FoodPrice5 * FoodNumber5) + (FoodPrice6 * FoodNumber6));

        if (APriceSum < BPriceSum) {
            System.out.println("B가 A보다 " + (BPriceSum - APriceSum) + "원 더 지불하였습니다");
        } else {
            System.out.println("A가 B보다 " + (APriceSum - BPriceSum) + "원 더 지불하였습니다");
        }
    }
}
