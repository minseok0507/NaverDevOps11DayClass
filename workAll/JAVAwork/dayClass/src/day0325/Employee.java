package day0325;

public class Employee {
    private String name, position;
    private int age, gibon, sudang;

    Employee() {
        name = "없음";
        position = "";
        age = 0;
        gibon = 0;
        sudang = 0;

    }

    public Employee(String name, String position, int age) {
        this.name = name;
        this.position = position;
        this.age = age;
        gibon = 0;
        sudang = 0;

    }

    public Employee(String name, int age) {
        this.name = name;
        position = "";
        this.age = age;
        gibon = 0;
        sudang = 0;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    public int getGibon() {
        return gibon;
    }

    public int getSudang() {
        return sudang;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGibon(int gibon) {
        this.gibon = gibon;
    }

    public void setSudang(int sudang) {
        this.sudang = sudang;
    }

    public void setPay(int gibon, int sudang) {
        this.gibon = gibon;
        this.sudang = sudang;
    }

    public void setSawon(String name, String position, int age) {
        this.name = name;
        this.position = position;
        this.age = age;
    }

    public int getNetPay() {
        return gibon + sudang;
    }
}
