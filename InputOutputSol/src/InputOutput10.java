import java.util.Scanner;

public class InputOutput10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("3가지 음식이름을 정해주세요");
        String FoodName = sc.next();
        String FoodName2 = sc.next();
        String FoodName3 = sc.next();
        InputOutput11 test = new InputOutput11(""+FoodName+"",""+FoodName2+"",""+FoodName3+"");
        test.Foodselectmenu();
    }
}
