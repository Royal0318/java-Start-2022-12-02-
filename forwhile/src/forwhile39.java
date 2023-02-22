import java.util.Scanner;

public class forwhile39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] totalMoney = new int[15];
        totalMoney[0] = 20000;
        totalMoney[1] = 20000;
        totalMoney[2] = 20000;
        totalMoney[3] = 20000;
        totalMoney[4] = 20000;
        totalMoney[5] = 10000;
        totalMoney[6] = 10000;
        totalMoney[7] = 10000;
        totalMoney[8] = 10000;
        totalMoney[9] = 10000;
        int[][] foodBuyNumber = new int[15][5];
        int[][] debtMoneyrecords = new int[15][15];
        int[] personalBorrowMoney = new int[15];
        int[] initialCapital = new int[15];
        int[] personalPaybackMoney = new int[15];
        int[] personalDebt = new int[15];
        forwhile40 object = new forwhile40(totalMoney,foodBuyNumber,debtMoneyrecords,personalBorrowMoney,0,initialCapital,personalPaybackMoney,personalDebt,0,0,1);
        forwhile40 emptyObject = new forwhile40();
        object.therestMoneyInput(sc);
        object.selectMenu(sc);
    }
}
