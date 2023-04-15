import java.util.Scanner;

public class Question2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String asc = "1 2 3 4 5 6 7 8";
        String des = "8 7 6 5 4 3 2 1";

        int check = 0;
        int check2 = 0;
        String str = sc.nextLine();
        for (int i = 0; i < 15;i++) {
            if (str.charAt(i) == asc.charAt(i)) {
                check += 1;
            }
            if (str.charAt(i) == des.charAt(i)) {
                check2 += 1;
            }
        }
        if (check == 15) {
            System.out.println("ascending");
        } else if (check2 == 15) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
