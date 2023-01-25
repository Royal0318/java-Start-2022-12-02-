import java.util.Scanner;

public class Jaunarytwenthfifth {
    public static void main(String[] args) {
        System.out.println(""+VariableSave()+"");
    }

    /*
    TodayPeopleInput에서 하루손님이 5명이거나 12명일때 10명으로 맞추는 방법구현
    영수증조회로가서 몇월몇일것을 확인할것인지 구현
     */
    public static int VariableSave() { //변수 보관 메소드
        int Month = 0; //달
        int Days = 0; //날짜
        int TotalBuyMoneySum = 0;
        int[][][] TransferredPersonCheck = new int[12][31][10]; //해당 손님이 이전된사람인지 체크함
        int[][][] arr = new int[12][31][10]; //한해의 12월 31일까지 2차원배열로 표현
        int[][][] Pointarr = new int[12][31][10];
        int[][][] BaconBuyNumber = new int[12][31][10];
        int[][][] IceCreamBuyNumber = new int[12][31][10];
        int[][][] BeenBuyNumber = new int[12][31][10];
        return TodayPeopleInput(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber,TotalBuyMoneySum,Pointarr);
    }

    public static int TodayPeopleInput(int Month, int Days, int[][][] arr, int[][][] TransferredPersonCheck, int[][][] BaconBuyNumber, int[][][] IceCreamBuyNumber, int[][][] BeenBuyNumber,int TotalBuyMoneySum,int[][][]Pointarr) {
        Scanner sc = new Scanner(System.in);
        int Count = 0;

        for (int i = Month; i < 12; i++) {
            for (int j = Days; j < 31; j++) {
                System.out.println("" + (Month + 1) + "월 " + (Days + 1) + "일의 손님 수 입력 \n안내 : 하루에 입력 가능한 손님 수는 100명 입니다");
                int TodayPeople = sc.nextInt();

                if (TodayPeople > 10) { //하루에 입장하는손님이 10명이 초과될경우
                    for (int k = 0; k < ((TodayPeople - 10) - Count); k++) { //10명이 넘는경우 체크배열값에 1을 추가하여 이전된 사람인지 판단하기 위한 절차
                        TransferredPersonCheck[Month][Days + 1][k] = 1;//10명이 넘었기때문에 다음날로 사람을 이전시키기 때문에 Day + 1을 적용하였다
                        Count++;
                        if (Count == 9) {
                            Days++; //10명이 모두 체크됐다면 다음날로 이전시킴
                        }
                        if ((TodayPeople - 10) == Count) { //둘이 같아졌다면 리턴시켜서 탈출
                            return PeopleMoneyInput(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber,TotalBuyMoneySum,Pointarr);
                        }
                    }
                } else { //이전되는사람이 없는경우
                    return PeopleMoneyInput(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber,TotalBuyMoneySum,Pointarr);
                }
            }
        }
        return 0;
    }

    public static int PeopleMoneyInput(int Month, int Days, int[][][] arr, int[][][] TransferredPersonCheck, int[][][] BaconBuyNumber, int[][][] IceCreamBuyNumber, int[][][] BeenBuyNumber,int TotalBuyMoneySum,int[][][]Pointarr) {
        Scanner sc = new Scanner(System.in);
        int KCount = 0;
        for (int k = KCount; k < 10; k++) { //10말고 상황에따라 다르게한다
            System.out.println("" + (k + 1) + "번째 손님의 돈을 입력해주세요 \n안내 : 10만원을 초과 할 수 없습니다");
            int PeopleMoney = sc.nextInt();

            if (PeopleMoney > 100000) {
                System.out.println("안내 : 10만원을 초과하여 받을 수 없습니다");
                k--;
            } else {
                arr[Month][Days][k] = PeopleMoney;
            }
        }
        return TotalMenuSelect(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber,KCount,TotalBuyMoneySum,Pointarr);
    }

    public static int TotalMenuSelect(int Month, int Days, int[][][] arr, int[][][] TransferredPersonCheck, int[][][] BaconBuyNumber, int[][][] IceCreamBuyNumber, int[][][] BeenBuyNumber,int KCount,int TotalBuyMoneySum,int[][][]Pointarr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("<<<주의사항>>> \n1.포인트 적립은 1번만 가능합니다\n2.다음사람과 시스템종료를 하기 위해서는 2가지의 조건이 존재합니다 \n첫번째 : 감자콩 개수가 아이스크림 보다 많은것 \n두번째 : 아이스크림 개수가 10의 배수일것\n");
        for (int k = KCount; k < 10; k++) {
            System.out.println("k값 "+k+" kcount"+KCount+"");
            System.out.println("" + (k + 1) + "번째 손님의 선택 \n1.베이컨 5000원,\n2.아이스크림 3000원,\n3.감자콩 1000원 \n4.다음사람 \n5.시스템 종료 \n6.포인트 적립 \n7.다음 날 \n8.영수증 조회");
            int MenuSelect = sc.nextInt();

            if (MenuSelect == 1) {
                return InputFoodBuyCorrectGuesses(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber, k, 5000, "베이컨",TotalBuyMoneySum,Pointarr);
            } else if (MenuSelect == 2) {
                return InputFoodBuyCorrectGuesses(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber, k, 3000, "아이스크림",TotalBuyMoneySum,Pointarr);
            } else if (MenuSelect == 3) {
                return InputFoodBuyCorrectGuesses(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber, k, 1000, "감자콩",TotalBuyMoneySum,Pointarr);
            } else if (MenuSelect == 4) {
                return NextDays(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber, k, MenuSelect,TotalBuyMoneySum,Pointarr);
            } else if (MenuSelect == 5) {
                return NextDays(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber, k, MenuSelect,TotalBuyMoneySum,Pointarr);
            } else if (MenuSelect == 6) {
                return PointsAccumulated(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber, k,TotalBuyMoneySum,Pointarr);
            } else if (MenuSelect == 7) {
                Days++;
                return TodayPeopleInput(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber,TotalBuyMoneySum,Pointarr); //다음날로 이동
            } else if (MenuSelect == 8) {
                return ReceiptCheck(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber,k,TotalBuyMoneySum,Pointarr);
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
        return 0;
    }

    public static int InputFoodBuyCorrectGuesses(int Month, int Days, int[][][] arr, int[][][] TransferredPersonCheck, int[][][] BaconBuyNumber, int[][][] IceCreamBuyNumber, int[][][] BeenBuyNumber, int k, int Price, String FoodName,int TotalBuyMoneySum,int[][][]Pointarr) { //구매한 음식정산
        if (Price == 5000) {
            BaconBuyNumber[Month][Days][k] += 1;
        } else if (Price == 3000) {
            IceCreamBuyNumber[Month][Days][k] += 1;
        } else {
            BeenBuyNumber[Month][Days][k] += 1;
        }
        arr[Month][Days][k] -= Price; //전체돈에서 차감
        TotalBuyMoneySum += Price;
        System.out.println("" + FoodName + "구매를 완료하였습니다 \n남은 잔액 " + arr[Month][Days][k] + "원");
        k++;
        return TotalMenuSelect(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber,k,TotalBuyMoneySum,Pointarr);
    }

    public static int NextDays(int Month, int Days, int[][][] arr, int[][][] TransferredPersonCheck, int[][][] BaconBuyNumber, int[][][] IceCreamBuyNumber, int[][][] BeenBuyNumber, int k, int MenuSelect,int TotalBuyMoneySum,int[][][]Pointarr) {
        int IceNumberCal = (((IceCreamBuyNumber[Month][Days][k] / 10 * 10) + 10) - IceCreamBuyNumber[Month][Days][k]); //배수판단 계산식

        if (BeenBuyNumber[Month][Days][k] > IceCreamBuyNumber[Month][Days][k]) {
            if ((IceCreamBuyNumber[Month][Days][k] % 10) != 0) {
                //아이스크림이 10의배수가 아닌경우
                System.out.println("안내 : 아이스크림의 개수를 " + IceNumberCal + "개 더 구매하세요");
            } else {
                //모두 통과되는 경우
                if (MenuSelect == 4) {
                    k++;
                    return TotalMenuSelect(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber,k,TotalBuyMoneySum,Pointarr);
                } else if (MenuSelect == 5) {
                    System.out.println("시스템을 종료합니다");
                    System.exit(1);
                }
            }
        } else {
            //감자콩이 아이스크림  개수보다 적을경우
            System.out.println("안내 : 현재 감자콩의 개수는 " + BeenBuyNumber[Month][Days][k] + "개이며 최소" + (IceCreamBuyNumber[Month][Days][k] - BeenBuyNumber[Month][Days][k]) + "개를 더 구매해야 합니다");
            return TotalMenuSelect(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber,k,TotalBuyMoneySum,Pointarr);
        }
        return 0;
    }
    public static int PointsAccumulated (int Month, int Days, int[][][] arr, int[][][] TransferredPersonCheck, int[][][] BaconBuyNumber, int[][][] IceCreamBuyNumber, int[][][] BeenBuyNumber, int k,int TotalBuyMoneySum,int[][][]Pointarr) {
        if (Pointarr[Month][Days][k] == 0) {
            double PointCal = (TotalBuyMoneySum * 0.01);
            Pointarr[Month][Days][k] += PointCal;
            System.out.println("포인트 적립이 완료되었습니다 \n현재 포인트 : " + PointCal + "Point");
        } else {
            System.out.println("포인트 적립은 한번만 가능합니다");
        }
        return TotalMenuSelect(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber, k, TotalBuyMoneySum, Pointarr);
    }
    public static int ReceiptCheck (int Month,int Days,int[][][]arr,int[][][]TransferredPersonCheck,int[][][]BaconBuyNumber,int[][][]IceCreamBuyNumber,int[][][]BeenBuyNumber,int k,int TotalBuyMoneySum,int[][][]Pointarr) {
        for (int i = 0; i < 10; i++) {
            if (BaconBuyNumber[Month][Days][i] == 0 && IceCreamBuyNumber[Month][Days][i] == 0 && BeenBuyNumber[Month][Days][i] == 0) {
                continue; //하나도 구매하지 않은경우 출력되지 않도록 설정한다
            }
            System.out.println("[" + Month + "월" + Days + "일] \n==========주문표==========");
            if (BaconBuyNumber[Month][Days][i] >= 1) {
                System.out.println("베이컨 X " + BaconBuyNumber[Month][Days][i] + "개 = " + (BaconBuyNumber[Month][Days][i] * 5000) + "원");
            }
            if (IceCreamBuyNumber[Month][Days][i] >= 1) {
                System.out.println("아이스크림 X " + BaconBuyNumber[Month][Days][i] + "개 = " + (BaconBuyNumber[Month][Days][i] * 3000) + "원");
            }
            if (BeenBuyNumber[Month][Days][i] >= 1) {
                System.out.println("감자콩 X " + BaconBuyNumber[Month][Days][i] + "개 = " + (BaconBuyNumber[Month][Days][i] * 1000) + "원");
            }
            System.out.println("======="+i+"번째 손님======= \n원래 가지고 있던 금액 : "+(TotalBuyMoneySum + arr[Month][Days][i])+"원 \n현재 가지고 있는 금액 : "+arr[Month][Days][i]+"원");
            if (Pointarr[Month][Days][i] != 0) {
                System.out.println("현재 보유 포인트 : "+Pointarr[Month][Days][i]+"");
            }
        }
        return TotalMenuSelect(Month, Days, arr, TransferredPersonCheck, BaconBuyNumber, IceCreamBuyNumber, BeenBuyNumber,k,TotalBuyMoneySum,Pointarr);
    }
}
