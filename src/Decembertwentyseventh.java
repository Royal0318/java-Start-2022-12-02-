/*
문) 총?개의 값을 입력받을건지 적어주시고
출력값은 거꾸로 출력되도록 만들어주세요
거꾸로 출력이 완료되었다면 입력한 값의 합을 나타내주시고
혹시라도 7이라는 숫자를 입력한적이 있다면 해당 7이라는 숫자가 3번이상 입력되지 않았다면 5번의 기회를 주세요
기회를 모두 소진하였다면 프로그램을 종료합니다
그 후 7이라는 숫자가 들어있는 모든 배열의 중간 Index번호는 몇번인지 나타내고
7이 나온 수만큼 더해진 값이 얼마인지 나타내는 코드를 작성해주세요
 */
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
