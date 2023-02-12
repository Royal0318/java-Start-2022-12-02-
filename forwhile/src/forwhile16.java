import java.util.Scanner;

public class forwhile16 {
    int[] Scorearr;
    String[] Namearr;

    forwhile16 (int[] Scorearr,String[] Namearr) {
        this.Scorearr = Scorearr;
        this.Namearr = Namearr;
    }
    void Peoplename () {
        Scanner sc = new Scanner(System.in);
        for (int i = 0;i < 4;i++) {
            System.out.println(""+(i + 1)+"번째 이름을 정해주세요");
            Namearr[i] = sc.next();
        }
    }
    void Peoplescore () {
        Scanner sc = new Scanner(System.in);
        for (int i = 0;i < 4;i++) {
            System.out.println(""+Namearr[i]+"의 점수를 정해주세요");
            Scorearr[i] = sc.nextInt();
        }
    }
    void Peopleselectmenu () {
        Scanner sc = new Scanner(System.in);
        System.out.println("1."+Namearr[0]+"점수 : "+Scorearr[0]+"\n2."+Namearr[1]+"점수 : "+Scorearr[1]+"\n3."+Namearr[2]+"점수 : "+Scorearr[2]+"\n4."+Namearr[3]+"점수 : "+Scorearr[3]+"\n");

       while (true) {
            System.out.println("1." + Namearr[0] + "\n2." + Namearr[1] + "\n3." + Namearr[2] + "\n4." + Namearr[3] + "\n5.시스템종료\n비교를 원하는 번호를 각각 입력해주세요");
            int comparison = sc.nextInt() - 1;
            int comparison2 = sc.nextInt() - 1;

            if (comparison < 0 || comparison > 4 || comparison2 < 0 || comparison2 > 4) {
                System.out.println("잘못된 번호입니다");
            } else {
                if (comparison == 4 && comparison2 == 4) {
                    System.out.println("프로그램을 종료합니다");
                    break;
                }
                if (Scorearr[comparison] < Scorearr[comparison2]) {
                    System.out.println("" + Namearr[comparison2] + "의 점수가 " + Namearr[comparison] + "보다 더 큽니다!");
                } else if (Scorearr[comparison] > Scorearr[comparison2]) {
                    System.out.println("" + Namearr[comparison] + "의 점수가 " + Namearr[comparison2] + "보다 더 큽니다!");
                } else {
                    System.out.println("두 점수가 같습니다");
                }
            }
        }
    }
}
