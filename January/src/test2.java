import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        System.out.println(""+main()+"");
    }

    public static int main() {
        int ICount = 0;
        int Count = 101;
        int[][] Old = new int[5][5];//25명의 정보를 기록 int니까 호수랑 나이 스트링은 이름을 받자
        int[][] Ho = new int[5][5];
        String [][] Namearr = new String[5][5];

        for (int i = 0;i < 5;i++) { //각각사람인원수에 호수를 부여한다
            for (int j = 0;j < 5;j++) {
                Ho[i][j] = Count;
                Count++;
            }
            Count = Count + 96; //105호다음에 201호 넘어간다
        }
        return Menu(Old,Ho,Namearr,ICount);
    }

    public static int Menu(int[][] Old,int[][] Ho,String[][] Namearr,int ICount) {
        //각각의 호수를 부여한다
        Scanner sc = new Scanner(System.in);
        for (int i = ICount; i < 25; i++) {
            System.out.println("1.이사  \n2.입주");
            int Select = sc.nextInt();
            if (Select == 1) {
                return In(Old, Ho, Namearr, ICount);
            } else if (Select == 2) {
                return Out(Old, Ho, Namearr, ICount);
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
        return 0;
    }

    public static int In(int[][] Old,int[][] Ho,String[][] Namearr,int ICount) {
        Scanner sc = new Scanner(System.in);
        for (int i = ICount; i < 25; i++) {
            System.out.println("입주를 원하는 호수를 적어주세요");
            int HouseSelect = sc.nextInt();

            if (HouseSelect < 101 || HouseSelect > 505) {
                System.out.println("잘못된 입력입니다");
                i--;
            } else {
                System.out.println("호수저장");
            }
            System.out.println("입주 할 사람의 이름");
            String Name = sc.next();


            System.out.println("입주 할 사람의 나이");
            int Age = sc.nextInt();
        }
        return House(Old, Ho, Namearr, ICount);
    }

    public static int Out(int[][] Old,int[][] Ho,String[][] Namearr,int ICount) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("이사갈 호수를 적어주세요");
            int HouseNumber = sc.nextInt();

            if (HouseNumber < 101 || HouseNumber > 505) {
                System.out.println("잘못된 입력입니다");
            }
            return House(Old, Ho, Namearr, ICount);
        }
    }

    public static int House(int[][] Old,int[][] Ho,String[][] Namearr,int ICount) {
        for (int i = 0; i < Old.length; i++) {
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            for (int j = 0; j < Ho.length; j++) { //5개씩
                System.out.printf("ㅣ" + Ho[i][j] + "호 이름 : "+Namearr[i][j]+"나이 : "+Old[i][j]+"");
            }
            System.out.println("\n");
        }
        return 0;
    }
}
