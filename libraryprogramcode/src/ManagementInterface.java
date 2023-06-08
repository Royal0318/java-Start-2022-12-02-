import java.util.HashMap;
import java.util.Scanner;

public interface ManagementInterface {
    Scanner sc = new Scanner(System.in);
    void bookNumbering (HashMap<LibraryManagement, Integer> bookList);
    void inputReleaseDays(HashMap<LibraryManagement, Integer> bookList);
    void findBookInformation(HashMap<LibraryManagement, Integer> bookList);
}
