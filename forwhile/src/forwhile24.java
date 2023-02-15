/*

총 ?개의 값을 받게 된다.
그리고 출력은 거꾸로 출력되게 만들어주세요.
거꾸로 출력이 완료되었다면,[그 후]
이번에는 입력 받은 값의 합을 나타내시고,
혹시라도 7이라는 숫자를 입력한 적이 있다면, 해당 7이라는 숫자가 몇 번이나 나왔는지,
7이 총 3번 이상 입력받지 않았다면, 7을 입력을 더 받아야 합니다. 라는 문구와 함께 5번의 기회가 더 주어진다.
해당 7이라는 숫자가 들어있는 배열[거꾸로 배열 기준]의 인덱스 중 중간(짝수의 경우 반올림기준) 몇 번인지를 나타내시고,
7이 나온 수만큼 더해진 값이 얼마인지 나타내보세요.

예시)

입력 1 2 3 4 5 6 7 7 8 9 10

[거꾸로]10 9 8 7 7 6 5 4 3 2 1

총 합은 62입니다.

7은 총 2번 나왔습니다.

7이 들어있는 index 중에서 중간에 위치한 index는 ?번 입니다.

7이 나온 값만큼 더한 숫자는 14입니다.
 */

import java.util.Scanner;

public class forwhile24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("총 입력받을 개수");
        int Indextotal = sc.nextInt();
        int Totalchance = 5;
        int Arrsum = 0;
        int[] arr = new int[Indextotal];

        while (true) {
            int Sevencount = 0;
            for (int i = 0; i < Indextotal; i++) {
                System.out.println("" + (i + 1) + "번째 값 입력");
                arr[i] = sc.nextInt();
                Arrsum += arr[i];
                if (arr[i] == 7) {
                    Sevencount += 1;
                }
            }
            for (int i = Indextotal; i > 0; i--) {
                System.out.println("" + i + "번째 값 : " + arr[i - 1] + "");
            }
            if (Sevencount > 3) {
                System.out.println("총 합은 : "+Arrsum+"입니다");
                System.out.println("7은 총 : "+Sevencount+"번 나왔습니다");
                System.out.println("7이 들어있는 index중에서 중간에 위치한 index는 "+(arr.length / 2)+"번 입니다");
                System.out.println("7의 총 합은 : "+(Sevencount * 7)+"입니다");
                break;
            } else {
                Totalchance -= 1;
                if (Totalchance >= 1) {
                    System.out.println("안내 : 7은 총 3번이상 나와야합니다 남은기회 : "+Totalchance+"회");
                } else {
                    System.out.println("기회를 모두 소진하였으므로 프로그램을 종료합니다");
                    break;
                }
            }
        }
    }
}
