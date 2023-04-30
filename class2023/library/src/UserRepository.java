import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UserRepository {
    public String memberName;
    //회원의 이름
    public int memberNumber;
    //회원번호
    public String memberAddress;
    //회원주소
    public int memberPhoneFrontNumber;
    public int memberPhoneBackNumber;
    //회원의 휴대폰번호 (앞4자리와 뒤4자리를 받아야 하기 때문에 2차원 배열을 사용 [][0]은 앞4자리를 받으며 [][1]은 뒤4자리를 받는다)
    public static int[][] borrowBookList;
    //회원이 빌린 책을 저장하는 변수 1차원에는 회원의번호가 2차원에는 회원이 빌린 책의 번호가 저장된다
    public static boolean informationisCheck;
    //빌림,반납,회원번호 조회 등등 확인이 필요한 작업에 boolean을사용하여 존재여부를 판단한다
    public UserRepository() {
        //예비생성자
    }

    UserRepository(String memberName, int memberNumber, String memberAddress, int memberPhoneFrontNumber, int memberPhoneBackNumber, int[][] borrowBookList, boolean informationisCheck) {
        this.memberName = memberName;
        this.memberNumber = memberNumber;
        this.memberAddress = memberAddress;
        this.memberPhoneFrontNumber = memberPhoneFrontNumber;
        this.memberPhoneBackNumber = memberPhoneBackNumber;
        UserRepository.informationisCheck = informationisCheck;
        UserRepository.borrowBookList = borrowBookList;
    }
    static void memberRegistrationName(Scanner sc, ArrayList<UserRepository> peopleInformation, int[][] borrowBookList) {
         /*
        메소드 역할 : 회원등록 1번째 절차이며 회원번호 부여, 이름 입력
        메소드 기능 : 회원번호는 for-each로 판단한다 왜냐하면 중간에 회원을 삭제하는경우,삭제하지않고 또등록하는경우
        2가지의 경우의수가 존재하기 때문이다 그렇기때문에 for-each문을 돌면서 비어있는 번호를 찾아 먼저 등록하고 비어있지않고 모두 존재하는경우
        다음번호를 부여하는 알고리즘을 생각했다
         */
        System.out.println("===========회원등록 절차를 시작합니다===========");

        int newSerialNumber = 1;
        for (UserRepository findEmptyIndex : peopleInformation) {
            if (findEmptyIndex.memberNumber == newSerialNumber) {
                newSerialNumber += 1;
            } else {
                break;
            }
        }
        System.out.println("새로운 회원번호는 : "+newSerialNumber+"번 입니다");
        System.out.println("회원의 이름을 적어주세요");
        String signupMemberName = sc.next();

        System.out.println("안내 : 회원 이름이 정상적으로 등록되었습니다");
        memberRegistrationAddress(sc, peopleInformation, borrowBookList, signupMemberName, newSerialNumber);
    }

    static void memberRegistrationAddress(Scanner sc, ArrayList<UserRepository> peopleInformation, int[][] borrowBookList, String signupMemberName, int signupMemberNumber) {
         /*
         메소드 역할 : 회원등록 2번째 절차이며 주소를 입력받는 메소드
         메소드 기능 : 주소를 입력받을 때 sc.nextLine을 통해 띄어쓰기 까지 받을수 있도록 하였고
         주소입력이 끝남과 동시에 휴대폰번호를 입력 받는 메소드로 이동
         */
        System.out.println("주소를 입력해주세요");
        sc.nextLine();
        String signupMemberAddress = sc.nextLine();

        System.out.println("안내 : 주소가 정상적으로 등록되었습니다");
        memberPhoneFrontNumber(sc, peopleInformation, borrowBookList, signupMemberName, signupMemberNumber, signupMemberAddress);
    }

    static void memberPhoneFrontNumber(Scanner sc, ArrayList<UserRepository> peopleInformation, int[][] borrowBookList, String signupMemberName, int signupMemberNumber, String signupMemberAddress) {
         /*
         메소드 역할 : 회원등록 3번째 절차이며 휴대폰 번호 앞 4자리를 입력받음
         메소드 기능 : 휴대폰 앞 4자리를 입력받는다 4자리로 제한을 두었기 때문에 범위를 1000 ~ 9999로 설정 입력이 끝난대로 이름을 받는 메소드로 이동
          */
        System.out.println("휴대폰 번호 앞 4자리를 입력해주세요 (맨앞 국번 3자리 제외)");
        int phoneFrontNumber = sc.nextInt();

        if (phoneFrontNumber >= 1000 && phoneFrontNumber <= 9999) {
            System.out.println("안내 : 휴대폰 앞 4자리가 등록되었습니다");
            memberPhoneBackNumber(sc, peopleInformation, borrowBookList, signupMemberName, signupMemberNumber, signupMemberAddress, phoneFrontNumber);
        } else {
            System.out.println("안내 : 잘못된 입력입니다");
            memberPhoneFrontNumber(sc, peopleInformation, borrowBookList, signupMemberName, signupMemberNumber, signupMemberAddress);
        }
    }
    public static void memberPhoneBackNumber(Scanner sc, ArrayList<UserRepository> peopleInformation, int[][] borrowBookList, String signupMemberName, int signupMemberNumber, String signupMemberAddress, int signupFrontNumber) {
         /*
         메소드 역할 : 회원등록 마지막 절차이며 휴대폰 뒤 4자리를 입력받고 전체적인 회원정보를 모아 list.add하여 추가
         메소드 기능 : 휴대폰 번호 뒤 4자리를 입력받고 회원등록을 완료시킨다
         1번째 절차부터 파라미터를 넘겨주면서 마지막에 한번에 등록하였다
         등록이 완료되면 saveDeleteMemberIndex전역변수는 초기화 한다
          */
        while (true) {
            System.out.println("휴대폰 번호 뒤 4자리를 입력해주세요 (맨앞 국번 3자리 제외)");
            int phoneBackNumber = sc.nextInt();

            if (phoneBackNumber >= 1000 && phoneBackNumber <= 9999) {
                System.out.println("안내 : 회원등록이 성공적으로 완료되었습니다!!");
                UserRepository success = new UserRepository(signupMemberName, signupMemberNumber, signupMemberAddress, signupFrontNumber, phoneBackNumber, borrowBookList,informationisCheck);
                peopleInformation.add(success);
                break;
            } else {
                System.out.println("안내 : 잘못된 입력입니다");
            }
        }
    }
    public static void findPeopleInformation(Scanner sc, ArrayList<SubBookReposity> Books, ArrayList<UserRepository> peopleInformation) {
         /*
         메소드 역할 : 회원을조회하여 정보를 출력해준다 (번호,이름,주소,전화번호,빌린책목록)
         메소드 기능 : 회원의 이름을 입력하면 for-each문을 돌려 list에 등록되어있는 이름과 일치하는지 확인
         만약 일치하는경우 해당  list내용을 모두출력한다
         그리고 for-each문을 돌려 borrowBookList[][] 2차원 배열을 이용하여 만약에 빌린책이 존재한경우 1을 부여하였기 때문에
         빌린 내역이 존재하면 대여중인 책 이름을 출력
          */
        System.out.println("회원 이름을 적어주세요");
        String findMemberName = sc.next();

        for (UserRepository memberIndex : peopleInformation) { //회원찾기용
            if (Objects.equals(memberIndex.memberName, findMemberName)) { //peopleInformation의 인스턴스에 저장된 이름이 입력한변수와 같은경우
                System.out.println("=============================");
                System.out.println("회원 번호 : " + memberIndex.memberNumber + "번");
                System.out.println("회원 이름 : " + memberIndex.memberName + "");
                System.out.println("회원 주소 : " + memberIndex.memberAddress + "");
                System.out.println("회원 전화번호 : 010 - " + memberIndex.memberPhoneFrontNumber + " - " + memberIndex.memberPhoneBackNumber + "");
                System.out.println("빌린 책 목록 : ");
                informationisCheck = true; //일치하는경우는 존재하는 회원이므로 true로 바꿈

                for (SubBookReposity borrowBookOutput : Books) {
                    //빌린 책을 기록한 2차원배열 : [멤버인덱스넘버][책번호] 가 1인경우 이미 빌린책이므로 책 이름을 출력
                    if (borrowBookList[memberIndex.memberNumber][borrowBookOutput.bookNumber] == 1) {
                        System.out.println("대여중 : " + borrowBookOutput.bookName + ""); //bookName
                        System.out.println("===================");
                    }
                }
            }
        }
        if (!informationisCheck) {
            System.out.println("안내 : 존재하지 않는 회원입니다");
        }
    }
    public static void loadMemberInformation (ArrayList<UserRepository> peopleInformation) {
        for (UserRepository findMember : peopleInformation) {
            System.out.println("===============================================");
            System.out.println("회원 번호 : " + findMember.memberNumber + "번");
            System.out.println("회원 이름 : " + findMember.memberName + "");
            System.out.println("회원 주소 : " + findMember.memberAddress + "");
            System.out.println("회원 전화번호 : 010 - " + findMember.memberPhoneFrontNumber + " - " + findMember.memberPhoneBackNumber + "");
        }
        System.out.println();
    }
    public static void deleteMemberInformation(Scanner sc, ArrayList<UserRepository> peopleInformation) {
         /*
         메소드 역할 : 회원번호 조회 후 회원정보 모두 삭제
         메소드 기능 : for-each문으로 등록되어있는 회원정보가 일치하는지 확인 후 일치하면 list에 등록되어있는 회원정보를 모두 삭제
         즉 list.remove를 사용
          */
        System.out.println("삭제하는 회원 번호를 입력해주세요");
        int memberNumber = sc.nextInt();

        for (UserRepository memberIndex : peopleInformation) {
            if (memberIndex.memberNumber == memberNumber) {
                int listIndex = peopleInformation.indexOf(memberIndex); //고유 list의 index번호를 저장
                System.out.println("안내 : 회원정보가 모두 삭제되었습니다");
                peopleInformation.remove(listIndex);
                informationisCheck = true; //회원을 찾았으므로 true로 바꿈
                break;
            }
        }
        if (!informationisCheck) {
            System.out.println("안내 : 존재하지 않는 회원번호입니다");
        }
    }
}
