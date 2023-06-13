import java.util.LinkedHashMap;
import java.util.Scanner;

public class libraryMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManagementInterface managementInterface = new LibraryBookManagement(); //회원관리 인스턴스

        BookFindWayInterface bookFindWayInterface = new LibraryBookFindWay(); //책 찾기 인스턴스

        Member_Management_Interface member_management_interface = new LibraryMemberManagement(); //회원관련 인스턴스

        LinkedHashMap<LibraryBookManagement, Integer> bookList = new LinkedHashMap<>(); //책관련 해시
        LinkedHashMap<LibraryMemberManagement,Integer> memberList = new LinkedHashMap<>(); //회원관련 해시

        LibraryBookManagement book1 = new LibraryBookManagement("세이노의 가르침","데이원","세이노",2023,3,2);
        LibraryBookManagement book2 = new LibraryBookManagement("역행자","웅진지식하우스","자청",2023,5,29);
        LibraryBookManagement book3 = new LibraryBookManagement("상식을 뒤엎는 돈의 심리학","미디어숲","저우신위에",2023,6,30);
        LibraryBookManagement book4 = new LibraryBookManagement("사장학개론","스노우폭스북스","김승호",2023,4,19);
        LibraryBookManagement book5 = new LibraryBookManagement("유연함의 힘","상상스퀘어","수잔 애쉬포드",2023,5,10);
        LibraryBookManagement book6 = new LibraryBookManagement("도둑맞은 집중력","어크로스","요한 하리",2023,4,28);
        LibraryBookManagement book7 = new LibraryBookManagement("모든 삶은 흐른다","피카","로랑스 드빌레르",2023,4,3);
        bookList.put(book1, 1);
        bookList.put(book2, 1);
        bookList.put(book3, 1);
        bookList.put(book4, 1);
        bookList.put(book5, 1);
        bookList.put(book6, 1);
        bookList.put(book7, 1);

        LibraryMemberManagement member1 = new LibraryMemberManagement("홍길동","경기도 성남시 분당구 그린아파트 102동 301호","010-2256-1313","2023년 3월 1일");
        LibraryMemberManagement member2 = new LibraryMemberManagement("김민재","경기도 성남시 분당구 청솔아파트 1101동 501호","010-3322-4562","2023년 4월 3일");
        LibraryMemberManagement member3 = new LibraryMemberManagement("최형민","경기도 광주시 쌍령동 현대아파트 101동 606호","010-0225-9811","2023년 12월 1일");

        memberList.put(member1, 1);
        memberList.put(member2, 2);
        memberList.put(member3, 3);

        while (true) {
            System.out.println("==============A도서관 관리 프로그램입니다==============");
            System.out.println("1.책 관리 2.회원관리 3.관리자모드 4.시스템종료");

            int menuChoice = sc.nextInt();

            if (menuChoice == 1) {
                while (true) {
                    System.out.println("1.책 등록 2.책 수정 3.책 삭제 4.책 찾기 5.돌아가기");

                    int bookManagementMenuChoice = sc.nextInt();

                    if (bookManagementMenuChoice == 1) {
                        System.out.println("책 등록을 시작합니다");
                        managementInterface.bookNumbering(bookList);
                        managementInterface.inputReleaseDays(bookList);
                        break;
                    }
                    else if (bookManagementMenuChoice == 2) {
                        managementInterface.findBookInformation(bookList);
                        break;
                    }
                    else if (bookManagementMenuChoice == 3) {
                        managementInterface.deleteBook(bookList);
                        break;
                    }
                    else if (bookManagementMenuChoice == 4) {
                        bookFindWayInterface.selectLookup(bookList);
                        break;
                    }
                    else if (bookManagementMenuChoice == 5) {
                        System.out.println("메인메뉴로 돌아갑니다");
                        break;
                    }
                    else {
                        System.out.println("잘못된 입력입니다 다시 입력해주세요");
                    }
                }
            }
            else if (menuChoice == 2) {
                while (true) {
                    System.out.println("1.회원 정보 조회 2.회원 등록 3.회원 삭제 4.돌아가기");

                    int memberManagementMenuChoice = sc.nextInt();

                    if (memberManagementMenuChoice == 1) {

                    } else if (memberManagementMenuChoice == 2) {
                        member_management_interface.memberNumbering(memberList);
                        member_management_interface.memberRegistrationDate(memberList);
                        break;
                    } else if (memberManagementMenuChoice == 3) {

                    } else if (memberManagementMenuChoice == 4) {

                    } else {
                        System.out.println("잘못된 입력입니다 다시 입력해주세요");
                    }
                }
            }
            else if (menuChoice == 3) {
                System.out.println("관리자 비밀번호 4자리를 입력해주세요 (초기 비밀번호는 0000입니다)");

                int password = sc.nextInt();

                if (password >= 1000 && password <= 9999) {

                }
                else {
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
