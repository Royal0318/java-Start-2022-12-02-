import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class LottoProgram implements LottoInterface {
    static int[] correctNumberRanking = new int[5]; //해당 등수를 몇번 맞았는지 세는 배열값
    static int winnerAmount = 0; //누적 당첨금액
    static Random random = new Random(); //랜덤 선언
    static HashSet<Integer> resultNumberSave = new HashSet<>(); //정답 로또번호를 저장
    static ArrayList<Integer> resultNumber; //Hashset에서 중복이 걸러진 로또번호를 비교 가능하도록 Arraylist로 저장이 필요하기 때문
    static int[][] myLottoNumber; //나의 전체 로또넘버
    static boolean[] duplicateCheck = new boolean[46]; //로또 번호 중복을 체크하기 위한 boolean형 전역변수

    static int buyLottoNumber = 0; //로또 구매한 장수

    static int correctCount = 0; //당첨번호와 대조하여 맞는경우 count를 하여 당첨순위를 확인하기 위해 사용
    static int temp = 0; //Random 번호를 일시적으로 담는변수
    static int nextColumn = 0; //한장의 열은 5이므로 다음장 A부터 입력을 도와주는 변수가 필요하기 때문에 선언하였음
    private int myTotalMoney; //나의 전체 가진 돈

    public int getMyMoney() {
        return myTotalMoney;
    }
    public void setMyMoney(int myMoney) {
        this.myTotalMoney = myMoney;
    }
    @Override
    public void inputMyMoney() {
        /*
        메소드 역할 : 오버라이딩을 하여 처음에 가질 돈을 입력받고 5000원이 최소금액이므로 그에따른 예외처리를 하였다
         */
        while (true) {
            System.out.println("내가 가질 돈을 입력하세요 (최소 5000원 이상부터 가능합니다)");
            int initialAmount = sc.nextInt();

            if (initialAmount >= 5000) {
                setMyMoney(initialAmount);
                resultNumberAutoInput();
                break;
            }
            else {
                System.out.println("최소금액은 5000원부터 가능합니다");
            }
        }
    }
    public void resultNumberAutoInput () {
        /*
        메소드 역할 : 돈을 입력하고 나서 기계가 자동으로 로또번호를 뽑는다 Hashset을 이용하였기 때문에 random넘버중 중복은 자동적으로 거르며
        6개의 번호를 뽑아야하기때문에 while의 탈출조건을 Hash의 size가 6이되면 탈출하도록 설정하였다
        그리고 나중에 각각의 번호를 비교해야하므로 hash를 result로 변환
         */
        while (resultNumberSave.size() != 6) {
            temp = random.nextInt(45) + 1;
            resultNumberSave.add(temp);
        }
        resultNumber = new ArrayList<>(resultNumberSave);
        buyLotto();
    }
    public void buyLotto() {
        /*
        메소드 역할 : 가진 돈을 기준으로 로또 장수를 구매할 수 있다
        로또 가격 * 5000으로 벗어난경우 예외처리를 하였으며
        여러장을 구매하는경우 그 만큼 입력받아야하는 배열도 늘어나므로 장수 X 행과열을 선언해주었다
         */
        while (true) {
            System.out.println("몇장을 구매하시겠습니까? (1장의 가격은 5000원이며 1장당 5번 이용할 수 있습니다");
            buyLottoNumber = sc.nextInt();

            if (buyLottoNumber >= 1) {
                int totalLottoPrice = (5000 * buyLottoNumber); //로또 구매시 총 가격

                myLottoNumber = new int[5 * buyLottoNumber][6 * buyLottoNumber]; //2차원배열 디폴트값 X 구매한 로또 장수

                if (totalLottoPrice <= getMyMoney()) {
                    System.out.println("구매가 완료되었습니다 잔액은 " + (getMyMoney() - totalLottoPrice) + "원 입니다");
                    inputMyInputNumber();
                    break;
                } else {
                    System.out.println("가진돈이 구매가격보다 더 적습니다 다시 입력해주세요");
                }
            } else {
                System.out.println("최소 1장이상부터 구매 가능합니다");
            }
        }
    }
    public void inputMyInputNumber() {
        /*
        메소드역할 : 숫자를 입력하는 개수에 따라서 자동,반자동,수동으로나뉜다
        0개이면 전체 자동,6개면 전체 수동,그 외에는 모두 반작으로 설정된다
         */
        while (true) {
            System.out.println("몇개의 숫자를 입력하시겠습니까? (0 ~ 6까지 입력하세요)");
            int number = sc.nextInt();

            if (number == 0) { //자동
                System.out.println("0개를 입력하였으므로 전체 자동으로 입력됩니다");
                inputAutoNumber();
                break;
            }
            else if (number == 6) { //수동
                System.out.println("전체 수동으로 입력합니다");
                manualProgram();
                break;
            }
            else if (number >= 1 && number < 6) { //반자동
                System.out.println("" + number + "개를 입력하므로 나머지 번호는 모두 반자동으로 입력됩니다");
                semiAutoProgram(number);
                break;
            }
            else {
                System.out.println("범위를 벗어났습니다 다시 입력해주세요");
            }
        }
    }
    public void inputAutoNumber() { //자동
        /*
        메소드 역할 : 3중for문을 통해 random값을 배열값에 담는다 한 행을 완료하면 중복을 확인해주는 boolean을 초기화해도 되므로
        Arrays.fill을 이용하여 초기화시킨다
        마찬가지로 Random을 이용하여 1 ~ 45까지 번호를 담으며 중복을 발견했을시 다시 입력받도록 k-= 1을 사용하였다
         */
        for (int i = 0; i < buyLottoNumber;i++) {
            for (int j = 0; j < 5;j++) {
                for (int k = 0; k < 6;k++) {
                    int randomNumber = random.nextInt(45) + 1;

                    if (!duplicateCheck[randomNumber]) {
                        duplicateCheck[randomNumber] = true;
                        myLottoNumber[nextColumn + j][k] = randomNumber;
                    } else {
                        k -= 1;
                    }
                }
                Arrays.fill(duplicateCheck, false);
            }
            nextColumn += 5;
        }
        findLottoNumber();
    }
    public void  semiAutoProgram (int number) { //반자동
        /*
        메소드 역할 : 파라미터로 넘겨받은 number개수만큼 수동으로 입력받으며 마찬가지로 중복 예외처리를 적용
        나머지번호는 자동으로 입력된다
         */
        for (int i = 0; i < buyLottoNumber;i++) {

            for (int j = 0; j < 5;j++) {
                char str = (char) (j + 65);

                for (int k = 0; k < number;k++) {
                    System.out.println("" + (i + 1) + "번째 장 : " + str + "수동 " + (k + 1) + "번째 숫자를 입력해주세요");
                    int lottoNumber = sc.nextInt();

                    if (lottoNumber >= 1 && lottoNumber <= 45 && !duplicateCheck[lottoNumber]) {
                        duplicateCheck[lottoNumber] = true;
                        myLottoNumber[nextColumn + j][k] = lottoNumber;
                    }
                    else {
                        System.out.println("안내 : 중복되는 숫자이거나 벗어난 범위를 입력하였습니다 다시 시도해주세요");
                        k -= 1;
                    }
                }

                System.out.println("입력이 완료되었습니다 나머지 번호는 자동으로 입력됩니다");
                for (int k = number;k < 6;k++) {
                    int randomNumber = random.nextInt(45) + 1;

                    if (!duplicateCheck[randomNumber]) {
                        duplicateCheck[randomNumber] = true;
                        myLottoNumber[nextColumn + j][k] = randomNumber;
                    }
                    else {
                        k -= 1;
                    }
                }
                Arrays.fill(duplicateCheck, false);
            }
            nextColumn += 5;
        }
        findLottoNumber();
    }
    public void manualProgram () { //수동
        /*
        메소드 역할 : char형을 이용하여 ABCDE를 for문 j에 맞춰 나오도록 설정
        중복예외처리,boolean초기화까지 완료
         */
        for (int i = 0; i < buyLottoNumber;i++) {
            for (int j = 0; j < 5; j++) {
                char str = (char) (j + 65);

                for (int k = 0; k < 6; k++) {
                    System.out.println("" + (i + 1) + "번째 장 : " + str + "수동 " + (k + 1) + "번째 숫자를 입력해주세요 (1 ~ 45번까지)");
                    int lottoNumber = sc.nextInt();

                    if (lottoNumber >= 1 && lottoNumber <= 45 && !duplicateCheck[lottoNumber]) {
                        duplicateCheck[lottoNumber] = true;
                        myLottoNumber[nextColumn + j][k] = lottoNumber;
                    }
                    else {
                        System.out.println("안내 : 중복되는 숫자이거나 벗어난 범위를 입력하였습니다 다시 시도해주세요");
                        k -= 1;
                    }
                }
                Arrays.fill(duplicateCheck, false);
            }
            nextColumn += 5;
        }
        findLottoNumber();
    }
    public void findLottoNumber () {
        /*
        로또 번호를 입력시 등수를 기록하는 메소드이다
        3중for문을 돌면서 contains를 이용하여 번호가 존재하면 correctCount변수에 1을추가
        한 행을 모두 검사하였으면 swich문을 이용하여 맞은개수에 따른 상금을 누적
         */
        nextColumn = 0;
        for (int i = 0; i < buyLottoNumber;i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 6;k++) {

                    if (resultNumber.contains(myLottoNumber[nextColumn + j][k])) {
                        correctCount += 1; //한줄에 맞는 개수 저장
                    }
                }
                switch (correctCount) {
                    case 6 : //1등
                        correctNumberRanking[0] += 1;
                        winnerAmount += 100000;
                        break;
                    case 5 :
                    case 4 : //2등
                        correctNumberRanking[1] += 1;
                        winnerAmount += 70000;
                        break;
                    case 3 : //3등
                        correctNumberRanking[2] += 1;
                        winnerAmount += 30000;
                        break;
                    case 2 : //4등
                        correctNumberRanking[3] += 1;
                        winnerAmount += 5000;
                        break;
                    default : //꽝
                        correctNumberRanking[4] += 1;
                        break;
                }
                correctCount = 0;
            }
            nextColumn += 5;
        }
        nextColumn = 0;
        loadResult();
    }
    public void loadResult () { //총 결과값
        /*
        메소드 역할 : 입력한 로또번호 전체와 당첨번호 그리고 각각이 몇등인지 출력한다
        마지막으로 가지고있던 돈과 당첨금액을 비교하여 이득인지 손해인지 그리고 얼마이득이고 손해인지 구현하였다
         */
        System.out.println("=================내가 입력한 로또번호=================");
        for (int i = 0; i < buyLottoNumber;i++) {

            for (int j = 0;j < 5;j++) {

                char str = (char) (j + 65);

                System.out.print(""+str+" : ");

                for (int k = 0; k < 6; k++) {
                    System.out.print("["+myLottoNumber[nextColumn + j][k]+"] ");
                }
                System.out.println();
            }
            System.out.println();
            nextColumn += 5;
        }
        System.out.println("\n===================당첨 번호===================");
        System.out.println("["+resultNumber.get(0)+"] ["+resultNumber.get(1)+"] ["+resultNumber.get(2)+"] ["+resultNumber.get(3)+"] ["+resultNumber.get(4)+"] ["+resultNumber.get(5)+"]");
        System.out.println("\n===================로또 당첨결과===================");
        System.out.println("1등 : "+correctNumberRanking[0]+"번");
        System.out.println("2등 : "+correctNumberRanking[1]+"번");
        System.out.println("3등 : "+correctNumberRanking[2]+"번");
        System.out.println("4등 : "+correctNumberRanking[3]+"번");
        System.out.println("5등 : "+correctNumberRanking[4]+"번\n");
        System.out.println("기존에 가지고있던 돈은 "+getMyMoney()+"원 입니다");
        System.out.println("총 사용한 돈은 "+(buyLottoNumber * 5000)+"원 입니다");
        System.out.println("총 당첨금액은 "+winnerAmount+"원 입니다");

        if (((buyLottoNumber * 5000)) < winnerAmount) {
            System.out.println("차익은 총 "+(winnerAmount - (buyLottoNumber * 5000))+"원 이므로 "+(winnerAmount - (buyLottoNumber * 5000))+"원 더 이득입니다");
        }
        else if (((buyLottoNumber * 5000)) > winnerAmount) {
            System.out.println("차익은 총 "+((buyLottoNumber * 5000) - winnerAmount)+"원 이므로 "+((buyLottoNumber * 5000) - winnerAmount)+"원 더 손해입니다");
        }
        else {
            System.out.println("사용한 돈과 당첨금액이 일치하므로 차익은 0원입니다");
        }
    }
}
