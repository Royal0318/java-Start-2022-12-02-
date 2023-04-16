import java.util.ArrayList;
import java.util.Scanner;

public class SubBookReposity {
    public int bookNumber;
    //책이 가지고있는 고유의번호
    public String bookName;
    //책 이름
    public String bookWriter;
    //책을 쓴 작가
    public String publisher;
    //책의 출판사
    public int releaseYear;
    //책 발매 연도
    public int releaseMonth;
    //책 발매 월
    public int releaseDays;
    //책 발매 일

    SubBookReposity() {

    }

    SubBookReposity(int bookNumber, String bookName, String bookWriter, String publisher, int releaseYear, int releaseMonth, int releaseDays) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.bookWriter = bookWriter;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.releaseDays = releaseDays;
    }

    public void findBookTitle(Scanner sc, ArrayList<SubBookReposity> Books) { //책 제목으로도서찾기
        System.out.println("찾으시는 책 이름을 적어주세요");
        String findBookName = sc.next();

        for (SubBookReposity bookName : Books) {
            if (bookName.bookName.equals(findBookName)) {
                int findBookIndex = Books.indexOf(bookName);
                SubBookReposity index = Books.get(findBookIndex);
                findBookInformation(index);
            }
        }
        System.out.println("해당 책은 존재하지 않습니다");
    }

    public void findBookNumber(Scanner sc, ArrayList<SubBookReposity> Books) { //책 번호으로도서찾기
        System.out.println("찾으시는 책 번호를 적어주세요");
        int findBookNumber = sc.nextInt();

        for (SubBookReposity bookName : Books) {
            if (bookName.bookNumber == findBookNumber) {
                int findBookIndex = Books.indexOf(bookName);
                SubBookReposity index = Books.get(findBookIndex);
                findBookInformation(index);
                break;
            }
        }
        System.out.println("해당 책은 존재하지 않습니다");
    }

    public void findBookWriterName(Scanner sc, ArrayList<SubBookReposity> Books) { //책 작가이름으로도서찾기
        System.out.println("찾으시는 책의 작가 이름을 적어주세요");
        String bookWriter = sc.next();

        for (SubBookReposity bookName : Books) {
            if (bookName.bookName.equals(bookWriter)) {
                int findBookIndex = Books.indexOf(bookName);
                SubBookReposity index = Books.get(findBookIndex);
                findBookInformation(index);
                break;
            }
        }
        System.out.println("해당 책은 존재하지 않습니다");
    }

    public void findBookInformation(SubBookReposity bookIndex) {
        System.out.println("책을 찾았습니다!!!");
        System.out.println("책 번호 : " + bookIndex.bookNumber + "");
        System.out.println("책 이름 : " + bookIndex.bookName + "");
        System.out.println("작가 : " + bookIndex.bookWriter + "");
        System.out.println("출판사 : " + bookIndex.publisher + "");
        System.out.println("발매 연월일 : " + bookIndex.releaseYear + "년 " + bookIndex.releaseMonth + "월 " + bookIndex.releaseDays + "일");
    }

    public void inputBookRegistration(Scanner sc, ArrayList<SubBookReposity> Books) { //책등록
        System.out.println("책 등록번호를 입력해주세요 (1 ~ 200번까지)");
        int registrationBookNumber = sc.nextInt();

        if (registrationBookNumber >= 1 && registrationBookNumber <= 200) {
            for (SubBookReposity findbook : Books) {
                if (findbook.bookNumber == registrationBookNumber) { //이미 등록된 번호인경우
                    System.out.println("이미 등록된 번호입니다 다른 번호를 입력해주세요");
                    inputBookRegistration(sc, Books);
                }
            }
        }
        inputBookRegistration2(sc, Books, registrationBookNumber); //통과되면 다음 순서로 넘김
    }

    public void inputBookRegistration2(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber) {
        System.out.println("등록할 책의 이름을 적어주세요");
        sc.nextLine();
        bookName = sc.nextLine();
        System.out.println("책 이름이 정상적으로 등록되었습니다");
        inputBookRegistration3(sc, Books, registrationBookNumber, bookName);
    }

    public void inputBookRegistration3(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String bookName) {
        System.out.println("작가 이름을 적어주세요");
        bookWriter = sc.nextLine();
        System.out.println("작가 이름이 정상적으로 등록되었습니다");
        inputBookRegistration4(sc, Books, registrationBookNumber, bookName, bookWriter);
    }

    public void inputBookRegistration4(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String bookName, String bookWriter) {
        System.out.println("책 출판사를 적어주세요");
        publisher = sc.nextLine();
        System.out.println("책 출판사를 정상적으로 등록하였습니다");
        inputBookRegistration5(sc, Books, registrationBookNumber, bookName, bookWriter, publisher);
    }

    public void inputBookRegistration5(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String bookName, String bookWriter, String publisher) {
        System.out.println("책 발매 연도를 적어주세요 (1900년 ~ 2023년까지 입력가능)");
        releaseYear = sc.nextInt();

        if (releaseYear >= 1900 && releaseYear <= 2023) {
            System.out.println("연도 등록이 완료되었습니다");
            inputBookRegistration6(sc, Books, registrationBookNumber, bookName, bookWriter, publisher, releaseYear);
        } else {
            System.out.println("잘못된 입력입니다");
            inputBookRegistration5(sc, Books, registrationBookNumber, bookName, bookWriter, publisher);
        }
    }

    public void inputBookRegistration6(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String bookName, String bookWriter, String publisher, int releaseYear) {
        System.out.println("책 발매 월을 적어주세요");
        releaseMonth = sc.nextInt();

        if (releaseMonth >= 1 && releaseMonth <= 12) {
            System.out.println("월 등록이 완료되었습니다");
            inputBookRegistration7(sc, Books, registrationBookNumber, bookName, bookWriter, publisher, releaseYear, releaseMonth);
        } else {
            System.out.println("잘못된 입력입니다");
            inputBookRegistration6(sc, Books, registrationBookNumber, bookName, bookWriter, publisher, releaseYear);
        }
    }

    public void inputBookRegistration7(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String bookName, String bookWriter, String publisher, int releaseYear, int releaseMonth) {
        while (true) {
            System.out.println("책 발매 일을 적어주세요");
            releaseDays = sc.nextInt();

            if (releaseDays >= 1 && releaseDays <= 31) {
                System.out.println("책 등록절차가 모두 완료되었습니다 ");
                SubBookReposity addBookcomplete = new SubBookReposity(registrationBookNumber, bookName, bookWriter, publisher, releaseYear, releaseMonth, releaseDays);
                Books.add(addBookcomplete);
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }

    public void returnBook(Scanner sc, ArrayList<SubBookReposity> Books) {
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 반납이 가능합니다");
        int numberInspection = sc.nextInt();

        for (int i = 0; i <= numberInspection; i++) {
            if (UserRepository.memberNumber == numberInspection) {
                System.out.println("반납하는 책의 제목을 적어주세요");
                String returnBookName = sc.next();

                checkBooksInformation(returnBookName, Books, sc, numberInspection, 1);
            }
        }
        System.out.println("존재하지 않는 회원 번호입니다 다시한번 확인해주세요");

    }

    public void borrowBook(Scanner sc, ArrayList<SubBookReposity> Books) {
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 빌리기가 가능합니다");
        int numberInspection = sc.nextInt();

        for (int i = 0; i <= numberInspection; i++) {
            if (UserRepository.memberNumber == numberInspection) {
                System.out.println("대여하는 책의 제목을 적어주세요");
                String borrowBooks = sc.next();

                checkBooksInformation(borrowBooks, Books, sc, numberInspection, 1);
            }
        }
        System.out.println("존재하지 않는 회원 번호입니다 다시한번 확인해주세요");
    }

    public void checkBooksInformation(String borrowBooks, ArrayList<SubBookReposity> Books, Scanner sc, int numberInspection, int select) {
        for (SubBookReposity bookBorrow : Books) {
            if (bookBorrow.bookName.equals(borrowBooks)) { //해당 북이 일치하는경우 즉 존재하는경우
                int indexTemp = Books.indexOf(bookBorrow); //해당 제목에 있는 인덱스 추출
                SubBookReposity informationResult = Books.get(indexTemp);

                System.out.println("책 정보를 다시한번 확인해주세요");
                System.out.println("========================================================");
                System.out.println("번호 : " + informationResult.bookNumber + "번");
                System.out.println("이름 : " + informationResult.bookName + "");
                System.out.println("작가 : " + informationResult.bookWriter + "");
                System.out.println("출판사 : " + informationResult.publisher + "");
                System.out.println("발매일 : " + informationResult.releaseYear + "년 " + informationResult.releaseMonth + "월 " + informationResult.releaseDays + "일");
                System.out.println("===================================");
                System.out.println("<<<해당 책 정보가 맞으시면 1번을 틀리다면 2번을 눌러주세요>>>");

                int borrowChoice = sc.nextInt();

                if (select == 1) {
                    if (borrowChoice == 1) {
                        System.out.println("대여가 성공적으로 완료되었습니다");
                        UserRepository.borrowBookList[numberInspection][indexTemp] = 1; //1을 부여함으로 써 빌린것 체크
                        //                                num번째 사람이    책번호index를 빌림
                        break;
                    } else if (borrowChoice == 2) {
                        System.out.println("메인 메뉴로 돌아갑니다");
                        break;
                        //리턴구현
                    } else {
                        System.out.println("잘못된 입력입니다");
                    }
                } else { //반납
                    if (borrowChoice == 1) {
                        System.out.println("반납이 성공적으로 완료되었습니다");
                        UserRepository.borrowBookList[numberInspection][indexTemp] = 0;
                        break;
                    } else if (borrowChoice == 2) {
                        System.out.println("메인 메뉴로 돌아갑니다");
                        break;
                    } else {
                        System.out.println("잘못된 입력입니다");
                    }
                }
            } else {
                System.out.println("해당 책을 찾지 못하였습니다 다시 시도해주세요");
                break;
            }
        }
    }

    public void findTotalBookInformation(ArrayList<SubBookReposity> Books) {
        System.out.println("<<<현재까지 등록된 A도서관의 전체 잭 정보입니다>>>");

        for (SubBookReposity bookListResult : Books) {
            System.out.println("===============================================");
            System.out.println("번호 : " + bookListResult.bookNumber + "번");
            System.out.println("이름 : " + bookListResult.bookName + "");
            System.out.println("작가 : " + bookListResult.bookWriter + "");
            System.out.println("작가 : " + bookListResult.bookWriter + "");
            System.out.println("출판사 : " + bookListResult.publisher + "");
            System.out.println("발매일 : " + bookListResult.releaseYear + "년 " + bookListResult.releaseMonth + "월 " + bookListResult.releaseDays + "일");
        }
        System.out.println();
    }
}
