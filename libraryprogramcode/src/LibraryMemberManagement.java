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
    public  void memberNumbering (HashMap<LibraryBookManagement, Integer> bookList, HashMap<LibraryMemberManagement, Integer> memberList) {

    }
}
