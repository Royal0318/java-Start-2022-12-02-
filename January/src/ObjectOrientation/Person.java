package ObjectOrientation;

public class Person {
    String Name;
    String Age;
    String Tall;
    String weight;
    String Familymembers;
    String Sex;
    String Jop;
    String Dream;
    String Residence;
    String Hometown;
    String Graduation;
    String Goals;


    Person(String Name, String Age, String Tall, String weight, String Familymembers, String Sex, String Job, String Dream, String Residence, String Hometown,String Graduation,String Goals) {
        this.Name = Name;
        this.Age = Age;
        this.Tall = Tall;
        this.weight = weight;
        this.Familymembers = Familymembers;
        this.Sex = Sex;
        this.Jop = Job;
        this.Dream = Dream;
        this.Residence = Residence;
        this.Hometown = Hometown;
        this.Graduation = Graduation;
        this.Goals = Goals;
    }
    void introduceMySelf(){
        System.out.println("==================자기소개 프로필==================");
        System.out.println("이름 : "+Name+" \n나이 : "+Age+"\n키 : "+Tall+"\n몸무게 : "+weight+"\n가족인원수 : "+Familymembers+"\n성별 : "+Sex+"\n직업 : "+Jop+"\n꿈 : "+Dream+"\n현재 거주지 : "+Residence+"\n고향 : "+Hometown+"\n취미 : "+Hobby()+"\n쉬는날에 하는것 : "+Breaktime()+" "+Breaktime2()+" "+Breaktime3()+"\n취업 목표 : "+Goals+"\n최종학력 : "+Graduation+"\n미래의 소원 : "+Hope()+"");
        System.out.println("================================================");
    }
    void Fighting() {
        System.out.println("열심히해서 꼭 취직하겠습니다 화이팅!");
    }
    String Hobby () {
        return "프로그래밍,외국드라마감상";
    }
    String Breaktime () {
        return "누워있기";
    }
    String Breaktime2 () {
        return "유튜브보기";
    }
    String Breaktime3 () {
        return "잠자기";
    }
    String Hope () {
        return "외국기업에 가서 일해보기";
    }
    /*
    1.String return이랑 위에 this랑 차이점이뭔가?
     */
}
