import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 10;
        String str = "" + a + "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                System.out.println("존재");
            }
        }
    }
}
