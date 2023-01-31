package ObjectOrientation;

import java.util.Scanner;

public class FebruaryOne2th {
    int Total;
    FebruaryOne2th (int Total) {
        this.Total = Total;
    }
    void NumberInput () {
        int Start = 2;
        Scanner sc = new Scanner(System.in);
        System.out.println("1번째 숫자 입력");
        int FirstNumber = sc.nextInt();

        while (Start < Total) {
            System.out.println(""+Start+"번째 숫자 입력");
            int NumberInput = sc.nextInt();
            System.out.println(""+FirstNumber+" + "+NumberInput+" = "+(FirstNumber + NumberInput)+"");
            FirstNumber += NumberInput;
            Start++;
        }
        System.out.println(""+Start+"회를 도달하였으므로 시스템을 종료!");
    }
}
