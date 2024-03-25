package day0325;

public class Student {
    private String name;
    private int java, spring;

    public Student() {
        this("아무개", 70, 90);
    }

    public Student(String name) {
        super();
        this.name = name;
    }

    public Student(int java, int spring) {
        super();
        this.java = java;
        this.spring = spring;
    }

    public Student(String name, int java, int spring) {
        super();
        this.name = name;
        this.java = java;
        this.spring = spring;
    }

    //getter
    public String getName() {
        return name;
    }

    public int getJava() {
        return java;
    }

    public int getSpring() {
        return spring;
    }

    public int getTotal() {
        return java + spring;
    }

    public double getAvg() {
        return (java + spring) / 2.0;
    }

    public String getGrade() {
        if (getAvg() >= 90) {
            return "장학생";
        } else if (getAvg() >= 80) {
            return "우등생";
        } else {
            return "재시험";
        }
    }


    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public void setSpring(int spring) {
        this.spring = spring;
    }

    public void setScore(int java, int spring) {
        this.java = java;
        this.spring = spring;
    }

}
