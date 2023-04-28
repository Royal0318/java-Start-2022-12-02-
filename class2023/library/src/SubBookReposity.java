import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class SubBookReposity {
    public int bookNumber;
    //책이 가지고있는 고유의번호
    public String bookName;
    //두 클래스에서 공용으로 사용되는 것만 static선언을 하였습니다
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
    public boolean checkTemp;
    //책의 존재여부 밎 회원번호 매치 확인을 위해 사용
    public int deleteBookSave;
    SubBookReposity() {
        //서브생성자
    }

    SubBookReposity(int bookNumber, String bookName, String bookWriter, String publisher, int releaseYear, int releaseMonth, int releaseDays, boolean checkTemp,int deleteBookSave) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.bookWriter = bookWriter;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.releaseDays = releaseDays;
        this.checkTemp = checkTemp;
        this.deleteBookSave = deleteBookSave;
    }

    public void findBookTitle(Scanner sc, ArrayList<SubBookReposity> Books) { //책 제목으로도서찾기
        checkTemp = false; //책을 찾기위해 재진입할경우 초기화시키기 위함
        System.out.println("찾으시는 책 이름을 적어주세요");
        String findBookName = sc.next();

        for (SubBookReposity indexNumber : Books) {
            if (Objects.equals(indexNumber.bookName, findBookName)) {
                checkTemp = true;
                findBookInformation(indexNumber);
            }
        }
        if (!checkTemp) {
            System.out.println("안내 : 책의 정보가 존재하지 않습니다 다시 시도해주세요");
        }
    }

    public void findBookNumber(Scanner sc, ArrayList<SubBookReposity> Books) { //책 번호으로도서찾기
        checkTemp = false;
        System.out.println("찾으시는 책 번호를 적어주세요");
        int bookSerialNumber = sc.nextInt();

        for (SubBookReposity indexNumber : Books) {
            if (indexNumber.bookNumber == bookSerialNumber) {
                checkTemp = true;
                findBookInformation(indexNumber);
            }
        }
        if (!checkTemp) {
            System.out.println("안내 : 책의 정보가 존재하지 않습니다 다시 시도해주세요");
        }
    }

    public void findBookWriterName(Scanner sc, ArrayList<SubBookReposity> Books) { //책 작가이름으로도서찾기
        checkTemp = false;
        System.out.println("찾으시는 책의 작가 이름을 적어주세요");
        String bookWriter = sc.next();

        for (SubBookReposity indexNumber : Books) {
            if (indexNumber.bookWriter.equals(bookWriter)) {
                checkTemp = true;
                findBookInformation(indexNumber);
            }
        }
        if (!checkTemp) {
            System.out.println("안내 : 책의 정보가 존재하지 않습니다 다시 시도해주세요");
        }
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
        if (deleteBookSave != 0) { //책을 지운경우 새로운 책을등록하는경우 다시 그 번호를 사용한다
            System.out.println("새로 등록될 책 번호는 : " + deleteBookSave + "번 입니다");
            inputBookName(sc, Books, deleteBookSave);
        } else { //지우지않은경우 그대로 등록
            System.out.println("새로 등록될 책 번호는 : " + (Books.size() + 1) + "번 입니다");
            inputBookName(sc, Books, (Books.size() + 1));
        }
    }

    public void inputBookName(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber) {
        System.out.println("등록할 책의 이름을 적어주세요");
        String registrationBookName = sc.next();
        System.out.println("정상적으로 등록되었습니다");
        inputBookWriter(sc, Books, registrationBookNumber, registrationBookName);
    }

    public void inputBookWriter(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String registrationBookName) {
        System.out.println("작가 이름을 적어주세요");
        String registrationWriterName = sc.next();
        System.out.println("정상적으로 등록되었습니다");
        inputBookPublisher(sc, Books, registrationBookNumber, registrationBookName, registrationWriterName);
    }

    public void inputBookPublisher(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String registrationBookName, String registrationWriterName) {
        System.out.println("책 출판사를 적어주세요");
        String registrationPublisherName = sc.next();
        System.out.println("책 출판사를 정상적으로 등록하였습니다");
        inputBookReleaseYear(sc, Books, registrationBookNumber, registrationBookName, registrationWriterName, registrationPublisherName);
    }

    public void inputBookReleaseYear(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String registrationBookName, String registrationWriterName, String registrationPublisherName) {
        while (true) {
            System.out.println("책 발매 연도를 적어주세요 (1900년 ~ 2023년까지 입력가능)");
            int releaseYear = sc.nextInt();

            if (releaseYear >= 1900 && releaseYear <= 2023) {
                System.out.println("연도 등록이 완료되었습니다");
                inputBookReleaseMonth(sc, Books, registrationBookNumber, registrationBookName, registrationWriterName, registrationPublisherName, releaseYear);
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }

    public void inputBookReleaseMonth(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String registrationBookName, String registrationWriterName, String registrationPublisherName, int releaseYear) {
        while (true) {
            System.out.println("책 발매 월을 적어주세요");
            int releaseMonth = sc.nextInt();

            if (releaseMonth >= 1 && releaseMonth <= 12) {
                System.out.println("월 등록이 완료되었습니다");
                inputBookReleaseDays(sc, Books, registrationBookNumber, registrationBookName, registrationWriterName, registrationPublisherName, releaseYear, releaseMonth);
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }

    public void inputBookReleaseDays(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String registrationBookName, String registrationWriterName, String registrationPublisherName, int releaseYear, int releaseMonth) {
        while (true) {
            System.out.println("책 발매 일을 적어주세요");
            int releaseDays = sc.nextInt();

            if (releaseDays >= 1 && releaseDays <= 31) {
                System.out.println("책 등록절차가 모두 완료되었습니다 ");
                SubBookReposity addBookcomplete = new SubBookReposity(registrationBookNumber, registrationBookName, registrationWriterName, registrationPublisherName, releaseYear, releaseMonth, releaseDays, checkTemp,deleteBookSave);
                Books.add(addBookcomplete);
                deleteBookSave = 0;
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
    public void returnBook(Scanner sc, ArrayList<UserRepository> peopleInformation, ArrayList<SubBookReposity> Books) {
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 반납이 가능합니다");
        int numberInspection = sc.nextInt();

        if (peopleInformation.size() >= numberInspection) {
            System.out.println("반납하는 책의 제목을 적어주세요");
            String returnBookName = sc.next();

            for (SubBookReposity returnBookCheck : Books) {
                if (Objects.equals(returnBookCheck.bookName, returnBookName)) {
                    checkTemp = true;
                    hasBooksInformation(returnBookName, sc, numberInspection, 2, Books);
                    break;
                }
            }
            if (!checkTemp) {
                System.out.println("존재하지 않는 책입니다 다시 확인해주세요");
            }
        } else {
            System.out.println("안내 : 존재하지 않는 회원 번호입니다 다시한번 확인해주세요");
        }
    }

    public void borrowBook(Scanner sc, ArrayList<UserRepository> peopleInformation, ArrayList<SubBookReposity> Books) {
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 빌리기가 가능합니다");
        int numberInspection = sc.nextInt();

        if (peopleInformation.size() >= numberInspection) {
            System.out.println("대여하는 책의 제목을 적어주세요");
            String borrowBooks = sc.next();

            for (SubBookReposity returnBookCheck : Books) {
                if (Objects.equals(returnBookCheck.bookName, borrowBooks)) {
                    checkTemp = true;
                    hasBooksInformation(borrowBooks, sc, numberInspection, 1, Books);
                    break;
                }
            }
            if (!checkTemp) {
                System.out.println("존재하지 않는 책입니다 다시 확인해주세요");
            }
        } else {
            System.out.println("안내 : 존재하지 않는 회원 번호입니다 다시한번 확인해주세요");
        }
    }

    public void hasBooksInformation(String borrowBooks, Scanner sc, int numberInspection, int select, ArrayList<SubBookReposity> Books) {
        for (SubBookReposity findBook : Books) {
            if (Objects.equals(findBook.bookName, borrowBooks)) {
                System.out.println("책 정보를 다시한번 확인해주세요");
                System.out.println("========================================================");
                System.out.println("번호 : " + findBook.bookNumber + "번");
                System.out.println("이름 : " + findBook.bookName + "");
                System.out.println("작가 : " + findBook.bookWriter + "");
                System.out.println("출판사 : " + findBook.publisher + "");
                System.out.println("발매일 : " + findBook.releaseYear + "년 " + findBook.releaseMonth + "월 " + findBook.releaseDays + "일");
                System.out.println("===================================");
                System.out.println("<<<해당 책 정보가 맞으시면 1번을 틀리다면 2번을 눌러주세요>>>");
                int borrowChoice = sc.nextInt();

                if (select == 1) {
                    if (borrowChoice == 1) {
                        System.out.println("대여가 성공적으로 완료되었습니다");
                        UserRepository.borrowBookList[numberInspection][findBook.bookNumber] = 1; //1을 부여함으로 써 빌린것 체크
                        break;
                    } else if (borrowChoice == 2) {
                        System.out.println("메인 메뉴로 돌아갑니다");
                        break;
                    } else {
                        System.out.println("잘못된 입력입니다");
                        break;
                    }
                } else {
                    if (borrowChoice == 1) {
                        if (UserRepository.borrowBookList[numberInspection][findBook.bookNumber] == 1) {
                            System.out.println("반납이 성공적으로 완료되었습니다");
                            UserRepository.borrowBookList[numberInspection][findBook.bookNumber] = 0;
                        } else {
                            System.out.println("책을 빌린 내역이 없습니다");
                        }
                        break;
                    } else if (borrowChoice == 2) {
                        System.out.println("메인 메뉴로 돌아갑니다");
                        break;
                    } else {
                        System.out.println("잘못된 입력입니다");
                        break;
                    }
                }
            }
        }
    }
    public void deleteBook (Scanner sc, ArrayList<SubBookReposity> Books) { //책이 삭제되면 회원가입으로 넘어가지는 현상 고침
        checkTemp = false;
        for (SubBookReposity bookListResult : Books) {
            System.out.println("===============================================");
            System.out.println("번호 : " + bookListResult.bookNumber + "번");
            System.out.println("이름 : " + bookListResult.bookName + "");
        }
        System.out.println("===============================================");
        System.out.println("삭제하고싶은 책 이름을 적어주세요");
        String removeBookName = sc.next();


        //지금 Arraylist에서 삭제하는경우 ConcurrentModificationException오류가 발생하기때문에 이 오류를 해결하는 방법을 생각해야한다

        if (!checkTemp) {
            System.out.println("책 번호를 다시한번 확인해주세요");
        }
    }

    public void findTotalBookInformation(ArrayList<SubBookReposity> Books) {
        System.out.println("<<<현재까지 등록된 A도서관의 전체 잭 정보입니다>>>");
        for (SubBookReposity bookListResult : Books) {
            System.out.println("===============================================");
            System.out.println("번호 : " + bookListResult.bookNumber + "번");
            System.out.println("이름 : " + bookListResult.bookName + "");
            System.out.println("작가 : " + bookListResult.bookWriter + "");
            System.out.println("출판사 : " + bookListResult.publisher + "");
            System.out.println("발매일 : " + bookListResult.releaseYear + "년 " + bookListResult.releaseMonth + "월 " + bookListResult.releaseDays + "일");
        }
        System.out.println();
    }
}
