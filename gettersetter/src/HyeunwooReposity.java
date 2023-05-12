import java.util.Scanner;

public class HyeunwooReposity {
    private String name;
    private int old;
    private String address;
    private String phoneNumber;
    private String hobby;
    private String sex;
    private String born;
    private String jop;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getJop() {
        return jop;
    }

    public void setJop(String jop) {
        this.jop = jop;
    }
    void inputName (Scanner sc) {
        System.out.println("이름을 적어주세요");
        setName(sc.nextLine());
    }
    void inputOld (Scanner sc) {
        System.out.println("나이을 적어주세요");
        setOld(sc.nextInt());
    }
    void inputAddress (Scanner sc) {
        System.out.println("주소를 적어주세요");
        sc.nextLine();
        setAddress(sc.nextLine());
    }
    void inputPhoneNumber (Scanner sc) {
        System.out.println("휴대폰 번호를 적어주세요 (-포함)");
        setPhoneNumber(sc.next());
    }
    void inputHobby (Scanner sc) {
        System.out.println("취미를 적어주세요 (여러개를 나열하셔도 좋습니다)");
        sc.nextLine();
        setHobby(sc.nextLine());
    }
    void inputSex (Scanner sc) {
        System.out.println("성별을 적어주세요");
        setSex(sc.next());
    }
    void inputBorn (Scanner sc) {
        System.out.println("태어난 곳을 적어주세요");
        sc.nextLine();
        setBorn(sc.nextLine());
    }
    void inputJop (Scanner sc) {
        System.out.println("직업을 적어주세요");
        setJop(sc.next());
    }
    void outputInformation () {
        System.out.println("============="+getName()+"의 인생정보=============");
        System.out.println("이름 : "+getName()+"");
        System.out.println("나이 : "+getOld()+"");
        System.out.println("성별 : "+getSex()+"");
        System.out.println("주소 : "+getAddress()+"");
        System.out.println("휴대폰 번호 "+getPhoneNumber()+"");
        System.out.println("취미 : "+getHobby()+"");
        System.out.println("태어난 곳 : "+getBorn()+"");
        System.out.println("직업 : "+getJop()+"");
        System.out.println("===============이상 끝===============");
    }
}
