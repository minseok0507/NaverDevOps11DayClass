package anno.study.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-ex4.xml");
        ShopController shopController = (ShopController) applicationContext.getBean("shopController");
        shopController.insert("청바지",2,30000);
        System.out.println("-".repeat(50));
        shopController.delete("청바지");
        System.out.println("-".repeat(50));
        shopController.update("자켓",1,120000);

    }


}
