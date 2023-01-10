import java.util.Scanner;

public class Januaryteenth {
    public static void main(String[] args) { //출력이니까
        if (End() == 0) {
            System.exit(1);
        }
    }

    public static int End() {
        Scanner sc = new Scanner(System.in);
        int Number = 0;
        System.out.println("몇개까지 있다고 할까요?");
        int ArrayNumber = sc.nextInt();
        return SelectMenu(ArrayNumber,Number);
    }

    public static int SelectMenu(int ArrayNumber,int Number) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= ArrayNumber; i++) {
            System.out.println("test "+i+"");

            if (i == ArrayNumber) { //시스템 종료조건
                return 0;
            }

            System.out.println("1.더하기  2.빼기  3.특정 값 불러오기");
            int Select = sc.nextInt();

            if (Select == 1) {
                return Plus(Select,Number, ArrayNumber,i);
            }
            if (Select == 2) {
                return Minus(Select,Number,ArrayNumber,i);
            }
            if (Select == 3) {
                return Number(Select,Number, ArrayNumber,i);
            }
        }
        return 0;
    }

    public static int Plus(int Select,int Number, int ArrayNumber,int i) {
        Scanner sc = new Scanner(System.in);
            System.out.println("숫자 입력");
            Number = sc.nextInt();
            return NumberInPut(Select, ArrayNumber, Number, i);
    }

    public static int Minus(int Select,int Number, int ArrayNumber,int i) {
        Scanner sc = new Scanner(System.in);
            System.out.println("숫자 입력");
            Number = sc.nextInt();
            return NumberInPut(Select, ArrayNumber, Number, i);
    }

    public static int Number(int Select,int Number, int ArrayNumber,int i) {
        Scanner sc = new Scanner(System.in);
            System.out.println("특정 값 입력");
            Number = sc.nextInt();
            return NumberInPut(Select, ArrayNumber, Number, i);
    }

    public static int NumberInPut(int Select, int ArrayNumber, int Number, int i) {
        int[] arr = new int[ArrayNumber];
        if (Select == 1) {
            arr[i] = arr[i - 1] + Number;
        }
        if (Select == 2) {
            arr[i] = arr[i - 1] - Number;
        }
        if (Select == 3) {
            arr[i] = Number;
        }
        for (int j = 0; j <= i; j++) {
            System.out.println("" + (j + 1) + "번째 숫자 : " + arr[j] + "");
        }
        return SelectMenu(ArrayNumber,Number);
    }
}
