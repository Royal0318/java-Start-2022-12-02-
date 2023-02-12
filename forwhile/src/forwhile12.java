import java.util.Scanner;

public class forwhile12 {
    int Totalmoney;
    int Borrowcheck;
    int[] Foodpricearr;
    int[] Foodnumberarr;
    String[] Foodnamearr;

    forwhile12 (int Totalmoney,int Borrowcheck,int[] Foodpricearr,int[] Foodnumberarr,String[] Foodnamearr) {
        this.Totalmoney = Totalmoney;
        this.Borrowcheck = Borrowcheck;
        this.Foodpricearr = Foodpricearr;
        this.Foodnumberarr = Foodnumberarr;
        this.Foodnamearr = Foodnamearr;
    }
    void FoodnameMet () {
        Scanner sc = new Scanner(System.in);
        for (int i = 0;i < 5;i++) {
            System.out.println(""+(i + 1)+"번째 음식이름을 적어주세요");
            Foodnamearr[i] = sc.next();
        }
    }
    void FoodpriceMet () {
        Scanner sc = new Scanner(System.in);
        for (int i = 0;i < 5;i++) {
            System.out.println(""+Foodnamearr[i]+"의 가격을 적어주세요");
            Foodpricearr[i] = sc.nextInt();
        }
    }
    void FoodnumberMet () {
        Scanner sc = new Scanner(System.in);
        for (int i = 0;i < 5;i++) {
            System.out.println(""+Foodnamearr[i]+"의 개수를 적어주세요");
            Foodnumberarr[i] = sc.nextInt();
            Totalmoney -= (Foodpricearr[i] * Foodnumberarr[i]);

            if (Totalmoney < 0) {
                Moneyincorrect(i); //돈이 부족할때
            } else {
                Moneycorrect(i); //돈이 남을때
            }
        }
    }
    void Moneyincorrect (int i) {
        Scanner sc = new Scanner(System.in);
        if (Borrowcheck == 1) {
            System.out.println("추가적으로 돈을 받았기 때문에 쫒겨났습니다");
            //넘어가는 메소드가 없으므로 시스템종료
        } else {
            while (true) {
                System.out.println("돈이 " + (Totalmoney * -1) + "원 부족합니다 추가로 받을 돈을 입력해주세요");
                int Moneyborrow = sc.nextInt();
                Totalmoney += Moneyborrow;

                if (Totalmoney < 0) {
                    System.out.println("돈을 다시 입력해주세요");
                    Totalmoney -= Moneyborrow;
                } else {
                    Moneycorrect(i);
                    Borrowcheck += 1;
                    break;
                }
            }
        }
    }
    void Moneycorrect (int i) {
        System.out.println(""+Foodnamearr[i]+"를 구매하여 총 "+Totalmoney+"원 남았습니다");
    }
}
