import java.util.ArrayList;
import java.util.Scanner;

public class forwhile32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Firstmoney = 0;
        int Finishmoney = 0;
        ArrayList<Integer> TotalIndex = new ArrayList<>();
        System.out.println("총 생성 인덱스 번호를 적어주세요");
        int People = sc.nextInt();

        for (int i = 0; i < People; i++) {
            System.out.println("" + (i + 1) + "번째 사람의 돈을 입력해주세요");
            TotalIndex.add(sc.nextInt()); //입력하는대로 인덱스 자동추가 및 가격 누적
        }
            for (int i = 0; i < People; i++) {
                System.out.println("" + (i + 1) + "번째  손님이 가진 금액 : " + TotalIndex.get(i) + "원");
                Firstmoney += TotalIndex.get(i);
                Finishmoney += TotalIndex.get(i);
            }

        for (int j = 0; j <= People; j++) {
            System.out.println("몇번째 손님의 돈을 빼겠습니까?");
            int Peoplechoice = sc.nextInt() - 1;
            System.out.println("빼고싶은 돈의 가격을 적어주세요");
            int Moneytake = sc.nextInt();
            Finishmoney -= Moneytake;
            //해당 값 계산
            TotalIndex.set(Peoplechoice, TotalIndex.get(Peoplechoice) - Moneytake);//해당 인덱스의 값을 빼기위한절차
            //Arraylist 이름.set(index선택,해당index.get(index선택) - 빼고싶은 값)

            if (TotalIndex.get(Peoplechoice) <= 0) { //손님 index를 삭제하는경우
                TotalIndex.remove(Peoplechoice); //해당 인덱스 삭제
                People--; //인덱스 삭제했으니까 총 인덱스가 1개감소하였으므로 표시를 해줘야함
            }
            //돈을 빼거나 삭제했을때 최종출력
            for (int i = 0; i < People; i++) {
                System.out.println("" + (i + 1) + "번째  손님이 가진 금액 : " + TotalIndex.get(i) + "원");
            }
            //else값이 필요없는이유는 다시 for문으로 돌아가면 그값이 빠진상태에서 출력되기때문에 중복되어 쓰지않아도 된다
        }
        System.out.println("처음에 모든 사람이 가지고 있던 돈의 총합은 "+Firstmoney+"원 입니다");
        System.out.println("마지막까지 가지고 있는 돈의 총합은 : "+Finishmoney+"원 입니다");
        System.out.println("처음과 마지막의 돈의 총합의 차는 : "+(Firstmoney - Finishmoney)+"원 입니다");
    }
}
