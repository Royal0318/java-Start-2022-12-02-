import java.io.IOException;
import java.util.Scanner;

public class Question2578 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[5][5];
        int result = 0;
        int bingoCount = 0;

        boolean check = false; //불린을 하나로만 조종할경우 동시대각이 나오면 한쪽이 카운트안되기 때문에 2개로 분리해야함
        boolean check2 = false;
        for (int i = 0; i < 5; i++) { //5X5에 값을 입력
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        while (true) {
            int isave = 0;
            int jsave = 0;
            int five = 0;
            result += 1;
            int bingoNumber = sc.nextInt();

            for (int i = 0; i < 5; i++) { //5X5에 값을 입력
                for (int j = 0; j < 5; j++) {
                    if (arr[i][j] == bingoNumber) { //같은곳을 찾은경우
                        arr[i][j] = 0; //빙고체크
                        isave = i;
                        jsave = j;
                        break;
                    }
                }
            }
            for (int i = 0; i < 5; i++) { //해당 가로줄 모두 체크
                if (arr[isave][i] == 0) { //행을 고정한다
                    five += 1;
                    if (five == 5) { //그 줄이 빙고인경우
                        bingoCount += 1; //빙고 카운트1추가
                        break;
                    }
                } else {
                    break;
                }
            }
            five = 0; //세로줄을 체크하기위해 초기화
            for (int i = 0; i < 5; i++) { //해당 세로 줄 모두체크
                if (arr[i][jsave] == 0) { //열을 고정함
                    five += 1;
                    if (five == 5) { //그 줄이 빙고인경우
                        bingoCount += 1; //빙고 카운트1추가
                        break;
                    }
                } else {
                    break;
                }
            }
            if (arr[0][0] == 0 && arr[1][1] == 0 && arr[2][2] == 0 && arr[3][3] == 0 && arr[4][4] == 0 && !check) {
                bingoCount += 1;
                check = true;
            }
            if (arr[0][4] == 0 && arr[1][3] == 0 && arr[2][2] == 0 && arr[3][1] == 0 && arr[4][0] == 0 && !check2) {
                bingoCount += 1;
                check2 = true;
            }
            if (bingoCount >= 3) {
                break;
            }
        }
        System.out.println(result);
    }
}
