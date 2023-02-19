public class forwhile39 {
    public static void main(String[] args) {
        int[] Totalmoney = new int[15];
        Totalmoney[0] = 20000;
        Totalmoney[1] = 20000;
        Totalmoney[2] = 20000;
        Totalmoney[3] = 20000;
        Totalmoney[4] = 20000;
        Totalmoney[5] = 10000;
        Totalmoney[6] = 10000;
        Totalmoney[7] = 10000;
        Totalmoney[8] = 10000;
        Totalmoney[9] = 10000;
        int[][] Foodbuynumber = new int[15][5];
        int[][] Deftmoney = new int[15][15];
        int[] Borrowmoney = new int[15];
        int[] Initialcapital = new int[15];
        int[] Paybacksum = new int[15];
        int[] Deftmoneysum = new int[15];
        forwhile40 Object = new forwhile40(Totalmoney,Foodbuynumber,Deftmoney,Borrowmoney,0,Initialcapital,Paybacksum,Deftmoneysum,0,0);
        forwhile40 EmptyObject = new forwhile40();
        Object.Therestmoneyinput();
        Object.Selectmenu();
    }
}
