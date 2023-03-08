import java.util.Scanner;

public class Question14914 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = 0;
        int apple = sc.nextInt();
        int banana = sc.nextInt();
        while (true) {
            people++;
            /*
            이 문제의 핵심은 무조건 사과와 바나나의출력값이 짝수가 나와야한다 그리고 나머지는 나오면 안된다 그러므로
            사과를 사람수로 나누어 그 나머지값이 0이나온다는 뜻은 몫이 딱맞아 떨어진다는 얘기이다
            시스템 종료조건으로는 사람수가 과일보다 클경우 과일수를그대로 나머지값으로 출력한다
             */
            if ((apple%people) == 0 && (banana%people) == 0) {
                System.out.println(""+people+" "+(apple/people)+" "+(banana/people)+"");
            }
            if ((apple%people) == apple && (banana%people) == banana) {
                break;
            }
        }
    }
}
