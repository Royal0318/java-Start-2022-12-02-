import java.util.Scanner;

public class phoneMain { //컨트롤러
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mobilePhone phone = new Phone();

        phone.on(); //처음 휴대폰 켜짐
        while (true) {
            System.out.println("1.휴대폰종료 2.텍스트 입력");

            int choice = sc.nextInt();

            if (choice == 1) {
                phone.off();
                break;
            } else if (choice == 2) {
                phone.display();
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }
    }
}
