import java.util.Scanner;

public class forwhile11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Borrowcheck = 0; //돈을 빌렸는지 여부를 체크
        String[] Foodname = new String[5]; //음식이름 배열
        int[] Foodprice = new int[5]; //음식 가격배열
        int[] Foodnumber = new int[5]; //음식 개수 배열

        System.out.println("추가적인 돈을 입력");
        int Totalmoney = sc.nextInt() + 10000;
        //전체돈에서 추가적인 돈을 입력받는다

        forwhile12 Totalmoneymet = new forwhile12(Totalmoney,Borrowcheck,Foodprice,Foodnumber,Foodname);
        Totalmoneymet.FoodnameMet();
        Totalmoneymet.FoodpriceMet();
        Totalmoneymet.FoodnumberMet();
    }
}
