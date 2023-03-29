import java.util.Scanner;

public class Question1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int earth = sc.nextInt();
        int sun = sc.nextInt();
        int moon = sc.nextInt();

        int earthCount = 0;
        int sunCount = 0;
        int moonCount = 0;
        int year = 1;

        while (true) {
            earthCount += 1;
            sunCount += 1;
            moonCount += 1;

            if (earthCount == 16) {
                earthCount = 1;
            }
            if (sunCount == 29) {
                sunCount = 1;
            }
            if (moonCount == 20) {
                moonCount = 1;
            }
            if (earthCount == earth && sunCount == sun && moonCount == moon) {
                break;
            }
            year += 1;
        }
        System.out.println(year);
    }
}
