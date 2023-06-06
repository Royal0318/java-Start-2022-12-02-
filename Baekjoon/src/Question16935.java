import java.util.Scanner;

public class Question16935 {
    static int rowCut;
    static int colCut;
    static int[][] arr;
    static int[][] copy;
    static int row;
    static int col;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        row = sc.nextInt(); //행

        col = sc.nextInt(); //열

        int R = sc.nextInt(); //연산횟수

        arr = new int[row][col];

        for (int i = 0; i < row; i++) { //행렬입력
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < R; k++) {
            int R2 = sc.nextInt();
            switch (R2) {
                case 1:
                    test1();
                    break;
                case 2:
                    test2();
                    break;
                case 3:
                    test3();
                    break;
                case 4:
                    test4();
                    break;
                case 5:
                    test5();
                    break;
                default:
                    test6();
                    break;
            }
        }
        for (int i = 0; i < row; i++) { //정답출력
            for (int j = 0; j < col; j++) {
                System.out.print("" + arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void test1() {
        copy = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copy[row - 1 - i][j] = arr[i][j];
            }
        }
        arr = copy;
    }

    public static void test2() {
        copy = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copy[i][col - 1 - j] = arr[i][j];
            }
        }
        arr = copy;
    }

    public static void test3() {
        copy = new int[col][row];
        int temp = row - 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copy[j][temp] = arr[i][j];
            }
            temp -= 1;
        }
        int temp2 = row;
        row = col;
        col = temp2;

        arr = copy;
    }

    public static void test4() {
        copy = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copy[col - 1 - j][i] = arr[i][j];
            }
        }
        int temp = row;
        row = col;
        col = temp;

        arr = copy;
    }

    public static void test5() {
        copy = new int[row][col];

        rowCut = row / 2; // 3
        colCut = col / 2; // 4

        for (int i = 0; i < rowCut; i++) { //1 -> 2
            for (int j = 0; j < colCut; j++) {
                copy[i][j + colCut] = arr[i][j];
            }
        }

        for (int i = 0; i < rowCut; i++) { //2 -> 3
            for (int j = colCut; j < col; j++) {
                copy[rowCut + i][j] = arr[i][j];
            }
        }
        for (int i = rowCut; i < row; i++) { //3 -> 4
            int temp = 0;
            for (int j = colCut; j < col; j++) {
                copy[i][temp] = arr[i][j];
                temp += 1;
            }
        }

        int temp = 0;
        for (int i = rowCut; i < row; i++) { //4 -> 1
            for (int j = 0; j < colCut; j++) {
                copy[temp][j] = arr[i][j];
            }
            temp += 1;
        }
        arr = copy;
    }

    public static void test6() {
        copy = new int[row][col];

        rowCut = row / 2; // 3
        colCut = col / 2; // 4

        for (int i = 0; i < rowCut; i++) { //1 -> 4
            for (int j = 0; j < colCut; j++) {
                copy[rowCut + i][j] = arr[i][j];
            }
        }
        for (int i = rowCut; i < row; i++) { //4 -> 3
            for (int j = 0; j < colCut; j++) {
                copy[i][colCut + j] = arr[i][j];
            }
        }
        int temp2 = 0;
        for (int i = rowCut; i < row; i++) { //3 -> 2
            for (int j = colCut; j < col; j++) {
                copy[temp2][j] = arr[i][j];
            }
            temp2 += 1;
        }
        for (int i = 0; i < rowCut; i++) { //2 -> 1
            int temp3 = 0;
            for (int j = colCut; j < col; j++) {
                copy[i][temp3] = arr[i][j];
                temp3 += 1;
            }
        }
        arr = copy;
    }
}
