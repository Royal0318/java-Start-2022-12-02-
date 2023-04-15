import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class UserRepository {
    public static String memberName;
    //회원의 이름
    public static int[] memberNumber;
    //회원번호
    public static String[] memberAddress;
    //회원주소
    public static int[][] memberPhoneNumber;
    //회원의 휴대폰번호 (앞4자리와 뒤4자리를 받아야 하기 때문에 2차원 배열을 사용 [][0]은 앞4자리를 받으며 [][1]은 뒤4자리를 받는다)
    public static int[][] borrowBookList;
    //회원이 빌린 책을 저장하는 변수 1차원에는 회원의번호가 2차원에는 회원이 빌린 책의 번호가 저장된다

    UserRepository (String[] memberName,int[] memberNumber, String[] memberAddress, int[][] memberPhoneNumber, int[][] borrowBookList) {
        UserRepository.memberName = Arrays.toString(memberName);
        UserRepository.memberNumber = memberNumber;
        UserRepository.memberAddress = memberAddress;
        UserRepository.memberPhoneNumber = memberPhoneNumber;
        UserRepository.borrowBookList = borrowBookList;
    }
    static void memberRegistrationName(Scanner sc, ArrayList<UserRepository> peopleInformation) {
        System.out.println("회원등록 절차를 시작합니다");
        System.out.println("회원의 이름을 적어주세요");
        memberName = sc.next();
        System.out.println("회원 이름이 정상적으로 등록되었습니다");
        memberRegistrationNumber(sc,memberName,peopleInformation);
    }
    static void memberRegistrationNumber (Scanner sc,String memberName,ArrayList<UserRepository> peopleInformation) {
        System.out.println("원하시는 회원번호를 입력해주세요");
        int Number = sc.nextInt();

       for (int i = 0; i < Number;i++) {
           if (UserRepository.memberNumber[i] != Number) {
               System.out.println("회원번호를 정상적으로 등록하였습니다");
               memberRegistrationAddress(sc,memberName,peopleInformation,Number);
           }
       }
        System.out.println("중복되는 회원번호입니다");
    }
    static void memberRegistrationAddress (Scanner sc,String memberName,ArrayList<UserRepository> peopleInformation,int Number) {
        System.out.println("여기부터");
    }
    public static void findPeopleInformation(Scanner sc,ArrayList<UserRepository> peopleInformation) {

    }
}
