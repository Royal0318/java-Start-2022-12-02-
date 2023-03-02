import java.io.*;
public class Question11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        sb.append((int) (Math.pow(2, num)-1)).append("\n");
        hanoi(num,1,2,3); //3이라고 가정
        System.out.println(""+sb+"");
    }
    static void hanoi (int num, int start, int middle, int finish) {
        if (num == 1) {
            sb.append(""+start+" "+finish+"\n");
            //1번으로 실행됨 1,3이 출력되니까 1번에있는 n-1개를 모두 들어 3번자리로 이동 3번자리는 start,finish,middle이니까 2번째자리로감
        } else {
            hanoi(num-1, start,finish,middle);
            //                 1번판   2번판  3번판  위에서는 1번에서 3번으로 이동시키기 때문이다
            sb.append(""+start+" "+finish+"\n");//1개를 a에서 c로 이동
            hanoi(num-1, middle,start,finish);
            //                 1번판   2번판  3번판
            // 1번에있는것을 또 3번으로 옮기는데  middle,start,finish이니까  =미들에서 피니쉬로 즉 2번에있는것이n-1개가3번으로 이동
        }
    }
}
