import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class forwhile30 {
    int Sum;
    int Sevencount;
    int Totalindex;
    int Chance;
    List<Integer> numbertest;
    forwhile30 (int Sum,int Sevencount,int Totalindex,int Chance,List<Integer> numbertest) {
        this.Sum = Sum;
        this.Sevencount = Sevencount;
        this.Totalindex = Totalindex;
        this.Chance = Chance;
        this.numbertest = numbertest;
    }
    void Numberinput () {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Totalindex;i++) {
            System.out.println(""+(i + 1)+"번째 번호를 적어주세요");
            numbertest.add(sc.nextInt());
            Sum += numbertest.get(i);

            if (numbertest.get(i) == 7) {
                Sevencount += 1;
            }
        }
        if (Sevencount >= 3) {
            Numberreverse();
        } else {
            Retry();
        }
    }
    void Numberreverse () {
        Collections.reverse(numbertest);
        System.out.println(numbertest); //거꾸로 출력
        System.out.println("총 나온값의 합은 "+Sum+"입니다");
        System.out.println("7은 총 "+Sevencount+"번 나왔습니다");
        System.out.println("7의 합은 총 "+(7 * Sevencount)+"입니다");
        System.out.println("중간의 위치한 인덱스 번호는 "+(Totalindex/2)+"번입니다");
        System.exit(0);
    }
    void Retry () {
        Chance -= 1;
        if (Chance >= 1) {
            System.out.println("7은 최소 3번이상 나와야합니다 남은 기회 : "+Chance+"회");
            Sum = 0;
            Sevencount = 0;
            numbertest.clear();
            Numberinput();
        } else {
            System.out.println("기회를 모두 사용하였으므로 프로그램을 종료합니다");
            System.exit(0);
        }
    }
}
