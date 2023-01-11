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

        for (int i = 1; i <= ArrayNumber; i++) {
            System.out.println("1.더하기  2.빼기  3.특정 값 호출");
            int Select = sc.nextInt();

            if (Select == 1) {
                return Plus(arr, Number, ArrayNumber, i);
            }
            if (Select == 2) {
                return Minus(arr, Number, ArrayNumber, i);
            }
            if (Select == 3) {
                return NumberCall(arr, Number, ArrayNumber, i);
            }
        }
        return 0;
    }

    public static int Plus(int[] arr, int Number, int ArrayNumber, int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 입력");
        Number = sc.nextInt();
        arr[i] = arr[i - 1] + Number;
        return Calculation(arr, Number, ArrayNumber, i);
    }

    public static int Minus(int[] arr, int Number, int ArrayNumber, int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 입력");
        Number = sc.nextInt();
        arr[i] = arr[i - 1] - Number;
        return Calculation(arr, Number, ArrayNumber, i);
    }

    public static int NumberCall(int[] arr, int Number, int ArrayNumber, int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("특정 값 입력");
        Number = sc.nextInt();
        arr[i] = Number;
        return Calculation(arr, Number, ArrayNumber, i);
    }

    public static int Calculation(int[] arr, int Number, int ArrayNumber, int i) {
        for (int j = 0; j <= i; j++) {
            System.out.println("" + (j + 1) + "번째 숫자 : " + arr[j] + "");
        }
        return MenuSelect(Number, ArrayNumber);
    }
}