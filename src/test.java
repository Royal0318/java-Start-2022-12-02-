
import java.util.Scanner;

public class test {
    /*
        자료형
        int -> 일반적인 정수형 -> 1,2,3,4,5,6
        문자형
        String -> 문자는 -> ""이렇게 쌍따옴표로 묶어줍니다.


        Scanner sc = new Scanner(System.in);

        System.out.println("이름을 입력하세요 : ");
        String name = sc.next();
        System.out.println("나이를 입력하세요 : ");
        int age = sc.nextInt();


        System.out.println("제 이름은 " + name + "이고, 나이는 " + age + "세입니다.");


        이 회색 공간은 주석이라는 건데,
        컴퓨터가 읽지 못하는 장소라서 메모, 혹은 저희가 했던 걸 넣는 용으로 하시면됩니다.

        지금부터 문제 드릴건데 지금은 초반이니까 위 내용 보면서 만들어보시면되세요 간단한것부터드릴게요





  아래 내용 직접 만들어보시면됩니다!

  아래 문구에서 ?는 모두 입력을 '먼저 받아준' 후,
  아래 문장이 나타날 수 있게 만들어주세요.

  오늘의 날짜는 ?월 ?일입니다.
  제 이름은 ?이고,
  제 나이는 ?세이고,
  제 목표는 ?입니다.















        Scanner sc = new Scanner(System.in);
        System.out.println("오늘은 몇월입니까");
        int day1 = sc.nextInt();
        System.out.println("제 이름은 무엇입니까?");
        String name2 = sc.next();
        System.out.println("나이는 몇살입니까?");
        int day3 = sc.nextInt();
        System.out.println("목표는 무엇입니까?");
        String nane4 = sc.next();

        System.out.println("오늘의 날짜는 "+day1+"입니다");
        System.out.println("제이름은 "+name2+"이고");
        System.out.println("제 나이는 "+day3+"이고");
        System.out.println("제 목표는 "+nane4+"입니다");

        Scanner sc = new Scanner(System.in);

      System.out.println("사람은 누가 있는가?");
      String A = "와";
      System.out.println("음식은 무엇이 있는가?");
      String B = "와";
      String C = "등등";
      System.out.println("음식 가격은 각각 얼마인가?");
      String D = "원";
      int E = 2000;
      int F = 800;
      int G = 1200;
      int H = 6200;
      int I = 2000;
      int J = 3200;
      System.out.println("영희는 철수보다 얼마를 더 지불?");
      String K = "는";
      String L = "보다";
      String N = "지불";
      int M = 7400;




        System.out.println("철수 "+A+" 영희가 쇼핑을 하고있습니다");
        System.out.println("토마토 "+B+" 감자,주스 "+C+" 있습니다");
        System.out.println("토마토는 "+E+""+D+" 감자는 "+F+""+D+" 주스는 "+G+""+D+" 떡은 "+H+""+D+" 마늘은 "+I+""+D+" 양파는 "+J+""+D+"입니다");
        System.out.println("영희"+K+" 철수"+L+" "+M+""+D+" 더 "+N+"했다");














      Scanner sc = new Scanner(System.in);
      System.out.println("사람이름?");
      String A = sc.next();
      String A1 = sc.next();
      String A2 = sc.next();

      System.out.println("각각 km수");
      int B = sc.nextInt();

      System.out.println(""+A+" "+A1+" "+A2+" 가 있다");
      System.out.println("셋의 집은 각각 "+B+"마다 떨어져 있는 거리에 존재한다");
      System.out.println("세명의 집을 차례대로 방문하려면 몇km를 걸어가야 하는가?");


      System.out.println("답은?");

      int C = sc.nextInt();

      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("각각 입력하고싶은 숫자를 입력하세요");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(""+a+"+"+b+"=");
        int answer = sc.nextInt();

        System.out.println("각각의 숫자는 "+a+"와 "+b+"입니다");

        System.out.println(""+a+"와 "+b+"를 더하면 값은?");
        int C = sc.nextInt();
        if (C == answer) {
            System.out.println("정답입니다!");
            System.out.println("다음문제");
            System.out.println(""+a+"와 "+b+"중 어느 값이 더 큽니까?");
            int R = sc.nextInt();

            if (b < R) {
                System.out.println("정답입니다!");
            } else if (b > R) {
                System.out.println("오답입니다! 정답은 "+b+"입니다!");
            } else if (a > R) {
                System.out.println("오답입니다! 정답은 "+a+"입니다!");
            }else {
                System.out.println("정답입니다!");
            }


        }
        if (C != answer) {
            System.out.println("오답입니다 정답은 "+answer+"입니다");
        }
    }
  }



        System.out.println("각각 입력하고싶은 숫자를 입력하세요");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(""+a+"+"+b+"=");
        int answer = sc.nextInt();

        System.out.println("각각의 숫자는 "+a+"와 "+b+"입니다");

        System.out.println(""+a+"와 "+b+"를 더하면 값은?");
        int C = sc.nextInt();
        if (C == answer) {
            System.out.println("정답입니다!");
            System.out.println("다음문제");
            System.out.println(""+a+"와 "+b+"중 어느 값이 더 큽니까?");
            System.out.println("1."+a+"  2."+b+"");
            int R = sc.nextInt();

            if (b < R) {
                    System.out.println("정답입니다!");
                } if (b > R) {
                    System.out.println("오답입니다! 정답은 "+b+"입니다!");
                } if (a > R) {
                    System.out.println("오답입니다! 정답은 "+a+"입니다!");
                }if (a < R){
                    System.out.println("정답입니다!");
            }


        }
        if (C != answer) {
            System.out.println("오답입니다 정답은 "+answer+"입니다");
        }


public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자 입력 : ");
        int num1 = sc.nextInt();
        System.out.println("두 번째 숫자 입력 : ");
        int num2 = sc.nextInt();

        System.out.println(num1 + "+" + num2 + "=");
        int answer = sc.nextInt();

        if (answer == num1 + num2) {
            System.out.println("어떤 숫자가 더 큽니까? 1." + num1 + "  2." + num2);
            int answer2 = sc.nextInt();
            if (answer2 == 1) {
                if (num1 > num2) {
                    System.out.println("정답");
                }
                if (num1 < num2) {
                    System.out.println("오답. 답은 2번입니다.");
                }
            }
            if (answer2 == 2) {
                if (num1 < num2) {
                    System.out.println("정답");
                }
                if (num1 > num2) {
                    System.out.println("오답. 답은 1번입니다.");
                }
            }
        }
        if (answer != num1 + num2) {
            System.out.println("정답은" + (num1 + num2) + "입니다.");




            다시만든거


             public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자를 입력하세요");
        int num1 = sc.nextInt();
        System.out.println("두 번째 숫자를 입력하세요");
        int num2 = sc.nextInt();

        System.out.println("" + num1 + "+" + num2 + "=");
        int answer = sc.nextInt();

        if (answer == num1+num2) {
            System.out.println("어떤 숫자가 더 큽니까?   1." + num1 + "   2." + num2 + "");
            int answer1 = sc.nextInt();
            if (answer1 == 1) {
                if (num1 > num2) {
                    System.out.println("정답입니다!");
                }
                if (num1 < num2) {
                    System.out.println("오답입니다! 정답은  2번 입니다");
                }
            }
                if (answer1 == 2) {
                    if (num1 < num2) {
                        System.out.println("정답입니다!");
                    }
                    if (num1 > num2) {
                        System.out.println("오답입니다! 정답은 1번 입니다");
                    }
                }
        }
        if (answer != num1 + num2) {
            System.out.println("오답입니다 정답은 "+(num1+num2)+"입니다");
        }
    }
}




       Scanner sc = new Scanner(System.in);
       int answer = sc.nextInt();

       if (answer >= 91 && answer <= 100) {
           System.out.println("A입니다");
       } else if (answer >= 81) {
           System.out.println("B입니다");
       } else if (answer >=71) {
           System.out.println("C입니다");
       } else if (answer >=70 && answer <=0) {
           System.out.println("D입니다");
       }


 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("추가 할 철수와 영희의 용돈을 입력하세요");
        int money = sc.nextInt() + 10000;

        System.out.println("현재 철수와 영희의 용돈은 총 " + money + "원이 있습니다");

        System.out.println("떡볶이,우동,과자,음료수,껌의 가격을 각각 적으세요");
        int food1 = sc.nextInt();
        System.out.println("떡볶이 가격은 "+food1+"원입니다");
        int food2 = sc.nextInt();
        System.out.println("우동 가격은 "+food2+"원입니다");
        int food3 = sc.nextInt();
        System.out.println("과자 가격은 "+food3+"원입니다");
        int food4 = sc.nextInt();
        System.out.println("음료수 가격은 "+food4+"원입니다");
        int food5 = sc.nextInt();
        System.out.println("껌 가격은 "+food5+"원입니다");

        System.out.println("떡볶이 가격은 "+food1+"원, 우동 가격은 "+food2+"원, 과자 가격은 "+food3+"원 음료수 가격은 "+food4+"원 껌 가격은 "+food5+"원 입니다");
        System.out.println("떡볶이를 몇개 주문하시겠습니까?");
        int answer = sc.nextInt();
        int a = answer * food1;
        if (money > a) {
            int left = (money - a);
            System.out.println("떡볶이 가격은 " + a + "원이고 남은 금액은 " + left + "원 입니다 ");

            System.out.println("우동은 몇개 주문하시겠습니까?");
            int answer2 = sc.nextInt();
            int i = answer2 * food2;
            int left2 = (left - i);
            System.out.println("우동 가격은 " + i + "원이고 남은 금액은 " + left2 + "원 입니다");

            System.out.println("과자를 몇개 주문하시겠습니까?");
            int answer3 = sc.nextInt();
            int j = answer3 * food3;
            int left3 = (left2 - j);
            System.out.println("우동 가격은 " + j + "원이고 남은 금액은 " + left3 + "원 입니다");

            System.out.println("음료수는 몇개 주문하시겠습니까?");
            int answer4 = sc.nextInt();
            int k = answer4 * food4;
            int lest4 = (left3 - k);
            System.out.println("과자 가격은 " + k + "원이고 남은 금액은 " + lest4 + "원 입니다");

            System.out.println("껌는 몇개 주문하시겠습니까?");
            int answer5 = sc.nextInt();
            int l = answer5 * food5;
            int lest5 = (lest4 - k);
            System.out.println("과자 가격은 " + l + "원이고 남은 금액은 " + lest5 + "원 입니다");
        }
        if (a > money) {
            System.out.println("돈이 부족합니다 얼마를 받으시겠습니까?");
            int money2 = sc.nextInt();
            int money3 = money + money2 - a;
            System.out.println("추가 용돈 " + money2 + "원을 받아 총 " + ((money + money2) - a) + "원이 되었습니다");

            System.out.println("우동은 몇개 주문하시겠습니까?");
            int answer2 = sc.nextInt();
            int i = answer2 * food2;
            if (money3 > i) {
                int left2 = (money3 - i);
                System.out.println("우동 가격은 " + i + "원이고 남은 금액은 " + left2 + "원 입니다");

                System.out.println("과자를 몇개 주문하시겠습니까?");
                int answer3 = sc.nextInt();
                int j = answer3 * food3;
                if (left2 > j) {
                    int left3 = (left2 - j);
                    System.out.println("우동 가격은 " + j + "원이고 남은 금액은 " + left3 + "원 입니다");

                    System.out.println("음료수는 몇개 주문하시겠습니까?");
                    int answer4 = sc.nextInt();
                    int k = answer4 * food4;
                    if (left3 > k) {
                        int lest4 = (left3 - k);
                        System.out.println("과자 가격은 " + k + "원이고 남은 금액은 " + lest4 + "원 입니다");

                        System.out.println("껌는 몇개 주문하시겠습니까?");
                        int answer5 = sc.nextInt();
                        int l = answer5 * food5;
                        if (lest4 > l) {
                            int lest5 = (lest4 - k);
                            System.out.println("과자 가격은 " + l + "원이고 남은 금액은 " + lest5 + "원 입니다");
                        }
                        if (lest4 < l) {
                            System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                        }
                       }
                    if (left3 < k) {
                        System.out.println("돈이 부족하여 주인장에게 쭂겨났습니다");
                    }
                   }
                 if (left2 < j) {
                    System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                 }
                }
            if (i > money3) {
                System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
            }
        }
    }
}




 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("a값을 정하세요");
        int a = sc.nextInt();
        if (5000 <= a || a <= 10000) {
            System.out.println("a값은 " + a + "입니다");

            System.out.println("b값을 정하세요");
            int b = sc.nextInt();
                if (b >= 4000 ) {
                    System.out.println("b값은 " + b + "입니다");
                    if (b > a) {
                        System.out.println("c값은 " + (a + b) + "입니다");
                    }
                }

            if (b < a) {
                int c = (a + b)-300;
                int d = a + b + c;
                System.out.println("c값은 "+c+"입니다");
                System.out.println("문제)d값은 a+b+c를 합한 값입니다 얼마입니까?");
                int answer = sc.nextInt();
                if (answer == d) {
                    System.out.println("정답입니다 d값은 "+d+"입니다");
                    System.out.println("e값은 a+b+c 값의 3배보다 작게 작성하세요");
                    int e = sc.nextInt();
                    if (3 * d > e) {
                        System.out.println("입력한 값은 "+e+"입니다 f값은 abcde를 합친 숫자보다 5000이 더 큽니다 얼마입니까");
                        int f = sc.nextInt();
                        if (d + e < f + 5000) {
                            System.out.println("g값은 f값의 2배입니다 얼마입니까?");
                            int g = sc.nextInt();
                            if (g == 2 * f) {
                                System.out.println("정답입니다! 수고하셨습니다");
                            }
                            if (g != 2 * f) {
                                System.out.println("틀렸습니다 정답은 "+(2 * f)+"입니다");
                            }
                        }
                        if (d + e > f + 5000) {
                            System.out.println("틀렸습니다 다시하세요");
                        }
                    }
                    if (3 * d < e) {
                        System.out.println("틀렸습니다 다시하세요");
                    }
                }
                if (answer != d) {
                    System.out.println("틀렸습니다 정답은 "+d+"입니다");
                }
                }
            if (b < 4000) {
                System.out.println("b값이 잘못되었습니다 다시하세요");
            }
            if (5000 > a || a > 10000) {
                System.out.println("a값이 잘못되었습니다 다시하세요");
            }
        }
    }
}

   Scanner sc = new Scanner(System.in);
        System.out.println("추가 할 철수와 영희의 용돈을 입력하세요");
        int money = sc.nextInt() + 10000;

        System.out.println("현재 철수와 영희의 용돈은 총 " + money + "원이 있습니다");

        System.out.println("떡볶이,우동,과자,음료수,껌의 가격을 각각 적으세요");
        int food1 = sc.nextInt();
        System.out.println("떡볶이 가격은 "+food1+"원입니다");
        int food2 = sc.nextInt();
        System.out.println("우동 가격은 "+food2+"원입니다");
        int food3 = sc.nextInt();
        System.out.println("과자 가격은 "+food3+"원입니다");
        int food4 = sc.nextInt();
        System.out.println("음료수 가격은 "+food4+"원입니다");
        int food5 = sc.nextInt();
        System.out.println("껌 가격은 "+food5+"원입니다");

        System.out.println("떡볶이 가격은 "+food1+"원, 우동 가격은 "+food2+"원, 과자 가격은 "+food3+"원 음료수 가격은 "+food4+"원 껌 가격은 "+food5+"원 입니다");
        System.out.println("떡볶이를 몇개 주문하시겠습니까?");
        int answer = sc.nextInt();
        int a = answer * food1;
        if (money > a) {
            int left = (money - a);
            System.out.println("떡볶이 가격은 " + a + "원이고 남은 금액은 " + left + "원 입니다 ");

            System.out.println("우동은 몇개 주문하시겠습니까?");
            int answer2 = sc.nextInt();
            int i = answer2 * food2;
            int left2 = (left - i); {
            System.out.println("우동 가격은 " + i + "원이고 남은 금액은 " + left2 + "원 입니다");

            System.out.println("과자를 몇개 주문하시겠습니까?");
            int answer3 = sc.nextInt();
            int j = answer3 * food3;
            int left3 = (left2 - j);
            System.out.println("우동 가격은 " + j + "원이고 남은 금액은 " + left3 + "원 입니다");

            System.out.println("음료수는 몇개 주문하시겠습니까?");
            int answer4 = sc.nextInt();
            int k = answer4 * food4;
            int lest4 = (left3 - k);
            System.out.println("과자 가격은 " + k + "원이고 남은 금액은 " + lest4 + "원 입니다");

            System.out.println("껌는 몇개 주문하시겠습니까?");
            int answer5 = sc.nextInt();
            int l = answer5 * food5;
            int lest5 = (lest4 - k);
            System.out.println("과자 가격은 " + l + "원이고 남은 금액은 " + lest5 + "원 입니다");

        }
        if (a >= money) {
            System.out.println("돈이 부족합니다 얼마를 받으시겠습니까?");
            int money2 = sc.nextInt();
            int money3 = money + money2 - a;
            System.out.println("추가 용돈 " + money2 + "원을 받아 총 " + ((money + money2) - a) + "원이 되었습니다");

            System.out.println("우동은 몇개 주문하시겠습니까?");
            int answer2 = sc.nextInt();
            int i = answer2 * food2;
            if (money3 > i) {
                int left2 = (money3 - i);
                System.out.println("우동 가격은 " + i + "원이고 남은 금액은 " + left2 + "원 입니다");

                System.out.println("과자를 몇개 주문하시겠습니까?");
                int answer3 = sc.nextInt();
                int j = answer3 * food3;
                if (left2 > j) {
                    int left3 = (left2 - j);
                    System.out.println("우동 가격은 " + j + "원이고 남은 금액은 " + left3 + "원 입니다");

                    System.out.println("음료수는 몇개 주문하시겠습니까?");
                    int answer4 = sc.nextInt();
                    int k = answer4 * food4;
                    if (left3 > k) {
                        int lest4 = (left3 - k);
                        System.out.println("과자 가격은 " + k + "원이고 남은 금액은 " + lest4 + "원 입니다");

                        System.out.println("껌는 몇개 주문하시겠습니까?");
                        int answer5 = sc.nextInt();
                        int l = answer5 * food5;
                        if (lest4 > l) {
                            int lest5 = (lest4 - k);
                            System.out.println("과자 가격은 " + l + "원이고 남은 금액은 " + lest5 + "원 입니다");
                        }
                        if (lest4 < l) {
                            System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                        }
                    }
                    if (left3 < k) {
                        System.out.println("돈이 부족하여 주인장에게 쭂겨났습니다");
                    }
                }
                if (left2 < j) {
                    System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                }
            }
            if (i > money3) {
                System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
            }
        }

    }


        System.out.println("1.감자 2.옥수수 3.수박 중에서 한가지를 고르세요");
        int answer = sc.nextInt();
        int answer2 = 1;
        int answer3 = 2;
        int answer4 = 3;
        if (answer == answer2) {
            System.out.println("" + answer + "번 감자를 선택하셨습니다");
            System.out.println("감자를 얼마어치 구매하시겠습니까? 1.1000원어치 2.2000원어치 3.3000원어치");
            int answer5 = sc.nextInt();
            int q = 1000;
            int w = 2000;
            int r = 3000;

            if (answer2 == answer5) {
                System.out.println("감자를 1000원 어치 선택하셨습니다");
                System.out.println("몇개 주문하시겠습니까?");
                int a = sc.nextInt();
                System.out.println("총 가격은 " + (a * q) + "원입니다");
            }
            if (answer3 == answer5) {
                System.out.println("감자를 2000원 어치 선택하셨습니다");
                System.out.println("몇개 주문하시겠습니까?");
                int b = sc.nextInt();
                System.out.println("총 가격은 " + (b * w) + "원입니다");
            }
            if (answer4 == answer5) {
                System.out.println("감자를 3000원 어치 선택하셨습니다");
                System.out.println("몇개 주문하시겠습니까?");
                int c = sc.nextInt();
                System.out.println("총 가격은 " + (c * r) + "원입니다");
            }
        }
        if (answer3 == answer) {
            System.out.println("" + answer + "번 옥수수를 선택하셨습니다");
            System.out.println("옥수수를 얼마어치 구매하시겠습니까? 1.4000원어치 2.5000원어치 3.6000원어치");
            int answer6 = sc.nextInt();
            int t = 4000;
            int y = 5000;
            int u = 6000;
            if (answer2 == answer6) {
                System.out.println("옥수수를 4000원 어치 선택하셨습니다");
                System.out.println("몇개 주문하시겠습니까?");
                int d = sc.nextInt();
                System.out.println("총 가격은 " + (d * t) + "원입니다");
            }
            if (answer3 == answer6) {
                System.out.println("옥수수를 5000원 어치 선택하셨습니다");
                System.out.println("몇개 주문하시겠습니까?");
                int e = sc.nextInt();
                System.out.println("총 가격은 " + (e * y) + "원입니다");
            }
            if (answer4 == answer6) {
                System.out.println("옥수수를 6000원 어치 선택하셨습니다");
                System.out.println("몇개 주문하시겠습니까?");
                int f = sc.nextInt();
                System.out.println("총 가격은 " + (f * u) + "원입니다");
            }

        }
        if (answer == answer4) {
            System.out.println("" + answer + "번 수박를 선택하셨습니다");
            System.out.println("수박를 얼마어치 구매하시겠습니까? 1.10000원어치 2.20000원어치 3.30000원어치");
            int answer7 = sc.nextInt();
            int z = 10000;
            int x = 20000;
            int m = 30000;
            if (answer2 == answer7) {
                System.out.println("수박를 10000원 어치 선택하셨습니다");
                System.out.println("몇개 주문하시겠습니까?");
                int g = sc.nextInt();
                System.out.println("총 가격은 " + (g * z) + "원입니다");
            }
            if (answer3 == answer7) {
                System.out.println("수박를 20000원 어치 선택하셨습니다");
                System.out.println("몇개 주문하시겠습니까?");
                int h = sc.nextInt();
                System.out.println("총 가격은 " + (h * x) + "원입니다");
            }
            if (answer4 == answer7) {
                System.out.println("수박를 30000원 어치 선택하셨습니다");
                System.out.println("몇개 주문하시겠습니까?");
                int j = sc.nextInt();
                System.out.println("총 가격은 " + (j * m) + "원입니다");
            }
        }
    }

}





public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = foodSelect();
        System.out.println(sum);
    }
    public static int foodSelect() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.감자 2.옥수수 3.수박 중에서 한가지를 고르세요");
        int select = sc.nextInt();
        if (select == 1) {
            return foodSelect2("감자",1000);
        }
        if (select == 2) {
            return foodSelect2("옥수수",2000);
        }
        if (select == 3) {
            return foodSelect2("수박",3000);
        }
        return 0;
    }
    public static int foodSelect2(String food, int price) {
        return 9;
    }
}


public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("추가 할 철수와 영희의 용돈을 입력하세요");
        int money = sc.nextInt() + 10000;

        System.out.println("현재 철수와 영희의 용돈은 총 " + money + "원이 있습니다");

        System.out.println("떡볶이,우동,과자,음료수,껌의 가격을 각각 적으세요");
        int food1 = sc.nextInt();
        System.out.println("떡볶이 가격은 " + food1 + "원입니다");
        int food2 = sc.nextInt();
        System.out.println("우동 가격은 " + food2 + "원입니다");
        int food3 = sc.nextInt();
        System.out.println("과자 가격은 " + food3 + "원입니다");
        int food4 = sc.nextInt();
        System.out.println("음료수 가격은 " + food4 + "원입니다");
        int food5 = sc.nextInt();
        System.out.println("껌 가격은 " + food5 + "원입니다");

        System.out.println("떡볶이 가격은 " + food1 + "원, 우동 가격은 " + food2 + "원, 과자 가격은 " + food3 + "원 음료수 가격은 " + food4 + "원 껌 가격은 " + food5 + "원 입니다");
        System.out.println("떡볶이를 몇개 주문하시겠습니까?");
        int answer = sc.nextInt();
        int a = answer * food1;
        if (money > a) {
            int left = (money - a);
            System.out.println("떡볶이 가격은 " + a + "원이고 남은 금액은 " + left + "원 입니다 ");

            System.out.println("우동은 몇개 주문하시겠습니까?");
            int answer2 = sc.nextInt();
            int i = answer2 * food2;
            if (left > i) {
                int left2 = (left - i);
                System.out.println("우동 가격은 " + i + "원이고 남은 금액은 " + left2 + "원 입니다");

                System.out.println("과자를 몇개 주문하시겠습니까?");
                int answer3 = sc.nextInt();
                int j = answer3 * food3;
                if (left2 > j) {
                    int left3 = (left2 - j);
                    System.out.println("과자 가격은 " + j + "원이고 남은 금액은 " + left3 + "원 입니다");

                    System.out.println("음료수는 몇개 주문하시겠습니까?");
                    int answer4 = sc.nextInt();
                    int k = answer4 * food4;
                    if (left3 > k) {
                        int lest4 = (left3 - k);
                        System.out.println("음료수 가격은 " + k + "원이고 남은 금액은 " + lest4 + "원 입니다");

                        System.out.println("껌는 몇개 주문하시겠습니까?");
                        int answer5 = sc.nextInt();
                        int l = answer5 * food5;
                        if (lest4 > l) {
                            int lest5 = (lest4 - k);
                            System.out.println("껌 가격은 " + l + "원이고 남은 금액은 " + lest5 + "원 입니다");
                        }
                        if (l >= lest4) { //껌 먹을 돈이 부족할때
                            System.out.println("돈이 부족합니다 얼마를 받으시겠습니까?");
                            int money2 = sc.nextInt();
                            int money3 = lest4 + money2 - l;
                            System.out.println("추가 용돈 " + money2 + "원을 받아 총 " + money3 + "원이 되었습니다");
                            System.out.println("껌은 몇개 주문하시겠습니까?");
                            int v = sc.nextInt();
                            int n = v * food5;
                            if (money3 > n) {
                                System.out.println("구매에 성공하셨습니다");
                            }
                            if (money3 < n) {
                                System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                            }
                        }
                    }
                    if (k >= left3) { //음료수 먹을 돈이 부족할때
                        System.out.println("돈이 부족합니다 얼마를 받으시겠습니까?");
                        int money2 = sc.nextInt();
                        int money3 = left3 + money2 - k;
                        System.out.println("추가 용돈 " + money2 + "원을 받아 총 " + money3 + "원이 되었습니다");

                        System.out.println("음료수는 몇개 주문하시겠습니까?");
                        int answer10 = sc.nextInt();
                        int t = answer10 * food4;
                        if (money3 > k) {
                            int lest3 = (money3 - t);
                            System.out.println("음료수 가격은 " + t + "원이고 남은 금액은 " + lest3 + "원 입니다");

                            System.out.println("껌는 몇개 주문하시겠습니까?");
                            int answer11 = sc.nextInt();
                            int r = answer11 * food5;
                            if (lest3 > r) {
                                int lest6 = (lest3 - r);
                                System.out.println("껌 가격은 " + r + "원이고 남은 금액은 " + lest6 + "원 입니다");
                            }
                            if (lest3 < r) {
                                System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                            }
                        }
                        if (money3 < k) {
                            System.out.println("돈이 부족하여 주인장에게 쭂겨났습니다");
                        }
                    }
                }
                if (j >= left2) { //과자먹을 돈이 부족할때
                    System.out.println("돈이 부족합니다 얼마를 받으시겠습니까?");
                    int money2 = sc.nextInt();
                    int money3 = left2 + money2 - j;
                    System.out.println("추가 용돈 " + money2 + "원을 받아 총 " + money3 + "원이 되었습니다");

                    System.out.println("음료수는 몇개 주문하시겠습니까?");
                    int answer4 = sc.nextInt();
                    int k = answer4 * food4;
                    if (money3 > k) {
                        int lest3 = (money3 - k);
                        System.out.println("음료수 가격은 " + k + "원이고 남은 금액은 " + lest3 + "원 입니다");

                        System.out.println("껌는 몇개 주문하시겠습니까?");
                        int answer5 = sc.nextInt();
                        int l = answer5 * food5;
                        if (lest3 > l) {
                            int lest4 = (lest3 - l);
                            System.out.println("과자 가격은 " + l + "원이고 남은 금액은 " + lest4 + "원 입니다");
                        }
                        if (lest3 < l) {
                            System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                        }
                    }
                    if (money3 < k) {
                        System.out.println("돈이 부족하여 주인장에게 쭂겨났습니다");
                    }
                }

            }
            if (i >= left) { //우동 먹을돈이부족할때
                System.out.println("돈이 부족합니다 얼마를 받으시겠습니까?");
                int money2 = sc.nextInt();
                int money3 = left + money2 - i;
                System.out.println("추가 용돈 " + money2 + "원을 받아 총 " + money3 + "원이 되었습니다");

                System.out.println("과자를 몇개 주문하시겠습니까?");
                int answer8 = sc.nextInt();
                int u = answer8 * food3;
                if (left > u) {
                    int left5 = (money3 - u);
                    System.out.println("과자 가격은 " + u + "원이고 남은 금액은 " + left5 + "원 입니다");

                    System.out.println("음료수는 몇개 주문하시겠습니까?");
                    int answer4 = sc.nextInt();
                    int k = answer4 * food4;
                    if (left5 > k) {
                        int lest3 = (left5 - k);
                        System.out.println("음료수 가격은 " + k + "원이고 남은 금액은 " + lest3 + "원 입니다");

                        System.out.println("껌는 몇개 주문하시겠습니까?");
                        int answer5 = sc.nextInt();
                        int l = answer5 * food5;
                        if (lest3 > l) {
                            int lest4 = (lest3 - l);
                            System.out.println("껌 가격은 " + l + "원이고 남은 금액은 " + lest4 + "원 입니다");
                        }
                        if (lest3 < l) {
                            System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                        }
                    }
                    if (left5 < k) {
                        System.out.println("돈이 부족하여 주인장에게 쭂겨났습니다");
                    }
                }
                if (left < u) {
                    System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                }
            }
        }
        if (a >= money) { //떡볶이 먹을돈이 부족할때
            System.out.println("돈이 부족합니다 얼마를 받으시겠습니까?");
            int money2 = sc.nextInt();
            int money3 = money + money2 - a;
            System.out.println("추가 용돈 " + money2 + "원을 받아 총 " + money3 + "원이 되었습니다");

            System.out.println("우동은 몇개 주문하시겠습니까?");
            int answer4 = sc.nextInt();
            int p = answer4 * food2;
            if (money3 > p) {
                int left2 = (money3 - p);
                System.out.println("우동 가격은 " + p + "원이고 남은 금액은 " + left2 + "원 입니다");

                System.out.println("과자를 몇개 주문하시겠습니까?");
                int answer3 = sc.nextInt();
                int j = answer3 * food3;
                if (left2 > j) {
                    int left3 = (left2 - j);
                    System.out.println("과자 가격은 " + j + "원이고 남은 금액은 " + left3 + "원 입니다");

                    System.out.println("음료수는 몇개 주문하시겠습니까?");
                    int answer6 = sc.nextInt();
                    int k = answer6 * food4;
                    if (left3 > k) {
                        int lest4 = (left3 - k);
                        System.out.println("음료수 가격은 " + k + "원이고 남은 금액은 " + lest4 + "원 입니다");

                        System.out.println("껌는 몇개 주문하시겠습니까?");
                        int answer5 = sc.nextInt();
                        int l = answer5 * food5;
                        if (lest4 > l) {
                            int lest5 = (lest4 - k);
                            System.out.println("껌 가격은 " + l + "원이고 남은 금액은 " + lest5 + "원 입니다");
                        }
                        if (lest4 < l) {
                            System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                        }
                    }
                    if (left3 < k) {
                        System.out.println("돈이 부족하여 주인장에게 쭂겨났습니다");
                    }
                }
                if (left2 < j) {
                    System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                }
            }
            if (p > money3) {
                System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
            }
        }
    }
}













        if (money > a) {
            int left = (money - a);
            System.out.println("떡볶이 가격은 " + a + "원이고 남은 금액은 " + left + "원 입니다 ");

            System.out.println("우동은 몇개 주문하시겠습니까?");
            int answer2 = sc.nextInt();
            int i = answer2 * food2;
            if (left > i) {
                int left2 = (left - i);
                System.out.println("우동 가격은 " + i + "원이고 남은 금액은 " + left2 + "원 입니다");

                System.out.println("과자를 몇개 주문하시겠습니까?");
                int answer3 = sc.nextInt();
                int j = answer3 * food3;
                if (left2 > j) {
                    int left3 = (left2 - j);
                    System.out.println("과자 가격은 " + j + "원이고 남은 금액은 " + left3 + "원 입니다");

                    System.out.println("음료수는 몇개 주문하시겠습니까?");
                    int answer4 = sc.nextInt();
                    int k = answer4 * food4;
                    if (left3 > k) {
                        int lest4 = (left3 - k);
                        System.out.println("음료수 가격은 " + k + "원이고 남은 금액은 " + lest4 + "원 입니다");

                        System.out.println("껌는 몇개 주문하시겠습니까?");
                        int answer5 = sc.nextInt();
                        int l = answer5 * food5;
                        if (lest4 > l) {
                            int lest5 = (lest4 - k);
                            System.out.println("껌 가격은 " + l + "원이고 남은 금액은 " + lest5 + "원 입니다");
                        }
                        if (l >= lest4) { //껌 먹을 돈이 부족할때
                            System.out.println("돈이 부족합니다 얼마를 받으시겠습니까?");
                            int money2 = sc.nextInt();
                            int money3 = lest4 + money2 - l;
                            System.out.println("추가 용돈 " + money2 + "원을 받아 총 " + money3 + "원이 되었습니다");
                            System.out.println("껌은 몇개 주문하시겠습니까?");
                            int v = sc.nextInt();
                            int n = v * food5;
                            if (money3 > n) {
                                System.out.println("구매에 성공하셨습니다");
                            }
                            if (money3 < n) {
                                System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                            }
                        }
                    }
                    if (k >= left3) { //음료수 먹을 돈이 부족할때
                        System.out.println("돈이 부족합니다 얼마를 받으시겠습니까?");
                        int money2 = sc.nextInt();
                        int money3 = left3 + money2 - k;
                        System.out.println("추가 용돈 " + money2 + "원을 받아 총 " + money3 + "원이 되었습니다");

                        System.out.println("음료수는 몇개 주문하시겠습니까?");
                        int answer10 = sc.nextInt();
                        int t = answer10 * food4;
                        if (money3 > k) {
                            int lest3 = (money3 - t);
                            System.out.println("음료수 가격은 " + t + "원이고 남은 금액은 " + lest3 + "원 입니다");

                            System.out.println("껌는 몇개 주문하시겠습니까?");
                            int answer11 = sc.nextInt();
                            int r = answer11 * food5;
                            if (lest3 > r) {
                                int lest6 = (lest3 - r);
                                System.out.println("껌 가격은 " + r + "원이고 남은 금액은 " + lest6 + "원 입니다");
                            }
                            if (lest3 < r) {
                                System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                            }
                        }
                        if (money3 < k) {
                            System.out.println("돈이 부족하여 주인장에게 쭂겨났습니다");
                        }
                    }
                }
                if (j >= left2) { //과자먹을 돈이 부족할때
                    System.out.println("돈이 부족합니다 얼마를 받으시겠습니까?");
                    int money2 = sc.nextInt();
                    int money3 = left2 + money2 - j;
                    System.out.println("추가 용돈 " + money2 + "원을 받아 총 " + money3 + "원이 되었습니다");

                    System.out.println("음료수는 몇개 주문하시겠습니까?");
                    int answer4 = sc.nextInt();
                    int k = answer4 * food4;
                    if (money3 > k) {
                        int lest3 = (money3 - k);
                        System.out.println("음료수 가격은 " + k + "원이고 남은 금액은 " + lest3 + "원 입니다");

                        System.out.println("껌는 몇개 주문하시겠습니까?");
                        int answer5 = sc.nextInt();
                        int l = answer5 * food5;
                        if (lest3 > l) {
                            int lest4 = (lest3 - l);
                            System.out.println("과자 가격은 " + l + "원이고 남은 금액은 " + lest4 + "원 입니다");
                        }
                        if (lest3 < l) {
                            System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                        }
                    }
                    if (money3 < k) {
                        System.out.println("돈이 부족하여 주인장에게 쭂겨났습니다");
                    }
                }

            }
            if (i >= left) { //우동 먹을돈이부족할때
                System.out.println("돈이 부족합니다 얼마를 받으시겠습니까?");
                int money2 = sc.nextInt();
                int money3 = left + money2 - i;
                System.out.println("추가 용돈 " + money2 + "원을 받아 총 " + money3 + "원이 되었습니다");

                System.out.println("과자를 몇개 주문하시겠습니까?");
                int answer8 = sc.nextInt();
                int u = answer8 * food3;
                if (left > u) {
                    int left5 = (money3 - u);
                    System.out.println("과자 가격은 " + u + "원이고 남은 금액은 " + left5 + "원 입니다");

                    System.out.println("음료수는 몇개 주문하시겠습니까?");
                    int answer4 = sc.nextInt();
                    int k = answer4 * food4;
                    if (left5 > k) {
                        int lest3 = (left5 - k);
                        System.out.println("음료수 가격은 " + k + "원이고 남은 금액은 " + lest3 + "원 입니다");

                        System.out.println("껌는 몇개 주문하시겠습니까?");
                        int answer5 = sc.nextInt();
                        int l = answer5 * food5;
                        if (lest3 > l) {
                            int lest4 = (lest3 - l);
                            System.out.println("껌 가격은 " + l + "원이고 남은 금액은 " + lest4 + "원 입니다");
                        }
                        if (lest3 < l) {
                            System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                        }
                    }
                    if (left5 < k) {
                        System.out.println("돈이 부족하여 주인장에게 쭂겨났습니다");
                    }
                }
                if (left < u) {
                    System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                }
            }
        }
        if (a >= money) { //떡볶이 먹을돈이 부족할때
            System.out.println("돈이 부족합니다 얼마를 받으시겠습니까?");
            int money2 = sc.nextInt();
            int money3 = money + money2 - a;
            System.out.println("추가 용돈 " + money2 + "원을 받아 총 " + money3 + "원이 되었습니다");

            System.out.println("우동은 몇개 주문하시겠습니까?");
            int answer4 = sc.nextInt();
            int p = answer4 * food2;
            if (money3 > p) {
                int left2 = (money3 - p);
                System.out.println("우동 가격은 " + p + "원이고 남은 금액은 " + left2 + "원 입니다");

                System.out.println("과자를 몇개 주문하시겠습니까?");
                int answer3 = sc.nextInt();
                int j = answer3 * food3;
                if (left2 > j) {
                    int left3 = (left2 - j);
                    System.out.println("과자 가격은 " + j + "원이고 남은 금액은 " + left3 + "원 입니다");

                    System.out.println("음료수는 몇개 주문하시겠습니까?");
                    int answer6 = sc.nextInt();
                    int k = answer6 * food4;
                    if (left3 > k) {
                        int lest4 = (left3 - k);
                        System.out.println("음료수 가격은 " + k + "원이고 남은 금액은 " + lest4 + "원 입니다");

                        System.out.println("껌는 몇개 주문하시겠습니까?");
                        int answer5 = sc.nextInt();
                        int l = answer5 * food5;
                        if (lest4 > l) {
                            int lest5 = (lest4 - k);
                            System.out.println("껌 가격은 " + l + "원이고 남은 금액은 " + lest5 + "원 입니다");
                        }
                        if (lest4 < l) {
                            System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                        }
                    }
                    if (left3 < k) {
                        System.out.println("돈이 부족하여 주인장에게 쭂겨났습니다");
                    }
                }
                if (left2 < j) {
                    System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
                }
            }
            if (p > money3) {
                System.out.println("돈이 부족하여 주인장에게 쫒겨났습니다");
            }
        }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            System.out.println("키(cm)를 적으세요");
            float answer = sc.nextInt();
            answer = (answer / 100);
            System.out.println("체중(kg)을 적으세요");
            float answer2 = sc.nextInt();
            float answer3 = (answer * answer);
//키는cm인데 m로 환산해야하니까 나눠야함 그런데 int로 명령어를 해서 쳤을시 계산값이 이상하게나옴
        //소수점 1.1333까지 고려하려면 float 또는 더블을 사용한다 ex) double a = 1.133d;  or float answer
        //a변수는 int 타입이므로 1.85나 1.64로 저장되지않고 그냥 1이됩니다. (정수 타입이니)
        float bmi = (answer2 / answer3);

            if (30 <= bmi) {
            System.out.println("고도비만이며 bmi지수는 "+bmi+"입니다");
        } else if (25 <= bmi && 29 <= bmi) {
            System.out.println("비만이며 bmi지수는 "+bmi+"입니다");
        } else if (23 <= bmi && 24 <= bmi) {
            System.out.println("과체중이며 bmi지수는"+bmi+"입니다");
        } else if (18.5 <= bmi && 22 >= bmi) {
            System.out.println("정상이며 bmi지수는"+bmi+"입니다");
        } else System.out.println("저체중이며 bmi지수는"+bmi+"입니다");
    }
}


//BMI 지수의 계산식 -> BMI = 체중(kg) / (키(m) * 키(m))//






//////////////////////숙제////////////////////////////////

 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("첫 번째 사람을 입력하세요");
        String answer = sc.next();
        System.out.println("" + answer + "의 점수를 입력하세요");
        int num = sc.nextInt();

        System.out.println("두 번째 사람을 입력하세요");
        String answer2 = sc.next();
        System.out.println("" + answer2 + "의 점수를 입력하세요");
        int num2 = sc.nextInt();

        System.out.println("세 번째 사람을 입력하세요");
        String answer3 = sc.next();
        System.out.println("" + answer3 + "의 점수를 입력하세요");
        int num3 = sc.nextInt();

        System.out.println("네 번째 사람을 입력하세요");
        String answer4 = sc.next();
        System.out.println("" + answer4 + "의 점수를 입력하세요");
        int num4 = sc.nextInt();


        System.out.println("" + answer + "의 점수는" + num + "점 \n" + answer2 + "의 점수는" + num2 + "점 \n" + answer3 + "의 점수는" + num3 + "점 \n" + answer4 + "의 점수는" + num4 + "점 입니다");

        System.out.println("1." + answer + "\n2." + answer2 + "\n3." + answer3 + "\n4." + answer4 + "\n5.시스템 종료");


        while (true) {
            System.out.println("누구와 누구를 대조하시겠습니까?(대조할 2명의 번호를 입력하세요)");
            int num5 = sc.nextInt();
            int num6 = sc.nextInt();

            if (num5 == 1 && num6 == 2) {                                            //num5가 1일때//
                if (num > num2) { //1이 2보다 큰경우
                    System.out.println("" + answer + "가" + answer2 + "보다 더 큽니다");
                }
            }
            if (num5 == 1 && num6 == 2) {                                            //num5가 1일때//
                if (num < num2) { //1이 2보다 작은경우
                    System.out.println("" + answer + "가" + answer2 + "보다 더 작습니다");
                }
            }
            if (num5 == 1 && num6 == 2) {                                            //num5가 1일때//
                if (num == num2) { //둘이 같은경우
                    System.out.println("둘이 같습니다");
                }
            }

            if (num5 == 1 && num6 == 3) {                                            //num5가 1일때//
                if (num > num3) { //1이 3보다 큰경우
                    System.out.println("" + answer + "가" + answer3 + "보다 더 큽니다");
                }
            }
            if (num5 == 1 && num6 == 3) {                                            //num5가 1일때//
                if (num < num3) { //1이 3보다 작은경우
                    System.out.println("" + answer + "가" + answer3 + "보다 더 작습니다");
                }
            }
            if (num5 == 1 && num6 == 3) {                                            //num5가 1일때//
                if (num == num3) { //둘이 같은경우
                    System.out.println("둘이 같습니다");
                }
            }



            if (num5 == 1 && num6 == 4) {                                            //num5가 1일때//
                if (num > num4) { //1이 4보다 큰경우
                    System.out.println("" + answer + "가" + answer4 + "보다 더 큽니다");
                }
            }
            if (num5 == 1 && num6 == 4) {                                            //num5가 1일때//
                if (num < num4) { //1이 3보다 작은경우
                    System.out.println("" + answer + "가" + answer4 + "보다 더 작습니다");
                }
            }
            if (num5 == 1 && num6 == 4) {                                            //num5가 1일때//
                if (num == num4) { //둘이 같은경우
                    System.out.println("둘이 같습니다");
                }
            }

            if (num5 == 2 && num6 == 1) {                                            //num5가 2일때//
                if (num2 > num) { //1이 4보다 큰경우
                    System.out.println("" + answer2 + "가" + answer + "보다 더 큽니다");
                }
            }
            if (num5 == 2 && num6 == 1) {                                            //num5가 2일때//
                if (num2 < num) { //1이 3보다 작은경우
                    System.out.println("" + answer2 + "가" + answer + "보다 더 작습니다");
                }
            }
            if (num5 == 2 && num6 == 1) {                                            //num5가 2일때//
                if (num2 == num) { //둘이 같은경우
                    System.out.println("둘이 같습니다");
                }
            }


            if (num5 == 2 && num6 == 3) {                                            //num5가 2일때//
                if (num2 > num3) { //2가 3보다 큰경우
                    System.out.println("" + answer2 + "가" + answer3 + "보다 더 큽니다");
                }
            }
            if (num5 == 2 && num6 == 3) {
                if (num2 < num3) { //2가 3보다 작은경우
                    System.out.println("" + answer2 + "가" + answer3 + "보다 더 작습니다");
                }
            }
            if (num5 == 2 && num6 == 3) {
                if (num2 == num3) { //둘이 같은경우
                    System.out.println("둘의 값은 같습니다");
                }
            }

            if (num5 == 2 && num6 == 4) {                                            //num5가 2일때//
                if (num2 > num4) { //2가 4보다 큰경우
                    System.out.println("" + answer2 + "가" + answer4 + "보다 더 큽니다");
                }
            }
            if (num5 == 2 && num6 == 4) {
                if (num2 < num4) { //2가 4보다 작은경우
                    System.out.println("" + answer2 + "가" + answer4 + "보다 더 작습니다");
                }
            }
            if (num5 == 2 && num6 == 4) {
                if (num2 == num4) { //둘이 같은경우
                    System.out.println("둘의 값은 같습니다");
                }
            }

            if (num5 == 3 && num6 == 1) {                                            //num5가 3일때//
                if (num3 > num) { //3이 1보다 큰경우
                    System.out.println("" + answer3 + "가" + answer + "보다 더 큽니다");
                }
            }
            if (num5 == 3 && num6 == 1) {
                if (num3 < num) { //3이 1보다 작은경우
                    System.out.println("" + answer3 + "가" + answer + "보다 더 작습니다");
                }
            }
            if (num5 == 3 && num6 == 1) {
                if (num3 == num) { //둘이 같은경우
                    System.out.println("둘의 값은 같습니다");
                }
            }

            if (num5 == 3 && num6 == 2) {                                            //num5가 3일때//
                if (num3 > num2) { //3이 2보다 큰경우
                    System.out.println("" + answer3 + "가" + answer2 + "보다 더 큽니다");
                }
            }
            if (num5 == 3 && num6 == 2) {
                if (num3 < num2) { //3이 2보다 작은경우
                    System.out.println("" + answer3 + "가" + answer2 + "보다 더 작습니다");
                }
            }
            if (num5 == 3 && num6 == 2) {
                if (num3 == num2) { //둘이 같은경우
                    System.out.println("둘의 값은 같습니다");
                }
            }

            if (num5 == 3 && num6 == 4) {                                            //num5가 3일때//
                if (num3 > num4) { //3이 4보다 큰경우
                    System.out.println("" + answer3 + "가" + answer4 + "보다 더 큽니다");
                }
            }
            if (num5 == 3 && num6 == 4) {
                if (num3 < num4) { //3이 4보다 작은경우
                    System.out.println("" + answer3 + "가" + answer4 + "보다 더 작습니다");
                }
            }
            if (num5 == 3 && num6 == 4) {
                if (num3 == num4) { //둘이 같은경우
                    System.out.println("둘의 값은 같습니다");
                }
            }


            if (num5 == 4 && num6 == 1) {                                            //num5가 4일때//
                if (num4 > num) { //4가 1보다 큰경우
                    System.out.println("" + answer4 + "가" + answer + "보다 더 큽니다");
                }
            }
            if (num5 == 4 && num6 == 1) {
                if (num4 < num) { //4가 1보다 작은경우
                    System.out.println("" + answer4 + "가" + answer + "보다 더 작습니다");
                }
            }
            if (num5 == 4 && num6 == 1) {
                if (num4 == num) { //둘이 같은경우
                    System.out.println("둘의 값은 같습니다");
                }
            }

            if (num5 == 4 && num6 == 2) {                                            //num5가 4일때//
                if (num4 > num2) { //4가 2보다 큰경우
                    System.out.println("" + answer4 + "가" + answer2 + "보다 더 큽니다");
                }
            }
            if (num5 == 4 && num6 == 2) {
                if (num4 < num2) { //4가 1보다 작은경우
                    System.out.println("" + answer4 + "가" + answer2 + "보다 더 작습니다");
                }
            }
            if (num5 == 4 && num6 == 2) {
                if (num4 == num2) { //둘이 같은경우
                    System.out.println("둘의 값은 같습니다");
                }
            }

            if (num5 == 4 && num6 == 3) {                                            //num5가 4일때//
                if (num4 > num3) { //4가 3보다 큰경우
                    System.out.println("" + answer4 + "가" + answer3 + "보다 더 큽니다");
                }
            }
            if (num5 == 4 && num6 == 3) {
                if (num4 < num3) { //4가 3보다 작은경우
                    System.out.println("" + answer4 + "가" + answer3 + "보다 더 작습니다");
                }
            }
            if (num5 == 4 && num6 == 3) {
                if (num4 == num3) { //둘이 같은경우
                    System.out.println("둘의 값은 같습니다");
                }
            }

            if (num5 == 5 && num6 == 1 || num5 == 1 && num6 == 5) {
                System.out.println("잘못된 입력입니다");
            }if (num5 == 5 && num6 == 2 || num5 == 2 && num6 == 5) {
                System.out.println("잘못된 입력입니다");
            }if (num5 == 5 && num6 == 3 || num5 == 3 && num6 == 5) {
                System.out.println("잘못된 입력입니다");
            }if (num5 == 5 && num6 == 4 || num5 == 4 && num6 == 5) {
                System.out.println("잘못된 입력입니다");
            } if (num5 == 1 && num6 == 1) {
                System.out.println("둘의 값이 같습니다");
            } if (num5 == 2 && num6 == 2) {
                System.out.println("둘의 값이 같습니다");
            } if (num5 == 3 && num6 == 3) {
                System.out.println("둘의 값이 같습니다");
            } if (num5 == 4 && num6 == 4) {
                System.out.println("둘의 값이 같습니다");
            }


            if (num5 == 5 && num6 == 5) {
                System.out.println("프로그램을 종료합니다");
                break;
            }
        }
    }
}




    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        }
    }































