package day0322;

class Member {
    private String name;
    private String hp;
    private String addr;

    //생성자
    Member() {
        this("앙앙앙", "031-1234-1234", "일산");
    }

    Member(String name) {
        this(name, "031-1234-1234", "일산");
    }

    Member(String name, String hp) {
        this(name, hp, "중산");
    }

    Member(String name, String hp, String addr) {
        this.name = name;
        this.hp = hp;
        this.addr = addr;
    }

    //setter

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }
    //getter


    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public String getHp() {
        return hp;
    }

}


public class Ex10_ClassMunje {

    public static void writeMember(Member m) {
        System.out.printf("이름 : %s\t휴대폰 : %s\t주소 : %s\n", m.getName(), m.getHp(), m.getAddr());
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Member m1 = new Member();
        Member m2 = new Member("이강인");
        Member m3 = new Member("손흥민", "010-2222-3333");
        Member m4 = new Member("Candy", "010-4444-5555", "제주도");

        System.out.println("** 멤버 명단 출력 **");
        writeMember(m1);
        writeMember(m2);
        writeMember(m3);
        writeMember(m4);

        System.out.println("멥버의 값 변경");
        m1.setName("이영자");
        m1.setHp("010-2323-7676");
        m1.setAddr("부산");
        writeMember(m1);
    }
}