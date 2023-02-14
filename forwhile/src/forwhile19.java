
public class forwhile19 {
    public static void main(String[] args) {
        //main값에 변수를 보관한다
        int Foodbuymoney = 0; //음식을 구매한 값을 저장
        int Foodbuycheck = 0; //식당 재입장 여부 확인
        int Calculatorsum = 0; //계산기 마지막값 기억
        int Calmenuoutcheck = 0; //계산기 재진입 여부 확인
        forwhile20 FoodMet = new forwhile20(Foodbuymoney, Foodbuycheck, Calculatorsum, Calmenuoutcheck);
        forwhile20 FoodMet2 = new forwhile20();
        //예비생성자
        FoodMet.Selectmenu(FoodMet);
        //메인값을 불러옴
    }
}
