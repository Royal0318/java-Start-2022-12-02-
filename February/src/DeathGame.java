
import java.util.Random;
import java.util.Scanner;
public class DeathGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random Test = new Random(); //랜덤 선언
        int LastPeople = 10; //남은사람 Check
        int[] People = new int[10]; //전체사람 index
        int[] Death = new int[10]; //탈락한사람 index
        System.out.println("게임 룰 설명 : 총 10명의 사람이 게임에 참가합니다 \n1부터 100까지 랜덤의 숫자를 부여받습니다 \n만약 자신이 4라는 숫자를 부여받은경우 탈락! \n끝까지 살아남는사람이 우승!\n");
        for (int i = 0; i < 100; i++) {
            System.out.println("" + (i + 1) + "회전 게임 시작 \n1.나눠주기 2.현재까지 생존자 확인 3.게임 종료");
            int Choice = sc.nextInt();

            if (Choice == 1) {
                for (int j = 0; j < 10; j++) {
                    if (Death[j] == 0) { //탈락하지 않은 사람만 부여
                        People[j] = Test.nextInt(20) + 1;
                        if (People[j] == 4) {
                            System.out.println("탈락자 발생!!!! \n<<<4가 나왔으므로 " + (j + 1) + "번째 사람은 탈락!>>>\n");
                            Death[j] += 1; //해당사람 탈락 표시
                            LastPeople -= 1;
                        }
                    }
                }
            } else if (Choice == 2) {
                System.out.println("<<<현재까지 생존자>>>\n");
                i--;
            } else if (Choice == 3) {
                System.out.println("시스템을 종료합니다");
                System.exit(1);
            } else {
                System.out.println("잘못된 입력입니다");
            }
            System.out.println("<<<" + (i + 1) + "회전이 종료되었습니다 각각의 부여받은 값을 공개합니다>>>\n");

            for (int j = 0; j < 10; j++) {
                if (Death[j] == 0 && LastPeople > 1) { //Death가 1인사람은 출력되지 않으며 LastPeople 즉 생존자만 출력되도록함
                    System.out.println("" + (j + 1) + "번째 : " + People[j] + "");
                } else if (Death[j] == 0 && LastPeople == 1) {
                    System.out.println("축하합니다!!!! 우승자는 "+(j + 1)+"번 입니다! \n우승자가 정해졌으므로 시스템을 종료합니다");
                    System.exit(1);
                }
            }
        }
    }
}

