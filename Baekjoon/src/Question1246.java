import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Question1246 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] cut = str.split(" ");
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0 ; i < Integer.parseInt(cut[1]);i++) {
            int client = Integer.parseInt(br.readLine()); //고객이원하는가격
            arr.add(client);
        }
        Collections.sort(arr);

        int result = Integer.MIN_VALUE;
        int temp = 0;
        int priceSave = 0;

        for (int i = 0 ; i < arr.size();i++) {
            if (Integer.parseInt(cut[0]) > Integer.parseInt(cut[1]) - i) {
                temp = (arr.get(i) * (Integer.parseInt(cut[1]) - i));
            }
            else { //고객수보다 달걀수가 더많은경우
                temp = (arr.get(i) * Integer.parseInt(cut[0]));
            }
            if (result < temp) {
                result = temp;
                priceSave = arr.get(i);
            }
        }
        System.out.println(""+priceSave+" "+result+"");
    }
}
