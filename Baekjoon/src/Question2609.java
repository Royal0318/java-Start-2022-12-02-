import java.util.Scanner;

public class Question2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int small = (x * y);
        System.out.println(""+f(x, y)+"\n"+(small/f(x, y))+"");
        //리턴조건에 만족한경우 x값을 리턴한다 x값은 y이며 그값은 2이기때문에 2를 리턴 그값이 최대공약수가 된다
    }
    static int f(int x,int y) {
        //유클리드 호재법을 사용
        if (y == 0) {
            return x;
        } else {
            return f(y, (x%y));
        }
        /*
        y값이 0이라면 2개의값이 0이되기위해서는 당연히 최대공약수는 x값이 되어야한다
        만약 else라면 유클리드 호재법을 이용해 나머지가 0이나올때까지 재귀를 계속반복한다
        예를들면 22,8이라고 하였을경우 몫은 2가 되고 나머지는 6이된다
        y는 8이되며 (x%y) = 6 두개의숫자가 다시 재귀를 반복하여 0이나올때까지 반복
         */
    }
}
