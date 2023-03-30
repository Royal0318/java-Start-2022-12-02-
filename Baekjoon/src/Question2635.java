import java.util.ArrayList;
import java.util.Scanner;

public class Question2635 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> save = new ArrayList<>();

        for (int i = n; i >= 1; i--) {
            arr.add(n); //index 0번
            arr.add(i); //index 1번

            while (true) {
                //무한반복을 통하여 plus값 즉 index2번의 값은 index 0 - index 1이기때문임
                int plus = (arr.get(arr.size() - 2) - arr.get(arr.size() - 1));

                if (plus < 0) {
                    break;
                    //그 값이 0보다 작으면 그만 카운트한타는 조건이 있었기때문
                } else {
                    arr.add(plus);
                    //그렇지않은경우 해당 값을 Arraylist에 추가
                }
            }
            if (max < arr.size()) {
                //total index length값이 전에값 보다 클경우 해당 길이를 max에담는다 save는 정답을 저장하는 Arraylist이기 때문에 max가 크다면 입력한 Arraylist값들을 저장한다
                max = arr.size();
                save.clear();
                save.addAll(arr);
            }
            arr.clear();
            //if문이 속하지않는경우 가장큰값이 아니므로 다시 카운트하기위해 Arraylist를 비워준다
        }
        System.out.println(max);
        for (int s : save) {
            System.out.println(s);
        }
    }
}
