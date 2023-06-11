import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question14490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] cut = str.split(":");
        int firstNumber = Integer.parseInt(cut[0]);
        int secondNumber = Integer.parseInt(cut[1]);

        int a = gcd(firstNumber,secondNumber);
        System.out.println(""+(firstNumber/a)+":"+(secondNumber/a)+"");
    }
    public static int gcd (int a,int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, (a % b));
    }
}
