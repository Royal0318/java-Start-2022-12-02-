import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Question1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] strCut = str.split("-"); //-기준으로 자름
        int result = 0;
        for (int i = 0; i < strCut.length;i++) {
            int sum = 0;

            String[] cut = strCut[i].split("\\+"); //plus가 붙은덩어리를 한번더 나눔

            for (int j = 0; j < cut.length;j++) {
                sum += Integer.parseInt(cut[j]);
            }
            if (i == 0) {
                result += sum;
            }
            else {
                result -= sum;
            }
        }
        System.out.println(result);
    }
}
