import java.util.Random;
import java.util.Scanner;

public class Februaryoneth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] arr = new String[15];
        Random RandomArray = new Random(); //랜덤을 설정하기위한 선언
        int Number;
        //꽝의 확률이 제일 높으며 50000원을 받는 확률이 제일 낮도록 설정하였다
        arr[0] = "꽝입니다 다시 한번 도전하세요!";
        arr[1] = "꽝입니다 다시 한번 도전하세요!";
        arr[2] = "꽝입니다 다시 한번 도전하세요!";
        arr[3] = "꽝입니다 다시 한번 도전하세요!";
        arr[4] = "꽝입니다 다시 한번 도전하세요!";
        arr[5] = "꽝입니다 다시 한번 도전하세요!";
        arr[6] = "축하드립니다. '100원'입니다!";
        arr[7] = "축하드립니다. '100원'입니다!";
        arr[8] = "축하드립니다. '100원'입니다!";
        arr[9] = "축하드립니다. '100원'입니다!";
        arr[10] = "축하드려요, '1000원'에 당첨되셨습니다!";
        arr[11] = "축하드려요, '1000원'에 당첨되셨습니다!";
        arr[12] = "와! '10000원'에 당첨되셨어요!";
        arr[13] = "와! '10000원'에 당첨되셨어요!";
        arr[14] = "당신이 진정한 승리자입니다. '50000원'에 당첨되셨어요.";
        System.out.println("=====랜덤 룰렛===== \n당신의 행운에 도전하세요! \n룰렛을 돌리겠습니까? \n안내 : yes 또는 no를 입력해주세요 대,소문자 관계없음");
        String RulletStringInput = sc.next();

        if (RulletStringInput.equals("yes") || RulletStringInput.equals("Yes")) {
            while (true) {
                Number = RandomArray.nextInt(15); //랜덤값 설정
                System.out.println(""+arr[Number]+"");
                System.out.println("1.다시한번 2.종료");
                int Select = sc.nextInt();
                if (Select == 1) {
                    System.out.println("재도전!");
                } else if (Select == 2) {
                    System.out.println("시스템을 종료합니다");
                    break;
                } else {
                    System.out.println("잘못된 입력입니다!");
                }
            }
        } else if (RulletStringInput.equals("no") || RulletStringInput.equals("No")) {
            System.out.println("시스템을 종료합니다");
        } else {
            System.out.println("잘못된 입력입니다!");
        }
    }
}
