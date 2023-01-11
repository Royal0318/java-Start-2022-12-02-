import java.util.Scanner;

public class Januaryeleventh {
    public static void main(String[] args) {
        if (End() == 0) {
            System.exit(1);
        }
    }

    public static int End() {
        Scanner sc = new Scanner(System.in);
        int Number = 0;
        System.out.println("총 개수");
        int ArrayNumber = sc.nextInt();
        return MenuSelect(Number, ArrayNumber);
    }

    public static int MenuSelect(int Number, int ArrayNumber) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[ArrayNumber];

        System.out.println("1.더하기  2.빼기  3.특정 값 호출");
        int Select = sc.nextInt();

        if (Select == 1) {
            return Plus(arr, Number, ArrayNumber,Select);
        }
        if (Select == 2) {
            return Minus(arr, Number, ArrayNumber,Select);
        }
        if (Select == 3) {
            return NumberCall(arr, Number, ArrayNumber,Select);
        }
        return 0;
    }

    public static int Plus(int[] arr, int Number, int ArrayNumber,int Select) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 입력");
        Number = sc.nextInt();
        return Cal(arr,Number,ArrayNumber,Select);
    }

    public static int Minus(int[] arr, int Number, int ArrayNumber,int Select) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 입력");
        Number = sc.nextInt();
        return Cal(arr,Number,ArrayNumber,Select);
    }

    public static int NumberCall(int[] arr, int Number, int ArrayNumber,int Select) {
        Scanner sc = new Scanner(System.in);
        System.out.println("특정 값 입력");
        Number = sc.nextInt();
        return Cal(arr,Number,ArrayNumber,Select);
    }

    public static int Cal(int[]arr,int Number,int ArrayNumber,int Select) {
        for (int i = 1; i <= ArrayNumber; i++) {

            if (Select == 1) {
                arr[i] = arr[i - 1] + Number;
            } else if (Select == 2) {
                arr[i] = arr[i - 1] - Number;
            } else if (Select == 3) {
                arr[i] = Number;
            }
            for (int j = 0; j <= i; j++) {
                System.out.println("" + (j + 1) + "번째 숫자 : " + arr[j] + "");
            }
            MenuSelect(Number,ArrayNumber);
        }
        return 0;
    }
}