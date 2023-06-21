import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Question1181a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[testCase];

        for (int i = 0 ; i < testCase;i++) { //문자열 저장
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //정렬하면서 두 문자열이 같은경우
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2); //o1과 o2를 비교한값을 리턴
                } else { //다른경우
                    return o1.length() - o2.length(); //정렬시작
                }
            }
        });
        //처음 하나는 여기서 저장
        sb.append(arr[0]).append("\n");
        for (int i = 1;i < arr.length;i++) { //나머지 정렬한다
            if (!Objects.equals(arr[i], arr[i - 1])) { //i번째와 i - 1번째가 같지않은경우만출력
                sb.append(arr[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
