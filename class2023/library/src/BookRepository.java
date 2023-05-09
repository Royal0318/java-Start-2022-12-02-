import java.util.ArrayList;
import java.util.Scanner;
public class BookRepository {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SubBookReposity> Books = new ArrayList<>(); //책정보 관련 Arraylist
        ArrayList<UserRepository> peopleInformation = new ArrayList<>(); //회원정보 관련 Arraylist
        int[][] borrowBookList = new int[1000][1000]; //1000명이 1000권까지 생성가능하도록 2차원 배열로 구현
        int password = 0;

        SubBookReposity book1 = new SubBookReposity(1, "마지막기차역", "무라세 다케시", "모모", 2022, 5, 9, false);
        SubBookReposity book2 = new SubBookReposity(2, "홍길동전", "김철수", "신세계출판사", 2015, 2, 3, false);
        Books.add(book1);
        Books.add(book2);

        UserRepository Information = new UserRepository("도현우", 1, "경기도 성남시", 2042, 3218, borrowBookList, false);
        peopleInformation.add(Information);

        UserRepository subUserRepository = new UserRepository();
        SubBookReposity subInformation = new SubBookReposity();

        //메인메뉴 UI
        while (true) {
            System.out.println("\n===========================A 도서관 관리프로그램입니다===========================");
            System.out.println("안내 : 원하는 메뉴의 번호를 입력해주세요");
            System.out.println("1.도서 대여 \n2.도서 반납 \n3.도서 삭제 \n4.도서 등록 \n5.도서 수정 \n6.등록된 책 모두 보기 \n7.책 찾기 \n8.회원관리(관리자 모드) \n9.시스템 종료");
            int menuChoice = sc.nextInt();

            if (menuChoice == 1) { //도서 대여
                book1.inputBorrowBook(sc, peopleInformation, Books);
            }
            else if (menuChoice == 2) { //도서 반납
                book1.returnBook(sc, peopleInformation, Books);
            }
            else if (menuChoice == 3) { //도서 삭제
                book1.deleteBook(sc, Books);
            }
            else if (menuChoice == 4) { //도서 등록
                System.out.println("<<<책 등록절차를 시작합니다>>>");
                book1.inputBookRegistration(sc, Books);
            }
            else if (menuChoice == 5) { //도서 수정
                book1.modifyBookInformation(sc,Books);
            }
            else if (menuChoice == 6) { //등록된 책 모두 보기
                System.out.println("<<<A도서관 전체 책 정보입니다>>>");
                book1.loadTotalBookInformation(Books);
            }
            else if (menuChoice == 7) { //책 찾기
                System.out.println("1.제목으로 찾기 2.책 번호로 찾기 3.작가 이름으로 찾기 4.이전으로 돌아가기");
                int findBookMenuChoice = sc.nextInt();

                switch (findBookMenuChoice) {
                    case 1 : //제목으로 찾기
                        book1.findBookTitle(sc,Books);
                        break;
                    case 2 : //번호로 찾기
                        book1.findBookNumber(sc, Books);
                        break;
                    case 3 : //작가 이름으로 찾기
                        book1.findBookWriterName(sc,Books);
                        break;
                    case 4 : //이전을 돌아가기
                        System.out.println("안내 : 메인메뉴로 돌아갑니다");
                        break;
                    default :
                        System.out.println("잘못된 입력입니다");
                        break;
                }
            }
            else if (menuChoice == 8) {//회원관리
                    if (password == 0) { //초기 비밀번호 설정
                        System.out.println("회원관리를 위한 초기 비밀번호 4자리를 설정해주세요");
                        int newPassword = sc.nextInt();

                        if (newPassword >= 1000 && newPassword <= 9999) {
                            System.out.println("설정이 완료되었습니다 비밀번호는 "+newPassword+"입니다");
                            password = newPassword;
                        } else {
                            System.out.println("잘못된 입력입니다 다시 설정해주세요");
                        }
                    }
                    else { //초기 비밀번호 설정 후
                        System.out.println("비밀번호 4자리를 입력해주세요");
                        int passwordInput = sc.nextInt();

                        if (passwordInput == password) {
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
                        } else {
                            System.out.println("틀린 비밀번호입니다 다시 시도해주세요");
                        }
                    }
            }
            else if (menuChoice == 9) { //프로그램 종료
                System.out.println("프로그램을 종료합니다");
                break;
            }
            else { //그 외의 번호 입력시
                System.out.println("잘못된 입력입니다");
            }

        }
    }
}