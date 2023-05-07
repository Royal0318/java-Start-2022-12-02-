import java.util.ArrayList;
import java.util.Scanner;
public class BookRepository {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SubBookReposity> Books = new ArrayList<>(); //책정보 관련 Arraylist
        ArrayList<UserRepository> peopleInformation = new ArrayList<>(); //회원정보 관련 Arraylist
        int[][] borrowBookList = new int[1000][1000]; //1000명이 1000권까지 생성가능하도록 2차원 배열로 구현

        SubBookReposity book1 = new SubBookReposity(1, "마지막기차역", "무라세 다케시", "모모", 2022, 5, 9, false);
        SubBookReposity book2 = new SubBookReposity(2, "홍길동전", "김철수", "신세계출판사", 2015, 2, 3, false);
        Books.add(book1);
        Books.add(book2);

        UserRepository Information = new UserRepository("도현우", 1, "경기도 성남시", 2042, 3218, borrowBookList, false);
        peopleInformation.add(Information);

        UserRepository subUserRepository = new UserRepository();
        SubBookReposity subInformation = new SubBookReposity();

        //메인메뉴
        while (true) {
            System.out.println("\n===========================A 도서관 관리프로그램입니다===========================");
            System.out.println("1.책 관리 2.회원관리 3.도서 대여 4.도서 반납 5.도서 삭제 6.시스템 종료");
            int menuChoice = sc.nextInt();

            if (menuChoice == 1) {
                System.out.println("1.책 전체 목록 보기 2.제목으로 책 검색 3.번호로 책 검색 4.책 작가 이름으로 검색 5.도서 등록 6.도서 수정 7.이전으로 돌아가기");

                int findBookMenuChoice = sc.nextInt();

                switch (findBookMenuChoice) {
                    case 1: //책 전체 목록 보기
                        System.out.println("<<<A도서관 전체 책 정보입니다>>>");
                        book1.loadTotalBookInformation(Books);
                        break;
                    case 2: //제목으로 책 검색
                        book1.findBookTitle(sc,Books);
                        break;
                    case 3: //번호로 책 검색
                        book1.findBookNumber(sc, Books);
                        break;
                    case 4 : //책 작가 이름으로 검색
                        book1.findBookWriterName(sc,Books);
                        break;
                    case 5 : //도서등록
                        System.out.println("<<<책 등록절차를 시작합니다>>>");
                        book1.inputBookRegistration(sc, Books);
                        break;
                    case 6 : //도서 수정
                        book1.modifyBookInformation(sc,Books);
                        break;
                    case 7 : //돌아가기
                        System.out.println("안내 : 메인메뉴로 돌아갑니다");
                        break;
                    default:
                        System.out.println("잘못된 입력입니다");
                        break;
                }
            } else if (menuChoice == 2) {
                System.out.println("1.회원조회 2.회원등록 3.회원삭제 4.전체 회원조회 5.돌아가기");
                int managementMenuChoice = sc.nextInt();

                switch (managementMenuChoice) {
                    case 1: //회원조회
                        UserRepository.findPeopleInformation(sc, Books, peopleInformation);
                        break;
                    case 2: //회원등록
                        UserRepository.memberRegistrationName(sc, peopleInformation, borrowBookList);
                        break;
                    case 3: //회원삭제
                        UserRepository.deleteMemberInformation(sc, peopleInformation);
                        break;
                    case 4: //전체 회원조회
                        System.out.println("<<<A도서관 전체 회원정보입니다>>>");
                        UserRepository.loadMemberInformation(peopleInformation);
                        break;
                    case 5: //돌아가기
                        System.out.println("안내 : 메인메뉴로 돌아갑니다");
                        break;
                    default:
                        System.out.println("잘못된 입력입니다 다시 입력해주세요");
                        break;
                }
            } else if (menuChoice == 3) { //도서 대여
                book1.inputBorrowBook(sc, peopleInformation, Books);
            } else if (menuChoice == 4) { //도서 반납
                book1.returnBook(sc, peopleInformation, Books);
            } else if (menuChoice == 5) {
                book1.deleteBook(sc, Books);
            } else if (menuChoice == 6) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
}