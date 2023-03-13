import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question1233 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] arr2 = new int[80];
        int max = 0;
        int max2 = 0;

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    arr.add(i + j + k);
                }
            }
        }
        //Arraylist에 모든경우의수의 합을 저장
        for (int i = 0; i < 80; i++) {
            int count = Collections.frequency(arr, i);
            arr2[i] = count;
        }
        //Collectins.frequency를 통해 Arraylist에 중복되는것을 모아서횟수로 변환
        max = arr2[0];
        for (int i = 0; i < 80; i++) {
            if (max < arr2[i]) {
               max = arr2[i];
               max2 = i;
           }
        }
        //가장 큰값을 찾는것과 동시에 그것이 몇번째에 존재하는지 알수있게 만듬
        System.out.println(max2);
    }
}
