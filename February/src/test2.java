public class test2 {
    String BookNumber;
    String BookName;
    String BookWriter;
    String Bookpublisher;
    String Bookyear;
    String BookBorrow;
    String BookBorrowPeople;

    test2 (String BookNumber,String BookName,String BookWriter,String Bookpublisher,String Bookyear,String BookBorrow,String BookBorrowPeople) {
        this.BookNumber = BookNumber;
        this.BookName = BookName;
        this.BookWriter = BookWriter;
        this.Bookpublisher = Bookpublisher;
        this.Bookyear = Bookyear;
        this.BookBorrow = BookBorrow;
        this.BookBorrowPeople = BookBorrowPeople;
    }
    void Information () {
        System.out.println("번호 : "+BookNumber+"\n제목 : "+BookName+"\n글쓴이 : "+BookWriter+" \n출판사 : "+Bookpublisher+"\n출판연도 : "+Bookyear+"\n대여상황 : "+BookBorrow+"\n빌린사람 : "+BookBorrowPeople+"");
    }

    public static class test3 {
        String Name;
        String Membernumber;
        String Dayofbirth;
        String Address;
        String Phonenumber;
        String Borrowbookname;
        String Borrowbooknumber;

        test3 (String Name,String Membernumber,String Dayofbirth,String Address,String Phonenumber,String Borrowbookname,String Borrowbooknumber) {
            this.Name = Name;
            this.Membernumber = Membernumber;
            this.Dayofbirth = Dayofbirth;
            this.Address = Address;
            this.Phonenumber = Phonenumber;
            this.Borrowbookname = Borrowbookname;
            this.Borrowbooknumber = Borrowbooknumber;
        }
        void PersonalInformation () {
            System.out.println("이름 : "+Name+"\n회원번호 : "+Membernumber+"\n생년월일 : "+Dayofbirth+" \n주소 : "+Address+"\n핸드폰번호 : "+Phonenumber+"\n빌린 책 : "+Borrowbookname+"\n빌린 책 개수 : "+Borrowbooknumber+"");
        }
    }
}
