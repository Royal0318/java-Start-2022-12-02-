import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class forwhile26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int Chance = 5;
        int Sevencount = 0;
            while (true) {
            List<Integer> test = new ArrayList<>(); //List선언
            System.out.println("총 인덱스 생성개수");
            int Totalindex = sc.nextInt();

            for (int i = 0; i < Totalindex; i++) {
                System.out.println(""+(i + 1)+"번째 값 입력");
                test.add(sc.nextInt()); //Arraylist처럼 add에 저장
                sum += test.get(i);

                if (test.get(i) == 7) {
                    Sevencount += 1;
                }
            }
            if (Sevencount >= 3) {
                Collections.reverse(test); //값을 뒤짚음
                System.out.println(test); //전체값 출력
                System.out.println("총입력 값은 : "+sum+"입니다");
                System.out.println("7은 총 "+Sevencount+"개가 나왔습니다");
                System.out.println("7의 총 합은 : "+(7 * Sevencount)+"입니다");
                System.out.println("중간에 위치한 index는 : "+(Totalindex/2)+"번 입니다");
                break;
            } else {
                Chance -= 1;
                if (Chance >= 1) {
                    System.out.println("7은 최소 3번이상 나와야합니다 남은기회 : "+Chance+"회");
                } else {
                    System.out.println("기회를 모두 사용하였으므로 프로그램을 종료합니다");
                    break;
                }
            }
        }
    }
}
