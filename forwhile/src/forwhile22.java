import java.util.Scanner;

public class forwhile22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] foodArrayIndex = new int[3][2];
        forwhile23 object = new forwhile23(3,0,0,foodArrayIndex);
        forwhile23 emptyObject = new forwhile23();
        object.ageInput(sc);
    }
}
