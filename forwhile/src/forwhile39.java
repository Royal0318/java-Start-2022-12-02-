public class forwhile39 {
    public static void main(String[] args) {
        int[] Totalmoney = new int[15];
        //5명은 20000원 고장 5명은 10000원 고정 나머지는 println으로 받는다
        Totalmoney[0] = 20000;
        Totalmoney[1] = 20000;
        Totalmoney[2] = 20000;
        Totalmoney[3] = 20000;
        Totalmoney[4] = 20000;
        Totalmoney[5] = 20000;
        Totalmoney[6] = 20000;
        Totalmoney[7] = 20000;
        Totalmoney[8] = 20000;
        Totalmoney[9] = 20000;
        int[][] Foodbuynumber = new int[15][5];
        int[][] Deftmoney = new int[15][15];
        int[][] Borrowmoney = new int[15][15];

        forwhile40 Object = new forwhile40(Totalmoney,Foodbuynumber,Deftmoney,Borrowmoney,0);
        forwhile40 EmptyObject = new forwhile40();
        Object.Therestmoneyinput();
    }
}
