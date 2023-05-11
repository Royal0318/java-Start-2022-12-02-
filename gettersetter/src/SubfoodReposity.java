import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SubfoodReposity {
    private String foodName; //음식명
    private int foodPrice; //음식가격

    SubfoodReposity() {
        //서브생성자
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
        boolean duplicateNameCheck = false;
        SubfoodReposity addFood = new SubfoodReposity(); //선언

        System.out.println("새로 추가할 음식의 이름을 적어주세요");
        String newFoodName = sc.next();

        for (SubfoodReposity duplicateCheck : food) { //중복되는 음식을 등록하는경우
            if (Objects.equals(duplicateCheck.foodName, newFoodName)) {
                System.out.println("중복되는 음식이 존재합니다 다른 음식을 등록해주세요");
                duplicateNameCheck = true;
                break;
            }
        }
        if (!duplicateNameCheck) { //음식이 중복되지 않고 정상적으로 등록되는경우
            addFood.setFoodName(newFoodName); //set에 문자열을 저장한다

            System.out.println("가격을 적어주세요");
            addFood.setFoodPrice(sc.nextInt());

            System.out.println("음식 이름 : " + addFood.getFoodName() + " \n가격 : " + addFood.getFoodPrice() + "원 \n위 정보가 맞다면 1번을 눌러주세요");
            //addFood set에 저장된것을 get으로 불러들인다
            int check = sc.nextInt();

            if (check == 1) {
                food.add(addFood); //Arraylist에 저장된 get정보들을 추가한다
                System.out.println("안내 : 정상적으로 등록되었습니다");
            } else {
                System.out.println("안내 : 잘못된 입력입니다 다시 시도해주세요");
            }
        }
    }
    public void deleteMenu (ArrayList<SubfoodReposity> food,Scanner sc) { //메뉴삭제
        boolean foodNameCheck = false;

        System.out.println("삭제하고싶은 음식 메뉴 이름을 적어주세요");
        String deleteFoodName = sc.next();

        for (SubfoodReposity findFoodName : food) {
            if (Objects.equals(findFoodName.foodName, deleteFoodName)) {
                System.out.println("정말로 삭제하시겠습니까? \n안내 : 삭제하신 음식 메뉴는 복구 할 수 없습니다 \n 1.삭제 2.취소");
                int deleteChoice = sc.nextInt();
                foodNameCheck = true;

                if (deleteChoice == 1) {
                    System.out.println("안내 : 정상적으로 삭제되었습니다");
                    food.remove(findFoodName);
                    break;
                } else if (deleteChoice == 2) {
                    System.out.println("안내 : 취소를 하였으므로 메인메뉴로 돌아갑니다");
                    break;
                } else {
                    System.out.println("안내 : 잘못된 입력입니다");
                    break;
                }
            }
        }
        if (!foodNameCheck) {
            System.out.println("안내 : 메뉴를 찾지 못하였습니다");
        }
    }
    public void modifyMenu (ArrayList<SubfoodReposity> food,Scanner sc) { //메뉴수정
        boolean changeFoodCheck = false;

        System.out.println("기존의 음식 이름을 적어주세요");
            String inputFoodName = sc.next();

            for (SubfoodReposity findFoodName : food) {
                if (Objects.equals(findFoodName.foodName, inputFoodName)) {

                    System.out.println("1.음식 이름 변경 2.음식 가격 변경");

                    int modifyMenuChoice = sc.nextInt();

                    if (modifyMenuChoice == 1) {
                        System.out.println("새로운 음식 이름을 적어주세요");

                        findFoodName.foodName = sc.next();
                    }
                    else if (modifyMenuChoice == 2) {
                        System.out.println("변동 후 가격을 적어주세요");

                        findFoodName.foodPrice = sc.nextInt();
                    }
                    System.out.println("정상적으로 수정이 완료되었습니다");
                    changeFoodCheck = true;
                    break;
                }
            }
        if (!changeFoodCheck) {
            System.out.println("안내 : 등록되어있지 않은 메뉴입니다");
        }
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