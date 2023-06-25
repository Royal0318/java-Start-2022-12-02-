import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase;i++) {
            int money = Integer.parseInt(br.readLine());

            int Quarter = 0;
            int Dime = 0;
            int Nickel = 0;
            int Penny = 0;

            if (money >= 25) {
                Quarter = (money / 25);
                money -= (25 * Quarter);
            }
            if (money >= 10) {
                Dime = (money / 10);
                money -= (10 * Dime);
            }
            if (money >= 5) {
                Nickel = (money / 5);
                money -= (5 * Nickel);
            }
            if (money >= 1) {
                Penny = money;
            }
            System.out.println(""+Quarter+" "+Dime+" "+Nickel+" "+Penny+"");
        }
    }
}
