import java.util.Scanner;

public class forwhile40 {
    int[][] personalDebtRecord;
    //각 손님이 가지고있는 개인 채무기록
    int[][] personalBuyFoodNumbers;
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
    int[] borrowTotalAmount;
    //nextPeople메소드에서 출력을 위한 i번째 손님의 전체 빌려준 금액
    int[] initialCapital;
    //초기에 각 손님들의 돈을 저장하는 배열
    int[] paybackTotalAmount;
    //각 손님이 전체적으로 갚은 금액의 합
    int[] DebtTotalAmount;
    //nextPeople메소드에서 출력을 위한 i번째 손님의 전체 빚 총액
    int i;
    //전체적인 손님순서를 대체
    int controlIndexSave;
    //제어를 사용할때 가장 마지막이였던 손님의 index번호를 저장해 이전손님으로 돌아갈때 사용
    int controlOnOffCheck;
    //제어의 on off유무를 판단 0이면 제어를 사용하지 않은상태이며 1인경우 제어를 사용하고 있는 상태이다
    int additionalIndex;
    //돈을 추가적으로 빌릴때 i값은 고정된상태로 Add변수만 증가하여 다음사람에게 계속 빌릴수 있도록 도와주는 보조변수

    forwhile40 () {

    }
    forwhile40 (int[] personalMoney,int[][] personalBuyFoodNumbers,int[][] personalDebtRecord,int[] borrowTotalAmount,int i,int[] initialCapital,int[] paybackTotalAmount,int[] DebtTotalAmount,int controlIndexSave,int controlOnOffCheck,int additionalIndex) {
        this.personalMoney  = personalMoney;
        this.personalBuyFoodNumbers = personalBuyFoodNumbers;
        this.personalDebtRecord = personalDebtRecord;
        this.borrowTotalAmount = borrowTotalAmount;
        this.i = i;
        this.initialCapital = initialCapital;
        this.paybackTotalAmount = paybackTotalAmount;
        this.DebtTotalAmount = DebtTotalAmount;
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
        /*
        nextPeople 메소드의 처음에 가지고 있는 값을 출력하기위해 initialCapital[i]배열에 돈을 사용전 미리 저장한다
        selectMenu메소드에서 6번 다음손님으로 넘어갈 때 처음에 가지고 있는 돈을 출력하기 위함
         */
        for (int i = 0; i < 15; i++) {
            initialCapital[i] += personalMoney[i];
        }
    }
    void selectMenu (Scanner sc) {
        //메인 선택 메뉴
            System.out.println(""+(i + 1)+"번째 선택 남은잔액 : "+personalMoney[i]+"원");
            if (controlOnOffCheck == 0) {
                //제어중인 상태가 아닌경우는 10번까지만 출력된다
                System.out.println("1.과자[1200원] 2.빵[1000원] 3.음료수[1500원] 4.과일[2500원] 5.술[8000원] 6.다음손님 7.환불 8.시스템 종료 9.돈갚기 10.제어");
            } else {
                //사람을 제어중인 상태일때는 controlOnOffCheck가 1이되며 11번 이전손님으로 돌아가기 메뉴가 추가적으로 생긴다
                System.out.println("1.과자[1200원] 2.빵[1000원] 3.음료수[1500원] 4.과일[2500원] 5.술[8000원] 6.다음손님 7.환불 8.시스템 종료 9.돈갚기 10.제어 11.이전 손님으로 돌아가기");
            }
            int foodMenuChoice = sc.nextInt();

            switch (foodMenuChoice) {
                /*
                1번부터 5번까지 음식을 주문한 경우 numberFoodPurchases(음식가격,음식index번호,Scanner sc를 리턴한다)
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
                    //다음손님으로 넘어가기
                    break;
                case 7 :
                    refundMenu(sc);
                    //환불
                    break;
                case 8 :
                    System.out.println("시스템을 종료합니다");
                    System.exit(0);
                    //모돈 사람이 음식을 구매하지 않아도 시스템을 강제종료 시킬 수있다
                    break;
                case 9 :
                    paybackPeopleChoice(sc);
                    //돈을 갚는 메소드로 이동
                    break;
                case 10 :
                    peopleControl(sc);
                    //특정 사람을 다시 되돌아와서 조종하는 메소드로 이동
                    break;
                case 11 :
                    returnSequence(sc);
                    //제어에 진입했을때 11번메뉴가 생성되며 11번을 누를시 제어컨트롤값이 0이되어 11번메뉴가 사라짐
                    break;
                default:
                    System.out.println("잘못된 입력입니다");
                    selectMenu(sc);
                    break;
            }
    }
    void numberFoodPurchases (int foodPrice,int buyFoodIndexNumber,Scanner sc) {
        //selectMenu 메뉴 메소드에서 1 ~ 5번 음식을 구매했을때 계산을 위해 수량을 입력받는 메소드
        System.out.println("몇개를 구매하시겠습니까?");
        int buyFoodNumber = sc.nextInt();

        if (personalMoney[i] >= (foodPrice * buyFoodNumber)) {
            personalMoney[i] -= (foodPrice * buyFoodNumber);
            //주문이 성공적으로 된 경우 Foodordercomplete메소드로 리턴하고 i번째 사람이 가지고 있는 돈은 (주문한 음식개수 X 가격)만큼 차감되어 계산된다
            foodOrderComplete(buyFoodIndexNumber,buyFoodNumber,sc);
        } else {
            //돈이 부족한경우 돈을 빌리는 메소드로 리턴
            borrowMoneyAskMenu(foodPrice,buyFoodNumber,sc,buyFoodIndexNumber);
        }
    }
    void borrowMoneyAskMenu (int foodPrice,int buyFoodNumber,Scanner sc,int buyFoodIndexNumber) {
        //돈이 부족하여 돈을빌려야할때 넘어오는 메소드
        personalMoney[i] -= (foodPrice * buyFoodNumber);
        //손님의 전체 돈에서 (가격 X 개수)를 미리 계산하여 돈이 부족 여부를 판단한다
        System.out.println("돈이 "+(personalMoney[i] * -1)+"원 부족합니다 추가로 빌리시겠습니까?  1.Yes 2.No");
        //음수가 나오지 않아야하는 조건이 있으므로 - 1을 곱하여 음수값을 제거
        int borrowMenuChoice = sc.nextInt();

        if (borrowMenuChoice == 1) {
            borrowMoneyInput(sc,buyFoodIndexNumber,buyFoodNumber);
            //추기적으로 돈을 빌리는경우 빌리는 돈의 액수를 입력받는 borrowMoneyInput 메소드로 리턴시킨다
        } else if (borrowMenuChoice == 2) {
            personalMoney[i] += (foodPrice * buyFoodNumber);
            System.out.println("추가로 돈을 빌리지 않았으므로 메인메뉴로 돌아갑니다");
            //돈을 빌리지 않는경우에는 미리 계산된 값을 반환하며 다시 고를수 있도록 메인메뉴로 리턴한다
        } else {
            personalMoney[i] += (foodPrice * buyFoodNumber);
            System.out.println("잘못된 입력입니다");
            //돈을 빌리는메소드로 넘어왔을때 미리 계산이 되었기 때문에 다시 반환하며 잘못입력시 다시 메인 선택메뉴로 리턴된다
        }
        selectMenu(sc);
    }
    void borrowMoneyInput (Scanner sc,int buyFoodIndexNumber,int buyFoodNumber) {
        //borrowMoneyAskMenu 메뉴에서 돈을 빌려야할때 이 메소드로 리턴된다
        System.out.println("얼마를 빌리시겠습니까?");
        int borrowMoneyInput = sc.nextInt();
        borrowResult(borrowMoneyInput,buyFoodIndexNumber,buyFoodNumber,sc);
    }
    void borrowResult (int borrowMoneyInput,int buyFoodIndexNumber,int buyFoodNumber,Scanner sc) {
        //borrowMoneyInput 메소드에서 빌리는 돈을 입력했을때 조건에 부합한지 확인하는 메소드
        if ((personalMoney[i + additionalIndex] - borrowMoneyInput) < 0) {
            //다음사람이 가지고 있는 돈보다 초과하여 빌리는경우
            System.out.println("다음사람이 가지고 있는 돈보다 초과하여 빌릴 수 없습니다 (다음 사람 잔액 : "+personalMoney[i + additionalIndex]+"원)");
        }
        if ((personalMoney[i] + borrowMoneyInput) < 0) {
            //돈을 빌렸지만 추가적으로 더 빌려야하는경우, 음수가 나오면 안되기 때문에 -1을 곱하며 더 빌리는경우 i + additionalIndex 번째 사람에게 빌리도록함
            System.out.println(""+(personalMoney[i] * -1)+"원이 부족합니다 돈을 더 빌리세요");
            additionalIndex += 1;
        }
        if ((personalMoney[i] + borrowMoneyInput) >= 0 && (personalMoney[i + additionalIndex] - borrowMoneyInput) >= 0) {
            //돈을 성공적으로 빌리는 경우
            personalMoney[i] += borrowMoneyInput;
            //빌린돈을 i번째 사람의 전체 돈에 누적시켜 부족여부를 판단
            personalMoney[i + additionalIndex] -= borrowMoneyInput;
            //돈을 빌려준 사람의 전체 금액에서 borrowMoneyInput 만큼 차감
            //borrowMoneyInput 메소드에서 빌리는 돈의 액수를 입력하면 borrowSystemcheck 메소드로 넘어와 조건만족여부를 판단
            personalDebtRecord[i][i + additionalIndex] += borrowMoneyInput;
            //각 손님에게 빌린 돈을 저장
            borrowTotalAmount[i + additionalIndex] += borrowMoneyInput;
            //(i + additionalIndex) 번째 사람이 빌려준 돈을 저장
            DebtTotalAmount[i] += borrowMoneyInput;
            //돈을 빌린사람의 전체적인 빚
            System.out.println(""+borrowMoneyInput+"원을 빌려 총 "+personalMoney[i]+"원이 되었습니다 추가적으로 빌리시겠습니까? 1.Yes 2.No");
            int addBorrowChoice = sc.nextInt();

            if (addBorrowChoice == 1) {
                additionalIndex += 1;
                borrowMoneyInput(sc,buyFoodIndexNumber,buyFoodNumber);
            } else {
                //더이상 빌리지 않는경우 주문을 완료하는 메소드로 리턴하며 다시 메인메뉴로 돌아감
                foodOrderComplete(buyFoodIndexNumber,buyFoodNumber,sc);
            }
        }
    }
    void foodOrderComplete (int buyFoodIndexNumber,int buyFoodNumber,Scanner sc) {
        //주문을 완료한경우 주문한 음식의 개수가 증가하며 메뉴로 다시 리턴된다
        personalBuyFoodNumbers[i][buyFoodIndexNumber] += buyFoodNumber;
        //i번째 사람이 buyFoodIndexNumber값의 여부에 따라 buyFoodNumber 개만큼 구매하였으므로 음식 구매 개수를 저장
        System.out.println("주문이 성공적으로 완료되었습니다");
        selectMenu(sc);
    }
    void refundMenu (Scanner sc) {
        //음식 환불 메소드
        if (personalBuyFoodNumbers[i][0] == 0 && personalBuyFoodNumbers[i][1] == 0 && personalBuyFoodNumbers[i][2] == 0 && personalBuyFoodNumbers[i][3] == 0 && personalBuyFoodNumbers[i][4] == 0) {
            System.out.println("음식을 구매한 내역이 없으므로 환불이 불가능합니다");
            selectMenu(sc);
            //5가지 음식을 1개도 구매하지 않은경우 환불이 불가능하므로 다시 메인메뉴로 리턴합니다
        }
        System.out.println("어떤 음식을 환불하시겠습니까?");
        System.out.println("1.과자 : "+personalBuyFoodNumbers[i][0]+"개 \n2.빵 : "+personalBuyFoodNumbers[i][1]+"개 \n3.음료수 : "+personalBuyFoodNumbers[i][2]+"개 \n4.과일 : "+personalBuyFoodNumbers[i][3]+"개 \n5.술 : "+personalBuyFoodNumbers[i][4]+"개");
        int refundListChoice = sc.nextInt();
        System.out.println("환불 개수를 입력해주세요");
        int refundFoodNumber = sc.nextInt();
        //환불음식과 개수를 선택후 swich문을 통해 개수와 음식의index를 리턴한다

        switch (refundListChoice) {
            case 1 :
                refundComplete (0,1200,sc,refundFoodNumber);
                break;
            case 2 :
                refundComplete (1,1000,sc,refundFoodNumber);
                break;
            case 3 :
                refundComplete (2,1500,sc,refundFoodNumber);
                break;
            case 4 :
                refundComplete (3,2500,sc,refundFoodNumber);
                break;
            case 5 :
                refundComplete (4,8000,sc,refundFoodNumber);
                break;
            default:
                System.out.println("잘못된 입력입니다");
                refundMenu(sc);
                break;
        }
    }
    void refundComplete (int foodIndexNumber,int foodPrice,Scanner sc,int refundFoodNumber) {
        //환불여부를 결정하는 메소드
        if (personalBuyFoodNumbers[i][foodIndexNumber] > refundFoodNumber) {
            //가지고 있는 음식의 개수가 환불하는 개수보다 많이 남은경우
            personalBuyFoodNumbers[i][foodIndexNumber] -= refundFoodNumber;
            //환불을 완료했으므로 해당 음식의 개수는 차감
            personalMoney[i] += (foodPrice * refundFoodNumber);
            //환불하였으므로 i번째 사람이 가지고 있는 전체 돈에 추가
            System.out.println(""+(foodPrice * refundFoodNumber)+"원을 돌려받았으며 환불이 완료되었습니다");
            selectMenu(sc);
        } else {
            //가지고 있는 음식의 개수가 환불하는 수량보다 부족할경우
            System.out.println("수량을 다시 확인해주세요");
            nextPeople(sc);
        }
    }
    void nextPeople (Scanner sc) {
        if (controlOnOffCheck == 1) {
            //제어상태가 on인 상태에서 다음손님으로 갈 수 없으므로 다시 메인메뉴로 리턴된다 controlOnOffCheck가 0이면 off상태이므로 영수증을 정상적으로 출력
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
            selectMenu(sc);
        }
        int outputTemp = 0;
        /*
        outputTemp는 food를 아무것도 구매하지 않고 다음손님으로 넘어갈때 출력되는것을 방지하기 위한 변수이며 아무것도 구매하지 않은 j값은
        continue문을 통해 출력되지 않으며 그 이외에 food를 구매한경우 outputTemp 변수에 1씩 누적되어 순서대로 출력이 가능하도록 구현
         */

        for (int j = 0; j < 15;j++) {
            if (personalBuyFoodNumbers[j][0] == 0 && personalBuyFoodNumbers[j][1] == 0 && personalBuyFoodNumbers[j][2] == 0 && personalBuyFoodNumbers[j][3] == 0 && personalBuyFoodNumbers[j][4] == 0) {
                continue;
                /*
                각 손님이 아무것도 사지 않고 다음손님을 눌렀을경우 번호는 1번부터 순서대로 출력되어야하므로 continue문을 사용하였으며 else값으로 물건을 1개라도 주문한사람은
                Outputorder변수를 통해 순서대로 출력되도록 만들었다
                 */
            } else {
                outputTemp += 1;
            }
            System.out.println("==================="+outputTemp+"번째 손님의 주문표===================");
            if (personalBuyFoodNumbers[j][0] >= 1) { //과자를 구매한 개수가 1개이상일경우 출력
                System.out.println("과자 X "+personalBuyFoodNumbers[j][0]+"개 = "+(personalBuyFoodNumbers[j][0] * 1200)+"원");
            }
            if (personalBuyFoodNumbers[j][1] >= 1) { //빵을 구매한 개수가 1개이상일경우 출력
                System.out.println("빵 X "+personalBuyFoodNumbers[j][1]+"개 = "+(personalBuyFoodNumbers[j][1] * 1000)+"원");
            }
            if (personalBuyFoodNumbers[j][2] >= 1) { //음료수를 구매한 개수가 1개이상일경우 출력
                System.out.println("음료수 X "+personalBuyFoodNumbers[j][2]+"개 = "+(personalBuyFoodNumbers[j][2] * 1500)+"원");
            }
            if (personalBuyFoodNumbers[j][3] >= 1) { //과일을 구매한 개수가 1개이상일경우 출력
                System.out.println("과일 X "+personalBuyFoodNumbers[j][3]+"개 = "+(personalBuyFoodNumbers[j][3] * 2500)+"원");
            }
            if (personalBuyFoodNumbers[j][4] >= 1) { //술을 구매한 개수가 1개이상일경우 출력
                System.out.println("과일 X "+personalBuyFoodNumbers[j][4]+"개 = "+(personalBuyFoodNumbers[j][4] * 4000)+"원");
            }
            System.out.println("=================================================");
            System.out.println("처음에 가지고 있던 금액 : "+initialCapital[j]+"원");
            System.out.println("현재 가지고 있는 금액 : "+personalMoney[j]+"원");
            System.out.println("전체 빚 진 금액 : "+ DebtTotalAmount[j]+"원");
            System.out.println("빚을 청산하고 남은 금액 : "+(DebtTotalAmount[j] - paybackTotalAmount[j])+"원");
            System.out.println("미납 된 금액 : "+(DebtTotalAmount[j] - paybackTotalAmount[j])+"원");
            System.out.println("빌려준 금액 : "+borrowTotalAmount[j]+"원\n");
        }
        i += 1;
        //구매자의 영수증을 모두 출력후 다음손님으로 넘어갈때 i 변수에 1을추가
        additionalIndex = 1;
        //초기 additionalIndex 값은 1이였으며 연속적으로 돈을 빌릴때 사용한 변수이다 다음손님으로 넘어 갈 때에는 정상적으로 초기화를 해줘야 하기 때문이다
        shuttingSystemcheck(sc);
        //전체적인 출력이끝나면 메인메뉴로 돌아간다
    }
    void paybackPeopleChoice (Scanner sc) {
        //특정 사람에게 빌린 돈을 갚기위한 메소드
        if (personalMoney[i] != 0) {
            System.out.println("몇번째 손님에게 갚겠습니까?");
            int payBackPeople = sc.nextInt() - 1;
            //실제 입력하는 손님의 번호와 index와 차이가 존재하므로 -1 을 적용

            if (personalDebtRecord[i][payBackPeople] != 0 && payBackPeople != i) {
                //돈을 갚는 손님에게 존재하는 빚이 있거나 또는 입력한 값이 자신을 입력한 경우가 아닌경우 정상적으로 리턴된다
                paybackMoneyInputMenu(payBackPeople,sc);
            } else {
                System.out.println("돈을 빌린 내역이 없거나 자신에게 갚을 수 없습니다");
                //자신에게 갚으려고 하거나 payBackPeople 번째 손님에게 돈을 빌린 내역이 없는경우 다시 메인메뉴로 리턴
            }
        } else {
            //돈갚기 메소드에 진입했을때 i번째 사람이 가지고 있는 돈의액수가 0원일때 돈을 갚을수 없으므로 다시 메인메뉴로 리턴된다
            System.out.println("현재 가지고 있는 돈이 없으므로 돈을 갚을 수 없습니다");
        }
        selectMenu(sc);
    }
    void paybackMoneyInputMenu (int payBackPeople,Scanner sc) {
        //빚을 갚는돈을 입력하는 메소드
        System.out.println("얼마를 갚겠습니까? "+(payBackPeople + 1)+"번째 사람에게 빌린 돈 : "+personalDebtRecord[i][payBackPeople]+"원");
        int payBackMoneyInput = sc.nextInt();

        if (personalDebtRecord[i][payBackPeople] >= payBackMoneyInput && (personalMoney[i] - payBackMoneyInput) >= 0) {
            //i번째 손님이 payBackPeople손님에게 돈을 갚을때 초과되어 돈을 갚지 않았으며 && 돈을 갚은 i번째 사람이 가지고 있는돈은 0보다 커야한다는 조건이 일치할경우
            personalMoney[i] -= payBackMoneyInput;
            //돈을 갚는 i번째 손님은 전체돈에서 차감
            personalMoney[payBackPeople] += payBackMoneyInput;
            //빌려준 돈을 받는 payBackPeople번째 손님은 전체돈에서 추가
            personalDebtRecord[i][payBackPeople] -= payBackMoneyInput;
            //조건이 성립되면  debtMoneyrecords[i][payBackPeople]에 빚이 누적되어있으므로 payBackMoneyInput 갚만큼 차감해서 빚을 정산한다
            borrowTotalAmount[payBackPeople] -= payBackMoneyInput;
            //payBackPeople번째 사람은 빌려준 금액에서 payBackMoneyInput 갚만큼 차감한다
            paybackTotalAmount[i] += payBackMoneyInput;
            //i번째 사람이 전체적으로 갚은 돈을 누적한다 이 변수는 다음 손님으로 넘어갈때 출력으로 사용하기 위함
            System.out.println(""+payBackMoneyInput+"원을 정상적으로 갚았습니다 남은 빚 : "+personalDebtRecord[i][payBackPeople]+"원");
        } else {
            System.out.println("빌린 금액을 정확히 확인해주세요");
        }
        selectMenu(sc);
    }
    void peopleControl (Scanner sc) {
        //원하는 손님으로 이동하기 위한 제어메소드
        if (i == 0) {
            //제어를 하기 위해서는 최소 2번째 손님(index 1)부터 가능하므로 index 0번은 제어가 불가 다시 메인메뉴로 리턴한다
            System.out.println("최소 2번째 손님부터 가능합니다");
        }
        if (controlOnOffCheck == 0) {
            System.out.println("몇번째 손님을 제어하시겠습니까?");
            int controlPeopleInput = sc.nextInt() - 1;
            //-1을 하는이유는 실제 손님은 배열에서 index 0부터 시작하기 때문
            controlIndexSave += i;
            //i값을 변경하기 전에 그 전 순서를 미리 저장하여 되돌아갈때 사용하기 위함
            i = controlPeopleInput;
            //해당손님으로 이동하기 위하여 i값을 변경
            controlOnOffCheck = 1;
            //제어가 켜져있는 상태 on
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
        }
        selectMenu(sc);
    }
    void returnSequence (Scanner sc) {
        //이전 손님으로 돌아가기
        if (controlOnOffCheck == 1) {
            //제어상태가 on인경우
            i = controlIndexSave;
            //저장했던 원래의 순서로 돌아간다
            controlIndexSave = 0;
            //save값 0으로 초기화
            controlOnOffCheck = 0;
            //제어상태 off로 전환
        }
        else {
            //제어상태가 off인경우
            System.out.println("잘못된 입력입니다");
        }
        selectMenu(sc);
    }
    void shuttingSystemcheck (Scanner sc) {
        //모든 사람이 물건을 구매했을때 시스템이 종료되도록 하는 메소드
        if (i == 14) {
            for (int i = 0; i < 15; i++) {
                personalMoney[0] += personalMoney[i];
            }
            System.out.println("시스템을 종료합니다 모든 손님들의 남은 돈은 " + personalMoney[0] + "원 입니다");
            System.exit(0);
            //i가 14 즉 15명이 모두 완료했을경우 15명이 가지고 있는 개인 금액을 0번 index에 for문을 통해 저장 Println 출력시 사용
        }
        selectMenu(sc);
    }
}
