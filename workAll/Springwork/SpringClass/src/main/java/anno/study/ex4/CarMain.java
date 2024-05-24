package anno.study.ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-ex4.xml");

        Car car = (Car) applicationContext.getBean("car");
        car.carInfo();
    }
}
