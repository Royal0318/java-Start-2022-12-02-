import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> arr = new HashMap<>();
        for (int i = 0 ; i < N;i++) {
            String str = br.readLine();

            if (str.length() >= M) { //해시를통해서 중복이면 value값을 + 1,중복이 아니면 새롭게 추가한다
                if (arr.containsKey(str)) {
                    arr.put(str, arr.get(str) + 1);
                }
                else {
                    arr.put(str, 1);
                }
            }
        }
        List<String> set = new ArrayList<>(arr.keySet()); //List이며 keySet을 가져옴

        set.sort((o1, o2) -> { //sort시작
            int temp = arr.get(o1); //value 숫자 찾아서 변수에넣음 즉 key(String) -- > value (int)로 바꾸는과정
            int temp2 = arr.get(o2);

            if (temp == temp2) { //자주나오는 단어의 수가같은경우
                if (o1.length() == o2.length()) {  //조건3 : 알파벳사전순
                    return o1.compareTo(o2); //알파벳 사전순으로 정렬
                }
                else {   //조건2 : 해당단어길이가 같은경우
                    return o2.length() - o1.length();
                }
            }
            else { //자주나오는 단어수가 다른경우
                return temp2 - temp;
            }
        });
        for (String s : set) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
