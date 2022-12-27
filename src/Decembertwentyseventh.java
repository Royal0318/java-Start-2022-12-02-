import java.util.Scanner;
public class Decembertwentyseventh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Chance = 5;
        System.out.println("몇개의 값을 입력 받으시겠습니까?");
        int Input = sc.nextInt();

        int [] arr = new int[Input];

        while (true) {
            int NumberSum = 0;
            int SevenCount = 0;
            int SevenSum = 0;
            for (int i = 0; i < Input; i++) {
                System.out.println("값을 입력해주세요");
                arr[i] = sc.nextInt();
                NumberSum += arr[i];
                if (arr[i] == 7) {
                    SevenCount++;
                    SevenSum += arr[i];
                }
            }
            for (int i = (arr.length - 1); i > 0; i--) {
                System.out.println(""+arr[i]+"");
            }
            System.out.println("입력한 값의 총 합은 " + NumberSum + "입니다");
            System.out.println("숫자 7은 총 " + SevenCount + "회 나왔습니다");
            System.out.println("숫자 7이 들어있는 Index중에서 중간에 위치한 Index는 "+(arr.length/2)+"번 입니다");
            System.out.println("숫자 7을 모두 더한 값은 "+SevenSum+"입니다");
            if (SevenCount < 3) {
                if (Chance >= 1) {
                    Chance--;
                    System.out.println("숫자 7은 총 3번이상 입력해야 합니다 (남은기회 " + Chance + "회)");
                } else {
                    System.out.println("기회를 모두 소진하였습니다");
                    return;
                }
            } else {
                return;
            }
        }
    }
}
