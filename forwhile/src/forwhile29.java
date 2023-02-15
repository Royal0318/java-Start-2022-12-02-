import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class forwhile29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Sum = 0;
        int Chance = 5;
        int Sevencount = 0;
        List<Integer> numbertest = new ArrayList<>();
        System.out.println("총 몇번을 받으시겠습니까?");
        int Totalindex = sc.nextInt();
        forwhile30 arr = new forwhile30(Sum,Sevencount,Totalindex,Chance,numbertest);
        arr.Numberinput();
    }
}
