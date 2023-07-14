import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String,Integer> arr = new HashMap<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] name = new String[N]; //이름저장
        for (int i = 0; i < N;i++) {
            String str = br.readLine();
            arr.put(str, i);
            name[i] = str; //문자는 배열로 따로저장
        }

        for (int i = 0; i < M;i++) {
            String str = br.readLine();

            if (str.charAt(0) - 'A' < 0) { //숫자 -- > 문자
                int temp = Integer.parseInt(str) - 1; //아스키코드값이 음수면 숫자 양수면 문자가나옴
                sb.append(name[temp]).append("\n"); //int형으로 변환 후 배열index에 넣어 문자저장
            }
            else { //문자 -- > 숫자
                sb.append(arr.get(str) + 1).append("\n"); //get하여 해당문자가 위치한 index + 1 저장
            }
        }
        System.out.println(sb);
    }
}
