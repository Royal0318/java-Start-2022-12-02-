import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Character> nArr = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < N;i++) { //듣을 입력시켜 저장
            nArr.put(br.readLine(), ' ');
        }
        for (int i = 0; i < M;i++) { //보를 입력하지만 듣이랑 비교해서 같은경우 arraylist에 저장하고 result변수에 1추가
            String str = br.readLine();
            if (nArr.containsKey(str)){
                result += 1;
                arr.add(str);
            }
        }
        Collections.sort(arr); //어레이솔트보다 컬렉션솔트가 더빠르다
        System.out.println(result);
        for (String s : arr) {
            System.out.println(""+s+"");
        }
    }
}
