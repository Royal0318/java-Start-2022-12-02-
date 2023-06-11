import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int result = 0; //정답

        for (int i = 0; i < str.length();i++) {
            boolean check = true;
            int index = 0;

            for (int j = i; j < str.length();j++) {
                if (str.charAt(j) != str.charAt(str.length() - 1 - index)) { //맨오른쪽문자열과 맨앞문자열을 비교하여 같은경우 반복문을 계속돌면서
                    //비교한다 만약에 다른경우 breaak되고 false가되어 다음 문자열을 검사 같은경우 끝까지 모두같은지 즉 펠린드롬인지 index + 1을하면서 계속안쪽으로 가면서 비교
                    check = false;
                    break;
                }
                index += 1;
            }
            if (check) { //만약에 펠린드롬이라면 i의 값을 기존문자열 길이에 더해 출력
                result = str.length() + i;
                break;
            }
        }
        System.out.println(result);
    }
}
