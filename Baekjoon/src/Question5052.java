import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question5052 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < testCase;i++) {
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];

            for (int j = 0 ; j < arr.length;j++) {
                arr[j] = br.readLine();
            }
            Arrays.sort(arr); //오름차순으로 정렬

            if (!cal(arr)) { //리턴으로 넘겨받은 결과가 false라면 비교한 두 수가 서로 일관성이 없으므로 NO를 출력하도록한다
                sb.append("NO\n");
            }
            else {
                sb.append("YES\n");
            }
        }
        System.out.println(sb);
    }
    public static boolean cal (String[] arr) {
        for (int i = 0 ; i < arr.length - 1;i++) {
            if (arr[i + 1].startsWith(arr[i])) {
                return false;
            }
        }
        //서로의 접두어 관계를 알아보려면 i번째 문자열과 그 다음문자열을 서로 비교해서 관계를 확인해야한다
        return true;
    }
}
