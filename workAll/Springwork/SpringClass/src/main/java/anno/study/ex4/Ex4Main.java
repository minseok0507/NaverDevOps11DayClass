package anno.study.ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Ex4Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-ex4.xml");

        Hello hello = (Hello) applicationContext.getBean("hello");
        hello.showMsg();
    }
}
