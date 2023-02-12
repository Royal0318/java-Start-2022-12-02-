import java.util.Scanner;

public class forwhile18 {
    public static void main(String[] args) {
        System.out.println("남은 금액은 총 " + Storevariables() + "원 입니다");
    }
    public static int Storevariables() {
        //변수를 보관하는 메소드
        int Foodbuysum = 0;
        int Calsum = 0;
        int Calcheck = 0;
        int Gobackin = 0;
        return Meinmenu(Foodbuysum, Gobackin,Calsum,Calcheck);
    }

    public static int Meinmenu(int Foodbuysum, int Gobackin,int Calsum,int Calcheck) {
        //메인메뉴 메소드
        Scanner sc = new Scanner(System.in);
        System.out.println("1.구구단 2.음식점 3.계산기 4.종료");
        int Menuselect = sc.nextInt();

        if (Menuselect == 1) {
            return Gugudan(Foodbuysum, Gobackin,Calsum,Calcheck);
        } else if (Menuselect == 2) {
            if (Gobackin == 0) {
                return Restaurant(Foodbuysum, Gobackin,Calsum,Calcheck);
            } else {
                return RebuyRestaurant(Foodbuysum, Gobackin,Calsum,Calcheck);
            }
        } else if (Menuselect == 3) {
            if (Calcheck == 0) {
                return Calculator(Foodbuysum, Gobackin,Calsum,Calcheck);
            } else {
                return Gobackcal(Foodbuysum, Gobackin,Calsum,Calcheck);
            }
        } else if (Menuselect == 4) {
            return  Foodbuysum;
        } else {
            System.out.println("잘못된 입력입니다");
        }
        return 0;
    }

    public static int Gugudan(int Foodbuysum, int Gobackin,int Calsum,int Calcheck) {
        //구구단
        for (int i = 0; i < 9; i++) {
            System.out.println("============(" + (i + 1) + "단)============");
            for (int j = 0; j < 9; j++) {
                System.out.println("" + (i + 1) + " X " + (j + 1) + " = " + ((i + 1) * (j + 1)) + "");
            }
        }
        return Meinmenu(Foodbuysum, Gobackin,Calsum,Calcheck);
    }

    public static int Restaurant(int Foodbuysum, int Gobackin,int Calsum,int Calcheck) {
        //음식점 (재진입 X)
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.볶음밥[8000원] 2.짜장면[7000원] 3.탕수육 4.돌아가기");
            int Foodselect = sc.nextInt();

            if (Foodselect == 1) {
                Foodbuysum += 8000;
                System.out.println("볶음밥 주문이 완료되었습니다 누적금액 : " + Foodbuysum + "원");
            } else if (Foodselect == 2) {
                Foodbuysum += 7000;
                System.out.println("짜장면 주문이 완료되었습니다 누적금액 : " + Foodbuysum + "원");
            } else if (Foodselect == 3) {
                System.out.println("1.대[28000원] 2.중[24000원] 3.소[18000원]");
                int Freshselect = sc.nextInt();

                if (Freshselect == 1) {
                    Foodbuysum += 28000;
                    System.out.println("탕수육 [대] 주문이 완료되었습니다 누적금액 : " + Foodbuysum + "원");
                } else if (Freshselect == 2) {
                    Foodbuysum += 24000;
                    System.out.println("탕수육 [중] 주문이 완료되었습니다 누적금액 : " + Foodbuysum + "원");
                } else if (Freshselect == 3) {
                    Foodbuysum += 18000;
                    System.out.println("탕수육 [소] 주문이 완료되었습니다 누적금액 : " + Foodbuysum + "원");
                } else {
                    System.out.println("잘못된 입력입니다");
                }
            } else if (Foodselect == 4) {
                if (Foodbuysum >= 7000) {
                    Gobackin += 1;
                }
                return Meinmenu(Foodbuysum, Gobackin, Calsum,Calcheck);
            }
        }
    }

    public static int RebuyRestaurant(int Foodbuysum, int Gobackin,int Calsum,int Calcheck) {
        //음식점 (재진입 O 음식값 누적X)
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.볶음밥[8000원] 2.짜장면[7000원] 3.탕수육 4.돌아가기");
            int Foodselect = sc.nextInt();

            if (Foodselect == 1) {
                System.out.println("볶음밥 주문이 완료되었습니다 누적금액 : " + Foodbuysum + "원");
            } else if (Foodselect == 2) {
                System.out.println("짜장면 주문이 완료되었습니다 누적금액 : " + Foodbuysum + "원");
            } else if (Foodselect == 3) {
                System.out.println("1.대[28000원] 2.중[24000원] 3.소[18000원]");
                int Freshselect = sc.nextInt();

                if (Freshselect == 1) {
                    System.out.println("탕수육 [대] 주문이 완료되었습니다 누적금액 : " + Foodbuysum + "원");
                } else if (Freshselect == 2) {
                    System.out.println("탕수육 [중] 주문이 완료되었습니다 누적금액 : " + Foodbuysum + "원");
                } else if (Freshselect == 3) {
                    System.out.println("탕수육 [소] 주문이 완료되었습니다 누적금액 : " + Foodbuysum + "원");
                } else {
                    System.out.println("잘못된 입력입니다");
                }
            } else if (Foodselect == 4) {
                return Meinmenu(Foodbuysum, Gobackin, Calsum,Calcheck);
            }
        }
    }
    public static int Calculator (int Foodbuysum,int Gobackin,int Calsum,int Calcheck) {
        //계산기 모드 재진입 X
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.더하기 2.빼기 3.돌아가기");
            int Calselect = sc.nextInt();

            if (Calselect == 1) {
                System.out.println("1번째 숫자와 2번째 숫자를 입력해주세요");
                int Firstnumber = sc.nextInt();
                int Secondnumber = sc.nextInt();
                System.out.println("" + Firstnumber + " + " + Secondnumber + " = " + (Firstnumber + Secondnumber) + "");
                Calsum += (Firstnumber + Secondnumber);
            } else if (Calselect == 2) {
                System.out.println("1번째 숫자와 2번째 숫자를 입력해주세요");
                int Firstnumber = sc.nextInt();
                int Secondnumber = sc.nextInt();

                if (Firstnumber < Secondnumber) {
                    System.out.println("2번째 숫자가 더 클 수 없습니다");
                } else {
                    System.out.println("" + Firstnumber + " - " + Secondnumber + " = " + (Firstnumber - Secondnumber) + "");
                }
            } else if (Calselect == 3) {
                Calcheck += 1;
                return Meinmenu(Foodbuysum, Gobackin, Calsum,Calcheck);
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
    public static int Gobackcal (int Foodbuysum,int Gobackin,int Calsum,int Calcheck) {
        //계산기 모드 재진입 O
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.더하기 2.빼기 3.돌아가기");
            int Calselect = sc.nextInt();

            if (Calselect == 1) {
                System.out.println("값을 입력해주세요");
                int Firstnumber = sc.nextInt();
                System.out.println("" + Calsum + " + " + Firstnumber + " = " + (Calsum + Firstnumber) + "");
                Calsum += Firstnumber;
            } else if (Calselect == 2) {
                System.out.println("값을 입력해주세요");
                int Firstnumber = sc.nextInt();

                if (Calsum < Firstnumber) {
                    System.out.println("2번째 숫자가 더 클 수 없습니다");
                } else {
                    System.out.println("" + Calsum + " - " + Firstnumber + " = " + (Calsum - Firstnumber) + "");
                    Calsum -= Firstnumber;
                }
            } else if (Calselect == 3) {
                return Meinmenu(Foodbuysum, Gobackin, Calsum,Calcheck);
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
}
