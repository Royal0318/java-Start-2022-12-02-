import java.util.Scanner;

public class Question1476a {
    static int years = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int earth = sc.nextInt();
        int sun = sc.nextInt();
        int moon = sc.nextInt();

        int earthCount = 0;
        int sumCount = 0;
        int moonCount = 0;

        System.out.println(f(earth,sun,moon,earthCount,sumCount,moonCount));
    }
    static int f (int earth,int sun,int moon,int earthCount,int sumCount,int moonCount) {
        System.out.println(""+earthCount+"  "+sumCount+"  "+moonCount+"");
        if (earth == 1 && sun == 1 && moon == 1) {
            return 1;
        } else {
            if (earthCount == 15) {
                earthCount = 0;
            } else if (sumCount == 28) {
                sumCount = 1;
            } else if (moonCount == 19) {
                moonCount = 1;
            }
            if (earth == earthCount && sun == sumCount && moon == moonCount) {
                return 1;
            }
        }
        f(earth,sun,moon,earthCount+1,sumCount+1,moonCount+1);
        years += 1;
        //전에 스택쌓은만큼 리턴되기때문에 그 횟수를 카운트한다
        return years;
    }
}
