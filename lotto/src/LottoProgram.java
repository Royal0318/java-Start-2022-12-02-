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
        /*
        메소드 역할 : 오버라이딩 되어 가장처음에 실행되며 로또를 구매하기전에
        자신이 가진 돈을 입력받는다 최소 5000원 부터 가능하여 5000원 미만을 입력할 경우 다시 입력받도록
        예외처리를 해주었다
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
        메소드 역할 : 프로그램이 동작하면 미리 당첨 로또번호를 저장한다
        Hash를 이용하였으므로 1 ~ 45번의 랜덤값이 temp 전역변수에 담기고 그 값이 만약에 중복이 발생할경우
        add되지않는다 resultNumberSave.size가 6이되면 탈출한다 6이되었다는것은 중복없이 6개의 당첨번호가 생성되었다는 것을 의미한다
        그 이후에 Hash는 직접 배열과 비교할 수 없어서 비교가능한 Arraylist형으로 변환시켜 주었다
         */
        while (resultNumberSave.size() != 6) {
            temp = random.nextInt(45) + 1;
            resultNumberSave.add(temp);
        }
        resultNumber = new ArrayList<>(resultNumberSave); //Hashmap을 Arraylist로 변환
        buyLotto();
    }
    public void buyLotto() {
        /*
        메소드 역할 : 가진돈을 가지고 로또를 구매하는 메소드이다
        buyLottoNumber 전역변수는 나중에 n장만큼 추가적으로 입력받아야하므로 전역변수 처리해주었으며
        가진돈보다 구매한 값이 더 큰경우 다시 입력받도록 예외처리를 해주었다
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
        메소드 역할 : 0 ~ 6개까지 숫자를 입력받는다 0개라면 자동 6개면 모두 수동이며 나머지는 반자동으로 배치되고
        그 외의 범위를 입력했을때 다시 입력받도록 예외처리도 하였다
         */
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
        /*
        메소드 역할 : 0개를 입력하였을때 모두 자동으로 입력된다
        All 자동일 경우에는 5 * 로또 구매용지 개수 만큼 for문이 돌면서 랜덤값이 저장된다
        boolean을 사용하여 temp값이 false 즉 중복되지않은 값이라면 그값을 true로 바꿔주고
        myLottoNumber 배열에 값을 담는다
        만약에 true라면 다시 입력받도록 j -= 1로 처리하였으며
        한 횡을 모두 입력이 완료되면 다시 boolean을 초기화한다
         */
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
        a = 0;
        findLottoNumber();
        //Math.random을 1 ~ 45범위로 지정하고 Arraylist contains를사용하여 중복하지않게했을때 왜 0이저장되는가?
    }
    public void  semiAutoProgram (int number) { //반자동
        /*
        메소드 역할 : 처음에 몇개를 입력할건지 담은 number변수만큼 for문이 돌면서 값을 저장한다
        나머지 방식은 위와 같으며 수동으로 입력이 끝난경우에
        나머지는 자동으로 입력되어야 하기 때문에 temp 변수를 통하여 랜덤 값을 담고 수동으로 입력한 값이 중복으로 존재하는지 체크한다
        char형을 이용하여 실제 복권과 유사하도록 A~E가 나타나도록 아스키 코드를 참고하여 숫자를 문자형으로 변환하여 사용했다
         */
        for (int i = 0; i < number; i++) { //수동번호 입력
            System.out.println("A 수동 " + (i + 1) + "번째 숫자를 입력해주세요 (1 ~ 45번까지)");
            int lottoNumber = sc.nextInt();

            if (lottoNumber >= 1 && lottoNumber <= 45 && !numberSave.contains(lottoNumber)) {
                myLottoNumber[0][i] = lottoNumber;
                numberSave.add(lottoNumber);
            } else {
                System.out.println("벗어난 범위이거나 이미 존재하는 번호입니다");
                i -= 1;
            }
        }
        for (int i = 1; i < 5; i++) { //bcde도 a와 같이 번호를 복사
            for (int j = 0; j < number; j++) {
                myLottoNumber[i][j] = myLottoNumber[0][j];
            }
        }
        a = 5;
        if (buyLottoNumber > 1) {
            for (int i = 0; i < (buyLottoNumber - 1); i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 6; k++) {
                        myLottoNumber[a + j][k] = myLottoNumber[j][k];
                    }
                }
                a += 5;
            }
        }
        a = 0;
        for (int i = 0; i < buyLottoNumber; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = number; k < 6; k++) {
                    int randomNumber = random.nextInt(45) + 1;

                    if (!numberSave.contains(randomNumber)) {
                        myLottoNumber[a + j][k] = randomNumber;
                    } else {
                        k -= 1;
                    }
                }
            }
            a += 5;
        }
        System.out.println("입력이 완료되었습니다 나머지 번호는 자동으로 입력됩니다");
        findLottoNumber();
    }
    public void manualProgram () { //수동
        /*
        메소드 역할 : 전체 수동은 입력한 값이 중복인지 여부만 판단하면 되기 때문에 간단하게 처리하였다
         */
        a = 0;
        for (int i = 0; i < 6; i++) {
            System.out.println("1번째 장 A 수동 " + (i + 1) + "번째 숫자를 입력해주세요 (1 ~ 45번까지)");
            int lottoNumber = sc.nextInt();

            if (lottoNumber >= 1 && lottoNumber <= 45 && !duplicateCheck[lottoNumber]) {
                duplicateCheck[lottoNumber] = true;
                myLottoNumber[a][i] = lottoNumber;
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
        a = 5;
        for (int k = 0; k < (5 * (buyLottoNumber - 1));k++) {
            for (int n = 0; n < 6;n++) {
                myLottoNumber[a + k][n] = myLottoNumber[0][n];
            }
        }
        findLottoNumber();
    }
    public void findLottoNumber () {
        /*
        메소드 역할 : 자동,반자동,수동이 모두 로또번호를 입력하였을때
        여기에서 로또 번호를 맞춘다
        3중for문을 이용하여 Hash에서 Arraylist로 변환하였기 때문에 배열과 값을 비교하는 것이 가능하다
        그러므로 if를 통하여 resultNumber.get을 사용하여 먼저 내가 입력한 횡의 값에 맞는것이 있는지 확인하면서 for문이 작동한다
        맞는번호가 존재하는경우 correctCount변수가 1씩증가하며
        한 횡이끝났을경우 등수를 확인한다 각각의 등수에 적혀진 1차원 배열에 1씩 추가하며
        winnerAmount(누적상금) 전역변수에 등수에 따른 상금이 누적된다
         */

        for (int i = 0; i < buyLottoNumber;i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 6;k++) {

                    if (resultNumber.contains(myLottoNumber[a + j][k])) {
                        correctCount += 1; //한줄에 맞는 개수 저장
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
                }
                else if (correctCount == 2) { //4등
                    correctNumberRanking[3] += 1;
                    winnerAmount += 5000;
                }
                else { //꽝
                    correctNumberRanking[4] += 1;
                }
                correctCount = 0;
            }
            a += 5;
        }
        a = 0;
        loadResult();
    }
    public void loadResult () { //총 결과값
        /*
        메소드 역할 : 로또 당첨결과를 모두 출력한다
        만약 내가 로또를 산 가격보다 당첨금액이 많은경우 또는 그반대인경우를 대비해
        if문으로 예외처리를 하였다
         */
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
