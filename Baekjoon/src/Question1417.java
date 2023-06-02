import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        int saveIndex = Integer.MIN_VALUE;
        int result = 0; //정답 ㅣㅣ

        int[] arr = new int[testCase];

        for (int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(br.readLine()); //배열값에 각각의 입력값을 저장

            if (max <= arr[i]) { //만약에 max보다 큰값인경우 index와함께 값까지 같이저장
                max = arr[i];
                saveIndex = i;
            }
        }
        if (testCase == 1 || saveIndex == 0) { //예외처리로 혼자출마하거나 처음부터 자신이 제일 큰표인경우 더 가져올필요가없으므로 시스템종료시킴
            System.out.println(0);
            return;
        }
        while (true) { //그렇지않은경우
            arr[saveIndex] -= 1; //자신을 제외한 가장많은표를 흭득한 사람의 표를1개제거
            arr[0] += 1; //자신의 표를 1개 추가
            result += 1; //1번 표가 옮겨졌으므로 1추가

            for (int i = testCase - 1; i >= 0; i--) { //for문을 정방향으로 출력한다면 다른값과 자신이 같을때 자신부터 출력하기때문에 역방향으로 돌린다
                if (arr[saveIndex] < arr[i]) { //가장많은 표를 가진사람이 역전당한경우
                    saveIndex = i; //다른사람의 index저장
                    if (saveIndex == 0) { //만약에 그것이 자신이되는경우에 시스템 종료
                        System.out.println(result);
                        return;
                    }
                }
            }
        }
    }
}
