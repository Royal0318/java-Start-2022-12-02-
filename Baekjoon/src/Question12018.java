import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Question12018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] cut = str.split(" ");
        int sumPoint = 0;
        int result = 0;

        ArrayList<Integer> resultArr = new ArrayList<>();

        for (int i = 0; i < Integer.parseInt(cut[0]); i++) {
            ArrayList<Integer> arr = new ArrayList<>();

            String NM = br.readLine();
            String[] nmCut = NM.split(" ");

            String inputPoint = br.readLine();
            String[] inputCut = inputPoint.split(" ");

            arraysSort(inputCut,arr);

            if (Integer.parseInt(nmCut[0]) > Integer.parseInt(nmCut[1])) {
                resultArr.add(arr.get(Integer.parseInt(nmCut[1]) - 1));
                /*신청한사람수가 더많은경우 예를들어 신청수가 4명이고 한계인원 2명이면 2번째로 들어가면되니까 cut[1] - 1의 값을줘
                서로 같게하면 포인트가 같을때 성준이에게 우선순위가 먼저이기때문
                 */
            }
            //신청한사람수 < 수강한계인원 (모두 수강이 가능한경우)
            else if (Integer.parseInt(nmCut[0]) < Integer.parseInt(nmCut[1])) {
                resultArr.add(1); //모두 수강이 가능하면 최소포인트인 1포인트만내면됨
            }
            else { //같은경우 1명만 재끼면됨
                resultArr.add(arr.get(arr.size() - 1));
            }
        }
        Collections.sort(resultArr);

        for (Integer s : resultArr) {
            System.out.println(s);
            if ((sumPoint + s) > Integer.parseInt(cut[1])) break;
            else {
                sumPoint += s;
                result += 1;
            }
        }
        System.out.println(result);
    }
    public static void arraysSort (String[] inputCut, ArrayList<Integer> arr) { //정렬
        for (String s : inputCut) arr.add(Integer.parseInt(s));
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }
}
