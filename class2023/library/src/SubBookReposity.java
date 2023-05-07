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
    public boolean informationisCheck;
    //책의 존재여부 밎 회원번호 매치 확인을 위해 사용
    SubBookReposity() {
        //서브생성자
    }

    SubBookReposity(int bookNumber, String bookName, String bookWriter, String publisher, int releaseYear, int releaseMonth, int releaseDays, boolean informationisCheck) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.bookWriter = bookWriter;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.releaseDays = releaseDays;
        this.informationisCheck = informationisCheck;
    }

    public void findBookTitle(Scanner sc, ArrayList<SubBookReposity> Books) {
         /*
         메소드 역할 : 책이름을 입력받고 존재여부 확인 후 결과메소드로 이동시켜줌
         메소드 기능 : 책이름을 입력받은 후 for-each문을 돌려 일치하는경우
         책정보를 출력해주는 findBookInformation메소드로 이동
         */
        informationisCheck = false; //책을 찾기위해 재진입할경우 초기화시키기 위함
        System.out.println("찾고있는 책 이름을 적어주세요");
        String findBookName = sc.next();

        for (SubBookReposity indexNumber : Books) {
            if (Objects.equals(indexNumber.bookName, findBookName)) {
                informationisCheck = true;
                findBookInformation(indexNumber);
            }
        }
        if (!informationisCheck) {
            System.out.println("안내 : 책의 정보가 존재하지 않습니다 다시 시도해주세요");
        }
    }

    public void findBookNumber(Scanner sc, ArrayList<SubBookReposity> Books) {
         /*
         메소드 역할 : 책 번호를 입력받고 일치여부를 확인 후 결과메소드인 findBookInformation로 이동
         메소드 기능 : 위 메소드와 마찬가지로 책번호가 일치하는경우 책 결과를 출력해주는 findBookInformation메소드로 이동시킴
         */
        informationisCheck = false;
        System.out.println("찾으시는 책 번호를 적어주세요");
        int bookSerialNumber = sc.nextInt();

        for (SubBookReposity indexNumber : Books) {
            if (indexNumber.bookNumber == bookSerialNumber) {
                informationisCheck = true;
                findBookInformation(indexNumber);
            }
        }
        if (!informationisCheck) {
            System.out.println("안내 : 책의 정보가 존재하지 않습니다 다시 시도해주세요");
        }
    }

    public void findBookWriterName(Scanner sc, ArrayList<SubBookReposity> Books) {
         /*
         메소드 역할 : 책 작가이름을 입력받고 일치여부를 확인 후 결과메소드인 findBookInformation로 이동
         메소드 기능 : 위 메소드와 마찬가지로 작가 이름이 일치하는경우 책 결과를 출력해주는 findBookInformation메소드로 이동시킴
         */
        informationisCheck = false;
        System.out.println("찾으시는 책의 작가 이름을 적어주세요");
        String bookWriter = sc.next();

        for (SubBookReposity indexNumber : Books) {
            if (indexNumber.bookWriter.equals(bookWriter)) {
                informationisCheck = true;
                findBookInformation(indexNumber);
            }
        }
        if (!informationisCheck) {
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
         메소드 기능 : newSerialNumber변수를 1번부터 시작한다 즉 책은 1번부터 번호가 부여되어있기 때문이다
         만약에 책을 삭제하지 않은경우에는 for문을돌면서 비어있으면 탈출하여 해당 번호를 찾지만
         책을 삭제한경우 다음에 책을 등록할때 비어있는 책의 번호를 채워야하기 때문에 for-each문을 사용
         */
        int newSerialNumber = 1;
        for (SubBookReposity findEmptyIndex : Books) {
            if (findEmptyIndex.bookNumber == newSerialNumber) {
                newSerialNumber += 1;
            } else {
                break;
            }
        }
        System.out.println("새로 등록될 책 번호는 : " + newSerialNumber + "번 입니다");
        inputBookName(sc, Books, newSerialNumber);
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
            System.out.println("책 발매 연도(年)을 적어주세요 (1900년 ~ 2023년까지 입력가능)");
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
            System.out.println("책 발매 월(月)을 적어주세요");
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
            System.out.println("책 발매 일(日)을 적어주세요");
            int releaseDays = sc.nextInt();

            if (releaseDays >= 1 && releaseDays <= 31) {
                System.out.println("안내 : 책 등록절차가 모두 완료되었습니다");
                SubBookReposity addBookcomplete = new SubBookReposity(registrationBookNumber, registrationBookName, registrationWriterName, registrationPublisherName, releaseYear, releaseMonth, releaseDays, informationisCheck);
                Books.add(addBookcomplete);
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
        informationisCheck = false;
        System.out.println("회원번호를 입력해주세요 안내 : 회원번호를 입력해야 반납이 가능합니다");
        int numberInspection = sc.nextInt();

        if (peopleInformation.size() >= numberInspection) {
            System.out.println("반납하는 책의 제목을 적어주세요");
            String returnBookName = sc.next();

            for (SubBookReposity returnBookCheck : Books) {
                if (Objects.equals(returnBookCheck.bookName, returnBookName)) {
                    informationisCheck = true;
                    hasBooksInformation(returnBookName, sc, numberInspection, 2, Books);
                    break;
                }
            }
            if (!informationisCheck) {
                System.out.println("안내 : 존재하지 않는 책입니다 다시 확인해주세요");
            }
        } else {
            System.out.println("안내 : 존재하지 않는 회원 번호입니다 다시한번 확인해주세요");
        }
    }

    public void inputBorrowBook(Scanner sc, ArrayList<UserRepository> peopleInformation, ArrayList<SubBookReposity> Books) {
         /*
         메소드 역할 : 책을 빌리는경우 회원번호와 제목을 입력받아 hasBooksInformation메소드로 보낸다
         hasBooksInformation메소드에서 정보가 일치하면 다시 책정보를 확인하고 최종 빌림 확인
         메소드 기능 : returnBook메소드와 마찬가지고 회원번호,책 제목을 입력받고 hasBooksInformation메소드로
         파라미터를 넘겨준다
         */
        int bookNumberSum = 0; //전체 책이 몇권인지 확인하기 위한 변수이다 책은 총 2권까지 빌릴 수 있기 때문이다
        informationisCheck = false;
        System.out.println("회원번호를 입력해주세요");
        System.out.println("안내 : 회원번호를 입력해야 빌리기가 가능하며 1인당 최대 2권만 빌릴수 있습니다");
        int numberInspection = sc.nextInt();

        for (SubBookReposity borrowBookOutput : Books) {    //회원이 책을 몇권빌렸는지 체크하기위한 for-each문
            bookNumberSum += UserRepository.borrowBookList[numberInspection][borrowBookOutput.bookNumber];
        }
        if (bookNumberSum == 2) {
            System.out.println("책은 최대 2권까지만 빌릴 수 있습니다");
        } else {
            if (peopleInformation.size() >= numberInspection) {
                System.out.println("대여하는 책의 제목을 적어주세요");
                String borrowBooks = sc.next();

                for (SubBookReposity returnBookCheck : Books) {
                    if (Objects.equals(returnBookCheck.bookName, borrowBooks) && UserRepository.borrowBookList[numberInspection][returnBookCheck.bookNumber] == 0) {
                        informationisCheck = true;
                        hasBooksInformation(borrowBooks, sc, numberInspection, 1, Books);
                        break;
                    }
                }
                if (!informationisCheck) {
                    System.out.println("안내 : 존재하지 않는 책이거나 이미 대여한 책입니다 다시 확인해주세요");
                }
            } else {
                System.out.println("안내 : 존재하지 않는 회원 번호입니다 다시 시도해주세요");
            }
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
         메소드 기능 : 바로 삭제하고싶은 책을 찾아서 삭제하기 쉽도록 등록된 책을 모두 출력하며
         listindex 변수에 Arraylist의 번호를 추출한 후 Arraylist remove를 통해 삭제한다
         */
        informationisCheck = false;
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
                int listIndex = Books.indexOf(deleteBookIndex); //고유 list의 index번호를 저장
                System.out.println("안내 : 책 정보가 모두 삭제되었습니다");
                Books.remove(listIndex);
                informationisCheck = true;
                break;
            }
        }
        if (!informationisCheck) {
            System.out.println("안내 : 책 번호를 다시한번 확인해주세요");
        }
    }
    public void modifyBookInformation (Scanner sc,ArrayList<SubBookReposity> Books) {
        /*
         메소드 역할 : 등록되어있는 책 정보를 수정
         메소드 기능 : 책번호를 입력받으면 for-each문을 통해 그 책이 존재하는지 여부를 확인하고
         책이 존재할 시 boolean에 true를 부여 존재하지 않은경우 false를 부여한다
         그 후 각각의 수정을 원하는 메뉴에 접근하여 수정 정보를 입력하면 수정이 완료되고 each문을 탈출해 다시 메인메뉴로 돌아간다
         */
        informationisCheck = false;
        System.out.println("수정을 원하는 책 번호를 적어주세요");
        int modifySelectNumber = sc.nextInt();

        for (SubBookReposity modify : Books) {
            if (modify.bookNumber == modifySelectNumber) {
                informationisCheck = true;
                System.out.println("1.책 이름 수정 2.책 작가 수정 3.책 출판사 수정 4.책 발매연도(年) 수정 5.책 발매 월(月) 수정 6.책 발매 일(日) 수정 7.이전으로 돌아가기");
                int modifyChoice = sc.nextInt();

                if (modifyChoice == 1) {
                    System.out.println("새로 수정할 이름을 적어주세요");
                    String newBookName = sc.next();
                    modify.bookName = ""+newBookName+"";
                    System.out.println("수정이 완료되었습니다");
                    break;
                } else if (modifyChoice == 2) {
                    System.out.println("새로 수정할 작가 이름을 적어주세요");
                    String newWriterName = sc.next();
                    modify.bookWriter = ""+newWriterName+"";
                    System.out.println("수정이 완료되었습니다");
                    break;
                } else if (modifyChoice == 3) {
                    System.out.println("새로 수정할 출판사 이름을 적어주세요");
                    String newpublisherName = sc.next();
                    modify.bookWriter = ""+newpublisherName+"";
                    System.out.println("수정이 완료되었습니다");
                    break;
                } else if (modifyChoice == 4) {
                    System.out.println("새로 수정할 발매연도(年)를 적어주세요");
                    int newReleaseYear = sc.nextInt();

                    if (newReleaseYear >= 1900 && newReleaseYear <= 2023) {
                        System.out.println("수정이 완료되었습니다");
                        modify.releaseYear = newReleaseYear;
                    } else {
                        System.out.println("안내 : 잘못된 입력입니다");
                    }
                    break;
                } else if (modifyChoice == 5) {
                    System.out.println("새로 수정할 발매 월(月)를 적어주세요");
                    int newReleaseMonth = sc.nextInt();

                    if (newReleaseMonth >= 1 && newReleaseMonth <= 12) {
                        System.out.println("수정이 완료되었습니다");
                        modify.releaseMonth = newReleaseMonth;
                    } else {
                        System.out.println("안내 : 잘못된 입력입니다");
                    }
                    break;
                } else if (modifyChoice == 6) {
                    System.out.println("새로 수정할 발매 일(日)를 적어주세요");
                    int newReleaseDays = sc.nextInt();

                    if (newReleaseDays >= 1 && newReleaseDays <= 31) {
                        System.out.println("수정이 완료되었습니다");
                        modify.releaseDays = newReleaseDays;
                    } else {
                        System.out.println("안내 : 잘못된 입력입니다");
                    }
                    break;
                } else if (modifyChoice == 7) {
                    System.out.println("메인메뉴로 돌아갑니다");
                    break;
                } else {
                    System.out.println("잘못된 입력입니다");
                    break;
                }
            }
        }
        if (!informationisCheck) {
            System.out.println("존재하지 않는 책입니다 다시 확인해주세요");
        }
    }

    public void loadTotalBookInformation(ArrayList<SubBookReposity> Books) {
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
