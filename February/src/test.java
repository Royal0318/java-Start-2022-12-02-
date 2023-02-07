import java.util.ArrayList;
import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("<<<도서관 시스템>>>\n1.전체 책 조회 \n2.빌린사람 조회 \n3.시스템종료");
            int BookChoice = sc.nextInt();

            if (BookChoice == 1) {
                test2 People = new test2("0001", "트렌드 코리아 2023", "김난도", "미래의창", "2022년 11월 28일", "O", "최민재\n");
                test2 People2 = new test2("0002", "만일 내가 인생을 다시 산다면", "김혜남", "메이븐", "2022년 11월 11일", "O", "김민혁\n");
                test2 People3 = new test2("0003", "불편한 편의점", "김호연", "나무옆의자", "2021년 4월 20일", "O", "김현우,이다연\n");
                test2 People4 = new test2("0004", "오늘 밤, 세계에서 이 사랑이 사라진다 해도", "이치조미사키,모모", "일본", "2021년 6월 28일", "O", "강민혁\n");
                test2 People5 = new test2("0005", "흔한남매 12", "흔한남매", "미래엔아이세움", "2022년 7월 2일", "X", "없음\n");

                ArrayList<test2> ArrayOutput = new ArrayList<>();

                ArrayOutput.add(People);
                ArrayOutput.add(People2);
                ArrayOutput.add(People3);
                ArrayOutput.add(People4);
                ArrayOutput.add(People5);

                for (test2 arr : ArrayOutput) {
                    arr.Information();
                }
            } else if (BookChoice == 2) {
                test2.test3 Peopleinformation = new test2.test3("최민재","10648-25","1996년 5월 21일","경기도 수원시","010-5526-3125","트렌드 코리아 2023","1\n");
                test2.test3 Peopleinformation2 = new test2.test3("김민혁","10758-65","2000년 3월 2일","서울시 서초구","010-2011-7885","만일 내가 인생을 다시 산다면","1\n");
                test2.test3 Peopleinformation3 = new test2.test3("김현우","11586-95","1999년 11월 22일","경기도 광주시","010-4984-3158","불편한 편의점","3\n");
                test2.test3 Peopleinformation4 = new test2.test3("이다연","10025-45","2001년 7월1일","서울시 동대문구","010-7588-1056","불편한 편의점","2\n");
                test2.test3 Peopleinformation5 = new test2.test3("강민혁","10052-22","1995년 8월 2일","서울시 노원구","010-7325-0019","오늘 밤, 세계에서 이 사랑이 사라진다 해도","1\n");

                ArrayList<test2.test3> ArrayOutput2 = new ArrayList<>();
                ArrayOutput2.add(Peopleinformation);
                ArrayOutput2.add(Peopleinformation2);
                ArrayOutput2.add(Peopleinformation3);
                ArrayOutput2.add(Peopleinformation4);
                ArrayOutput2.add(Peopleinformation5);

                for (test2.test3 arr2 : ArrayOutput2) {
                    arr2.PersonalInformation();
                }
            } else if (BookChoice == 3) {
                System.out.println("시스템을 종료합니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
}
