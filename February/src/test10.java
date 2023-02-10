public class test10 {
    int FoodPrice;
    int FoodPrice2;
    int FoodPrice3;
    int FoodPrice4;
    int FoodPrice5;
    int FoodPrice6;

    int FoodNumber;
    int FoodNumber2;
    int FoodNumber3;
    int FoodNumber4;
    int FoodNumber5;
    int FoodNumber6;


    test10 (int FoodPrice,int FoodPrice2,int FoodPrice3,int FoodPrice4,int FoodPrice5,int FoodPrice6,int FoodNumber,int FoodNumber2,int FoodNumber3,int FoodNumber4,int FoodNumber5,int FoodNumber6) {
        this.FoodPrice = FoodPrice;
        this.FoodPrice2 = FoodPrice2;
        this.FoodPrice3 = FoodPrice3;
        this.FoodPrice4 = FoodPrice4;
        this.FoodPrice5 = FoodPrice5;
        this.FoodPrice6 = FoodPrice6;
        this.FoodNumber = FoodNumber;
        this.FoodNumber2 = FoodNumber2;
        this.FoodNumber3 = FoodNumber3;
        this.FoodNumber4 = FoodNumber4;
        this.FoodNumber5 = FoodNumber5;
        this.FoodNumber6 = FoodNumber6;
    }

    void FoodCal (int FoodPrice,int FoodPrice2,int FoodPrice3,int FoodPrice4,int FoodPrice5,int FoodPrice6,int FoodNumber,int FoodNumber2,int FoodNumber3,int FoodNumber4,int FoodNumber5,int FoodNumber6) {
        System.out.println("토마토의 총 가격은 : "+(FoodPrice * FoodNumber)+"원");
        System.out.println("감자의 총 가격은 : "+(FoodPrice2 * FoodNumber2)+"원");
        System.out.println("물의 총 가격은 : "+(FoodPrice3 * FoodNumber3)+"원");
        System.out.println("과자의 총 가격은 : "+(FoodPrice4 * FoodNumber4)+"원");
        System.out.println("빵의 총 가격은 : "+(FoodPrice5 * FoodNumber5)+"원");
        System.out.println("껌의 총 가격은 : "+(FoodPrice6 * FoodNumber6)+"원");
        System.out.println("A와 B의 총 가격은 "+((FoodPrice * FoodNumber) + (FoodPrice2 * FoodNumber2) + (FoodPrice3 * FoodNumber3) + (FoodPrice4 * FoodNumber4) + (FoodPrice5 * FoodNumber5) + (FoodPrice6 * FoodNumber6)) +"원");
        System.out.println("A는 총 "+((FoodPrice * FoodNumber) + (FoodPrice2 * FoodNumber2) + (FoodPrice3 * FoodNumber3))+"원을 지불");
        System.out.println("B는 총 "+((FoodPrice4 * FoodNumber4) + (FoodPrice5 * FoodNumber5) + (FoodPrice6 * FoodNumber6))+"원을 지불");

    }
}
