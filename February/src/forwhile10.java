import java.util.Scanner;

public class forwhile10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] Foodname = new String[5]; //음식의 이름을 저장
        int[][] FoodnumberAndprice = new int[5][2]; //행은 음식의 가격 열은 음식의 개수를 저장
        int Totalmoney = 0;
        int Borrowcount = 0;
        Foodname[0] = "떡볶이";
        Foodname[1] = "우동";
        Foodname[2] = "과자";
        Foodname[3] = "빵";
        Foodname[4] = "음료수";

        while (true) {
            System.out.println("추가적으로 받을 용돈을 적어주세요");
            Totalmoney = sc.nextInt() + 10000;

            if (Totalmoney < 0) {
                System.out.println("잘못된 입력입니다 다시 해주세요");
            } else {
                break;
            }
        }
        System.out.println(""+(Totalmoney - 10000)+"원을 추가적으로 받아 총 "+Totalmoney+"원이 되었습니다");
        for (int i = 0; i < 5;i++) {
            System.out.println(""+Foodname[i]+"의 가격을 적어주세요");
            FoodnumberAndprice[i][0] = sc.nextInt();
        }
        for (int i = 0; i < 5;i++) {
            System.out.println(""+Foodname[i]+"의 개수을 적어주세요");
            FoodnumberAndprice[i][1] = sc.nextInt();
            Totalmoney -= (FoodnumberAndprice[i][0] * FoodnumberAndprice[i][1]); //예) [0][0]은 음식의 가격 [0][1] 음식의 개수
            //Total값이 이상함
            if (Totalmoney < 0 && Borrowcount == 1) {
                System.out.println("추가적으로 돈을 받았기 때문에 쫒겨났습니다");
                break;
            }
            if (Totalmoney < 0 && Borrowcount == 0) {
                while (true) {
                System.out.println("돈이 "+(Totalmoney * -1)+"원 부족합니다 추가적으로 빌릴돈을 적어주세요");
                int Borrowmoney = sc.nextInt();
                Totalmoney += Borrowmoney;

                    if (Totalmoney < 0) {
                        System.out.println("안내 : 입력을 다시 해주세요!");
                        Totalmoney -= Borrowmoney;
                    } else {
                        Borrowcount += 1;
                        break;
                    }
                }
            }
            System.out.println(""+Foodname[i]+"를 "+(FoodnumberAndprice[0][0] * FoodnumberAndprice[0][1])+"원 구매하였으며 남은돈은 "+Totalmoney+"원 입니다");
        }
    }
}
