import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question5545 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        String[] cut = str.split(" ");

        int dowCal = Integer.parseInt(br.readLine()); //도우의 열량
        int[] di = new int[N]; //토핑의 열량

        for (int i = 0; i < N;i++) {
            di[i] = Integer.parseInt(br.readLine()); //토핑열량 배열에 저장
        }

        int zeroTopKcal = (dowCal / Integer.parseInt(cut[0])); //토핑을 하나도 올리지않은경우
        int result = zeroTopKcal;

        Arrays.sort(di); //오름차순 정렬

        int totalCal = dowCal; //토탈 칼로리
        int pizzaPrice = Integer.parseInt(cut[0]); //피자가격

        //토핑을 1개이상 올린경우
        for (int i = (N - 1) ; i >= 0;i--) { //큰열량부터
            totalCal += di[i]; //토탈칼로리 + 토핑칼로리
            pizzaPrice += Integer.parseInt(cut[1]); //for문을 돌때마다 가격이 달리지므로 가격을 추가

            int tempKCal = (totalCal / pizzaPrice); //토핑이1개이상인경우의 1원당 칼로리측정

            if (result < tempKCal) { //만약 토핑을 한개도안올린경우보다 큰경우
                result = tempKCal; //답을 바꾼다
            }
        }
        System.out.println(result);
    }
}
