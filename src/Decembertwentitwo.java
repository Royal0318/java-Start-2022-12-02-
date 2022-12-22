/*
문) 첫번째 줄에는 인덱스를 생성할 수 있도록 값을 입력받는다
그 후에 1.더하기 2.빼기 3.특정 값불러오기중
1번을 선택하고 값을 5 입력했을때
출력으로
1번째 값 : 0
2번째 값 : 5
그 다음 2번을 누르고
3을 입력했을 때
출력으로
1번째 값 : 0
2번째 값 : 5
3번째 값 : 2
이렇게 나열되면서 출력되는 배열을 만들어라
 */
import java.util.Scanner;
public class Decembertwentitwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("인덱스 생성 값");
        int Index = sc.nextInt();

        int [] arr = new int[Index];
        for (int i=1;i<Index;i++) {
            System.out.println("1.더하기  2.빼기  3.특정 값 불러오기");
            int Select = sc.nextInt();
            if (Select == 1){
                System.out.println("값 입력");
                int Number = sc.nextInt();
                arr[i] = arr[i - 1] + Number;
            }
            if (Select == 2){
                System.out.println("값 입력");
                int Number = sc.nextInt();
                arr[i] = arr[i - 1] - Number;
            }
            if (Select == 3){
                System.out.println("특정 값 입력");
                int Number = sc.nextInt();
                arr[i] = Number;
            }
            for (int j=0;j<=i;j++) {
                System.out.println(""+(j + 1)+"번째 값 : "+arr[j]+"");
            }
        }
    }
}
