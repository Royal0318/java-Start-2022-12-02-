import java.util.Scanner;
public class forwhile23 {

    int Totalchance;
    int Totalmoney;
    int Accountcheck;
    int[][] Foodarr;


    forwhile23 () {

    }
    forwhile23 (int Totalchance,int Totalmoney,int Accountcheck,int[][] Foodarr) {
        this.Totalchance = Totalchance;
        this.Totalmoney = Totalmoney;
        this.Accountcheck = Accountcheck;
        this.Foodarr = Foodarr;
    }

    void Age () {
        Scanner sc = new Scanner(System.in);
        System.out.println("나이를 입력해주세요 (1 ~ 200세)");
        int Age = sc.nextInt();

        if (Age < 1 || Age > 200) {
            System.out.println("나이를 다시 입력해주세요");
            Age();
        } else {
            System.out.println("귀하의 나이는 " + Age + "세 입니다");
            Gender();
        }
    }
    void Gender () {
        Scanner sc = new Scanner(System.in);
        System.out.println("성별을 적어주세요 (예)남 or 여)");
        String Gender = sc.next();

        if (Gender.equals("남") || Gender.equals("여") || Gender.equals("남자") || Gender.equals("여자")) {
            System.out.println("귀하의 성별은 "+Gender+"입니다");
            PhoneFrontnumber();
        } else {
            System.out.println("성별을 다시 적어주세요");
            Gender();
        }
    }
    void PhoneFrontnumber () {
        Scanner sc = new Scanner(System.in);
        System.out.println("국번 제외 전화번호 앞 4자리를 적어주세요 (예)010-1234-5678 --- > 1234)");
        int Frontnumber = sc.nextInt();

        if (Frontnumber >= 1000 && Frontnumber < 10000) {
            System.out.println("국번 제외 전화번호 뒤 4자리를 적어주세요 (예)010-1234-5678 --- > 5678)");
            int Backnumber = sc.nextInt();

            if (Backnumber > 1000 && Backnumber < 10000) {
                System.out.println("귀화의 휴대폰 번호는 010-"+Frontnumber+"-"+Backnumber+"입니다");
                Personalnumber();
            } else {
                System.out.println("번호를 다시 입력해주세요");
                PhoneFrontnumber();
            }
        } else {
            System.out.println("번호를 다시 입력해주세요");
            PhoneFrontnumber();
        }
    }
    void Personalnumber () {
        Scanner sc = new Scanner(System.in);
        System.out.println("주민등록번호 뒤 7자리를 입력해주세요 (예)960318-1234567 --> 1234567)");
        int Pesonalnumber = sc.nextInt();

        if (Pesonalnumber > 10000 && Pesonalnumber < 9999999) {
            Bank();
        }
        if (Pesonalnumber < 1000000 || Pesonalnumber > 9999999) {
            if (Totalchance >= 1) {
                Totalchance -= 1;
                System.out.println("다시 입력해주세요 남은기회 : " + Totalchance + "회");
                Personalnumber();
            } else {
                Totalchance -= 1;
                Incorrect(Pesonalnumber);
            }
        }
    }
    void Incorrect (int Pesonalnumber) {
        if (Totalchance == -2) {
            System.out.println("기회를 모두 사용하였으므로 프로그램을 종료합니다");
            System.exit(0); //시스템0은 정상적인 종료방법 1은 비정상적인 종료방법
        }
        if (Pesonalnumber < 1000000 || Pesonalnumber > 9999999 && Totalchance == -1) {
            System.out.println("마지막 기회입니다");
            Personalnumber();
        }
    }
    void Bank () {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.계좌조회 2.계좌입금 3.계좌출금 4.음식점   \n안내 : 계좌조회는 1회만 가능하며 이후 기회가 차감됩니다");
            int Bankselect = sc.nextInt();

            switch (Bankselect) {
                case 1:
                    if (Accountcheck == 2) {
                        Totalchance -= 1;
                        if (Totalchance >= 1) {
                            System.out.println("계좌조회는 1회만 가능합니다 남은기회 : "+Totalchance+"회");
                        } else {
                            System.out.println("기회를 모두 사용하였으므로 프로그램을 종료합니다");
                            System.exit(0);
                        }
                    } else if (Accountcheck == 1) {
                        System.out.println("현재 잔액은 : " + Totalmoney + "원 입니다");
                        Accountcheck = 2;
                    } else {
                        System.out.println("처음에는 계좌입금과 출금만 가능합니다");
                    }
                    Bank();
                case 2:
                    Moneydeposit();
                case 3:
                    Withdrawal();
                case 4:
                    //가진 돈에따른 음식값의 비율
                    Foodarr[0][0] = (Totalmoney / 20); //장어덮밥
                    Foodarr[1][0] = (Totalmoney / 10); //옥수수콘
                    Foodarr[2][0] = (Totalmoney * 3 / 100); //감자튀김
                    Restaurant();
                default:
                    System.out.println("잘못된 입력입니다");
            }
        }
    }
    void Moneydeposit () {
        Scanner sc = new Scanner(System.in);
        System.out.println("입금 금액을 적어주세요");
        int Depositmoney = sc.nextInt();
        if (Depositmoney < 1) {
            System.out.println("최소 1원부터 입금 가능합니다");
            Moneydeposit();
        } else {
            Totalmoney += Depositmoney;
            System.out.println("입금이 완료되었습니다 현재 잔액 : "+Totalmoney+"원");
            Accountcheck = 1;
            Bank();
        }
    }
    void Withdrawal () {
        Scanner sc = new Scanner(System.in);
        System.out.println("출금 금액을 적어주세요");
        int Withdrawalmoney = sc.nextInt();
        if (Totalmoney < Withdrawalmoney) {
            System.out.println("출금 금액이 잔액보다 더 많습니다");
            Withdrawal();
        } else {
            Totalmoney -= Withdrawalmoney;
            System.out.println("출금이 완료되었습니다 현재 잔액 : "+Totalmoney+"원");
        }
        Bank();
    }
    void Restaurant () {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.장어덮밥(" + Foodarr[0][0] + "원) 2.옥수수콘(" + Foodarr[1][0] + "원) 3.감자튀김(" + Foodarr[2][0] + "원) 4.계산[변경] 5.환불 6.시스템 종료 \n<<<현재 잔액 : "+Totalmoney+"원>>>");
            int Foodchoice = sc.nextInt();

            switch (Foodchoice) {
                case 1:
                    Foodcalculation(0, "장어덮밥");
                case 2:
                    Foodcalculation(1, "옥수수콘");
                case 3:
                    Foodcalculation(2, "감자튀김");
                case 4:
                    Menuchange();
                case 5:
                    Refund();
                case 6:
                    System.out.println("시스템을 종료합니다");
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다");
            }
        }
    }
    void Foodcalculation (int Foodindexarr,String Foodname) {
        if (Totalmoney > Foodarr[Foodindexarr][0]) {
            Totalmoney -= Foodarr[Foodindexarr][0]; //해당음식 가격 차감
            Foodarr[Foodindexarr][1] += 1; //해당 음식개수증가
            System.out.println(""+Foodname+"구매가 완료되었습니다");
        } else {
            System.out.println("돈이 부족합니다");
        }
        Restaurant();
    }
    void Menuchange () {
        int Pricecheck = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("교환 할 음식의 번호를 적어주세요 (예)감자튀김 --> 옥수수콘 --> 3 Enter 2 Enter)? \n1.장어덮밥  \n2.옥수수콘  \n3.감자튀김");
            int Changefood = sc.nextInt() - 1;
            int Changefood2 = sc.nextInt() - 1;

            if (Changefood < 0 || Changefood > 2 || Changefood2 < 0 || Changefood2 > 2) {
                System.out.println("잘못된 입력입니다");
            } else {
                if (Foodarr[Changefood][1] == 0) {
                    System.out.println("수량을 다시 확인해주세요");
                    System.out.println("안내 : 현재 구매한 음식의 개수 \n1.장어덮밥 : " + Foodarr[0][1] + "개 \n2.옥수수콘 : " + Foodarr[1][1] + "개 \n3.감자튀김 : " + Foodarr[2][1] + "개");
                } else {
                    Foodarr[Changefood][1] -= 1;//교환하므로 수량감소
                    Foodarr[Changefood2][1] += 1;//교환하므로 수량증가
                    Pricecheck += (Foodarr[Changefood][0] - Foodarr[Changefood2][0]);

                    if (Pricecheck < 0) { //Pricecheck가 음수가 나온다는것은 더 비싼음식으로 음식을 바꿧다는뜻이다
                        Totalmoney -= ((Foodarr[Changefood][0] - Foodarr[Changefood2][0]));//교환하지만 추가적으로 돈을 더 내야하는상황
                        System.out.println("교환이 완료되었습니다 " + ((Foodarr[Changefood][0] - Foodarr[Changefood2][0]) * -1) + "원을 추가로 지불했습니다");
                    } else {
                        Totalmoney += ((Foodarr[Changefood][0] - Foodarr[Changefood2][0]));//교환하지만 값이 싼음식으로 바꿧으므로 추가적으로 돈을 받음
                        System.out.println("교환이 완료되었습니다 " + (Foodarr[Changefood][0] - Foodarr[Changefood2][0]) + "원을 추가로 받았습니다");
                    }
                }
                Restaurant();
            }
        }
    }
    void Refund () {
        Scanner sc = new Scanner(System.in);
        System.out.println("환불 할 음식의 번호를 적어주세요 \n1.장어덮밥  \n2.옥수수콘  \n3.감자튀김");
        int Refundfoodnumber = sc.nextInt();

        switch (Refundfoodnumber) {
            case 1 :
               Refundfinish("장어덮밥",1);
            case 2 :
                Refundfinish("옥수수콘",2);
            case 3 :
                Refundfinish("감자튀김",3);
            default :
                System.out.println("잘못된 입력입니다");
                Refund();
        }
    }
    void Refundfinish (String Food,int index) {
        if (Foodarr[index - 1][1] >= 1) {
            Totalmoney += Foodarr[index - 1][0];
            Foodarr[index - 1][1] -= 1; //환불하였으므로 개수 차감
            System.out.println("" + Food + "환불이 완료되었습니다");
        } else {
            System.out.println("구매한 내역이 없습니다");
        }
        Restaurant();
    }
}
