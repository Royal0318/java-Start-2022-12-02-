import java.util.Scanner;

public class Januarynineteenth {
    public static void main(String[] args) {
        System.out.println("안내 : 기회가 "+(VariableSave() - 1)+"회를 초과하였기 때문에 게임이 종료됩니다");
    }
/*
1.정답을 틀렸을때 힌트값을 줘보자 (완)
2.내가입력한숫자가 행렬에 없는숫자인경우 그메시지를출력한다 (완)
3.함수값을 좀더 세세하게나눠라
4.기회를 모두 사용한경우 왜졌는지 설명을해라 (완)
5.게임에 이긴경우 이겼다는메시지 (완)
6.main값 메서드안에있는변수 수정
 */
    public static int VariableSave() {
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

        System.out.println("<<<<<<숫자 맞추기 게임>>>>>> \n게임 룰 설명 : 4X4행렬에 원하는 숫자를 입력합니다 그 이후 각 행렬에 들어있는 값을 맞춥니다 \n정답인경우 공개 오답인경우 공개되지 않으며 기회가 차감됩니다 \n입력한 값이 행렬값에 존재하지 않는경우 메시지로 알려드립니다 \n4X4행렬을 모두 풀었다면 자신이 맞춘 행렬의 값을 모두 더하는 문제가 나오며 정답을 맞춘경우 자신이 2번째부터 틀린 행렬의 값을 모두 더해서 맞추는 문제가 출제됩니다 \n그러므로 자신이 입력한 숫자를 잘 기억해주세요 \n틀린경우 기회가 차감 정답을 모두 맞춘경우 게임이 종료됩니다 \n기회는 총 10번이며 10번을 모두 사용한경우 자동으로 게임이 종료됩나다\n");
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
        int MatrixCheck = 0; //정답을 맞추기 위해 행렬값을 입력했을때 전체 행렬에 존재하는경우 값을부여 되돌아오면 스스로 값을 초기화한다
        if (AnswerCountSave == 16) { //16개의 행렬의 정답을 모두 맞춘경우 Game2로 리턴시켜줌
            return Game2(Chance,CorrectGuessesNumberSave, IncorrectNumberSave);
        }
        System.out.println("맞추고싶은 곳의 행열을 각각 입력하시오  \n예)1행1열 : (1 Enter 1)");
        int Row = sc.nextInt(); //행
        int Column = sc.nextInt(); //열

        if (CorrectNumberOutputarr[Row][Column] != 0) { //정답을 맞춘곳에 다시 값을 중복으로 입력하려는경우
            System.out.println("이미 정답을 맞췄기 때문에 더이상 값을 입력할 수 없습니다");
            return MatrixCorrectAnswerInput(Chance, arr, CorrectNumberOutputarr, CorrectGuessesNumberSave, IncorrectNumberSave, AnswerCountSave);
        } else {
            System.out.println("" + Row + "행" + Column + "열을 입력하셨습니다 정답을 입력하시오");
            int CorrectNumberInput = sc.nextInt();
            return ReExamiation(CorrectNumberInput,Chance, arr, CorrectNumberOutputarr, CorrectGuessesNumberSave, IncorrectNumberSave, AnswerCountSave,MatrixCheck,Row,Column);
        }
    }
    public static int ReExamiation(int CorrectNumberInput,int Chance,int[][] arr,int[][] CorrectNumberOutputarr,int CorrectGuessesNumberSave,int IncorrectNumberSave,int AnswerCountSave,int MatrixCheck,int Row,int Column) {
        //행렬값을 맞추기위해 답을 입력한경우 해당 값이 전체행렬값에 존재하는 값인지 판단하기 위해 거치는 메소드
        if (arr[Row][Column] == CorrectNumberInput) { //정답을 맞춘 경우
            CorrectNumberOutputarr[Row][Column] = 1; //정답시 입력한  행렬값에 1을부여하여 출력시 1을 가지고있는 행렬값만 출력된다
            CorrectGuessesNumberSave += arr[Row][Column]; //정답시 Game2 문제를 풀기위한 정답값을 저장한다
            AnswerCountSave += 1;
            return CorrectGuessesInput(CorrectNumberInput, Chance, arr, CorrectNumberOutputarr, CorrectGuessesNumberSave, IncorrectNumberSave, AnswerCountSave, Row, Column);
        } else {
            return IncorrectAnswerInput(CorrectNumberInput, Chance, arr, CorrectNumberOutputarr, Row, Column, CorrectGuessesNumberSave, IncorrectNumberSave, AnswerCountSave);
        }
    }

    public static int CorrectGuessesInput(int CorrectNumberInput,int Chance,int[][]arr,int[][]CorrectNumberOutputarr,int CorrectGuessesNumberSave,int IncorrectNumberSave,int AnswerCountSave,int Row,int Column) {
        //정답을 맞춘경우에 넘어오는 메소드
        System.out.println("<정답입니다!>");
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
    public static int IncorrectAnswerInput(int CorrectNumberInput,int Chance,int[][]arr,int[][]CorrectNumberOutputarr,int Row,int Column,int CorrectGuessesNumberSave,int IncorrectNumberSave,int AnswerCountSave) {
        //정답을 맞추지 못한 경우에 넘어오는 메소드
        Chance += 1;
        if (Chance <= 10) { //정답을 맞추지 못한 경우에 기회가 1회 추가되며 기회를 카운트하며 맞추지 못한것은 출력되지않으며 맞춘것만 출력되도록 for문을 구현
            System.out.println("<오답입니다!> \n주의 : " + Chance + "번째 기회 10회 초과시 패배!");
            System.out.println("내가 입력했던 숫자 : "+CorrectNumberInput+"");
            if (arr[Row][Column] < CorrectNumberInput) { //정답입력시 힌트를 제공한다
                System.out.println("힌트 : 정답은 입력한 값 보다 작습니다");
            } else if (arr[Row][Column] > CorrectNumberInput) {
                System.out.println("힌트 : 정답은 입력한 값 보다 큽니다");
            }
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
            System.out.println("<<<Game Over!!!!>>>  \n<정답을 공개합니다>"); //기회를 10회 초과되고 게임종료직전에 출력된다 정답을 입력했던 행렬값을 모두 출력해줌
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.printf("["+i+"]["+j+"] : "+arr[i][j]+" ");
                }
                System.out.println("\n");
            }
            System.out.println("정답을 맞춘 배열들의 총 합 : "+CorrectGuessesNumberSave+"\n2번 이상 틀린 배열들의 총 합 : "+IncorrectNumberSave+"");
            return Chance;
        }
    }
    public static int Game2 (int Chance,int CorrectGuessesNumberSave,int IncorrectNumberSave) {
        Scanner sc = new Scanner(System.in);
        System.out.println("지금까지 맞춘 배열값의 총 합은 얼마였습니까?");
        int TotalCorrectNumber = sc.nextInt();

        if (TotalCorrectNumber == CorrectGuessesNumberSave) {
            return Game3(Chance,IncorrectNumberSave);
        } else {
            Chance -= 1;
            if (Chance <= 10) {
                System.out.println("<오답입니다!> \n주의 : " + Chance + "번째 기회 10회 초과시 패배");
            } else {
                System.out.println("<<<Game Over!!!!>>> \n<정답을 공개합니다> 정답을 맞춘 배열들의 총 합은"+CorrectGuessesNumberSave+"입니다");
                return Chance;
            }
        }
        return 0;
    }
    public static int Game3 (int Chance,int IncorrectNumberSave) {
        Scanner sc = new Scanner(System.in);
        System.out.println("마지막 문제입니다 \n2번이상 틀린것에 대한 배열값의 총 합은 얼마였습니까?");
        int TotalIncorrectNumber = sc.nextInt();

        if (TotalIncorrectNumber == IncorrectNumberSave) {
            System.out.println("<<<<<<<<<<축하합니다 끝까지 통과하였으므로 우승하였습니다!>>>>>>>>>>");
            System.exit(1);
        } else {
            Chance -= 1;
            if (Chance <= 10) {
                System.out.println("<오답입니다!> \n주의 : " + Chance + "번째 기회 10회 초과시 패배");
            } else {
                System.out.println("<<<Game Over!!!!>>> \n<정답을 공개합니다> 정답을 맞춘 배열들의 총 합은"+IncorrectNumberSave+"입니다");
                return Chance;
            }
        }
        return 0;
    }
}
