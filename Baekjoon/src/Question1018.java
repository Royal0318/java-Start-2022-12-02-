import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] white = new String[8];
        String[] black = new String[8];
        String[] arr = new String[N];

        for (int i = 0 ; i < N;i++) { //입력
            arr[i] = br.readLine();
        }
        for (int i = 0 ; i < 8;i++) { //화이트시작
            if ((i % 2) == 0) { //짝수라인
                white[i] = "WBWBWBWB";
            } else {
                white[i] = "BWBWBWBW";
            }
        }
        for (int i = 0 ; i < 8;i++) { //블랙시작
            if ((i % 2) == 0) { //짝수라인
                black[i] = "BWBWBWBW";
            } else {
                black[i] = "WBWBWBWB";
            }
        }
        int result = 64;
        //8 X 8에서 가장 많이 나오는 경우의수가 모두 다른경우 64가지가 나오기 때문
        //화이트와 블랙두개의 개수를 카운트해서 최소값 찾아야함
        for (int i = 0 ; i < (N - 7);i++) { //추가적이동
            for (int j = 0 ; j < (M - 7);j++) {
                int whiteCount = 0; //다른 화이트 개수
                int blackCount = 0; //다른 블랙 개수

                for (int k = 0; k < 8;k++) {
                    for (int l = 0 ; l < 8;l++) {
                        if (black[k].charAt(l) != arr[i + k].charAt(j + l)) blackCount += 1;
                        //블랙기준 판은 k와 j만돌면서 arr은 이동하면서 비교한다 다를경우 카운트
                        if (white[k].charAt(l) != arr[i + k].charAt(j + l)) whiteCount += 1;
                        //화이트토 마찬가지 같은방법으로
                    }
                }
                int min = Math.min(whiteCount,blackCount);
                if (min < result) {
                    result = min;
                }
            }
        }
        System.out.println(result);
    }
}
