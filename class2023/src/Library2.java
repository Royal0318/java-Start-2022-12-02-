import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class Library2 {
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
    public int memberRegistrationOrder;
    //회원 등록을 몇번까지 했는지 체크하는 전역변수

    ///여기서부터 회원정보관련 전역변수
    public String[] memberName;
    //회원의 이름
    public int[] memberNumber;
    //회원번호
    public String[] memberAddress;
    //회원주소
    public int[][] memberPhoneNumber;
    //회원의 휴대폰번호 (앞4자리와 뒤4자리를 받아야 하기 때문에 2차원 배열을 사용 [][0]은 앞4자리를 받으며 [][1]은 뒤4자리를 받는다)
    public int[][] borrowBookList;
    //회원이 빌린 책을 저장하는 변수 1차원에는 회원의번호가 2차원에는 회원이 빌린 책의 번호가 저장된다

    Library2() {

    }
    Library2(int bookNumber, String bookName, String bookWriter, String publisher, int releaseYear, int releaseMonth, int releaseDays, int memberRegistrationOrder, String[] memberName, int[] memberNumber, String[] memberAddress, int[][] memberPhoneNumber, int[][] borrowBookList) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.bookWriter = bookWriter;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.releaseDays = releaseDays;
        this.memberRegistrationOrder = memberRegistrationOrder;
        this.memberName = memberName;
        this.memberNumber = memberNumber;
        this.memberAddress = memberAddress;
        this.memberPhoneNumber = memberPhoneNumber;
        this.borrowBookList = borrowBookList;
    }

    void getSystemMenu(Scanner sc, ArrayList<Library2> Books) {
        //도서관 메인 메소드
        System.out.println("\n=======A 도서관 관리 프로그램입니다=======");
        System.out.println("1.도서 찾기 2.도서 등록 3.도서 반납 4.도서 대여 5.회원등록 6.회원조회 7.전체 책 조회 8.시스템 종료");
        int menuChoice = sc.nextInt();

        //메인메뉴는 if문보다 스위치문이 코드를 보는 가독성이 더 좋기 때문에 switch를 사용
        switch (menuChoice) {
            case 1:
                findBook(sc, Books);
                break;
            case 2:
                inputBookRegistration(sc, Books);
                break;
            case 3:
                inputBookReturn(sc, Books);
                break;
            case 4:
                inputBookBorrowMenu(sc, Books);
                break;
            case 5:
                inputMemberName(sc, Books);
                break;
            case 6:
                findMemberInformation(sc, Books);
                break;
            case 7:
                findTotalBookList(sc, Books);
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

    void findBook(Scanner sc, ArrayList<Library2> Books) {
        //책 찾기
        System.out.println("어떤 방법으로 찾으시겠습니까?");
        System.out.println("1.책 이름으로 찾기 2.작가 이름으로 찾기 3.출판사로 찾기 4.책 번호로 찾기");
        int selectMethod = sc.nextInt();

        switch (selectMethod) {
            case 1:
                findByBookName(sc, Books);
                break;
            case 2:
                findByWriterName(sc, Books);
                break;
            case 3:
                findByPublisherName(sc, Books);
                break;
            case 4:
                findByBookNumber(sc, Books);
                break;
            default:
                System.out.println("잘못된 입력입니다");
                break;
        }
    }

    void findByBookName(Scanner sc, ArrayList<Library2> Books) {
        //책이름으로 찾기
        System.out.println("찾고자하는 책의 이름을 적어주세요");
        String findbookName = sc.next();

        for (Library2 s : Books) {
            if (s.bookName.equals("" + findbookName + "")) {
                findBookOutput(sc, Books, s);
                break;
            }
        }
        /*
        포잇치문을 통해 찾고자하는 책의 이름을 String으로 입력받은 후 현재 등록되어있는 책의 이름을 모두 루프를돌려 찾는다
        책을 찾은경우 밑에 메소드로 이동되지만 찾지못한경우 메인메뉴로 리턴된다
         */
        System.out.println("원하시는 책이 존재하지 않습니다");
        getSystemMenu(sc, Books);
    }

    void findByWriterName(Scanner sc, ArrayList<Library2> Books) {
        //작가 이름으로 찾기
        System.out.println("찾고자하는 작가 이름을 적어주세요");
        String writerName = sc.next();

        for (Library2 s : Books) {
            if (s.bookWriter.equals("" + writerName + "")) {
                findBookOutput(sc, Books, s);
                break;
            }
        }
        System.out.println("원하시는 책이 존재하지 않습니다");
        getSystemMenu(sc, Books);
    }

    void findByPublisherName(Scanner sc, ArrayList<Library2> Books) {
        //출판사 이름으로 찾기
        System.out.println("출판사 이름을 적어주세요");
        String publisherName = sc.next();

        for (Library2 s : Books) {
            if (s.publisher.equals("" + publisherName + "")) {
                findBookOutput(sc, Books, s);
                break;
            }
        }
        System.out.println("원하시는 책이 존재하지 않습니다");
        getSystemMenu(sc, Books);
    }

    void findByBookNumber(Scanner sc, ArrayList<Library2> Books) {
        //책 번호로 찾기
        System.out.println("책 번호를 적어주세요");
        int bookNumber = sc.nextInt();

        for (Library2 s : Books) {
            if (s.bookNumber == bookNumber) {
                findBookOutput(sc, Books, s);
            }
        }
        System.out.println("원하시는 책이 존재하지 않습니다");
        getSystemMenu(sc, Books);
    }

    void findBookOutput(Scanner sc, ArrayList<Library2> Books, Library2 s) {
        //책을 찾기위해서 정보를 입력후 포잇치문을 돌려서 원하는 정보가있는 경우 index를 추출하여 해당 책의 정보를 모두 출력한다
        System.out.println("해당 책을 찾았습니다!!!");
        int index = Books.indexOf(s);
        Library2 InformationResult = Books.get(index);
        System.out.println("============책 정보============");
        System.out.println("번호 : " + InformationResult.bookNumber + "번");
        System.out.println("이름 : " + InformationResult.bookName + "");
        System.out.println("작가 : " + InformationResult.bookWriter + "");
        System.out.println("작가 : " + InformationResult.bookWriter + "");
        System.out.println("출판사 : " + InformationResult.publisher + "");
        System.out.println("발매일 : " + InformationResult.releaseYear + "년 " + InformationResult.releaseMonth + "월 " + InformationResult.releaseDays + "일");
        System.out.println("===================================");
        getSystemMenu(sc, Books);
    }

    void inputBookRegistration(Scanner sc, ArrayList<Library2> Books) {
        //새로운 책 등록시작 , 책의번호 입력
        System.out.println("등록할 책의 번호를 부여해주세요 (0 ~ 999)");
        int registrationBookNumber = sc.nextInt();

        if (registrationBookNumber >= 0 && registrationBookNumber <= 999) {
            for (Library2 registration : Books) {
                if (registration.bookNumber != registrationBookNumber) {
                    System.out.println("번호 저장이 완료되었습니다");
                    inputBookName(sc, Books, registrationBookNumber);
                }
            }
        }
        System.out.println("이미 등록된 번호이거나 잘못된 입력입니다");
        getSystemMenu(sc, Books);
    }

    void inputBookName(Scanner sc, ArrayList<Library2> Books, int inputBookNumber) {
        //책 등록 : 책의 이름
        System.out.println("등록하는 책의 이름을 적어주세요");
        String registrationBookName = sc.next();
        System.out.println("등록이 완료되었습니다");
        inputBookWriter(sc, Books, inputBookNumber, registrationBookName);
    }

    void inputBookWriter(Scanner sc, ArrayList<Library2> Books, int inputBookNumber, String bookNameInput) {
        //책 등록 : 책의 작가
        System.out.println("등록하는 책의 작가 이름을 적어주세요");
        String registrationWriterName = sc.next();
        System.out.println("등록이 완료되었습니다");
        inputBookPublisher(sc, Books, inputBookNumber, bookNameInput, registrationWriterName);
    }

    void inputBookPublisher(Scanner sc, ArrayList<Library2> Books, int inputBookNumber, String bookNameInput, String bookWriterName) {
        //책 등록 : 책 출판사
        System.out.println("등록하는 책의 출판사를 적어주세요");
        String registrationPublisherName = sc.next();
        System.out.println("등록이 완료되었습니다");
        inputBookReleaseYear(sc, Books, inputBookNumber, bookNameInput, bookWriterName, registrationPublisherName);
    }

    void inputBookReleaseYear(Scanner sc, ArrayList<Library2> Books, int inputBookNumber, String bookNameInput, String bookWriterName, String publisherInput) {
        //책 등록 : 발매연도
        System.out.println("책 발매 연도를 적어주세요 (1900년 ~ 2023년까지 입력가능)");
        int releaseYear = sc.nextInt();

        if (releaseYear >= 1900 && releaseYear <= 2023) {
            System.out.println("연도 등록이 완료되었습니다");
            inpuyBookReleaseMonth(sc, Books, inputBookNumber, bookNameInput, bookWriterName, publisherInput, releaseYear);
        } else {
            System.out.println("잘못된 입력입니다");
            inputBookReleaseYear(sc, Books, inputBookNumber, bookNameInput, bookWriterName, publisherInput);
        }
    }

    void inpuyBookReleaseMonth(Scanner sc, ArrayList<Library2> Books, int inputBookNumber, String bookNameInput, String bookWriterName, String publisherInput, int releaseYearInput) {
        //책 등록 : 발매한 월
        System.out.println("책이 발매한 달을 적어주세요");
        int releaseMonth = sc.nextInt();

        if (releaseMonth > 0 && releaseMonth <= 12) {
            System.out.println("월 등록이 완료되었습니다");
            inpuyBookReleaseDays(sc, Books, inputBookNumber, bookNameInput, bookWriterName, publisherInput, releaseYearInput, releaseMonth);
        } else {
            System.out.println("잘못된 입력입니다");
            inpuyBookReleaseMonth(sc, Books, inputBookNumber, bookNameInput, bookWriterName, publisherInput, releaseYearInput);
        }
    }

    void inpuyBookReleaseDays(Scanner sc, ArrayList<Library2> Books, int inputBookNumber, String bookNameInput, String bookWriterName, String publisherInput, int releaseYearInput, int month) {
        //책 등록 : 발매 요일
        System.out.println("책이 발매한 날짜을 적어주세요");
        int releaseDays = sc.nextInt();

        if (releaseDays >= 1 && releaseDays <= 31) {
            System.out.println("전체 등록이 완료되었습니다");
            Library2 addBookComplete = new Library2(inputBookNumber, bookNameInput, bookWriterName, publisherInput, releaseYearInput, month, releaseDays, memberRegistrationOrder, memberName, memberNumber, memberAddress, memberPhoneNumber, borrowBookList);
            Books.add(addBookComplete);
            getSystemMenu(sc, Books);
            //등록 메소드에서 입력받은 파라미터를 모두 넘겨받아서 addBookComplete라는 인스턴스를 생성 파라미터를 모두 추가하여 Arraylist에 추가
        } else {
            System.out.println("잘못된 입력입니다");
            inpuyBookReleaseDays(sc, Books, inputBookNumber, bookNameInput, bookWriterName, publisherInput, releaseYearInput, month);
        }
    }

    void inputMemberName(Scanner sc, ArrayList<Library2> Books) {
        //회원등록절차1 (이름을 입력받음)
        System.out.println("===========회원 등록을 시작합니다===========");
        System.out.println("회원이름을 적어주세요");
        memberName[memberRegistrationOrder] = sc.next();
        inputMemberNumber(sc, Books);
    }

    void inputMemberNumber(Scanner sc, ArrayList<Library2> Books) {
        //회원등록절차2 (고객의 회원번호를 부여)
        System.out.println("고객님의 회원번호는 " + (memberRegistrationOrder + 1) + "번 입니다");
        memberNumber[memberRegistrationOrder] += 1;
        /*
        가장처음에 addBookComplete라는 전역변수의 값은 0에서 시작한다 회원번호는 1에서 시작하게 설계했기 때문에 +1을 추가했다
        그리고 배열값에 1을 추가한 이유는 나중에 회원을 조회할때 1이 부여되어있으면 해당 손님은 등록이 완료 되었다는 것을 인식하기 위한 값이다
         */
        inputMemberAddress(sc, Books);
    }

    void inputMemberAddress(Scanner sc, ArrayList<Library2> Books) {
        //회원등록절차3 (고객의 주소를 입력)
        System.out.println("회원님의 주소를 적어주세요");
        memberAddress[memberRegistrationOrder] = sc.next();
        System.out.println("========주소 등록이 완료되었습니다========");
        inputMemberPhoneNumber(sc, Books);
    }

    void inputMemberPhoneNumber(Scanner sc, ArrayList<Library2> Books) {
        //회원등록절차4 (고객의 휴대전화 앞4자리와 뒤 4자리를 입력받음)
        System.out.println("휴대전화 앞 4자리를 입력해주세요 (휴대폰 국번 제외)");
        int phoneFrontNumber = sc.nextInt();

        if (phoneFrontNumber >= 1000 && phoneFrontNumber <= 9999) {
            System.out.println("휴대전화 뒤 4자리를 입력해주세요 (휴대폰 국번 제외)");
            int phoneBackNumber = sc.nextInt();

            if (phoneBackNumber >= 1000 && phoneBackNumber <= 9999) {
                memberPhoneNumber[memberRegistrationOrder][0] = phoneFrontNumber;
                memberPhoneNumber[memberRegistrationOrder][1] = phoneBackNumber;
                System.out.println("모든 회원정보 등록이 완료되었습니다");
                memberRegistrationOrder += 1;
                getSystemMenu(sc, Books);
                /*
                회원등록 절차를 완료하면 memberRegistrationOrder 전역변수에 1을 추가하여 다음에 추가적인 회원을 등록할때 다음번호로 입력하기 위함
                휴대전화는 2차원 배열을 사용하였으며 2차원배열값이 0인것은 휴대폰 앞자리를 받으며 1인것은 뒷자리를 받음
                 */
            } else {
                System.out.println("잘못된 입력입니다");
                inputMemberPhoneNumber(sc, Books);
            }
        } else {
            System.out.println("잘못된 입력입니다");
            inputMemberPhoneNumber(sc, Books);
        }
    }

    void findMemberInformation(Scanner sc, ArrayList<Library2> Books) {
        //회원정보조회
        System.out.println("찾는 회원의 이름을 적어주세요");
        String findMemberName = sc.next();

        for (int i = 0; i <= memberRegistrationOrder; i++) {

            if (Objects.equals(memberName[i], findMemberName)) {
                System.out.println("==========회원을 찾았습니다!==========");
                System.out.println("회원번호 : " + memberNumber[i] + "번");
                System.out.println("성함 : " + memberName[i] + "");
                System.out.println("주소 : " + memberAddress[i] + "");
                System.out.println("휴대폰 번호 : 010 - " + memberPhoneNumber[i][0] + " - " + memberPhoneNumber[i][1] + "");
                System.out.println("빌린 책 목록 : ");
                for (int k = 0; k < 1000; k++) {
                    if (borrowBookList[i + 1][k] == 1) {
                        Library2 InformationResult = Books.get(k);
                        System.out.println("제목 : " + InformationResult.bookName + "");
                    }
                }
                getSystemMenu(sc, Books);
            }
        }
        /*
        회원의 이름을 입력하여 Arraylist에 등록된 이름과 일치할경우 해당 index를 추출 배열값에 넣어 고객의 정보를 출력한다
        for문을 통해서 1차원의 값은 i번째로 등록한 손님의 순서이며 2차원 값은 책을 등록할때 해당 책의 고유의번호이다
         */
        System.out.println("일치하는 회원이 없습니다");
        getSystemMenu(sc, Books);
    }

    void findTotalBookList(Scanner sc, ArrayList<Library2> Books) {
        //A도서관에 등록된 책을 모두 출력하기위한 메소드
        System.out.println("A도서관의 책 목록입니다");
        for (Library2 bookListResult : Books) {
            System.out.println("===============================================");
            System.out.println("번호 : " + bookListResult.bookNumber + "번");
            System.out.println("이름 : " + bookListResult.bookName + "");
            System.out.println("작가 : " + bookListResult.bookWriter + "");
            System.out.println("작가 : " + bookListResult.bookWriter + "");
            System.out.println("출판사 : " + bookListResult.publisher + "");
            System.out.println("발매일 : " + bookListResult.releaseYear + "년 " + bookListResult.releaseMonth + "월 " + bookListResult.releaseDays + "일");
        }
        //포잇치문을 통해 Arraylist에 등록된 책을 모두 출력한다
        getSystemMenu(sc, Books);
    }

    void inputBookReturn(Scanner sc, ArrayList<Library2> Books) {
        //책 반납
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 반납이 가능합니다");
        int numberInspection = sc.nextInt();

        for (int i = 0; i <= memberRegistrationOrder; i++) {
            if (memberNumber[i] == numberInspection) {
                System.out.println("반납하는 책의 제목을 적어주세요");
                String returnBooks = sc.next();
                findBookInformation(returnBooks, Books, sc, numberInspection, 2);
            }
        }
        System.out.println("존재하지 않는 회원 번호입니다");
        getSystemMenu(sc, Books);
    }

    void inputBookBorrowMenu(Scanner sc, ArrayList<Library2> Books) {
        //책 대여
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 빌리기가 가능합니다");
        int numberInspection = sc.nextInt();

        for (int i = 0; i <= memberRegistrationOrder; i++) {
            if (memberNumber[i] == numberInspection) {
                System.out.println("대여하는 책의 제목을 적어주세요");
                String borrowBooks = sc.next();
                findBookInformation(borrowBooks, Books, sc, numberInspection, 1);
            }
        }
        System.out.println("존재하지 않는 회원 번호입니다");
        getSystemMenu(sc, Books);
    }

    void findBookInformation(String borrowBooks, ArrayList<Library2> Books, Scanner sc, int numberInspection, int temp) {
        /*
        temp의 변수값이 1인경우 책을 대여하여 정보를 확인하기 위함이며 변수값이 2인경우 반납하기전 해당 책의 정보가 맞는지 확인하기 위한 변수이다
        책의 정보를 출력후에 책의 정보가 맞는지 한번 더 확인을 하기 위해 입력을 받으며 대여를 하는경우
        borrowBookList의 2차원배열을 이용하여 1차원값에는 회원번호를 2차원 값에는 책에서 추출한 index 번호가 들어간다
        대여를 하는경우 배열값에 1을 부여하여 회원정보를 조회할때 빌린책의 정보가 출력되도록 위함
         */
        for (Library2 bookBorrow : Books) {
            if (bookBorrow.bookName.equals("" + borrowBooks + "")) {
                System.out.println("<<<해당 책의 정보를 다시 한번 확인해 주십시요>>>");
                int index = Books.indexOf(bookBorrow);
                Library2 InformationResult = Books.get(index);

                System.out.println("번호 : " + InformationResult.bookNumber + "번");
                System.out.println("이름 : " + InformationResult.bookName + "");
                System.out.println("작가 : " + InformationResult.bookWriter + "");
                System.out.println("작가 : " + InformationResult.bookWriter + "");
                System.out.println("출판사 : " + InformationResult.publisher + "");
                System.out.println("발매일 : " + InformationResult.releaseYear + "년 " + InformationResult.releaseMonth + "월 " + InformationResult.releaseDays + "일");
                System.out.println("===================================");
                System.out.println("해당 책이 맞으면 1번 아니라면 2번을 눌러주세요");

                int againCheck = sc.nextInt();

                if (temp == 1) {
                    if (againCheck == 1) {
                        System.out.println("책 대여가 완료되었습니다");
                        borrowBookList[numberInspection][index] = 1;
                    }
                } else {
                    if (againCheck == 1) {
                        System.out.println("책 반납이 완료되었습니다");
                        borrowBookList[numberInspection][index] = 0;
                    }
                }
                System.out.println("메인메뉴로 돌아갑니다");
                getSystemMenu(sc, Books);
            }
        }
        System.out.println("해당 책이 존재하지 않습니다 다시 확인 해주세요");
        getSystemMenu(sc, Books);
    }
}
