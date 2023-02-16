import java.util.Scanner;
public class forwhile23 {
    int Givenchance; //총 정해진 기회
    int Totalamount; //전체 가지고 있는 돈의 액수
    int Accountinquirycount; //계좌조회 체크관련변수
    int[][] TotalFoodarr; //전체 음식 배열

    forwhile23 () {

    }
    forwhile23 (int Givenchance,int Totalamount,int Accountinquirycount,int[][] TotalFoodarr) {
        this.Givenchance = Givenchance;
        this.Totalamount = Totalamount;
        this.Accountinquirycount = Accountinquirycount;
        this.TotalFoodarr = TotalFoodarr;
    }

    void Ageinput () {
        Scanner sc = new Scanner(System.in);
        System.out.println("나이를 입력해주세요 (입력제한 : 1 ~ 200세)");
        int Age = sc.nextInt();

        if (Age < 1 || Age > 200) {
            System.out.println("나이를 다시 입력해주세요");
            Ageinput();
        } else {
            System.out.println("귀하의 나이는 " + Age + "세 입니다");
            Genderinput();
        }
    }
    void Genderinput () {
        Scanner sc = new Scanner(System.in);
        System.out.println("성별을 적어주세요 (예)남 or 여)");
        String Gender = sc.next();

        if (Gender.equals("남") || Gender.equals("여") || Gender.equals("남자") || Gender.equals("여자")) {
            System.out.println("귀하의 성별은 "+Gender+"입니다");
            Phonefrontnumberinput();
        } else {
            System.out.println("성별을 다시 적어주세요");
            Genderinput();
        }
    }
    void Phonefrontnumberinput () {
        Scanner sc = new Scanner(System.in);
        System.out.println("국번 제외 전화번호 앞 4자리를 적어주세요 (예)010-1234-5678 --- > 1234)");
        int Frontnumber = sc.nextInt();

        if (Frontnumber >= 1000 && Frontnumber < 10000) {
           Phonebacknumberinput(Frontnumber);
        } else {
            System.out.println("번호를 다시 입력해주세요");
            Phonefrontnumberinput();
        }
    }
    void Phonebacknumberinput (int Frontnumber) {
        Scanner sc = new Scanner(System.in);
        System.out.println("국번 제외 전화번호 뒤 4자리를 적어주세요 (예)010-1234-5678 --- > 5678)");
        int Backnumber = sc.nextInt();

        if (Backnumber > 1000 && Backnumber < 10000) {
            System.out.println("귀하의 휴대폰 번호는 010-"+Frontnumber+"-"+Backnumber+"입니다");
            Personalnumberinput();
        } else {
            System.out.println("번호를 다시 입력해주세요");
            Phonebacknumberinput(Frontnumber);
        }
    }
    void Personalnumberinput () {
        Scanner sc = new Scanner(System.in);
        System.out.println("주민등록번호 뒤 7자리를 입력해주세요 예시) 960318-1234567 --> 1234567");
        int Pesonalnumber = sc.nextInt();

        if (Pesonalnumber > 10000 && Pesonalnumber < 9999999) {
            Bankmenuselect();
        }
        if (Pesonalnumber < 1000000 || Pesonalnumber > 9999999) {
            Incorrectguesses();
        }
    }
    void Incorrectguesses () {
        Givenchance -= 1; //전체 기회 1회 차감
        if (Givenchance >= 1) {
            System.out.println("다시 입력해주세요 남은기회 : " + Givenchance + "회");
        } else if (Givenchance == 0) {
            System.out.println("마지막 기회입니다");
        } else {
           Gameover();
        }
        Personalnumberinput();
    }
    void Bankmenuselect () {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.계좌조회 2.계좌입금 3.계좌출금 4.음식점 \n안내 : 계좌조회는 1회만 가능하며 이후 기회가 차감됩니다");
        int Bankselect = sc.nextInt();

        switch (Bankselect) {
            case 1:
                if (Accountinquirycount == 0) {
                    System.out.println("처음에는 계좌입금과 출금만 가능합니다");
                } else if (Accountinquirycount == 1) {
                    System.out.println("현재 잔액은 : " + Totalamount + "원 입니다");
                    Accountinquirycount = 2;
                } else {
                    Givenchance -= 1;
                    if (Givenchance >= 1) {
                        System.out.println("계좌조회는 1회만 가능합니다 남은기회 : " + Givenchance + "회");
                    } else {
                        Gameover();
                    }
                }
                Bankmenuselect();
            case 2:
                Moneydepositinput();
            case 3:
                Withdrawalinput();
            case 4:
                //가진 돈에따른 음식값의 비율
                TotalFoodarr[0][0] = (Totalamount / 20); //index [0] = 장어덮밥
                TotalFoodarr[1][0] = (Totalamount / 10); //index [1] = 옥수수콘
                TotalFoodarr[2][0] = (Totalamount * 3 / 100); //index [2] = 감자튀김
                Restaurantmenu();
            default:
                System.out.println("잘못된 입력입니다");
                Bankmenuselect();
        }
    }
    void Moneydepositinput () {
        Scanner sc = new Scanner(System.in);
        System.out.println("입금 금액을 적어주세요");
        int Depositmoney = sc.nextInt();

        if (Depositmoney < 1) {
            System.out.println("최소 1원부터 입금 가능합니다");
            Moneydepositinput();
        } else {
            System.out.println("입금이 완료되었습니다 현재 잔액 : "+ (Totalamount += Depositmoney)+"원");
            Accountinquirycount = 1;
            Bankmenuselect();
        }
    }
    void Withdrawalinput () {
        Scanner sc = new Scanner(System.in);
        System.out.println("출금 금액을 적어주세요");
        int Withdrawalmoney = sc.nextInt();

        if (Totalamount < Withdrawalmoney) {
            System.out.println("출금 금액이 잔액보다 더 많습니다");
            Withdrawalinput();
        } else {
            System.out.println("출금이 완료되었습니다 현재 잔액 : "+(Totalamount -= Withdrawalmoney)+"원");
            Bankmenuselect();
        }
    }
    void Restaurantmenu () {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.장어덮밥(" + TotalFoodarr[0][0] + "원) 2.옥수수콘(" + TotalFoodarr[1][0] + "원) 3.감자튀김(" + TotalFoodarr[2][0] + "원) 4.계산[변경] 5.환불 6.시스템 종료 \n<<<현재 잔액 : " + Totalamount + "원>>>");
        int Foodchoice = sc.nextInt();

        switch (Foodchoice) {
            case 1:
                Foodcalculation(0, "장어덮밥");
            case 2:
                Foodcalculation(1, "옥수수콘");
            case 3:
                Foodcalculation(2, "감자튀김");
            case 4:
                Foodexchange();
            case 5:
                Refundmenu();
            case 6:
                System.out.println("시스템을 종료합니다");
                System.exit(0);
            default:
                System.out.println("잘못된 입력입니다");
                Restaurantmenu();
        }
    }
    void Foodcalculation (int Foodindexarr,String Foodname) {
        //음식 계산 메소드
        if (Totalamount > TotalFoodarr[Foodindexarr][0]) {
            Totalamount -= TotalFoodarr[Foodindexarr][0]; //구매한 음식의 가격만큼 차감시킨다
            TotalFoodarr[Foodindexarr][1] += 1; //구매한 음식의 개수증가
            System.out.println(""+Foodname+"구매가 완료되었습니다");
        } else {
            System.out.println("돈이 부족합니다");
        }
        Restaurantmenu();
    }
    void Foodexchange () {
        int Foodpricedifference = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("교환 할 음식의 번호를 적어주세요 예시) 감자튀김 --> 옥수수콘 --> 3 Enter 2 Enter \n1.장어덮밥  \n2.옥수수콘  \n3.감자튀김");
        int Changefood = sc.nextInt() - 1;
        int Changefood2 = sc.nextInt() - 1;
        //실제 메뉴와 Println에 나와있는 번호의 차이가 있기 때문에 -1을 적었다

        if (Changefood < 0 || Changefood > 2 || Changefood2 < 0 || Changefood2 > 2) {
            System.out.println("잘못된 입력입니다");
            Foodexchange();
        } else {
            if (TotalFoodarr[Changefood][1] == 0) {
                //선택한 번호의 음식을 구매한 이력이 없는경우
                System.out.println("수량을 다시 확인해주세요");
                System.out.println("안내 : 현재 구매한 음식의 개수 \n1.장어덮밥 : " + TotalFoodarr[0][1] + "개 \n2.옥수수콘 : " + TotalFoodarr[1][1] + "개 \n3.감자튀김 : " + TotalFoodarr[2][1] + "개");
            } else {
                TotalFoodarr[Changefood][1] -= 1;//교환하므로 수량감소
                TotalFoodarr[Changefood2][1] += 1;//교환하므로 수량증가
                Foodpricedifference += (TotalFoodarr[Changefood][0] - TotalFoodarr[Changefood2][0]);
                //교환한 음식의 가격차이를 확인하여 음수가나온경우 돈을 지불하고 양수가나온경우 추가로 돈을 받는다

                if (Foodpricedifference < 0) {
                    Totalamount -= ((TotalFoodarr[Changefood][0] - TotalFoodarr[Changefood2][0]));//교환하지만 추가적으로 돈을 더 내야하는상황
                    System.out.println("교환이 완료되었습니다 " + ((TotalFoodarr[Changefood][0] - TotalFoodarr[Changefood2][0]) * -1) + "원을 추가로 지불했습니다");
                } else {
                    Totalamount += ((TotalFoodarr[Changefood][0] - TotalFoodarr[Changefood2][0]));//교환하지만 값이 싼음식으로 바꿧으므로 추가적으로 돈을 받음
                    System.out.println("교환이 완료되었습니다 " + (TotalFoodarr[Changefood][0] - TotalFoodarr[Changefood2][0]) + "원을 추가로 받았습니다");
                }
            }
            Restaurantmenu();
        }
    }
    void Refundmenu () {
        Scanner sc = new Scanner(System.in);
        System.out.println("환불 할 음식의 번호를 적어주세요 \n1.장어덮밥  \n2.옥수수콘  \n3.감자튀김");
        int Refundfoodnumber = sc.nextInt();

        switch (Refundfoodnumber) {
            case 1 :
                Refundsuccess("장어덮밥",1);
            case 2 :
                Refundsuccess("옥수수콘",2);
            case 3 :
                Refundsuccess("감자튀김",3);
            default :
                System.out.println("잘못된 입력입니다");
                Refundmenu();
        }
    }
    void Refundsuccess (String Food,int Receiveindexnumber) {
        if (TotalFoodarr[Receiveindexnumber - 1][1] >= 1) {
            Totalamount += TotalFoodarr[Receiveindexnumber - 1][0]; //음식의 가격만큼 전체 가진돈에 추가시킴
            TotalFoodarr[Receiveindexnumber - 1][1] -= 1; //환불하였으므로 개수 차감
            System.out.println("" + Food + "환불이 완료되었습니다");
        } else {
            System.out.println("구매한 내역이 없습니다");
        }
        Restaurantmenu();
    }
    void Gameover () {
        System.out.println("기회를 모두 사용하였으므로 프로그램을 종료합니다");
        System.exit(0);
    }
}
