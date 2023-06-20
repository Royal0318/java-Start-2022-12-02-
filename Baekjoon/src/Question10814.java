import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Question10814 {
    public static void main(String[] args) throws IOException {
        //String ver
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine()); //testcase입력
        StringTokenizer st;

        String[][] str = new String[testCase][2];
        for (int i = 0; i < testCase;i++) {
            st = new StringTokenizer(br.readLine()," "); //공백을 기준으로
            str[i][0] = st.nextToken(); //나이저장
            str[i][1] = st.nextToken(); //이름저장
        } //저장완료

        //여기서부터 정렬
        Arrays.sort(str, new Comparator<String[]>() {
            @Override //상위 클래스나 인터페이스에서 이미구현되어있는 메소드를 여기에서 사용한다는 의미
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]); //리턴하는데 문자열-->int형변환
            }
        });
        //정렬된것 붙침
        for (int i = 0; i < testCase;i++) {
            sb.append(str[i][0]).append(" ").append(str[i][1]).append("\n"); //여기까지 한줄
        }
        //출력부
        System.out.println(sb);
    }
}
