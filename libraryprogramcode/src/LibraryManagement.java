import java.util.HashMap;

public  class LibraryManagement implements ManagementInterface { //책관리 클래스
    private String bookName; //책이름
    private String bookPublisher; //책 출판사
    private String bookWriter; //책 작가
    private int releaseYear; //책 출시 연도(年)
    private int releaseMonth; //책 출시 월(月)
    private int releaseDays; //책 출시 일 (日)

    public LibraryManagement() {

    }

    public LibraryManagement(String bookName, String bookPublisher, String bookWriter, int releaseYear, int releaseMonth, int releaseDays) {
        //책 시리얼넘버
        this.bookName = bookName;
        this.bookPublisher = bookPublisher;
        this.bookWriter = bookWriter;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.releaseDays = releaseDays;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(int releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    public int getReleaseDays() {
        return releaseDays;
    }

    public void setReleaseDays(int releaseDays) {
        this.releaseDays = releaseDays;
    }
    @Override
    public void bookNumbering (HashMap<LibraryManagement, Integer> bookList) {
        int newSerialNumber = 1;
        /*
        for (int book : bookNumber) {

        }
        System.out.println("등록할 책의 번호는 "++"번 입니다");

         */
        inputBookName();
    }

    public void inputBookName () {
        System.out.println("등록할 책 이름을 적어주세요");
        setBookName(sc.next());
        System.out.println("등록이 완료되었습니다 (등록할 책 이름 : "+getBookName()+"");
        inputBookPublisher();
    }
    public void inputBookPublisher () {
        System.out.println("등록할 책의 출판사를 적어주세요");
        setBookPublisher(sc.next());
        System.out.println("등록이 완료되었습니다 (등록할 책 출판사 : "+getBookPublisher()+"");
        inputBookWriter();
    }
    public void inputBookWriter () {
        System.out.println("등록할 책의 작가 이름을 적어주세요");
        setBookWriter(sc.next());
        System.out.println("등록이 완료되었습니다 (등록할 책 작가 이름 : "+getBookWriter()+"");
        inputReleaseYear();
    }
    public void inputReleaseYear () {
        while (true) {
            System.out.println("등록할 책의 출시 연(年)도를 입력해주세요 (1900 ~ 2023년까지 가능합니다)");

            setReleaseYear(sc.nextInt());

            if (getReleaseYear() >= 1900 && getReleaseYear() <= 2023) {
                System.out.println("등록이 완료되었습니다 (등록할 책 출시연도 : "+getReleaseYear()+"년");
                inputReleaseMonth();
                break;
            }
            else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }
    }
    public void inputReleaseMonth () {
        while (true) {
            System.out.println("등록할 책의 출시 월(月)를 입력해주세요 (1월 ~ 12월 까지 가능합니다)");

            setReleaseMonth(sc.nextInt());

            if (getReleaseMonth() >= 1 && getReleaseMonth() <= 12) {
                System.out.println("등록이 완료되었습니다 (등록할 책 출시 월(月) : "+getReleaseMonth()+"월");
                inputReleaseDays();
                break;
            }
            else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }

    }
    public void inputReleaseDays () {
        while (true) {
            System.out.println("등록할 책의 출시 일(日)를 입력해주세요 (1일 ~ 31일 까지 가능합니다)");

            setReleaseDays(sc.nextInt());

            if (getReleaseDays() >= 1 && getReleaseDays() <= 31) {
                System.out.println("등록이 완료되었습니다 (등록할 책 출시 일(日) : "+getReleaseMonth()+"일");
                System.out.println("=============책 등록이 모두 완료되었습니다=============");

            }
            else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }
    }
}
