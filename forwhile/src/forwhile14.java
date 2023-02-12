import java.util.Scanner;

public class forwhile14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] Scorearr = new int[4];
        String[] Namearr = new String[4];

        for (int i = 0;i < 4;i++) {
            System.out.println(""+(i + 1)+"번째 이름을 입력해주세요");
            Namearr[i] = sc.next();
        }
        for (int i = 0;i < 4;i++) {
            System.out.println(""+Namearr[i]+"의 점수를 입력해주세요");
            Scorearr[i] = sc.nextInt();
        }
        System.out.println("1."+Namearr[0]+"점수 : "+Scorearr[0]+" \n2."+Namearr[1]+"점수 : "+Scorearr[1]+"\n3."+Namearr[2]+"점수 : "+Scorearr[2]+"\n4."+Namearr[3]+"점수 : "+Scorearr[3]+"\n");
        while (true) {
            System.out.println("1."+Namearr[0]+"\n2."+Namearr[1]+"\n3."+Namearr[2]+"\n4."+Namearr[3]+"\n5.시스템 종료");
            int Peopleselect = sc.nextInt() - 1;
            int Peopleselect2 = sc.nextInt() - 1;
            //메뉴번호와 index번호를 일치시키기위함

            if (Peopleselect < 1 || Peopleselect > 4 || Peopleselect2 < 1 || Peopleselect2 > 4) {
                System.out.println("잘못된 입력입니다");
            } else {
                if (Peopleselect == 4 && Peopleselect2 == 4) {
                    System.out.println("시스템을 종료합니다");
                    break;
                }
                Scorearr[Peopleselect] = Peopleselect;
                Scorearr[Peopleselect2] = Peopleselect2;

                if (Peopleselect == Peopleselect2) {
                    System.out.println("같은 번호를 입력할 수 없습니다");
                }
                if (Scorearr[Peopleselect] > Scorearr[Peopleselect2]) {
                    System.out.println("" + Namearr[Peopleselect] + "의 점수가 " + Namearr[Peopleselect2] + "보다 더 큽니다!");
                } else if (Scorearr[Peopleselect] < Scorearr[Peopleselect2]) {
                    System.out.println("" + Namearr[Peopleselect2] + "의 점수가 " + Namearr[Peopleselect] + "보다 더 큽니다!");
                }
            }
        }
    }
}
