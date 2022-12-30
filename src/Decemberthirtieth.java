/*
문)맨 처음에 인덱스 값을 생성하고 각 사람마다 값을 넣어주세요
그 다음 원하는 인덱스 번호에 값을 추가가되는 1차원배열 코드를 만들어주세요
종료 조건은 원하는 인덱스 번호,값에 0을 넣었을경우 프로그램이 종료되도록 만들어주세요
예) 5명까지 생성 각각의 값은 10,20,30,40,50
2번째 자리에 100이라는 값을 넣을때
출력값
1번째 값 : 10
2번째 값 : 100
3번째 값 : 20
4번째 값 : 30
5번째 값 : 40
6번째 값 : 50
위처럼 나오도록 작성해주세요
 */
import java.util.Scanner;
public class Decemberthirtieth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇명까지 생성하시겠습니까?");
        int People = sc.nextInt();

        int [] arr = new int[People + 10000];

        System.out.println("각 사람마다 값을 입력해주세요");
        for (int i = 0; i < People; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < People; i++) {
            System.out.println("" + (i + 1) + "번째 사람의 번호는 : " + arr[i] + "입니다");
        }
        for (int i = 0; i < People; i++) {
            System.out.println("몇번자리에 인덱스를 추가하시겠습니까?");
            int PlusIndex = sc.nextInt() - 1;
            System.out.println("해당 인덱스의 값 적어주세요");
            int Number = sc.nextInt();

            for (int j = (People + (i + 1)); j > (PlusIndex);j--) {
                arr[j] = arr[j - 1];
            }
            arr[PlusIndex] = Number;
            for (int j = 0; j < (People + (i + 1));j++) {
                System.out.println(""+(j + 1)+"번째 사람의 번호는 : "+arr[j]+"입니다");
            }
            if (PlusIndex == 0 && Number == 0) {
                break;
            }
        }
    }
}
