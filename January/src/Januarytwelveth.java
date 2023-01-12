import java.util.Scanner;

public class Januarytwelveth {
    public static void main(String[] args) {
        if (End() == 0) {
            System.exit(1);
        }
    }

    public static int End() {
        Scanner sc = new Scanner(System.in);
        int Number = 0;
        int Count = 0;
        System.out.println("총 개수");
        int Index = sc.nextInt();
        int [] arr = new int[Index];
        return MenuSelect(arr,Number, Index,Count);
    }

    public static int MenuSelect(int[]arr,int Number, int Index,int Count) {
        Scanner sc = new Scanner(System.in);
        /*
        for문을돌게하려면 i값과index가 같이리턴받고 arr값도 같이 넘어가야 한번돌때 초기화되지 않는다
         */

        for (int i = (1+Count); i <= Index; i++) {
            if (i == Index) { //시스템 종료
                return 0;
            }
            System.out.println("1.더하기  2.빼기  3.특정 값 호출");
            int Select = sc.nextInt();

            if (Select == 1) {
                return Plus(arr, Number, Index,i,Count);
            }
            if (Select == 2) {
                return Minus(arr, Number, Index,i,Count);
            }
            if (Select == 3) {
                return NumberCall(arr, Number, Index,i,Count);
            }
        }
        return 0;
    }

    public static int Plus(int[] arr, int Number, int Index,int i,int Count) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 입력");
        Number = sc.nextInt();
        arr[i] = arr[i - 1] + Number;
        return Cal(arr, Number, Index,i,Count);
    }

    public static int Minus(int[] arr, int Number, int Index,int i,int Count) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 입력");
        Number = sc.nextInt();
        arr[i] = arr[i - 1] - Number;
        return Cal(arr, Number, Index,i,Count);
    }

    public static int NumberCall(int[] arr, int Number, int Index,int i,int Count) {
        Scanner sc = new Scanner(System.in);
        System.out.println("특정 값 입력");
        Number = sc.nextInt();
        arr[i] = Number;
        return Cal(arr, Number, Index,i,Count);
    }

    public static int Cal(int[] arr, int Number, int Index,int i,int Count) {
        for (int j = 0; j <= i; j++) {
            System.out.println("" + (j + 1) + "번째 숫자 : " + arr[j] + "");
        }
        Count++;
        return MenuSelect(arr,Number, Index,Count); //수정
    }
}