import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class codeup1548 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());

        if (f(score) == 1) {
            System.out.println("A");
        } else if (f(score) == 2) {
            System.out.println("B");
        } else if (f(score) == 3) {
            System.out.println("C");
        } else if (f(score) == 4) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
    static int f (int score) {
        if (score >= 90 && score <= 100) {
            return 1;
        } else if (score < 90 && score >= 80) {
            return 2;
        } else if (score < 80 && score >= 70) {
            return 3;
        } else if (score < 70 && score >= 60) {
            return 4;
        } else {
            return 5;
        }
    }
}
