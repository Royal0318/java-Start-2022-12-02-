package ObjectOrientation;

import java.util.Scanner;

public class FebruaryOneth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇개의 숫자를 받으시겠습니까?");
        int Total = sc.nextInt();
        FebruaryOne2th TotalControl = new FebruaryOne2th(Total);
        TotalControl.NumberInput();
    }
}
