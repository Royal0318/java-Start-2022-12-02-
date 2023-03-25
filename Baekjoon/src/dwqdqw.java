
public class dwqdqw {
    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 4;
        arr[3] = 5;
        arr[4] = 7;
        arr[5] = 9;
        int target = 8; // 이 중 몇 번째 인덱스부터 10 이상이 되는지 찾아보도록 하자.
        int n = 6; // 배열의 크기

        System.out.println(lower_bound(arr, target, n));
    }

    static int lower_bound(int[] arr, int target, int size) {
        int mid = 0;
        int start = 0;
        int end = 0;

        end = size - 1; // n - 1

        while (end > start) { // end가 start보다 같거나 작아지면, 그 값이 Lower Bound이므로 반복을 종료한다.
            //즉 end 값은 배열의 크기에서 1씩줄어들면서 0보다 작아지거나 같을때 종료

            mid = ((start + end) / 2);


            if (arr[mid] >= target) {// 중간값이 원하는 값보다 크거나 같을 경우, 끝값을 중간값으로 설정하여 다시 탐색한다.
                end = mid;
            } else {
                start = mid + 1; // 중간값이 원하는 값보다 작을 경우, 시작값을 중간값+1로 설정하여 다시 탐색한다.
            }
        }
        return end;
    }
}
