import java.util.Scanner;

public class MatrixSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] Number = new int[4][4];
        int[][] Correct = new int[4][4];
        int TotalChance = 0;
        int OpenMatrix = 0;//모든값을 맞췄을때 판단하도록 한다

        System.out.println("안내 : 1 ~ 100까지의 숫자만 입력가능합니다");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("[" + i + "][" + j + "]에 숫자를 입력해주세요");
                int Gamenumberinput = sc.nextInt();

                if (Gamenumberinput > 0 && Gamenumberinput <= 100) {
                    Number[i][j] = Gamenumberinput;
                    //배열값에 입력한 숫자를 할당한다
                } else {
                    System.out.println("잘못된 입력입니다!!!");
                    j--;
                }
            }
        }
        //입력 값 출력
        System.out.println("=========================");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("[" + i + "][" + j + "] : ? ");
            }
            System.out.println();
        }
        System.out.println("=========================");
        //정답인경우 오픈 정답이아닌경우 정답오픈안하고 기회 올라감
        while (true) {
            System.out.println("맞추고싶은 열과행 입력");
            int Row = sc.nextInt(); //행값 입력

            if (Row < 0 || Row > 3) {
                System.out.println("잘못된입력!");
            } else {
                int line = sc.nextInt(); //렬값 입력

                if (line < 0 || line > 3) {
                    System.out.println("잘못된 입력!");
                } else {
                    if (Correct[Row][line] != 0) {
                        System.out.println("이미 정답을 맞춘 문제입니다");
                    }
                    if (Correct[Row][line] == 0) {
                        System.out.println("[" + Row + "]과[" + line + "]의 정답 값을 입력");
                        int Answer = sc.nextInt();

                        if (Number[Row][line] == Answer) {
                            //입력한 행렬값이 정답값과 같을경우
                            Correct[Row][line] = 1;
                            OpenMatrix += 1;
                            System.out.println("<<<정답입니다!>>>");
                        }
                        if (Number[Row][line] != Answer) {
                            //입력한 행렬값이 정답값과 다를경우
                            TotalChance += 1;
                            //오답인경우 찬스값이 1회증가함
                            System.out.println("<<<오답입니다!!>>>\n기회 : (" + TotalChance + "/10회) \n10회 도달시 패배!");

                            if (TotalChance == 11) {
                                System.out.println("기회를 모두 사용하였으므로 패배!!! \n정답을 공개합니다!");
                                for (int i = 0; i < 4; i++) {
                                    for (int j = 0; j < 4; j++) {
                                        System.out.printf("[" + i + "][" + j + "] : " + Number[i][j] + " ");
                                    }
                                    System.out.println();
                                }
                                break;
                            }
                        }
                        //정답이던 오답이던 이 행렬을 출력함
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                if (Correct[i][j] == 1) {
                                    System.out.printf("[" + i + "][" + j + "] : " + Number[i][j] + " ");
                                } else {
                                    System.out.printf("[" + i + "][" + j + "] : ? ");
                                }
                            }
                            System.out.println();
                        }
                        if (OpenMatrix == 17) {
                            System.out.println("<<<축하합니다!! 우승하였습니다!>>>");
                            break;
                        }
                    }
                }
            }
        }
    }
}
