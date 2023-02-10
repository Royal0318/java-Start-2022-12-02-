import java.util.Scanner;

public class InputOutputsol3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("A는 3개의 음식 B도 3개의음식을 구매합니다 먼저 음식의 이름을 정해주세요");
        String FoodNameInput = sc.next();
        String FoodName2Input = sc.next();
        String FoodName3Input = sc.next();
        String FoodName4Input = sc.next();
        String FoodName5Input = sc.next();
        String FoodName6Input = sc.next();
        InputOutputsol4 test = new InputOutputsol4(""+FoodNameInput+"",""+FoodName2Input+"",""+FoodName3Input+"",""+FoodName4Input+"",""+FoodName5Input+"",""+FoodName6Input+"");
        test.FoodPriceMet();
    }
}
