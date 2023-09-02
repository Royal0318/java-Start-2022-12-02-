import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question1654a {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] cut = str.split(" ");
        int[] arr = new int[Integer.parseInt(cut[0])];

        long end = 0;
        for (int i = 0 ; i < Integer.parseInt(cut[0]);i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (end < arr[i]) end = arr[i];
        }
        long start = 1;
        long result = 0;

        while (start <= end) {
            long middle = ((start + end) / 2);

            if (cal(arr,middle) >= Integer.parseInt(cut[1])) { //입력한 N값과 일치하거나 큰경우 start위치를 바꾸면 middle값이 커져 else로 계속 가면서 end와 만나 탈출하도록 설계
                result = middle;
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }
        System.out.println(result);
    }
    public static int cal (int [] arr,long middle) {
        int sum = 0;

        for (int i = 0 ; i < arr.length;i++) {
            sum += (arr[i] / middle);
        }
        return sum;
    }
}
