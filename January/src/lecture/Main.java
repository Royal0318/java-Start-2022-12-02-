package lecture;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("도현우씨가 가고싶은 기업은 어디입니까? \n1.대기업 \n2.중견기업 \n3.중소기업");
        int Select = sc.nextInt();

        if (Select == 1) {
            Person HyeonWoo = new Person("도현우","27살","173cm","72Kg","총 4명","남성","무직","웹 개발자","경기광주","서울 송파구","고등학교 졸업","대기업");
            HyeonWoo.introduceMySelf(); //현우의 자기소개프로필를 불러온다
            HyeonWoo.Fighting(); //
        } else if (Select == 2) {
            Person HyeonWoo = new Person("도현우","27살","173cm","72Kg","총 4명","남성","무직","웹 개발자","경기광주","서울 송파구","고등학교 졸업","중견기업");
            HyeonWoo.introduceMySelf();
            HyeonWoo.Fighting();
        } else if (Select == 3) {
            Person HyeonWoo = new Person("도현우","27살","173cm","72Kg","총 4명","남성","무직","웹 개발자","경기광주","서울 송파구","고등학교 졸업","중소기업");
            HyeonWoo.introduceMySelf();
            HyeonWoo.Fighting();
        } else {
            System.out.println("안내 : 잘못된 입력");
        }
    }
}
