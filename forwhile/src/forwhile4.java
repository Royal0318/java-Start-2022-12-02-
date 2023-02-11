import java.util.Scanner;

public class forwhile4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int whilestart = 1;
        System.out.println("총 반복횟수");
        int whilenum = sc.nextInt();
        System.out.println("1번째 숫자 입력");
        int Num = sc.nextInt();
        forwhile5 whiletest = new forwhile5(whilenum,Num);
        whiletest.Cal(whilestart);
    }
}
