import java.util.*;

public class forwhile25 {
    public static void main(String[] args) {
        int Sevencount = 0;
        int Totalnumber = 0;
        int Totalchance = 5;
        while (true) {
            ArrayList<Integer> test = new ArrayList<>(); //Arraylist선언
            Scanner sc = new Scanner(System.in);
            System.out.println("총 인덱스 개수 입력");
            int Totalindex = sc.nextInt();

            for (int i = 0; i < Totalindex; i++) {
                System.out.println("" + (i + 1) + "번째 값 입력");
                test.add(sc.nextInt());
                Totalnumber += test.get(i); //입력한 값들을 Seventotal로 누적시킴

                if (test.get(i) == 7) { //7을 입력시 카운트 1개 증가
                    Sevencount += 1;
                }
            }
            for (int i = Totalindex; i > 0; i--) {
                System.out.println("" + i + "번째 값 : " + test.get(i - 1) + "");
            }
            if (Sevencount >= 3) {
                System.out.println("입력한 값의 총 합은 : "+Totalnumber+"입니다");
                System.out.println("7은 총 : "+Sevencount+"번 나왔습니다");
                System.out.println("7이 들어있는 index중 중간에 위치한 index는 "+(Totalindex/2)+"번입니다");
                System.out.println("7이 나온 값만큼 더한 숫자는 : "+(7 * Sevencount)+"입니다");
                break;
            } else {
                Totalchance -= 1;
                if (Totalchance >= 1) {
                    System.out.println("7은 최소 3번이상 나와야합니다 남은기회 : " + Totalchance + "회");
                } else {
                    System.out.println("기회를 모두 사용하였으므로 프로그램을 종료합니다");
                    break;
                }
            }
        }
    }
}
