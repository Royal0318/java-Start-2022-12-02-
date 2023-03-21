import java.io.*;

public class Question17614b {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        System.out.println(f(n, count));
    }

    static int f(int n, int count) {
        if (n == 1) {
            return count;
        } else {
            String str = ""+n+"";
            for (int i = 0; i < str.length();i++) {
                if (str.charAt(i) == '3' || str.charAt(i) == '6' || str.charAt(i) == '9'){
                    count += 1;
                }
            }
        }
        return f(n - 1, count);
    }
}
