import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int count = 0;
        char[] arr = new char[4];
        arr[0] = 'U';
        arr[1] = 'C';
        arr[2] = 'P';
        arr[3] = 'C';
        for (int i = 0; i < str.length();i++) {
            if (count == 4) { //count가 4인경우는 UCPC를 모두찾았다는 뜻이므로 탈출
                break;
            } else { //그렇지않고 알파벳이 같은경우 count추가
                if (str.charAt(i) == arr[count]) {
                    count += 1;
                }
            }
        }
        if (count == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}
