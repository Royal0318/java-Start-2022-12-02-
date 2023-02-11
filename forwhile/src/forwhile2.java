import java.util.Scanner;

public class forwhile2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("총 반복 횟수");
        int Repetition = sc.nextInt();

        System.out.println("1번째 숫자 입력");
        int First = sc.nextInt();
        for (int i = 1; i < Repetition;i++) {
            System.out.println(""+(i + 1)+"번째 숫자 입력");
            int Second = sc.nextInt();
            System.out.println(""+First+" + "+Second+" = "+(First + Second)+"");
            First += Second;
        }
        System.out.println("목표 횟수에 도달하였으므로 프로그램을 종료합니다");
    }
}
