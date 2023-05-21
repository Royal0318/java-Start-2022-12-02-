import java.util.ArrayList;
import java.util.Scanner;

public class getsetMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<banktest> people = new ArrayList<>();

        banktest arr = new banktest();

        arr.inputInformation(people,sc);
        arr.outputOrder(people);
    }
}
