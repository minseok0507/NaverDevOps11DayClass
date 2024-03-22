package day0322;

class Stu {
    String name = "이영자";
    String blood = "A";
    int age = 12;
}

public class Ex06_CallByReference {
    public static void changeStu(Stu stu) {
        stu.blood = "O";
        stu.age = 34;
    }

    public static void main(String[] args) {
        Stu s = new Stu();
        System.out.println(s.name + ", " + s.blood + "," + s.age);
        changeStu(s);
        System.out.println(s.name + ", " + s.blood + "," + s.age);
    }
}
