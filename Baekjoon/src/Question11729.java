import java.io.*;

public class Question11729 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //일반적인 Scanner로 작성하면 시간초과가 발생하기때문에 빠른  BufferedWriter를 사용한다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader 선언
        int n = Integer.parseInt(br.readLine());

        bw.write((int) (Math.pow(2, n) - 1) + "\n");
        /*
        하노이의 공식을 유도하면 결과적으로 n = n^n -1 이 된다 즉 3개를 입력시 8-1이되어 7가지 방법이 나옴
         */
        hanoi(n,1,2,3);
        //start는 가장 처음에있는 기둥 middle은 중간에있는기둥 finish는 마지막에 존재하는 기둥이다
        bw.flush();
        bw.close();
    }
    static void hanoi (int n,int start,int middle,int finish) throws IOException {
        //처음에 3을 입력받았을때
        if (n == 1) {
            bw.write(""+start+" "+finish+"\n");
            //Scanner대신 br.write로 작성
        } else {
            hanoi(n-1, start, finish, middle);
            bw.write(""+start+" "+finish+"\n");
            hanoi(n-1, middle, start, finish);
            //제가 생각하는 바로는 출력이 이뤄져야 원판을 옮긴것이라고 판단하였습니다
            /*
            1.처음에  hanoi(n-1, start, finish, middle);즉 n-1개를 middle로 옮긴다 아직 출력이 되지 않았으므로 완전히 옮긴것은 아니다 n-1을 옮겼고 이제 가장 처음기둥에
            1개가 남아있으므로 if문이 성립한다 if문의 내용은 1번기둥에 있는 하노이를 마지막기둥으로 옮기라는뜻 이제 출력이 되었으므로 사실상 1번에있는 n-1게를 2번으로 옮긴것이다

              2.그 다음에는 다음순서인    bw.write(""+start+" "+finish+"\n");가 출력되며 1번에있는 나머지 1개를 3번으로 옮긴다 지금까지 정리하면
              2번기둥에 2개 3번기둥에 1개가 있으며 2번기둥에 있는 2개를 모두 3번기둥에 옮기면된다

            3.마지막으로   hanoi(n-1, middle, start, finish);이다 n-1개를 middle에서 finish로 옮긴다 나머지 1개가 남으므로 출력으로 1번에있는것을 마지막으로 옮겨라
            start는 중간에 존재 finish는 마지막에있으므로 2번째있는 나머지 기둥이 3번으로 가면서 완성된다
             */
        }
    }
}
