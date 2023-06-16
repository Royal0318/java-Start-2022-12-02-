
import java.util.HashMap;
import java.util.Objects;

public class LibraryBookFindWay implements BookFindWayInterface {
    private String findBookName;
    private String findBookWriter;
    private int findBookSerialNumber;
    private boolean findCheck;

    public boolean isFindCheck() {
        return findCheck;
    }

    public void setFindCheck(boolean findCheck) {
        this.findCheck = findCheck;
    }

    public String getFindBookName() {
        return findBookName;
    }

    public void setFindBookName(String findBookName) {
        this.findBookName = findBookName;
    }

    public String getFindBookWriter() {
        return findBookWriter;
    }

    public void setFindBookWriter(String findBookWriter) {
        this.findBookWriter = findBookWriter;
    }

    public int getFindBookSerialNumber() {
        return findBookSerialNumber;
    }

    public void setFindBookSerialNumber(int findBookSerialNumber) {
        this.findBookSerialNumber = findBookSerialNumber;
    }

    @Override
    public void selectLookup(HashMap<LibraryBookManagement, Integer> bookList) {
        setFindCheck(false);
        while (true) {
            System.out.println("1.책 이름으로 찾기 2.작가 이름으로 찾기 3.순서로 찾기 4.전체 책 리스트 보기 5.돌아가기");
            int menuChoice = sc.nextInt();

            if (menuChoice == 1) {
                findBookName(bookList);
            }
            else if (menuChoice == 2) {
                findWriterName(bookList);
            }
            else if (menuChoice == 3) {
                System.out.println("1.출시연도 빠른순으로 보기 2.책 가나다순으로 보기 3.돌아가기");

                int findChoice = sc.nextInt();

                if (findChoice == 1) {

                }
                else if (findChoice == 2) {

                }
                else if (findChoice == 3) {
                    System.out.println("메인메뉴로 돌아갑니다");
                    break;
                }
                else {
                    System.out.println("잘못된 입력입니다 다시 시도해주세요");
                }
            }
            else if (menuChoice == 4) {
                System.out.println("현재까지 등록된 A도서관 책 리스트입니다");

                System.out.println("=========================================");
                for (LibraryBookManagement outputBook : bookList.keySet()) {
                    System.out.println("제목 : "+outputBook.getBookName()+"");
                    System.out.println("작가 : "+outputBook.getBookWriter()+"");
                    System.out.println("출판사 : "+outputBook.getBookPublisher()+"");
                    System.out.println("발매 연월일 : "+outputBook.getReleaseYear()+"년 "+outputBook.getReleaseMonth()+"월 "+outputBook.getReleaseDays()+"일");
                    System.out.println("=========================================");
                }
                System.out.println("\n");
                break;
            }
            else if (menuChoice == 5) {
                System.out.println("메인메뉴로 돌아갑니다");
                break;
            }
            else {
                System.out.println("잘못된 입력입니다 다시 시도해주세요");
            }
        }
    }
    public void findBookName (HashMap<LibraryBookManagement, Integer> bookList) {
        System.out.println("찾는 책 이름을 적어주세요");
        sc.nextLine();
        setFindBookName(sc.nextLine());

        for (LibraryBookManagement outputBook : bookList.keySet()) {
            if (Objects.equals(getFindBookName(), outputBook.getBookName())) {
                System.out.println("책을 찾았습니다!!!");
                System.out.println("제목 : "+outputBook.getBookName()+"");
                System.out.println("작가 : "+outputBook.getBookWriter()+"");
                System.out.println("출판사 : "+outputBook.getBookPublisher()+"");
                System.out.println("발매 연월일 : "+outputBook.getReleaseYear()+"년 "+outputBook.getReleaseMonth()+"월 "+outputBook.getReleaseDays()+"일");
                setFindCheck(true); //책을 찾은경우 true로 전환
                break;
            }
        }
        if (!isFindCheck()) {
            System.out.println("존재하지 않는 책입니다 다시 시도해주세요");
        }
    }
    public void findWriterName (HashMap<LibraryBookManagement, Integer> bookList) {
        //책이름으로 찾기
        System.out.println("작가 이름을 적어주세요");
        sc.nextLine(); //매개값 삭제
        setFindBookWriter(sc.next());

        for (LibraryBookManagement outputBook : bookList.keySet()) {
            if (Objects.equals(getFindBookWriter(), outputBook.getBookWriter())) {
                System.out.println("책을 찾았습니다!!!");
                System.out.println("제목 : "+outputBook.getBookName()+"");
                System.out.println("작가 : "+outputBook.getBookWriter()+"");
                System.out.println("출판사 : "+outputBook.getBookPublisher()+"");
                System.out.println("발매 연월일 : "+outputBook.getReleaseYear()+"년 "+outputBook.getReleaseMonth()+"월 "+outputBook.getReleaseDays()+"일");
                setFindCheck(true);
                break;
            }
        }
        if (!isFindCheck()) {
            System.out.println("존재하지 않는 책입니다 다시 시도해주세요");
        }
    }
}