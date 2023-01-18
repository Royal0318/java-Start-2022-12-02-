import java.util.Scanner;

public class Januaryeighteenth2 {
    public static void main(String[] args) {
        System.out.println("" + main() + "");
    }
    public static int main() {
        int ICount = 0;
        int JCount = 0;
        int EndCount = 0;
        int Count = 101;
        int[][] NoName = new int[5][5];
        int[][] Old = new int[5][5];
        int[][] Ho = new int[5][5];
        String[][] Namearr = new String[5][5];
        for (int i = 0;i < 5;i++) { //호수부여
            for (int j = 0;j < 5;j++) {
                Ho[i][j] = Count;
                Count++;
            }
            Count = Count + 95;
        }
        return Menu(Old, Ho, Namearr, ICount, NoName,JCount,Count,EndCount);
    }

    public static int Menu(int[][] Old, int[][] Ho, String[][] Namearr, int ICount, int[][] NoName,int JCount,int Count,int EndCount) {
        Scanner sc = new Scanner(System.in);
        if (EndCount == 24) { //종료조건
            return main();
        }
        while (true) {
            System.out.println("1.이사  \n2.입주");
            int Select = sc.nextInt();
            if (Select == 1) {
                return Out(Old, Ho, Namearr, ICount, NoName, JCount, Count,EndCount);
            } else if (Select == 2) {
                return In(Old, Ho, Namearr, ICount, NoName, JCount, Count,EndCount);
            } else {
                System.out.println("잘못된 입력입니다\n");
            }
        }
    }


    public static int In(int[][] Old, int[][] Ho, String[][] Namearr, int ICount, int[][] NoName,int JCount,int Count,int EndCount) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("입주를 원하는 호수를 적어주세요");
            int HouseSelect = sc.nextInt();

            if (HouseSelect < 101 || HouseSelect > 505) {
                System.out.println("잘못된 입력입니다");
            } else {
                ICount = ((HouseSelect / 100) - 1);
                JCount = ((HouseSelect % 100) - 1);
                if (Old[ICount][JCount] != 0) {
                    System.out.println("해당 호수에 사람이 살고 있습니다");
                    ICount = 0;
                    JCount = 0;
                } else {
                    System.out.println("입주 할 사람의 이름");
                    String Name = sc.next();
                    Namearr[ICount][JCount] = Name;
                    NoName[ICount][JCount] += 1;

                    System.out.println("입주 할 사람의 나이");
                    int Age = sc.nextInt();
                    Old[ICount][JCount] = Age;
                    EndCount++;
                }
                return House(Old, Ho, Namearr, ICount, NoName, JCount, Count,EndCount);
            }
        }
    }

    public static int Out(int[][] Old, int[][] Ho, String[][] Namearr, int ICount, int[][] NoName,int JCount,int Count,int EndCount) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("이사갈 호수를 적어주세요");
            int HouseNumber = sc.nextInt();

            if (HouseNumber < 101 || HouseNumber > 505) {
                System.out.println("잘못된 입력입니다");
            } else {
                ICount = ((HouseNumber / 100) - 1);
                JCount = ((HouseNumber % 100) - 1);
                if (Old[ICount][JCount] == 0) {
                    System.out.println("해당 호수에 아무도 없습니다");
                    ICount = 0;
                    JCount = 0;
                } else {
                    Old[ICount][JCount] = 0;
                    Namearr[ICount][JCount] = "";
                    EndCount++;
                }
                return House(Old, Ho, Namearr, ICount, NoName, JCount, Count,EndCount);
            }
        }
    }

    public static int House(int[][] Old,int[][] Ho,String[][] Namearr,int ICount,int[][] NoName,int JCount,int Count,int EndCount) {
        for (int i = 0; i < 5; i++) {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            for (int j = 0; j < 5; j++) {
                if (NoName[i][j] == 0) {
                    System.out.printf("ㅣ" + Ho[i][j] + "호 이름 :  나이 : "+Old[i][j]+"");
                } else {
                    System.out.printf("ㅣ" +  Ho[i][j] + "호 이름 : "+Namearr[i][j]+" 나이 : "+Old[i][j]+"");
                }
            }
            System.out.println();
        }
        ICount = 0;
        JCount = 0;
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        return Menu(Old,Ho,Namearr,ICount,NoName,JCount,Count,EndCount);
    }
}
