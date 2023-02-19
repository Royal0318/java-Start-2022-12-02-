import java.util.Scanner;

public class forwhile40 {
    int[][] Deftmoney;
    //각 손님이 가지고있는 빚 저장배열
    int[][] Foodbuynumber;
    /*
        구매한 음식의 개수를저장한다 총 5개의 index이므로
        index[0] = 과자
        index[1] = 빵
        index[2] = 음료수
        index[3] = 과일
        index[4] = 술
        */
    int[] Totalmoney;
    //총 15명이 가지고 있는 돈의 총 합
    //5명은 20000원 고장 5명은 10000원 고정 나머지는 println으로 받는다
    int[] Borrowmoney;
    //빌려준 금액을 저장하는 변수
    int[] Initialcapital;
    //초기에 각 손님들의 돈을 저장하는 배열
    int[] Paybacksum;
    //각 손님이 전체적으로 갚은 금액의 합
    int[] Deftmoneysum;
    //각손님이 가지고 있는 빚의 총액
    int i;
    //전체적인 for문의 index역할
    int Controlindexsave;
    //제어를 사용할때 가장 마지막이였던 손님의 index번호를 저장해 이전손님으로 돌아갈때 사용
    int Controlonoffcheck;
    //제어의 on off유무를 판단 0이면 제어를 사용하지 않은상태이며 1인경우 제어를 사용하고 있는 상태이다

    forwhile40 () {

    }
    forwhile40 (int[] Totalmoney,int[][] Foodbuynumber,int[][] Deftmoney,int[] Borrowmoney,int i,int[] Initialcapital,int[] Paybacksum,int[] Deftmoneysum,int Controlindexsave,int Controlonoffcheck) {
        this.Totalmoney  = Totalmoney;
        this.Foodbuynumber = Foodbuynumber;
        this.Deftmoney = Deftmoney;
        this.Borrowmoney = Borrowmoney;
        this.i = i;
        this.Initialcapital = Initialcapital;
        this.Paybacksum = Paybacksum;
        this.Deftmoneysum = Deftmoneysum;
        this.Controlindexsave = Controlindexsave;
        this.Controlonoffcheck = Controlonoffcheck;
    }
    void Therestmoneyinput () {
        Scanner sc = new Scanner(System.in);
        //10번째부터 15번째 사람의 돈을 입력받음
        for (int i = 10; i < 15; i++) {
            System.out.println(""+(i + 1)+"번째 사람의 돈을 입력해주세요");
            Totalmoney[i] = sc.nextInt();

            if (Totalmoney[i] < 0) {
                System.out.println("다시 입력해주세요");
                i--;
            }
        }
        System.out.println("<<<모든 사람의 돈이 입력되었습니다>>>");
        for (int i = 0; i < 15; i++) {
            Initialcapital[i] += Totalmoney[i];
        }
    }
    void Selectmenu () {
        int Additionalindex = 1; //돈을 추가적으로 빌릴때 i값은 고정된상태로 Add변수만 증가하여 다음사람에게 계속 빌릴수 있도록 도와주는 보조변수
        Scanner sc = new Scanner(System.in);
        //모든 손님이 물건을 골랐을때 종료조건이 되므로 시스템 종료직전 for문으로 모든 손님의 돈을 index0에 저장함으로 써 프로그램을 종료시킨다
        if (i == 14) {
            for (int i = 0; i < 15; i++) {
                Totalmoney[0] += Totalmoney[i];
            }
            System.out.println("시스템을 종료합니다 모든 손님들의 남은 돈은 " + Totalmoney[0] + "원 입니다");
            System.exit(0);
        }
            System.out.println(""+(i + 1)+"번째 선택 남은잔액 : "+Totalmoney[i]+"원");
            if (Controlonoffcheck == 0) {
                System.out.println("1.과자[1200원] 2.빵[1000원] 3.음료수[1500원] 4.과일[2500원] 5.술[8000원] 6.다음손님 7.환불 8.시스템 종료 9.돈갚기 10.제어");
            } else {
                System.out.println("1.과자[1200원] 2.빵[1000원] 3.음료수[1500원] 4.과일[2500원] 5.술[8000원] 6.다음손님 7.환불 8.시스템 종료 9.돈갚기 10.제어 11.이전 손님으로 돌아가기");
            }
            int Foodmenuchoice = sc.nextInt();

            switch (Foodmenuchoice) {
                /*
                각각의 음식을 주문했을경우에 for문의 i값과 가격그리고 음식의 정해진index 넘버를 리턴시킨다
                 */
                case 1 :
                    Numberfoodpurchases(1200,0,Additionalindex);
                case 2 :
                    Numberfoodpurchases(1000,1,Additionalindex);
                case 3 :
                    Numberfoodpurchases(1500,2,Additionalindex);
                case 4 :
                    Numberfoodpurchases(2500,3,Additionalindex);
                case 5 :
                    Numberfoodpurchases(8000,4,Additionalindex);
                case 6 :
                    if (Controlonoffcheck == 1) {
                        System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
                        Selectmenu();
                    } else {
                        Nextpeople();
                    }
                case 7 :
                    Refundmenu();
                case 8 :
                    System.out.println("시스템을 종료합니다");
                    System.exit(0);
                case 9 :
                    Paybackpeoplechoice();
                case 10 :
                    Peoplecontrol();
                case 11 :
                    if (Controlonoffcheck == 1) {
                        //제어상태가 on인경우
                        i = Controlindexsave; //저장했던 원래의 순서로 돌아간다
                        Controlindexsave = 0; //save값 0으로 초기화
                        Controlonoffcheck = 0; //제어상태 off로 전환
                        Selectmenu();
                    }
                    else {
                        //제어상태가 off인경우
                        System.out.println("잘못된 입력입니다");
                        Selectmenu();
                    }
                default:
                    System.out.println("잘못된 입력입니다");
                    Selectmenu();
            }
    }
    void Numberfoodpurchases (int Foodprice,int Buyfoodindexnumber,int Additionalindex) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇개를 구매하시겠습니까?");
        int Buyfoodnumber = sc.nextInt();

        if (Totalmoney[i] < (Foodprice * Buyfoodnumber)) {
            //돈이 부족한경우 돈을 빌리는 메소드로 리턴
            Borrowmoneyaskmenu(Buyfoodnumber,Foodprice,Additionalindex);
        } else {
            //주문이 성공적으로 된 경우 Foodordercomplete메소드로 리턴
            Foodordercomplete(Buyfoodindexnumber,Buyfoodnumber,Foodprice);
        }
    }
    void Borrowmoneyaskmenu (int Buyfoodnumber,int Foodprice,int Additionalindex) {
        //돈을 빌리는지 안빌리는지 질문여부를 묻는 메소드
        Scanner sc = new Scanner(System.in);
        //돈이 부족할때 돈을 빌리는 메소드
        Totalmoney[i] -= (Foodprice * Buyfoodnumber);
        System.out.println("돈이 "+(Totalmoney[i] * -1)+"원 부족합니다 추가로 빌리시겠습니까?  1.Yes 2.No");
        int Borrowmenuchoice = sc.nextInt();

        if (Borrowmenuchoice == 1) {
            //추기적으로 돈을 빌리는경우 빌리는 돈의 액수를 입력받는 메소드로 리턴시킨다
            Borrowmoneyinput(Buyfoodnumber,Additionalindex,Buyfoodnumber,Foodprice);
        } else if (Borrowmenuchoice == 2) {
            Totalmoney[i] += (Foodprice * Buyfoodnumber);
            //돈을 빌리지 않는경우에는 미리 계산된 값을 반환하며 다시 고를수 있도록 메인메뉴로 리턴됩니다
        } else {
            Totalmoney[i] += (Foodprice * Buyfoodnumber);
            //돈을 빌리는메소드로 넘어왔을때 미리 계산이 되었기 때문에 다시선택은 재반환 필요
            System.out.println("잘못된 입력입니다");
        }
        Selectmenu();
    }
    void Borrowmoneyinput (int Buyfoodindexnumber,int Additionalindex,int Buyfoodnumber,int Foodprice) {
        Scanner sc = new Scanner(System.in);
        //돈을 빌리는경우
        System.out.println("얼마를 빌리시겠습니까?");
        int Borrowmoneyinput = sc.nextInt();
        Totalmoney[i] += Borrowmoneyinput;
        //빌린돈을 i번째 사람의 전체 돈에 누적

        if (Totalmoney[i] < 0 && Totalmoney[i + Additionalindex] > Borrowmoneyinput) {
            System.out.println(""+(Totalmoney[i] * -1)+"원이 부족합니다 돈을 더 빌리세요");
            Totalmoney[i] -= Borrowmoneyinput;
            //돈을 빌려도 i번째 사람이 가지고있는 전체 돈이 음수인경우 이경우 추가적으로 빌려야한다
        }
        else if (Totalmoney[i] >= 0 && Totalmoney[i + Additionalindex] < Borrowmoneyinput) {
            System.out.println("다음사람이 가지고 있는 돈보다 초과하여 빌릴 수 없습니다");
            Totalmoney[i] -= Borrowmoneyinput;
            //돈을 빌리지만 다음사람이 가지고 있는 돈보다 더 많이 빌리는경우
        }
        else if (Totalmoney[i] >= 0 && Totalmoney[i + Additionalindex] > Borrowmoneyinput) {
            Deftmoney[i][i + Additionalindex] += Borrowmoneyinput;
            //각 손님에게 빌린 돈을 저장하는 배열
            Borrowmoney[i + Additionalindex] += Borrowmoneyinput;
            //어떤 손님에게 돈을 빌려줬는지 저장하는 배열
            Totalmoney[i + Additionalindex] -= Borrowmoneyinput;
            //돈을 빌려준 사람의 전체 금액에서 돈을 빌려준만큼 차감
            Deftmoneysum[i] += Borrowmoneyinput;
            //돈을 빌린사람의 전체적인 빚
            System.out.println("돈을 빌렸습니다 추가적으로 빌리시겠습니까? 1.Yes 2.No");
            int AddBorrowchoice = sc.nextInt();

            if (AddBorrowchoice == 1) {
                Additionalindex += 1;
            } else {
                Foodordercomplete(Buyfoodindexnumber,Buyfoodnumber,Foodprice);
            }
        }
        Borrowmoneyinput(Buyfoodindexnumber,Additionalindex,Buyfoodnumber,Foodprice);
    }
    void Foodordercomplete (int Buyfoodindexnumber,int Buyfoodnumber,int Foodprice) {
        //주문을 완료한경우 주문한 음식의 개수가 증가하며 메뉴로 다시 리턴된다
        Foodbuynumber[i][Buyfoodindexnumber] += 1; //i번째 사람이 구매한 음식의 개수를 1개 저장한다
        Totalmoney[i] -= (Buyfoodnumber * Foodprice);
        System.out.println("주문이 성공적으로 완료되었습니다");
        Selectmenu();
    }
    void Refundmenu () {
        Scanner sc = new Scanner(System.in);
        System.out.println("어떤 음식을 환불하시겠습니까?");
        System.out.println("1.과자 : "+Foodbuynumber[i][0]+"개 \n2.빵 : "+Foodbuynumber[i][1]+"개 \n3.음료수 : "+Foodbuynumber[i][2]+"개 \n4.과일 : "+Foodbuynumber[i][3]+"개 \n5.술 : "+Foodbuynumber[i][4]+"개");
        int Refundlistchoice = sc.nextInt();

        switch (Refundlistchoice) {
            case 1 :
                Refundcomplete (0,1200);
            case 2 :
                Refundcomplete (1,1000);
            case 3 :
                Refundcomplete (2,1500);
            case 4 :
                Refundcomplete (3,2500);
            case 5 :
                Refundcomplete (4,8000);
            default:
                System.out.println("잘못된 입력입니다");
                Refundmenu();
        }
    }
    void Nextpeople () {
        int Outputorder = 0;
        //다음손님으로 넘어가기전 물건을 구매한 손님들의 영수증 내역을 모두 출력한다
        for (int j = 0; j < 15;j++) {
            if (Foodbuynumber[j][0] == 0 && Foodbuynumber[j][1] == 0 && Foodbuynumber[j][2] == 0 && Foodbuynumber[j][3] == 0 && Foodbuynumber[j][4] == 0) {
                continue;
                /*각 손님이 아무것도 사지 않고 다음손님을 눌렀을경우 번호는 1번부터 순서대로 출력되어야하므로 continue문을 사용하였으며 else값으로 물건을 1개라도 주문한사람은
                Outputorder변수를 통해 순서대로 출력되도록 만들었다
                 */
            } else {
                Outputorder += 1;
            }
            System.out.println("==================="+Outputorder+"번째 손님의 주문표===================");
            if (Foodbuynumber[j][0] >= 1) { //과자를 구매한 개수가 1개이상일경우 출력
                System.out.println("과자 X "+Foodbuynumber[j][0]+"개 = "+(Foodbuynumber[j][0] * 1200)+"원");
            }
            if (Foodbuynumber[j][1] >= 1) { //빵을 구매한 개수가 1개이상일경우 출력
                System.out.println("빵 X "+Foodbuynumber[j][1]+"개 = "+(Foodbuynumber[j][1] * 1000)+"원");
            }
            if (Foodbuynumber[j][2] >= 1) { //음료수를 구매한 개수가 1개이상일경우 출력
                System.out.println("음료수 X "+Foodbuynumber[j][2]+"개 = "+(Foodbuynumber[j][2] * 1500)+"원");
            }
            if (Foodbuynumber[j][3] >= 1) { //과일을 구매한 개수가 1개이상일경우 출력
                System.out.println("과일 X "+Foodbuynumber[j][3]+"개 = "+(Foodbuynumber[j][3] * 2500)+"원");
            }
            if (Foodbuynumber[j][4] >= 1) { //술을 구매한 개수가 1개이상일경우 출력
                System.out.println("과일 X "+Foodbuynumber[j][4]+"개 = "+(Foodbuynumber[j][4] * 4000)+"원");
            }
            System.out.println("===============================================================");
            System.out.println("처음에 가지고 있던 금액 : "+Initialcapital[j]+"원");
            System.out.println("현재 가지고 있는 금액 : "+Totalmoney[j]+"원");
            System.out.println("전체 빚 진 금액 : "+ Deftmoneysum[j]+"원");
            System.out.println("빚을 청산하고 남은 금액 : "+(Deftmoneysum[j] -Paybacksum[j])+"원");
            System.out.println("미납 된 금액 : "+(Deftmoneysum[j] -Paybacksum[j])+"원");
            System.out.println("빌려준 금액 : "+Borrowmoney[j]+"원\n");
        }
        i += 1; //해당 손님의 선택이 모두 끝나고 다음손님으로 넘어가기 위해 += 1을 부여
        Selectmenu(); //전체적인 출력이끝나면 메인메뉴로 돌아간다
    }
    void Refundcomplete (int Foodindexnumber,int Foodprice) {
        if (Foodbuynumber[i][Foodindexnumber] == 0) {
            System.out.println("수량을 다시 확인해주세요");
            Refundmenu();
        } else {
            Foodbuynumber[i][Foodindexnumber] -= 1; //환불을 완료했으므로 해당 음식의 개수는 차감
            Totalmoney[i] += Foodprice; //환불하였으므로 음식가격을 전체가격에 누적시킨다
            System.out.println(""+Foodprice+"원을 돌려받았으며 환불이 완료되었습니다");
            Selectmenu();
        }
    }
    void Paybackpeoplechoice () {
        //돈을 갚는사람을 입력하고 그 값을 Paybackmoneyinputmenu에 리턴시킨다 몰아넣기보다 분할해서 넣는것이 코드를 읽는 입장에선 편하다고 판단
        Scanner sc = new Scanner(System.in);
        System.out.println("몇번째 손님에게 갚겠습니까?");
        int Paybackpeople = sc.nextInt() - 1;

        if (Deftmoney[i][Paybackpeople] == 0) {
            System.out.println("돈을 빌린 내역이 없습니다");
        } else {
            Paybackmoneyinputmenu(Paybackpeople);
        }
    }
    void Paybackmoneyinputmenu (int Paybackpeople) {
        Scanner sc = new Scanner(System.in);
        System.out.println("얼마를 갚겠습니까?");
        int Moneyinput = sc.nextInt();

        if (Deftmoney[i][Paybackpeople] >= Moneyinput) {
            //빚진 금액보다 클 수 없으므로 같거나 적어야한다
            Deftmoney[i][Paybackpeople] -= Moneyinput;
            Borrowmoney[Paybackpeople] -= Moneyinput;
            Paybacksum[i] += Moneyinput;
            System.out.println(""+Moneyinput+"원을 정상적으로 갚았습니다 남은 빚 : "+Deftmoney[i][Paybackpeople]+"원");
            Selectmenu();
        } else {
            System.out.println("빌린 금액을 정확히 확인해주세요");
            Paybackmoneyinputmenu(Paybackpeople);
        }
    }
    void Peoplecontrol () {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇번째 손님을 제어하시겠습니까?");
        int Controlpeople = sc.nextInt() - 1;
        Controlindexsave += i; //i값을 변경하기 전에 그 전 순서를 미리 저장하여 되돌아갈때 사용하기 위함
        i = Controlpeople;//해당손님으로 이동하기 위하여 i값을 변경
        Controlonoffcheck = 1; //제어가 켜져있는 상태 on
        Selectmenu();
    }
}
