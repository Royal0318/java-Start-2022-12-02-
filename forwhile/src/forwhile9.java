import java.util.Scanner;
public class forwhile9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] Foodname = new String[5]; //각음식의 이름배열
        int [] Foodprice = new int[5]; //각 음식의 가격배열
        int [] Foodnum = new int[5]; //각 음식의 개수배열
        int Borrowcount = 0; //빌린 여부 확인 카운트
        Foodname[0] = "떡볶이";
        Foodname[1] = "우동";
        Foodname[2] = "과자";
        Foodname[3] = "빵";
        Foodname[4] = "음료수";

        System.out.println("추가적으로 받을 돈을 입력해주세요");
        int Plusmoney = sc.nextInt() + 10000;

        for (int i = 0;i < 5;i++) {
            //음식의 가격을 for문으로 적용
            System.out.println(""+Foodname[i]+" 가격을 입력해주세요");
            Foodprice[i] = sc.nextInt();
        }
        for (int i = 0;i < 5;i++) {
            //여기서부터 각각음식 구매
            System.out.println(""+Foodname[i]+" 구매 개수를 입력해주세요");
            Foodnum[i] = sc.nextInt();
            Plusmoney -= (Foodnum[i] * Foodprice[i]);

            if (Plusmoney < 0 && Borrowcount == 1) {
                System.out.println("추가적으로 돈을 받았기 때문에 쫒겨났습니다");
                break;
            }
            if (Plusmoney < 0 && Borrowcount == 0) {
                while (true) {
                    System.out.println("돈이 " + (Plusmoney * -1) + "원 부족합니다 얼마를 빌리시겠습니까?");
                    //부족한 돈의 값이 음수가 나오지 않도록 설정
                    int Borrowmoney = sc.nextInt();
                    Plusmoney += Borrowmoney;

                    if (Plusmoney < 0) {
                        System.out.println("안내 : 돈이 부족합니다 다시 입력해주세요!");
                        Plusmoney -= Borrowmoney;
                    } else {
                        Borrowcount += 1;
                        break;
                    }
                }
            }
            System.out.println(""+Foodname[i]+"는 "+(Foodnum[i] * Foodprice[i])+"원 남은돈은 "+Plusmoney+"원 입니다");
        }
    }
}
