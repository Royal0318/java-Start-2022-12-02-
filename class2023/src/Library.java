import java.util.ArrayList;
import java.util.Scanner;
public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Library2> Books = new ArrayList<>();
        String[] memberName = new String[1000];
        int[] memberNumber = new int[1000];
        String[] memberAddress = new String[1000];
        int[][] memberPhoneNumber = new int[1000][2];
        int[][] borrowBookList = new int[1000][1000];
        //배열값을 1000으로 잡아서 총 1000까지 등록이 가능하도록 설정

        //등록전 도서관에 10권을 미리 등록한다
        Library2 book1 = new Library2(1,"세상의 마지막 기차역","무라세 다케시","모모",2022,5,9,0,memberName,memberNumber,memberAddress,memberPhoneNumber,borrowBookList);
        Library2 book2 = new Library2(2,"조금 서툴더라도 네 인생을 응원해","자희독서희","미디어숲",2022,11,20,0,memberName,memberNumber,memberAddress,memberPhoneNumber,borrowBookList);
        Library2 book3 = new Library2(3,"역행자","자청","웅진지식하우스",2022,6,3,0,memberName,memberNumber,memberAddress,memberPhoneNumber,borrowBookList);
        Library2 book4 = new Library2(4,"마흔에 읽는 니체","장재형","유노북스",2022,9,1,0,memberName,memberNumber,memberAddress,memberPhoneNumber,borrowBookList);
        Library2 book5 = new Library2(5,"천원을 경영하라","박정부","쌤엔파커스",2022,12,1,0,memberName,memberNumber,memberAddress,memberPhoneNumber,borrowBookList);
        Library2 book6 = new Library2(6,"하얼빈","김훈","문학동네",2022,8,3,0,memberName,memberNumber,memberAddress,memberPhoneNumber,borrowBookList);
        Library2 book7 = new Library2(7,"불편한편의점2","미등록","미등록",2022,5,4,0,memberName,memberNumber,memberAddress,memberPhoneNumber,borrowBookList);
        Library2 book8 = new Library2(8,"조국의 법고전 산책","조국","오마이북",2022,11,9,0,memberName,memberNumber,memberAddress,memberPhoneNumber,borrowBookList);
        Library2 book9 = new Library2(9,"아버지의 해방일지","정지아","창비",2022,9,2,0,memberName,memberNumber,memberAddress,memberPhoneNumber,borrowBookList);
        Library2 book10 = new Library2(10,"트랜드코리아","김난도","미래의창",2022,10,5,0,memberName,memberNumber,memberAddress,memberPhoneNumber,borrowBookList);
        Books.add(book1);
        Books.add(book2);
        Books.add(book3);
        Books.add(book4);
        Books.add(book5);
        Books.add(book6);
        Books.add(book7);
        Books.add(book8);
        Books.add(book9);
        Books.add(book10);

        Library2 subObject = new Library2();
        //서브 생성자
        book1.getSystemMenu(sc,Books);

    }
}
