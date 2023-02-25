import java.util.Scanner;

public class forwhile22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] foodArrayIndex = new int[3][2];
        //2차원 배열을 이용하여 음식의 가격과 개수를 저장하는 배열값 횡렬의 0은 음식의 가격 1은 음식의 개수를 저장한다
        forwhile23 object = new forwhile23(3,0,0,foodArrayIndex);
        //메인생성자
        forwhile23 emptyObject = new forwhile23();
        //예비 생성자
        object.ageInput(sc);
    }
}
