import java.util.Random;
import java.util.Scanner;

public class lotto {
    static Random random;
    static int[] lottoNumber;
    static int[][] num;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        random = new Random();
        lottoNumber = new int[6];
        num = new int[5][6];

        while (true) {
            for (int i = 0; i < 6;i++) {
                lottoNumber[i] = random.nextInt(45) + 1; //1 ~ 45번까지 랜덤번호를 배열값에 저장
            }
            System.out.println("1.프로그램 시작 2.시스템 종료");
            int menuChoice = sc.nextInt();

            if (menuChoice == 1) {
                for (int i = 0; i < 5;i++) {
                    for (int j = 0; j < 6;j++) {
                        num[i][j] = random.nextInt(45) + 1;
                    }
                }
                lotto();
            } else if (menuChoice == 2) {
                System.out.println("시스템을 종료합니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
    public static void lotto () {
        sb = new StringBuilder();
        System.out.println("당첨 번호 : ["+lottoNumber[0]+"] ["+lottoNumber[1]+"] ["+lottoNumber[2]+"] ["+lottoNumber[3]+"] ["+lottoNumber[4]+"] ["+lottoNumber[5]+"]");
        for (int i = 0; i < 5 ;i ++) {
            char str = (char)(i+65);
            System.out.println(""+str+"자동 : ["+num[i][0]+"] ["+num[i][1]+"] ["+num[i][2]+"] ["+num[i][3]+"] ["+num[i][4]+"] ["+num[i][5]+"]");
        }

        for (int i = 0; i < 5;i++) {
            int correctNumber = 0; //맞춘 번호 개수
            char str = (char)(i+65); //A,B,C,D,E 출력을 위한 형변환 (int 형 ---> 알파벳)

            for (int j = 0; j < 6;j++) {
                if (lottoNumber[i] == num[i][j]) {
                    correctNumber += 1;
                }
            }
            if (correctNumber == 6) {
                sb.append(str).append("자동 : ").append("1등").append("\n");
            } else if (correctNumber == 5) {
                sb.append(str).append("자동 : ").append("2등").append("\n");
            } else if (correctNumber == 4) {
                sb.append(str).append("자동 : ").append("3등").append("\n");
            } else if (correctNumber == 3) {
                sb.append(str).append("자동 : ").append("4등").append("\n");
            } else if (correctNumber == 2) {
                sb.append(str).append("자동 : ").append("5등").append("\n");
            } else {
                sb.append(str).append("자동 : ").append("꽝").append("\n");
            }
        }
        System.out.println("=================결과=================");
        System.out.println(sb);
    }
}
