import java.util.Scanner;

public class Question1120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String one = sc.next();
        String two = sc.next();
        int count = 0;

        int min = 51;
        char[] arr = new char[two.length()];
        String str = ""+one+"";
        String str2 = ""+two+"";


        for (int i = 0; i < (str2.length() - str.length() + 1);i++) {
            int check = 0;

            for (int j = i; j < (one.length() + i);j++) {
                arr[j] = str.charAt(j - count);
            }
            for (int j = i; j < (one.length() + count);j++) {

                if (arr[j] != str2.charAt(j)) {
                    check += 1;
                }
            }
            if (min > check) {
                min = check;
            }
            count += 1;
        }
        System.out.println(min);
    }
}
