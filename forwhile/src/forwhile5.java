import java.util.Scanner;

public class forwhile5 {
    int Repetition;
    int First;


    forwhile5 (int Repetition,int First) {
        this.Repetition = Repetition;
        this.First = First;
    }
    void Cal (int whilestart) {
        Scanner sc = new Scanner(System.in);
        for (int i = whilestart;i < Repetition;i++) {
            System.out.println(""+(i + 1)+"번째 숫자 입력");
            int Second = sc.nextInt();
            System.out.println(""+First+" + "+Second+" = "+(First + Second)+"");
            First += Second;
            whilestart++;
        }
        System.out.println("목표 횟수에 도달하였으므로 프로그램을 종료합니다");
    }
}
