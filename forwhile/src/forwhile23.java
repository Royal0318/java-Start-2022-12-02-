import java.util.Scanner;
public class forwhile23 {
    int givenChance;
    //각 개인정보를 입력할때 틀리게 입력했을경우 차감되는 전체 기회변수 초기의 기회 3회
    int totalAmountMoney;
    //전체 가지고 있는 돈의 액수를 담고있는 변수
    int accountInquirycheck;
    /*
    계좌조회여부 확인하는 변수이다 처음에는 0이므로 계좌 조회만 가능하지만 입,출금을 완료했을시 1이되어 계좌조회는 단 1번만가능하다 그이후 2가되어 추가적으로
    계좌조회를 하려는경우 givenChance 가 차감된다
     */
    int[][] totalFoodArr;
    /*
    전체 음식과 관련된 배열이다
    int [?][0] totalFoodArr  = 음식의 가격을 나타내는 횡렬 index값
    int [?][1] totalFoodArr  = 음식의 개수를 나타내는 횡렬 index값
     */
    forwhile23 () {

    }
    forwhile23 (int givenChance,int totalAmountMoney,int accountInquirycheck,int[][] totalFoodArr) {
        this.givenChance = givenChance;
        this.totalAmountMoney = totalAmountMoney;
        this.accountInquirycheck = accountInquirycheck;
        this.totalFoodArr = totalFoodArr;
    }

    void ageInput (Scanner sc) {
        //나이를 입력하는 메소드 나이제한은 1세 ~ 200세이며 초과하거나 미달하여 입력시 재입력받도록 설정
        System.out.println("나이를 입력해주세요 (입력제한 : 1 ~ 200세)");
        int age = sc.nextInt();

        if (age >= 1 && age <= 200) {
            System.out.println("귀하의 나이는 " + age + "세 입니다");
            genderInput(sc);
            //나이를 조건에 맞는 범위로 입력했을 경우 입력한 나이를 출력하며 성별을 입력하는 genderInput 메소드로 리턴됨
        } else {
            System.out.println("나이를 다시 입력해주세요");
            ageInput(sc);
        }
    }
    void genderInput (Scanner sc) {
        //성별을 입력할 수 있는 메소드 String으로 성별을 받으며 예시에 나와있는 문자열을 벗어나면 다시 입력하도록 설정
        System.out.println("성별을 적어주세요 예시1) 남 or 여, 예시2) 남자 or 여자");
        String gender = sc.next();

        if (gender.equals("남") || gender.equals("여") || gender.equals("남자") || gender.equals("여자")) {
            System.out.println("귀하의 성별은 "+gender+"입니다");
            phoneFrontNumberInput(sc);
            //성별을 제대로 입력시 전화번호를 입력받는 phoneFrontNumberInput 메소드로 리턴
        } else {
            System.out.println("성별을 다시 입력해주세요");
            genderInput(sc);
        }
    }
    void phoneFrontNumberInput (Scanner sc) {
        //휴대전화 앞 4자리를 입력받을 수 있는 메소드 최소값 1000 ~ 최대값 9999까지 입력이 가능
        System.out.println("국번 제외 전화번호 앞 4자리를 적어주세요 예)010-1234-5678 --- > 1234");
        int frontNumber = sc.nextInt();

        if (frontNumber >= 1000 && frontNumber < 10000) {
            phoneBackNumberInput(frontNumber,sc);
            //번호를 정상적으로 입력시 phoneBackNumberInput 메소드로 (전화번호 앞 4자리를 리턴보냄)
        } else {
            System.out.println("번호를 다시 입력해주세요");
            phoneFrontNumberInput(sc);
        }
    }
    void phoneBackNumberInput (int frontNumber,Scanner sc) {
        //휴대전화 뒤 4자리를 입력받을 수 있는 메소드 최소값 1000 ~ 최대값 9999까지 입력이 가능
        System.out.println("국번 제외 전화번호 뒤 4자리를 적어주세요 예)010-1234-5678 --- > 5678");
        int backNumber = sc.nextInt();

        if (backNumber > 1000 && backNumber < 10000) {
            System.out.println("귀하의 휴대폰 번호는 010-"+frontNumber+"-"+backNumber+"입니다");
            personalNumberInput(sc);
            //휴대전화 번호를 모두 정상적으로 입력했을경우 휴대폰 번호를 출력하며 personalNumberInput로 리턴됨
        } else {
            System.out.println("번호를 다시 입력해주세요");
            phoneBackNumberInput(frontNumber,sc);
        }
    }
    void personalNumberInput (Scanner sc) {
        //주민등록번호를 입력받는 메소드 뒤 7자리를 입력받으며 조건에 맞지 않는경우 다시 입력받는다
        System.out.println("주민등록번호 뒤 7자리를 입력해주세요 예시) 960318-1234567 --> 1234567");
        int pesonalNumber = sc.nextInt();

        if (pesonalNumber >= 1000000 && pesonalNumber <= 9999999) {
            bankMenuSelect(sc);
            //정상적으로 입력되었을 시 은행프로그램 메소드로 리턴
        } else {
            inCorrectGuesses(sc);
            //주민등록번호가 조건에 맞지 않는경우 inCorrectGuesses 메소드로 리턴된다
        }
    }
    void inCorrectGuesses (Scanner sc) {
        //주민등록번호를 틀리게 입력했을경우 이 메소드로 리턴되며 전체 기회 변수인 givenChance가 1회 차감됨
        givenChance -= 1;
        //문제 내용에 맞게 기회가 1회 차감되며 기회가 0회일시 마지막으로 기회1번을 추가적으로 주며 다시 틀릴경우 gameOver 메소드로 리턴 프로그램을 종료
        if (givenChance >= 1) {
            System.out.println("다시 입력해주세요 남은기회 : " + givenChance + "회");
        } else if (givenChance == 0) {
            System.out.println("마지막 기회입니다");
        } else {
            gameOver();
            //마지막 기회마저 틀린경우 게임을 종료시키는 메소드로 리턴 후 시스템 종료
        }
        personalNumberInput(sc);
    }
    void bankMenuSelect (Scanner sc) {
        //은행의 전체적인 메뉴를 선택할 수 있는 메뉴
        System.out.println("1.계좌조회 2.계좌입금 3.계좌출금 4.음식점 \n안내 : 계좌조회는 1회만 가능하며 이후 기회가 차감됩니다, 음식점을 이용하기 위해서는 최소 1000원 이상 필요합니다");
        int bankListSelect = sc.nextInt();

        switch (bankListSelect) {
            case 1:
                accountInquiryWarning(sc);
                //accountInquiryWarning 메소드로 리턴되어 조건에 맞는지 확인한다
                break;
            case 2:
                moneyDepositInput(sc);
                //입금 메소드로 리턴
                break;
            case 3:
                withDrawlInput(sc);
                //출금 메소드로 리턴
                break;
            case 4:
                if (totalAmountMoney < 1000) {
                    System.out.println("음식점을 이용하기 위해서는 최소 1000원이상 가지고 있어야합니다");
                    bankMenuSelect(sc);
                    //음식점을 이용하기위해서 최소 1000원이상 필요하도록 설정하였습니다
                } else {
                    //가진 돈에따른 음식값의 비율을 적용 후 음식점으로 리턴된다
                    totalFoodArr[0][0] = (totalAmountMoney / 20); //2번째로 비쌈
                    //index [0] = 장어덮밥
                    totalFoodArr[1][0] = (totalAmountMoney / 10); //가장비쌈
                    //index [1] = 옥수수콘
                    totalFoodArr[2][0] = (totalAmountMoney * 3 / 100); //가장쌈
                    //index [2] = 감자튀김
                    restaurantMenu(sc);
                }
                break;
            default:
                System.out.println("잘못된 입력입니다");
                bankMenuSelect(sc);
                break;
        }
    }
    void accountInquiryWarning (Scanner sc) {
        /*
        처음에 Accountinquirycount의 값은 0이며 문제에 나와있듯이 최초 은행프로그램 진입시 입금과 출금만 가능하다
        입금과 출금을 진행하고 계좌조회를 했을때 단 1회밖에 할 수 없으며 그이후 Accountinquirycount 값에 2가 부여된다
        계속 계좌조회를 시도할 경우 기회가 1회 차감되며 기회를 모두 소모한 경우 시스템이 종료된다
        */
        if (accountInquirycheck == 0) {
            System.out.println("처음에는 계좌입금과 출금만 가능합니다");
            //은행프로그램에 최초 진입시 계좌조회는 불가능하며 입금과 출금만 가능하다
        }
        else if (accountInquirycheck == 1) {
            System.out.println("현재 잔액은 : " + totalAmountMoney + "원 입니다");
            accountInquirycheck = 2;
            /*
            입금이나 출금을 하고 난 이후에 계좌조회는 단 1회만 가능하다 그 이후 accountInquirycheck 변수에 2를 부여하여
            다시 계좌조회를 하려고 할때 기회를 1회 차감한다
             */
        }
        else {
            givenChance -= 1;
            if (givenChance >= 1) {
                System.out.println("계좌조회는 1회만 가능합니다 남은기회 : " + givenChance + "회");
                //계속 계좌조회를 시도할때 기회가 1회씩 차감되며 기회를 모두 사용하였을때 gameOver 메소드로 리턴 프로그램을 종료한다
            } else {
                gameOver();
            }
        }
        bankMenuSelect(sc);
    }
    void moneyDepositInput (Scanner sc) {
        //입금을 진행하는 메소드
        System.out.println("입금 금액을 적어주세요");
        int depositMoney = sc.nextInt();

        if (depositMoney >= 1) {
            totalAmountMoney += depositMoney;
            System.out.println("입금이 완료되었습니다 현재 잔액 : "+ totalAmountMoney +"원");
            accountInquirycheck = 1;
            bankMenuSelect(sc);
            //입금이 완료된경우에는 입금했던 금액을 totalAmountMoney에 전체잔액 변수에 누적 Accountinquirycount 변수에 1을 부과하여 계좌조회를 1회만 허용되도록한다
        } else {
            System.out.println("최소 1원부터 입금 가능합니다");
            moneyDepositInput(sc);
            //입금금액을 1원 미만으로 적은경우에는 최소 1원부터 가능하기 때문에 다시 입력하도록 리턴한다
        }
    }
    void withDrawlInput (Scanner sc) {
        //출금을 진행하는 메소드
        System.out.println("출금 금액을 적어주세요");
        int withDrawMoney = sc.nextInt();

        if (totalAmountMoney >= withDrawMoney) {
            totalAmountMoney -= withDrawMoney;
            System.out.println("출금이 완료되었습니다 현재 잔액 : "+totalAmountMoney+"원");
            bankMenuSelect(sc);
            //출금이 완료되는경우 totalAmountMoney 에서 차감된다
        } else {
            System.out.println("출금 금액이 잔액보다 더 많습니다");
            withDrawlInput(sc);
            //출금금액이 잔액보다 많은경우에는 출금이 불가능하므로 다시 입력받도록 리턴한다
        }
    }
    void restaurantMenu (Scanner sc) {
        //음식점 메뉴
        System.out.println("1.장어덮밥(" + totalFoodArr[0][0] + "원) 2.옥수수콘(" + totalFoodArr[1][0] + "원) 3.감자튀김(" + totalFoodArr[2][0] + "원) 4.계산[변경] 5.환불 6.시스템 종료 \n<<<현재 잔액 : " + totalAmountMoney + "원>>>");
        int foodListChoice = sc.nextInt();

        switch (foodListChoice) {
            /*
            장어덮밥index = 0번
            옥수수콘index = 1번
            감자튀김index = 2번
            원하는 음식을 선택한 후 foodCalculation(음식 index 번호,음식이름,Scanner sc를 리턴보낸다)
             */
            case 1:
                foodCalculation(0, "장어덮밥",sc);
                break;
            case 2:
                foodCalculation(1, "옥수수콘",sc);
                break;
            case 3:
                foodCalculation(2, "감자튀김",sc);
                break;
            case 4:
                foodExchange(sc);
                //음식을 교환하는 메소드로 리턴된다
                break;
            case 5:
                refundMenu(sc);
                //음식을 환불하는 메소드로 리턴된다
                break;
            case 6:
                System.out.println("시스템을 종료합니다");
                System.exit(0);
                break;
            default:
                System.out.println("잘못된 입력입니다");
                restaurantMenu(sc);
                //잘못된 입력시 다시 메뉴를 선택할 수 있도록 리턴
                break;
        }
    }
    void foodCalculation (int foodIndexArr,String foodName,Scanner sc) {
        //(음식 index 번호,음식이름,Scanner sc)를 리턴받아 계산을 완료하고 다시 음식점으로 돌아간다
        if (totalAmountMoney > totalFoodArr[foodIndexArr][0]) {
            //가지고 있는는 전체돈이 받은 index에따라 음식의 가격과 비교해서 충분히 남아있을때 구매를 완료시킴
            totalAmountMoney -= totalFoodArr[foodIndexArr][0];
            //구매한 음식의 가격만큼 totalAmountMoney 에서 차감한다
            totalFoodArr[foodIndexArr][1] += 1;
            //foodIndexArr의 번호에 따라 음식의 종류가 달라진다 그러므로 리턴받은 index번호에 따라 해당 음식의 개수를 1개 누적한다
            System.out.println(""+foodName+"구매가 완료되었습니다");
        } else {
            System.out.println("돈이 부족합니다");
            //돈이 부족한경우 다시 음식점으로 돌아간다
        }
        restaurantMenu(sc);
    }
    void foodExchange (Scanner sc) {
        //음식을 교환하기 위하여 사용되는 메소드
        int foodPricedIfference = 0;
        /*
        foodPricedIfference 변수는 교환이 완료되었을때 교환되는 음식에 따라 돈을 돌려받을지 추가 지불할지 여부를 결정해주는 변수이다
        예를들어서 옥수수콘이 가장비싸지만 옥수수콘을 감자튀김으로 바꿀경우 가장비싼 음식을 가장싼 음식으로 바꾸는 것 이기때문에
        (옥수수콘 - 감자튀김)값만큼 돈을 돌려받게 되는것이다
         */
        System.out.println("교환 할 음식의 번호를 적어주세요 예시) 감자튀김 --> 옥수수콘 --> 3 Enter 2 Enter \n1.장어덮밥  \n2.옥수수콘  \n3.감자튀김");
        int changeFood = sc.nextInt() - 1;
        int changeFood2 = sc.nextInt() - 1;
        //실제 메뉴와 Println에 나와있는 번호의 차이가 있기 때문에 -1을 적용

        if (changeFood < 0 || changeFood > 2 || changeFood2 < 0 || changeFood2 > 2 || changeFood == changeFood2) {
            //음식의 번호를 벗어나거나 같은 음식을 교환하는경우 교환이 불가능하므로 다시 고르도록 리턴시킴
            System.out.println("잘못된 입력입니다");
            foodExchange(sc);
        }
        else {
            if (totalFoodArr[changeFood][1] == 0) {
                //선택한 번호의 음식을 구매한 내역이 없는경우에는 다시 입력하게 리턴되며 가지고 있는 음식의 개수를 출력해준다
                System.out.println("수량을 다시 확인해주세요");
                System.out.println("안내 : 현재 구매한 음식의 개수 \n1.장어덮밥 : " + totalFoodArr[0][1] + "개 \n2.옥수수콘 : " + totalFoodArr[1][1] + "개 \n3.감자튀김 : " + totalFoodArr[2][1] + "개");
            } else {
                //교환이 성공적으로 되는경우
                totalFoodArr[changeFood][1] -= 1;
                //교환하므로 자신이 가지고 있는 음식의 개수를 1개 차감
                totalFoodArr[changeFood2][1] += 1;
                //교환하므로 교환되는 음식의 개수가 증가
                foodPricedIfference += (totalFoodArr[changeFood][0] - totalFoodArr[changeFood2][0]);
                totalAmountMoney += foodPricedIfference;
                //교환한 음식의 가격차이를 확인하여 음수가나온경우 돈을 지불하고 양수가나온경우 추가로 돈을 받는다 그 차이를 foodPricedIfference 변수에 저장후 조건을 따짐
                if (foodPricedIfference < 0) {
                    System.out.println("교환이 완료되었습니다 " + ((totalFoodArr[changeFood][0] - totalFoodArr[changeFood2][0]) * -1) + "원을 추가로 지불했습니다");
                    //교환하지만 추가적으로 돈을 더 내야하는상황
                } else {
                    System.out.println("교환이 완료되었습니다 " + (totalFoodArr[changeFood][0] - totalFoodArr[changeFood2][0]) + "원을 추가로 받았습니다");
                    //교환하지만 값이 싼음식으로 바꿧으므로 추가적으로 돈을 받음
                }
            }
            restaurantMenu(sc);
        }
    }
    void refundMenu (Scanner sc) {
        //음식을 환불할때 리턴되는 메소드
        System.out.println("환불 할 음식의 번호를 적어주세요 \n1.장어덮밥  \n2.옥수수콘  \n3.감자튀김");
        int refundFoodListNumber = sc.nextInt();

        //switch문을 이용하여 원하는 메뉴 입력시 (음식이름,음식index번호,Scanner sc)을 refundSuccess로 보냄)
        switch (refundFoodListNumber) {
            case 1 :
                refundSuccess("장어덮밥",0,sc);
                break;
            case 2 :
                refundSuccess("옥수수콘",1,sc);
                break;
            case 3 :
                refundSuccess("감자튀김",2,sc);
                break;
            default :
                System.out.println("잘못된 입력입니다");
                refundMenu(sc);
                break;
        }
    }
    void refundSuccess (String food,int receiveIndexNumber,Scanner sc) {
        //음식환불을 완료시키는 메소드이다 [][0] == 음식의 가격을 나타내며 [][1] == 음식의 개수를 나타낸다
        if (totalFoodArr[receiveIndexNumber][1] >= 1) {
            //receiveIndexNumber의 음식index번호를 배열값에 넣어 해당 음식 개수가 존재할경우 음식을 환불한다
            totalAmountMoney += totalFoodArr[receiveIndexNumber][0];
            //음식의 가격만큼 전체 가진돈에 추가시킴
            totalFoodArr[receiveIndexNumber][1] -= 1;
            //환불하였으므로 환불하는 음식의 개수 차감
            System.out.println("" + food + "환불이 완료되었습니다");
        } else {
            System.out.println("구매한 내역이 없습니다");
        }
        restaurantMenu(sc);
    }
    void gameOver () {
        //기회를 모두 사용하였을때 리턴되는 메소드이다 기회를 모두 사용하였을경우 리턴되여 exit를 통해 시스템이 종료된다
        System.out.println("기회를 모두 사용하였으므로 프로그램을 종료합니다");
        System.exit(0);
    }
}
