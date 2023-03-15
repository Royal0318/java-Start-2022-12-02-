public class Question4673 {
    public static void main(String[] args) {
        boolean[] arr = new boolean[10001];
        //반대의 값이 나와야하기 때문에 boolean을사용
        for (int k = 1; k <= 10000; k++) {
            for (int i = 1; i < k; i++) {
                String str = "" + i + "";
                int length = str.length();
                int sum = 0;
                //각각의 자리값을 length에 저장하며각자릿수의 합을sum변수에 저장
                for (int j = 0; j < length; j++) {
                    sum += str.charAt(j) - '0';
                }
                if ((i + sum) == k) {
                    arr[k] = true;
                    break;
                }
                //셀프넘버가 아닌수는 true를 준다
            }
        }
        for (int i = 1 ; i < 10000;i++) {
            if (!arr[i]) {
                System.out.println(""+i+"");
            }
        }
        //셀프넘버인수들만 출력해야하기때문에 false값을 출력함
    }
}