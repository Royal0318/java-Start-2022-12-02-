import java.util.HashMap;
import java.util.Scanner;

public interface Member_Management_Interface {
    Scanner sc = new Scanner(System.in);

    void memberNumbering (HashMap<LibraryMemberManagement, Integer> memberList);
    void memberRegistrationDate (HashMap<LibraryMemberManagement, Integer> memberList);
}
