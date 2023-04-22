import java.util.Scanner;

public class Question2018a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int start = 1; //1부터 시작
        int end = 1; //끝도 1부터시작
        int result = 1; //정답 개수
        int sum = 1; //현재까지 누적합 start와 end는 1이니까 sum은 1이되야함

        while (end < num) { //end가 num을 넘지 않도록 즉 예가 15라면 14까지만
            if (sum == num) { //같은경우는 end를 한칸올리고 그값까지 더한다 당연히 그 다음은 elseif가되어 start를 한칸올리고 그 뒤에는 삭제된다
                result += 1;
                end += 1;
                sum = (sum + end);
            } else if (sum > num) { //sum이 더큰경우에 현재start지점을 지우고 (sum에서 뺌) start을 늘린다 그러면 x개를 더하는 범위가 x-1이 되어 범위는 좁아지기 때문이다
                sum = (sum - start);
                start += 1;
            } else { //num이 더큰경우 end를 한칸늘려 sum이랑 end랑 가까워지도록한다
                end += 1;
                sum = (sum + end);
            }
        }
        System.out.println(result);
    }
}
