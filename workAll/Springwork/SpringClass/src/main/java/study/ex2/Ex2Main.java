package study.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex2Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-ex2.xml");
        Student student = (Student) applicationContext.getBean("stu");
        student.show();

    }
}
