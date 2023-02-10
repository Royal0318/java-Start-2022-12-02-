import java.util.Scanner;

public class Februaryteenth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("A는 토마토,감자 물을 B는 과자와 빵과 껌을 구매합니다");
        System.out.println("토마토,감자,물,과자,빵,껌의 가격을 각각적어주세요");
        int Tomato = sc.nextInt();
        int Potato = sc.nextInt();
        int Water = sc.nextInt();
        int Snack = sc.nextInt();
        int Bread = sc.nextInt();
        int GGum = sc.nextInt();

        System.out.println("토마토,감자,물,과자,빵,껌의 개수을 각각적어주세요");
        int TomatoNumber = sc.nextInt();
        int PotatoNumber = sc.nextInt();
        int WaterNumber = sc.nextInt();
        int SnackNumber = sc.nextInt();
        int BreadNumber = sc.nextInt();
        int GGumNumber = sc.nextInt();

        test10 FoodTotal = new test10(Tomato,Potato,Water,Snack,Bread,GGum,TomatoNumber,PotatoNumber,WaterNumber,SnackNumber,BreadNumber,GGumNumber);
        FoodTotal.FoodCal(Tomato,Potato,Water,Snack,Bread,GGum,TomatoNumber,PotatoNumber,WaterNumber,SnackNumber,BreadNumber,GGumNumber);
    }
}
