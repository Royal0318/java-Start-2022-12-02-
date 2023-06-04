import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double scoreSum = 0; //학점 X 과목평점
        double totalScore = 0; //전체학점
        String[] arr = {"A+","A0","B+","B0","C+","C0","D+","D0","F"};
        double[] score = {4.5,4.0,3.5,3.0,2.5,2.0,1.5,1.0,0.0};

        for (int i = 0; i < 20;i++) { //총 20개의 문자열을 입력받는다
            String str = br.readLine();

            String[] cut = str.split(" ");

            String temp = cut[2]; //과목을 temp변수에 저장

            for (int j = 0; j < arr.length;j++) {
                if (temp.contains(arr[j]) && !cut[2].equals("P")) {
                    //arr을 돌면서 temp가 어디위치에 존재하는지 체크 && P는 계산하지않음
                    scoreSum += (score[j] * Double.parseDouble(cut[1])); //학점 X 과목평점
                    totalScore += Double.parseDouble(cut[1]); //전체학점
                    break;
                }
            }
        }
        double result = (scoreSum/totalScore);
        System.out.printf("%.6f",result); //소수점6째자리까지 출력
    }
}
