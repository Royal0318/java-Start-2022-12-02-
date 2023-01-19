import java.util.Scanner;

public class Januarynineteenth {
    public static void main(String[] args) {
        //10번의 기회를 초과시 출력
        System.out.println("기회가 "+main()+"회를 초과하였으므로 패배");
    }

    public static int main() {
        //변수를 보관하는 메인 메소드
        int Chance = 0; //틀렸을경우 기회변수가 올라감 10회 초과시 게임종료
        int CorrectGuessesNumberSave = 0; //정답을 입력시 정답인 값을 저장하는 변수
        int IncorrectNumberSave = 0; //오답을 입력시 오답인 값을 저장하는 변수
        int AnswerCountSave = 0; //정답시 카운트를 누적하여 전체 행렬값을 모두 Open시 Game2로 넘어가도록 카운트를 누적하는 변수
        return IndexInputNumber(Chance,CorrectGuessesNumberSave,IncorrectNumberSave,AnswerCountSave);
    }

    public static int IndexInputNumber(int Chance,int CorrectGuessesNumberSave,int IncorrectNumberSave,int AnswerCountSave) {
        //각 인덱스에 숫자를 부여하기 위해 필요한 입력 메소드
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[4][4];
        int[][] CorrectNumberOutputarr = new int[4][4]; //정답을 입력시 정답만 출력되도록 도와주는 행렬

        for (int i = 0; i < arr.length; i++) { //각 인덱스에 숫자를 부여하기위한 for문
            for (int j = 0; j < arr.length; j++) {
                System.out.println("["+i+"] ["+j+"] 숫자 입력");
                int ArrayCorrectNumber = sc.nextInt();
                arr[i][j] += ArrayCorrectNumber;
            }
        }
        for (int i = 0; i < arr.length; i++) { //숫자를 부여 한 후 정답을 맞추기 전 전체행렬을 출력
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("["+i+"]["+j+"] : ? ");
            }
            System.out.println("\n");
        }
        return  MatrixCorrectAnswerInput(Chance,arr,CorrectNumberOutputarr,CorrectGuessesNumberSave,IncorrectNumberSave,AnswerCountSave);
    }
    public static int MatrixCorrectAnswerInput(int Chance,int[][]arr,int[][]CorrectNumberOutputarr,int CorrectGuessesNumberSave,int IncorrectNumberSave,int AnswerCountSave) {
        //정답을 입력하기위한 메소드
        Scanner sc = new Scanner(System.in);
        if (AnswerCountSave == 16) { //16개의 행렬의 정답을 모두 맞춘경우 Game2로 리턴시켜줌
            return Game2(CorrectGuessesNumberSave,IncorrectNumberSave);
        }
        System.out.println("맞추고싶은 곳의 행열을 각각 입력하시오 \n예)1행1열 : (1 Enter 1)");
        int Row = sc.nextInt(); //행
        int Column = sc.nextInt(); //열
        System.out.println(""+Row+"행"+Column+"열을 입력하셨습니다 정답을 입력하시오");
        int CorrectNumberInput = sc.nextInt();

        if (arr[Row][Column] == CorrectNumberInput) { //정답을 맞춘 경우
            CorrectNumberOutputarr[Row][Column] += 1; //정답시 입력한  행렬값에 1을부여하여 출력시 1을 가지고있는 행렬값만 출력된다
            CorrectGuessesNumberSave += arr[Row][Column]; //정답시 Game2 문제를 풀기위한 정답값을 저장한다
            AnswerCountSave += 1;
            return CorrectGuessesInput(Chance,arr,CorrectNumberOutputarr,CorrectGuessesNumberSave,IncorrectNumberSave,AnswerCountSave);
        } else { //정답을 맞추지 못한 경우
            CorrectNumberOutputarr[Row][Column] += 0; //오답인경우는 0을 부여하여 출력시 답이 출력되지 않도록 구현
            return IncorrectAnswerInput(Chance,arr,CorrectNumberOutputarr,Row,Column,CorrectGuessesNumberSave,IncorrectNumberSave,AnswerCountSave);
        }
    }
    public static int CorrectGuessesInput(int Chance,int[][]arr,int[][]CorrectNumberOutputarr,int CorrectGuessesNumberSave,int IncorrectNumberSave,int AnswerCountSave) {
        //정답을 맞춘경우에 넘어오는 메소드
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (CorrectNumberOutputarr[i][j] == 0) { //정답을 맞춘 행렬 index에 1의값을 부여하여 출력되며 0을 가진값은 출력되지 않는다
                    System.out.printf("[" + i + "][" + j + "] : ? ");
                } else if (CorrectNumberOutputarr[i][j] == 1) {
                    System.out.printf("[" + i + "][" + j + "] : "+arr[i][j]+" ");
                }
            }
            System.out.println("\n");
        }
        return MatrixCorrectAnswerInput(Chance,arr,CorrectNumberOutputarr,CorrectGuessesNumberSave,IncorrectNumberSave,AnswerCountSave);
    }
    public static int IncorrectAnswerInput(int Chance,int[][]arr,int[][]CorrectNumberOutputarr,int Row,int Column,int CorrectGuessesNumberSave,int IncorrectNumberSave,int AnswerCountSave) {
        //정답을 맞추지 못한 경우에 넘어오는 메소드
        Chance += 1;
        if (Chance <= 10) { //정답을 맞추지 못한 경우에 기회가 1회 추가되며 기회를 카운트하며 맞추지 못한것은 출력되지않으며 맞춘것만 출력되도록 for문을 구현
            System.out.println("주의 : " + Chance + "번째 기회 10회가 넘어갈경우 패배");
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (CorrectNumberOutputarr[i][j] == 0) {
                        System.out.printf("[" + i + "][" + j + "] : ? ");
                    } else if (CorrectNumberOutputarr[i][j] == 1) {
                        System.out.printf("[" + i + "][" + j + "] : "+arr[i][j]+" ");
                        if (Chance >= 2) { //2번이상 틀렸을 때 부터 틀린값들을 저장해서 Game3에 사용됨
                            IncorrectNumberSave += arr[Row][Column];
                        }
                    }
                }
                System.out.println("\n");
            }
            return MatrixCorrectAnswerInput(Chance,arr,CorrectNumberOutputarr,CorrectGuessesNumberSave,IncorrectNumberSave,AnswerCountSave);
        } else {
            System.out.println("<정답을 공개합니다>"); //기회를 10회 초과되고 게임종료직전에 출력된다 정답을 입력했던 행렬값을 모두 출력해줌
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.printf("["+i+"]["+j+"] : "+arr[i][j]+" ");
                }
                System.out.println("\n");
            }
            System.out.println("정답을 맞춘 배열들의 총 합 : "+CorrectGuessesNumberSave+"\n2번 이상 틀린 배열들의 총 합 : "+IncorrectNumberSave+"");
            return 10;
        }
    }
    public static int Game2 (int CorrectGuessesNumberSave,int IncorrectNumberSave) {
        Scanner sc = new Scanner(System.in);
        System.out.println("지금까지 맞춘 배열값의 총 합은 얼마였습니까?");
        int TotalCorrectNumber = sc.nextInt();

        if (TotalCorrectNumber == CorrectGuessesNumberSave) {
            return Game3(IncorrectNumberSave);
        } else {
            System.out.println("오답입니다 정답은 "+CorrectGuessesNumberSave+"입니다");
            System.exit(1);
        }
        return 0;
    }
    public static int Game3 (int IncorrectNumberSave) {
        Scanner sc = new Scanner(System.in);
        System.out.println("마지막 문제입니다 \n2번이상 틀린것에 대한 배열값의 총 합은 얼마였습니까?");
        int TotalIncorrectNumber = sc.nextInt();

        if (TotalIncorrectNumber == IncorrectNumberSave) {
            System.out.println("축하합니다 끝까지 통과하였습니다!");
            System.exit(1);
        } else {
            System.out.println("오답입니다 정답은 "+IncorrectNumberSave+"입니다");
            System.exit(1);
        }
        return 0;
    }
}
