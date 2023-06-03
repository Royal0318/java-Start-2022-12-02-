import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question5555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int result = 0;

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase;i++) {
            String str2 = br.readLine();
            str2 += str2; //문자열을 붙쳐서 링처럼 만든다
            /*
           예를들어 ABCD이고
           DAVCABC인경우 --> DAVCABCDABCABC가 되기때문에 contains는 하나만 찾으면 바로
           탈출하니까 두개가 잘 맞는 방법
             */
            if (str2.contains(str)) { //전체 문자열 탐색함 한번만 찾으면 탈출
                result += 1;
            }
        }
        System.out.println(result);
    }
}
