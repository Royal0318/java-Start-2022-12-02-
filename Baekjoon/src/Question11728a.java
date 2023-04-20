import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Question11728a {
    public static void main(String[] args) throws IOException {
        //Scanner로 입력받는경우이다 아마 sb도없었다면 시간초과가 발생했을것같다 이방법도 시간이 오래걸리는편이다
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int temp = 0;

        int a = sc.nextInt();
        int b = sc.nextInt();

        long[] arr = new long[a + b];
        long[] arr2 = new long[b];

        for (int i = 0; i < a;i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < b;i++) {
            arr2[i] = sc.nextInt();
        }
        for (int i = a; i < arr.length;i++) {
            arr[i] = arr2[temp];
            temp += 1;
            //입력한 배열값을 다시 arr에 옮기는과정
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length;i++) {
            sb.append(arr[i]).append(" "); //sb를 통해 붙인다
        }
        System.out.println(sb);
    }
}