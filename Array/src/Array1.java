import java.util.Scanner;
public class Array1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][4];
        int[][] correctAnswerCheck = new int[3][4];
        //정답을 맞춘경우 입력한 행렬값에 1을부여 정답을 맞춘 자리는 정답이 출력되도록 하기 위함
        int totalChance = 0;
        //게임의 기회변수 0부터 10까지 증가하면서 10을 초과시 게임이 강제 종료된다
        int gameTerminationCheck = 0;
        //게임 종료조건을 카운트하는변수 정답을 모두 맞추면 게임이 종료되거나 기회를 모두 소진해서 게임이 종료되는 조건이므로 정답을 맞춘경우 1개씩 누적되며 모두 맞춘경우 행렬개수와 동일해지므로 게임종료

        while (true) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.println("[" + i + "][" + j + "]에 숫자를 입력해주세요");
                    arr[i][j] = sc.nextInt();
                }
            }
            //2중 for문을 통해 행과 열이 반복되면서 원하는 수를 2차원Array에 저장한다
            System.out.println("<<<숫자가 모두 저장되었습니다 게임을 시작합니다>>>");
            System.out.println("게임 룰 설명 : 메인 화면에 ?로 되어있는 곳에 숫자를 입력하여 맞추면 성공!");
            System.out.println("만약 틀렸을 경우 총 10회의 기회가 주어집니다 10회안에 모두 맞추세요! 오답을 입력시 힌트를 제공합니다\n");
            //숫자를 모두 저장 후 게임 룰 설명

            while (true) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (correctAnswerCheck[i][j] == 1) {
                            System.out.printf("[" + i + "][" + j + "] = "+arr[i][j]+" ");
                        } else {
                            System.out.printf("[" + i + "][" + j + "] = ? ");
                        }
                    }
                    System.out.println();
                }
                //2중for문으로 전체적인 행렬을 보여준다 정답을 맞춘경우 correctAnswerCheck 배열에 1이 부여되며 해당 Array는 정답이 출력
                System.out.println("정답을 맞추고 싶다면 행과 열을 각각 입력해주세요");
                int rows = sc.nextInt();
                int column = sc.nextInt();
                //각각행렬값을 입력한다
                if (rows >= 0 && rows < 3 && column >= 0 && column < 4 && correctAnswerCheck[rows][column] == 0) {
                    //행렬값이 정상범위내에 들어온다면 정답을 입력받도록한다
                    System.out.println("정답을 입력해주세요");
                    int correctNumber = sc.nextInt();

                    if (arr[rows][column] == correctNumber) {
                        System.out.println("<<<정답입니다!!!>>>");
                        correctAnswerCheck[rows][column] = 1;
                        gameTerminationCheck += 1;
                        //입력한 행렬번호를 arr에 입력 그 arr값이 자신이 입력한정답과 일치한경우 correctAnswerCheck에 1을 부여 게임종료 조건변수인 gameTerminationCheck 에도 1을부여한다
                    } else {
                        totalChance += 1;
                        if (totalChance <= 10) {
                            System.out.println("<<<오답입니다!!! 총 기회 : " + totalChance + "/10회>>>");

                            if (arr[rows][column] < correctNumber) {
                                System.out.println("힌트 : 정답은 입력한 값보다 작습니다");
                            } else {
                                System.out.println("힌트 : 정답은 입력한 값보다 큽니다");
                            }
                        }
                        //정답을 맞추지 못한경우 totalChance 값이 1씩 증가 if문을 통해 입력한 값이 정답보다 큰지 크지 않은지 알려주는 힌트를 제공
                        else {
                            System.out.println("Game Over!! 정답을 모두 공개합니다!");
                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 4; j++) {
                                    System.out.printf("["+i+"]["+j+"] = "+arr[i][j]+" ");
                                }
                                System.out.println();
                            }
                            //기회를 모두 소진하면 정답을 모두 공개하고 게임 재시작 여부를 묻는다
                            System.out.println("게임을 다시 시작하겠습니까? (1.Yes 2.No)");
                            int restart = sc.nextInt();

                            if (restart == 1) {
                                System.out.println("게임을 다시 시작합니다");
                                break;
                            } else if (restart == 2) {
                                System.out.println("프로그램을 종료합니다");
                                return;
                            } else {
                                System.out.println("잘못된 입력입니다");
                                return;
                            }
                            //게임을 다시시작하는 경우 break문으로 while문을 빠져나가 게임을 재시작하며 2번이나 범위를 벗어났을경우 강제종료된다
                        }
                    }
                } else {
                    System.out.println("잘못된 입력이거나 이미 맞춘 정답입니다");
                }

                if (gameTerminationCheck == 12) {
                    System.out.println("축하합니다! 정답을 모두 맞췄습니다! 게임을 다시 시작하겠습니까? (1.Yes 2.No)");
                    int restart = sc.nextInt();

                    if (restart == 1) {
                        System.out.println("게임을 다시 시작합니다");
                        break;
                    } else if (restart == 2) {
                        System.out.println("프로그램을 종료합니다");
                        return;
                    } else {
                        System.out.println("잘못된 입력입니다");
                        return;
                    }
                    //4X3 게임판이므로 총 12개의 번호를 맞출수 있다 모두 맞춘경우 gameTerminationCheck변수값은 12가 되므로 게임 재시작 여부를 묻는다
                }
            }
        }
    }
}
