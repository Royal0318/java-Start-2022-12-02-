/*
이 문제는 반복문을 얼마나 잘 기억하고 있는지 테스트 하는 문제이다
문)당신은 프리랜서입니다 은행에서 근무하는 한 은행원이 은행프로그램을 간단하게 만들어 달라는 요청이 왔습니다
당신은 은행원의 조건에 맞게 프로그램을 만들어야합니다

처음에 개인정보들을 입력받습니다
나이(1세 ~ 200세),성별(남,여 그외에는x),전화번호(010을 제외한 8자리)
,주민등록번호(앞6자리),카드비밀번호(4자리)를 순서대로 입력받습니다
단,나이 부터 주민등록번호까지 한번이라도 틀린경우 처음부터 다시 진행되도록 설계해주세요
처음에 주민등록번호를 입력할 때 6자리를 입력받게 하고 만약에 입력한 숫자가 6자리가 안된다면 3번의 기회를 주고
프로그램을 종료시키세요
단 종료시키기 전에 입력한숫자가 6자리보다 안되면 마지막 기회 1회 6자리보다 크게 입력시 기회를 2번 더 제공합니다
기회는 누적됩니다
만약 주민등록번호가 일치할 경우 카드번호 4자리를 입력 할 수 있게 하세요 이 역시 4자리가 되지 않는다면
3번의 기회를 주고 프로그램을 종료시키세요
그 후 1.계좌 조회. 2.계좌 입금 3.계좌 출금이 가능하도록 설정해주시고
단, 처음에 2번과 3번을 입력할 시 [처음에는 계좌 조회만 가능합니다.]라는 문구가 나타나게 해주세요
1번을 입력할 경우 계좌에 얼마가 들어있는지 나오게 하고 그 상황에서 다시 첫번째 상황으로 이동 할 수 있게 해주세요
첫 번째 상황으로 이동했다면 1번을 누를시 [계좌조회는 1회만 가능합니다]라고 나와야하며 2,3번만 입력이 가능하도록 해주세요
2번을 입력시 금액을 입금할 수 있게 하고 이는 출금과 연관 지어야 합니다
3번을 누를 시 계좌에서 돈을 뺄 수 있지만 가지고 있는 돈 보다 많이 출금 할 시 잔액이 부족하다는 문구가 뜨게 해주세요
주의조건) 현문제에서 반복문은 총 3번만 사용가능하며 최대한 코드를 간결하게 작성 해주세요
for문,while문 모두 사용 가능합니다
 */
import java.util.Scanner;
public class Decemberseventeenth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int count2 = 0;
        int Chance = 3;
        while (true) {
            if (count == 0) {
                System.out.println("나이를 입력하세요 (1세 ~ 200세)");
                int Old = sc.nextInt();
                if (Old <= 0 || Old > 200) {
                    System.out.println("");
                } else {
                    count = 1;
                }
            }
            if (count == 1) {
                System.out.println("성별을 입력하세요 (1.남  2.여)");
                int Sex = sc.nextInt();
                if (Sex <= 0 || Sex > 2) {
                    System.out.println("");
                } else {
                    count = 2;
                }
            }
            if (count == 2) {
                System.out.println("전화번호를 입력하세요 (010을 제외한 8자리)");
                int PhoneNumber = sc.nextInt();
                if (PhoneNumber < 10000000 || PhoneNumber > 99999999) {
                    System.out.println("");
                } else {
                    count = 3;
                }
            }
            if (count == 3) {
                System.out.println("주민등록번호를 입력하세요 (앞6자리)");
                int PersonalNumber = sc.nextInt();

                if (PersonalNumber < 100000) {
                    Chance -= 1;
                    if (Chance >= 1) {
                        System.out.println("주민등록번호를 다시 입력해주세요 남은기회 : " + Chance + "회");
                    } else if (Chance == 0) {
                        System.out.println("\n마지막 기회입니다");
                    } else {
                        System.out.println("제한 횟수 초과!");
                        return;
                    }
                }
            }
            count = 0;
        }
    }
}

