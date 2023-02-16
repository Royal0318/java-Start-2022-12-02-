import java.util.ArrayList;
import java.util.Scanner;
public class forwhile35 {
    int Totalindex;
    int Startsum;
    int Lastsum;

    forwhile35(int Totalindex, int Startsum,int Lastsum) {
        this.Totalindex = Totalindex;
        this.Startsum = Startsum;
        this.Lastsum = Lastsum;
    }

    void Numberinput(ArrayList<Integer> arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Totalindex; i++) {
            System.out.println("" + (i + 1) + "번째 손님의 돈을 입력");
            arr.add(sc.nextInt());
            Startsum += arr.get(i);
        }
        Peopleselect(arr);
    }

    void Peopleselect(ArrayList<Integer> arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Totalindex; i++) {
            System.out.println("" + (i + 1) + "번째 손님이 가지고 있는 금액 " + arr.get(i) + "원");
        }

        System.out.println("몇번째 손님의 돈을 빼겠습니까? \n안내 : 시스템 종료를 원하시면 손님과 빼는돈을 모두 0을 입력해주세요");
        int Choice = sc.nextInt();

        if (Choice > Totalindex) {
            System.out.println("잘못된 입력입니다");
            Peopleselect(arr);
        } else {
            System.out.println("얼마를 빼겠습니까?");
            int Moneytake = sc.nextInt();

            if (Choice == 0 && Moneytake == 0) {
                Systemsutting();
            }
            arr.set((Choice - 1), arr.get((Choice - 1)) - Moneytake);

            if (arr.get(Choice - 1) == 0 || arr.get(Choice - 1) > 0) {
                //계산 후 해당 index에서 가지고 있는 값이 0보다 크거나 아니면 0이 될때 리턴시킴
                Lastsum += Moneytake;
                Resultvalue(arr, (Choice - 1));
            } else if (arr.get(Choice - 1) < 0) {
                System.out.println("가지고 있는 돈보다 많이 뺄 수 없습니다");
                arr.set((Choice - 1), arr.get((Choice - 1)) + Moneytake);
            }
        }
    }

    void Resultvalue(ArrayList<Integer> arr, int Choice) {
        if (arr.get(Choice) == 0) {
            arr.remove(Choice);
            Totalindex--;
        }
        Peopleselect(arr);
    }

    void Systemsutting() {
        System.out.println("남은 손님들이 가지고있는 돈의 총 합은 " + (Startsum - Lastsum) + "원 입니다");
        System.out.println("처음과 마지막의 차액은 " + (Startsum - Lastsum) + "원 입니다");
        System.out.println("마지막까지 남은 손님은 총 " + Totalindex + "명 입니다");
        System.out.println("처음에 가지고 있던 돈은 총 " + Startsum + "원입니다");
        System.exit(0);
    }
}
