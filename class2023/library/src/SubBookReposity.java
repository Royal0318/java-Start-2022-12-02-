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

    SubBookReposity () {

    }
    SubBookReposity (int bookNumber,String bookName,String bookWriter,String publisher,int releaseYear,int releaseMonth,int releaseDays) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.bookWriter = bookWriter;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.releaseDays = releaseDays;
    }
    void findBookTitle () { //책 제목으로도서찾기

    }
    void findBookNumber () { //책 번호으로도서찾기

    }
    void findBookWriterName () { //책 작가이름으로도서찾기

    }
    void inputBookRegistration (Scanner sc, ArrayList<SubBookReposity> Books) { //책등록
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
        inputBookRegistration2(sc,Books,registrationBookNumber); //통과되면 다음 순서로 넘김
    }
    void inputBookRegistration2 (Scanner sc, ArrayList<SubBookReposity> Books,int registrationBookNumber) {
        System.out.println("등록할 책의 이름을 적어주세요");
        sc.nextLine();
        bookName = sc.nextLine();
        System.out.println("책 이름이 정상적으로 등록되었습니다");
        inputBookRegistration3(sc,Books,registrationBookNumber,bookName);
    }
    void inputBookRegistration3 (Scanner sc,ArrayList<SubBookReposity> Books,int registrationBookNumber,String bookName) {
        System.out.println("작가 이름을 적어주세요");
        bookWriter = sc.nextLine();
        System.out.println("작가 이름이 정상적으로 등록되었습니다");
        inputBookRegistration4(sc,Books,registrationBookNumber,bookName,bookWriter);
    }
    void inputBookRegistration4 (Scanner sc,ArrayList<SubBookReposity> Books,int registrationBookNumber,String bookName,String bookWriter) {
        System.out.println("책 출판사를 적어주세요");
        publisher = sc.nextLine();
        System.out.println("책 출판사를 정상적으로 등록하였습니다");
        inputBookRegistration5(sc,Books,registrationBookNumber,bookName,bookWriter,publisher);
    }
    void inputBookRegistration5 (Scanner sc,ArrayList<SubBookReposity> Books,int registrationBookNumber,String bookName,String bookWriter,String publisher) {
        System.out.println("책 발매 연도를 적어주세요 (1900년 ~ 2023년까지 입력가능)");
        releaseYear = sc.nextInt();

        if (releaseYear >= 1900 && releaseYear <= 2023) {
            System.out.println("연도 등록이 완료되었습니다");
            inputBookRegistration6(sc,Books,registrationBookNumber,bookName,bookWriter,publisher,releaseYear);
        } else {
            System.out.println("잘못된 입력입니다");
            inputBookRegistration5(sc,Books,registrationBookNumber,bookName,bookWriter,publisher);
        }
    }
    void inputBookRegistration6 (Scanner sc,ArrayList<SubBookReposity> Books,int registrationBookNumber,String bookName,String bookWriter,String publisher,int releaseYear) {
        System.out.println("책 발매 월을 적어주세요");
        releaseMonth = sc.nextInt();

        if (releaseMonth >= 1 && releaseMonth <= 12) {
            System.out.println("월 등록이 완료되었습니다");
            inputBookRegistration7(sc,Books,registrationBookNumber,bookName,bookWriter,publisher,releaseYear,releaseMonth);
        } else {
            System.out.println("잘못된 입력입니다");
            inputBookRegistration6(sc, Books, registrationBookNumber, bookName, bookWriter, publisher, releaseYear);
        }
    }
    void inputBookRegistration7 (Scanner sc,ArrayList<SubBookReposity> Books,int registrationBookNumber,String bookName,String bookWriter,String publisher,int releaseYear,int releaseMonth) {
        System.out.println("책 발매 일을 적어주세요");
        releaseDays = sc.nextInt();

        if (releaseDays >= 1 && releaseDays <= 31) {
            System.out.println("책 등록절차가 모두 완료되었습니다 ");
            SubBookReposity addBookcomplete = new SubBookReposity(registrationBookNumber,bookName,bookWriter,publisher,releaseYear,releaseMonth,releaseDays);
            Books.add(addBookcomplete);

        } else {
            System.out.println("잘못된 입력입니다");
            inputBookRegistration7(sc, Books, registrationBookNumber, bookName, bookWriter, publisher, releaseYear,releaseMonth);
        }
    }
    void returnBook (Scanner sc) {

    }
    void borrowBook (Scanner sc,ArrayList<SubBookReposity> Books) {
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 빌리기가 가능합니다");
        int numberInspection = sc.nextInt();

        for (int i = 0; i <= numberInspection; i++) {
            if (UserRepository.memberNumber[i] == numberInspection) {
                System.out.println("대여하는 책의 제목을 적어주세요");
                String borrowBooks = sc.next();
             //   checkBooksInformation(borrowBooks, Books, sc, numberInspection, 1);
            }
        }
        System.out.println("존재하지 않는 회원 번호입니다 다시한번 확인해주세요");
    }
    void checkBooksInformation () {

    }
}
