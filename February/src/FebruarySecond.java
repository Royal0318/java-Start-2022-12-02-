import java.util.Random;
import java.util.Scanner;

public class FebruarySecond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int RandomNumberSum;
        int CorrectNumberSum = 0; //맞는 번호가 존재할때 누적시킨다
        int[] MyLottoNumberarr = new int[7]; //내가 입력한 번호를 저장
        int[] ComputerNumberarr = new int[7]; //컴퓨터가 랜덤으로 선정한 번호를 저장
        Random LottoRandom = new Random(); //랜덤값 선언

        while (true) {
            for (int i = 0; i < 6; i++) {
                int UserwhileStrat = 0;
                System.out.println("" + (i + 1) + "번째 번호를 입력해주세요 (1 ~ 40까지)");
                int Number = sc.nextInt();

                if (Number < 0 || Number > 40) {
                    System.out.println("잘못된 입력입니다!");
                    i--;
                } else {
                    if (i == 0) {
                        MyLottoNumberarr[i] = Number;
                    }
                    if (i >= 1) {
                        MyLottoNumberarr[i] = Number; //미리 값을 넣고 시작
                        while (UserwhileStrat < i) {
                            if (MyLottoNumberarr[UserwhileStrat] == MyLottoNumberarr[i]) {
                                System.out.println("중복된 값이 존재합니다 다시 입력해주세요");
                                i--;
                            }
                            UserwhileStrat++;
                        }
                    }
                }
            }
            for (int i = 0; i < 6; i++) { //컴퓨터가 랜덤으로 로또번호를 저장한다
                int ComwhileStart = 0;
                System.out.println("컴퓨터가 로또번호를 선정중입니다 잠시만 기다려주세요.........");
                RandomNumberSum = LottoRandom.nextInt(40) + 1; //Random값을 이용하여 1 ~ 40까지 범위설정

                if (i == 0) {
                    ComputerNumberarr[i] = RandomNumberSum;
                }
                if (i >= 1) {
                    ComputerNumberarr[i] = RandomNumberSum; //미리 값을 넣고 시작
                    while (ComwhileStart < i) {
                        if (ComputerNumberarr[ComwhileStart] == ComputerNumberarr[i]) {
                            i--;
                        } else {
                            if (ComputerNumberarr[i] == ComputerNumberarr[i]) {
                                CorrectNumberSum++;
                                ComwhileStart++;
                            }
                        }
                    }
                }
            }
            //로또 번호 출력
            System.out.println("\n<<<로또 번호를 공개합니다!>>>\n");
            for (int i = 0; i < 6; i++) {
                System.out.println("" + (i + 1) + "번째 숫자 : " + ComputerNumberarr[i] + "");
            }
            //당첨 결과 출력
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
            //재도전 여부 확인
            System.out.println("\n한번 더 도전하시겠습니까? \ny/n");
            String Challenge = sc.next();

            if (Challenge.equals("y") || Challenge.equals("Y")) {
                System.out.println();
            } else if (Challenge.equals("n") || Challenge.equals("N")) {
                System.out.println("시스템을 종료합니다");
                break;
            }
        }
    }
}
