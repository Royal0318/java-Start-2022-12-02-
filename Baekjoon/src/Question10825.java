import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Question10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        String[][] arr = new String[testCase][4];

        for (int i = 0; i < testCase;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
            arr[i][3] = st.nextToken();
        }
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) { //국어점수가 같을경우
                    if (Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) { //영어점수가 같은경우
                        if (Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])) {
                            return o1[0].compareTo(o2[0]); //이름이 사전순으로
                        }
                        else {
                            return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]); //수학점수 감소
                        }
                    }
                    else {
                        return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]); //영어점수 증가
                    }
                }
                else {
                    return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]); //국어점수 감소
                }
            }
        });
        for (String[] s : arr) {
            sb.append(s[0]).append("\n");
        }
        System.out.println(sb);
    }
}
