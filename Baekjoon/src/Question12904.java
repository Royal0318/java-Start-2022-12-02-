import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Question12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());

        while (T.length() > S.length()) { //S의 길이가 더 길어지면 탈출한다 왜냐하면 더이상 비교가 안되기때문이다
            if (T.charAt(T.length() - 1) == 'A') { //만약 끝에가 A라면 A를 삭제함 방법1번
                T.deleteCharAt(T.length()-1);
            }
            else if (T.charAt(T.length() - 1) == 'B') { //방법2 B인경우
                T.deleteCharAt(T.length()-1);
                T.reverse();
            }
        }
        String sStr = String.valueOf(S); //String형으로 변환
        String tStr = String.valueOf(T);
        if (Objects.equals(sStr, tStr)) System.out.println(1); //같은경우 1 다른경우 0
        else System.out.println(0);
    }
}
