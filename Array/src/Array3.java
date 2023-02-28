/*
문 ) 1.3X4줄의 게임판을 2차원 배열을 이용하여 만든다
2.각각의 배열값에 원하는 값을 입력후 그 값을 맞추는 게임을 제작하여라
3.해당 번호를 맞추면 정답을 공개 틀린경우 기회를 1 추가하여 기회가 10회를 초과했을때 프로그램을 종료시켜라
4.틀린경우 정답은 공개되지 않는다
 */
import java.util.Scanner;

public class Array3 {
    int[][] gameCard;
    //전체 게임판의 개수 총 4X3이므로 12개가 만들어진다
    int[][] correctAnswerArr;
    //정답을 맞춘경우 해당 배열값에 1을부여하여 정답이 출력되도록 gameCard배열을 보조하는 배열값
    int correctAnswerCount;
    //정답을 맞추면 1씩 누적되며 저장하는 변수값이 12가되면 모든 정답을 맞춘것이므로 게임 재시작 여부를 묻는 메소드로 이동할 수 있게 도와준다
    int totalChance;
    //전체 기회 한번씩 틀릴 때 마다 1회씩 증가하며 10회를 초과할 시 게임종료

    Array3 () {

    }
    Array3 (int[][]gameCard,int[][] correctAnswerArr,int correctAnswerCount,int totalChance) {
        this.gameCard = gameCard;
        this.correctAnswerArr = correctAnswerArr;
        this.correctAnswerCount = correctAnswerCount;
        this.totalChance = totalChance;
    }
    void answerInput (Scanner sc) {
        //게임을 시작하기 전 이중for문을 이용하여 정답을 입력하여 gameCard[][] 2차원배열값에 저장한다 저장이 끝나면 게임룰을 출력 후 정답을 맞추는 메소드로 이동
        for (int i = 0; i < 3;i++) {
            for (int j = 0; j < 4;j++) {
                System.out.println("["+i+"]["+j+"]에 정답을 입력해주세요");
                gameCard[i][j] = sc.nextInt();
            }
        }
        System.out.println("<<<정답이 모두 입력되었습니다>>>");
        System.out.println("게임 룰 설명 : 총 12개의 판에 숨겨져있는 정답을 맞추는 게임입니다");
        System.out.println("원하는 자리의 행렬번호를 입력 후 정답을 입력 맞추면 해당 자리의 ?가 정답으로 바뀝니다");
        System.out.println("오답인경우 기회가 1회 누적되며 총 10회를 초과했을경우 게임이 종료됩니다");
        System.out.println("정답을 맞추지 못한경우에는 힌트를 제공하니 참고해주세요!\n");
        gameNumberOutput(sc);
    }
    void gameNumberOutput (Scanner sc) {
        //정답입력이 완료되면 Prinf을 통해 각 배열값을 출력하지만 정답은 출력되지 않는다 정답을 맞춰 correctAnswerArr[][]값이 1이 부여되면 정답이 출력됨
        for (int i = 0; i < 3;i++) {
            for (int j = 0; j < 4;j++) {
                if (correctAnswerArr[i][j] == 1) {
                    System.out.printf("["+i+"]["+j+"] = "+gameCard[i][j]+" ");
                } else {
                    System.out.printf("["+i+"]["+j+"] = ? ");
                }
            }
            System.out.println();
        }
        correctNumberInput(sc);
    }
    void correctNumberInput (Scanner sc) {
        //정답을 맞추는 메소드이다 행렬값을 입력 후 정답까지입력 범위내로 입력시 정답여부를 판단 범위를 벗어날경우 재입력 받도록 리턴된다
        System.out.println("원하는 자리의 행렬 번호를 입력해주세요");
        int row = sc.nextInt();
        int column = sc.nextInt();
        System.out.println("정답을 입력해주세요");
        int answer = sc.nextInt();

        if (row >= 0 && row <= 3 && column >= 0 && column <= 4) {
            //행렬을 범위내에 입력하였을경우 정답이 처음에 입력했던 값과 일치하는지 2차원배열과 비교한다
            if (gameCard[row][column] == answer) {
                correctGuesses(sc,row,column);
            } else {
                incorrectGuesses(sc);
            }
        } else {
            System.out.println("잘못된 범위입니다");
            gameNumberOutput(sc);
        }
    }
    void correctGuesses (Scanner sc,int row,int colunm) {
        /*
        정답을 맞춘경우 정답입니다!문장이 출력되며 correctAnswerArr[row][colunm] 2차원 배열값에 1이 부여되며 gameNumberOutput로 리턴될때 정답을
        맞춘 배열은 정답이 출력된다 그리고 correctAnswerCount 변수에도 1이 부여되어 게임종료 조건 만족여부를 확인
         */
        System.out.println("<<<정답입니다!>>>");
        correctAnswerArr[row][colunm] = 1;
        correctAnswerCount += 1;
        if (correctAnswerCount == 12) {
            gameFinish(sc, 2);
        }
        //4X3줄이기 때문에 총 12개의 판이 존재한다 그러므로 모든 정답을 맞췄다는 것은 correctAnswerCount변수가 12가 되었다는 뜻이며 게임종료 조건에 부합한다
        gameNumberOutput(sc);
    }
    void incorrectGuesses (Scanner sc) {
        //입력한 값이 오답인경우 totalChance 전체 기회가 1씩 누적되며 총 10회를 초과시 retryAsk 메소드로 1을 리턴보내 재시작 여부를 확인
        totalChance += 1;
        if (totalChance <= 10) {
            System.out.println("<<<오답입니다!>>> 기회 : "+totalChance+"/10회");
            gameNumberOutput(sc);
        } else {
            gameFinish(sc,1);
        }
    }
    void gameFinish (Scanner sc,int size) {
        //총 기회가 10회가 초과되었을경우 게임종료 조건이 되며 모든 정답을 출력 후 retryAsk 메소드에서 게임 재시작 여부를 확인한다
        if (size == 1) {
            System.out.println("<<<Game Over>>> 정답을 공개합니다!");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.printf("[" + i + "][" + j + "] = " + gameCard[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("<<<축하합니다! 모든 문제를 풀었습니다!>>>");
        }
        //모든 정답을 맞췄을경우 마찬가지로 retryAsk메소드에서 재시작 여부를 확인한다
        retryAsk(sc);
    }
    void retryAsk (Scanner sc) {
        System.out.println("게임을 다시 시작하시겠습니까? (1.Yes 2.No)");
        int retry = sc.nextInt();

        if (retry == 1) {
            //기회가 10회를 초과하였을경우 게임재시작여부를 확인하며 만약 재시작 할 경우 전체적인 변수와 배열값을 초기화한다
            System.out.println("게임을 다시 시작합니다");
            totalChance = 0;
            correctAnswerCount = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    correctAnswerArr[i][j] = 0;
                }
            }
            answerInput(sc);
        } else if (retry == 2) {
            //게임 진행을 원하지 않는경우 시스템을 종료
            System.out.println("프로그램을 종료합니다");
            System.exit(0);
        } else {
            System.out.println("잘못된 입력입니다");
            retryAsk(sc);
        }
    }
}
