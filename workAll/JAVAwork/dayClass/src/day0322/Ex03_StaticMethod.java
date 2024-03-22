package day0322;

class MyShop {

    private String sampum;
    private int su, dan;
    private static String message;
    public static final String SHOP = "24시간 이마트";

    public void setDan(int dan) {
        this.dan = dan;
    }

    public void setSu(int su) {
        this.su = su;
    }

    public void setSampum(String sampum) {
        this.sampum = sampum;
    }

    public static void setMessage(String message) {
        MyShop.message = message;
    }

    //상품명, 수령, 단가, 한번에 변경
    public void setDate(String sampum, int su, int dan) {
        this.setDan(dan);
        this.setSu(su);
        this.setSampum(sampum);
    }

//overloading method
    public void setDate(String sampum, int su, int dan,String message) {
        this.setDan(dan);
        this.setSu(su);
        this.setSampum(sampum);
        setMessage(message);
    }

    public void writeDate(){
        System.out.println("상품명 : "+ sampum);
        System.out.println("수량 : "+ su + ", 단가 : "+ dan);
        System.out.println("총 금액 : "+ su * dan);
        System.out.println("오늘의 메세지 : "+ message);
        System.out.println("=".repeat(20));
    }


}

public class Ex03_StaticMethod {
    public static void main(String[] args) {
        MyShop my1 = new MyShop();
        MyShop my2 = new MyShop();
        MyShop my3 = new MyShop();

        System.out.println("상품 1");
        my1.setSampum("딸기");
        my1.setSu(3);
        my1.setDan(2300);
        MyShop.setMessage("과일 세일!");
        my1.writeDate();

        System.out.println("상품 2");
        my2.setDate("수박",3,30000);
        my2.writeDate();

        System.out.println("상품 3");
        my3.setDate("참외",5,2000,"세일 마감!");
        my3.writeDate();

        System.out.println("상품 1 다시");
        my1.writeDate();


        System.out.println("상품 2 수량변경 다시");
        my2.setSu(10);
        my2.writeDate();
    }
}
