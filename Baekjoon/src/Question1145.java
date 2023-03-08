import java.util.Scanner;
public class Question1145 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5]; //총 5번의 입력을 받는다
        int output = 1; //1부터 while을통하여 3개의 배수가 일치할때까지 올라감
        int arrcount = 0; //arr.length 반복을 도와주는 변수
        int check = 0; //배수일치회수를 카운트하는 변수
        for (int i = 0; i < arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        //for문을통해 5개의 변수를 arr에 넣음
            while (arrcount < 5) {
                //arr[i]중에 i값이 arrcount이므로 계속 초기화되면서 반복
                if ((output%arr[arrcount]) == 0) {
                    //1부터 시작되어 각입력한배열과 나눠 나머지가0인경우 즉 배수인경우 check변수에 1부여
                    check += 1;
                    if (check >= 3) {
                        break;
                    }
                    //그 변수가 3회면 output변수에 3개의 배수가 일치한다는뜻
                }
                arrcount += 1;
                //만약일치하지 않는경우 계속반복되도록 0 ~ 4까지 돌린다
                if (arrcount == 5) {
                    //만약 output값에 3개의배수가 일치하지않는경우 1바퀴를 다돌았으므로 초기화하고 다음수부터 측정
                    arrcount = 0;
                    output += 1;
                    check = 0;
                }
            }
        System.out.println(""+output+"");
    }
}
