import java.util.Scanner;

public class codeup1570 {
    static int check = 0;
    //lower bound 코드
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n;i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(f(arr,n,target));
    }
    static int f (int[] arr,int n,int target) {
        int start = 0;
        int middle = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < target) {
                //upper인경우 <=로 설정
                check += 1;
            }
        }
        //for문을돌려 타겟이 모든 배열값보다 큰경우 check에 1을 누적
        if (check == arr.length) {
            return arr.length+1;
            //만약에 배열size값과 check값이 크다는뜻은 target이 배열값보다 모두크다는 의미이므로 size+1만큼 리턴
        } else {
            //그렇지 않은경우 start시작값은 1이고 end 즉 끝의위치는 배열사이즈 -1이된다
            end = (n - 1);
            while (end > start) {
                //while문을 돌려 끝에서부터 검사한다
                middle = ((start + end) / 2);
                //중간값을 구하는 식
                if (arr[middle] < target) {
                    //중간에위치한값이 타겟값보다 작은경우
                    start = (middle + 1);
                    //시작위치를 중간위치 + 1로 설정
                } else {
                    //중간에위치한값이 타겟값보다 작은경우
                    end = middle;
                    //끝의위치를 중간위치로 변경
                }
            }
            return (end + 1);
            //반복문이 끝난경우 끝에위치한 index + 1을 리턴
        }
    }
}
