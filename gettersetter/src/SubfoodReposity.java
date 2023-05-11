import java.util.ArrayList;
import java.util.Scanner;

public class SubfoodReposity {
    private String foodName; //음식명
    private int foodPrice; //음식가격

    private SubfoodReposity() {
        //서브생성자
    }
    public SubfoodReposity (String foodName,int foodPrice) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
    public void setFoodName (String foodName) {
        this.foodName = foodName;
    }
    private String getFoodName () {
        return foodName;
    }
    public void setFoodPrice (int foodPrice) {
        this.foodPrice = foodPrice;
    }
    private int getFoodPrice () {
        return foodPrice;
    }

    public void addMenu (ArrayList<SubfoodReposity> food, Scanner sc) { //메뉴추가
        System.out.println("새로 추가할 음식의 이름을 적어주세요");
        String name = sc.next();
        System.out.println("가격을 적어주세요");
        int price = sc.nextInt();

        System.out.println("음식 이름 : "+name+" \n가격 : "+price+"원 \n위 정보가 맞다면 1번을 눌러주세요");
        int check = sc.nextInt();

        if (check == 1) {
            setFoodName(name);
            setFoodPrice(price);
            SubfoodReposity addFood = new SubfoodReposity(getFoodName(),getFoodPrice());
            food.add(addFood);
            System.out.println("정상적으로 등록되었습니다");
        } else {
            System.out.println("잘못된 입력입니다 다시 시도해주세요");
        }
    }
    public void deleteMenu () { //메뉴삭제

    }
    public void orderMenu () { //메뉴주문

    }
    public void modifyMenu () { //메뉴수정

    }
    public void outputMenu (ArrayList<SubfoodReposity> food) { //전체등록된 메뉴 출력
        int listNumber = 1;
        for (SubfoodReposity totalFoodMenu : food) {
            System.out.println(""+listNumber+"."+totalFoodMenu.foodName+" \n가격 : "+totalFoodMenu.foodPrice+"");
            listNumber += 1;
            System.out.println("=============================================");
        }
    }
}
//알트 + 인써트로 손쉽게 만들수있다