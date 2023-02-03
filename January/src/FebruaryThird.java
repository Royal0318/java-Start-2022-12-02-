import java.util.Random;
import java.util.Scanner;

public class FebruaryThird {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random Roulette = new Random();
        int RouNumber;
        int[] InputNumber = new int[5];
        double[] Probability = new double[6];
        //입력한 숫자만큼 카운트하돼 확률을 구할때 사용한다

        while (true) {
            int WhileStart = 10000;
            //입력한숫자만큼 반복하기 위함 재도전시 값이 초기화되도록 설정
            System.out.println("=====랜덤 룰렛===== \n당신의 행운에 도전하세요! \n10000 ~ 100000까지 숫자를 입력해주세요");
            int RouletteNumber = sc.nextInt();

            if (RouletteNumber > 10000 && RouletteNumber <= 100000) {
                while (WhileStart <= RouletteNumber) {
                    RouNumber = Roulette.nextInt(100000) + 10000;

                    if (RouNumber <= 50000) { //1 ~ 50000까지 꽝이 나오도록 설계
                        InputNumber[0] += 1; //나온 횟수를 카운트하는 배열값
                        Probability[0] += 1; //나온 횟수를 카운트하되 확률을 구하기위한 배열값
                    } else if (RouNumber <= 80000) { //50000 ~ 80000까지 100원이 나오도록 설계
                        InputNumber[1] += 1;
                        Probability[1] += 1;
                    } else if (RouNumber <= 90000) { //80000 ~ 90000까지 1000원이 나오도록 설계
                        InputNumber[2] += 1;
                        Probability[2] += 1;
                    } else if (RouNumber <= 99000) { //90000 ~ 99000까지 10000원이 나오도록 설계
                        InputNumber[3] += 1;
                        Probability[3] += 1;
                    } else { //99000 ~ 100000까지 50000원이 나오도록 설계
                        InputNumber[4] += 1;
                        Probability[4] += 1;
                    }
                    WhileStart++;
                    Probability[5] += 1; //전체 누적값
                }

                for (int i = 0 ; i < 5 ; i ++) {
                    //for문을 이용하여 미리
                    // 확률이 계산되도록 구성
                    Probability[i] = (Probability[i] / Probability[5] * 100);
                }
                System.out.println("           |   꽝   |   100원   |   1000원   ㅣ   10000원   |   50000원 ㅣ \n나온 횟수 : ㅣ "+InputNumber[0]+"회 ㅣ  "+InputNumber[1]+"회  ㅣ   "+InputNumber[2]+"회    ㅣ    "+InputNumber[3]+"회   ㅣ   "+InputNumber[4]+"회   ㅣ");
                System.out.printf("확률 :     ㅣ %.2f%%",Probability[0]); //소수점 2번째 자리까지 출력되도록 설정
                System.out.printf(" ㅣ  %.2f%%",Probability[1]);
                System.out.printf(" ㅣ   %.2f%%",Probability[2]);
                System.out.printf("    ㅣ    %.2f%%",Probability[3]);
                System.out.printf("   ㅣ  %.2f%%  ㅣ",Probability[4]);

                System.out.println("\n한번 더 도전하시겠습니까? 1.도전  2.종료");
                int Choice = sc.nextInt();

                if (Choice == 1) {
                    System.out.println("재도전!");
                    //재도전시 횟수 초기화
                    for (int i = 0 ; i < 5 ; i ++) {
                        InputNumber[i] = 0;
                    }
                } else if (Choice == 2) {
                    System.out.println("시스템을 종료합니다");
                    System.exit(1);
                }
            } else {
                System.out.println("잘못된 입력");
            }
        }
    }
}
