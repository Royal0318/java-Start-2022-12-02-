import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SubBookReposity {
    public int bookNumber;
    //책이 가지고있는 시리얼 넘버
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
    public boolean checkTemp;
    //책의 존재여부 밎 회원번호 매치 확인을 위해 사용
    public int deleteBookSave;
    //회원정보나 책을 삭제한경우 index 번호를 전역변수에 저장하여 다음에 등록할경우 빈 index번호를 채우기 위함
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

    public void findBookTitle(Scanner sc, ArrayList<SubBookReposity> Books) {
         /*
         메소드 역할 : 책이름을 입력받고 존재여부 확인 후 결과메소드로 이동시켜줌
         메소드 기능 : 책이름을 입력받은 후 for-each문을 돌려 일치하는경우
         책정보를 출력해주는 findBookInformation메소드로 이동
         */
        checkTemp = false; //책을 찾기위해 재진입할경우 초기화시키기 위함
        System.out.println("찾고있는 책 이름을 적어주세요");
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

    public void findBookNumber(Scanner sc, ArrayList<SubBookReposity> Books) {
         /*
         메소드 역할 : 책 번호를 입력받고 일치여부를 확인 후 결과메소드인 findBookInformation로 이동
         메소드 기능 : 위 메소드와 마찬가지로 책번호가 일치하는경우 책 결과를 출력해주는 findBookInformation메소드로 이동시킴
         */
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

    public void findBookWriterName(Scanner sc, ArrayList<SubBookReposity> Books) {
         /*
         메소드 역할 : 책 작가이름을 입력받고 일치여부를 확인 후 결과메소드인 findBookInformation로 이동
         메소드 기능 : 위 메소드와 마찬가지로 작가 이름이 일치하는경우 책 결과를 출력해주는 findBookInformation메소드로 이동시킴
         */
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
        /*
         메소드 역할 : 위 3개의 메소드에서 입력한 결과값을 출력시켜준다
         메소드 기능 : 일치하는 index 파라미터를 받아서 그 index번호에 속하는 list내용을 모두 출력시킨다
         */
        System.out.println("책을 찾았습니다!!!");
        System.out.println("책 번호 : " + bookIndex.bookNumber + "");
        System.out.println("책 이름 : " + bookIndex.bookName + "");
        System.out.println("작가 : " + bookIndex.bookWriter + "");
        System.out.println("출판사 : " + bookIndex.publisher + "");
        System.out.println("발매 연월일 : " + bookIndex.releaseYear + "년 " + bookIndex.releaseMonth + "월 " + bookIndex.releaseDays + "일");
    }

    public void inputBookRegistration(Scanner sc, ArrayList<SubBookReposity> Books) {
         /*
         메소드 역할 : 책 등록을 위한 1번째 절차이며 책번호를 부여함
         메소드 기능 : UserRepository클래스와 같은 방법이며 책을 지웠을때는 deleteBookSave변수에 담겨있는 리터럴이 존재할경우
         list에 빈 번호를 채우기위해 바로 부여하며
         삭제한 기록이 없는경우에는 list.size + 1을 파라미터에 담는다
         */
        if (deleteBookSave != 0) { //책을 지운경우 새로운 책을등록하는경우 다시 그 번호를 사용한다
            System.out.println("새로 등록될 책 번호는 : " + deleteBookSave + "번 입니다");
            inputBookName(sc, Books, deleteBookSave);
        } else { //지우지않은경우 그대로 등록
            System.out.println("새로 등록될 책 번호는 : " + (Books.size() + 1) + "번 입니다");
            inputBookName(sc, Books, (Books.size() + 1));
        }
    }

    public void inputBookName(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber) {
         /*
         메소드 역할 : 책 등록을 위한 2번째 절차이며 책 이름을 받음
         메소드 기능 : 등록할 책 이름을 입력받아 파라미터에 넣고 다음메소드로 이동
         */
        System.out.println("등록할 책의 이름을 적어주세요");
        String registrationBookName = sc.next();
        System.out.println("안내 : 정상적으로 등록되었습니다");
        inputBookWriter(sc, Books, registrationBookNumber, registrationBookName);
    }

    public void inputBookWriter(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String registrationBookName) {
         /*
         메소드 역할 :  책 등록을 위한 3번째 절차이며 작가 이름을 받음
         메소드 기능 : 등록할 작가 이름을 입력받아 파라미터에 넣고 다음메소드로 이동
         */
        System.out.println("작가 이름을 적어주세요");
        String registrationWriterName = sc.next();
        System.out.println("안내 : 정상적으로 등록되었습니다");
        inputBookPublisher(sc, Books, registrationBookNumber, registrationBookName, registrationWriterName);
    }

    public void inputBookPublisher(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String registrationBookName, String registrationWriterName) {
         /*
         메소드 역할 :  책 등록을 위한 4번째 절차이며 출판사 이름을 받음
         메소드 기능 : 등록할 출판사 이름을 입력받아 파라미터에 넣고 다음메소드로 이동
         */
        System.out.println("책 출판사를 적어주세요");
        String registrationPublisherName = sc.next();
        System.out.println("안내 : 책 출판사를 정상적으로 등록하였습니다");
        inputBookReleaseYear(sc, Books, registrationBookNumber, registrationBookName, registrationWriterName, registrationPublisherName);
    }

    public void inputBookReleaseYear(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String registrationBookName, String registrationWriterName, String registrationPublisherName) {
        /*
         메소드 역할 :  책 등록을 위한 5번째 절차이며 책 발매 연도를 받음
         메소드 기능 : 등록할 책 발매연도를 출력하기위해 연도를 입력받아 파라미터에 넣고 다음메소드로 이동 출시연도는 1900 ~ 2023년까지 제한하였다
         */
        while (true) {
            System.out.println("책 발매 연도(Year)을 적어주세요 (1900년 ~ 2023년까지 입력가능)");
            int releaseYear = sc.nextInt();

            if (releaseYear >= 1900 && releaseYear <= 2023) {
                System.out.println("안내 : 연도 등록이 완료되었습니다");
                inputBookReleaseMonth(sc, Books, registrationBookNumber, registrationBookName, registrationWriterName, registrationPublisherName, releaseYear);
                break;
            } else {
                System.out.println("안내 : 잘못된 입력입니다");
            }
        }
    }

    public void inputBookReleaseMonth(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String registrationBookName, String registrationWriterName, String registrationPublisherName, int releaseYear) {
         /*
         메소드 역할 :  책 등록을 위한 6번째 절차이며 책 발매 월를 받음
         메소드 기능 : 등록할 책 발매 월을 출력하기위해 월를 입력받아 파라미터에 넣고 다음메소드로 이동
         */
        while (true) {
            System.out.println("책 발매 월(Month)을 적어주세요");
            int releaseMonth = sc.nextInt();

            if (releaseMonth >= 1 && releaseMonth <= 12) {
                System.out.println("안내 : 월 등록이 완료되었습니다");
                inputBookReleaseDays(sc, Books, registrationBookNumber, registrationBookName, registrationWriterName, registrationPublisherName, releaseYear, releaseMonth);
                break;
            } else {
                System.out.println("안내 : 잘못된 입력입니다");
            }
        }
    }

    public void inputBookReleaseDays(Scanner sc, ArrayList<SubBookReposity> Books, int registrationBookNumber, String registrationBookName, String registrationWriterName, String registrationPublisherName, int releaseYear, int releaseMonth) {
         /*
         메소드 역할 : 책 등록을 위한 마지막 절차이며 책 발매 요일을 받고 책을 등록시킴
         메소드 기능 : 등록할 책 발매 요일을 출력하기위해 요일을 1일 ~ 31일로 입력받고 넘겨받은파라미터를 모두 list에 등록한다
         삭제한 내역이 있으면 deleteBookSave변수의 리터럴값을 초기화
         */
        while (true) {
            System.out.println("책 발매 일(Days)을 적어주세요");
            int releaseDays = sc.nextInt();

            if (releaseDays >= 1 && releaseDays <= 31) {
                System.out.println("안내 : 책 등록절차가 모두 완료되었습니다");
                SubBookReposity addBookcomplete = new SubBookReposity(registrationBookNumber, registrationBookName, registrationWriterName, registrationPublisherName, releaseYear, releaseMonth, releaseDays, checkTemp,deleteBookSave);
                Books.add(addBookcomplete);
                deleteBookSave = 0;
                break;
            } else {
                System.out.println("안내 : 잘못된 입력입니다");
            }
        }
    }
    public void returnBook(Scanner sc, ArrayList<UserRepository> peopleInformation, ArrayList<SubBookReposity> Books) {
         /*
         메소드 역할 : 책을 빌린경우 반납을 하기위해 회원번호와 제목을 입력받아 hasBooksInformation메소드로 보낸다
         hasBooksInformation메소드에서 정보가 일치하면 다시 책정보를 확인하고 최종 반납
         메소드 기능 : 회원번호 존재 여부 확인 후 반납하는 책의 제목을 for-each문으로 판단한다
         빌리는 메소드와 반납메소드에 따로따로 넣는다면 코드가 길어지기때문에 따로 분리를 시켰다
         hasBooksInformation메소드로 넘기는 파라미터중에 2번은 반납이고 1번은 빌리는것이다
         */
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 반납이 가능합니다");
        int numberInspection = sc.nextInt();

        if (peopleInformation.size() >= numberInspection) {
            System.out.println("반납하는 책의 제목을 적어주세요");
            String returnBookName = sc.next();

            for (SubBookReposity returnBookCheck : Books) {
                if (Objects.equals(returnBookCheck.bookName, returnBookName)) {
                    checkTemp = true;
                    hasBooksInformation(returnBookName, sc, numberInspection, 2, Books);
                }
            }
            if (!checkTemp) {
                System.out.println("안내 : 존재하지 않는 책입니다 다시 확인해주세요");
            }
        } else {
            System.out.println("안내 : 존재하지 않는 회원 번호입니다 다시한번 확인해주세요");
        }
    }

    public void borrowBook(Scanner sc, ArrayList<UserRepository> peopleInformation, ArrayList<SubBookReposity> Books) {
         /*
         메소드 역할 : 책을 빌리는경우 회원번호와 제목을 입력받아 hasBooksInformation메소드로 보낸다
         hasBooksInformation메소드에서 정보가 일치하면 다시 책정보를 확인하고 최종 빌림 확인
         메소드 기능 : returnBook메소드와 마찬가지고 회원번호,책 제목을 입력받고 hasBooksInformation메소드로
         파라미터를 넘겨준다
         */
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 빌리기가 가능합니다");
        int numberInspection = sc.nextInt();

        if (peopleInformation.size() >= numberInspection) {
            System.out.println("대여하는 책의 제목을 적어주세요");
            String borrowBooks = sc.next();

            for (SubBookReposity returnBookCheck : Books) {
                if (Objects.equals(returnBookCheck.bookName, borrowBooks)) {
                    checkTemp = true;
                    hasBooksInformation(borrowBooks, sc, numberInspection, 1, Books);
                }
            }
            if (!checkTemp) {
                System.out.println("안내 : 존재하지 않는 책입니다 다시 시도해주세요");
            }
        } else {
            System.out.println("안내 : 존재하지 않는 회원 번호입니다 다시 시도해주세요");
        }
    }

    public void hasBooksInformation(String borrowBooks, Scanner sc, int numberInspection, int borrowRetrunCheckIndex, ArrayList<SubBookReposity> Books) {
         /*
         메소드 역할 : 반납,대여하는경우 정보를 입력하면 책정보 확인여부 후 대여,반납
         메소드 기능 : 파라미터에 받은 입력한정보들을 for-each문을통해 책 정보를 확인하며 반납은 2번 리턴은 1번이기때문에
         코드의 중복을 없애기위해 따로 한곳에 몰아넣었으며 책 정보가 일치하여 1번을 선택하는경우
         받은파라미터 번호에따라 반납,대여를 판단한다
         */
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
                int informationReCheck = sc.nextInt();

                if (informationReCheck == 1) {
                    if (borrowRetrunCheckIndex == 1) {
                        System.out.println("안내 : 대여가 성공적으로 완료되었습니다");
                        UserRepository.borrowBookList[numberInspection][findBook.bookNumber] = 1; //2차원 배열을 이용해 1을 부여하여 빌린것을 check한다
                    } else {
                        if (UserRepository.borrowBookList[numberInspection][findBook.bookNumber] == 1) {
                            System.out.println("안내 : 반납이 성공적으로 완료되었습니다");
                            UserRepository.borrowBookList[numberInspection][findBook.bookNumber] = 0; //반납한경우 0으로 초기화
                        } else {
                            System.out.println("안내 : 책을 빌린 내역이 없습니다");
                        }
                        break;
                    }
                } else if (informationReCheck == 2) {
                    System.out.println("안내 : 메인 메뉴로 돌아갑니다");
                    break;
                } else {
                    System.out.println("안내 : 잘못된 입력입니다");
                    break;
                }
            }
        }
    }
    public void deleteBook (Scanner sc, ArrayList<SubBookReposity> Books) {
         /*
         메소드 역할 : 등록된 책을 삭제
         메소드 기능 : 처음에 등록되어있는 책을 모두 출력한 후 삭제하고싶은 책의 번호를 입력받는다
         그 후 일치하는경우 deleteBookSave변수에 삭제한 책의 index를 담는다 왜냐하면 다음에 책을 새로 등록할때 삭제된 번호를
         채워야 하기 때문이다 그 후에 list.remove를 이용하여 정보를 모두 지운다
         */
        checkTemp = false;
        for (SubBookReposity bookListResult : Books) {
            System.out.println("===============================================");
            System.out.println("번호 : " + bookListResult.bookNumber + "번");
            System.out.println("이름 : " + bookListResult.bookName + "");
        }
        System.out.println("===============================================");
        System.out.println("삭제하고싶은 책 번호를 입력해주세요");
        int removeBookSerialNumber = sc.nextInt();

        for (SubBookReposity deleteBookIndex : Books) {
            if (deleteBookIndex.bookNumber == removeBookSerialNumber) {
                System.out.println("안내 : 책 정보가 모두 삭제되었습니다");
                deleteBookSave = (removeBookSerialNumber - 1); //실제 입력값과 Arraylist에 등록된 index의 차이가 -1만큼 존재하기 때문
                Books.remove(deleteBookSave);
                checkTemp = true;
                break;
            }
        }
        if (!checkTemp) {
            System.out.println("안내 : 책 번호를 다시한번 확인해주세요");
        }
    }

    public void findTotalBookInformation(ArrayList<SubBookReposity> Books) {
         /*
         메소드 역할 : 도서관에 등록되어있는 책을 모두 출력
         메소드 기능 : 도서관에 등록되어있는 책을 for-each문을 통해 출력함
         */
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
