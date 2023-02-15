import java.util.ArrayList;
import java.util.Scanner;

public class forwhile27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ar = new ArrayList<>();
        int TotalChance = 5;
        int Sevencount = 0;
        int Sum = 0;
        System.out.println("총 index 개수를 입력");
        int Totalindex = sc.nextInt();
        forwhile28 test = new forwhile28(Totalindex,TotalChance,Sevencount,Sum);

        test.Numberinput(ar);
    }
}
