import java.util.Scanner;

public class InputOutput8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1번째 수 2번재 수 각각 입력");
        int First = sc.nextInt();
        int Second = sc.nextInt();

        InputOutput9 Cal = new InputOutput9(First,Second);
        Cal.Plus();
    }
}
