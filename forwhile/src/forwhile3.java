import java.util.Scanner;

public class forwhile3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("반복 횟수를 적어주세요");
        int Repetition = sc.nextInt();
        int[] arr = new int[Repetition];

        for (int i = 0; i < Repetition;i++) {
            System.out.println(""+(i + 1)+"번째 숫자입력");
            int Number = sc.nextInt();
            arr[i] += Number;
            /*
            2개의 숫자를 더해야 하기때문에 i가 1부터 시작하면 index 0과 1을 더해서 구할수 있다
            첫번째 값과 2번째 값을 더하여 2번재 arr[i - 1]을 가장 최신 index에 더해줌으로써 반복적으로 돌릴수 있다
            */
            if (i >= 1) {
                System.out.println(""+arr[i - 1]+" + "+arr[i]+" = "+(arr[i - 1] + arr[i])+"");
                arr[i] += arr[i - 1];
            }
        }
        System.out.println("목표 횟수에 도달하였으므로 프로그램을 종료합니다");
    }
}
