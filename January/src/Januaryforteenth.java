import java.util.Scanner;

public class Januaryforteenth {
    public static void main(String[] args) {
        System.out.println("기회가 "+main()+"회를 초과하였으므로 패배");
    }

    public static int main() {
        int Chance = 0;
        int AnswerSum = 0;
        int WrongSum = 0;
        int QueationCount = 0;
        int WrongCount = 0;
        return InputNumber(Chance,AnswerSum,WrongSum,WrongCount,QueationCount);
    }

    public static int InputNumber(int Chance,int AnswerSum,int WrongSum,int WrongCount,int QueationCount) {
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
        return MatrixPrint(Chance,arr,Answerarr,AnswerSum,WrongSum,WrongCount,QueationCount);
    }
    public static int MatrixPrint (int Chance,int[][]arr,int[][]Answerarr,int AnswerSum,int WrongSum,int WrongCount,int QueationCount) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("["+i+"]["+j+"] : ? ");//가로출력
            }
            System.out.println("\n");
        }
        return MatrixInPut(Chance,arr,Answerarr,AnswerSum,WrongSum,WrongCount,QueationCount);
    }
    public static int MatrixInPut(int Chance,int[][]arr,int[][]Answerarr,int AnswerSum,int WrongSum,int WrongCount,int QueationCount) {
        Scanner sc = new Scanner(System.in);
        System.out.println("맞추고싶은 곳의 행열을 각각 입력하시오 \n예)1행1열 : (1 Enter 1)");
        int Row = sc.nextInt(); //행
        int Column = sc.nextInt(); //열
        System.out.println(""+Row+"행"+Column+"을 입력하셨습니다 정답을 입력하시오");
        int AnswerInput = sc.nextInt();

        if (arr[Row][Column] == AnswerInput) {
            Answerarr[Row][Column] += 1;
            AnswerSum += arr[Row][Column];
            QueationCount += 1;
            return Answer(Chance,arr,Answerarr,AnswerSum,WrongSum,WrongCount,QueationCount); //정답
        } else {
            Answerarr[Row][Column] += 1;
            WrongCount += 1;
            return Wrong(Chance,arr,Answerarr,Row,Column,AnswerSum,WrongSum,WrongCount,QueationCount); //틀림
        }
    }
    public static int Answer(int Chance,int[][]arr,int[][]Answerarr,int AnswerSum,int WrongSum,int WrongCount,int QueationCount) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (Answerarr[i][j] == 0) { //정답을 맞춘 행렬index에 1의값을 부여 해당값은 정답을출력 0인값은 ?값을 출력
                    System.out.printf("[" + i + "][" + j + "] : ? ");
                } else if (Answerarr[i][j] == 1) {
                    System.out.printf("[" + i + "][" + j + "] : "+arr[i][j]+" ");
                }
            }
            System.out.println("\n");
        }
        if (QueationCount == 12) { //오답과 정답 12개의 판을 모두 오픈했을때 다음게임
            return Game2(AnswerSum,WrongSum);
        }
        return MatrixInPut(Chance,arr,Answerarr,AnswerSum,WrongSum,WrongCount,QueationCount);
    }
    public static int Wrong(int Chance,int[][]arr,int[][]Answerarr,int Row,int Column,int AnswerSum,int WrongSum,int WrongCount,int QueationCount) {
        Chance += 1;
        if (Chance <= 10) {
            System.out.println("주의 : " + Chance + "번째 기회 10회가 넘어갈경우 패배");
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (Answerarr[i][j] == 0) {
                        System.out.printf("[" + i + "][" + j + "] : ? ");
                    } else if (Answerarr[i][j] == 1) {
                        System.out.printf("[" + i + "][" + j + "] : "+arr[i][j]+" ");
                        if (WrongCount >= 2) { //2번째 틀렸을때부터 값을 저장한다
                            WrongSum += arr[Row][Column];
                        }
                    }
                }
                System.out.println("\n");
            }
            return MatrixInPut(Chance,arr,Answerarr,AnswerSum,WrongSum,WrongCount,QueationCount);
        } else {
            System.out.println("<정답을 공개합니다>");
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.printf("["+i+"]["+j+"] : ? ");//가로출력
                }
                System.out.println("\n");
            }
            System.out.println("정답을 맞춘 배열들의 총 합 : "+AnswerSum+"\n2번 이상 틀린 배열들의 총 합 : "+WrongSum+"");
            return 10;
        }
    }
    public static int Game2 (int AnswerSum,int WrongSum) {
        Scanner sc = new Scanner(System.in);
        System.out.println("지금까지 맞춘 배열값의 총 합은 얼마였습니까?");
        int Answer = sc.nextInt();

        if (Answer == AnswerSum) {
            return Game3(WrongSum);
        } else {
            System.out.println("오답입니다 정답은 "+AnswerSum+"입니다");
            System.exit(1);
        }
        return 0;
    }
    public static int Game3 (int WrongSum) {
        Scanner sc = new Scanner(System.in);
        System.out.println("마지막 문제입니다 \n2번이상 틀린것에 대한 배열값의 총 합은 얼마였습니까?");
        int Answer = sc.nextInt();

        if (Answer == WrongSum) {
            System.out.println("축하합니다 정답을 모두 맞췄습니다!");
            System.exit(1);
        } else {
            System.out.println("오답입니다 정답은 "+WrongSum+"입니다");
            System.exit(1);
        }
        return 0;
    }
}
