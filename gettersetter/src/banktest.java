import java.util.ArrayList;
import java.util.Scanner;

public class banktest {
    private String name; //이름
    private int order; //순서
    private int time; //소요시간
    private String purpose; //목적
    private String phoneNumber; //폰넘버

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    void inputInformation (ArrayList<banktest> people, Scanner sc) {
        System.out.println("10명의 이름,순서,소요시간,목적,휴대폰 번호('-'제외)를 입력해주세요");
        for (int i = 0; i < 10;i++) {
            banktest informationAdd = new banktest();
            informationAdd.setName(sc.next());
            informationAdd.setOrder(sc.nextInt());
            informationAdd.setTime(sc.nextInt());
            informationAdd.setPurpose(sc.next());
            informationAdd.setPhoneNumber(sc.next());
            people.add(informationAdd); //전체저장
        }
    }
    void outputOrder (ArrayList<banktest> people) {
        for (int i = 1; i <= 10;i++) {
            for (banktest order : people) {
                if (order.getOrder() == i) {
                    System.out.printf(""+order.getName()+" ");
                }
            }
        }
    }
}
