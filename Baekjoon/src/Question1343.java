import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int xcount = 0; //초반에 X카운트를 담기위한변수
        for (int i = 0; i < str.length();i++) {
            if (str.charAt(i) == 'X') {
                xcount += 1; //전체문자열을 검사하면서 X의 개수를 확인
            }
        }

        if (xcount%2 == 0) { //X의개수가 짝수일때만 덮을수 있으므로 짝수일때 가능
            str = str.replaceAll("XXXX", "AAAA"); //4자리는 AAAA로덮고
            str = str.replaceAll("XX", "BB"); //2자리는 BB로 덮는다
        }
        for (int i = 0; i < str.length();i++) {
            if (str.charAt(i) == 'X') { //다 덮고나서 x가존재하면 덮지못한것이므로 -1을출력함
                System.out.println(-1);
                return;
            }
        }
        System.out.println(str);
    }
}
