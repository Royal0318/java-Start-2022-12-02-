import java.util.Scanner;

public class whilefunction {
    public static void main(String[] args) {
        System.out.println("정답입니다! 가장 큰 값은 "+End()+"입니다");
    }
    public static int End () {
        int LargeNumber = 0;
        int Start = 1;
        return whileInPut(LargeNumber,Start);
    }
    public static int whileInPut (int LargeNumber,int Start) {
        Scanner sc = new Scanner(System.in);
        int Chance = 5;

        while (Start <= 10) { //while문으로 10개를 숫자를 입력받으며 각각의 수를 비교하여 가장 큰수를 저장한다
            System.out.println(""+Start+"번째 숫자 입력");
            int Number = sc.nextInt();
            if (LargeNumber < Number) {
                LargeNumber = Number;
            }
            Start++;
        }
        return NumberInPut(LargeNumber,Chance);
    }
    public static int NumberInPut (int LargeNumber,int Chance) {
        Scanner sc = new Scanner(System.in);
        System.out.println("가장 큰 숫자는?");
        int Answer = sc.nextInt();
        return Chance(Chance,LargeNumber,Answer);
    }
    public static int Chance (int Chance,int LargeNumber,int Answer) {
        if (Answer != LargeNumber) {
            Chance -= 1;
            if (Chance >= 1) { //1회 틀릴때마다 기회가 차감되며 찬스를 다시 리턴시켜 재질문
                System.out.println("남은 기회 "+Chance+"회");
                return NumberInPut(LargeNumber,Chance);
            } else if (Chance == 0) {
                System.out.println("게임오버!");
                System.exit(1); //기회를 모두 소진시 강제 종료
            }
        } else {
            return LargeNumber; //가장 큰 값과 입력한 값이 일치할때 가장 큰 값을 리턴시켜 시스템종료
        }
        return 0;
    }
}
