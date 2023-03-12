import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class codeup1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (f(n) == 2) {
            System.out.println("prime");
        } else {
            System.out.println("composite");
        }

    }
    static int f (int n) {
       int start = 1;
       int check = 0;
       while (start <= n) {
           if ((n/start) >= 1 && (n%start) == 0) { //소수의조건 : 몫은 존재하지만 나머지는 존재하지않음
               check += 1;
           }
           start++;
       }
       return check;
    }
}
