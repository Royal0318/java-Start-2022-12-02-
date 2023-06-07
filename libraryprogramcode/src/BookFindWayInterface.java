import java.util.HashMap;
import java.util.Scanner;

public interface BookFindWayInterface {
    Scanner sc = new Scanner(System.in);

    void selectLookup(HashMap<LibraryManagement, Integer> bookList);
}
