import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1654 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] line = new long[K];

        //길이가 int형의 최대값이기때문에 long으로 해야한다
        long start = 1; //시작
        long end = Integer.MIN_VALUE; //나눌수있는 최대
        long result = 0; //정답

        for (int i = 0 ; i < K;i++) {
            line[i] = Integer.parseInt(br.readLine());
            if (end < line[i]) end = line[i]; //end의 최대값
        }

        while (start <= end) {
            long mid = ((start + end) / 2);

            //여기서맞는지확인
            if (check(mid,line) >= N) { //N개의 개수와 일치하는경우
                result = mid; //정답에 mid개수 입력
                start = mid + 1; //시작점 변경하여 mid값 수정
            }
            else { //N개보다 적은경우
                end = mid - 1; //끝지점을 중간지점으로 옮김
            }
        }
        System.out.println(result);
    }
    public static long check (long mid,long[] line) {
        long sum = 0; //최대 만들수있는개수

        for (long j : line) {
            sum += (j / mid);
        }
        return sum; //나눌수있는 개수를 리턴해서넘겨줌
    }
}
