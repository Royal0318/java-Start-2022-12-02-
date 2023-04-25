import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SubBookReposity {
    public int bookNumber;
    //책이 가지고있는 고유의번호
    public static String bookName;
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
    public boolean checkTemp;
    //책 발매 일

    /*
    4월 26일 할일 list
    테스트를 돌려보면서 부족한 부분 다시 고치기
    일단은 책을 등록했을때 미리등록된 2권의 책index를 덮는 부분부터 수정작업에 들어감
     */
    SubBookReposity() {
        //서브생성자
    }

    SubBookReposity(int bookNumber, String bookName, String bookWriter, String publisher, int releaseYear, int releaseMonth, int releaseDays,boolean checkTemp) {
        this.bookNumber = bookNumber;
        SubBookReposity.bookName = bookName;
        this.bookWriter = bookWriter;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.releaseDays = releaseDays;
        this.checkTemp = checkTemp;
    }
    public void findBookTitle(Scanner sc, ArrayList<SubBookReposity> Books) { //책 제목으로도서찾기
        System.out.println("찾으시는 책 이름을 적어주세요");
        sc.nextLine();
        String findBookName = sc.nextLine();

        for (SubBookReposity indexNumber : Books) {
            if (bookName.equals(findBookName)) {
                findBookInformation(indexNumber, true);
                break;
            }
            if (!checkTemp) {
                System.out.println("안내 : 책의 정보가 존재하지 않습니다 다시 시도해주세요");
                break;
            }
        }
    }

    public void findBookNumber(Scanner sc, ArrayList<SubBookReposity> Books) { //책 번호으로도서찾기
        System.out.println("찾으시는 책 번호를 적어주세요");
        int bookSerialNumber = sc.nextInt();

        for (SubBookReposity indexNumber : Books) {
            if (indexNumber.bookNumber == bookSerialNumber) {
                findBookInformation(indexNumber, true);
                break;
            }
            if (!checkTemp) {
                System.out.println("안내 : 책의 정보가 존재하지 않습니다 다시 시도해주세요");
                break;
            }
        }
    }

    public void findBookWriterName(Scanner sc, ArrayList<SubBookReposity> Books) { //책 작가이름으로도서찾기
        System.out.println("찾으시는 책의 작가 이름을 적어주세요");
        String bookWriter = sc.next();

        for (SubBookReposity indexNumber : Books) {
            if (indexNumber.bookWriter.equals(bookWriter)) {
                findBookInformation(indexNumber, true);
                break;
            }
            if (!checkTemp) {
                System.out.println("안내 : 책의 정보가 존재하지 않습니다 다시 시도해주세요");
                break;
            }
        }
    }

    public void findBookInformation(SubBookReposity bookIndex,boolean checkTemp) {
        while (true) {
            if (checkTemp) {
                System.out.println("책을 찾았습니다!!!");
                System.out.println("책 번호 : " + bookIndex.bookNumber + "");
                System.out.println("책 이름 : " + bookName + "");
                System.out.println("작가 : " + bookIndex.bookWriter + "");
                System.out.println("출판사 : " + bookIndex.publisher + "");
                System.out.println("발매 연월일 : " + bookIndex.releaseYear + "년 " + bookIndex.releaseMonth + "월 " + bookIndex.releaseDays + "일");
                break;
                //break로 나가면 왜 존재하지않는책이나옴?
            }
        }
    }

    public void inputBookRegistration(Scanner sc, ArrayList<SubBookReposity> Books) { //책등록
        System.out.println("책 등록번호는 : "+Books.size()+"번 입니다");
        while (true) {
            System.out.println("책 등록번호를 입력해주세요 (1 ~ 200번까지)");
            int registrationBookNumber = sc.nextInt();

            if (registrationBookNumber >= 1 && registrationBookNumber <= 200) {
                for (SubBookReposity findbook : Books) {
                    if (findbook.bookNumber == registrationBookNumber) { //이미 등록된 번호인경우
                        checkTemp = true;
                        break;
                    }
                }
            }
            if (checkTemp) {
                System.out.println("이미 등록된 번호입니다 다른 번호를 입력해주세요");
                checkTemp = false;
            } else {
                System.out.println("정상적으로 등록되었습니다");
                inputBookName(sc, Books,registrationBookNumber); //통과되면 다음 순서로 넘김
                break;
            }
        }
    }

    public void inputBookName(Scanner sc, ArrayList<SubBookReposity> Books,int registrationBookNumber) {
        System.out.println("등록할 책의 이름을 적어주세요");
        sc.nextLine();
        String registrationBookName = sc.next();
        System.out.println("정상적으로 등록되었습니다");
        inputBookWriter(sc, Books,registrationBookNumber,registrationBookName);
    }

    public void inputBookWriter(Scanner sc, ArrayList<SubBookReposity> Books,int registrationBookNumber,String registrationBookName) {
        System.out.println("작가 이름을 적어주세요");
        String registrationWriterName = sc.next();
        System.out.println("정상적으로 등록되었습니다");
        inputBookPublisher(sc, Books,registrationBookNumber,registrationBookName,registrationWriterName);
    }

    public void inputBookPublisher(Scanner sc, ArrayList<SubBookReposity> Books,int registrationBookNumber,String registrationBookName,String registrationWriterName) {
        System.out.println("책 출판사를 적어주세요");
        String registrationPublisherName = sc.next();
        System.out.println("책 출판사를 정상적으로 등록하였습니다");
        inputBookReleaseYear(sc, Books,registrationBookNumber,registrationBookName,registrationWriterName,registrationPublisherName);
    }

    public void inputBookReleaseYear(Scanner sc, ArrayList<SubBookReposity> Books,int registrationBookNumber,String registrationBookName,String registrationWriterName,String registrationPublisherName) {
        while (true) {
            System.out.println("책 발매 연도를 적어주세요 (1900년 ~ 2023년까지 입력가능)");
            int releaseYear = sc.nextInt();

            if (releaseYear >= 1900 && releaseYear <= 2023) {
                System.out.println("연도 등록이 완료되었습니다");
                inpuyBookReleaseMonth(sc, Books,registrationBookNumber,registrationBookName,registrationWriterName,registrationPublisherName,releaseYear);
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }

    public void  inpuyBookReleaseMonth(Scanner sc, ArrayList<SubBookReposity> Books,int registrationBookNumber,String registrationBookName,String registrationWriterName,String registrationPublisherName,int releaseYear) {
        while (true) {
            System.out.println("책 발매 월을 적어주세요");
            int releaseMonth = sc.nextInt();

            if (releaseMonth >= 1 && releaseMonth <= 12) {
                System.out.println("월 등록이 완료되었습니다");
                inputBookReleaseDays(sc, Books,registrationBookNumber,registrationBookName,registrationWriterName,registrationPublisherName,releaseYear,releaseMonth);
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }

    public void inputBookReleaseDays(Scanner sc, ArrayList<SubBookReposity> Books,int registrationBookNumber,String registrationBookName,String registrationWriterName,String registrationPublisherName,int releaseYear,int releaseMonth) {
        while (true) {
            System.out.println("책 발매 일을 적어주세요");
            int releaseDays = sc.nextInt();

            if (releaseDays >= 1 && releaseDays <= 31) {
                System.out.println("책 등록절차가 모두 완료되었습니다 ");
                SubBookReposity addBookcomplete = new SubBookReposity(registrationBookNumber, registrationBookName, registrationWriterName, registrationPublisherName, releaseYear, releaseMonth, releaseDays,checkTemp);
                Books.add(addBookcomplete);
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }

    public void returnBook(Scanner sc, ArrayList<SubBookReposity> Books,ArrayList<UserRepository> peopleInformation) {
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 반납이 가능합니다");
        int numberInspection = sc.nextInt();

        for (UserRepository memberMatch : peopleInformation) {
            if (memberMatch.memberNumber == numberInspection) {
                System.out.println("반납하는 책의 제목을 적어주세요");
                String returnBookName = sc.next();
                checkBooksInformation(returnBookName, Books, sc, numberInspection, 2);
                break;
            }
        }
        System.out.println("안내 : 존재하지 않는 회원 번호입니다 다시한번 확인해주세요");
    }

    public void borrowBook(Scanner sc, ArrayList<SubBookReposity> Books, ArrayList<UserRepository> peopleInformation) {
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 빌리기가 가능합니다");
        int numberInspection = sc.nextInt();

        for (UserRepository memberMatch : peopleInformation) {
            if (memberMatch.memberNumber == numberInspection) {
                System.out.println("대여하는 책의 제목을 적어주세요");
                String borrowBooks = sc.next();
                checkBooksInformation(borrowBooks, Books, sc, numberInspection, 1);
                break;
            }
        }
        System.out.println("안내 : 존재하지 않는 회원 번호입니다 다시한번 확인해주세요");
    }

    public void checkBooksInformation(String borrowBooks, ArrayList<SubBookReposity> Books, Scanner sc, int numberInspection, int select) {

        if (Objects.equals(SubBookReposity.bookName, borrowBooks)) { //해당 북이 일치하는경우 즉 존재하는경우 (static선언하였기때문에 if문으로 가능?)
            System.out.println("책 정보를 다시한번 확인해주세요");
            System.out.println("========================================================");
            System.out.println("번호 : " + bookNumber + "번");
            System.out.println("이름 : " + bookName + "");
            System.out.println("작가 : " + bookWriter + "");
            System.out.println("출판사 : " + publisher + "");
            System.out.println("발매일 : " + releaseYear + "년 " + releaseMonth + "월 " + releaseDays + "일");
            System.out.println("===================================");
            System.out.println("<<<해당 책 정보가 맞으시면 1번을 틀리다면 2번을 눌러주세요>>>");

            int borrowChoice = sc.nextInt();

            if (select == 1) {
                if (borrowChoice == 1) {
                    System.out.println("대여가 성공적으로 완료되었습니다");
                    UserRepository.borrowBookList[numberInspection][bookNumber] = 1; //1을 부여함으로 써 빌린것 체크
                } else if (borrowChoice == 2) {
                    System.out.println("메인 메뉴로 돌아갑니다");
                } else {
                    System.out.println("잘못된 입력입니다");
                }
            } else {
                if (borrowChoice == 1) {
                    System.out.println("반납이 성공적으로 완료되었습니다");
                    UserRepository.borrowBookList[numberInspection][bookNumber] = 0;
                } else if (borrowChoice == 2) {
                    System.out.println("메인 메뉴로 돌아갑니다");
                } else {
                    System.out.println("잘못된 입력입니다");
                }
            }
        }
    }
    public void bookRemove (Scanner sc,ArrayList<SubBookReposity> Books) {
        System.out.println("삭제를 원하는 책 제목을 적어주세요");
        String removeBookName = sc.next();

        if (Objects.equals(SubBookReposity.bookName, removeBookName)) {
            int check = Integer.parseInt(SubBookReposity.bookName); //찾은 bookName의 번호를 check변수에담고 삭제
            System.out.println("책이 삭제되었습니다");
            Books.remove(check);
        } else {
            System.out.println("책이 존재하지 않습니다");
        }
    }
    public void findTotalBookInformation(ArrayList<SubBookReposity> Books) {
        System.out.println("<<<현재까지 등록된 A도서관의 전체 잭 정보입니다>>>");

        for (SubBookReposity bookListResult : Books) {
            System.out.println("===============================================");
            System.out.println("번호 : " + bookListResult.bookNumber + "번");
            System.out.println("이름 : " + bookName + "");
            System.out.println("작가 : " + bookListResult.bookWriter + "");
            System.out.println("출판사 : " + bookListResult.publisher + "");
            System.out.println("발매일 : " + bookListResult.releaseYear + "년 " + bookListResult.releaseMonth + "월 " + bookListResult.releaseDays + "일");
        }
        System.out.println();
    }
}
