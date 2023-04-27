import java.util.ArrayList;
import java.util.Scanner;

public class BookRepository {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SubBookReposity> Books = new ArrayList<>(); //책정보 관련 Arraylist
        ArrayList<UserRepository> peopleInformation = new ArrayList<>(); //회원정보 관련 Arraylist

        int[][] borrowBookList = new int[1000][1000]; //1000명이 1000권까지 생성가능하도록 2차원 배열로 구현

        SubBookReposity book1 = new SubBookReposity(1, "마지막기차역", "무라세 다케시", "모모", 2022, 5, 9,false);
        SubBookReposity book2 = new SubBookReposity(2, "홍길동전", "김철수", "신세계출판사", 2015, 2, 3,false);
        Books.add(book1);
        Books.add(book2);

        UserRepository Information = new UserRepository("도현우", 1, "경기도 성남시", 2042,3218,borrowBookList);

        peopleInformation.add(Information);


        /*
        UserRepository subUserRepository = new UserRepository();
        SubBookReposity subInformation = new SubBookReposity();
         */

        //메인메뉴
        while (true) {
            System.out.println("\n================A 도서관 관리프로그램입니다================");
            System.out.println("1.도서 찾기 2.도서 등록 3.도서 반납 4.도서 대여 5.도서 삭제 6.회원등록 7.회원조회 8.전체 책 조회 9.시스템 종료");
            int menuChoice = sc.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.println("1.책 제목으로 검색 2.책 번호로 검색 3.책 작가 이름으로 검색");
                    int findBookMenuChoice = sc.nextInt();

                    if (findBookMenuChoice == 1) {
                        book1.findBookTitle(sc,Books);
                        break;
                    } else if (findBookMenuChoice == 2) {
                        book1.findBookNumber(sc,Books);
                        break;
                    } else if (findBookMenuChoice == 3) {
                        book1.findBookWriterName(sc,Books);
                        break;
                    } else {
                        System.out.println("잘못된 입력입니다");
                        break;
                    }
                case 2:
                    System.out.println("책 등록절차를 시작합니다");
                    book1.inputBookRegistration(sc, Books);
                    break;
                case 3:
                    book1.returnBook(sc,peopleInformation,Books);
                    break;
                 case 4:
                    book1.borrowBook(sc,peopleInformation,Books);
                    break;
                case 5:
                    book1.bookRemove(sc,Books);
                case 6:
                    UserRepository.memberRegistrationName(sc,peopleInformation,borrowBookList,Books);
                    break;
                case 7:

                    UserRepository.findPeopleInformation(sc,Books,peopleInformation);
                    break;
                case 8:
                    book1.findTotalBookInformation(Books);
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다");
                    return;
                default:
                    System.out.println("잘못된 입력입니다");
                    break;
            }
        }
    }
}