import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        int cut = Integer.parseInt(st.nextToken());

        int[] arr = new int[testCase];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < testCase;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0; //스타트지점
        int result = 0; //정답 경우의수
        int end = 0; //끝지점
        int sum = 0; //총누적합

        sum += (arr[end]); //처음시작할때 sum에 end에 속한값을 미리넣고시작
        while (true) {
            if (sum == cut) {
                result += 1;
                sum -= (arr[start]); //같다면 다음으로 넘아가기 때문에 전에 존재하는 start값 삭제후 이동
                start += 1;
            } else if (sum < cut) {
                if (end == (testCase - 1)) { //end가 테스트케이스 index - 1까지 도달시 break로 while문 탈출
                    break;
                } else { //그렇지 않은경우에는 계속 반복
                    end += 1;
                    sum = (sum + arr[end]);
                }
            } else { //sum > cut
                sum -= (arr[start]);
                start += 1;
            }
        }
        System.out.println(result);
    }
}
