import java.util.ArrayList;
import java.util.Scanner;

public class Library2 {
    String BookName;
    String Bookwriter;
    String BookPublisher;
    int Price;
    int BookNumber;


    Library2 (String BookName,String Bookwriter, String BookPublisher,int Price,int  BookNumber) {
        this.BookName = BookName;
        this.Bookwriter = Bookwriter;
        this.BookPublisher = BookPublisher;
        this.Price = Price;
        this.BookNumber = BookNumber;
    }
    void BookTotallistoutput (int BookNumberCount) {
        //전체 책 리스트 출력
        for (int i = 0; i < BookNumberCount; i++) { //등록한 책만큼 출력
            System.out.println("도서 이름 : " + BookName + "");
            System.out.println("작가 : " + Bookwriter + "");
            System.out.println("출판사 : " + BookPublisher + "");
            System.out.println("가격 : " + Price + "원");
            System.out.println("번호 : " + BookNumber + "");
            System.out.println("================================");
        }
    }
    void BookBorrowMet (ArrayList<Library2> ArrayOutput,int BookNumberCount) {
        Scanner sc = new Scanner(System.in);
        //책 빌려주기
        for (Library2 arr : ArrayOutput) {
            arr.BookTotallistoutput(BookNumberCount);
        }
        System.out.println("빌리고싶은 책의 이름을 입력하세요");
        String BookChoice = sc.next();

        if (BookChoice.equals(""+BookName+"")) {
          //빌리기
        }
    }
}
