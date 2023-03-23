import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class Library2 {
    //책등록
    public int bookNumber;
    //책넘버
    public String bookName;
    //책이름
    public String bookWriter;
    //책을 쓴 작가
    public String publisher;
    //출판사
    public int releaseYear;
    public int releaseMonth;
    public int releaseDays;
    public int memberRegistrationOrder;
    public int bookFindCheckNumber;
    //밑에서부터 회원정보등록
    public String[] memberName;
    public int[] memberNumber;
    public String[] memberAddress;
    public int[][] memberPhoneNumber;
    public int[][] borrowBookList;


    Library2 () {

    }
    Library2 (int bookNumber,String bookName,String bookWriter,String publisher,int releaseYear,int releaseMonth,int releaseDays,int memberRegistrationOrder,int bookFindCheckNumber,String[] memberName,int[] memberNumber,String[] memberAddress,int[][] memberPhoneNumber,int[][] borrowBookList) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.bookWriter = bookWriter;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.releaseDays = releaseDays;
        this.memberRegistrationOrder = memberRegistrationOrder;
        this.bookFindCheckNumber = bookFindCheckNumber;
        this.memberName = memberName;
        this.memberNumber = memberNumber;
        this.memberAddress = memberAddress;
        this.memberPhoneNumber = memberPhoneNumber;
        this.borrowBookList = borrowBookList;
    }

    void systemMenu (Scanner sc,ArrayList<Library2> Books) {
        System.out.println("\n=======A 도서관 관리 프로그램입니다=======");
        System.out.println("1.도서 찾기 2.도서 등록 3.도서 반납 4.도서 대여 5.회원등록 6.회원조회 7.전체 책 조회 8.시스템 종료");
        int menuChoice = sc.nextInt();

        switch (menuChoice) {
            case 1 :
                bookFind(sc,Books);
                break;
            case 2 :
                bookRegistration(sc,Books);
                break;
            case 3 :
                bookReturn(sc,Books);
                break;
            case 4 :
                bookBorrow(sc,Books);
                break;
            case 5 :
                memberNameRegistration(sc,Books);
                break;
            case 6 :
                memberInformation(sc,Books);
                break;
            case 7 :
               totalBookList(sc,Books);
            case 8 :
                System.out.println("프로그램을 종료합니다");
                System.exit(0);
                break;
            default :
                System.out.println("잘못된 입력입니다");
                break;
        }
    }
    void bookFind (Scanner sc,ArrayList<Library2> Books) {
        //책 찾기
        System.out.println("어떤 방법으로 찾으시겠습니까?");
        System.out.println("1.책 이름으로 찾기 2.작가 이름으로 찾기 3.출판사로 찾기 4.책 번호로 찾기");
        int selectMethod = sc.nextInt();

        switch (selectMethod) {
            case 1 :
                findByBookName(sc,Books);
                break;
            case 2 :
                findByWriterName(sc,Books);
                break;
            case 3 :
                findByPublisherName(sc,Books);
                break;
            case 4 :
                findByBookNumber(sc,Books);
                break;
            default :
                System.out.println("잘못된 입력입니다");
                break;
        }
    }
    void findByBookName (Scanner sc,ArrayList<Library2> Books) {
        //책이름으로 찾기
        System.out.println("찾고자하는 책의 이름을 적어주세요");
        String findBook = sc.next();

        for (Library2 s : Books) {
            if (s.bookName.equals(""+findBook+"")) {
                findBookOutput(sc,Books,s);
                bookFindCheckNumber = 1;
                break;
            }
        }
        if (bookFindCheckNumber == 0) {
            System.out.println("원하시는 책이 존재하지 않습니다");
            systemMenu(sc, Books);
        }
    }
    void findByWriterName (Scanner sc,ArrayList<Library2> Books) {
        //작가 이름으로 찾기
        System.out.println("찾고자하는 작가 이름을 적어주세요");
        String findName = sc.next();

        for (Library2 s : Books) {
            if (s.bookWriter.equals(""+findName+"")) {
                findBookOutput(sc,Books,s);
                break;
            }
        }
        if (bookFindCheckNumber == 0) {
            System.out.println("원하시는 책이 존재하지 않습니다");
            systemMenu(sc, Books);
        }
    }
    void findByPublisherName (Scanner sc,ArrayList<Library2> Books) {
        //출판사 이름으로 찾기
        System.out.println("출판사 이름을 적어주세요");
        String findPublisher = sc.next();

        for (Library2 s : Books) {
            if (s.publisher.equals(""+findPublisher+"")) {
                findBookOutput(sc,Books,s);
            }
        }
        if (bookFindCheckNumber == 0) {
            System.out.println("원하시는 책이 존재하지 않습니다");
            systemMenu(sc, Books);
        }
    }
    void findByBookNumber (Scanner sc,ArrayList<Library2> Books) {
        //책 번호로 찾기
        System.out.println("책 번호를 적어주세요");
        int findBookNumber = sc.nextInt();

        for (Library2 s : Books) {
            if (s.bookNumber == findBookNumber) {
                findBookOutput(sc,Books,s);
            }
        }
        if (bookFindCheckNumber == 0) {
            System.out.println("원하시는 책이 존재하지 않습니다");
            systemMenu(sc, Books);
        }
    }
    void findBookOutput (Scanner sc,ArrayList<Library2> Books,Library2 s) {
        System.out.println("해당 책을 찾았습니다!!!");
        System.out.println("===================================");
        int index = Books.indexOf(s);
        Library2 m = Books.get(index);
        System.out.println("============책 정보============");
        System.out.println("번호 : "+m.bookNumber+"번");
        System.out.println("이름 : "+m.bookName+"");
        System.out.println("작가 : "+m.bookWriter+"");
        System.out.println("작가 : "+m.bookWriter+"");
        System.out.println("출판사 : "+m.publisher+"");
        System.out.println("발매일 : "+m.releaseYear+"년 "+m.releaseMonth+"월 "+m.releaseDays+"일");
        System.out.println("===================================");
        systemMenu(sc,Books);
    }
    void bookRegistration (Scanner sc,ArrayList<Library2> Books) {
        //새로운 책 등록시작 , 책의번호 입력
        System.out.println("등록할 책의 번호를 부여해주세요 (0 ~ 999)");
        int inputBookNumber = sc.nextInt();

        if (inputBookNumber >= 0 && inputBookNumber <= 999) {
            for (Library2 registration : Books) {
                if (registration.bookNumber == inputBookNumber) {
                    System.out.println("이미 등록된 책이 존재합니다 다시 입력해주세요");
                    bookRegistration(sc, Books);
                    break;
                }
            }
            System.out.println("번호 저장이 완료되었습니다");
            bookNameRegistration(sc, Books, inputBookNumber);
        } else {
            System.out.println("잘못된 입력입니다");
            bookRegistration(sc, Books);
        }
    }
    void bookNameRegistration (Scanner sc,ArrayList<Library2> Books,int inputBookNumber) {
        //책 등록 : 책의 이름
        System.out.println("등록하는 책의 이름을 적어주세요");
        String bookNameInput = sc.next();
        System.out.println("등록이 완료되었습니다");
        bookWriterRegistration(sc,Books,inputBookNumber,bookNameInput);
    }
    void bookWriterRegistration (Scanner sc,ArrayList<Library2> Books,int inputBookNumber,String bookNameInput) {
        //책 등록 : 책의 작가
        System.out.println("등록하는 책의 작가 이름을 적어주세요");
        String bookWriterName = sc.next();
        System.out.println("등록이 완료되었습니다");
        bookPublisherRegistration(sc,Books,inputBookNumber,bookNameInput,bookWriterName);
    }
    void bookPublisherRegistration (Scanner sc,ArrayList<Library2> Books,int inputBookNumber,String bookNameInput,String bookWriterName) {
        //책 등록 : 책 출판사
        System.out.println("등록하는 책의 출판사를 적어주세요");
        String publisherInput = sc.next();
        System.out.println("등록이 완료되었습니다");
        bookReleaseYearInput(sc,Books,inputBookNumber,bookNameInput,bookWriterName,publisherInput);
    }
    void bookReleaseYearInput (Scanner sc,ArrayList<Library2> Books,int inputBookNumber,String bookNameInput,String bookWriterName,String publisherInput) {
        //책 등록 : 발매연도
        System.out.println("책 발매 연도를 적어주세요 (1900년 ~ 2023년까지 입력가능)");
        int year = sc.nextInt();

        if (year >= 1900 && year <= 2023) {
            System.out.println("연도 등록이 완료되었습니다");
            bookReleaseMonthInput(sc,Books,inputBookNumber,bookNameInput,bookWriterName,publisherInput,year);
        } else {
            System.out.println("잘못된 입력입니다");
            bookReleaseYearInput(sc,Books,inputBookNumber,bookNameInput,bookWriterName,publisherInput);
        }
    }
    void bookReleaseMonthInput (Scanner sc,ArrayList<Library2> Books,int inputBookNumber,String bookNameInput,String bookWriterName,String publisherInput,int releaseYearInput) {
        //책 등록 : 발매한 월
        System.out.println("책이 발매한 달을 적어주세요");
        int month = sc.nextInt();

        if (month > 0 && month <= 12) {
            System.out.println("월 등록이 완료되었습니다");
            bookReleaseDaysInput(sc,Books,inputBookNumber,bookNameInput,bookWriterName,publisherInput,releaseYearInput,month);
        } else {
            System.out.println("잘못된 입력입니다");
            bookReleaseMonthInput(sc,Books,inputBookNumber,bookNameInput,bookWriterName,publisherInput,releaseYearInput);
        }
    }
    void bookReleaseDaysInput (Scanner sc,ArrayList<Library2> Books,int inputBookNumber,String bookNameInput,String bookWriterName,String publisherInput,int releaseYearInput,int month) {
        //책 등록 : 발매 요일
        System.out.println("책이 발매한 날짜을 적어주세요");
        int days = sc.nextInt();

        if (days >= 1 && days <= 31) {
            System.out.println("전체 등록이 완료되었습니다");
            Library2 addBookComplete = new Library2(inputBookNumber,bookNameInput,bookWriterName,publisherInput,releaseYearInput,month,days,memberRegistrationOrder,0,memberName,memberNumber,memberAddress,memberPhoneNumber,borrowBookList);
            Books.add(addBookComplete);
            systemMenu(sc,Books);
        } else {
            System.out.println("잘못된 입력입니다");
            bookReleaseDaysInput(sc,Books,inputBookNumber,bookNameInput,bookWriterName,publisherInput,releaseYearInput,month);
        }
    }
    void memberNameRegistration (Scanner sc,ArrayList<Library2> Books) {
        //회원등록
        System.out.println("===========회원 등록을 시작합니다===========");
        System.out.println("회원이름을 적어주세요");
        memberName[memberRegistrationOrder] = sc.next();
        memberNumberRegistration(sc,Books);
    }
    void memberNumberRegistration (Scanner sc,ArrayList<Library2> Books) {
        System.out.println("고객님의 회원번호는 "+(memberRegistrationOrder+1)+"번 입니다");
        memberNumber[memberRegistrationOrder] += (memberRegistrationOrder+1);
        memberAddressRegistration(sc, Books);
    }
    void memberAddressRegistration (Scanner sc,ArrayList<Library2> Books) {
        System.out.println("회원님의 주소를 적어주세요");
        memberAddress[memberRegistrationOrder] = sc.next();
        System.out.println("========주소 등록이 완료되었습니다========");
        memberPhoneNumberRegistration(sc,Books);
    }
    void memberPhoneNumberRegistration (Scanner sc,ArrayList<Library2> Books) {
        System.out.println("휴대전화 앞 4자리를 입력해주세요 (휴대폰 국번 제외)");
        int phoneFrontNumber = sc.nextInt();

        if (phoneFrontNumber >= 1000 && phoneFrontNumber <= 9999) {
            System.out.println("휴대전화 뒤 4자리를 입력해주세요 (휴대폰 국번 제외)");
            int phoneBackNumber = sc.nextInt();

            if (phoneBackNumber >= 1000 && phoneBackNumber <= 9999) {
                memberPhoneNumber[memberRegistrationOrder][0] = phoneFrontNumber;
                memberPhoneNumber[memberRegistrationOrder][1] = phoneBackNumber;
                System.out.println("모든 회원정보 등록이 완료되었습니다");
                systemMenu(sc, Books);
            } else {
                System.out.println("잘못된 입력입니다");
                memberPhoneNumberRegistration(sc,Books);
            }
        } else {
            System.out.println("잘못된 입력입니다");
            memberPhoneNumberRegistration(sc,Books);
        }
    }
    void memberInformation (Scanner sc,ArrayList<Library2> Books) {
        //회원정보조회
        System.out.println("찾는 회원의 이름을 적어주세요");
        String findMemberName = sc.next();

        for (int i = 0;i <= memberRegistrationOrder;i++) {

            if (Objects.equals(memberName[i], findMemberName)) {
                System.out.println("==========회원을 찾았습니다!==========");
                System.out.println("회원번호 : "+memberNumber[i]+"번");
                System.out.println("성함 : "+memberName[i]+"");
                System.out.println("주소 : "+memberAddress[i]+"");
                System.out.println("휴대폰 번호 : 010 - "+memberPhoneNumber[i][0]+" - "+memberPhoneNumber[i][1]+"");
                System.out.println("빌린 책 목록 : ");
                    for (int k = 0;k < 1000;k++) {
                        if (borrowBookList[i+1][k] == 1) {
                            Library2 m = Books.get(k);
                            System.out.println("제목 : "+m.bookName+"");
                        }
                    }

                //빌린책수정
                systemMenu(sc, Books);
            } else {
                System.out.println("일치하는 회원이 없습니다");
                systemMenu(sc, Books);
            }
        }
    }
    void totalBookList (Scanner sc,ArrayList<Library2> Books) {
        System.out.println("A도서관의 책 목록입니다");
        for (Library2 list : Books) {
            System.out.println("===============================================");
            System.out.println("번호 : " + list.bookNumber + "번");
            System.out.println("이름 : " + list.bookName + "");
            System.out.println("작가 : " + list.bookWriter + "");
            System.out.println("작가 : " + list.bookWriter + "");
            System.out.println("출판사 : " + list.publisher + "");
            System.out.println("발매일 : " + list.releaseYear + "년 " + list.releaseMonth + "월 " + list.releaseDays + "일");
        }
        systemMenu(sc,Books);
    }
    void bookReturn (Scanner sc,ArrayList<Library2> Books) {
        //책 반납
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 반납이 가능합니다");
        int numberInspection = sc.nextInt();

        for (int i = 0; i <= memberRegistrationOrder;i++) {
            if (memberNumber[i] == numberInspection) {
                System.out.println("반납하는 책의 제목을 적어주세요");
                String returnBooks = sc.next();

                bookInformationFind(returnBooks,Books,sc,numberInspection,2);

            } else {
                System.out.println("존재하지 않는 회원 번호입니다");
                systemMenu(sc, Books);
            }
        }
    }
    void bookBorrow (Scanner sc,ArrayList<Library2> Books) {
        //책 대여
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 빌리기가 가능합니다");
        int numberInspection = sc.nextInt();

        for (int i = 0; i <= memberRegistrationOrder;i++) {
            if (memberNumber[i] == numberInspection) {
                System.out.println("대여하는 책의 제목을 적어주세요");
                String borrowBooks = sc.next();

                 bookInformationFind(borrowBooks,Books,sc,numberInspection,1);

            } else {
                System.out.println("존재하지 않는 회원 번호입니다");
                systemMenu(sc, Books);
            }
        }
    }
    void bookInformationFind (String borrowBooks,ArrayList<Library2> Books,Scanner sc,int numberInspection,int temp) {
        for (Library2 bookBorrow : Books) {
            if (bookBorrow.bookName.equals("" + borrowBooks + "")) {
                System.out.println("<<<해당 책의 정보를 다시 한번 확인해 주십시요>>>");
                int index = Books.indexOf(bookBorrow);
                Library2 find = Books.get(index);
                bookFindCheckNumber = 1;

                System.out.println("번호 : " + find.bookNumber + "번");
                System.out.println("이름 : " + find.bookName + "");
                System.out.println("작가 : " + find.bookWriter + "");
                System.out.println("작가 : " + find.bookWriter + "");
                System.out.println("출판사 : " + find.publisher + "");
                System.out.println("발매일 : " + find.releaseYear + "년 " + find.releaseMonth + "월 " + find.releaseDays + "일");
                System.out.println("===================================");
                System.out.println("해당 책이 맞으면 1번 아니라면 2번을 눌러주세요");

                int againCheck = sc.nextInt();

                if (temp == 1) {
                    if (againCheck == 1) {
                        System.out.println("책 대여가 완료되었습니다");
                        borrowBookList[numberInspection][index] = 1;
                    } else {
                        System.out.println("메인메뉴로 돌아갑니다");
                    }
                } else {
                    if (againCheck == 1) {
                        System.out.println("책 반납이 완료되었습니다");
                        borrowBookList[numberInspection][index] = 0;
                    } else {
                        System.out.println("메인메뉴로 돌아갑니다");
                    }
                }
                systemMenu(sc, Books);

                if (bookFindCheckNumber == 0) {
                    System.out.println("해당 책이 존재하지 않습니다 다시 확인 해주세요");
                    systemMenu(sc, Books);
                }
            }
        }
    }
}
