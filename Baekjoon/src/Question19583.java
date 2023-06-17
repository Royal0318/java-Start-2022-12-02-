import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Question19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<String> start = new HashSet<>(); //시작
        HashSet<String> end = new HashSet<>(); //끝
        HashSet<String> name = new HashSet<>(); //이름

        st = new StringTokenizer(br.readLine());
        String S = st.nextToken(); //시작시간
        String E = st.nextToken(); //끝난시간
        String Q = st.nextToken(); //스트리밍 종료시간

        String str;

        while ((str = br.readLine()) != null) { //따로 주어진게없기때문에 탈출조건을 마련
            String[] cut = str.split(" "); //공백을 기준으로자름
            String one = cut[0]; //시간
            String two = cut[1];//이름

            //일단 채팅은 쳤으니까 기록한다
            //그 이후 시간을 비교한다
            name.add(two);

            if (one.compareTo(S) <= 0) { //만약 시간시간과 비교해서 같으면 0 1개다르면 -1...
                //시작시간보다 빠르다면 음수를 출력하기때문에 출석인정
                start.add(two);//시작출석에 이름저장
            } else if (one.compareTo(E) >= 0 && one.compareTo(Q) <= 0) {
                end.add(two);
                //끝난시간부터 스트리밍종료시간까지 채팅친사람 출석
            }
            //else는 이후에 채팅친사람이기때문에 체크 X
        }
        int result = 0; //정답
        for (String s : name) {
            //만약에 시작과 끝 이름 둘다존재시 출석인정된사람
            if (start.contains(s) && end.contains(s)) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
