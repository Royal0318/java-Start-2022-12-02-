import java.util.Scanner;
public class Question14697 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int room1 = sc.nextInt();
        int room2 = sc.nextInt();
        int room3 = sc.nextInt();
        int people = sc.nextInt();
        int output = 0;

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                for (int k = 0; k < 50; k++) {
                    if ((room1 * i) + (room2 * j) + (room3 * k) == people) {
                        System.out.println("i값 : "+i+"");
                        System.out.println("j값 : "+j+"");
                        System.out.println("k값 : "+k+"");
                        //3중포문을 통해 모든 경우의수를 탐색한다
                        output = 1;
                        break;
                    }
                }
            }
        }
        if (output == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
