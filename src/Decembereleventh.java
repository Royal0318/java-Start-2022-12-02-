/*
오늘은 for문에 대해 배웠다 while문과 똑같은 반복문이지만
while은 무한으로 반복할때 자주 사용하며
for문같은경우 끝이 있는 경우에 자주 사용된다
for(초기값, 조건식, 증감식) 을한번에 입력하여 쓸 수 있어
가독성이 while보다 좋다

문)정수값을 입력받아 1부터 입력받은 값까지 1씩 증가된 값을 출력하는 코드를 작성하시오
단 1부터 시작하는 값이 아닌 100부터 시작하는 형태로 출력된다
예) 정수입력 : 3
출력 : 100,101,102
 */
import java.util.Scanner;
public class Decembereleventh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i=1;i<=number;i++) {
            System.out.println(""+(i + 99)+"");
        }
    }
}
