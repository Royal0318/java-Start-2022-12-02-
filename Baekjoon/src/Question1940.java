import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //배열있는경우 양쪽에서 좁히면서 탐색한다

        int testCase = Integer.parseInt(br.readLine());
        //입력은 한개만 존재하기에 br.readline

        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[testCase];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //시간을 단축하기위해 한번에 입력받고 분할해서 분배하기위해 token사용
        Arrays.sort(arr);
        //계산하기 편하도록 낮은순부터 정렬한다
        int start = 0; //시작
        int end = (testCase - 1); //끝
        int result = 0; //정답 카운트

        while (start < end) {
            if ((arr[start] + arr[end]) == num) { //같은경우에는 result를 1카운트하며 시작과 끝을 한칸씩 좁힌다
                result += 1;
                start += 1;
                end -= 1;
            } else if ((arr[start] + arr[end]) > num) {
                /*만약에 배열값이 더 커진경우에는 end를 한칸당겨서 숫자를 줄인다 왜냐하면 sort를했기때문에
               값은 작은순부터 나열되어 있다 그런데 start를 한칸올리게되면 두 배열값이 더 커지기 때문에 end를 줄여서 숫자를 적게 하는것이다
                 */
                end -= 1;
            } else { //만약 num값이 더 크다면 끝에는 고정시키고 시작을 옮겨서 다시 계산작업을 수행한다
               start += 1;
            }
        }
        System.out.println(result);
    }
}
