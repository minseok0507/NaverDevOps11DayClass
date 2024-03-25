package day0325;

class Member{
    private String memberName;
    private int memberCount;

    Member(){
        this("동창회",10);

    }

    Member(String memberName, int memberCount){
        this.memberName = memberName;
        this.memberCount = memberCount;
    }

    public void writeMember(){
        System.out.println("모임 이름 : " + memberName);
        System.out.println("모임 정원 : " + memberCount);
    }

}

class SubMember extends Member{
    private String myName;
    private int myAge;
    SubMember(){
        myName = "no";
        myAge = 20;
    }
    SubMember(String memberName, int memberCount, String myName, int myAge){
        super(memberName,memberCount);
        this.myName = myName;
        this.myAge = myAge;
    }

    @Override
    public void writeMember() {
        super.writeMember();
        System.out.println("내 이름 : " + myName);
        System.out.println("내 이름 : " + myAge);
        System.out.println("=".repeat(50));
    }
}

public class Ex07_Inheri {
    public static void main(String[] args) {
        SubMember sm1 = new SubMember();
        sm1.writeMember();

        SubMember sm2 = new SubMember("701",30,"djd",35);
        sm2.writeMember();


    }


}
