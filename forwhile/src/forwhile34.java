import java.util.ArrayList;
import java.util.Scanner;

public class forwhile34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Startsum = 0;
        int Lastsum = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("전체 인덱스 크기를 정해주세요");
        int Totalindex = sc.nextInt();
        forwhile35 test = new forwhile35(Totalindex,Startsum,Lastsum);
        test.Numberinput(arr);
    }
}
