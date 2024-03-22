package day0322;

class Student{
    private String name;
    private int kor, eng, tot;
    private double avg;

    Student(){
        this("이름 미정",20,20);

    }
    Student(String name){
        this(name,50,20);
    }

    Student(String name, int kor, int eng){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.tot = kor+eng;
        this.avg = tot/2.0;
    }

    public void write(){
        System.out.printf("이름 : %s\n국어 : %d\n영어 : %d\n총점 : %d\n평균 : %2.1f\n",name,kor,eng,tot,avg);
    }


}
public class Ex09_Constructor {
    public static void main(String[] args) {
        Student st = new Student();
        Student st1 = new Student("옹옹옹");
        Student st2 = new Student("잉이잉",50,10);
        st.write();
        st1.write();
        st2.write();
    }

}
