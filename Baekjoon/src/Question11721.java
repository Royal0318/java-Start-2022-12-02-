import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int start = 0;
        StringBuilder sb = new StringBuilder();

        while (start < str.length()) { //0부터 문자열 length까지 반복
            sb.append(str.charAt(start)); //한번씩 반복될때마다 문자열을 붙친다
            if ((start % 10) == 9) { //나머지가 9라는것은 10개를 모두입력했다는말
                System.out.println(sb); //10개를 붙쳤으므로 출력
                sb.setLength(0); //sb초기화
            }
            start += 1;
        }
        System.out.println(sb); //끝부분이 10개가 되지않으면 나머지도 출력
    }
}
