import java.util.Scanner;
public class InputOutput9 {
    int First;
    int Second;

    InputOutput9 (int First,int Second) {
        this.First = First;
        this.Second = Second;
    }
    void Plus () {
        Scanner sc = new Scanner(System.in);
        System.out.println(""+First+" + "+Second+" = ?");
        int Answer = sc.nextInt();
        Round1(Answer);
    }
    void Round1 (int Answer) {
        if (Answer == (First + Second)) {
            Round2();
            //정답일시 Round2로 이동
        } else {
            System.out.println("오답입니다! 정답은 : "+(First + Second)+"입니다!");
        }
    }
    void Round2 () {
        Scanner sc = new Scanner(System.in);
        System.out.println("1."+First+" 2."+Second+" 어느쪽이 더 큰수 입니까?");
        int Round2choice = sc.nextInt();

        if (First != Second) {
            if (Round2choice == 1 && First < Second) {
                System.out.println("오답입니다 정답은 " + Second + "입니다");
            } else if (Round2choice == 1) {
                System.out.println("정답입니다");
            } else if (Round2choice == 2 && First < Second) {
                System.out.println("정답입니다");
            } else {
                System.out.println("오답입니다 정답은 " + First + "입니다");
            }
        } else {
            System.out.println("두 수는같습니다");
        }
    }
}
