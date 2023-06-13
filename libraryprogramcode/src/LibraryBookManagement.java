import java.util.HashMap;
import java.util.Objects;

public class LibraryBookManagement implements BookManagementInterface { //책관리 클래스
    private String bookName; //책이름
    private String bookPublisher; //책 출판사
    private String bookWriter; //책 작가
    private String modifyBookName; //수정하는 책 이름이 존재하는지 여부를 확인
    private String deleteBookName; //책을 지우기 위해 책 이름입력받음

    private int modifyMenuChoice; //수정 메뉴 선택
    private int releaseYear; //책 출시 연도(年)
    private int releaseMonth; //책 출시 월(月)
    private int releaseDays; //책 출시 일 (日)
    private boolean duplicateCheck; //책 중복여부 확인

    public LibraryBookManagement() {

    }

    public LibraryBookManagement(String bookName, String bookPublisher, String bookWriter, int releaseYear, int releaseMonth, int releaseDays) {
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

    public String getModifyBookName() {
        return modifyBookName;
    }

    public void setModifyBookName(String modifyBookName) {
        this.modifyBookName = modifyBookName;
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

    public boolean isDuplicateCheck() {
        return duplicateCheck;
    }

    public void setDuplicateCheck(boolean duplicateCheck) {
        this.duplicateCheck = duplicateCheck;
    }

    public int getModifyMenuChoice() {
        return modifyMenuChoice;
    }

    public void setModifyMenuChoice(int modifyMenuChoice) {
        this.modifyMenuChoice = modifyMenuChoice;
    }

    public String getDeleteBookName() {
        return deleteBookName;
    }

    public void setDeleteBookName(String deleteBookName) {
        this.deleteBookName = deleteBookName;
    }

    @Override
    public void bookNumbering(HashMap<LibraryBookManagement, Integer> bookList) {
        System.out.println("등록할 책의 번호는 " + (bookList.size() + 1) + "번 입니다");
        inputBookName();
    }

    public void inputBookName() {
        System.out.println("등록할 책 이름을 적어주세요");
        setBookName(sc.next());
        System.out.println("등록이 완료되었습니다");
        inputBookPublisher();
    }

    public void inputBookPublisher() {
        System.out.println("등록할 책의 출판사를 적어주세요");
        setBookPublisher(sc.next());
        System.out.println("등록이 완료되었습니다");
        inputBookWriter();
    }

    public void inputBookWriter() {
        System.out.println("등록할 책의 작가 이름을 적어주세요");
        setBookWriter(sc.next());
        System.out.println("등록이 완료되었습니다");
        inputReleaseYear();
    }

    public void inputReleaseYear() {
        while (true) {
            System.out.println("등록할 책의 출시 연(年)도를 입력해주세요 (1900 ~ 2023년까지 가능합니다)");

            setReleaseYear(sc.nextInt());

            if (getReleaseYear() >= 1900 && getReleaseYear() <= 2023) {
                System.out.println("등록이 완료되었습니다");
                inputReleaseMonth();
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }
    }

    public void inputReleaseMonth() {
        while (true) {
            System.out.println("등록할 책의 출시 월(月)를 입력해주세요 (1월 ~ 12월 까지 가능합니다)");

            setReleaseMonth(sc.nextInt());

            if (getReleaseMonth() >= 1 && getReleaseMonth() <= 12) {
                System.out.println("등록이 완료되었습니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }
    }

    @Override
    public void inputReleaseDays(HashMap<LibraryBookManagement, Integer> bookList) {
        while (true) {
            System.out.println("등록할 책의 출시 일(日)를 입력해주세요 (1일 ~ 31일 까지 가능합니다)");

            setReleaseDays(sc.nextInt());

            if (getReleaseDays() >= 1 && getReleaseDays() <= 31) {
                System.out.println("등록이 완료되었습니다\n");

                for (LibraryBookManagement bookName : bookList.keySet()) { //같은 책 존재여부 검사
                    if (Objects.equals(getBookName(), bookName.getBookName()) && Objects.equals(getBookPublisher(), bookName.getBookPublisher()) && Objects.equals(getBookWriter(), bookName.getBookWriter()) && getReleaseYear() == bookName.getReleaseYear() && getReleaseMonth() == bookName.getReleaseMonth() && getReleaseDays() == bookName.getReleaseDays()) {
                        System.out.println("안내 : 같은 책이 이미 존재하기 때문에 책 수량을 조정합니다");

                        int plusBook = bookList.get(bookName); //기존에 존재하는 1권을 1권추가하여 2권으로 조정

                        bookList.replace(bookName, bookList.get(bookName) + plusBook); //replace (등록된 책,그 책의 value 값 + 1권추가)

                        setDuplicateCheck(true); //존재하면 수량만 등록
                        break;
                    }
                }
                if (!isDuplicateCheck()) { //존재하지않는경우 새로등록
                    LibraryBookManagement bookAdd = new LibraryBookManagement("" + getBookName() + "", "" + getBookPublisher() + "", "" + getBookWriter() + "", getReleaseYear(), getReleaseMonth(), getReleaseDays());
                    bookList.put(bookAdd, 1);
                }
                System.out.println("=============책 등록이 모두 완료되었습니다=============\n");
                setDuplicateCheck(false); //boolean 값 초기화
                break;
            }
            else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }
    }

    @Override
    public void findBookInformation(HashMap<LibraryBookManagement, Integer> bookList) {
        System.out.println("수정 하고싶은 책 이름을 적어주세요");
        setModifyBookName(sc.nextLine());

        for (LibraryBookManagement modify : bookList.keySet()) {
            if (Objects.equals(getModifyBookName(), modify.getBookName())) { //책이 존재하고 일치하는경우
                modifyInformation(modify);
                setDuplicateCheck(true); //존재하는경우 true
                break;
            }
        }
        if (!isDuplicateCheck()) { //책이 존재하지않는경우
            System.out.println("존재하지 않는 책입니다 다시 시도해 주세요");
            setDuplicateCheck(false); //boolean 값 초기화
        }
    }

    public void modifyInformation(LibraryBookManagement modify) {
        System.out.println("안내 : 원하는 메뉴의 번호를 적어주세요");
        System.out.println("1.책 이름 수정 2.책 출판사 수정 3.책 작가 수정 4.연도(年) 수정 5.월(月)수정 6.일(日) 수정 7.돌아가기");

        setModifyMenuChoice(sc.nextInt());

        if (getModifyMenuChoice() == 1) {
            System.out.println("새로운 책 이름을 적어주세요");

            sc.nextLine();
            String modifyNewBookName = sc.nextLine();

            modify.setBookName(modifyNewBookName); //새로운 책 이름을 변경
            System.out.println("변경이 완료되었습니다");
        }
        else if (getModifyMenuChoice() == 2) {
            System.out.println("새로운 출판사 이름을 적어주세요");

            sc.nextLine();
            String modifyNewBookPublisher = sc.nextLine();

            modify.setBookPublisher(modifyNewBookPublisher);
            System.out.println("변경이 완료되었습니다");
        }
        else if (getModifyMenuChoice() == 3) {
            System.out.println("새로운 작가 이름을 적어주세요");

            sc.nextLine();
            String modifyNewBookWriter = sc.nextLine();

            modify.setBookWriter(modifyNewBookWriter);
            System.out.println("변경이 완료되었습니다");
        }
        else if (getModifyMenuChoice() == 4) {
            while (true) {
                System.out.println("새로운 연도(年)를 적어주세요");

                int modifyNewBookYear = sc.nextInt();

                if (modifyNewBookYear >= 1900 && modifyNewBookYear <= 2023) {
                    modify.setReleaseYear(modifyNewBookYear);
                    System.out.println("변경이 완료되었습니다");
                    break;
                }
                else {
                    System.out.println("잘못된 입력입니다 다시 입력해주세요");
                }
            }
        }
        else if (getModifyMenuChoice() == 5) {
            while (true) {
                System.out.println("새로운 월(月)를 적어주세요");

                int modifyNewBookMonth = sc.nextInt();

                if (modifyNewBookMonth >= 1 && modifyNewBookMonth <= 12) {
                    modify.setReleaseMonth(modifyNewBookMonth);
                    System.out.println("변경이 완료되었습니다");
                    break;
                }
                else {
                    System.out.println("잘못된 입력입니다 다시 입력해주세요");
                }
            }
        }
        else if (getModifyMenuChoice() == 6) {
            while (true) {
                System.out.println("새로운 일(日)을 적어주세요");

                int modifyNewBookDays = sc.nextInt();

                if (modifyNewBookDays >= 1 && modifyNewBookDays <= 31) {
                    modify.setReleaseDays(modifyNewBookDays);
                    System.out.println("변경이 완료되었습니다");
                    break;
                } else {
                    System.out.println("잘못된 입력입니다 다시 입력해주세요");
                }
            }
        }
        else if (getModifyMenuChoice() == 7) {
            System.out.println("메인메뉴로 돌아갑니다");
        }
        else {
            System.out.println("잘못된 입력입니다 다시 시도해주세요");
        }
    }

    @Override
    public void deleteBook(HashMap<LibraryBookManagement, Integer> bookList) {
        setDuplicateCheck(false);
        System.out.println("지우고싶은 책 이름을 적어주세요");
        setDeleteBookName(sc.nextLine());

        for (LibraryBookManagement modify : bookList.keySet()) {
            if (Objects.equals(getDeleteBookName(), modify.getBookName())) { //책이 존재하고 일치하는경우
                setDuplicateCheck(true); //존재하는경우 true
                confirmDeletion(modify,bookList);
                break;
            }
        }
        if (!isDuplicateCheck()) {
            System.out.println("존재하지 않는 책입니다 다시 시도해주세요");
        }
    }

    public void confirmDeletion(LibraryBookManagement modify,HashMap<LibraryBookManagement, Integer> bookList) {
        while (true) {
            System.out.println("\n정말로 삭제하시겠습니까? 1.예 2.아니요 \n안내 : 삭제하면 다시 복구 할 수 없습니다!");

            int deleteMenuChoice = sc.nextInt();

            if (deleteMenuChoice == 1) {
                System.out.println("정상적으로 삭제되었습니다");
                bookList.remove(modify); //modify 가 담고있는 index번호를 remove메소드에 담아 booklist에 저장되어있는 해시값을 삭제한다
                sc.nextLine(); //개행문자 초기화
                break;
            }
            else if (deleteMenuChoice == 2) {
                System.out.println("메인 메뉴로 돌아갑니다");
                sc.nextLine(); //이전에 입력했던 책 nextline 개행문자 초기화시킴
                break;
            }
            else {
                System.out.println("잘못된 입력입니다 다시 시도해주세요");
            }
        }
    }
}
