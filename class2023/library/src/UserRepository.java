
class UserRepository {
    public static String[] memberName;
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
        UserRepository.memberName = memberName;
        UserRepository.memberNumber = memberNumber;
        UserRepository.memberAddress = memberAddress;
        UserRepository.memberPhoneNumber = memberPhoneNumber;
        UserRepository.borrowBookList = borrowBookList;
    }
    static void memberRegistration() {

    }

    public static void findPeopleInformation() {

    }
}
