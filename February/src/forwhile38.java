/*
import java.util.Scanner;

public class forwhile36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] Peoplemoney = new int[15];
        int[] Borrowmoneyarr = new int[15]; //빌려준금액
        int[] Deftmoneyarr = new int[15];//빚진금액
        int[] Paybackmoneyarr = new int[15];//갚은금액
        //음식 배열
        int[] Breadnumber = new int[15];
        int[] Dringknumber = new int[15];
        int[] Snacknumber = new int[15];
        int[] Winenumber = new int[15];
        int[] Fruitnumber = new int[15];
        int[] Menucheck = new int[15];
        int Count = 0;
        int AddBorrowcount = 0;
        Peoplemoney[0] = 20000;
        Peoplemoney[1] = 20000;
        Peoplemoney[2] = 20000;
        Peoplemoney[3] = 20000;
        Peoplemoney[4] = 20000;
        Peoplemoney[5] = 10000;
        Peoplemoney[6] = 10000;
        Peoplemoney[7] = 10000;
        Peoplemoney[8] = 10000;
        Peoplemoney[9] = 20000;
        for (int i = 10; i < 15; i++) {
            System.out.println("" + i + "번째 손님 돈 입력");
            Peoplemoney[i] = sc.nextInt();
        }
        System.out.println("입력이 모두 완료되었습니다");
        //meinmenu
        for (int i = 0; i < 15; i++) {
            System.out.println(""+(i + 1)+"번째 손님의 선택입니다");
            System.out.println("1.빵[1200원] 2.음료수[1000원] 3.과자[1300원] 4.술[3000원] 5.과일[2500원] 6.다음손님 7.돈갚기 8.제어 9.시스템 종료");
            int Menuchoice = sc.nextInt();

            if (Menuchoice == 1) {
                Count = 1;
            } else if (Menuchoice == 2) {
               Count = 2;
            } else if (Menuchoice == 3) {
                Count = 3;
            } else if (Menuchoice == 4) {
                Count = 4;
            } else if (Menuchoice == 5) {
                Count = 5;
            } else if (Menuchoice == 6) {
                Count = 6;
            } else if (Menuchoice == 7) {
                Count = 7;
            } else if (Menuchoice == 8) {
                Count = 8;
            } else if (Menuchoice == 9) {
                Count = 9;
            }
            if (Count == 1) {
                System.out.println("몇개를 구매하시겠습니까?");
                Breadnumber[i] = sc.nextInt();
                Peoplemoney[i] = (Peoplemoney[i] - (Breadnumber[i] * 1200));

                if (Peoplemoney[i] < 0) {
                    Menucheck[i] = 1;
                    Count = 10;
                } else {
                    System.out.println("빵 " + Breadnumber[i] + "개 구매가 완료되었습니다");
                    i--; //계속 고를 수 있도록 i값 고정
                }
            } else if (Count == 2) {
                System.out.println("몇개를 구매하시겠습니까?");
                Dringknumber[i] = sc.nextInt();
                Peoplemoney[i] = (Peoplemoney[i] - (Dringknumber[i] * 1000));

                if (Peoplemoney[i] < 0) {
                    Menucheck[i] = 2;
                    Count = 10;
                } else {
                    System.out.println("음료수 " + Dringknumber[i] + "개 구매가 완료되었습니다");
                    i--;
                }
            } else if (Count == 3) {
                System.out.println("몇개를 구매하시겠습니까?");
                Snacknumber[i] = sc.nextInt();
                Peoplemoney[i] = (Peoplemoney[i] - (Snacknumber[i] * 1300));

                if (Peoplemoney[i] < 0) {
                    Menucheck[i] = 3;
                    Count = 10;
                } else {
                    System.out.println("과자 " + Snacknumber[i] + "개 구매가 완료되었습니다");
                    i--;
                }
            } else if (Count == 4) {
                System.out.println("몇개를 구매하시겠습니까?");
                Winenumber[i] = sc.nextInt();
                Peoplemoney[i] = (Peoplemoney[i] - (Winenumber[i] * 3000));

                if (Peoplemoney[i] < 0) {
                    Menucheck[i] = 4;
                    Count = 10;
                } else {
                    System.out.println("술 " + Winenumber[i] + "개 구매가 완료되었습니다");
                    i--;
                }
            } else if (Count == 5) {
                System.out.println("몇개를 구매하시겠습니까?");
                Fruitnumber[i] = sc.nextInt();
                Peoplemoney[i] = (Peoplemoney[i] - (Fruitnumber[i] * 2500));

                if (Peoplemoney[i] < 0) {
                    Menucheck[i] = 5;
                    Count = 10;
                } else {
                    System.out.println("과일 " + Fruitnumber[i] + "개 구매가 완료되었습니다");
                    i--;
                }
            } else if (Count == 6) {
                    for (int j = 0; j < 15; j++) {
                        if (Breadnumber[j] == 0 && Dringknumber[j] == 0 && Snacknumber[j] == 0 && Winenumber[j] == 0 && Fruitnumber[j] == 0) {
                            continue;
                        }
                        System.out.println("=========================" + j + "번째 손님 주문표=========================");
                        if (Breadnumber[j] >= 1) {
                            System.out.println("빵 X " + Breadnumber[j] + "개 = " + (Breadnumber[j] * 1200) + "원");
                        }
                        if (Dringknumber[j] >= 1) {
                            System.out.println("음료수 X " + Dringknumber[j] + "개 = " + (Dringknumber[j] * 1000) + "원");
                        }
                        if (Snacknumber[j] >= 1) {
                            System.out.println("과자 X " + Snacknumber[j] + "개 = " + (Snacknumber[j] * 1300) + "원");
                        }
                        if (Winenumber[j] >= 1) {
                            System.out.println("술 X " + Winenumber[j] + "개 = " + (Winenumber[j] * 3000) + "원");
                        }
                        if (Fruitnumber[j] >= 1) {
                            System.out.println("과일 X " + Fruitnumber[j] + " = " + Fruitnumber[j] * 2500 + "원");
                        }
                        System.out.println("원래 가지고 있던 금액 : "++"원");
                        System.out.println("현재 가지고 있는 금액 : "++"원");
                        System.out.println("빚 진 금액 : "+Deftmoneyarr[j]+"원");
                        System.out.println("빚을 청산하고 남은 금액 : "+(Deftmoneyarr[j] - Paybackmoneyarr[j])+"원");
                        System.out.println("미납된 금액 : "++"원");
                        System.out.println("빌려준 금액 : "+Borrowmoneyarr[j]+"원");
                        System.out.println("============================================================");
                    }
            } else if (Count == 7) {

            } else if (Count == 8) {

            } else if (Count == 9) {
                System.out.println("시스템을 종료합니다");
                break;
            } else if (Count == 10) {
                while (true) {
                    System.out.println("돈이 " + (Peoplemoney[i] * -1) + "원 부족합니다 추가로 빌리시겠습니까? \n1.예 2.아니요");
                    int Borrowchoice = sc.nextInt();

                    if (Borrowchoice == 1) {
                        System.out.println("얼마를 빌리시겠습니까?");
                        int Borrowmoney = sc.nextInt();

                        if (Borrowmoney > Peoplemoney[i + 1 + AddBorrowcount]) {
                            System.out.println("다음사람이 가진돈보다 초과하여 빌릴 수 없습니다");
                        } else if (Borrowmoney < Peoplemoney[i + 1 + AddBorrowcount]) { //돈을 빌리는것이 다음사람이 가지고 있는 돈보다 적게 빌리는경우
                            Peoplemoney[i] += Borrowmoney;
                            if (Peoplemoney[i] < 0) { //돈을 빌려도 부족한경우
                                System.out.println("추가적으로 돈을 더 빌려야합니다");
                                AddBorrowcount += 1;
                            } else {
                                System.out.println(""+Borrowmoney+"원을 빌렸습니다 다음 사람이 가진 돈 "+(Peoplemoney[i + 1 + AddBorrowcount])+"원");
                                i--;
                                AddBorrowcount = 0;
                                break;
                            }
                        }
                    } else if (Borrowchoice == 2) {
                        if (Menucheck[i] == 1) { //빵을 빌릴때
                            Breadnumber[i] = 0; //개수 초기화
                            Peoplemoney[i] += (Breadnumber[i] * 1500); //구매했던 돈 다시 반환
                        } else if (Menucheck[i] == 2) {
                            Dringknumber[i] = 0;
                            Peoplemoney[i] += (Dringknumber[i] * 1000);
                        } else if (Menucheck[i] == 3) {
                            Snacknumber[i] = 0;
                            Peoplemoney[i] += (Snacknumber[i] * 1300);
                        } else if (Menucheck[i] == 4) {
                            Winenumber[i] = 0;
                            Peoplemoney[i] += (Winenumber[i] * 3000);
                        } else {
                            Fruitnumber[i] = 0;
                            Peoplemoney[i] += (Fruitnumber[i] * 2500);
                        }
                        Menucheck[i] = 0;
                        break;
                    } else {
                        System.out.println("잘못된 입력입니다");
                    }
                }
            }
        }
    }
}

 */
