import java.util.Scanner;

public class forwhile8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Moneyborrowcount = 0;
        //추가적으로 돈을 빌렸는지 확인할 수 있는 카운트값
        System.out.println("추가 용돈을 입력해주세요");
        int Plusmoney = sc.nextInt() + 10000;

        System.out.println("현재 가지고 있는 돈은 총 " + Plusmoney + "원 입니다");
        System.out.println("떡볶이,우동,과자,빵,음료수 가격을 각각 적어주세요");
        int Food = sc.nextInt(); //떡볶이
        int Food2 = sc.nextInt();//우동
        int Food3 = sc.nextInt();//과자
        int Food4 = sc.nextInt();//빵
        int Food5 = sc.nextInt();//음료수

        System.out.println("떡볶이는 구매 개수 입력");
        int Foodnumber = sc.nextInt();
        Plusmoney -= (Food * Foodnumber);


        if (Plusmoney < 0) {
            while (true) {
                //돈이 부족한경우 돈을빌릴수있으며 지불해야 하는 값보다 적게 빌릴경우 while문을 통해 다시 빌리도록 한다
                System.out.println("돈이" + (Plusmoney * -1) + "원 부족합니다 얼마를 빌리시겠습니까?");
                int Foodborrow = sc.nextInt();
                Plusmoney += Foodborrow;

                if (Plusmoney < 0) {
                    System.out.println("안내 : 돈이 부족합니다! 다시 시도해주세요");
                    Plusmoney -= Foodborrow; //다시 시도하는경우 빌린돈을 다시 반환
                } else {
                    Moneyborrowcount += 1; //빌린 후 카운트값 1추가 및 break로 탈출
                    break;
                }
            }
        }
        System.out.println("떡볶이 가격은 " + (Food * Foodnumber) + "원이고 남은돈은 " + Plusmoney + "원 입니다");
        System.out.println("우동 구매 개수 입력");
        int Food2number = sc.nextInt();
        Plusmoney -= (Food2 * Food2number);

        if (Plusmoney < 0 && Moneyborrowcount == 1) {
            System.out.println("이미 돈을 받았기 때문에 쫒겨났습니다");
            return;
        }
        if (Plusmoney < 0) {
            while (true) {
                System.out.println("돈이" + (Plusmoney * -1) + "원 부족합니다 얼마를 빌리시겠습니까?");
                int Foodborrow = sc.nextInt();
                Plusmoney += Foodborrow;

                if (Plusmoney < 0) {
                    System.out.println("안내 : 돈이 부족합니다! 다시 시도해주세요");
                    Plusmoney -= Foodborrow;
                } else {
                    Moneyborrowcount += 1;
                    break;
                }
            }
        }
        System.out.println("우동 가격은 " + (Food2 * Food2number) + "원이고 남은돈은 " + Plusmoney + "원 입니다");
        System.out.println("과자 구매 개수 입력");
        int Food3number = sc.nextInt();
        Plusmoney -= (Food3 * Food3number);

        if (Plusmoney < 0 && Moneyborrowcount == 1) {
            System.out.println("이미 돈을 받았기 때문에 쫒겨났습니다");
            return;
        }
        if (Plusmoney < 0) {
            while (true) {
                System.out.println("돈이" + (Plusmoney * -1) + "원 부족합니다 얼마를 빌리시겠습니까?");
                int Foodborrow = sc.nextInt();
                Plusmoney += Foodborrow;

                if (Plusmoney < 0) {
                    System.out.println("안내 : 돈이 부족합니다! 다시 시도해주세요");
                    Plusmoney -= Foodborrow;
                } else {
                    Moneyborrowcount += 1;
                    break;
                }
            }
        }
        System.out.println("과자 가격은 " + (Food3 * Food3number) + "원이고 남은돈은 " + Plusmoney + "원 입니다");
        System.out.println("빵 구매 개수 입력");
        int Food4number = sc.nextInt();
        Plusmoney -= (Food4 * Food4number);

        if (Plusmoney < 0 && Moneyborrowcount == 1) {
            System.out.println("이미 돈을 받았기 때문에 쫒겨났습니다");
            return;
        }
        if (Plusmoney < 0) {
            while (true) {
                System.out.println("돈이" + (Plusmoney * -1) + "원 부족합니다 얼마를 빌리시겠습니까?");
                int Foodborrow = sc.nextInt();
                Plusmoney += Foodborrow;

                if (Plusmoney < 0) {
                    System.out.println("안내 : 돈이 부족합니다! 다시 시도해주세요");
                    Plusmoney -= Foodborrow;
                } else {
                    Moneyborrowcount += 1;
                    break;
                }
            }
        }
        System.out.println("빵 가격은 " + (Food4 * Food4number) + "원이고 남은돈은 " + Plusmoney + "원 입니다");
        System.out.println("음료수 구매 개수 입력");
        int Food5number = sc.nextInt();
        Plusmoney -= (Food5 * Food5number);

        if (Plusmoney < 0 && Moneyborrowcount == 1) {
            System.out.println("이미 돈을 받았기 때문에 쫒겨났습니다");
            return;
        }
        if (Plusmoney < 0) {
            while (true) {
                System.out.println("돈이" + (Plusmoney * -1) + "원 부족합니다 얼마를 빌리시겠습니까?");
                int Foodborrow = sc.nextInt();
                Plusmoney += Foodborrow;

                if (Plusmoney < 0) {
                    System.out.println("안내 : 돈이 부족합니다! 다시 시도해주세요");
                    Plusmoney -= Foodborrow;
                } else {
                    break;
                }
            }
        }
        System.out.println("음료수 가격은 " + (Food5 * Food5number) + "원이고 남은돈은 " + Plusmoney + "원 입니다");
    }
}
