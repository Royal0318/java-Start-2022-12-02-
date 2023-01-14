import java.util.Scanner;

public class Januaryforteenth {
    public static void main(String[] args) {
        System.out.println(""+main()+"");
    }

    public static int main() {
        int Chance = 0;
        return InputNumber(Chance);
    }

    public static int InputNumber(int Chance) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][4];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println("["+i+"] ["+j+"] 숫자 입력");
                int ArrayNumberInput = sc.nextInt();
                arr[i][j] += ArrayNumberInput;
            }
        }
        return MatrixPrint(Chance,arr);
    }
    public static int MatrixPrint (int Chance,int[][]arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("["+i+"]["+j+"] : ? ");//가로출력
            }
            System.out.println("\n");
        }
        return MatrixInPut(Chance,arr);
    }
    public static int MatrixInPut(int Chance,int[][]arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("?에 들어갈 값을 맞추고싶다면 행과열을 각각 입력 해주세요 \n예)1행1열 : (1 Enter 1)");
        int Row = sc.nextInt(); //행
        int Column = sc.nextInt(); //열
        System.out.println(""+Row+"행"+Column+"을 입력하셨습니다 정답은 무엇입니까?");
        int Answer = sc.nextInt();

        if (arr[Row][Column] == Answer) {
            return Answer(Chance,arr);
        } else {
            return Wrong(Chance,arr);
        }
    }
    public static int Answer(int Chance,int[][]arr) { //정답일시 해당 숫자가 나타난다
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("["+i+"]["+j+"] : ? ");
            }
            System.out.println("\n");
        }
        return MatrixInPut(Chance,arr);
    }
    public static int Wrong(int Chance,int[][]arr) { //오답일시
        Chance += 1;
        if (Chance >= 10) {
            System.out.println("주의 : " + Chance + "번째 기회 10회가 넘어갈경우 패배");
            return MatrixInPut(Chance,arr);
        } else { //게임오버시 전체값 제시
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.printf("["+i+"]["+j+"] : "+arr[i][j]+" ");
                }
                System.out.println("\n");
            }
            return 0;
        }
    }
}
