import java.util.ArrayList;
import java.util.Scanner;
public class LibraryProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Library2> ArrayOutput = new ArrayList<>(); //Arraylist 선언
        int BookNumberCount = 1;//책의 총 개수 카운트

        //기존에 도서관에 존재하는 책
        Library2 Book = new Library2("트렌드 코리아 2023", "김난도", "미래의창",19000,2563);
        Library2 Book2 = new Library2("만일 내가 인생을 다시 산다면", "김혜남", "메이븐",17200,6458);
        Library2 Book3 = new Library2("불편한 편의점", "김호연", "나무옆의자",14000,585);
        Library2 Book4 = new Library2("오늘 밤, 세계에서 이 사랑이 사라진다 해도", "이치조 미사키·모모", "일본출판사",14000,339);
        Library2 Book5 = new Library2("흔한남매 12", "흔한남매", "미래엔아이세움",12000,810);

        //기존 책 등록절차
        ArrayOutput.add(Book);
        ArrayOutput.add(Book2);
        ArrayOutput.add(Book3);
        ArrayOutput.add(Book4);
        ArrayOutput.add(Book5);

        while (true) {
            System.out.println("<<<도서관 관리 프로그램입니다>>>\n1.도서관 책 추가 \n2.전체 책 조회 \n3.책 빌리기 \n4.책 정보 삭제 \n5.시스템 종료");
            int Choice = sc.nextInt();

            if (Choice == 1) {
                BookNumberCount += 1; //책을 등록할때 전체 책 카운트
                BookRegistration(ArrayOutput);
            } else if (Choice == 2) { //information을 활성화시키기위한 입력값을 어떻게받음
                Booklistoutput(ArrayOutput,BookNumberCount);
            } else if (Choice == 3) {
                BookBorrow(ArrayOutput,BookNumberCount,Book);
            } else if (Choice == 4) {
                //책삭
            } else if (Choice == 5) {
                System.out.println("시스템을 종료합니다");
                System.exit(1);
            }
        }
    }
    public static void BookRegistration (ArrayList<Library2> ArrayOutput) {
        //새로운 책 등록
        Scanner sc = new Scanner(System.in);
        System.out.println("등록하는 책의 이름을 적어주세요");
        String BookName = sc.next();
        System.out.println("등록하는 책의 작가를 적어주세요");
        String Writer = sc.next();
        System.out.println("등록하는 책의 출판사를 적어주세요");
        String Publisher = sc.next();
        System.out.println("등록하는 책의 가격을 적어주세요 예)10000");
        int Price = sc.nextInt();

        while (true) {
            System.out.println("등록하는 책의 번호 1 ~ 4자리 적어주세요 (1 ~ 9999까지 번호부여가능)");
            int BookNum = sc.nextInt();

            if (BookNum >= 1 && BookNum < 10000) {
                System.out.println("<<<안내 : 등록이 완료되었습니다!!!>>>\n");
                Library2 test2 = new Library2("" + BookName + "", "" + Writer + "", "" + Publisher + "", Price, BookNum);
                ArrayOutput.add(test2);
                //입력한 정보들을 test2에 담아 Arrayoutput에 저장
                return;
                //다시 메인메뉴로 리턴한다
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
    public static void Booklistoutput (ArrayList<Library2> ArrayOutput,int BookNumberCount) {
        //가지고 있는 책 리스트 출력
        System.out.println("<<<현재까지 등록된 책은 총 "+BookNumberCount+"권 입니다>>>\n");
        for (Library2 arr : ArrayOutput) {
            arr.BookTotallistoutput(BookNumberCount);
        }
    }
    public static void BookBorrow (ArrayList<Library2> ArrayOutput, int BookNumberCount,Library2 Book) {
        Book.BookBorrowMet(ArrayOutput,BookNumberCount);
    }
    public static void BookDelete () {
        Scanner sc = new Scanner(System.in);
        //책 정보 삭제
    }
}
