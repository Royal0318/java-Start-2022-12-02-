import java.util.HashMap;
import java.util.Objects;

public class LibraryMemberManagement implements Member_Management_Interface {
    private String memberName; //회원이름
    private String memberAddress; //회원주소
    private String memberPhoneNumber; //회원 휴대폰번호
    private String memberRegistrationDate; //회원가입일자
    private String deleteMember; //멤버삭제


    private boolean memberCheck; //회원 찾기 유무


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
    public boolean isMemberCheck() {
        return memberCheck;
    }

    public void setMemberCheck(boolean memberCheck) {
        this.memberCheck = memberCheck;
    }
    public String getDeleteMember() {
        return deleteMember;
    }

    public void setDeleteMember(String deleteMember) {
        this.deleteMember = deleteMember;
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
    public void findMemberInformation (HashMap<LibraryMemberManagement, Integer> memberList) { //멤버 찾기
        System.out.println("찾는 회원의 휴대폰 번호를 적어주세요");
        setMemberPhoneNumber(sc.next());

        for (LibraryMemberManagement output : memberList.keySet()) {
            if (Objects.equals(getMemberPhoneNumber(), output.memberPhoneNumber)) {
                System.out.println("이름 : "+output.memberName+"");
                System.out.println("주소 : "+output.memberAddress+"");
                System.out.println("휴대폰 번호 : "+output.memberPhoneNumber+"");
                System.out.println("가입일 : "+output.memberRegistrationDate+"");
            }
            setMemberCheck(true);
            break;
        }
        if (!isMemberCheck()) {
            System.out.println("존재하지 않는 회원정보입니다");
            setMemberCheck(false); //재초기화
        }
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
                LibraryMemberManagement memberRegistration = new LibraryMemberManagement("" + getMemberName() + "", "" + getMemberAddress() + "", "" + getMemberPhoneNumber() + "", "" + getMemberRegistrationDate() + "");
                memberList.put(memberRegistration, memberList.size() + 1); //멤버추가하면서 value 값 = 지금까지등록된 회원 index size + 1
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }
    }

    @Override
    public void deleteMemberInformation(HashMap<LibraryMemberManagement, Integer> memberList) { //멤버삭제 method
        System.out.println("삭제를 원하는 회원의 휴대폰 번호를 입력해주세요");
        setDeleteMember(sc.next());

        for (LibraryMemberManagement output : memberList.keySet()) {
            if (Objects.equals(getDeleteMember(), output.memberPhoneNumber)) {
                System.out.println("이름 : "+output.memberName+"");
                System.out.println("주소 : "+output.memberAddress+"");
                System.out.println("휴대폰 번호 : "+output.memberPhoneNumber+"");
                System.out.println("가입일 : "+output.memberRegistrationDate+"");
            }
            setMemberCheck(true);
            deleteInformationRecheck(output,memberList);
            break;
        }
        if (!isMemberCheck()) { //입력한 회원 존재시
            System.out.println("존재하지 않는 회원정보입니다");
            setMemberCheck(false); //재초기화
        }
    }
    public void deleteInformationRecheck (LibraryMemberManagement memberIndex,HashMap<LibraryMemberManagement, Integer> memberList) {
        while (true) {
            System.out.println("정말로 정보를 삭제하시겠습니까? 1.네 2.아니오 \n안내 : 정보를 삭제하면 복구가 불가능합니다");
            int deleteCheck = sc.nextInt();

            if (deleteCheck == 1) {
                System.out.println("회원이 정상적으로 삭제되었습니다");
                memberList.remove(memberIndex);
                break;
            } else if (deleteCheck == 2) {
                System.out.println("메인메뉴로 돌아갑니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시 시도해주세요");
            }
        }
    }
}
