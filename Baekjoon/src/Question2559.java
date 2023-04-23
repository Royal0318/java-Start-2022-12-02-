import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        //메모리를 줄이기위해 StringTokenizer 사용

        int cut = Integer.parseInt(st.nextToken());

        int[] arr = new int[testCase];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE; //가장최소, 0라고 설정할시 음수값으로 입력하면 0이출력되어 테스트통과 X

        for (int i = 0; i <= (testCase - cut);i++) {
            //end지점을 생각하여야 함 10칸중 cut이2라면 i값은 index 8에서 멈춰야 j가 8,9를돌기때문
            int sum = 0;
            for (int j = i; j < (i + cut);j++) {
                sum += arr[j];
                //cut만큼 sum변수에 값을 넣는다
            }
            if (max < sum) { //기본적인 크기비교
                max = sum;
            }
        }
        System.out.println(max);
    }
}
