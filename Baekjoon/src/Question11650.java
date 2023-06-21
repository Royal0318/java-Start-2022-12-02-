import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Question11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        int[][] arr = new int[testCase][2];

        for (int i = 0; i < testCase;i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            arr[i][0] = one;
            arr[i][1] = two;
        }
        Arrays.sort(arr, new Comparator<int[]>() { //comparator을 사용하여 2가지 이상정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) { //만약에 비교하는 값이 같다면
                    return o1[1] - o2[1]; //뒤에 존재하는 값을 오름차순 정렬
                } else { //다르다면
                    return o1[0] - o2[0]; //앞에 존재하는 값을 오름차순 정렬
                }
            }
        });
        for (int i = 0; i < testCase;i++) { //빠른출력을 위해 append
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}
