import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question9342 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < testCase;i++) {
            String str = br.readLine();
            boolean check = false;

            for (int j = 0 ; j < str.length() - 1;j++) {
                if (str.charAt(j) == 'A' || str.charAt(j) == 'B' || str.charAt(j) == 'C' || str.charAt(j) == 'D' || str.charAt(j) == 'E' || str.charAt(j) == 'F') {
                    if (str.charAt(j) != str.charAt(j + 1)) {
                        if (str.charAt(j) == 'A' && str.charAt(j + 1) != 'F') {
                            check = true;
                            break;
                        }
                        else if (str.charAt(j) == 'F' && str.charAt(j + 1) != 'C') {
                            check = true;
                            break;
                        }
                        else if (str.charAt(j) == 'C' && j != str.length() - 1) {
                            check = true;
                            break;
                        }
                    }
                }
                else {
                    check = true;
                    break;
                }
            }
            if (check) sb.append("Good").append("\n");
            else sb.append("Infected!").append("\n");
        }
        System.out.println(sb);
    }
}
