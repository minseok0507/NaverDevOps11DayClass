package study.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import study.ex2.Student;

public class Ex3Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-ex3.xml");
        MyCart cart = (MyCart) applicationContext.getBean("cart");
        cart.showInfo();

        MyCart cart2 = (MyCart) applicationContext.getBean("cart2");
        cart2.showInfo();
        MyCart cart3 = (MyCart) applicationContext.getBean("cart2");
        cart2.showInfo();

        System.out.println("singleton cart is: " + cart.hashCode());
        System.out.println("prototype cart is: " + cart2.hashCode());
        System.out.println("prototype cart is: " + cart3.hashCode());
    }
}
