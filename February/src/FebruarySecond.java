import java.util.Random;
import java.util.Scanner;

public class FebruarySecond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int RandomNumberSum;
        int[] CorrectNumberSum = new int[5]; //맞는 번호가 존재할때 누적시킨다
        int[][] MyLottoNumberarr = new int[5][6]; //내가 입력한 번호를 저장
        int[][] ComputerNumberarr = new int[5][6]; //컴퓨터가 랜덤으로 선정한 번호를 저장
        Random LottoRandom = new Random(); //랜덤값 선언

        while (true) {
            for (int i = 0; i < 5; i++) {
                System.out.println("[" + (i + 1) + "번 수동]");
                for (int j = 0; j < 6; j++) {
                    int UserwhileStrat = 0;
                    System.out.println("" + (j + 1) + "번째 번호를 입력해주세요 (1 ~ 40까지)");
                    int Number = sc.nextInt();

                    if (Number < 0 || Number > 40) {
                        System.out.println("잘못된 입력입니다!");
                        j--;
                    } else {
                        if (j == 0) {
                            MyLottoNumberarr[i][j] = Number;
                        }
                        if (j >= 1) {
                            MyLottoNumberarr[i][j] = Number; //미리 값을 넣고 시작
                            while (UserwhileStrat < j) { //while을 사용하여 중복된 값을 구별하기 위한 작업
                                if (MyLottoNumberarr[i][UserwhileStrat] == MyLottoNumberarr[i][j]) {
                                    System.out.println("중복된 값이 존재합니다 다시 입력해주세요");
                                    j--;
                                }
                                UserwhileStrat++;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("컴퓨터가 로또번호를 선정중입니다 잠시만 기다려주세요.........");
                for (int j = 0; j < 6; j++) { //컴퓨터가 랜덤으로 로또번호를 저장한다
                    int ComwhileStart = 0;
                    RandomNumberSum = LottoRandom.nextInt(40) + 1; //Random값을 이용하여 1 ~ 40까지 범위설정

                    if (j == 0) {
                        ComputerNumberarr[i][j] = RandomNumberSum;
                    } else {
                        ComputerNumberarr[i][j] = RandomNumberSum;
                        while (ComwhileStart < j) {
                            if (ComputerNumberarr[i][ComwhileStart] == ComputerNumberarr[i][j]) {
                                ComputerNumberarr[i][j] -= RandomNumberSum; //중복된 숫자를 뽑았을때 초기화시킨다
                                j--;
                            }
                            ComwhileStart++;
                        }
                    }
                }
            }
            //유저가 입력한 번호와 컴퓨터가 입력한번호를 대조하여 맞는번호가 존재시 CorrectNumberSum에 누적시킴
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    for (int k = 0; k < 6; k++) {
                        System.out.println("" + i + " " + k + " =  " + i + " " + j + "");
                        if (ComputerNumberarr[i][k] == MyLottoNumberarr[i][j]) {
                            CorrectNumberSum[i] += 1;
                        }
                    }
                }
            }
            //로또 번호 출력
            System.out.println("\n<<<로또 번호를 공개합니다!>>>\n");
            for (int i = 0; i < 5; i++) {
                System.out.println("[" + (i + 1) + "번 수동]");
                for (int j = 0; j < 6; j++) {
                    System.out.printf("[" + ComputerNumberarr[i][j] + "]");
                }
                System.out.println();
            }
            //당첨 결과 출력
            for (int i = 0; i < 5; i++) {
                System.out.println("=========[" + (i + 1) + "번 수동]=========");
                System.out.println(""+CorrectNumberSum[i]+"");
                if (CorrectNumberSum[i] == 6) {
                    System.out.println("축하합니다!1등에 당첨되었습니다!");
                } else if (CorrectNumberSum[i] == 5) {
                    System.out.println("축하합니다 2등입니다");
                } else if (CorrectNumberSum[i] == 4) {
                    System.out.println("축하합니다 3등입니다");
                } else if (CorrectNumberSum[i] == 3) {
                    System.out.println("축하합니다 4등입니다");
                } else if (CorrectNumberSum[i] == 2) {
                    System.out.println("축하합니다 5등입니다");
                } else {
                    System.out.println("아쉽게도 꽝입니다");
                }
            }
            //재도전 여부 확인
            while (true) {
                System.out.println("\n한번 더 도전하시겠습니까? \ny/n");
                String Challenge = sc.next();

                if (Challenge.equals("y") || Challenge.equals("Y")) {
                    for (int i = 0 ; i < 5 ; i++) {
                        CorrectNumberSum[i] = 0;
                    }
                    //초기화시키고 탈출
                    break;
                } else if (Challenge.equals("n") || Challenge.equals("N")) {
                    System.out.println("시스템을 종료합니다");
                    return;
                } else {
                    System.out.println("잘못된 입력입니다");
                }
            }
        }
    }
}
