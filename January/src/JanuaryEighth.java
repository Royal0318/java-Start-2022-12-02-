/*
본 문제는 function사용,while문사용이 필수인 문제입니다
문) 총 10개의 숫자를 입력 받습니다.
해당 10개의 숫자중에서 가장 큰 숫자를 맞출 수 있는 프로그램을 개발할 것 입니다
만약 해당 10개의 숫자중에서 가장 큰 숫자를 맞추지 못했다면 총 5번의 기회가 부여됩니다
기회가 카운트되는 도중에 정답을 맞췄을경우 종료
기화안에서 정답을 맞추지 못했다면 종료
다만 여기서 중요한 것은 기회의 개념과 제일 처음에 맞추는것과 다른 코드로 반영이 되어야합니다
 */
import java.util.Scanner;
public class JanuaryEighth {
    public static void main(String[] args) { //최종출력
        System.out.println("정답입니다! 가장 큰 값은 "+End()+" 입니다");
    }
    public static int End () {
        Scanner sc = new Scanner(System.in);
        int Chance = 5;
        int Start = 1;
        int Large = 0;

        while (Start <= 10) {
            System.out.println(""+Start+"번째 숫자");
            int Number = sc.nextInt();
            if (Large < Number) {
                Large = Number;
            }
            Start++;
        }
        return TotalNumber(Large,Chance);
    }
    public static int TotalNumber (int Large,int Chance) {
        Scanner sc = new Scanner(System.in);
            System.out.println("가장 큰 값은?");
            int Number = sc.nextInt();
            return ChanceNumber(Number,Large,Chance);
    }
    public static int ChanceNumber (int Number,int Large,int Chance) { //기회
        if (Large != Number) {
            Chance -= 1;
            if (Chance >= 1) {
                System.out.println("남은기회 " + Chance + "회");
                return TotalNumber(Large,Chance);
            } else {
                System.out.println("게임오버!");
                System.exit(1);
            }
        } else { //정답을 맞췄을경우 가장 큰 값을 맨위로 리턴시킴
            return Large;
        }
        return 0;
    }
}
