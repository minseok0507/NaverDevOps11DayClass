package study.ex2;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor //final, NoNull 만 생성자 주입
@Setter
public class Student {
    private String schoolName;
    @NonNull
    MyInfo myInfo;

//    public Student(MyInfo myInfo) {
//        this.myInfo = myInfo;
//    }
//
//    public void setSchoolName(String schoolName) {
//        this.schoolName = schoolName;
//    }

    public void show(){
        System.out.println(myInfo);
        System.out.println("School Name: " + schoolName);
    }
}
