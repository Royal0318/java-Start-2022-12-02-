import java.util.HashMap;

public class LibraryMemberManagement implements Member_Management_Interface {
    private String memberName; //회원이름
    private String memberAddress; //회원주소
    private String memberPhoneNumber; //회원 휴대폰번호
    private String memberRegistrationDate; //회원가입일자

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberPhoneNumber() {
        return memberPhoneNumber;
    }

    public void setMemberPhoneNumber(String memberPhoneNumber) {
        this.memberPhoneNumber = memberPhoneNumber;
    }

    public String getMemberRegistrationDate() {
        return memberRegistrationDate;
    }

    public void setMemberRegistrationDate(String memberRegistrationDate) {
        this.memberRegistrationDate = memberRegistrationDate;
    }
    public LibraryMemberManagement () { //보조생성자 생성

    }
    public LibraryMemberManagement (String memberName, String memberAddress, String memberPhoneNumber, String memberRegistrationDate) { //생성자 생성
        this.memberName = memberName;
        this.memberAddress = memberAddress;
        this.memberPhoneNumber = memberPhoneNumber;
        this.memberRegistrationDate = memberRegistrationDate;
    }
    @Override
    public void memberNumbering (HashMap<LibraryMemberManagement, Integer> memberList) {
        System.out.println("회원 등록을 시작합니다 새로 부여된 회원번호는 "+memberList.size()+"번 입니다 ");
        inputMemberName();
    }
    public void inputMemberName () {
        System.out.println("등록 할 회원의 이름을 적어주세요");
        setMemberName(sc.next());
        System.out.println("\n안내 : 회원 이름이 정상적으로 등록되었습니다\n");
        inputMemberAddress();
    }
    public void inputMemberAddress () {
        System.out.println("등록 할 회원의 주소를 적어주세요");
        setMemberAddress(sc.next());
        System.out.println("\n안내 : 회원 주소가 정상적으로 등록되었습니다\n");
        inputMemberPhoneNumber();
    }
    public void inputMemberPhoneNumber () {
        while (true) {
            System.out.println("등록 할 회원의 휴대폰 번호를 적어주세요 (주의사항 : '-'포함 13자를 입력)");
            setMemberPhoneNumber(sc.next());

            int numberCheck = getMemberPhoneNumber().length();

            if (numberCheck == 13) {
                System.out.println("\n안내 : 회원 주소가 정상적으로 등록되었습니다\n");
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }
    }
    @Override
    public void memberRegistrationDate(HashMap<LibraryMemberManagement, Integer> memberList) {
        while (true) {
            System.out.println("회원 가입일자를 공백을 포함하여 적어주세요 (예 : 2023년 1월 1일)");

            setMemberRegistrationDate(sc.next());

            int daysCheck = getMemberRegistrationDate().length();

            if (daysCheck == 10) {
                System.out.println("\n안내 : 회원등록이 모두 정상적으로 완료되었습니다\n");
                LibraryMemberManagement memberRegistration = new LibraryMemberManagement(""+getMemberName()+"",""+getMemberAddress()+"",""+getMemberPhoneNumber()+"",""+getMemberRegistrationDate()+"");
                memberList.put(memberRegistration, memberList.size() + 1); //멤버추가하면서 value 값 = 지금까지등록된 회원 index size + 1
                break;
            }
            else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }
    }
}
