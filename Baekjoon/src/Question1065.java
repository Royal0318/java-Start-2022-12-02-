import java.util.Scanner;
public class Question1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();
        int[] arr = new int[5];

        if (n <= 99) {
          count = n;
        } else if (n == 1000) {
            //1000일때의 처리가 필요하다 1000이상은 주어지지않았기 때문이고 1000은 144이기때문에 따로처리필요
            count = 144;
        } else {
            count += 99;
            //그 이후에는 100이넘어가니까 99를 추가하고 시작한다
            for (int i = 100; i <= n; i++) {
                String str = "" + i + "";

                for (int j = 0; j < str.length(); j++) {
                    arr[j] = str.charAt(j);
                }
                //여기까지 각자리수에 해당하는 값을 배열에 넣음
                for (int j = 0; j < str.length(); j++) {
                    arr[j] = (arr[j] - arr[j + 1]);
                }
                //예를들어서 100이라고하면 arr[0] = arr[0] - arr[1]이다 그렇다면
                //                       1    =    1   -    0     결국 arr[0] = 1이된다
                //이렇게 계산한값을 앞에값에 덮고 중간것을 마지막것과 비교하며 나아간다
                for (int j = 0; j < (str.length()-1); j++) {
                    if (arr[j] == arr[j + 1]) {
                        count += 1;
                    }
                }
                //3자리 까지 하기때문에 3자리수에서 각자리끼리 비교하고 최종적으로는 2자리 끼리 비교하기때문에 -1이 필요
            }
        }
        System.out.println(count);
    }
}