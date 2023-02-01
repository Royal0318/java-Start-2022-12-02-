import java.util.Random;
import java.util.Scanner;

public class Februaryfirst2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int RandomNumberSum;
        int CorrectNumberSum = 0; //맞는것 체크
        int[] Lottoarr = new int[7]; //내가 입력한 번호를 저장
        int[] LottoCorrectNumber = new int[7]; //컴퓨터가 랜덤으로 선정한 번호를 저장
        Random LottoRandom = new Random();

        for (int i = 0; i < 6; i++) {
            System.out.println("" + (i + 1) + "번째 번호를 입력해주세요 (1 ~ 40까지)");
            int Number = sc.nextInt();

            if (Number < 0 || Number > 40) {
                System.out.println("잘못된 입력입니다!");
                i--;
            } else {
                Lottoarr[i] = Number; //번호를 각각저장
            }
        }
        for (int i = 0; i < 6; i++) { //컴퓨터가 랜덤으로 로또번호를 저장한다
            System.out.println("컴퓨터가 로또번호를 선정중입니다 잠시만 기다려주세요.........");
            RandomNumberSum = LottoRandom.nextInt(40) + 1; //Random값을 이용하여 1 ~ 40까지 범위설정
            LottoCorrectNumber[i] = RandomNumberSum;
            if (Lottoarr[i] == LottoCorrectNumber[i]) {
                CorrectNumberSum++;
            }
        }
        //로또 번호 출력과 결과값 출력
        System.out.println("\n<<<로또 번호를 공개합니다!>>>\n");
        for (int i = 0; i < 6; i++) {
            System.out.println("" + (i + 1) + "번째 숫자 : " + LottoCorrectNumber[i] + "");
        }
        if (CorrectNumberSum == 6) {
            System.out.println("축하합니다!1등에 당첨되었습니다!");
        } else if (CorrectNumberSum == 5) {
            System.out.println("축하합니다 2등입니다");
        } else if (CorrectNumberSum == 4) {
            System.out.println("축하합니다 3등입니다");
        } else if (CorrectNumberSum == 3) {
            System.out.println("축하합니다 4등입니다");
        } else if (CorrectNumberSum == 2) {
            System.out.println("축하합니다 5등입니다");
        } else {
            System.out.println("아쉽게도 꽝입니다");
        }
    }
}
