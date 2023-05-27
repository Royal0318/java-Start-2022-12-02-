import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Question1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str,"0");
        StringTokenizer st2 = new StringTokenizer(str,"1");
        System.out.println(Math.min(st.countTokens(), st2.countTokens()));
        //0과 1을 따로 잘라서 카운트하는 방법
    }
}
