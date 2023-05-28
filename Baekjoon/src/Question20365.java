import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int result = 0;
        StringTokenizer st = new StringTokenizer(str,"R");
        StringTokenizer st2 = new StringTokenizer(str,"B");

        result += Math.min(st.countTokens(), st2.countTokens());
        System.out.println(result + 1);
        //이게 왜되지?? 이상하네...
        //한쪽을 다 파란색으로 하던가 한쪽을 빨간색으로 해서 적은수를 고르면된다
        //그렇기때문에 tokenizer로 나눠서 작은쪽이 정답이다
    }
}
