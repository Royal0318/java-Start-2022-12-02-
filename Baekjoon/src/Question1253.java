import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int result = 0;

        int testCase = Integer.parseInt(br.readLine());

        long[] arr = new long[testCase];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //Arraylist로 정렬 후 투포인터

        for (int i = 0; i < testCase;i++) {
            int start = 0;
            int end = (testCase - 1);
            long point = arr[i];

            while (start < end) {
                if ((arr[start] + arr[end] == point)) { //같은수가 나온경우
                    if (start != i && end != i) { //start와 end가 i와겹치면 안되므로 if로 설정
                        result += 1; //만약에 s와 e랑 i가 모두 다른경우 정답으로 체크후 break
                        break;
                    } else if (start == i) { //만약같다면 포인터 옮김
                        start += 1;
                    } else {
                        end -= 1;
                    }
                } else if ((arr[start] + arr[end] > point)) {
                    //배열값이 더큰경우 end를 한칸 당겨서 point랑 가깝게 만든다
                    end -= 1;
                } else {
                    start += 1;
                }
            }
        }
        System.out.println(result);
    }
}
