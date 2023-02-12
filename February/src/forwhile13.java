/*
[문제 출제1: 이름은 입력할 수 있게 할 것.]
	[문제 출제2: 각각의 이름에 점수를 입력받을 수 있게 할 것.] -> 영희의 점수 :
	[문제 출제3: 예시) 1번을 누르면 규민, 2번을 누르면 민영을 선택할 수 있게 하고, 그 둘의 점수를 각각 비교하게 할 것.]
	[문제 출제3: 입력받은 점수를 토대로 점수를 각각 비교하여, 규민이 크면 규민이 큽니다. 라는 문장이 뜨게 할 것.]
	규민과 민영과 철수와 영희가 있다.
	규민은 점수를 ?를 받았고,
	민영은 점수를 ?를 받았고,
	철수는 점수를 ?를 받았고,
	영희는 점수를 ?를 받았다.
	다음 중 누구와 비교해도 누가 누구보다 큰 점수를 받았는지 쓸 수 있도록 해보아라.
	예)
	첫 번째 사람 이름 : 경민
	경민이 받은 점수 입력 : 100
	두 번째 사람 이름 : 홍길동
	홍길동이 받은 점수 입력 : 90
	세 번째 사람 이름 : 철수
	철수가 받은 점수 입력 : 80
	네 번째 사람 이름 : 영희
	영희가 받은 점수 입력 : 70
	1.경민
	2.홍길동
	3.철수
	4.영희
	5.종료
	누구와 누구를 대조하시겠습니까?
	첫 번째 사람 입력 : 1
	두 번째 사람 입력 : 3
	시스템 : 경민의 점수가 철수의 점수보다 더 큽니다!
	1.경민
	2.홍길동
	3.철수
	4.영희
	5. 종료.
	누구와 누구를 대조하시겠습니까?
	첫 번째 사람 입력 : 3
	두 번째 사람 입력 : 1
	시스템 : 경민의 점수가 철수의 점수보다 더 큽니다!
	종료는
	첫 번째 사람 입력 : 5
	두 번째 사람 입력 : 5
	처럼 둘 다 5번을 누른 경우 나타난다.
	만약, 둘 중 하나라도 5번이 아니라면
	잘못된 입력입니다! 라는 말이 나타나야 한다.
 */
import java.util.Scanner;
public class forwhile13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("4명의 이름을 각각 입력해주세요");
        String Name = sc.next();
        String Name2 = sc.next();
        String Name3 = sc.next();
        String Name4 = sc.next();
        System.out.println(""+Name+"의 점수를 입력해주세요");
        int Namescore = sc.nextInt();
        System.out.println(""+Name2+"의 점수를 입력해주세요");
        int Name2score = sc.nextInt();
        System.out.println(""+Name3+"의 점수를 입력해주세요");
        int Name3score = sc.nextInt();
        System.out.println(""+Name4+"의 점수를 입력해주세요");
        int Name4score = sc.nextInt();

        System.out.println("1."+Name+" 점수 : "+Namescore+" \n2."+Name2+"점수 : "+Name2score+" \n3."+Name3+" 점수 : "+Name3score+" \n4."+Name4+" 점수 : "+Name4score+" \n비교 할 2명의 번호를 적어주세요\n");
        while (true) {
            System.out.println("1."+Name+" \n2."+Name2+" \n3."+Name3+" \n4."+Name4+" \n5.시스템 종료 \n안내 : 시스템종료는 두 숫자를 모두 5를 입력해야합니다");
            int Select = sc.nextInt();
            int Select2 = sc.nextInt();

            if (Select == 5 && Select2 == 5) {
                System.out.println("시스템을 종료합니다");
                break;
            }
            if (Select == Select2) {
                System.out.println("같은 번호는 대조할 수 없습니다");
            }
            if (Select < 1 || Select > 4 || Select2 < 1 || Select2 > 4) {
                System.out.println("잘못된 입력입니다");
            }

            //Select1가 다른번호랑 대조할경우
            if (Select == 1 && Select2 == 2) {
                if (Namescore > Name2score) {
                    System.out.println(""+Name+"의 점수가 "+Name2+"점수보다 더 큽니다!");
                } else if (Namescore < Name2score) {
                    System.out.println(""+Name2+"의 점수가 "+Name+"점수보다 더 큽니다!");
                }
            } else if (Select == 1 && Select2 == 3) {
                if (Namescore > Name3score) {
                    System.out.println(""+Name+"의 점수가 "+Name3+"점수보다 더 큽니다!");
                } else if (Namescore < Name3score) {
                    System.out.println(""+Name3+"의 점수가 "+Name+"점수보다 더 큽니다!");
                }
            } else if (Select == 1 && Select2 == 4) {
                if (Namescore > Name4score) {
                    System.out.println(""+Name+"의 점수가 "+Name4+"점수보다 더 큽니다!");
                } else if (Namescore < Name4score) {
                    System.out.println(""+Name4+"의 점수가 "+Name+"점수보다 더 큽니다!");
                }
            }
            //Select2가 다른번호랑 대조할경우
            if (Select == 2 && Select2 == 1) {
                if (Name2score > Namescore) {
                    System.out.println(""+Name2+"의 점수가 "+Name+"점수보다 더 큽니다!");
                } else if (Name2score < Namescore) {
                    System.out.println(""+Name+"의 점수가 "+Name2+"점수보다 더 큽니다!");
                }
            } else if (Select == 2 && Select2 == 3) {
                if (Name2score > Name3score) {
                    System.out.println(""+Name2+"의 점수가 "+Name3+"점수보다 더 큽니다!");
                } else if (Name2score < Name3score) {
                    System.out.println(""+Name3+"의 점수가 "+Name2+"점수보다 더 큽니다!");
                }
            } else if (Select == 2 && Select2 == 4) {
                if (Name2score > Name4score) {
                    System.out.println(""+Name2+"의 점수가 "+Name4+"점수보다 더 큽니다!");
                } else if (Namescore < Name4score) {
                    System.out.println(""+Name4+"의 점수가 "+Name2+"점수보다 더 큽니다!");
                }
            }
            //Select3가 다른번호랑 대조할경우
            if (Select == 3 && Select2 == 1) {
                if (Name3score > Namescore) {
                    System.out.println(""+Name3+"의 점수가 "+Name+"점수보다 더 큽니다!");
                } else if (Name3score < Namescore) {
                    System.out.println(""+Name+"의 점수가 "+Name3+"점수보다 더 큽니다!");
                }
            } else if (Select == 3 && Select2 == 2) {
                if (Name3score > Name2score) {
                    System.out.println(""+Name3+"의 점수가 "+Name2+"점수보다 더 큽니다!");
                } else if (Name3score < Name2score) {
                    System.out.println(""+Name2+"의 점수가 "+Name3+"점수보다 더 큽니다!");
                }
            } else if (Select == 3 && Select2 == 4) {
                if (Name3score > Name4score) {
                    System.out.println(""+Name3+"의 점수가 "+Name4+"점수보다 더 큽니다!");
                } else if (Name3score < Name4score) {
                    System.out.println(""+Name4+"의 점수가 "+Name3+"점수보다 더 큽니다!");
                }
            }
            //Select4가 다른번호랑 대조할경우
            if (Select == 4 && Select2 == 1) {
                if (Name4score > Namescore) {
                    System.out.println(""+Name4+"의 점수가 "+Name+"점수보다 더 큽니다!");
                } else if (Name4score < Namescore) {
                    System.out.println(""+Name+"의 점수가 "+Name4+"점수보다 더 큽니다!");
                }
            } else if (Select == 4 && Select2 == 2) {
                if (Name4score > Name2score) {
                    System.out.println(""+Name4+"의 점수가 "+Name2+"점수보다 더 큽니다!");
                } else if (Name4score < Name2score) {
                    System.out.println(""+Name2+"의 점수가 "+Name4+"점수보다 더 큽니다!");
                }
            } else if (Select == 4 && Select2 == 3) {
                if (Name4score > Name3score) {
                    System.out.println(""+Name4+"의 점수가 "+Name3+"점수보다 더 큽니다!");
                } else if (Name4score < Name3score) {
                    System.out.println(""+Name3+"의 점수가 "+Name4+"점수보다 더 큽니다!");
                }
            }
        }
    }
}
