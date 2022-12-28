import java.util.Scanner;
public class Decembertwentyeighth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        최대값을 구하는 방법은

Arrays.sort();
이 메소드를 사용하여 최대 인덱스값과 최소 인덱스 값을 적으면 해결되었다

최대값을 따로 구하고싶다면 물론 위방법을 사용해도 무방하지만

최대값만 구하고 싶을때 사용하는 방법이 또 있다


예를 들어보자


9개의 인덱스를 생성하고 각각의 값을 입력하여 최대값을 찾으라고 하면 쉽게 할 수 있다

만약에 입력한 최대값의 위치까지 고려하라고 한다면 약간 복잡해진다

하지만 그렇게 어렵지 않다 코드를 보자


import java.util.Scanner;
public class baekjoon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        int max = arr[0];
        int maxindex = 0;

        for (int i=1;i< arr.length;i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
                maxindex = i;
            }
        }
        System.out.println(""+max+"");
        System.out.println(""+maxindex+"");
    }
}
위 코드에서는 int max라는 변수값에 최대값이 들어가도록 하였다 그 값은 arr[0]번의 인덱스에 저장한다

그리고 밑에는 최대값이 몇번째에 위치 하는지 알 수 있는 maxindex변수를 0으로 지정해놨다


그런 후 for문에서 인덱스 1부터 10까지 max와 비교한다

비교해서 더 크다면 max값을 해당 값으로 바꿔주는 매커니즘이 되겠다

만약에 arr[1] 값이 3이고 max가 1이라면

max = arr[i]를 통하여 max값이 3이 될것이고

arr[2] = 5이고 max가 3이라면

다시 위와 동일한 방법으로 5로 바뀔것이다
         */
    }
}
