import java.util.Scanner;
/*
1.Phone이라는 프로젝트를 생성하고 mobilePhone이라는 이름의 인터페이스를 만든다
2.인터페이스 모바일 폰은 껏다켯다가 가능합니다 그래서 추상메소드로 on,off를 만든다
3.휴대푠이 켜지고 텍스트를 입력받아 입력후 화면에 출력을 하고 종료
4.만약에 입력을 하지않고 30초가 지났을경우 프로그램 종료
5.인터페이스에 static상수로 Timeout을 만들고 30초에 맞출것
6.텍스트를 입력받아 화면을 출력할 수 있는 추상메소드 display도 만들것
 */
public class phoneMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mobilePhone phone = new Phone();

        phone.on();
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
