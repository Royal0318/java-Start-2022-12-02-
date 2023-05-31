import java.util.Random;

public class LottoProgram implements LottoInterface {
    static int[][] lotto; //로또번호
    static int[] resultNumber; //로또 당첨번호
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
        int buyNumber = sc.nextInt();

        int tempCal = (5000 * buyNumber); //로또 구매시 총 가격

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
    public void AutoProgram() {

    }
    public void semiAutoProgram () {

    }
    public void manualProgram () {

    }
}
