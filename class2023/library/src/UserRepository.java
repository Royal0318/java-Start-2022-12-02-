import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UserRepository {
    public  String memberName;
    //회원의 이름
    public  int memberNumber;
    //회원번호
    public  String memberAddress;
    //회원주소
    public  int memberPhoneFrontNumber;
    public  int memberPhoneBackNumber;
    //회원의 휴대폰번호 (앞4자리와 뒤4자리를 받아야 하기 때문에 2차원 배열을 사용 [][0]은 앞4자리를 받으며 [][1]은 뒤4자리를 받는다)
    public static int[][] borrowBookList;
    //회원이 빌린 책을 저장하는 변수 1차원에는 회원의번호가 2차원에는 회원이 빌린 책의 번호가 저장된다
    public UserRepository() {
        //예비생성자
    }
    UserRepository(String memberName, int memberNumber, String memberAddress, int memberPhoneFrontNumber, int memberPhoneBackNumber, int[][] borrowBookList) {
        this.memberName = memberName;
        this.memberNumber = memberNumber;
        this.memberAddress = memberAddress;
        this.memberPhoneFrontNumber = memberPhoneFrontNumber;
        this.memberPhoneBackNumber = memberPhoneBackNumber;
        UserRepository.borrowBookList = borrowBookList;
    }

    /*
    현재 문제점 2가지
    1.책을 삭제하고 회원가입으로 넘어가는 문제
    2.빌린책 목록 나오게하는것 구현 (구현완료)
    3.변수명 재수정
    4.위 3가지 고친 후 리테스트
     */
    static void memberRegistrationName(Scanner sc, ArrayList<UserRepository> peopleInformation, int[][] borrowBookList) {
        System.out.println("===========회원등록 절차를 시작합니다===========");
        System.out.println("회원의 이름을 적어주세요");
        String signupMemberName = sc.next();
        System.out.println("안내 : 회원 이름이 정상적으로 등록되었습니다");
        //여기서 책을삭제하고 재등록하면 그자리에 책이 들어갈수있도록 구현한다
        System.out.println("고객님의 회원번호는 " + (peopleInformation.size() + 1) + "번 입니다");
        memberRegistrationAddress(sc, peopleInformation, borrowBookList, signupMemberName, (peopleInformation.size() + 1));
    }
    static void memberRegistrationAddress(Scanner sc,ArrayList<UserRepository> peopleInformation,int[][] borrowBookList,String signupMemberName,int signupMemberNumber) {
        System.out.println("주소를 입력해주세요");
        String signupMemberAddress = sc.nextLine();

        System.out.println("주소가 정상적으로 등록되었습니다");
        memberPhoneFrontNumber(sc, peopleInformation, borrowBookList,signupMemberName,signupMemberNumber,signupMemberAddress);
    }

    static void memberPhoneFrontNumber(Scanner sc, ArrayList<UserRepository> peopleInformation, int[][] borrowBookList,String signupMemberName,int signupMemberNumber,String signupMemberAddress) {
        System.out.println("휴대폰 번호 앞 4자리를 입력해주세요 (맨앞 국번 3자리 제외)");
        int signupFrontNumber = sc.nextInt();

        if (signupFrontNumber >= 1000 && signupFrontNumber <= 9999) {
            System.out.println("휴대폰 앞 4자리가 등록되었습니다");
            memberPhoneBackNumber(sc, peopleInformation, borrowBookList,signupMemberName,signupMemberNumber,signupMemberAddress,signupFrontNumber);
        } else {
            System.out.println("잘못된 입력입니다");
            memberPhoneFrontNumber(sc, peopleInformation, borrowBookList,signupMemberName,signupMemberNumber,signupMemberAddress);
        }
    }


    public static void findPeopleInformation(Scanner sc,ArrayList<SubBookReposity> Books,ArrayList<UserRepository> peopleInformation) {
        boolean check = false;
        System.out.println("회원 이름을 적어주세요");
        sc.nextLine();
        String findMemberName = sc.nextLine();

        for (UserRepository memberIndex : peopleInformation) { //회원찾기용
            if (Objects.equals(memberIndex.memberName, findMemberName)) { //peopleInformation의 인스턴스에 저장된 이름이 입력한변수와 같은경우
                check = true;
                System.out.println("=============================");
                System.out.println("회원 번호 : " + memberIndex.memberNumber + "번");
                System.out.println("회원 이름 : " + memberIndex.memberName + "");
                System.out.println("회원 주소 : " + memberIndex.memberAddress + "");
                System.out.println("회원 전화번호 : 010 - " + memberIndex.memberPhoneFrontNumber + " - " + memberIndex.memberPhoneBackNumber + "");
                System.out.println("빌린 책 목록 : ");

                for (SubBookReposity borrowBookOutput : Books) {
                    //빌린 책을 기록한 2차원배열 : [멤버인덱스넘버][책번호] 가 1인경우 빌린흔적이므로 그 index 책네임출력
                    if (borrowBookList[memberIndex.memberNumber][borrowBookOutput.bookNumber] == 1) {
                        System.out.println("대여중 : " + borrowBookOutput.bookName + ""); //bookName
                        System.out.println("================");
                    }
                }
            }
        }
        if (!check) {
            System.out.println("존재하지 않는 회원입니다");
        }
    }
    static void memberPhoneBackNumber(Scanner sc, ArrayList<UserRepository> peopleInformation,int[][] borrowBookList,String signupMemberName,int signupMemberNumber,String signupMemberAddress,int signupFrontNumber) {
        while (true) {
            System.out.println("휴대폰 번호 뒤 4자리를 입력해주세요 (맨앞 국번 3자리 제외)");
            int signupBackNumber = sc.nextInt();

            if (signupBackNumber >= 1000 && signupBackNumber <= 9999) {
                System.out.println("회원등록이 성공적으로 완료되었습니다!!");
                UserRepository success = new UserRepository(signupMemberName, signupMemberNumber, signupMemberAddress, signupFrontNumber, signupBackNumber, borrowBookList);
                peopleInformation.add(success);
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
}
