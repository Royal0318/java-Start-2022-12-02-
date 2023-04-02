import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question16505 {
    static char[][] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        //n의 값을 1이라고 가정

        arr = new char[(int) Math.pow(2, n)][(int) Math.pow(2, n)];
        //2X2의 2차원 배열이 생성됨

        for (int i = 0; i < (int) Math.pow(2, n); i++) {
            Arrays.fill(arr[i], ' ');
        }
        //Arrays.fill을통해 전체 공백을 채움
        recur(0, 0, 0);
        //여기서 recur 메소드로 이동

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < (int) Math.pow(2, n); i++) {
            //바깥 for문은 0 ~ 2이지만 괄호가 < 이므로 2번만 실행
            for (int j = 0; j < (int) Math.pow(2, n)-i; j++) {
                //안쪽for문은 1을입력했을때 다음칸으로 넘어갈때 별 1개만 출력되기 때문에 2가아니라 1인 1번만 실행되어야한다 불필요한 공백은 출력하지 않음
                sb.append(arr[i][j]);
                //입력된별을 합친다
            }
            //안쪽 for문이 끝난경우 if문에 맞는지 확인
            if (i != (int) Math.pow(2, n)) {
                sb.append("\n");
            }
            /*
            1.i값 : 0 Math.pow = 2  if문실행 X
            2.i값 : 1 Math.pow = 2  if문실행 X
            3.i값 : 2 Math.pow = 2  if문실행 O
            즉 2번까지 가로로 별2개 ** 가찍히고 3번으로 넘어갈때 if문이 실행되면서 다음라인으로 넘어감
            4.i값 : 1 Math.pow = 2  if문 실행X
            5.i값 : 2 Math.pow = 2  if문실행 O
            5번째에서 if문이 실행되어 또 다른라인으로 넘어가므로 최종적으로
            **
            *
            의 모양이 나온다
             */
        }
        System.out.print(sb);
    }

    static void recur(int de, int x, int y) {
        /*
        총 루프 도는 횟수에 따라 x와 y의 변화값
        1.x값 : 0 y값 : 0
        2.x값 : 0 y값 : 1
        3.x값 : 1 y값 : 0
         */
        if (de == n) {
            arr[x][y] = '*';
            return;
        }
        int d = (int)Math.pow(2, de);
        System.out.println("de값 : "+de+"");
        recur(de + 1, x, y); //1번실행 처음에는 x와 y둘다 0이므로 2차원배열 [0][0]에 *가 찍힘 n이 1이기때문에 de는 루프를 한번돌면 1이되므로 if문을 실행하여 [0][0]에 별을저장
        recur(de + 1, x, (y + d)); //2번실행 d의 값을 먼저 구한다 de는 다시 리턴으로 넘어왔을때 0이므로 x는 0 y + d는 0 + 1(d = 2의0승 즉 1이기 때문) 이여서 [0][1]에 별을저장
        recur(de + 1, (x + d), y); //3번실행 d의 값을 먼저 구한다 de는 다시 리턴으로 넘어왔을때 0이므로 x+d는 1이되고 y값은 0이된다
        //모두 루프를돌았기 때문에 출력으로
    }
}
