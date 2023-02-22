import java.util.Scanner;

public class forwhile40 {
    int[][] debtMoneyrecords;
    //각 손님이 가지고있는 빚 저장배열
    int[][] foodBuyNumber;
    /*
        구매한 음식의 개수를저장한다 총 5개의 index이므로
        index[0] = 과자
        index[1] = 빵
        index[2] = 음료수
        index[3] = 과일
        index[4] = 술
        */
    int[] personalMoney;
    //총 15명이 가지고 있는 돈의 총 합
    //5명은 20000원 고장 5명은 10000원 고정 나머지는 println으로 받는다
    int[] personalBorrowMoney;
    //빌려준 금액을 저장하는 변수
    int[] initialCapital;
    //초기에 각 손님들의 돈을 저장하는 배열
    int[] personalPaybackMoney;
    //각 손님이 전체적으로 갚은 금액의 합
    int[] personalDebt;
    //각손님이 가지고 있는 빚의 총액
    int i;
    //전체적인 for문의 index역할
    int controlIndexSave;
    //제어를 사용할때 가장 마지막이였던 손님의 index번호를 저장해 이전손님으로 돌아갈때 사용
    int controlOnOffCheck;
    //제어의 on off유무를 판단 0이면 제어를 사용하지 않은상태이며 1인경우 제어를 사용하고 있는 상태이다
    int additionalIndex;
    //돈을 추가적으로 빌릴때 i값은 고정된상태로 Add변수만 증가하여 다음사람에게 계속 빌릴수 있도록 도와주는 보조변수

    forwhile40 () {

    }
    forwhile40 (int[] personalMoney,int[][] foodBuyNumber,int[][] debtMoneyrecords,int[] personalBorrowMoney,int i,int[] initialCapital,int[] personalPaybackMoney,int[] personalDebt,int controlIndexSave,int controlOnOffCheck,int additionalIndex) {
        this.personalMoney  = personalMoney;
        this.foodBuyNumber = foodBuyNumber;
        this.debtMoneyrecords = debtMoneyrecords;
        this.personalBorrowMoney = personalBorrowMoney;
        this.i = i;
        this.initialCapital = initialCapital;
        this.personalPaybackMoney = personalPaybackMoney;
        this.personalDebt = personalDebt;
        this.controlIndexSave = controlIndexSave;
        this.controlOnOffCheck = controlOnOffCheck;
        this.additionalIndex = additionalIndex;
    }
    void therestMoneyInput (Scanner sc) {
        //10번째부터 15번째 사람의 돈을 입력받음
        for (int i = 10; i < 15; i++) {
            System.out.println(""+(i + 1)+"번째 사람의 돈을 입력해주세요");
            personalMoney[i] = sc.nextInt();

            if (personalMoney[i] < 0) {
                System.out.println("다시 입력해주세요");
                i--;
            }
        }
        System.out.println("<<<모든 사람의 돈이 입력되었습니다>>>");
        for (int i = 0; i < 15; i++) {
            initialCapital[i] += personalMoney[i];
        }
    }
    void selectMenu (Scanner sc) {
        //모든 손님이 물건을 골랐을때 종료조건이 되므로 시스템 종료직전 for문으로 모든 손님의 돈을 index0에 저장함으로 써 프로그램을 종료시킨다
            System.out.println(""+(i + 1)+"번째 선택 남은잔액 : "+personalMoney[i]+"원");
            if (controlOnOffCheck == 0) {
                System.out.println("1.과자[1200원] 2.빵[1000원] 3.음료수[1500원] 4.과일[2500원] 5.술[8000원] 6.다음손님 7.환불 8.시스템 종료 9.돈갚기 10.제어");
            } else {
                System.out.println("1.과자[1200원] 2.빵[1000원] 3.음료수[1500원] 4.과일[2500원] 5.술[8000원] 6.다음손님 7.환불 8.시스템 종료 9.돈갚기 10.제어 11.이전 손님으로 돌아가기");
            }
            int foodMenuChoice = sc.nextInt();

            switch (foodMenuChoice) {
                /*
                각각의 음식을 주문했을경우에 음식의가격과 음식의 고유 indx번호 그리고 돈을 계속빌릴경우
                손님의 index는 고정되고 빌려주는 사람은 1씩 추가되어야하므로 Additionalindex를 사용하였다
                 */
                case 1 :
                    numberFoodPurchases(1200,0,sc);
                    break;
                case 2 :
                    numberFoodPurchases(1000,1,sc);
                    break;
                case 3 :
                    numberFoodPurchases(1500,2,sc);
                    break;
                case 4 :
                    numberFoodPurchases(2500,3,sc);
                    break;
                case 5 :
                    numberFoodPurchases(8000,4,sc);
                    break;
                case 6 :
                    nextPeople(sc);
                    break;
                case 7 :
                    refundMenu(sc);
                    break;
                case 8 :
                    System.out.println("시스템을 종료합니다");
                    System.exit(0);
                    break;
                case 9 :
                    paybackPeopleChoice(sc);
                    break;
                case 10 :
                    peopleControl(sc);
                    break;
                case 11 :
                    returnSequence(sc);
                    break;
                default:
                    System.out.println("잘못된 입력입니다");
                    selectMenu(sc);
                    break;
            }
    }
    void numberFoodPurchases (int foodPrice,int buyFoodIndexNumber,Scanner sc) {
        System.out.println("몇개를 구매하시겠습니까?");
        int buyFoodNumber = sc.nextInt();

        if (personalMoney[i] < (foodPrice * buyFoodNumber)) {
            //돈이 부족한경우 돈을 빌리는 메소드로 리턴
            borrowMoneyAskMenu(foodPrice,buyFoodNumber,sc,buyFoodIndexNumber);
        } else {
            //주문이 성공적으로 된 경우 Foodordercomplete메소드로 리턴
            personalMoney[i] -= (foodPrice * buyFoodNumber);
            foodOrderComplete(buyFoodIndexNumber,buyFoodNumber,sc);
        }
    }
    void borrowMoneyAskMenu (int foodPrice,int buyFoodNumber,Scanner sc,int buyFoodIndexNumber) {
        //돈을 빌리는지 안빌리는지 질문여부를 묻는 메소드
        personalMoney[i] -= (foodPrice * buyFoodNumber);
        //손님의 전체 돈에서 (가격 X 개수)를 미리 계산하여 돈이 부족 여부를 판단한다
        System.out.println("돈이 "+(personalMoney[i] * -1)+"원 부족합니다 추가로 빌리시겠습니까?  1.Yes 2.No");
        int borrowMenuChoice = sc.nextInt();

        if (borrowMenuChoice == 1) {
            borrowMoneyInput(sc,buyFoodIndexNumber,buyFoodNumber);
            //추기적으로 돈을 빌리는경우 빌리는 돈의 액수를 입력받는 메소드로 리턴시킨다
        } else if (borrowMenuChoice == 2) {
            personalMoney[i] += (foodPrice * buyFoodNumber);
            System.out.println("추가로 돈을 빌리지 않았으므로 메인메뉴로 돌아갑니다");
            //돈을 빌리지 않는경우에는 미리 계산된 값을 반환하며 다시 고를수 있도록 메인메뉴로 리턴됩니다
        } else {
            personalMoney[i] += (foodPrice * buyFoodNumber);
            System.out.println("잘못된 입력입니다");
            //돈을 빌리는메소드로 넘어왔을때 미리 계산이 되었기 때문에 다시선택은 재반환 필요
        }
        selectMenu(sc);
    }
    void borrowMoneyInput (Scanner sc,int buyFoodIndexNumber,int buyFoodNumber) {
        //돈을 빌리는경우
        System.out.println("얼마를 빌리시겠습니까?");
        int borrowMoneyInput = sc.nextInt();
        personalMoney[i] += borrowMoneyInput;
        //빌린돈을 i번째 사람의 전체 돈에 누적시켜 부족여부를 판단

        if (personalMoney[i] >= 0 && personalMoney[i + additionalIndex] < borrowMoneyInput) {
            borrowSystemcheck(sc,buyFoodIndexNumber,buyFoodNumber,borrowMoneyInput,1);
            //돈을 빌리지만 다음사람이 가지고 있는 돈보다 더 많이 빌리는경우
        }
        if (personalMoney[i] < 0 && personalMoney[i + additionalIndex] > borrowMoneyInput) {
            borrowSystemcheck(sc,buyFoodIndexNumber,buyFoodNumber,borrowMoneyInput,2);
        }
        if (personalMoney[i] >= 0 && personalMoney[i + additionalIndex] > borrowMoneyInput) {
            borrowSystemcheck(sc,buyFoodIndexNumber,buyFoodNumber,borrowMoneyInput,3);
        }
    }
    void borrowSystemcheck (Scanner sc,int buyFoodIndexNumber,int buyFoodNumber,int borrowMoneyInput,int borrowSystemindex) {
        debtMoneyrecords[i][i + additionalIndex] += borrowMoneyInput;
        //각 손님에게 빌린 돈을 저장하는 배열
        personalBorrowMoney[i + additionalIndex] += borrowMoneyInput;
        //몇번째 사람이 전체적으로 얼마를 빌려줬는지 누적받는 배열값
        personalMoney[i + additionalIndex] -= borrowMoneyInput;
        //돈을 빌려준 사람의 전체 금액에서 돈을 빌려준만큼 차감
        personalDebt[i] += borrowMoneyInput;
        //돈을 빌린사람의 전체적인 빚

        if (borrowSystemindex == 1) {
            System.out.println("다음사람이 가지고 있는 돈보다 초과하여 빌릴 수 없습니다");
            personalMoney[i] -= borrowMoneyInput;
            debtMoneyrecords[i][i + additionalIndex] -= borrowMoneyInput;
            personalBorrowMoney[i + additionalIndex] -= borrowMoneyInput;
            personalMoney[i + additionalIndex] += borrowMoneyInput;
            personalDebt[i] -= borrowMoneyInput;
            borrowMoneyInput(sc,buyFoodIndexNumber,buyFoodNumber);
        }
        else if (borrowSystemindex == 2) {
            System.out.println(""+(personalMoney[i] * -1)+"원이 부족합니다 돈을 더 빌리세요");
            additionalIndex += 1;
        }
        else {
            System.out.println(""+borrowMoneyInput+"원을 빌려 총 "+personalMoney[i]+"원이 되었습니다 추가적으로 빌리시겠습니까? 1.Yes 2.No");
            int addBorrowChoice = sc.nextInt();

            if (addBorrowChoice == 1) {
                additionalIndex += 1;
            } else {
                foodOrderComplete(buyFoodIndexNumber,buyFoodNumber,sc);
            }
        }
        borrowMoneyInput(sc,buyFoodIndexNumber,buyFoodNumber);
    }
    void foodOrderComplete (int buyFoodIndexNumber,int buyFoodNumber,Scanner sc) {
        //주문을 완료한경우 주문한 음식의 개수가 증가하며 메뉴로 다시 리턴된다
        foodBuyNumber[i][buyFoodIndexNumber] += buyFoodNumber; //i번째 사람이 구매한 음식의 개수를 1개 저장한다
        System.out.println("주문이 성공적으로 완료되었습니다");
        selectMenu(sc);
    }
    void refundMenu (Scanner sc) {
        if (foodBuyNumber[i][0] == 0 && foodBuyNumber[i][1] == 0 && foodBuyNumber[i][2] == 0 && foodBuyNumber[i][3] == 0 && foodBuyNumber[i][4] == 0) {
            System.out.println("음식을 구매한 내역이 없으므로 환불이 불가능합니다");
            selectMenu(sc);
            //5가지 음식을 1개도 구매하지 않은경우 환불이 불가능하므로 다시 메인메뉴로 리턴합니다
        }
        System.out.println("어떤 음식을 환불하시겠습니까?");
        System.out.println("1.과자 : "+foodBuyNumber[i][0]+"개 \n2.빵 : "+foodBuyNumber[i][1]+"개 \n3.음료수 : "+foodBuyNumber[i][2]+"개 \n4.과일 : "+foodBuyNumber[i][3]+"개 \n5.술 : "+foodBuyNumber[i][4]+"개");
        int refundListChoice = sc.nextInt();

        switch (refundListChoice) {
            case 1 :
                refundComplete (0,1200,sc);
                break;
            case 2 :
                refundComplete (1,1000,sc);
                break;
            case 3 :
                refundComplete (2,1500,sc);
                break;
            case 4 :
                refundComplete (3,2500,sc);
                break;
            case 5 :
                refundComplete (4,8000,sc);
                break;
            default:
                System.out.println("잘못된 입력입니다");
                refundMenu(sc);
                break;
        }
    }
    void nextPeople (Scanner sc) {
        if (controlOnOffCheck == 1) {
            //제어상태가 on인 상태에서 다음손님으로 갈 수 없으므로 다시 메인메뉴로 리턴된다 controlOnOffCheck가 0이면 off상태이므로 영수증을 정상적으로 출력
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
            selectMenu(sc);
        }
        int outputOrder = 0;
        //다음손님으로 넘어가기전 물건을 구매한 손님들의 영수증 내역을 모두 출력한다
        for (int j = 0; j < 15;j++) {
            if (foodBuyNumber[j][0] == 0 && foodBuyNumber[j][1] == 0 && foodBuyNumber[j][2] == 0 && foodBuyNumber[j][3] == 0 && foodBuyNumber[j][4] == 0) {
                continue;
                /*
                각 손님이 아무것도 사지 않고 다음손님을 눌렀을경우 번호는 1번부터 순서대로 출력되어야하므로 continue문을 사용하였으며 else값으로 물건을 1개라도 주문한사람은
                Outputorder변수를 통해 순서대로 출력되도록 만들었다
                 */
            } else {
                outputOrder += 1;
            }
            System.out.println("==================="+outputOrder+"번째 손님의 주문표===================");
            if (foodBuyNumber[j][0] >= 1) { //과자를 구매한 개수가 1개이상일경우 출력
                System.out.println("과자 X "+foodBuyNumber[j][0]+"개 = "+(foodBuyNumber[j][0] * 1200)+"원");
            }
            if (foodBuyNumber[j][1] >= 1) { //빵을 구매한 개수가 1개이상일경우 출력
                System.out.println("빵 X "+foodBuyNumber[j][1]+"개 = "+(foodBuyNumber[j][1] * 1000)+"원");
            }
            if (foodBuyNumber[j][2] >= 1) { //음료수를 구매한 개수가 1개이상일경우 출력
                System.out.println("음료수 X "+foodBuyNumber[j][2]+"개 = "+(foodBuyNumber[j][2] * 1500)+"원");
            }
            if (foodBuyNumber[j][3] >= 1) { //과일을 구매한 개수가 1개이상일경우 출력
                System.out.println("과일 X "+foodBuyNumber[j][3]+"개 = "+(foodBuyNumber[j][3] * 2500)+"원");
            }
            if (foodBuyNumber[j][4] >= 1) { //술을 구매한 개수가 1개이상일경우 출력
                System.out.println("과일 X "+foodBuyNumber[j][4]+"개 = "+(foodBuyNumber[j][4] * 4000)+"원");
            }
            System.out.println("=================================================");
            System.out.println("처음에 가지고 있던 금액 : "+initialCapital[j]+"원");
            System.out.println("현재 가지고 있는 금액 : "+personalMoney[j]+"원");
            System.out.println("전체 빚 진 금액 : "+ personalDebt[j]+"원");
            System.out.println("빚을 청산하고 남은 금액 : "+(personalDebt[j] - personalPaybackMoney[j])+"원");
            System.out.println("미납 된 금액 : "+(personalDebt[j] - personalPaybackMoney[j])+"원");
            System.out.println("빌려준 금액 : "+personalBorrowMoney[j]+"원\n");
        }
        i += 1;
        //해당 손님의 선택이 모두 끝나고 다음손님으로 넘어가기 위해 += 1을 부여
        additionalIndex = 1;
        //다음손님으로 넘기면 다시 다음사람에게 돈을 빌리도록 초기화시킨다
        shuttingSystemcheck(sc); //전체적인 출력이끝나면 메인메뉴로 돌아간다
    }
    void refundComplete (int foodIndexNumber,int foodPrice,Scanner sc) {
        if (foodBuyNumber[i][foodIndexNumber] == 0) {
            System.out.println("수량을 다시 확인해주세요");
            nextPeople(sc);
        } else {
            foodBuyNumber[i][foodIndexNumber] -= 1; //환불을 완료했으므로 해당 음식의 개수는 차감
            personalMoney[i] += foodPrice; //환불하였으므로 음식가격을 전체가격에 누적시킨다
            System.out.println(""+foodPrice+"원을 돌려받았으며 환불이 완료되었습니다");
            selectMenu(sc);
        }
    }
    void paybackPeopleChoice (Scanner sc) {
        if (personalMoney[i] == 0) {
            //돈갚기 메소드에 진입했을때 i번째 사람이 가지고 있는 돈의액수가 0원일때 돈을 갚을수 없으므로 다시 메인메뉴로 리턴된다
            System.out.println("현재 가지고 있는 돈이 없으므로 돈을 갚을 수 없습니다");
            selectMenu(sc);
        }
        //돈을 갚는사람을 입력하고 그 값을 Paybackmoneyinputmenu에 리턴시킨다 몰아넣기보다 분할해서 넣는것이 코드를 읽는 입장에선 편하다고 판단
        System.out.println("몇번째 손님에게 갚겠습니까?");
        int payBackPeople = sc.nextInt() - 1;

        if (debtMoneyrecords[i][payBackPeople] == 0 || payBackPeople == i) {
            System.out.println("돈을 빌린 내역이 없거나 자신에게 갚을 수 없습니다");
            selectMenu(sc);
        } else {
            paybackMoneyInputMenu(payBackPeople,sc);
        }
    }
    void paybackMoneyInputMenu (int payBackPeople,Scanner sc) {
        //빚을 갚는돈을 입력하는 메소드
        System.out.println("얼마를 갚겠습니까? "+(payBackPeople + 1)+"번째 사람에게 빌린 돈 : "+debtMoneyrecords[i][payBackPeople]+"원");
        int payBackMoneyInput = sc.nextInt();
        personalMoney[i] -= payBackMoneyInput;
        personalMoney[payBackPeople] += payBackMoneyInput;
        //payBackPeople번째 사람은 빌려준 금액에서 payBackMoneyInput 갚만큼 돈을 받는다

        if (debtMoneyrecords[i][payBackPeople] >= payBackMoneyInput && personalMoney[i] >= 0) {
            //돈을 빌린사람에게 갚을때 빌린돈보다 같게 갚거나 적게 갚을때 정상적으로 갚은 조건이 성립된다
            debtMoneyrecords[i][payBackPeople] -= payBackMoneyInput;
            //조건이 성립되면  debtMoneyrecords[i][payBackPeople]에 빚이 누적되어있으므로 payBackMoneyInput 갚만큼 차감해서 빚을 정산한다
            personalBorrowMoney[payBackPeople] -= payBackMoneyInput;
            //payBackPeople번째 사람은 빌려준 금액에서 payBackMoneyInput 갚만큼 차감한다
            personalPaybackMoney[i] += payBackMoneyInput;
            //i번째 사람이 갚은 돈을 기록한다 빚을 청산하고 남은 금액을 계산하기 위해서 사용함
            System.out.println(""+payBackMoneyInput+"원을 정상적으로 갚았습니다 남은 빚 : "+debtMoneyrecords[i][payBackPeople]+"원");
            selectMenu(sc);
        } else {
            personalMoney[i] += payBackMoneyInput;
            personalMoney[i + payBackPeople] -= payBackMoneyInput;
            System.out.println("빌린 금액을 정확히 확인해주세요");
            paybackMoneyInputMenu(payBackPeople,sc);
        }
    }
    void peopleControl (Scanner sc) {
        //원하는 손님으로 이동하기 위한 제어메소드
        if (i == 0) {
            //제어를 하기 위해서는 최소 2번째 손님(index 1)부터 가능하므로 index 0번은 제어가 불가 다시 메인메뉴로 리턴한다
            System.out.println("최소 2번째 손님부터 가능합니다");
        }
        if (controlOnOffCheck == 1) {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
        } else {
            System.out.println("몇번째 손님을 제어하시겠습니까?");
            int controlPeopleInput = sc.nextInt() - 1; //-1을 하는이유는 실제 손님은 index가 0에서 시작하기 때문이다
            controlIndexSave += i; //i값을 변경하기 전에 그 전 순서를 미리 저장하여 되돌아갈때 사용하기 위함
            i = controlPeopleInput;//해당손님으로 이동하기 위하여 i값을 변경
            controlOnOffCheck = 1; //제어가 켜져있는 상태 on
        }
        selectMenu(sc);
    }
    void returnSequence (Scanner sc) {
        if (controlOnOffCheck == 1) {
            //제어상태가 on인경우
            i = controlIndexSave; //저장했던 원래의 순서로 돌아간다
            controlIndexSave = 0; //save값 0으로 초기화
            controlOnOffCheck = 0; //제어상태 off로 전환
        }
        else {
            //제어상태가 off인경우
            System.out.println("잘못된 입력입니다");
        }
        selectMenu(sc);
    }
    void shuttingSystemcheck (Scanner sc) {
        if (i == 14) {
            for (int i = 0; i < 15; i++) {
                personalMoney[0] += personalMoney[i];
            }
            System.out.println("시스템을 종료합니다 모든 손님들의 남은 돈은 " + personalMoney[0] + "원 입니다");
            System.exit(0);
        } else {
            selectMenu(sc);
        }
    }
}
