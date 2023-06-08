import java.util.Scanner;

public class MyInformation {
    private String name;
    private String address;
    private int password;
    private int old;
    private String family;

    public void setName (String name) { //이름받고
        this.name = name;
    }
    private String getName () { //이름넘겨주고
        return name;
    }
    public void setAddress (String address) { //주소받고
        this.address = address;
    }
    public String getAddress () { //주소넘겨주고
        return address;
    }
    public void setPassword (int password) { //비번받고
        this.password = password;
    }
    public int getPassword() { //비번넘겨주고
        return password;
    }
    public void setOld (int old) {
        this.old = old;
    }
    public int getOld () {
        return old;
    }
    public void setFamily (String family) {
        this.family = family;
    }
    public String getFamily () {
        return family;
    }
    public void test (Scanner sc) {
        System.out.println("이름 : "+getName()+"");
        System.out.println("주소 :  "+getAddress()+"");
        System.out.println("나이 : "+getOld()+"살");
        System.out.println("비밀번호 : "+getPassword()+"");

        inputFamily(sc);
    }
    public void inputFamily (Scanner sc) { //가족구성원은 입력으로받음
        System.out.println("가족 구성원입력");

        setFamily(sc.next()); //set에 입력받아서 저장하여

        System.out.println("가족 : "+getFamily()+""); //불러온다
    }
}
