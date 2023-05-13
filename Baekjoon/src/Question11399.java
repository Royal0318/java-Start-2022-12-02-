import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int result = 0; //정답
        int sum = 0; //누적합을 구하기위한 임시변수
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase;i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr); //Collections.sort를이용하여 정렬

        for (int i = 0; i < testCase;i++) {
            sum += arr.get(i); //값을 sum에 계속넣는다 그러면 sum은 처음에 입력한 부분부터 계속 누적됨
            result += sum; //값을 받을때마다 정답에 넣으면 누적합이됨
        }
        System.out.println(result);
    }
}
