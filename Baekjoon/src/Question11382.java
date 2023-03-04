import java.io.*;
import java.util.Scanner;

public class Question11382 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        System.out.println(""+(a + b + c)+"");
        //이 문제는 범위가 10 ^ 12까지 존재하므로 int형으로는 받을 수 없다 그러므로 long을 통해받으며 만약 long보다 클경우 Bigintiger를 사용한다
    }
}
