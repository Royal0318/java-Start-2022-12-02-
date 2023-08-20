import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Question2870a {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < testCase;i++) {

            String str = br.readLine();
            String[] cut = str.split("\\D"); //d는알파벳만 //D는 숫자만
            //01과같이 앞에 0이존재하면 지움 단 단독으로 0이존재하는것은 지우지 않음
            for (String s : cut) {
                if (!s.equals("")) { //공백이 아니라면 ArraysList에 저장
                    arr.add(new BigInteger(s));
                }
            }
            Collections.sort(arr, new Comparator<BigInteger>() { //Comparator메소드로 정렬
                @Override
                public int compare(BigInteger o1, BigInteger o2) {
                    return o1.compareTo(o2);
                }
            });
        }
        for (BigInteger s : arr) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
