package function;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println("남은 금액은 "+Allowance()+"원 입니다");
    }
    public static int Allowance() {
        Scanner sc = new Scanner(System.in);
        int Count = 0;
        int Check = 0;
        System.out.println("추가 금액을 입력하세요");
        int Allowance = sc.nextInt() + 10000;
        System.out.println("현재 금액은 "+Allowance+"원 입니다");
        return PriceInPut(Allowance,Count,Check);
    }
    public static int PriceInPut(int Allowance,int Count,int Check) {
        Scanner sc = new Scanner(System.in);
        System.out.println("떡볶이,우동,과자,빵,과일의 금액을 각각 입력하세요");
        int Food = sc.nextInt(); //떡볶이
        int Food2 = sc.nextInt(); //우동
        int Food3 = sc.nextInt(); //과자
        int Food4 = sc.nextInt(); //빵
        int Food5 = sc.nextInt(); //과일
        return Order(Allowance,Count,Check,Food,Food2,Food3,Food4,Food5);
    }
    public static int Order(int Allowance,int Count,int Check,int Food,int Food2,int Food3,int Food4,int Food5) {
        Scanner sc = new Scanner(System.in);
        if (Count == 0) {
            System.out.println("떡볶이를 몇개 주문 하시겠습니까?");
            int Number = sc.nextInt();
            return Examine(Check, Allowance, Count, Number, Food,Food2,Food3,Food4,Food5, "떡볶이");
        }
        if (Count == 1) {
            System.out.println("우동을 몇개 주문 하시겠습니까?");
            int Number = sc.nextInt();
            return Examine(Check, Allowance, Count, Number, Food,Food2,Food3,Food4,Food5, "우동");
        }
        if (Count == 2) {
            System.out.println("과자를 몇개 주문 하시겠습니까?");
            int Number = sc.nextInt();
            return Examine(Check, Allowance, Count, Number, Food,Food2,Food3,Food4,Food5, "과자");
        }
        if (Count == 3) {
            System.out.println("빵을 몇개 주문 하시겠습니까?");
            int Number = sc.nextInt();
            return Examine(Check, Allowance, Count, Number, Food,Food2,Food3,Food4,Food5, "빵");
        }
        if (Count == 4) {
            System.out.println("과일을 몇개 주문 하시겠습니까?");
            int Number = sc.nextInt();
            return Examine(Check, Allowance, Count, Number, Food,Food2,Food3,Food4,Food5, "과일");
        }
        if (Count == 5) {
            return Allowance;
        }
        return 0;
    }
    public static int Examine(int Check,int Allowance,int Count,int Number,int Food,int Food2,int Food3,int Food4,int Food5,String FoodName) {
        Scanner sc = new Scanner(System.in);
        int Total = (Number * Food);

        if (Allowance < Total && Check == 1) {
            System.out.println("추가적으로 용돈을 받았기 때문에 쫒겨났습니다");
            System.exit(1);
        }
        if (Allowance >= Total) {
            System.out.println(""+FoodName+"는 "+Total+"원이고 현재 남은 잔액은 "+(Allowance - Total)+"원 입니다");
            Allowance -= Total;
            return Order(Allowance,(Count + 1),Check,Food,Food2,Food3,Food4,Food5);
        } else {
            System.out.println("현재 "+(Total - Allowance)+"원 부족합니다 얼마를 추가하시겠습니까?");
            int PlusMoney = sc.nextInt();
            Allowance += PlusMoney;
            Allowance -= Total;
            System.out.println(""+PlusMoney+"원을 받아 현재 잔액은 "+Allowance+"원 입니다");
            return Order(Allowance,(Count + 1),(Check + 1),Food,Food2,Food3,Food4,Food5);
        }
    }
}
