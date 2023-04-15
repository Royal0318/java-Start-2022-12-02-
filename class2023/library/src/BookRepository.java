import java.util.ArrayList;
import java.util.Scanner;

public class BookRepository {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SubBookReposity> Books = new ArrayList<>(); //책정보관리 Array
        ArrayList<UserRepository> peopleInformation = new ArrayList<>(); //회원정보

        String[] memberName = new String[1000];
        int[] memberNumber = new int[1000];
        String[] memberAddress = new String[1000];
        int[][] memberPhoneNumber = new int[1000][2];
        int[][] borrowBookList = new int[1000][1000];


        UserRepository Information = new UserRepository(memberName, memberNumber, memberAddress, memberPhoneNumber, borrowBookList);
        peopleInformation.add(Information);

        SubBookReposity book1 = new SubBookReposity(1, "세상의 마지막 기차역", "무라세 다케시", "모모", 2022, 5, 9);
        SubBookReposity book2 = new SubBookReposity(2, "홍길동전", "김철수", "신세계출판사", 2015, 2, 3);
        Books.add(book1);
        Books.add(book2);

        SubBookReposity subInformation = new SubBookReposity();

        while (true) {
            System.out.println("================A 도서관 관리프로그램입니다================");
            System.out.println("1.도서 찾기 2.도서 등록 3.도서 반납 4.도서 대여 5.회원등록 6.회원조회 7.전체 책 조회 8.시스템 종료");
            int menuChoice = sc.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.println("1.책 제목으로 검색 2.책 번호로 검색 3.책 작가 이름으로 검색");
                    int findBookMenuChoice = sc.nextInt();

                    if (findBookMenuChoice == 1) {
                        book1.findBookTitle(sc,Books);
                    } else if (findBookMenuChoice == 2) {
                        book1.findBookNumber(sc,Books);
                    } else if (findBookMenuChoice == 3) {
                        book1.findBookWriterName(sc,Books);
                    } else {
                        System.out.println("잘못된 입력입니다");
                        break;
                    }
                case 2:
                    System.out.println("책 등록절차를 시작합니다");
                    book1.inputBookRegistration(sc, Books);
                    break;
                case 3:
                    book1.returnBook(sc,Books);
                    break;
                case 4:
                    book1.borrowBook(sc, Books);
                    break;
                case 5:
                    UserRepository.memberRegistrationName(sc,peopleInformation);
                    break;
                case 6:
                    UserRepository.findPeopleInformation(sc,peopleInformation);
                    break;
                case 7:
                    book1.findTotalBookInformation(Books);
                    break;
                case 8:
                    System.out.println("프로그램을 종료합니다");
                    return;
                default:
                    System.out.println("잘못된 입력입니다");
                    break;
            }
        }
    }
}