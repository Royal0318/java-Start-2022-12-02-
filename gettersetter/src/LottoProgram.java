import java.util.ArrayList;
import java.util.HashSet;

public class LottoProgram implements LottoInterface {
    static int[] correctNumberRanking = new int[5]; //해당 등수를 몇번 맞았는지 세는 배열값
    static int winnerAmount = 0; //당첨금액
    /*
    1등 : 100000원
    2등 : 70000원
    3등 : 30000원
    4등 : 5000원
    5등 : 0원
     */
    static HashSet<Integer> resultNumberSave = new HashSet<>(); //정답 로또번호
    static ArrayList<Integer> resultNumber;

    static int[][] myLottoNumber;
    static boolean[] duplicateCheck = new boolean[46]; //중복체크

    static int buyLottoNumber = 0; //로또 구매한 장수

    static int correctCount = 0;
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
        while (true) {
            System.out.println("내가 가질 돈을 입력하세요 (최소 5000원 이상부터 가능합니다)");
            int initialAmount = sc.nextInt();

            if (initialAmount >= 5000) {
                setMyMoney(initialAmount);
                buyLotto();
                break;
            } else {
                System.out.println("최소금액은 5000원부터 가능합니다");
            }
        }
    }
    public void buyLotto() {
        while (true) {
            System.out.println("몇장을 구매하시겠습니까? (1장의 가격은 5000원이며 1장당 5번 이용할 수 있습니다");
            buyLottoNumber = sc.nextInt();

            int tempCal = (5000 * buyLottoNumber); //로또 구매시 총 가격

            if (tempCal <= getMyMoney()) {
                System.out.println("구매가 완료되었습니다 잔액은 " + (getMyMoney() - tempCal) + "원 입니다");
                randomResultNumber();
                break;
            } else {
                System.out.println("가진돈이 구매가격보다 더 적습니다 다시 입력해주세요");
            }
        }
    }
    public void randomResultNumber() {
        //로또번호 미리 저장
        int temp;
        while (resultNumberSave.size() != 6) {
            temp = (int)(Math.random() * 45) + 1;
            resultNumberSave.add(temp);
        }
        resultNumber = new ArrayList<>(resultNumberSave); //Hashmap을 Arraylist로 변환
        //정답 랜덤으로 저장
        myLottoNumber = new int[5 * buyLottoNumber][6 * buyLottoNumber]; //2차원배열 디폴트값 X 구매한 로또 장수

           for (int i = 0; i < (5 * buyLottoNumber);i++) {
               for (int j = 0; j < 6;j++) {
                   temp = (int)(Math.random() * 45) + 1;

                   if (!duplicateCheck[temp]) {
                       duplicateCheck[temp] = true;
                       myLottoNumber[i][j] += temp;
                   } else {
                       j -= 1;
                   }
               }
               for (int j = 1; j < 46;j++) {
                   duplicateCheck[j] = false;
               }
           }
        //나의번호를 랜덤으로 미리 저장
        inputMyInputNumber();
    }
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
            manualProgram();
            semiAutoProgram();
        }
        else if (number >= 1 && number < lottoMaxNumber) { //1 ~ 5까지
            System.out.println(""+number+"개를 입력하므로 "+(number - getInputNumber())+"개는 반자동으로 입력됩니다");
            setInputNumber(number);
            semiAutoProgram();
        }
        else {
            System.out.println("범위를 벗어났습니다 다시 입력해주세요");
        }
    }
    public void AutoProgram() { //올 자동
            for (int i = 0; i < 5 * buyLottoNumber;i++) {
                for (int j = 0; j < 6; j++) {
                    for (int k = 0; k < 6;k++) {
                        if (myLottoNumber[i][k] == resultNumber.get(j) && !duplicateCheck[myLottoNumber[i][k]]) {
                            duplicateCheck[myLottoNumber[i][j]] = true;
                            correctCount += 1; //한줄에 맞는 개수 저장
                        }
                    }
                }
                if (correctCount == 6) { //1등
                    correctNumberRanking[0] += 1;
                    winnerAmount += 100000;
                }
                else if (correctCount == 5 || correctCount == 4) { //2등
                    correctNumberRanking[1] += 1;
                    winnerAmount += 70000;
                }
                else if (correctCount == 3) { //3등
                    correctNumberRanking[2] += 1;
                    winnerAmount += 30000;
                } else if (correctCount == 2) { //4등
                    correctNumberRanking[3] += 1;
                    winnerAmount += 5000;
                } else { //꽝
                    correctNumberRanking[4] += 1;
                }
                for (int j = 1;j < 46;j++) {
                    duplicateCheck[j] = false;
                }
                correctCount = 0;
            }
        outputResult();
    }
    public void semiAutoProgram () { //반자동

    }
    public void manualProgram () { //수동
        for (int i = 0; i < buyLottoNumber;i++) {

            for (int j = 0; j < 5; j++) {
                char str = (char) (j + 65);

                for (int k = 0; k < 6; k++) {
                    System.out.println(""+(i + 1)+"번째 장 : " + str + "수동 " + (k + 1) + "번째 숫자를 입력해주세요");
                    int lottoNumber = sc.nextInt();

                    if (!duplicateCheck[lottoNumber]) {
                        duplicateCheck[lottoNumber] = true;
                    } else { //중복인경우 다시
                        System.out.println("안내 : 중복되는 숫자는 입력할 수 없습니다");
                        k -= 1;
                    }
                }
                for (int k = 1;k < 46;k++) {
                    duplicateCheck[k] = false;
                }
            }
        }
        System.out.println("로또 번호를 맞추는 중 입니다 조금만 기다려주세요...");

        for (int i = 0; i < 5 * buyLottoNumber;i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6;k++) {
                    if (myLottoNumber[i][k] == resultNumber.get(j) && !duplicateCheck[myLottoNumber[i][k]]) {
                        duplicateCheck[myLottoNumber[i][j]] = true;
                        correctCount += 1; //한줄에 맞는 개수 저장
                    }
                }
            }
            if (correctCount == 6) { //1등
                correctNumberRanking[0] += 1;
                winnerAmount += 100000;
            }
            else if (correctCount == 5 || correctCount == 4) { //2등
                correctNumberRanking[1] += 1;
                winnerAmount += 70000;
            }
            else if (correctCount == 3) { //3등
                correctNumberRanking[2] += 1;
                winnerAmount += 30000;
            } else if (correctCount == 2) { //4등
                correctNumberRanking[3] += 1;
                winnerAmount += 5000;
            } else { //꽝
                correctNumberRanking[4] += 1;
            }
            for (int j = 1;j < 46;j++) {
                duplicateCheck[j] = false;
            }
            correctCount = 0;
        }
        outputResult();
    }
    public void outputResult () { //총 결과값
        System.out.println("==========로또 당첨결과==========");
        System.out.println("1등 : "+correctNumberRanking[0]+"번");
        System.out.println("2등 : "+correctNumberRanking[1]+"번");
        System.out.println("3등 : "+correctNumberRanking[2]+"번");
        System.out.println("4등 : "+correctNumberRanking[3]+"번");
        System.out.println("5등 : "+correctNumberRanking[4]+"번\n");
        System.out.println("기존에 가지고있던 돈은 "+getMyMoney()+"원 입니다");
        System.out.println("총 사용한 돈은 "+(buyLottoNumber * 5000)+"원 입니다");
        System.out.println("총 당첨금액은 "+winnerAmount+"원 입니다");

        if (((buyLottoNumber * 5000)) < winnerAmount) {
            System.out.println("차익은 총 "+(winnerAmount - (buyLottoNumber * 5000))+"원 이므로 "+(winnerAmount - (buyLottoNumber * 5000))+"원 더 흭득하였습니다");
        } else if (((buyLottoNumber * 5000)) > winnerAmount) {
            System.out.println("차익은 총 "+((buyLottoNumber * 5000) - winnerAmount)+"원 이므로 "+((buyLottoNumber * 5000) - winnerAmount)+"원 더 손해입니다");
        } else {
            System.out.println("사용한 돈과 당첨금액이 일치하므로 차익은 0원입니다");
        }
    }
}
