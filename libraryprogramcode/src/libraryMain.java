import java.util.HashMap;
import java.util.Scanner;

public class libraryMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManagementInterface managementInterface = new LibraryManagement();
        BookFindWayInterface bookFindWayInterface = new LibraryBookFindWay();

        HashMap<LibraryManagement, Integer> bookList = new HashMap<>();

        LibraryManagement book1 = new LibraryManagement("세이노의 가르침","데이원","세이노",2023,3,2);
        LibraryManagement book2 = new LibraryManagement("역행자","웅진지식하우스","자청",2023,5,29);
        LibraryManagement book3 = new LibraryManagement("상식을 뒤엎는 돈의 심리학","미디어숲","저우신위에",2023,6,30);
        LibraryManagement book4 = new LibraryManagement("사장학개론","스노우폭스북스","김승호",2023,4,19);
        LibraryManagement book5 = new LibraryManagement("유연함의 힘","상상스퀘어","수잔 애쉬포드",2023,5,10);
        LibraryManagement book6 = new LibraryManagement("도둑맞은 집중력","어크로스","요한 하리",2023,4,28);
        LibraryManagement book7 = new LibraryManagement("모든 삶은 흐른다","피카","로랑스 드빌레르",2023,4,3);
        bookList.put(book1, 1);
        bookList.put(book2, 2);
        bookList.put(book3, 3);
        bookList.put(book4, 4);
        bookList.put(book5, 5);
        bookList.put(book6, 6);
        bookList.put(book7, 7);

        while (true) {
            System.out.println("==============A도서관 관리 프로그램입니다==============");
            System.out.println("1.책 관리 2.회원관리 3.관리자모드 4.시스템종료");

            int menuChoice = sc.nextInt();

            if (menuChoice == 1) {
                System.out.println("1.책 등록 2.책 수정 3.책 삭제 4.책 찾기 5.돌아가기");

                int bookManagementMenuChoice = sc.nextInt();

                if (bookManagementMenuChoice == 1) {
                    System.out.println("책 등록을 시작합니다");
                    managementInterface.bookNumbering(bookList);
                }
                else if (bookManagementMenuChoice == 2) {

                }
                else if (bookManagementMenuChoice == 3) {

                }
                else if (bookManagementMenuChoice == 4) {
                    bookFindWayInterface.selectLookup(bookList);
                }
                else if (bookManagementMenuChoice == 5) {
                    System.out.println("메인메뉴로 돌아갑니다");
                }
                else {
                    System.out.println("잘못된 입력입니다 다시 입력해주세요");
                }
            }
            else if (menuChoice == 2) {
                System.out.println("1.회원 정보 조회 2.회원 등록 3.회원 삭제 4.돌아가기");

                int memberManagementMenuChoice = sc.nextInt();

                if (memberManagementMenuChoice == 1) {

                }
                else if (memberManagementMenuChoice == 2) {

                }
                else if (memberManagementMenuChoice == 3) {

                }
                else if (memberManagementMenuChoice == 4) {

                }
                else {
                    System.out.println("잘못된 입력입니다 다시 입력해주세요");
                }
            }
            else if (menuChoice == 3) {
                System.out.println("관리자 비밀번호 4자리를 입력해주세요 (초기 비밀번호는 0000입니다)");

                int password = sc.nextInt();

                if (password >= 1000 && password <= 9999) {

                } else {
                    System.out.println("잘못된 입력입니다 다시 입력해주세요");
                }
            }
            else if (menuChoice == 4) {
                System.out.println("시스템을 종료합니다");
                break;
            }
            else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }
    }
}
/*
import java.util.*;

public class BookManager {
    public static void main(String[] args) {
        HashMap<String, Book> bookMap = new HashMap<>();

        Book book1 = new Book("알고리즘", "방송통신", 1997);
        Book book2 = new Book("알고리즘2", "방송통신2", 1996);
        Book book3 = new Book("알고리즘3", "방송통신3", 1995);

        bookMap.put("1번째 책", book1);
        bookMap.put("2번째 책", book2);
        bookMap.put("3번째 책", book3);

        for (String key : bookMap.keySet()) {
            Book book = bookMap.get(key);
            System.out.println(key + " - " + book.getTitle() + " / " + book.getPublisher() + " / " + book.getYear());
        }
    }
}

class Book {
    private String title;
    private String publisher;
    private int year;

    public Book(String title, String publisher, int year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }
}

 */
