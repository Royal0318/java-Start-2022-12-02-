import java.util.HashMap;
import java.util.Scanner;

public interface BookManagementInterface {
    Scanner sc = new Scanner(System.in);
    void bookNumbering (HashMap<LibraryBookManagement, Integer> bookList);
    void inputReleaseDays(HashMap<LibraryBookManagement, Integer> bookList);
    void findBookInformation(HashMap<LibraryBookManagement, Integer> bookList);
    void deleteBook(HashMap<LibraryBookManagement, Integer> bookList);
}
