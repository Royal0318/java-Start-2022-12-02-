import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class LottoProgram implements LottoInterface {
    static int[] correctNumberRanking = new int[5]; //해당 등수를 몇번 맞았는지 세는 배열값
    static int winnerAmount = 0; //누적 당첨금액
    static Random random = new Random();
    static HashSet<Integer> resultNumberSave = new HashSet<>(); //정답 로또번호를 저장
    static ArrayList<Integer> resultNumber; //Hashset에서 중복이 걸러진 로또번호를 비교 가능하도록 Arraylist로 저장이 필요하기 때문
    static int[][] myLottoNumber; //나의 전체 로또넘버
    static boolean[] duplicateCheck = new boolean[46]; //로또 번호 중복을 체크하기 위한 boolean형 전역변수
    static ArrayList<Integer> numberSave = new ArrayList<>();

    static int buyLottoNumber = 0; //로또 구매한 장수

    static int correctCount = 0; //당첨번호와 대조하여 맞는경우 count를 하여 당첨순위를 확인하기 위해 사용
    static int temp = 0; //Random 번호를 일시적으로 담는변수
    static int a = 0; //한장 A자동만 입력하면 나머지는 복사되고 다음장으로 넘어가서 입력받게해주는 전역변수
    private int myTotalMoney; //나의 전체 가진 돈

    public int getMyMoney() {
        return myTotalMoney;
    }
    public void setMyMoney(int myMoney) {
        this.myTotalMoney = myMoney;
    }
    @Override
    public void inputMyMoney() {
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
        while (resultNumberSave.size() != 6) {
            temp = random.nextInt(45) + 1;
            resultNumberSave.add(temp);
        }
        resultNumber = new ArrayList<>(resultNumberSave); //Hashmap을 Arraylist로 변환
        buyLotto();
    }
    public void buyLotto() {
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
        while (true) {
            System.out.println("몇개의 숫자를 입력하시겠습니까? (0 ~ 6까지 입력하세요)");
            int number = sc.nextInt();

            if (number == 0) { //자동
                System.out.println("0개를 입력하였으므로 전체 자동으로 입력됩니다");
                inputAutoNumber();
                break;
            }
            else if (number == lottoMaxNumber) { //수동
                System.out.println("전체 수동으로 입력합니다");
                manualProgram();
                break;
            }
            else if (number >= 1 && number < lottoMaxNumber) { //반자동
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
        for (int i = 0; i < buyLottoNumber;i++) {
            for (int j = 0; j < 5;j++) {
                for (int k = 0; k < 6;k++) {
                    int randomNumber = random.nextInt(45) + 1;

                    if (!duplicateCheck[randomNumber]) {
                        duplicateCheck[randomNumber] = true;
                        myLottoNumber[a + j][k] = randomNumber;
                    } else {
                        k -= 1;
                    }
                }
                Arrays.fill(duplicateCheck, false); //boolean초기화
            }
            a += 5;
        }
        findLottoNumber();
        //Math.random을 1 ~ 45범위로 지정하고 Arraylist contains를사용하여 중복하지않게했을때 왜 0이저장되는가?
    }
    public void  semiAutoProgram (int number) { //반자동
        for (int i = 0; i < number; i++) { //수동번호 입력
            System.out.println("A 수동 " + (i + 1) + "번째 숫자를 입력해주세요 (1 ~ 45번까지)");
            int lottoNumber = sc.nextInt();

            if (lottoNumber >= 1 && lottoNumber <= 45 && !duplicateCheck[lottoNumber]) {
                duplicateCheck[lottoNumber] = true;
                myLottoNumber[0][i] = lottoNumber;
            } else {
                System.out.println("벗어난 범위이거나 이미 존재하는 번호입니다");
                i -= 1;
            }
        }
        for (int i = 0; i < buyLottoNumber; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < number; k++) {
                    myLottoNumber[a + j][k] = myLottoNumber[0][k];
                }
            }
            a += 5;
        }
        a = 0;
        for (int i = 0; i < buyLottoNumber; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = number; k < 6; k++) {
                    int randomNumber = random.nextInt(45) + 1;

                    if (!duplicateCheck[randomNumber] && !numberSave.contains(randomNumber)) {
                        numberSave.add(randomNumber);
                        myLottoNumber[a + j][k] = randomNumber;
                    } else {
                        k -= 1;
                    }
                }
                numberSave.clear();
            }
            a += 5;
        }
        a = 0;
        findLottoNumber();
    }
    public void manualProgram () { //수동
        for (int i = 0; i < 6; i++) {
            System.out.println("1번째 장 A 수동 " + (i + 1) + "번째 숫자를 입력해주세요 (1 ~ 45번까지)");
            int lottoNumber = sc.nextInt();

            if (lottoNumber >= 1 && lottoNumber <= 45 && !duplicateCheck[lottoNumber]) {
                duplicateCheck[lottoNumber] = true;
                myLottoNumber[0][i] = lottoNumber;
            }
            else {
                System.out.println("벗어난 범위이거나 이미 존재하는 번호입니다");
                i -= 1;
            }
        }
        for (int i = 1 ; i < 5;i++) {
            for (int j = 0 ; j< 6;j++) {
                myLottoNumber[i][j] = myLottoNumber[0][j];
            }
        }
        if (buyLottoNumber > 1) {
            a = 5;
            for (int i = 0; i < buyLottoNumber; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 6; k++) {
                        myLottoNumber[a + j][k] = myLottoNumber[0][k];
                    }
                }
                a += 5;
            }
        }
        a = 0;
        findLottoNumber();
    }
    public void findLottoNumber () {
        for (int i = 0; i < buyLottoNumber;i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 6;k++) {

                    if (resultNumber.contains(myLottoNumber[a + j][k])) {
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
            a += 5;
        }
        a = 0;
        loadResult();
    }
    public void loadResult () { //총 결과값
        System.out.println("=================내가 입력한 로또번호=================");
        for (int i = 0; i < buyLottoNumber;i++) {

            for (int j = 0;j < 5;j++) {

                char str = (char) (j + 65);

                System.out.print(""+str+" : ");

                for (int k = 0; k < 6; k++) {
                    System.out.print("["+myLottoNumber[a + j][k]+"] ");
                }
                System.out.println();
            }
            System.out.println();
            a += 5;
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
/*
수동테스트
 for (int i = 0; i < buyLottoNumber;i++) {

            for (int j = 0; j < 5; j++) {
                char str = (char) (j + 65);

                for (int k = 0; k < 6; k++) {
                    System.out.println("" + (i + 1) + "번째 장 : " + str + "수동 " + (k + 1) + "번째 숫자를 입력해주세요 (1 ~ 45번까지)");
                    int lottoNumber = sc.nextInt();

                    if (lottoNumber >= 1 && lottoNumber <= 45) {
                        if (!duplicateCheck[lottoNumber]) {
                            duplicateCheck[lottoNumber] = true;
                        } else { //중복인경우 다시
                            System.out.println("안내 : 중복되는 숫자는 입력할 수 없습니다");
                            k -= 1;
                        }
                    } else {
                        System.out.println("벗어난 범위입니다 다시 입력해주세요");
                        k -= 1;
                    }
                }
                for (int k = 1;k < 46;k++) {
                    duplicateCheck[k] = false;
                }
            }
        }

        반자동 테스트
        for (int i = 0; i < buyLottoNumber;i++) {

            for (int j = 0; j < 5;j++) {
                char str = (char) (j + 65);

                for (int k = 0; k < number;k++) {
                    System.out.println("" + (i + 1) + "번째 장 : " + str + "수동 " + (k + 1) + "번째 숫자를 입력해주세요");
                    int lottoNumber = sc.nextInt();

                    if (lottoNumber >= 1 && lottoNumber <= 45) {
                        if (!duplicateCheck[lottoNumber]) {
                            duplicateCheck[lottoNumber] = true;
                            myLottoNumber[j][k] = lottoNumber;
                        } else { //중복인경우 다시
                            System.out.println("안내 : 중복되는 숫자는 입력할 수 없습니다");
                            k -= 1;
                        }
                    } else {
                        System.out.println("벗어난 범위입니다 다시 입력해주세요");
                        k -= 1;
                    }
                }
                System.out.println("입력이 완료되었습니다 나머지 번호는 자동으로 입력됩니다");
                for (int k = number;k < 6;k++) {
                    temp = (int)(Math.random() * 45) + 1;

                    if (!duplicateCheck[temp]) {
                        duplicateCheck[temp] = true;
                        myLottoNumber[j][k] = temp;
                    } else {
                        k -= 1;
                    }
                }
                for (int k = 1;k < 46;k++) {
                    duplicateCheck[k] = false;
                }
            }
        }

 */
