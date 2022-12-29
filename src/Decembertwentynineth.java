/*
문) 처음에 몇명까지 만들지 입력받고 그 후에 각각의 손님의 금액을 입력해주세요
금액 입력을 마친 후 손님이 가진금액을 모두 나오게 하며
바로 몇 번째 손님의 돈을 차감할지 질문한다
그 다음 차감할 돈을 입력받고 그 돈이 가지고있는돈과 일치할때 즉 0원이되면
그 손님의 번호는 삭제된다
예) 총 5명을 생성
몇 번째 손님을 선택하겠습니까? : 2
얼마를 빼겠습니까? : 20000
만약 2번째 손님이 가진금액이 20000원일시 일치하게 되어 삭제된다
결과 : 1번째 손님이 가진 금액 : 10000
2번째 손님이 가진 금액 : 30000
3번째 손님이 가진 금액 : 40000
4번째 손님이 가진 금액 : 50000
즉 출력은 1번째,3번째,4번째,5번째처럼 나오는 형태가 아닌 사라진 인덱스를 채워주게 된다
만약 일치하지 않게 될경우 차감된 값과 나머지 값을 출력하게 된다
손님의 선택과 삭제하는금액을 모두 0으로 작성시 프로그램이 종료되게 하는 프로그램을 작성하시오
 */
import java.util.Scanner;
public class Decembertwentynineth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("총 몇명까지 만들겠습니까?");
        int People = sc.nextInt();
        int[] arr = new int[People];
        System.out.println("각각 손님이 가진 금액을 입력해주세요");

        for (int i = 0; i < People; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < People; i++) {
            System.out.println("" + (i + 1) + "번째 손님이 가진 금액 : " + arr[i] + "원");
        }
        for (;;) {
            int RemainMoney = 0;
            System.out.println("몇번째 손님의 돈을 차감 하시겠습니까?");
            int PeopleSelect = sc.nextInt();
            System.out.println("얼마를 차감 하시겠습니까?");
            int MinusMoney = sc.nextInt();
            RemainMoney = (arr[PeopleSelect - 1] - MinusMoney); //남는돈 = 선택한 손남의 돈 - 차감하는돈

            if (RemainMoney == 0) { //돈이 0원이되서 삭제되는경우
                for (int i = (PeopleSelect - 1); i < (People - 1); i++) {
                    arr[i] = arr[i + 1]; //다음 index의 값을 가지고 온다
                }
                People--;
                for (int i = 0; i <= (People - 1); i++) {
                    System.out.println(""+(i + 1)+"번째 손님이 가진 금액 : "+arr[i]+"원");
                }
            }
            if (RemainMoney > 0) { //돈이 남는경우
                arr[PeopleSelect - 1] = RemainMoney;
                for (int i = 0; i < People; i++) {
                    System.out.println(""+(i + 1)+"번째 손님이 가진 금액 : "+arr[i]+"원");
                }
            }
            if (PeopleSelect == 0 && MinusMoney == 0) { //시스템 종료조건
                System.out.println("시스템을 종료합니다");
                 break;
            }
        }
    }
}
