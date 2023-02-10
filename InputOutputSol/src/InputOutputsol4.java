import java.util.Scanner;

public class InputOutputsol4 {
    String FoodName;
    String FoodName2;
    String FoodName3;
    String FoodName4;
    String FoodName5;
    String FoodName6;


    InputOutputsol4(String FoodName,String FoodName2,String FoodName3,String FoodName4,String FoodName5,String FoodName6) {
        this.FoodName = FoodName;
        this.FoodName2 = FoodName2;
        this.FoodName3 = FoodName3;
        this.FoodName4 = FoodName4;
        this.FoodName5 = FoodName5;
        this.FoodName6 = FoodName6;
    }
    void FoodPriceMet () {
        Scanner sc = new Scanner(System.in);
        System.out.println(""+FoodName+" "+FoodName2+" "+FoodName3+" "+FoodName4+" "+FoodName5+" "+FoodName6+"의 가격을 각각 적어주세요");
        int FoodNamePrice = sc.nextInt();
        int FoodName2Price = sc.nextInt();
        int FoodName3Price = sc.nextInt();
        int FoodName4Price = sc.nextInt();
        int FoodName5Price = sc.nextInt();
        int FoodName6Price = sc.nextInt();
        FoodNumberMet(FoodNamePrice,FoodName2Price,FoodName3Price,FoodName4Price,FoodName5Price,FoodName6Price);
    }
    void FoodNumberMet (int FoodNamePrice,int FoodName2Price,int FoodName3Price,int FoodName4Price,int FoodName5Price,int FoodName6Price) {
        Scanner sc = new Scanner(System.in);
        System.out.println(""+FoodName+" "+FoodName2+" "+FoodName3+" "+FoodName4+" "+FoodName5+" "+FoodName6+"의 구매개수를 각각 적어주세요");
        int FoodBuyNumber = sc.nextInt();
        int Food2BuyNumber = sc.nextInt();
        int Food3BuyNumber = sc.nextInt();
        int Food4BuyNumber = sc.nextInt();
        int Food5BuyNumber = sc.nextInt();
        int Food6BuyNumber = sc.nextInt();
        Output(FoodNamePrice,FoodName2Price,FoodName3Price,FoodName4Price,FoodName5Price,FoodName6Price,FoodBuyNumber,Food2BuyNumber,Food3BuyNumber,Food4BuyNumber,Food5BuyNumber,Food6BuyNumber);
    }
    void Output(int FoodNamePrice,int FoodName2Price,int FoodName3Price,int FoodName4Price,int FoodName5Price,int FoodName6Price,int FoodBuyNumber,int Food2BuyNumber,int Food3BuyNumber,int Food4BuyNumber,int Food5BuyNumber,int Food6BuyNumber) {
        System.out.println(""+FoodName+"는 : "+(FoodNamePrice * FoodBuyNumber)+"원");
        System.out.println(""+FoodName2+"는 : "+(FoodName2Price * Food2BuyNumber)+"원");
        System.out.println(""+FoodName3+"는 : "+(FoodName3Price * Food3BuyNumber)+"원");
        System.out.println(""+FoodName4+"는 : "+(FoodName4Price * Food4BuyNumber)+"원");
        System.out.println(""+FoodName5+"는 : "+(FoodName5Price * Food5BuyNumber)+"원");
        System.out.println(""+FoodName6+"는 : "+(FoodName6Price * Food6BuyNumber)+"원");
        System.out.println("총 합은 "+((FoodNamePrice * FoodBuyNumber) + (FoodName2Price * Food2BuyNumber) + (FoodName3Price * Food3BuyNumber) + (FoodName4Price * Food4BuyNumber) + (FoodName5Price * Food5BuyNumber) + (FoodName6Price * Food6BuyNumber))+"원");
        System.out.println("A가 지불한 값은 : "+((FoodNamePrice * FoodBuyNumber) + (FoodName2Price * Food2BuyNumber) + (FoodName3Price * Food3BuyNumber))+"원");
        System.out.println("B가 지불한 값은 : "+ ((FoodName4Price * Food4BuyNumber) + (FoodName5Price * Food5BuyNumber) + (FoodName6Price * Food6BuyNumber))+"원");
    }
}
