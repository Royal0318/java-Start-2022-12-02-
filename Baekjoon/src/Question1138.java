import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] arr = new int[testCase];
        ArrayList<Integer> resultArr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = testCase - 1;i >= 0;i--) {
            resultArr.add(arr[i],(i + 1)); //arr[i]값의 index쪽에 i + 1값을 할당한다
        }
        for (Integer output : resultArr) {
            System.out.printf(""+output+" ");
        }
    }
    /*
    Arraylist에 중간에삽입할경우 들어가는 뒤에부터 한칸씩 자동으로 밀어주기때문에 Arraylist로 풀어도됨
    시뮬레이션을 해보자
    예시가 2 1 1 0 라고하면
    일단 arr[] 배열에 저장을한다 각각 arr[0] = 2,arr[1] = 1,arr[2] = 1,arr[3] = 0 이 할당된다
    그 이후에 Arraylist에 다시 값을 넣는데
    정방향이 아닌 역방향으로 넣어야한다 정방향으로 넣게된다면
    i = 0일때 add는 (arr[0],(i + 1)) = (2의 index에 1을 넣어버리기 때문에 원하는 값이 나오지않음)
    역으로 진행할때
    i = 3  add.(arr[3],3 + 1) = (index 0자리에 4값을 할당하여 딱맞음)     (4, , , ,)
    i = 2  add.(arr[2],2 + 1) = (index 1자리에 3값을 할당하여 딱맞음)     (4,3, , ,)
    i = 1  add.(arr[1],1 + 1) = (index 0자리에 2값을 할당)
    여기에서 이미 index 1의 자리에는 숫자가 존재하지만 값을 할당하면 3의 위치가 한칸 자동으로 밀리고 위에 2가 들어간다!!!!
    그래서 결과는 (4,2,3, ,)
    i = 0  add.(arr[0],0 + 1) = (index 0자리에 1값을 할당하여 딱맞음)
    마찬가지로 index 2의자리는 이미 3이 들어있지만 들어갈수있으며 3은 마지막으로밀린다
    그래서 결과는  (4,2,1,3)이 되게된다!
     */
}