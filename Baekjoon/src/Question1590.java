import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question1590 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //테스트케이스
        int T = Integer.parseInt(st.nextToken()); //나의 도착시간
        long result = 0;

        ArrayList<Long> arr = new ArrayList<>();

        for (int i = 0 ; i < N;i++) {
            st = new StringTokenizer(br.readLine());
            long si = Integer.parseInt(st.nextToken()); //첫 버스출발시간
            long li = Integer.parseInt(st.nextToken()); //버스 간격
            long ci = Integer.parseInt(st.nextToken()); //버스 대수

            for (int j = 0 ; j < ci;j++) {
                arr.add(si + (li * j)); //전체순서대로 나열
            }
        }
        Collections.sort(arr);

        if (arr.get(0) >= T) { //T가 가장앞에 존재하는경우
            result = arr.get(0) - T; //가장처음버스를 타는것이 가능하다
        }
        else if (arr.get(arr.size() - 1) < T) { //모든 버스를 놓쳐서 못타는경우
            System.out.println(-1);
            return;
        }
        else { //중간에 탑승이 가능한경우
            int start = 0;
            int end = (arr.size() -1);

            while (start < end) {
                int mid = (start + end) / 2;

                if (arr.get(mid) == T) {
                    System.out.println(0);
                    return; //리턴안하면 출력2번나옴
                }
                else if (arr.get(mid) > T) {
                    end = mid;
                }
                else {
                    start = mid + 1;
                }
            }
            result = arr.get(end) - T;
        }
        System.out.println(result);
    }
}
