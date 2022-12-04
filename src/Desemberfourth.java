import java.util.Scanner;

public class Desemberfourth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("입력받을 2개의 수를 입력해주세요");
        int num = sc.nextInt();
        int num2 = sc.nextInt();
        int total = num + num2;


        System.out.println(""+num+"+"+num2+"= ?");
        int total2 = sc.nextInt();

        if (total2 == total) {
            System.out.println("1."+num+"  2."+num2+"어느쪽이 더 큽니까?");
            int answer3 = sc.nextInt();

            if (answer3 == 1 && num > num2) {
                System.out.println("정답입니다!");
            } else if (answer3 == 1 && num < num2) {
                System.out.println("오답입니다! 정답은 2번입니다");
            } else if (answer3 == 2 && num < num2) {
                System.out.println("정답입니다!");
            } else if (answer3 == 2 && num > num2) {
                System.out.println("오답입니다! 정답은 1번입니다");
            } else if (num == num2) {
                System.out.println("둘이 같은값이라서 비교할수 없습니다");
            }
        }
        if (total2 != total) {
            System.out.println("틀렸습니다 다시해주세요");
        }
    }
}