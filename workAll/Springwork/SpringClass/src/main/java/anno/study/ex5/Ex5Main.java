package anno.study.ex5;

import anno.study.ex4.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Ex5Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-ex4.xml");

        Emp emp = (Emp) applicationContext.getBean("emp");
        emp.sawonInfo();

    }
}
