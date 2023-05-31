import java.util.Random;

public class LottoProgram implements LottoInterface {
    static boolean[] duplicateCheck = new boolean[46]; //중복검사를 위해 boolean형 선언
    static int[] correctNumberRanking = new int[5]; //해당 등수를 몇번 맞았는지 세는 배열값
    static int winnerAmount = 0; //당첨금액
    /*
    1등 : 100000원
    2등 : 70000원
    3등 : 50000원
    4등 : 30000원
    5등 : 5000원
     */
    static int[] resultNumber; //로또 당첨번호
    static int inputNumberCheck = 0; //중복이 나오는경우 다시 입력받도록 하고 6개를 입력시 탈출시키도록 도와줌
    static int buyLottoNumber = 0; //로또 구매한 장수
    static Random random; //랜덤 번호를 위해 static으로선언
    private int myMoney; //나의 돈
    private int inputNumber; //숫자입력 개수

    public int getMyMoney() {
        return myMoney;
    }

    public int getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public void setMyMoney(int myMoney) {
        this.myMoney = myMoney;
    }
    @Override
    public void inputMyMoney() {
        System.out.println("내가 가질 돈을 입력하세요");
        setMyMoney(sc.nextInt());
    }
    @Override
    public void buyLotto() {
        System.out.println("몇장을 구매하시겠습니까? (1장의 가격은 5000원이며 1장당 5번 이용할 수 있습니다");
        buyLottoNumber = sc.nextInt();

        int tempCal = (5000 * buyLottoNumber); //로또 구매시 총 가격

        if (tempCal <= getMyMoney()) {
            setMyMoney(getMyMoney() - tempCal);
            System.out.println("구매가 완료되었습니다 잔액은 "+(tempCal - getMyMoney())+"원 입니다");
        }
        else {
            System.out.println("가진돈이 구매가격보다 더 적습니다 다시 입력해주세요");
        }
    }
    @Override
    public void inputMyInputNumber() {
        System.out.println("몇개의 숫자를 입력하시겠습니까? (1 ~ 6까지 입력하세요)");
        int number = sc.nextInt();

        if (number == 0) {
            System.out.println("0개를 입력하였으므로 전체 자동으로 입력됩니다");
            setInputNumber(number);
            AutoProgram();
        }
        else if (number == lottoMaxNumber) {
            System.out.println("전체 수동으로 입력합니다");
            setInputNumber(number);
            semiAutoProgram();
        }
        else if (number >= 1 && number < lottoMaxNumber) { //1 ~ 5까지
            System.out.println(""+number+"개를 입력하므로 "+(number - getInputNumber())+"개는 반자동으로 입력됩니다");
            setInputNumber(number);
            manualProgram();
        }
        else {
            System.out.println("범위를 벗어났습니다 다시 입력해주세요");
        }
    }
    @Override
    public void randomResultNumber() {
        //로또번호 미리 저장
        while (inputNumberCheck < 7) { //6일때 탈출 그전까지 입력받음
            int temp = random.nextInt(45) + 1; //랜덤넘버 1 ~ 45

            if (!duplicateCheck[temp]) { //해당문자가 false라면 통과
                resultNumber[inputNumberCheck] += temp; //통과한값은 배열값에 저장
                duplicateCheck[temp] = true;//중복방지를위해 true로 바꿈
                inputNumberCheck += 1;
            }
        }
        for (int i = 1; i < 46;i++) {
            duplicateCheck[i] = false;
        }
    }
    public void AutoProgram() { //올 자동
        for (int i = 0; i < buyLottoNumber;i++) { //총 장수만큼 반복문 실행

            for (int j = 0; j < 5;j++) {
                int correctCount = 0; //한줄에 맞는 개수 저장

                while (inputNumberCheck < 7) { //6일때 탈출 그전까지 입력받음
                    int temp = random.nextInt(45) + 1; //랜덤넘버 1 ~ 45

                    if (!duplicateCheck[temp]) { //해당문자가 false라면 통과
                        if (temp == resultNumber[inputNumberCheck]) {
                            correctCount += 1;
                        }
                        inputNumberCheck += 1;
                        duplicateCheck[temp] = true; //해당번호가 나왔으므로 true로 바꿈
                    }
                }
                //한줄끝날때마다 순위파악 및 초기화
                inputNumberCheck = 0;
                if (correctCount == 6) { //1등
                    correctNumberRanking[0] += 1;
                    winnerAmount += 100000;
                }
                else if (correctCount == 5) { //2등
                    correctNumberRanking[1] += 1;
                    winnerAmount += 70000;
                }
                else if (correctCount == 4) { //3등
                    correctNumberRanking[2] += 1;
                    winnerAmount += 50000;
                }
                else if (correctCount == 3) { //4등
                    correctNumberRanking[3] += 1;
                    winnerAmount += 30000;
                }
                else { //꽝
                    correctNumberRanking[4] += 1;
                    winnerAmount += 5000;
                }
            }
        }
        outputResult();
    }
    public void semiAutoProgram () { //반자동

    }
    public void manualProgram () { //수동

    }
    public void outputResult () { //총 결과값
        System.out.println("==========로또 당첨결과==========");
        System.out.println("1등 : "+correctNumberRanking[0]+"번");
        System.out.println("2등 : "+correctNumberRanking[1]+"번");
        System.out.println("3등 : "+correctNumberRanking[2]+"번");
        System.out.println("4등 : "+correctNumberRanking[3]+"번");
        System.out.println("5등 : "+correctNumberRanking[4]+"번\n");
        System.out.println("총 사용한 돈은 "+(buyLottoNumber * 5000)+"원 입니다");
        System.out.println("총 당첨금액은 "+winnerAmount+"원 입니다");

        if (((buyLottoNumber * 5000)) < winnerAmount) {
            System.out.println("차익은 총 "+(winnerAmount - (buyLottoNumber * 5000))+"원 이므로 "+(winnerAmount - (buyLottoNumber * 5000))+"원 더 흭득하였습니다");
        } else {
            System.out.println("차익은 총 "+((buyLottoNumber * 5000) - winnerAmount)+"원 이므로 "+((buyLottoNumber * 5000) - winnerAmount)+"원 더 손해입니다");
        }
    }
}
