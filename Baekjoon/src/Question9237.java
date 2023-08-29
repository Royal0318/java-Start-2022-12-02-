import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question9237 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int temp = 1;
        int result = 1;
        String str = br.readLine();
        String[] cut = str.split(" ");

        int[] arr = new int[N];

        for (int i = 0 ; i < cut.length;i++) {
            arr[i] = Integer.parseInt(cut[i]);
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1 ; i >= 0;i--) {
            arr[i] = (arr[i] + temp + 1);
            temp += 1;

            if (result < arr[i]) {
                result = arr[i];
            }
        }
        System.out.println(result);
        /*
        핵심은 가장오래걸리는 나무가 가장 먼저심어진다면 최대한 시간을 단축할수있다
        그러므로 sort를 내림차순으로하여 첫날에 심어지는나무는 1일이걸리므로
        첫째나무 자라는시간 + 현재날짜를 더해준다
        그렇게 계산 후마지막에는 이장님은 마지막나무가 다 자란다음날에 초대하므로
        + 1을 추가적으로 계산해주면된다
         */
    }
}