import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //주몽문제와 굉장히 비슷한문제이다
        int testCase = Integer.parseInt(br.readLine()); //테스트케이스

        long[] arr = new long[testCase];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } //배열에 저장
        Arrays.sort(arr);
        //이것이 필수!
        int sum = Integer.parseInt(br.readLine()); //원하는 값

        int start = 0; //시작지점
        int end = (testCase - 1); //끝지점
        int result = 0; //정답 케이스 갯수

        while (start < end) { //start가 testcase -1에 도달하면 자동 break탈출
            if ((arr[start] + arr[end]) == sum) {
                result += 1;
                start += 1;
                end -= 1;
                //sort를 하였기때문에 배열더한값이 sum과 같은경우 시작과 끝지점은 모두 한칸씩 이동시킨다
            } else if ((arr[start] + arr[end]) < sum) { //만약에 sum이 더 큰경우라면 start를 이동시켜 값을 크게만들어야함
                start += 1;
            } else { //그렇지않은경우 end를 줄여 값을 작게만들어야함
                end -= 1;
            }
        }
        System.out.println(result);
    }
}
