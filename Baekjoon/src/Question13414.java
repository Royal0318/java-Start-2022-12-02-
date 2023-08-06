import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Question13414 {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashMap<String,Integer> arr = new LinkedHashMap<>();

        for (int i = 0 ; i < L;i++) {
            String str = br.readLine();

            if (arr.containsKey(str)) { //다시 신청하는 경우
                arr.remove(str); //해당 인원 삭제 후 재등록
                arr.put(str, 1);
            }
            else { //새로등록하는경우
                arr.put(str, 1);
            }
        }
        int count = 0;
        for (String s : arr.keySet()) { //선착순 출력
            if (count == K) {
                return;
            }
            count += 1;
            System.out.println(s);
        }
    }
}
