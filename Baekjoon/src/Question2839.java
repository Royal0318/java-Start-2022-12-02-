import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question2839 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int kg = Integer.parseInt(br.readLine());

        if (kg == 3 || kg == 5) {
            System.out.println(1);
        } else if (kg == 4 || kg == 7) {
            System.out.println(-1);
        } else if ((kg % 5) == 0) {
            System.out.println((kg / 5));
        } else if ((kg % 5) == 1 || (kg % 5) == 3) {
            System.out.println((kg / 5) + 1);
        } else if ((kg % 5) == 2 || (kg % 5) == 4) {
            System.out.println((kg / 5) + 2);
        }
    }
}
