import java.util.Arrays;
import java.util.Scanner;
public class Question2309 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        int check = 0;

        for (int i = 0; i < 9;i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        //각각의 수를 배열값에 담고 전체 계산에서 2명을 거르기 위한 sum변수에 모든값을 저장한다
        for (int i = 8; i > 0;i--) {
            for (int j = (i-1); j >= 0; j--) {
                if (check == 0) {
                    if (((sum - (arr[i] + arr[j])) == 100)) {
                        arr[i] = 0;
                        arr[j] = 0;
                        check = 1;
                        break;
                    }
                }
            }
        }
        /*
        여기서 중요한점은 2명을 따로 골라야하기 때문에 그부분을 잘 생각해야한다  0 ~ 8까지 존재하기 때문에
        처음에 8을 고정시키고 7부터 0까지 내려오면서 두수의 합을 sum에 빼고 그값이 100이면 break로 탈출해야한다
        그런데 여기서중요한점은 break만하면 다시 바깥for문으로 인해 다시돌아서 다른것도 초기화 시키기때문에
        한번 찾으면 더이상 진입하지 않도록 하는 변수가 따로 필요하다 그것이 check변수다
        하나를 찾으면 더이상 초기화시키지 못하도록 check = 1을하여 막는다
        그 이후에 Arrays.sort로 정렬 후 가장 앞인덱스 2개는 0이기때문에 출력이 필요없으므로 i = 2부터 출력한다
         */
        Arrays.sort(arr);
        for (int i = 2; i < 9;i++) {
            if (arr[i] != 0) {
                System.out.println("" + arr[i] + "");
            }
        }
    }
}
