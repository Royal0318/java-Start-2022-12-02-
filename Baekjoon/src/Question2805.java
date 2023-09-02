import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] cut = str.split(" ");

        long[] arr = new long[Integer.parseInt(cut[0])];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        long end = 0;

        for (int i = 0 ; i < arr.length;i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (end < arr[i]) end = arr[i];
        }
        long result = 0;
        long start = 1;

        while (start <= end) {
            long middle = ((start + end) / 2);

            if (cal(arr,middle) >= Integer.parseInt(cut[1])) {
                start = middle + 1;
                result = middle;
            }
            else { //원하는 길이가 안나오는경우
                end = middle - 1;
            }
        }
        System.out.println(result);
    }
    public static long cal (long[] arr,long middle) {
        long sum = 0;

        for (int i = 0 ; i < arr.length;i++) {
            if (arr[i] < middle) continue; //middle값이 더크면 그대로남기때문에 pass한다
            sum += (arr[i] - middle); //나머지 나무를 가져간다
        }
        return sum;
    }
}
