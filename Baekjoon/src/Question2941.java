import java.util.Scanner;

public class Question2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'c') {
                if (i < str.length() - 1) {
                    if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                        i += 1;
                    }
                }
            } else if (str.charAt(i) == 'd') {
                if (i < str.length()-1) {
                    if (str.charAt(i + 1) == 'z') {
                        if (i < str.length()-2) {
                            if (str.charAt(i + 2) == '=') {
                                i += 2;
                            }
                        }
                    } else if (str.charAt(i + 1) == '-') {
                        i += 1;
                    }
                }
            } else if (str.charAt(i) == 'l') {
                if (i < str.length()-1) {
                    if (str.charAt(i + 1) == 'j') {
                        i += 1;
                    }
                }
            } else if (str.charAt(i) == 'n') {
                if (i < str.length()-1) {
                    if (str.charAt(i + 1) == 'j') {
                        i += 1;
                    }
                }
            } else if (str.charAt(i) == 's') {
                if (i < str.length()-1) {
                    if (str.charAt(i + 1) == '=') {
                        i += 1;
                    }
                }
            } else if (str.charAt(i) == 'z') {
                if (i < str.length()-1) {
                    if (str.charAt(i + 1) == '=') {
                        i += 1;
                    }
                }
            }
            result += 1;
        }
        System.out.println(result);
    }
}
