import java.util.Scanner;

public class forwhile40 {
    int[] Totalmoney;
    //총 15명이 가지고 있는 돈의 총 합
    int[][] Deftmoney;
    int[][] Foodbuynumber;
    /*구매한 음식의 개수를저장한다 총 5개의 index이므로
    index[0] = 과자
    index[1] = 빵
    index[2] = 음료수
    index[3] = 과일
    index[4] = 술
     */
    int[][] Borrowmoney;
    int Icontrol;

    forwhile40 () {

    }
    forwhile40 (int[] Totalmoney,int[][] Foodbuynumber,int[][] Deftmoney,int[][] Borrowmoney,int Icontrol) {
        this.Totalmoney  = Totalmoney;
        this.Foodbuynumber = Foodbuynumber;
        this.Deftmoney = Deftmoney;
        this.Borrowmoney = Borrowmoney;
        this.Icontrol = Icontrol;
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
        Selectmenu();
    }
    void Selectmenu () {
        Scanner sc = new Scanner(System.in);
        int Additionalindex = 1; //돈을 추가적으로 빌릴때 i값은 고정된상태로 Add변수만 증가하여 다음사람에게 계속 빌릴수 있도록 도와주는 보조변수
        //메인 선택메뉴
        for (int i = 0; i < 15; i = Icontrol) {
            //제어를 위해서 Icontrol이 i값을 대신한다
            System.out.println(""+(i + 1)+"번째 선택 남은잔액 : "+Totalmoney[i]+"원");
            System.out.println("1.과자[1200원] 2.빵[1000원] 3.음료수[1500원] 4.과일[2500원] 5.술[8000원] 6.다음손님 7.환불 8.시스템 종료 9.돈갚기 10.제어");
            int Foodmenuchoice = sc.nextInt();

            switch (Foodmenuchoice) {
                /*
                각각의 음식을 주문했을경우에 for문의 i값과 가격그리고 음식의 정해진index 넘버를 리턴시킨다
                 */
                case 1 :
                    Numberfoodpurchases(1200,i,0,Additionalindex);
                case 2 :
                    Numberfoodpurchases(1000,i,1,Additionalindex);
                case 3 :
                    Numberfoodpurchases(1500,i,2,Additionalindex);
                case 4 :
                    Numberfoodpurchases(2500,i,3,Additionalindex);
                case 5 :
                    Numberfoodpurchases(8000,i,4,Additionalindex);
                case 6 :

                case 7 :
                    Refundmenu(i);
                case 8 :
                    System.out.println("시스템을 종료합니다");
                    System.exit(0);
                case 9 :
                    Paybackpeoplechoice(i);
                case 10 :

                case 11 :

                default:
                    System.out.println("잘못된 입력입니다");
            }
            Selectmenu();
        }
    }
    void Numberfoodpurchases (int Foodprice,int i,int Buyfoodindexnumber,int Additionalindex) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇개를 구매하시겠습니까?");
        int Buyfoodnumber = sc.nextInt();

        if (Totalmoney[i] < (Foodprice * Buyfoodnumber)) {
            //돈이 부족한경우 돈을 빌리는 메소드로 리턴
            Borrowmoneyaskmenu(i,Buyfoodnumber,Foodprice,Additionalindex);
        } else {
            //주문이 성공적으로 된 경우 Foodordercomplete메소드로 리턴
            Foodordercomplete(i,Buyfoodindexnumber);
        }
    }
    void Borrowmoneyaskmenu (int i,int Buyfoodnumber,int Foodprice,int Additionalindex) {
        //돈을 빌리는지 안빌리는지 질문여부를 묻는 메소드
        Scanner sc = new Scanner(System.in);
        //돈이 부족할때 돈을 빌리는 메소드
        Totalmoney[i] -= (Foodprice * Buyfoodnumber);
        System.out.println("돈이 "+(Totalmoney[i] * -1)+"원 부족합니다 추가로 빌리시겠습니까?  1.Yes 2.No");
        int Borrowmenuchoice = sc.nextInt();

        if (Borrowmenuchoice == 1) {
            //추기적으로 돈을 빌리는경우 빌리는 돈의 액수를 입력받는 메소드로 리턴시킨다
            Borrowmoneyinput(i,Buyfoodnumber,Additionalindex);
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
    void Borrowmoneyinput (int i,int Buyfoodindexnumber,int Additionalindex) {
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
            Borrowmoney[i + Additionalindex][i] += Borrowmoneyinput;
            Totalmoney[i + Additionalindex] -= Borrowmoneyinput;
            System.out.println("돈을 빌렸습니다 추가적으로 빌리시겠습니까? 1.Yes 2.No");
            int AddBorrowchoice = sc.nextInt();

            if (AddBorrowchoice == 1) {
                Additionalindex += 1;
            } else {
                Foodordercomplete(i,Buyfoodindexnumber);
            }
        }
        Borrowmoneyinput(i,Buyfoodindexnumber,Additionalindex);
    }
    void Foodordercomplete (int i,int Buyfoodindexnumber) {
        //주문을 완료한경우 주문한 음식의 개수가 증가하며 메뉴로 다시 리턴된다
        Foodbuynumber[i][Buyfoodindexnumber] += 1; //i번째 사람이 구매한 음식의 개수를 1개 저장한다
        System.out.println("주문이 성공적으로 완료되었습니다");
        Selectmenu();
    }
    void Refundmenu (int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("어떤 음식을 환불하시겠습니까?");
        System.out.println("1.과자 : "+Foodbuynumber[i][0]+"개 \n2.빵 : "+Foodbuynumber[i][1]+"개 \n3.음료수 : "+Foodbuynumber[i][2]+"개 \n4.과일 : "+Foodbuynumber[i][3]+"개 \n5.술 : "+Foodbuynumber[i][4]+"개");
        int Refundlistchoice = sc.nextInt();

        switch (Refundlistchoice) {
            case 1 :
                Refundcomplete (i,0,1200);
            case 2 :
                Refundcomplete (i,1,1000);
            case 3 :
                Refundcomplete (i,2,1500);
            case 4 :
                Refundcomplete (i,3,2500);
            case 5 :
                Refundcomplete (i,4,8000);
            default:
                System.out.println("잘못된 입력입니다");
                Refundmenu(i);
        }
    }
    void Refundcomplete (int i,int Foodindexnumber,int Foodprice) {
        if (Foodbuynumber[i][Foodindexnumber] == 0) {
            System.out.println("수량을 다시 확인해주세요");
            Refundmenu(i);
        } else {
            Foodbuynumber[i][Foodindexnumber] -= 1; //환불을 완료했으므로 해당 음식의 개수는 차감
            Totalmoney[i] += Foodprice; //환불하였으므로 음식가격을 전체가격에 누적시킨다
            System.out.println(""+Foodprice+"원을 돌려받았으며 환불이 완료되었습니다");
            Selectmenu();
        }
    }
    void Paybackpeoplechoice (int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇번째 손님에게 갚겠습니까?");
        int Paybackpeople = sc.nextInt() - 1;

        if (Deftmoney[i][Paybackpeople] == 0) {
            System.out.println("돈을 빌린 내역이 없습니다");
        } else {
            Paybackmoneyinputmenu(Paybackpeople,i);
        }
    }
    void Paybackmoneyinputmenu (int Paybackpeople,int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("얼마를 갚겠습니까?");
        int Moneyinput = sc.nextInt();

        if (Deftmoney[i][Paybackpeople] >= Moneyinput) {
            //빚진 금액보다 클 수 없으므로 같거나 적어야한다
            Deftmoney[i][Paybackpeople] -= Moneyinput;
            System.out.println(""+Moneyinput+"원을 정상적으로 갚았습니다 남은 빚 : "+Deftmoney[i][Paybackpeople]+"원");
        }
    }
}
