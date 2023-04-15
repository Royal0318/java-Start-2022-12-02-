import java.util.Scanner;

public class Question11050a {
    //재귀적으로 풀은문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int one = sc.nextInt();
        int two = sc.nextInt();
        System.out.println((f(one,two) / twof(two)));
    }
    static int f (int one,int two) {
        if (two == 1) {
            //5C2라고 가정시 2번만돌아야하기때문에 two를가져옴
            return one;
        } else {
            return one * f(one - 1,two - 1);
        }
    }
    static int twof (int two) {
        if (two == 1) {
            return 1;
        } else {
            return two * twof(two - 1);
        }
    }
}
