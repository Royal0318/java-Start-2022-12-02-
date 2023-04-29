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
    public static int saveDeleteMemberIndex;

    public static boolean checkTemp;

    public UserRepository() {
        //예비생성자
    }

    UserRepository(String memberName, int memberNumber, String memberAddress, int memberPhoneFrontNumber, int memberPhoneBackNumber, int[][] borrowBookList, int saveDeleteMemberIndex, boolean checkTemp) {
        this.memberName = memberName;
        this.memberNumber = memberNumber;
        this.memberAddress = memberAddress;
        this.memberPhoneFrontNumber = memberPhoneFrontNumber;
        this.memberPhoneBackNumber = memberPhoneBackNumber;
        UserRepository.checkTemp = checkTemp;
        UserRepository.saveDeleteMemberIndex = saveDeleteMemberIndex;
        UserRepository.borrowBookList = borrowBookList;
    }
    /*
    4월 30일 해결할것
    1.책을 삭제하고 회원가입으로 넘어가는 문제 (swich문을 if문으로 변경했을때 해당 문제가 사라짐 왜그러지?)
    원인을 알아보자
    2.변수명이나 메소드명 재검사
    3.전체적인 테스트
     */
    static void memberRegistrationName(Scanner sc, ArrayList<UserRepository> peopleInformation, int[][] borrowBookList) {
        System.out.println("===========회원등록 절차를 시작합니다===========");
        if (saveDeleteMemberIndex != 0) {
            System.out.println("새로운 회원번호는 " + saveDeleteMemberIndex + "번 입니다");
        } else {
            saveDeleteMemberIndex = (peopleInformation.size() + 1);
            System.out.println("새로운 회원번호는 " + saveDeleteMemberIndex + "번 입니다");
        }
        System.out.println("회원의 이름을 적어주세요");
        String signupMemberName = sc.next();
        System.out.println("안내 : 회원 이름이 정상적으로 등록되었습니다");
        memberRegistrationAddress(sc, peopleInformation, borrowBookList, signupMemberName, saveDeleteMemberIndex);
    }

    static void memberRegistrationAddress(Scanner sc, ArrayList<UserRepository> peopleInformation, int[][] borrowBookList, String signupMemberName, int signupMemberNumber) {
        System.out.println("주소를 입력해주세요");
        sc.nextLine();
        String signupMemberAddress = sc.nextLine();

        System.out.println("안내 : 주소가 정상적으로 등록되었습니다");
        memberPhoneFrontNumber(sc, peopleInformation, borrowBookList, signupMemberName, signupMemberNumber, signupMemberAddress);
    }

    static void memberPhoneFrontNumber(Scanner sc, ArrayList<UserRepository> peopleInformation, int[][] borrowBookList, String signupMemberName, int signupMemberNumber, String signupMemberAddress) {
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


    public static void findPeopleInformation(Scanner sc, ArrayList<SubBookReposity> Books, ArrayList<UserRepository> peopleInformation) {
        System.out.println("회원 이름을 적어주세요");
        String findMemberName = sc.next();

        for (UserRepository memberIndex : peopleInformation) { //회원찾기용
            if (Objects.equals(memberIndex.memberName, findMemberName)) { //peopleInformation의 인스턴스에 저장된 이름이 입력한변수와 같은경우
                checkTemp = true;
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
        if (!checkTemp) {
            System.out.println("안내 : 존재하지 않는 회원입니다");
        }
    }

    public static void memberPhoneBackNumber(Scanner sc, ArrayList<UserRepository> peopleInformation, int[][] borrowBookList, String signupMemberName, int signupMemberNumber, String signupMemberAddress, int signupFrontNumber) {
        while (true) {
            System.out.println("휴대폰 번호 뒤 4자리를 입력해주세요 (맨앞 국번 3자리 제외)");
            int phoneBackNumber = sc.nextInt();

            if (phoneBackNumber >= 1000 && phoneBackNumber <= 9999) {
                System.out.println("안내 : 회원등록이 성공적으로 완료되었습니다!!");
                UserRepository success = new UserRepository(signupMemberName, signupMemberNumber, signupMemberAddress, signupFrontNumber, phoneBackNumber, borrowBookList, saveDeleteMemberIndex, checkTemp);
                peopleInformation.add(success);
                saveDeleteMemberIndex = 0;
                break;
            } else {
                System.out.println("안내 : 잘못된 입력입니다");
            }
        }
    }

    public static void deleteMemberInformation(Scanner sc, ArrayList<UserRepository> peopleInformation) {
        System.out.println("삭제하는 회원 번호를 입력해주세요");
        int memberNumber = sc.nextInt();

        for (UserRepository memberIndex : peopleInformation) {
            if (memberIndex.memberNumber == memberNumber) {
                System.out.println("안내 : 회원정보가 모두 삭제되었습니다");
                saveDeleteMemberIndex = memberNumber;
                peopleInformation.remove((memberNumber - 1));
                checkTemp = true;
                break;
            }
        }
        if (!checkTemp) {
            System.out.println("안내 : 존재하지 않는 회원번호입니다");
        }
    }
}
