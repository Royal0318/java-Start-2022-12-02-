import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int snack = Integer.parseInt(st.nextToken());

        int[] arr = new int[snack];

        int start = 1; //시작지점(1로잡은이유는 0으로 할경우 byZero에러가 발생하기 때문에 방지차원)
        //start변수를 0으로하고 while문안에 따로 작성할경우 시간초과발생!!
        int end = Integer.MIN_VALUE; //끝지점

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < snack; i++) { //과자 개수 입력
            arr[i] = Integer.parseInt(st.nextToken());

            if (end < arr[i]) end = arr[i];
        }

        int result = 0; //정답

        while (start <= end) {
            int mid = ((start + end) / 2);

            if (check(arr,mid) >= people) {
                start = mid + 1; //스타트를 미드 + 1만큼 증가시켜 다음것도 되는지 확인
                result = mid;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
    private static int check (int[] arr,int mid) {
        int sum = 0;
        for (int j : arr) {
            sum += (j / mid);
        }
        return sum;
    }
}
