import java.util.Scanner;

public class Januaryforteenth {
    public static void main(String[] args) {
        System.out.println("기회가 "+main()+"회를 초과하였으므로 패배");
    }

    public static int main() {
        int Chance = 0;
        int AnswerSum = 0;
        int WrongSum = 0;
        return InputNumber(Chance);
    }

    public static int InputNumber(int Chance) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][4];
        int[][] Answerarr = new int[3][4];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println("["+i+"] ["+j+"] 숫자 입력");
                int ArrayNumberInput = sc.nextInt();
                arr[i][j] += ArrayNumberInput;
            }
        }
        return MatrixPrint(Chance,arr,Answerarr);
    }
    public static int MatrixPrint (int Chance,int[][]arr,int[][]Answerarr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("["+i+"]["+j+"] : ? ");//가로출력
            }
            System.out.println("\n");
        }
        return MatrixInPut(Chance,arr,Answerarr);
    }
    public static int MatrixInPut(int Chance,int[][]arr,int[][]Answerarr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("?에 들어갈 값을 맞추고싶다면 행과열을 각각 입력하시오 \n예)1행1열 : (1 Enter 1)");
        int Row = sc.nextInt(); //행
        int Column = sc.nextInt(); //열
        System.out.println(""+Row+"행"+Column+"을 입력하셨습니다 정답 입력");
        int AnswerInput = sc.nextInt();

        if (arr[Row][Column] == AnswerInput) {
            Answerarr[Row][Column] += 1;
            return Answer(Chance,arr,Answerarr,Row,Column);
        } else {
            return Wrong(Chance,arr,Answerarr);
        }
    }
    public static int Answer(int Chance,int[][]arr,int[][]Answerarr,int Row,int Column) { //정답일시 해당 숫자가 나타난다 정답카운트를줘서 해당 카운트를 받은것만 숫자출력 아닌것은 ?
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (Answerarr[i][j] == 0) {
                    System.out.printf("[" + i + "][" + j + "] : ? ");
                } else if (Answerarr[i][j] == 1) {
                    System.out.printf("[" + i + "][" + j + "] : "+arr[Row][Column]+" ");
                }
            }
            System.out.println("\n");
        }
        return MatrixInPut(Chance,arr,Answerarr);
    }
    public static int Wrong(int Chance,int[][]arr,int[][]Answerarr) { //오답일시
        Chance += 1;
        if (Chance <= 10) {
            System.out.println("주의 : " + Chance + "번째 기회 10회가 넘어갈경우 패배");
            return MatrixInPut(Chance,arr,Answerarr);
        } else { //게임오버시 전체값 제시
            System.out.println("정답을 공개합니다 : ");
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.printf("["+i+"]["+j+"] : "+arr[i][j]+" ");
                }
                System.out.println("\n");
            }
            return 10;
        }
    }
}
