import java.util.Scanner;

public class Februaryteenthsol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] FoodNamearr = new String[6];
        int[] FoodPricearr = new int[6];
        int[] FoodNumberarr = new int[6];
        int APriceSum = 0;
        int BPriceSum = 0;
        FoodNamearr[0] = "토마토";
        FoodNamearr[1] = "감자";
        FoodNamearr[2] = "물";
        FoodNamearr[3] = "과자";
        FoodNamearr[4] = "빵";
        FoodNamearr[5] = "껌";

        System.out.println("A는 토마토,감자,물을 B는 과자,빵,껌을 구매합니다");
        for (int i = 0;i < 6;i++) {
            //음식의 가격을 정하기
            System.out.println(""+FoodNamearr[i]+"의 가격을 정해주세요");
            int FoodPrice = sc.nextInt();
            FoodPricearr[i] = FoodPrice;
        }
        for (int i = 0;i < 6;i++) {
            //음식의 구매 개수를 정하기
            System.out.println(""+FoodNamearr[i]+"의 개수을 정해주세요");
            int FoodNumber = sc.nextInt();
            FoodNumberarr[i] = FoodNumber;
        }
        for (int i = 0;i < 6;i++) {
            if (i < 3) {
                APriceSum += (FoodPricearr[i] * FoodNumberarr[i]);
            } else {
                BPriceSum += (FoodPricearr[i] * FoodNumberarr[i]);
            }
        }
        System.out.println("총 가격은 "+(APriceSum + BPriceSum)+"원이 나왔습니다");
        System.out.println("A는 "+APriceSum+"원이 나왔으며");
        System.out.println("B는 "+BPriceSum+"원이 나왔으며");

        if (APriceSum < BPriceSum) {
            System.out.println("B는 A보다 "+(BPriceSum - APriceSum)+"원 더 지불했습니다");
        } else {
            System.out.println("A는 B보다 "+(APriceSum - BPriceSum)+"원 더 지불했습니다");

        }
    }
}
