import java.util.Scanner;

public interface LottoInterface  {
    Scanner sc = new Scanner(System.in);
    int lottoMaxNumber = 6; //최대 6까지 입력가능하다

    void inputMyMoney ();

    void buyLotto();
    void randomResultNumber();

    void inputMyInputNumber();

}
