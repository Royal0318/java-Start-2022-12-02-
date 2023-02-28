import java.util.Scanner;

public class Array4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] age = new int[5][5];
        int[][] familyMembers = new int[5][5];
        int[][] phoneFrontNumber = new int[5][5];
        int[][] phoneBackNumber = new int[5][5];
        String[][] name = new String[5][5];
        Array5 object = new Array5(age,familyMembers,phoneFrontNumber,phoneBackNumber,name);
        Array5 subObject = new Array5();
        object.systemMainMenu(sc);
    }
}
