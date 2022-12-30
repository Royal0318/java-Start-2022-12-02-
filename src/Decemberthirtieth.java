import java.util.Scanner;
public class Decemberthirtieth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int PlusSum = 0;
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
        for (int i = 0;i < People;i++) {
            int IndexSum = 0;
            PlusSum += 1; //추가할때마다 총 인덱스에서 1개씩 증가함
            System.out.println("몇번자리에 인덱스를 추가하시겠습니까?");
            int PlusIndex = sc.nextInt();
            IndexSum += arr[PlusIndex - 1]; //추가입력하는 인덱스를 덮기전에 그 값을 미리 저장해놓음
            System.out.println("해당 인덱스의 값 적어주세요");
            int Number = sc.nextInt();

            arr[PlusIndex - 1] = IndexSum;
            for (int j = (People + PlusSum); j > (PlusIndex - 1);j--) {//마지막 인덱스부터 줄어들면서 마지막인덱스의 값이 전 인덱스값을 가져옴
                arr[j] = arr[j - 1]; //마지막 인덱스값이 전 인덱스 값을 가져옴
            }
            arr[PlusIndex - 1] = Number; //새로 들어간 자리에 값을 입력
            for (int j = 0; j < (People + PlusSum);j++) {
                System.out.println(""+(j + 1)+"번째 사람의 번호는 : "+arr[j]+"입니다");
            }
            if (PlusIndex == 0 && Number == 0) {
                break;
            }
        }
    }
}
