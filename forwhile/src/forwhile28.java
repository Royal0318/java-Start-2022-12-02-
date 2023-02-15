import java.util.ArrayList;
import java.util.Scanner;

public class forwhile28 {
    int Totalindex;
    int Chance;
    int Sevencount;
    int Sum;


    forwhile28 (int Totalindex,int Chance,int Sevencount,int Sum) {
        this.Totalindex = Totalindex;
        this.Chance = Chance;
        this.Sevencount = Sevencount;
        this.Sum = Sum;
    }
    void Numberinput (ArrayList<Integer> ar) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Totalindex;i++) {
            System.out.println(""+(i + 1)+"번째 값 입력");
            ar.add(sc.nextInt());
            Sum += ar.get(i);

            if (ar.get(i) == 7) {
                Sevencount += 1;
            }
        }
        if (Sevencount >= 3) {
            Chancethreeup(ar);
        } else {
            Chancethreedown(ar);
        }
    }
    void Chancethreeup (ArrayList<Integer> ar) {
        for (int i = Totalindex; i > 0;i--) {
            System.out.println(""+i+"번째 : "+ar.get(i - 1)+"");
        }
        System.out.println("총 합은 "+Sum+"입니다");
        System.out.println("7은 총 "+Sevencount+"번 나왔습니다");
        System.out.println("중간에 위치한 index 번호는 "+(Totalindex/2)+"번 입니다");
        System.out.println("7의 총 합은 "+(7 * Sevencount)+"입니다");
        System.exit(0);
    }
    void Chancethreedown (ArrayList<Integer> ar) {
        Chance -= 1;
        if (Chance >= 1) {
            System.out.println("7은 총 3번이상 나와야합니다 남은기회 : "+Chance+"회");
            ar.clear(); //Arraylist에 만들어진 값들을 모두 초기화시킨다
            Sevencount = 0; //카운트값 초기화
            Sum = 0; //전체 누적값 초기화
            Numberinput(ar); //다시 메인 입력메소드로 리턴시킴 단 찬스는 리턴시키지 않는다
        } else {
            System.out.println("기회를 모두 사용하였으므로 프로그램이 종료됩니다");
            System.exit(0);
        }
    }
}
