
import java.util.ArrayList;
import java.util.Scanner;


public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Library2> Books = new ArrayList<>();
        String[] memberName = new String[1000];
        int[] memberNumber = new int[1000];
        String[] memberAddress = new String[1000];
        int[][] memberPhoneNumber = new int[1000][2];
        int[][] borrowBookList = new int[1000][1000];
        //배열값을 1000으로 잡아서 총 1000까지 등록이 가능하도록 설정

        //등록전 도서관에 10권을 미리 등록한다
        Library2 book1 = new Library2(1, "세상의 마지막 기차역", "무라세 다케시", "모모", 2022, 5, 9, 0, memberName, memberNumber, memberAddress, memberPhoneNumber, borrowBookList);
        Library2 book2 = new Library2(2, "조금 서툴더라도 네 인생을 응원해", "자희독서희", "미디어숲", 2022, 11, 20, 0, memberName, memberNumber, memberAddress, memberPhoneNumber, borrowBookList);
        Library2 book3 = new Library2(3, "역행자", "자청", "웅진지식하우스", 2022, 6, 3, 0, memberName, memberNumber, memberAddress, memberPhoneNumber, borrowBookList);
        Library2 book4 = new Library2(4, "마흔에 읽는 니체", "장재형", "유노북스", 2022, 9, 1, 0, memberName, memberNumber, memberAddress, memberPhoneNumber, borrowBookList);
        Library2 book5 = new Library2(5, "천원을 경영하라", "박정부", "쌤엔파커스", 2022, 12, 1, 0, memberName, memberNumber, memberAddress, memberPhoneNumber, borrowBookList);
        Library2 book6 = new Library2(6, "하얼빈", "김훈", "문학동네", 2022, 8, 3, 0, memberName, memberNumber, memberAddress, memberPhoneNumber, borrowBookList);
        Library2 book7 = new Library2(7, "불편한편의점2", "미등록", "미등록", 2022, 5, 4, 0, memberName, memberNumber, memberAddress, memberPhoneNumber, borrowBookList);
        Library2 book8 = new Library2(8, "조국의 법고전 산책", "조국", "오마이북", 2022, 11, 9, 0, memberName, memberNumber, memberAddress, memberPhoneNumber, borrowBookList);
        Library2 book9 = new Library2(9, "아버지의 해방일지", "정지아", "창비", 2022, 9, 2, 0, memberName, memberNumber, memberAddress, memberPhoneNumber, borrowBookList);
        Library2 book10 = new Library2(10, "트랜드코리아", "김난도", "미래의창", 2022, 10, 5, 0, memberName, memberNumber, memberAddress, memberPhoneNumber, borrowBookList);
        Books.add(book1);
        Books.add(book2);
        Books.add(book3);
        Books.add(book4);
        Books.add(book5);
        Books.add(book6);
        Books.add(book7);
        Books.add(book8);
        Books.add(book9);
        Books.add(book10);

        Library2 subObject = new Library2();
        //서브 생성자

        /*
        메소드 역할 : 가장 먼저 실행했을때 실행되는 메소드이며 사용자가 원하는 메뉴의 번호를 입력했을 시 해당
        메소드로 이동되게 한다

        메소드 기능 : 프로그램 사용자가 원하는 번호를 입력시 해당 메소드로 이동
         */
        while (true) {
            System.out.println("\n=======A 도서관 관리 프로그램입니다=======");
            System.out.println("1.도서 찾기 2.도서 등록 3.도서 반납 4.도서 대여 5.회원등록 6.회원조회 7.전체 책 조회 8.시스템 종료");
            int menuChoice = sc.nextInt();

            //메인메뉴는 if문보다 스위치문이 코드를 보는 가독성이 더 좋기 때문에 switch를 사용
            switch (menuChoice) {
                case 1:
                    System.out.println("어떤 방법으로 찾으시겠습니까?");
                    System.out.println("1.책 이름으로 찾기 2.작가 이름으로 찾기 3.출판사로 찾기 4.책 번호로 찾기");
                    int selectMethod = sc.nextInt();

                    if (selectMethod == 1) {
                        book1.findByBookName(sc, Books);
                    } else if (selectMethod == 2) {
                        book1.findByWriterName(sc, Books);
                    } else if (selectMethod == 3) {
                        book1.findByPublisherName(sc, Books);
                    } else if (selectMethod == 4) {
                        book1.findByBookNumber(sc, Books);
                    } else {
                        System.out.println("잘못된 입력입니다");
                    }
                    break;
                case 2:
                    book1.inputBookRegistration(sc, Books);
                    break;
                case 3:
                    book1.inputBookReturn(sc, Books);
                    break;
                case 4:
                    book1.inputBookBorrowMenu(sc, Books);
                    break;
                case 5:
                    book1.inputMemberName(sc);
                    break;
                case 6:
                    book1.findMemberInformation(sc, Books);
                    break;
                case 7:
                    book1.findTotalBookList(Books);
                    break;
                case 8:
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 입력입니다");
                    break;
            }
        }
    }
}
