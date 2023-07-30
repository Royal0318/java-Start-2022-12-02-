import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question13702 {
    static int K;
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < N;i++)  {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        if (N == 1) { //테스트케이스가 1개라면 그것이 정답이다
            System.out.println(arr[0]);
            return;
        }
        int start = 0; //시작점
        int end = max; //끝점
        int result = 0; //정답
        while (start <= end) { //시작과 끝지점이 같아지면 반복문 종료
            int middle = ((start + end) / 2); //중간지점

            if (binarySearch(middle)) { //true일때마다 정답이 바뀜
                result = middle;
                start = middle + 1;
            }
            else { //false
                end = middle - 1; //끝지점을 1씩줄이면서 mid와함께 다시 탐색
            }
        }
        System.out.println(result); //정답출력부
    }
    private static boolean binarySearch (int middle) {
        int tempResult = 0; //이 메소드안에서만 K에만족하는지 판단하기 위한 변수

        for (int i = 0 ; i < N;i++) {
            long div = (arr[i] / middle);
            tempResult += div;
        }
        if (tempResult >= K) { //result로 저장한값이 사람수와 일치하거나 큰경우
            return true;
        }
        else { //인원수에 만족하지않는경우
            return false;
        }
    }
}
