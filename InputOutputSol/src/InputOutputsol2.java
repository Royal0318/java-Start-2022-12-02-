/*
문) A는 토마토 감자 주스를 구매하여 B는 과자 물 껌을 구매합니다
가격과 개수는 입력으로 받으며 마지막에 음식가격의 총합,A의 총 지불값,B의 총지불값 만약A의지불값이 B보다 적을경우 B가 A보다 ?원 지불했다는
문구가 나오도록 작성하여라
 */
import java.util.Scanner;

public class InputOutputsol2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1차원 배열을 이용한 풀이
        int[] FoodPricearr = new int[6];//음식가격
        int[] FoodNumberarr = new int[6]; //음식개수
        int APriceSum = 0; //A음식의 전체가격
        int BPriceSum = 0; //B음식의 전체가격

        System.out.println("A는 토마토 감자 주스를 B는 과자,물,껌을 샀습니다");
        System.out.println("토마토,감자,주스.과자.물,껌의 가격을 각각 적어주세요");
        for (int i = 0;i < 6;i++) {
            int FoodPrice = sc.nextInt();
            FoodPricearr[i] = FoodPrice;
            //1차원 배열을 이용하여 각각의 음식가격을 저장한다
        }
        System.out.println("토마토,감자,주스.과자.물,껌의 개수을 각각 적어주세요");
        for (int i = 0;i < 6;i++) {
            int FoodNumber = sc.nextInt();
            FoodNumberarr[i] = FoodNumber;

            if (i < 3) { //index 0 ~ 2까지 3개는 토마토,감자,주스기때문에 A값에 누적
                APriceSum += (FoodPricearr[i] * FoodNumberarr[i]);
            } else { //나머진는 B에누적시킨다
                BPriceSum += (FoodPricearr[i] * FoodNumberarr[i]);
            }
        }
        System.out.println("총 음식의 값은 "+(APriceSum + BPriceSum)+"원입니다");
        System.out.println("A의 총 가격은 : "+APriceSum+"원");
        System.out.println("B의 총 가격은 : "+BPriceSum+"원");
        if (APriceSum < BPriceSum) {
            System.out.println("B가 A보다 "+(BPriceSum - APriceSum)+"원 더 지불했습니다");
        } else if (APriceSum > BPriceSum) {
            System.out.println("A가 B보다 "+(APriceSum - BPriceSum)+"원 더 지불했습니다");
        } else {
            System.out.println("둘의 지불값은 같습니다");
        }
    }
}
