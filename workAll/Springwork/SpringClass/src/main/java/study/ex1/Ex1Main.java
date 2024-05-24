package study.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex1Main {
    public static void main(String[] args) {
        System.out.println("기존의 자바 방식으로 호출");
        MessageInter messageInter = null;
        messageInter = new Message1();
        String s = messageInter.sayHello("minseok");
        System.out.println(s);

        messageInter = new Message2();
        s = messageInter.sayHello("민석");
        System.out.println(s);


        System.out.println("\n\n스프링 방식으로 호출");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-ex1.xml");

        MessageInter messageInter1 = (Message1) applicationContext.getBean("mes1");
        s = messageInter1.sayHello("candy");
        System.out.println(s);

        messageInter1 = applicationContext.getBean("mes2", Message2.class);
        s = messageInter1.sayHello("캔티");
        System.out.println(s);

    }
}
