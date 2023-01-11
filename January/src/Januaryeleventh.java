import java.util.Scanner;

public class Januaryeleventh {
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
        return MenuSelect(Number, ArrayNumber);
    }
    public static int MenuSelect(int Number, int ArrayNumber) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= ArrayNumber; i++) {
            System.out.println("i값 테스트 "+i+"");

            if (i == ArrayNumber) { //시스템 종료조건
                return 0;
            }
            System.out.println("1.더하기  2.빼기  3.특정 값 불러오기");
            int Select = sc.nextInt();

            if (Select == 1) {
                return Plus(Number, ArrayNumber, Select,i);
            }
            if (Select == 2) {
                return Minus(Number, ArrayNumber, Select,i);
            }
            if (Select == 3) {
                return Number(Number, ArrayNumber, Select,i);
            }
        }
        return 0;
    }

    public static int Plus(int Number, int ArrayNumber, int Select,int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 입력");
        Number = sc.nextInt();
        return NumberInPut(Number, ArrayNumber, Select,i);
    }

    public static int Minus(int Number, int ArrayNumber, int Select,int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 입력");
        Number = sc.nextInt();
        return NumberInPut(Number, ArrayNumber, Select,i);
    }

    public static int Number(int Number, int ArrayNumber, int Select,int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("특정 값 입력");
        Number = sc.nextInt();
        return NumberInPut(Number, ArrayNumber, Select,i);
    }

    public static int NumberInPut(int Number, int ArrayNumber, int Select,int i) {
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
        return MenuSelect(Number, ArrayNumber);
    }
}
