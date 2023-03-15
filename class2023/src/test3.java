import java.util.ArrayList;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < 5 ; i ++) {
          arr.add(sc.next());
        }
        System.out.println("입력");
        int a = sc.nextInt();

        System.out.println(""+arr.get(a)+"");
    }
}
